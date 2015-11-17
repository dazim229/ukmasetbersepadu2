package ptm.my.ukm.ukmasetbersepadu;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.adapter.ResultListEditRuangAdapter;
import ptm.my.ukm.ukmasetbersepadu.model.Ruang;
import ptm.my.ukm.ukmasetbersepadu.model.User;
import ptm.my.ukm.ukmasetbersepadu.net.LoggingInterceptor;
import ptm.my.ukm.ukmasetbersepadu.service.SmkApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class ____RuangEditBangunanFragment extends Fragment {

//    @Bind(R.id.tvItemCode) TextView tvName;
//    @Bind(R.id.tvJawatan) TextView tvJawatan;
//    @Bind(R.id.tvJbtnTugas) TextView tvJbtnTugas;
//    @Bind(R.id.tvUkmper) TextView tvUkmper;
//    @Bind(R.id.ivPhoto) ImageView ivPhoto;
//    @Bind(R.id.source1) ImageView source1;

    @Bind(R.id.listAsset)
    ListView lvAsset;

    ResultListEditRuangAdapter resultListEditRuangAdapter;

    private static final String ARG_USER = "param1";
    private User user;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    private Context mContext;


    public static ____RuangEditBangunanFragment newInstance(User param1) {
        ____RuangEditBangunanFragment fragment = new ____RuangEditBangunanFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public ____RuangEditBangunanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);







    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.___fragment_list_ruang_bangunan, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, getActivity());




        resultListEditRuangAdapter = new ResultListEditRuangAdapter(getActivity(),0);
        lvAsset.setAdapter(resultListEditRuangAdapter);
        getAsset("1");







    }
    public void getAsset(final String id){
        final MaterialDialog dialog =  new MaterialDialog.Builder(getActivity())
                .title("Loading")
                .content("Please Wait")
                .progress(true, 0)
                .show();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new LoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://10.1.140.42/efast/api/")
                .baseUrl("http://smkphp.ukm.my/ruang/efast/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<List<Ruang>> assetCall = smkApi.getListRuang("1", "200");



        assetCall.enqueue(new Callback<List<Ruang>>() {
            @Override
            public void onResponse(Response<List<Ruang>> response) {
                dialog.dismiss();
                if (response == null) {
                    Snackbar.make(lvAsset, "not found id:", Snackbar.LENGTH_LONG).show();
                } else {
                    resultListEditRuangAdapter.addAll(response.body());
                    resultListEditRuangAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Snackbar.make(lvAsset, "Server Error" + t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
