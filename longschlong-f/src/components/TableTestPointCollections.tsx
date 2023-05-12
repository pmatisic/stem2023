import React from "react";
import { Table, Tag } from "antd";
import { JSONData } from "../validators/expected_json";

const { Column, ColumnGroup } = Table;

interface TableTestPointCollectionsProps {
  data: JSONData;
}

const TableTestPointCollections: React.FC<TableTestPointCollectionsProps> = ({
  data,
}) => {
  console.log(data);
  return (
    <Table dataSource={data.TestPointCollections}>
      <ColumnGroup title="Tast point collections">
        <Column title="Id" dataIndex="Id" key="id" />
        <Column
          title="Input condition"
          dataIndex="InputConditionId"
          key="inputCondition"
          render={(inputConditionId: number) => (
            <>
              {data.Project.InputConditions.map(({ Id, Parameter }) => {
                if (Id === inputConditionId) {
                  return (
                    <div color="blue" key={Id}>
                      {Parameter}
                    </div>
                  );
                }
              })}
            </>
          )}
        />
        <Column
          title="Sample"
          dataIndex="SampleIds"
          key="sample"
          render={(sampleIds: number[]) => (
            <>
              {data.Project.Samples.map(({ Id, Name, ProductName }) => {
                if (sampleIds.includes(Id)) {
                  return (
                    <div color="blue" key={Id}>
                      {Name} ({ProductName})
                    </div>
                  );
                }
              })}
            </>
          )}
        />
        <Column
          title="Test Points"
          dataIndex="TestPoints"
          key="testPoints"
          render={(testPoints: { Value: number; Unit: string }[]) => (
            <div>
              {testPoints.map(({ Value }) => (
                <Tag color="blue" key={Value}>
                  {Value}
                </Tag>
              ))}
            </div>
          )}
        />
      </ColumnGroup>
    </Table>
  );
};

export default TableTestPointCollections;
