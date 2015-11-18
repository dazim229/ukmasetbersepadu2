package ptm.my.ukm.ukmasetbersepadu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.model.User;


public class __JenisRuangFragment extends Fragment {

//    @Bind(R.id.tvItemCode) TextView tvName;
//    @Bind(R.id.tvJawatan) TextView tvJawatan;
//    @Bind(R.id.tvJbtnTugas) TextView tvJbtnTugas;
//    @Bind(R.id.tvUkmper) TextView tvUkmper;
//    @Bind(R.id.ivPhoto) ImageView ivPhoto;
    @Bind(R.id.source1) ImageView source1;
    @Bind(R.id.textView14)   TextView textView14;
    @Bind(R.id.textView15) TextView textView15;




    private static final String ARG_USER = "param1";
    private User user;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    private Context mContext;


    public static __JenisRuangFragment newInstance(User param1) {
        __JenisRuangFragment fragment = new __JenisRuangFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public __JenisRuangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        String tempat = bundle.getString("lokasit");
//        textView14.setText().




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.__fragment_jenis_ruang, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = getArguments().getParcelable(ARG_USER);
//        initProfile(user);



        source1.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ___DrawerActivity3.class);
                i.putExtra("user", user);
                startActivity(i);


            }
        });





//

    }
//
//    public void initProfile(User argUser){
//        imageLoader = ImageLoader.getInstance();
//        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.ic_launcher)
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .build();
//
//        tvName.setText(argUser.getNama());
//        tvJawatan.setText(argUser.getNamaJawHakiki());
//        tvJbtnTugas.setText(argUser.getNamaJabHakiki());
//        tvUkmper.setText(argUser.getUkmper());
//        imageLoader.displayImage(argUser.getGambarUrl(), ivPhoto, options);
//    }

}
