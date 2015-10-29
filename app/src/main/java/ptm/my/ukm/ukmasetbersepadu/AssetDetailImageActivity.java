package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.utils.PhotoPickerIntent;
import my.ukm.ptm.ukmassetstracker.adapter.PhotoAdapter;
import my.ukm.ptm.ukmassetstracker.model.Asset;

public class AssetDetailImageActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public final static int REQUEST_CODE = 1;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    PhotoAdapter photoAdapter;
    ArrayList<String> selectedPhotos = new ArrayList<>();
    List<String> photos = null;
    private Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail_image);
        ButterKnife.bind(this);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        if (getIntent() != null){
            asset = getIntent().getParcelableExtra("asset");
        }

        photoAdapter = new PhotoAdapter(this, selectedPhotos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL));
        recyclerView.setAdapter(photoAdapter);
    }

    @OnClick(R.id.btnImage) void openImagePicker(){
        PhotoPickerIntent intent = new PhotoPickerIntent(this);
        intent.setPhotoCount(9);
        intent.setShowCamera(true);
        intent.setShowGif(true);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @OnClick(R.id.btnNext) void openAssetSummaray(){
        Intent i = new Intent(this,AssetSummary.class);
        i.putExtra("asset", asset);
        if(photos != null){
            i.putExtra("photos",new ArrayList<String>(photos));
        }
        finish();
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (intent != null) {
                photos = intent.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
            selectedPhotos.clear();

            if (photos != null) {

                selectedPhotos.addAll(photos);
            }
            photoAdapter.notifyDataSetChanged();
        }
    }
}
