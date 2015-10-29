package ptm.my.ukm.ukmasetbersepadu.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import my.ukm.ptm.ukmassetstracker.AssetDetailActivity;
import my.ukm.ptm.ukmassetstracker.R;
import my.ukm.ptm.ukmassetstracker.model.Asset;

public class ResultListAdapter extends ArrayAdapter<Asset> {

    private LayoutInflater mLayoutInflater;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions options;
    private Context mContext;

    public ResultListAdapter(Context context, int resource) {
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
            convertView = mLayoutInflater.inflate(R.layout.asset_list_item, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext,AssetDetailActivity.class);
                    Asset searchResult = (Asset) v.findViewById(R.id.tvItemCode).getTag();
                    i.putExtra("asset", searchResult);
                    mContext.startActivity(i);
                }
            });

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Asset searchResult = getItem(position);

        vh.tvItemCode.setTag(searchResult);
        vh.tvItemCategory.setText(searchResult.getCategory());
        vh.tvItemCode.setText(searchResult.getItemCode());
        vh.tvItemDepartment.setText(searchResult.getDepartmentCode());
        vh.tvItemFak.setText(searchResult.getCostcrtDesc());
        vh.tvItemDesc.setText(searchResult.getDescription());
        vh.tvAssetCode.setText(searchResult.getAssetCode());
        vh.tvItemReceiveDate.setText(searchResult.getRecieveDate());
        vh.tvItemType.setText(searchResult.getType());
        vh.tvItemValue.setText(searchResult.getNettValue());

        return convertView;
    }

    public static class ViewHolder  {
        @Bind(R.id.tvItemCategory) TextView tvItemCategory;
        @Bind(R.id.tvItemCode) TextView tvItemCode;
        @Bind(R.id.tvItemDepartment) TextView tvItemDepartment;
        @Bind(R.id.tvItemFak) TextView tvItemFak;
        @Bind(R.id.tvItemDesc) TextView tvItemDesc;
        @Bind(R.id.tvItemId) TextView tvAssetCode;
        @Bind(R.id.tvItemReceiveDate) TextView tvItemReceiveDate;
        @Bind(R.id.tvItemType) TextView tvItemType;
        @Bind(R.id.tvItemValue) TextView tvItemValue;

        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
