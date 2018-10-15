package com.ibtikar.app.dutchmart.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.models.CartItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartItemsAdapter extends ArrayAdapter<CartItemModel> {
    Context context;
    ViewHolder viewHolder;

    private CustomeListener customeListener;

    public CartItemsAdapter(Context context, ArrayList<CartItemModel> items)
    {
        super(context,0,items);
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CartItemModel cartListModel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_item_cart, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvProductName.setText(cartListModel.getProductName());
        viewHolder.tvQuntity.setText(String.valueOf(cartListModel.getQuantity()));
        viewHolder.btnDecreaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customeListener.onAmountEditListener(viewHolder.tvQuntity.getText().toString(),false, position);
            }
        });

        viewHolder.btnIncreaseAuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customeListener.onAmountEditListener(viewHolder.tvQuntity.getText().toString(),true, position);
            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customeListener.onRemoveButtonClickListner(cartListModel.getId(), position);
            }
        });

        if (!(cartListModel.getImageUrl()==null || cartListModel.getImageUrl().equals("")))
        {
            Glide.with(context)
                    .load(cartListModel.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.imvDescription);
        }
        else {
           /* Glide.with(context)
                    .load(R.drawable.placeholder).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.imvDescription);*/ }

         viewHolder.tvTotalQuantityPrice.setText(String.valueOf(cartListModel.getPriceForTotalQuantity()));

        viewHolder.loutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customeListener.onItemClickListener(cartListModel.getId());
            }
        });

        return convertView;
    }





    public class ViewHolder {
        @BindView(R.id.imageView3)
        ImageView imvDescription;
        @BindView(R.id.lout_cont)
        ConstraintLayout loutContainer;
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_quantity)
        TextView tvQuntity;
        @BindView(R.id.btn_decrease)
        ImageView btnDecreaseQuantity;
        @BindView(R.id.btn_increase)
        ImageView btnIncreaseAuantity;
        @BindView(R.id.tv_total_quantity_price)
        TextView tvTotalQuantityPrice;
        @BindView(R.id.imageView4)
        ImageView btnDelete;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }


    public interface CustomeListener {
        public void onRemoveButtonClickListner(String productId, int position);
        public void onAmountEditListener(String currentQuantity, boolean isIncrease, int position);
        public void onItemClickListener(String productId);
    }
    public void setCustomButtonListner(CustomeListener listener) {
        this.customeListener = listener;
    }

}
