package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.okhttp.OkHttpClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import my.ukm.ptm.ukmassetstracker.model.Asset;
import my.ukm.ptm.ukmassetstracker.net.LoggingInterceptor;
import my.ukm.ptm.ukmassetstracker.service.SmkApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchAssetActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.container) CoordinatorLayout vContainer;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_asset);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if (getIntent() != null){
            id = getIntent().getStringExtra("id");
            getAsset(id);
        }

    }

    public void getAsset(final String id){
        final MaterialDialog dialog =  new MaterialDialog.Builder(this)
                .title("Loading")
                .content("Please Wait")
                .progress(true, 0)
                .show();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.140.42/efast/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<Asset> assetCall = smkApi.getAsset(id);
        assetCall.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Response<Asset> response) {
                dialog.dismiss();
                if(response == null){
                    Snackbar.make(vContainer, "Asset not found id:" + id, Snackbar.LENGTH_LONG).show();
                }else {
                    Asset asset = response.body();
                    Intent i = new Intent(getApplicationContext(),AssetDetailActivity.class);
                    i.putExtra("asset",asset);
                    finish();
                    startActivity(i);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Snackbar.make(vContainer, "Server Error" + t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
