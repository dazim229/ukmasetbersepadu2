package ptm.my.ukm.ukmasetbersepadu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import ptm.my.ukm.ukmasetbersepadu.R;
import ptm.my.ukm.ukmasetbersepadu.model.Ruang;

public class ResultListEditRuangAdapter extends ArrayAdapter<Ruang> {

    private LayoutInflater mLayoutInflater;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options;
    private Context mContext;





    public ResultListEditRuangAdapter(Context context, int resource) {
        super(context, resource);
        mLayoutInflater = LayoutInflater.from(context);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.___ruang_list_item, parent, false);

            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final MaterialDialog dialog =  new MaterialDialog.Builder(mContext)
                            .title("BANGUNAN")
                            .content("Edit Data Bangunan Baru(develop)")
//                .progress(true, 0)
                            .show();
//                    Intent i = new Intent(mContext,RuangDetailActivity.class);
//                    Intent i = new Intent(mContext,Main3Activity.class);
//                    Ruang searchResult = (Ruang) v.findViewById(R.id.tvItemCode).getTag();
////                    Log.e("Success", searchResult.toString());
//                    i.putExtra("asset", searchResult);
//                    mContext.startActivity(i);
                }
            });

        }
        else {
            vh = (ViewHolder) convertView.getTag();


        }

        Ruang searchResult = getItem(position);

          vh.tvItemCode.setTag(searchResult);
//        vh.tvItemCategory.setText(searchResult.getCategory());
          vh.tvItemCode.setText(searchResult.getNmBangunan_ba());
//        vh.tvItemDepartment.setText(searchResult.getDepartmentCode());
//        vh.tvItemFak.setText(searchResult.getCostcrtDesc());
//        vh.tvItemDesc.setText(searchResult.getDescription());
          vh.tvAssetCode.setText(searchResult.getIdBangunan_ba());
//        vh.tvItemReceiveDate.setText(searchResult.getRecieveDate());
//        vh.tvItemType.setText(searchResult.getType());
//        vh.tvItemValue.setText(searchResult.getNettValue());

        return convertView;
    }

    public static class ViewHolder  {
//        @Bind(R.id.tvItemCategory) TextView tvItemCategory;
          @Bind(R.id.tvItemCode) TextView tvItemCode;
//        @Bind(R.id.tvItemDepartment) TextView tvItemDepartment;
//        @Bind(R.id.tvItemFak) TextView tvItemFak;
//        @Bind(R.id.tvItemDesc) TextView tvItemDesc;
          @Bind(R.id.tvItemId) TextView tvAssetCode;
//        @Bind(R.id.tvItemReceiveDate) TextView tvItemReceiveDate;
//        @Bind(R.id.tvItemType) TextView tvItemType;
//        @Bind(R.id.tvItemValue) TextView tvItemValue;

        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
