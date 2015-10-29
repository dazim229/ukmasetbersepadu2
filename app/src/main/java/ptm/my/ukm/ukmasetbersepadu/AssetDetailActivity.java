package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.ukm.ptm.ukmassetstracker.model.Asset;

public class AssetDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tvItemCategory) TextView tvItemCategory;
    @Bind(R.id.tvItemCode) TextView tvItemCode;
    @Bind(R.id.tvItemDepartment) TextView tvItemDepartment;
    @Bind(R.id.tvItemFak) TextView tvItemFak;
    @Bind(R.id.tvItemDesc) TextView tvItemDesc;
    @Bind(R.id.tvItemId) TextView tvAssetCode;
    @Bind(R.id.tvItemReceiveDate) TextView tvItemReceiveDate;
    @Bind(R.id.tvItemType) TextView tvItemType;
    @Bind(R.id.tvItemValue) TextView tvItemValue;

    private Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail);
        ButterKnife.bind(this);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        if (getIntent() != null){
            asset = getIntent().getParcelableExtra("asset");

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
        }

    }

    @OnClick(R.id.btnNext) void goToAssetDetailImageActivity(){
        Intent i = new Intent(this,AssetDetailImageActivity.class);
        i.putExtra("asset",asset);
        finish();
        startActivity(i);
    }

}
