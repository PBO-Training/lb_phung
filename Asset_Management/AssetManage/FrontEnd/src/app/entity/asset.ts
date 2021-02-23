export interface Asset {
  assetId: number;
  assetCode: string;
  assetName: string;
  assetPrice: string;
  assetDayExp: Date;
  used: number;
  doNotUse: number;

  assetType: Object;
}
