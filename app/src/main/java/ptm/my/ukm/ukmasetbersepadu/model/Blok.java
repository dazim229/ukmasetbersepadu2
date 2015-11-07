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
public class Blok implements Parcelable {

    @SerializedName("id_bangunn")
    @Expose
    private String idBangunan;

    @SerializedName("nm_bangunn")
    @Expose
    private String nmBangunan;

    @SerializedName("id_lokasi")
    @Expose
    private String idLokasi;

    @SerializedName("s_tatus")
    @Expose
    private String status;

    @SerializedName("id_kemas")
    @Expose
    private String idKemas;

    @SerializedName("tkh_kemas")
    @Expose
    private String tkhKemas;



    public String getIdBangunan() { return idBangunan; }
    public void setIdBangunan(String idBangunan) { this.idBangunan = idBangunan; }

    public String getNmBangunan() { return nmBangunan;  }
    public void setNmBangunan(String nmBangunan) { this.nmBangunan = nmBangunan; }

    public String getIdLokasi() { return idLokasi; }
    public void setIdLokasi(String idLokasi) { this.idLokasi = idLokasi;  }

    public String getStatus() { return status;  }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdKemas() {  return idKemas;  }
    public void setIdKemas(String idKemas) {
        this.idKemas = idKemas;
    }

    public String getTkhKemas() { return tkhKemas;  }
    public void setTkhKemas(String tkhKemas) {
        this.tkhKemas = tkhKemas;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idBangunan);
        dest.writeString(this.nmBangunan);
        dest.writeString(this.idLokasi);
        dest.writeString(this.status);
        dest.writeString(this.idKemas);
        dest.writeString(this.tkhKemas);

    }

    public Blok() {
    }

    protected Blok(Parcel in) {
        this.idBangunan = in.readString();
        this.nmBangunan = in.readString();
        this.idLokasi = in.readString();
        this.status = in.readString();
        this.idKemas = in.readString();
        this.tkhKemas = in.readString();

    }

    public static final Creator<Blok> CREATOR = new Creator<Blok>() {
        public Blok createFromParcel(Parcel source) {
            return new Blok(source);
        }

        public Blok[] newArray(int size) {
            return new Blok[size];
        }
    };
}
