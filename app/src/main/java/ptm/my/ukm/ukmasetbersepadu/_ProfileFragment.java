package ptm.my.ukm.ukmasetbersepadu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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


public class _ProfileFragment extends Fragment {

    @Bind(R.id.tvItemCode) TextView tvName;
    @Bind(R.id.tvJawatan) TextView tvJawatan;
    @Bind(R.id.tvJbtnTugas) TextView tvJbtnTugas;
    @Bind(R.id.tvUkmper) TextView tvUkmper;
    @Bind(R.id.ivPhoto) ImageView ivPhoto;
    @Bind(R.id.source1) ImageView source1;
    @Bind(R.id.source2) ImageView source2;
    @Bind(R.id.source3) ImageView source3;
    @Bind(R.id.source4) ImageView source4;
    @Bind(R.id.source5) ImageView source5;
    @Bind(R.id.source6) ImageView source6;
    @Bind(R.id.source7) ImageView source7;
    @Bind(R.id.source8) ImageView source8;
    @Bind(R.id.source9) ImageView source9;



    private static final String ARG_USER = "param1";
    private User user;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
    private Context mContext;


    public static _ProfileFragment newInstance(User param1) {
        _ProfileFragment fragment = new _ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public _ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);







    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout._fragment_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = getArguments().getParcelable(ARG_USER);
        initProfile(user);

        source1.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source2.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source3.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source4.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source5.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source6.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source7.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });

        source8.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });



        source9.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), __DrawerActivity2.class);
                i.putExtra("user", user);
                startActivity(i);
//

            }
        });




//

    }

    public void initProfile(User argUser){
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        tvName.setText(argUser.getNama());
        tvJawatan.setText(argUser.getNamaJawHakiki());
        tvJbtnTugas.setText(argUser.getNamaJabHakiki());
        tvUkmper.setText(argUser.getUkmper());
        imageLoader.displayImage(argUser.getGambarUrl(), ivPhoto, options);
    }

}
