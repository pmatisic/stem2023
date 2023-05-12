import "./App.css";
import { InboxOutlined } from "@ant-design/icons";
import type { UploadProps } from "antd";
import { message, Upload } from "antd";
import { JSONData } from "./validators/expected_json";
import { useState } from "react";
import TableTestPointCollections from "./components/TableTestPointCollections";

const { Dragger } = Upload;

function App() {
  const [jsonData, setJsonData] = useState<JSONData | null>(null);

  const props: UploadProps = {
    name: "file",
    action: "https://localhost:8080/",
    accept: ".json",
    maxCount: 1,
    beforeUpload(file) {
      //convert retrieved file to text and read it
      const reader = new FileReader();

      reader.readAsText(file);
      reader.onload = () => {
        try {
          //check if file is json
          const json: JSONData = JSON.parse(reader.result as string);
          setJsonData(json);
          console.log("Projects", json.Project);
          console.log("TestPoints", json.TestPointCollections);
        } catch (err) {
          console.log(err);
          message.error("File is not a JSON file");
          return false;
        }
      };

      return false; //PREVENTS UPLOAD
    },
    onChange(info) {
      const { status } = info.file;
      if (status !== "uploading") {
        console.log(info.file, info.fileList);
      }
      if (status === "done") {
        message.success(`${info.file.name} file uploaded successfully.`);
      } else if (status === "error") {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
    onDrop(e) {
      console.log("Dropped files", e.dataTransfer.files);
    },
  };

  return (
    <>
      <Dragger {...props}>
        <p className="ant-upload-drag-icon">
          <InboxOutlined />
        </p>
        <p className="ant-upload-text">
          Click or drag file to this area to upload
        </p>
        <p className="ant-upload-hint">
          Support for a single or bulk upload. Strictly prohibited from
          uploading company data or other banned files.
        </p>
      </Dragger>
      {jsonData && <TableTestPointCollections data={jsonData} />}
    </>
  );
}

export default App;
