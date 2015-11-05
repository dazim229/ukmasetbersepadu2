package ptm.my.ukm.ukmasetbersepadu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ptm.my.ukm.ukmasetbersepadu.model.Asset;
import ptm.my.ukm.ukmasetbersepadu.model.Ruang;

public class RuangDetailActivity extends AppCompatActivity {

      @Bind(R.id.toolbar) Toolbar toolbar;
      @Bind(R.id.tvItemCode) TextView tvItemCode;
      @Bind(R.id.tvItemId) TextView tvAssetCode;


    private Ruang asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang_detail);
        ButterKnife.bind(this);
//
//        if(toolbar != null){
//            setSupportActionBar(toolbar);
//        }

        if (getIntent() != null){
            asset = getIntent().getParcelableExtra("asset");

              getSupportActionBar().setTitle(asset.getNmBangunan());
              tvItemCode.setText(asset.getNmBangunan());
              tvAssetCode.setText(asset.getIdBangunan());

        }

    }

//    @OnClick(R.id.btnNext) void goToAssetDetailImageActivity(){
//        Intent i = new Intent(this,AssetDetailImageActivity.class);
//        i.putExtra("asset",asset);
//        finish();
//        startActivity(i);
//    }
}