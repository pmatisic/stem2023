import React from "react";
import { Table } from "antd";
import { Sample } from "../validators/expected_json";

const { Column, ColumnGroup } = Table;

interface TableSamplesProps {
  data: Sample[];
}

const TableSamples: React.FC<TableSamplesProps> = ({ data }) => {
  console.log(data);
  return (
    <Table dataSource={data}>
      <ColumnGroup title="Samples">
        <Column title="Id" dataIndex="id" key="id" />
        <Column title="Family name" dataIndex="FamilyName" key="familyName" />
        <Column
          title="Product name"
          dataIndex="ProductName"
          key="productName"
        />
        <Column title="Name" dataIndex="Name" key="name" />
      </ColumnGroup>
    </Table>
  );
};

export default TableSamples;
