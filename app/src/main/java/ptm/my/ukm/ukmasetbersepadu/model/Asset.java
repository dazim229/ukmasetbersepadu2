package ptm.my.ukm.ukmasetbersepadu.model;

/**
 * Created by fird on 15/09/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Asset implements Parcelable {

    @SerializedName("asset_code")
    @Expose
    private String assetCode;
    @SerializedName("item_code")
    @Expose
    private String itemCode;
    @SerializedName("grn_no")
    @Expose
    private String grnNo;
    @SerializedName("order_no")
    @Expose
    private String orderNo;
    @Expose
    private String status;
    @Expose
    private String description;
    @SerializedName("tag_status")
    @Expose
    private String tagStatus;
    @Expose
    private String type;
    @SerializedName("recieve_date")
    @Expose
    private String recieveDate;
    @SerializedName("source_kod_proses")
    @Expose
    private String sourceKodProses;
    @SerializedName("nett_value")
    @Expose
    private String nettValue;
    @SerializedName("costcrt_desc")
    @Expose
    private String costcrtDesc;
    @SerializedName("department_code")
    @Expose
    private String departmentCode;
    @Expose
    private String category;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(String tagStatus) {
        this.tagStatus = tagStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(String recieveDate) {
        this.recieveDate = recieveDate;
    }

    public String getSourceKodProses() {
        return sourceKodProses;
    }

    public void setSourceKodProses(String sourceKodProses) {
        this.sourceKodProses = sourceKodProses;
    }

    public String getNettValue() {
        return nettValue;
    }

    public void setNettValue(String nettValue) {
        this.nettValue = nettValue;
    }

    public String getCostcrtDesc() {
        return costcrtDesc;
    }

    public void setCostcrtDesc(String costcrtDesc) {
        this.costcrtDesc = costcrtDesc;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.assetCode);
        dest.writeString(this.itemCode);
        dest.writeString(this.grnNo);
        dest.writeString(this.orderNo);
        dest.writeString(this.status);
        dest.writeString(this.description);
        dest.writeString(this.tagStatus);
        dest.writeString(this.type);
        dest.writeString(this.recieveDate);
        dest.writeString(this.sourceKodProses);
        dest.writeString(this.nettValue);
        dest.writeString(this.costcrtDesc);
        dest.writeString(this.departmentCode);
        dest.writeString(this.category);
    }

    public Asset() {
    }

    protected Asset(Parcel in) {
        this.assetCode = in.readString();
        this.itemCode = in.readString();
        this.grnNo = in.readString();
        this.orderNo = in.readString();
        this.status = in.readString();
        this.description = in.readString();
        this.tagStatus = in.readString();
        this.type = in.readString();
        this.recieveDate = in.readString();
        this.sourceKodProses = in.readString();
        this.nettValue = in.readString();
        this.costcrtDesc = in.readString();
        this.departmentCode = in.readString();
        this.category = in.readString();
    }

    public static final Creator<Asset> CREATOR = new Creator<Asset>() {
        public Asset createFromParcel(Parcel source) {
            return new Asset(source);
        }

        public Asset[] newArray(int size) {
            return new Asset[size];
        }
    };
}
