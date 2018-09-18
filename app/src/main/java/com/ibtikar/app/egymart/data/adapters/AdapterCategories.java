package com.ibtikar.app.egymart.data.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.uiutilities.CustomRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCategories extends CustomRecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<CategoryModel> arrayList;
    private Context context;
    private CustomButtonListener customListener;


    public AdapterCategories(Context context,
                       ArrayList<CategoryModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.view_category_item, parent, false);
        viewHolder = new CategoriesViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CategoryModel categoryModel = arrayList.get(position);
        final CategoriesViewHolder categoriesViewHolder = (CategoriesViewHolder) holder;

        categoriesViewHolder.tv_title.setText(categoryModel.getTitle());
        categoriesViewHolder.img_desc.setImageBitmap(categoryModel.getIm());
        categoriesViewHolder.lout_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListener.onItemNewsClickListner(categoryModel.getTitle(), categoryModel.getId());
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public void add(CategoryModel r) {
        arrayList.add(r);
        notifyItemInserted(arrayList.size()-1 );
    }

    public void addAll(ArrayList<CategoryModel> opResults) {
        for (CategoryModel result : opResults) {
            add(result);
        }
    }


    public class CategoriesViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.img_desc)
        ImageView img_desc;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.lout_container)
        RelativeLayout lout_container;

        public CategoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CustomButtonListener {
        public void onItemNewsClickListner(String title, String id);
    }
    public void setCustomButtonListner(CustomButtonListener listener) {
        this.customListener = listener;
    }

}
