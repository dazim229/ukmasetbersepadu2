package ptm.my.ukm.ukmasetbersepadu;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.ukm.ptm.ukmassetstracker.adapter.PhotoAdapter;
import my.ukm.ptm.ukmassetstracker.model.Asset;

public class AssetSummary extends AppCompatActivity {

    @Bind(R.id.tvItemCategory) TextView tvItemCategory;
    @Bind(R.id.tvItemCode) TextView tvItemCode;
    @Bind(R.id.tvItemDepartment) TextView tvItemDepartment;
    @Bind(R.id.tvItemFak) TextView tvItemFak;
    @Bind(R.id.tvItemDesc) TextView tvItemDesc;
    @Bind(R.id.tvItemId) TextView tvAssetCode;
    @Bind(R.id.tvItemReceiveDate) TextView tvItemReceiveDate;
    @Bind(R.id.tvItemType) TextView tvItemType;
    @Bind(R.id.tvItemValue) TextView tvItemValue;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.cContainer) CoordinatorLayout cContainer;

    private Asset asset;

    @Bind(R.id.recycler_view)  RecyclerView recyclerView;
    PhotoAdapter photoAdapter;

    ArrayList<String> selectedPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_summary);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if (getIntent() != null){
            asset = getIntent().getParcelableExtra("asset");

            System.out.println(asset);

            getSupportActionBar().setTitle(asset.getItemCode());
            tvItemCategory.setText(asset.getCategory());
            tvItemCode.setText(asset.getItemCode());
            tvItemDepartment.setText(asset.getDepartmentCode());
            tvItemFak.setText(asset.getCostcrtDesc());
            tvItemDesc.setText(asset.getDescription());
            tvAssetCode.setText(asset.getAssetCode());
            tvItemReceiveDate.setText(asset.getRecieveDate());
            tvItemType.setText(asset.getType());
            tvItemValue.setText(asset.getNettValue());

            selectedPhotos = getIntent().getStringArrayListExtra("photos");
            System.out.println(selectedPhotos);

        }

        if(selectedPhotos != null){
            photoAdapter = new PhotoAdapter(this, selectedPhotos);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL));
            recyclerView.setAdapter(photoAdapter);
        }

    }

    @OnClick(R.id.fabDone) void done(){
        final MaterialDialog dialog =  new MaterialDialog.Builder(this)
                .title("Updating")
                .content("Please Wait")
                .progress(true, 0)
                .show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
                finish();
            }
        }, 2000);
    }

}
