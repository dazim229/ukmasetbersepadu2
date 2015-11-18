package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.model.Ruang;
import ptm.my.ukm.ukmasetbersepadu.model.User;
import ptm.my.ukm.ukmasetbersepadu.net.LoggingInterceptor;
import ptm.my.ukm.ukmasetbersepadu.service.SmkApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.spinner)    Spinner spinner;
    @Bind(R.id.editText7) EditText editText7;
    @Bind(R.id.editText8)   EditText editText8;
    @Bind(R.id.editText9) EditText editText9;
    @Bind(R.id.editText10)   EditText editText10;
    @Bind(R.id.editText11) EditText editText11;
    @Bind(R.id.spinner2)    Spinner spinner2;
    @Bind(R.id.editText13)   EditText editText13;
    @Bind(R.id.buttonSimpan)   Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buttonSimpan.setOnClickListener(this);
    }

    private void insertUser(){

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://10.1.140.42/efast/api/")
                .baseUrl("http://smkphp.ukm.my/ruang/efast/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<Ruang> assetCall = smkApi.addBangunn(editText8.getText().toString());
        assetCall.enqueue(new Callback<Ruang>() {
            @Override
            public void onResponse(Response<Ruang> response) {
                   // Toast.makeText(getBaseContext(), "Data Masuk", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Throwable t) {
                //Toast.makeText(getBaseContext(), "Log Masuk Tidak Berjaya", Toast.LENGTH_LONG).show();


            }
        });

        String output = "Data Berjaya Dimasukkan";
        Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
    }

    //Overriding onclick method
    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        insertUser();
    }


}
