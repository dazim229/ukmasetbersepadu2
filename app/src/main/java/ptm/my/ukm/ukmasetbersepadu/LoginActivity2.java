package ptm.my.ukm.ukmasetbersepadu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ptm.my.ukm.ukmasetbersepadu.model.User;
import ptm.my.ukm.ukmasetbersepadu.net.LoggingInterceptor;
import ptm.my.ukm.ukmasetbersepadu.service.SmkApi;
import com.squareup.okhttp.OkHttpClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
//import butterknife.InjectView;

public class LoginActivity2 extends AppCompatActivity {
    private static final String TAG = "LoginActivity2";
    private static final int REQUEST_SIGNUP = 0;

    @Bind(R.id.input_ukmper) EditText _ukmperText;
    @Bind(R.id.input_katalaluan) EditText _katalaluanText;
    @Bind(R.id.btn_login) Button _loginButton;
    @Bind(R.id.link_signup) TextView _signupLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);
        
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                login();
                String username = _ukmperText.getText().toString().trim();
                String password = _katalaluanText.getText().toString();
                auth(username,password);
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                //Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                //startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }



    public void auth(String username,String password){

        if (!validate()) {
            onLoginFailed();
            return;
        }

       // _loginButton.setEnabled(false);
//       final MaterialDialog dialog =  new MaterialDialog.Builder(this)
//                .title("Loading")
//                .content("Please Wait")
//                .progress(true, 0)
//                .show();

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity2.this, R.style.MyTheme);

        //progressDialog.getWindow().setBackgroundDrawable(null);
        //progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setIndeterminate(false);
        progressDialog.setMessage("Pengesahan");
        progressDialog.show();


        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://appsmu.ukm.my/smkapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<User> userCall = smkApi.loginAuth(username,password);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                progressDialog.dismiss();

                User user = response.body();
                if (user.getError().equals("NULL")) {


                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    // On complete call either onLoginSuccess or onLoginFailed
                                    onLoginSuccess();                   // onLoginFailed();
                                    progressDialog.dismiss();
                                }
                            }, 3000);

                    Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                    i.putExtra("user", user);
                    startActivity(i);

                } else {
                    Toast.makeText(getBaseContext(), "Log Masuk Tidak Berjaya", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Throwable t) {
               Toast.makeText(getBaseContext(), "Log Masuk Tidak Berjaya", Toast.LENGTH_LONG).show();

                _loginButton.setEnabled(true);
            }
        });

    }

















//    public void login() {
//        Log.d(TAG, "Login");
//
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }
//
//        _loginButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity2.this, R.style.MyTheme);
//
//        //progressDialog.getWindow().setBackgroundDrawable(null);
//        //progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        progressDialog.setIndeterminate(false);
//        progressDialog.setMessage("Pengesahan");
//        progressDialog.show();
//
//        String ukmper = _ukmperText.getText().toString();
//        String katalaluan = _katalaluanText.getText().toString();
//
//        // TODO: Implement your own authentication logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onLoginSuccess or onLoginFailed
//                        onLoginSuccess();                   // onLoginFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        if (requestCode == REQUEST_SIGNUP) {
////            if (resultCode == RESULT_OK) {
////
////                // TODO: Implement successful signup logic here
////                // By default we just finish the Activity and log them in automatically
////                this.finish();
////            }
////        }
////    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity2
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Log Masuk Tidak Berjaya", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }















    public boolean validate() {
        boolean valid = true;

        String ukmper = _ukmperText.getText().toString();
        String katalaluan = _katalaluanText.getText().toString();

        if (ukmper.isEmpty()) {
            _ukmperText.setError("Sila Masukkan UKMPer");
            valid = false;
        } else {
            _ukmperText.setError(null);
        }

        if (katalaluan.isEmpty()) {
            _katalaluanText.setError("Masukkan Kata Laluan diantara 4 hingga 10 characters alphanmberic");
            valid = false;
        } else {
            _katalaluanText.setError(null);
        }


        return valid;

    }
}
