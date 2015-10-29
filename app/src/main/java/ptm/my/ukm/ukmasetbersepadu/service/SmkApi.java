package ptm.my.ukm.ukmasetbersepadu.service;

import java.util.List;

import my.ukm.ptm.ukmassetstracker.model.Asset;
import my.ukm.ptm.ukmassetstracker.model.User;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by fird on 14/09/2015.
 */
public interface SmkApi {

    @GET("login/auth/id/{ukmper}/pass/{password}/format/json/")
    Call<User> loginAuth(
            @Path("ukmper") String ukmper,
            @Path("password") String password
    );

    @GET("asset/get/{assetId}")
    Call<Asset> getAsset(
            @Path("assetId") String assetId
    );

    @GET("asset/getall/{start}/{end}")
    Call<List<Asset>> getListAsset(
            @Path("start") String start,
            @Path("end") String end
    );

}
