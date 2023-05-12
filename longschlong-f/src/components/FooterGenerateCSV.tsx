import { DownloadOutlined } from "@ant-design/icons";
import { Button, Form, Input, Select } from "antd";
import { JSONData } from "../validators/expected_json";

const { Option } = Select;

const tailLayout = {
  wrapperCol: { offset: 8, span: 16 },
};

const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 16 },
};

interface TableTestPointCollectionsProps {
  data: JSONData;
}

const FooterGenerateCSV: React.FC<TableTestPointCollectionsProps> = ({
  data,
}) => {
  const [form] = Form.useForm();

  const downloadCSV = (values: { samples: number[] }) => {
    console.log(values);
    values.samples.forEach((sampleId) => {
      console.log(sampleId);
      const sampleColumns = data.TestPointCollections.filter((testPoint) =>
        testPoint.SampleIds.includes(sampleId)
      );
      const inputConditionIds = sampleColumns.map(
        (testPoint) => testPoint.InputConditionId
      );

      const testPointValues = sampleColumns.map((testPoint) => {
        const testPointValues = testPoint.TestPoints.map(
          (testPoint) => testPoint.Value
        );
        return testPointValues;
      });

      const inputConditionNames = data.Project.InputConditions.filter(
        (inputCondition) => inputConditionIds.includes(inputCondition.Id)
      ).map((inputCondition) => inputCondition.Parameter);
      console.log(inputConditionNames);
      console.log(testPointValues);
    });
  };

  return (
    <Form
      {...layout}
      form={form}
      name="control-hooks"
      onFinish={downloadCSV}
      style={{ maxWidth: 600 }}
    >
      <Form.Item name="samples" label="Samples" rules={[{ required: true }]}>
        <Select
          placeholder="Select what samples to include"
          allowClear
          mode="multiple"
        >
          {data.Project.Samples.map(({ Id, Name, ProductName }) => (
            <Option key={Id} value={Id}>
              {Name} ({ProductName})
            </Option>
          ))}
        </Select>
      </Form.Item>
      <Form.Item
        noStyle
        shouldUpdate={(prevValues, currentValues) =>
          prevValues.gender !== currentValues.gender
        }
      >
        {({ getFieldValue }) =>
          getFieldValue("gender") === "other" ? (
            <Form.Item
              name="selectSamples"
              label="Samples:"
              rules={[{ required: true }]}
            >
              <Input />
            </Form.Item>
          ) : null
        }
      </Form.Item>
      <Form.Item {...tailLayout}>
        <Button type="primary" htmlType="submit">
          Generate CSV <DownloadOutlined />
        </Button>
      </Form.Item>
    </Form>
  );
};

export default FooterGenerateCSV;
