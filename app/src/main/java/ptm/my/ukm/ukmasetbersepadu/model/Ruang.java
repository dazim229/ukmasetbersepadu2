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
public class Ruang implements Parcelable {

    //-----------------------------------------------Bangunan = ba------------------------------------------//

    @SerializedName("id_bangunn_ba")
    @Expose
    private String idBangunan_ba;

    @SerializedName("nm_bangunn_ba")
    @Expose
    private String nmBangunan_ba;

    @SerializedName("id_lokasi_ba")
    @Expose
    private String idLokasi_ba;

    @SerializedName("s_tatus_ba")
    @Expose
    private String status_ba;

    @SerializedName("id_kemas_ba")
    @Expose
    private String idKemas_ba;

    @SerializedName("tkh_kemas_ba")
    @Expose
    private String tkhKemas_ba;




    public String getIdBangunan_ba() { return idBangunan_ba; }
    public void setIdBangunan_ba(String idBangunan_ba) { this.idBangunan_ba = idBangunan_ba; }

    public String getNmBangunan_ba() { return nmBangunan_ba;  }
    public void setNmBangunan_ba(String nmBangunan_ba) { this.nmBangunan_ba = nmBangunan_ba; }

    public String getIdLokasi_ba() { return idLokasi_ba; }
    public void setIdLokasi_ba(String idLokasi_ba) { this.idLokasi_ba = idLokasi_ba;  }

    public String getStatus_ba() { return status_ba;  }
    public void setStatus_ba(String status_ba) {
        this.status_ba = status_ba;
    }

    public String getIdKemas_ba() {  return idKemas_ba;  }
    public void setIdKemas_ba(String idKemas_ba) {
        this.idKemas_ba = idKemas_ba;
    }

    public String getTkhKemas_ba() { return tkhKemas_ba;  }
    public void setTkhKemas_ba(String tkhKemas_ba) {
        this.tkhKemas_ba = tkhKemas_ba;
    }


    //-------------------------------------------Bangunan = ba------------------------------------------//



    //-----------------------------------------------Blok = bl------------------------------------------//

    @SerializedName("id_blok_bl")
    @Expose
    private String idBlok_bl;

    @SerializedName("nm_blok_bl")
    @Expose
    private String nmBlok_bl;

    @SerializedName("id_lokasi_bl")
    @Expose
    private String idLokasi_bl;

    @SerializedName("id_bangunn_bl")
    @Expose
    private String idBangunn_bl;

    @SerializedName("a_ras_bl")
    @Expose
    private String aras_bl;

    @SerializedName("s_tatus_bl")
    @Expose
    private String status_bl;

    @SerializedName("id_kemas_bl")
    @Expose
    private String idKemas_bl;

    @SerializedName("tkh_kemas_bl")
    @Expose
    private String tkhKemas_bl;




    public String getIdBlok_bl() { return idBlok_bl; }
    public void setIdBlok_bl(String idBlok_bl) { this.idBlok_bl = idBlok_bl; }

    public String getNmBlok_bl() { return nmBlok_bl;  }
    public void setNmBlok_bl(String nmBlok_bl) { this.nmBlok_bl = nmBlok_bl; }

    public String getIdLokasi_bl() { return idLokasi_bl; }
    public void setIdLokasi_bl(String idLokasi_bl) { this.idLokasi_bl = idLokasi_bl;  }

    public String getIdBangunn_bl() { return idBangunn_bl;  }
    public void setIdBangunn_bl(String idBangunn_bl) {   this.idBangunn_bl = idBangunn_bl;  }

    public String getAras_bl() {  return aras_bl;  }
    public void setAras_bl(String aras_bl) {  this.aras_bl = aras_bl; }

    public String getStatus_bl() { return status_bl;  }
    public void setStatus_bl(String status_bl) {
        this.status_bl = status_bl;
    }

    public String getIdKemas_bl() {  return idKemas_bl;  }
    public void setIdKemas_bl(String idKemas_bl) {
        this.idKemas_bl = idKemas_bl;
    }

    public String getTkhKemas_bl() { return tkhKemas_bl;  }
    public void setTkhKemas_bl(String tkhKemas_bl) {
        this.tkhKemas_bl = tkhKemas_bl;
    }

    //------------------------------------------------Blok = bl------------------------------------------//


    //-----------------------------------------------Ruang = ru------------------------------------------//

    //-----------------------------------------------Ruang = ru------------------------------------------//








    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Untuk Bangunan = _ba
        dest.writeString(this.idBangunan_ba);
        dest.writeString(this.nmBangunan_ba);
        dest.writeString(this.idLokasi_ba);
        dest.writeString(this.status_ba);
        dest.writeString(this.idKemas_ba);
        dest.writeString(this.tkhKemas_ba);

        // Untuk Bangunan = _bl
        dest.writeString(this.idBlok_bl);
        dest.writeString(this.nmBlok_bl);
        dest.writeString(this.idLokasi_bl);
        dest.writeString(this.idBangunn_bl);
        dest.writeString(this.aras_bl);
        dest.writeString(this.status_bl);
        dest.writeString(this.idKemas_bl);
        dest.writeString(this.tkhKemas_bl);

        // Untuk Ruang = _ru


    }

    public Ruang() {
    }

    protected Ruang(Parcel in) {
        // Untuk Bangunan = _ba
        this.idBangunan_ba = in.readString();
        this.nmBangunan_ba = in.readString();
        this.idLokasi_ba = in.readString();
        this.status_ba = in.readString();
        this.idKemas_ba = in.readString();
        this.tkhKemas_ba = in.readString();

        // Untuk Bangunan = _bl
        this.idBlok_bl = in.readString();
        this.nmBlok_bl = in.readString();
        this.idLokasi_bl = in.readString();
        this.idBangunn_bl = in.readString();
        this.aras_bl = in.readString();
        this.status_bl = in.readString();
        this.idKemas_bl = in.readString();
        this.tkhKemas_bl = in.readString();

        // Untuk Ruang = _ru

    }

    public static final Creator<Ruang> CREATOR = new Creator<Ruang>() {
        public Ruang createFromParcel(Parcel source) {
            return new Ruang(source);
        }

        public Ruang[] newArray(int size) {
            return new Ruang[size];
        }
    };
}
