package ptm.my.ukm.ukmasetbersepadu;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.adapter.ResultListAdapter;
import ptm.my.ukm.ukmasetbersepadu.model.Asset;
import ptm.my.ukm.ukmasetbersepadu.net.LoggingInterceptor;
import ptm.my.ukm.ukmasetbersepadu.service.SmkApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by fird on 09/10/2015.
 */
public class HistoryFragment extends Fragment {
    @Bind(R.id.listAsset)
    ListView lvAsset;

    ResultListAdapter resultListAdapter;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public HistoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_asset, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, getActivity());

        resultListAdapter = new ResultListAdapter(getActivity(),0);
        lvAsset.setAdapter(resultListAdapter);
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
                .baseUrl("http://10.1.140.42/efast/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        SmkApi smkApi = retrofit.create(SmkApi.class);
        Call<List<Asset>> assetCall = smkApi.getListAsset("1","5");
        assetCall.enqueue(new Callback<List<Asset>>() {
            @Override
            public void onResponse(Response<List<Asset>> response) {
                dialog.dismiss();
                if(response == null){
                    Snackbar.make(lvAsset, "not found id:", Snackbar.LENGTH_LONG).show();
                }else {
                    resultListAdapter.addAll(response.body());
                    resultListAdapter.notifyDataSetChanged();
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
