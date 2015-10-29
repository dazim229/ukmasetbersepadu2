package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ptm.my.ukm.ukmasetbersepadu.model.User;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.tvItemCode) TextView tvName;
    @Bind(R.id.tvJawatan) TextView tvJawatan;
    @Bind(R.id.tvJbtnTugas) TextView tvJbtnTugas;
    @Bind(R.id.tvUkmper) TextView tvUkmper;
    @Bind(R.id.ivPhoto) ImageView ivPhoto;
    @Bind(R.id.fabQr) FloatingActionButton fabQr;
    @Bind(R.id.fabSearch) FloatingActionButton fabSearch;

    private User user;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        user = getIntent().getParcelableExtra("user");

        tvName.setText(user.getNama());
        tvJawatan.setText(user.getNamaJawHakiki());
        tvJbtnTugas.setText(user.getNamaJabHakiki());
        tvUkmper.setText(user.getUkmper());
        imageLoader.displayImage(user.getGambarUrl(), ivPhoto, options);

    }

    @OnClick(R.id.fabQr) void scanQr() {
        Intent i = new Intent(this,ScannerActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.fabSearch) void assetSearch(){
        Intent i = new Intent(this,SearchByIdActivity.class);
        startActivity(i);
    }

}
