package ptm.my.ukm.ukmasetbersepadu.model;

/**
 * Created by fird on 14/09/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User implements Parcelable {

    @Expose
    public String id;
    @Expose
    public String ukmper;
    @Expose
    public String nama;
    @Expose
    public String ptj;
    @Expose
    public String nokp;
    @Expose
    public String emel;
    @SerializedName("kod_jaw_hakiki")
    @Expose
    public String kodJawHakiki;
    @SerializedName("nama_jaw_hakiki")
    @Expose
    public String namaJawHakiki;
    @SerializedName("kod_jab_hakiki")
    @Expose
    public String kodJabHakiki;
    @SerializedName("nama_jab_hakiki")
    @Expose
    public String namaJabHakiki;
    @SerializedName("kod_jab_tugas")
    @Expose
    public String kodJabTugas;
    @SerializedName("nama_jab_tugas")
    @Expose
    public String namaJabTugas;
    @SerializedName("status_ukm")
    @Expose
    public String statusUkm;
    @SerializedName("kod_status_ukm")
    @Expose
    public String kodStatusUkm;
    @SerializedName("tkh_mula_ukm")
    @Expose
    public String tkhMulaUkm;
    @SerializedName("tkh_tamat")
    @Expose
    public String tkhTamat;
    @SerializedName("nama_fak_tugas")
    @Expose
    public String namaFakTugas;
    @SerializedName("kod_fak_tugas")
    @Expose
    public String kodFakTugas;
    @SerializedName("nama_fak_hakiki")
    @Expose
    public String namaFakHakiki;
    @SerializedName("kod_fak_hakiki")
    @Expose
    public String kodFakHakiki;
    @SerializedName("kod_fak_hakiki_smp")
    @Expose
    public String kodFakHakikiSmp;
    @SerializedName("kump_jaw_hakiki")
    @Expose
    public String kumpJawHakiki;
    @SerializedName("kod_jaw_tadbir")
    @Expose
    public String kodJawTadbir;
    @Expose
    public String error;
    @SerializedName("error_code")
    @Expose
    public String errorCode;
    @SerializedName("error_msg")
    @Expose
    public String errorMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUkmper() {
        return ukmper;
    }

    public void setUkmper(String ukmper) {
        this.ukmper = ukmper;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPtj() {
        return ptj;
    }

    public void setPtj(String ptj) {
        this.ptj = ptj;
    }

    public String getNokp() {
        return nokp;
    }

    public void setNokp(String nokp) {
        this.nokp = nokp;
    }

    public String getEmel() {
        return emel;
    }

    public void setEmel(String emel) {
        this.emel = emel;
    }

    public String getKodJawHakiki() {
        return kodJawHakiki;
    }

    public void setKodJawHakiki(String kodJawHakiki) {
        this.kodJawHakiki = kodJawHakiki;
    }

    public String getNamaJawHakiki() {
        return namaJawHakiki;
    }

    public void setNamaJawHakiki(String namaJawHakiki) {
        this.namaJawHakiki = namaJawHakiki;
    }

    public String getKodJabHakiki() {
        return kodJabHakiki;
    }

    public void setKodJabHakiki(String kodJabHakiki) {
        this.kodJabHakiki = kodJabHakiki;
    }

    public String getNamaJabHakiki() {
        return namaJabHakiki;
    }

    public void setNamaJabHakiki(String namaJabHakiki) {
        this.namaJabHakiki = namaJabHakiki;
    }

    public String getKodJabTugas() {
        return kodJabTugas;
    }

    public void setKodJabTugas(String kodJabTugas) {
        this.kodJabTugas = kodJabTugas;
    }

    public String getNamaJabTugas() {
        return namaJabTugas;
    }

    public void setNamaJabTugas(String namaJabTugas) {
        this.namaJabTugas = namaJabTugas;
    }

    public String getStatusUkm() {
        return statusUkm;
    }

    public void setStatusUkm(String statusUkm) {
        this.statusUkm = statusUkm;
    }

    public String getKodStatusUkm() {
        return kodStatusUkm;
    }

    public void setKodStatusUkm(String kodStatusUkm) {
        this.kodStatusUkm = kodStatusUkm;
    }

    public String getTkhMulaUkm() {
        return tkhMulaUkm;
    }

    public void setTkhMulaUkm(String tkhMulaUkm) {
        this.tkhMulaUkm = tkhMulaUkm;
    }

    public String getTkhTamat() {
        return tkhTamat;
    }

    public void setTkhTamat(String tkhTamat) {
        this.tkhTamat = tkhTamat;
    }

    public String getNamaFakTugas() {
        return namaFakTugas;
    }

    public void setNamaFakTugas(String namaFakTugas) {
        this.namaFakTugas = namaFakTugas;
    }

    public String getKodFakTugas() {
        return kodFakTugas;
    }

    public void setKodFakTugas(String kodFakTugas) {
        this.kodFakTugas = kodFakTugas;
    }

    public String getNamaFakHakiki() {
        return namaFakHakiki;
    }

    public void setNamaFakHakiki(String namaFakHakiki) {
        this.namaFakHakiki = namaFakHakiki;
    }

    public String getKodFakHakiki() {
        return kodFakHakiki;
    }

    public void setKodFakHakiki(String kodFakHakiki) {
        this.kodFakHakiki = kodFakHakiki;
    }

    public String getKodFakHakikiSmp() {
        return kodFakHakikiSmp;
    }

    public void setKodFakHakikiSmp(String kodFakHakikiSmp) {
        this.kodFakHakikiSmp = kodFakHakikiSmp;
    }

    public String getKumpJawHakiki() {
        return kumpJawHakiki;
    }

    public void setKumpJawHakiki(String kumpJawHakiki) {
        this.kumpJawHakiki = kumpJawHakiki;
    }

    public String getKodJawTadbir() {
        return kodJawTadbir;
    }

    public void setKodJawTadbir(String kodJawTadbir) {
        this.kodJawTadbir = kodJawTadbir;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.ukmper);
        dest.writeString(this.nama);
        dest.writeString(this.ptj);
        dest.writeString(this.nokp);
        dest.writeString(this.emel);
        dest.writeString(this.kodJawHakiki);
        dest.writeString(this.namaJawHakiki);
        dest.writeString(this.kodJabHakiki);
        dest.writeString(this.namaJabHakiki);
        dest.writeString(this.kodJabTugas);
        dest.writeString(this.namaJabTugas);
        dest.writeString(this.statusUkm);
        dest.writeString(this.kodStatusUkm);
        dest.writeString(this.tkhMulaUkm);
        dest.writeString(this.tkhTamat);
        dest.writeString(this.namaFakTugas);
        dest.writeString(this.kodFakTugas);
        dest.writeString(this.namaFakHakiki);
        dest.writeString(this.kodFakHakiki);
        dest.writeString(this.kodFakHakikiSmp);
        dest.writeString(this.kumpJawHakiki);
        dest.writeString(this.kodJawTadbir);
        dest.writeString(this.error);
        dest.writeString(this.errorCode);
        dest.writeString(this.errorMsg);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.ukmper = in.readString();
        this.nama = in.readString();
        this.ptj = in.readString();
        this.nokp = in.readString();
        this.emel = in.readString();
        this.kodJawHakiki = in.readString();
        this.namaJawHakiki = in.readString();
        this.kodJabHakiki = in.readString();
        this.namaJabHakiki = in.readString();
        this.kodJabTugas = in.readString();
        this.namaJabTugas = in.readString();
        this.statusUkm = in.readString();
        this.kodStatusUkm = in.readString();
        this.tkhMulaUkm = in.readString();
        this.tkhTamat = in.readString();
        this.namaFakTugas = in.readString();
        this.kodFakTugas = in.readString();
        this.namaFakHakiki = in.readString();
        this.kodFakHakiki = in.readString();
        this.kodFakHakikiSmp = in.readString();
        this.kumpJawHakiki = in.readString();
        this.kodJawTadbir = in.readString();
        this.error = in.readString();
        this.errorCode = in.readString();
        this.errorMsg = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public String getGambarUrl(){
        return "http://gambar.ukm.my/GambarKT/"+ukmper.trim()+".jpg";
    }
}