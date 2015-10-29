package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.okhttp.OkHttpClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.model.User;
import ptm.my.ukm.ukmasetbersepadu.net.LoggingInterceptor;
import ptm.my.ukm.ukmasetbersepadu.service.SmkApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.btnLogin) Button btnLogin;
    @Bind(R.id.etUsername) EditText etUsername;
    @Bind(R.id.etPassword) EditText etPassword;
    @Bind(R.id.container)  RelativeLayout vContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString();
                auth(username,password);
            }
        });
    }

    public void auth(String username,String password){

        final MaterialDialog dialog =  new MaterialDialog.Builder(this)
                .title("Loading")
                .content("Please Wait")
                .progress(true, 0)
                .show();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://smkphp.ukm.my/ruang/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<User> userCall = smkApi.loginAuth(username,password);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                dialog.dismiss();

                User user = response.body();
                if (user.getError().equals("NULL")) {
                    Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                    i.putExtra("user", user);
                    startActivity(i);
                } else {
                    Snackbar.make(vContainer, user.getErrorMsg(), Snackbar.LENGTH_LONG).show();
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
