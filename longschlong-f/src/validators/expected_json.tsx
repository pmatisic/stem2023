interface TestPoint {
  Value: number;
  Unit: string;
}

export interface Sample {
  FamilyName: string;
  ProductName: string;
  Name: string;
  Id: number;
}

interface InputCondition {
  Parameter: string;
  Min: number;
  Typical: number;
  Max: number;
  TimeBetweenPoints: number;
  Id: number;
}

interface Project {
  Name: string;
  Samples: Sample[];
  InputConditions: InputCondition[];
  Id: number;
}

export interface TestPointCollection {
  InputConditionId: number;
  SampleIds: number[];
  TestPoints: TestPoint[];
  Id: number;
}

export interface JSONData {
  Project: Project;
  TestPointCollections: TestPointCollection[];
}
