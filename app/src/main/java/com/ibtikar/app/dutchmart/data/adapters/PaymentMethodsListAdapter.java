package com.ibtikar.app.dutchmart.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.models.CreditsItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodsListAdapter extends ArrayAdapter<CreditsItemModel> {
    Context context;
    ViewHolder viewHolder;
    ArrayList<CreditsItemModel> items;
    CustomeListener customeListener;


    public PaymentMethodsListAdapter(Context context, ArrayList<CreditsItemModel> items) {
        super(context,0,items);
        this.context = context;
        this.items = items;

    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CreditsItemModel menuItemModel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_payment_items_list, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        }

        else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvCreditName.setText(menuItemModel.getTitle());
        viewHolder.loutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customeListener.onItemClickListener(menuItemModel.getTitle(), menuItemModel.getId(), position);
            }
        });
        return convertView;
    }

    public interface CustomeListener {
        public void onItemClickListener(String title, String itemId, int position);
    }

    public void setCustomButtonListner(CustomeListener listener) {
        this.customeListener = listener;
    }

    public class ViewHolder {

        @BindView(R.id.lout_container)
        CardView loutContainer;
        @BindView(R.id.tv_visa_title)
        TextView tvCreditName;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
