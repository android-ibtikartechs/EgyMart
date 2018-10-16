package com.ibtikar.app.dutchmart.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibtikar.app.dutchmart.R;
import com.ibtikar.app.dutchmart.data.models.CategoryModel;
import com.ibtikar.app.dutchmart.data.models.MenuItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuListAdapter extends ArrayAdapter<CategoryModel> {
    Context context;
    ViewHolder viewHolder;
    ArrayList<CategoryModel> items;
    CustomeListener customeListener;


    public MenuListAdapter(Context context, ArrayList<CategoryModel> items)
    {
        super(context,0,items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CategoryModel menuItemModel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_menu_item, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        }

        else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvProductName.setText(menuItemModel.getTitle());
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

        @BindView(R.id.lout_cont)
        LinearLayout loutContainer;
        @BindView(R.id.tv_menu_item_name)
        TextView tvProductName;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }

}
