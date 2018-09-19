package com.ibtikar.app.egymart.data.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibtikar.app.egymart.R;
import com.ibtikar.app.egymart.data.models.CategoryModel;
import com.ibtikar.app.egymart.uiutilities.CustomRecyclerView;
import com.ibtikar.app.egymart.uiutilities.PaginationAdapterCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSubCategories extends CustomRecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private ArrayList<CategoryModel> arrayList;
    private Context context;
    private customButtonListener customListener;

    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    Handler handler;
    Runnable runnable;
    private PaginationAdapterCallback mCallback;
    private String errorMsg;

    public AdapterSubCategories(Context context,
                                    ArrayList<CategoryModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public int getItemViewType(int position) {

        return (position == arrayList.size() -1 && isLoadingAdded) ? LOADING : ITEM;
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

    public void remove(CategoryModel r) {
        int position = arrayList.indexOf(r);
        if (position > -1) {
            arrayList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }
    public CategoryModel getItem(int position) {
        return arrayList.get(position);
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }



    public void addLoadingFooter() {
        isLoadingAdded = true;
        //add(new OpportunityModel());
        add(getItem(arrayList.size()-1));
    }
    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = arrayList.size() - 1;
        CategoryModel result = getItem(position);

        if (result != null) {
            arrayList.remove(position);
            notifyItemRemoved(position);
        }
    }


    @Override
    public void onBindViewHolder(CustomRecyclerView.ViewHolder holder, final int position) {
        final CategoryModel model = arrayList.get(position);
        switch (getItemViewType(position)) {
            case ITEM:
                final SubCategoryViewHolder subCategoryViewHolder = (SubCategoryViewHolder) holder;
                subCategoryViewHolder.img_desc.setImageBitmap(model.getIm());
                subCategoryViewHolder.tv_title.setText(model.getTitle());
                subCategoryViewHolder.lout_container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customListener.onItemClickListner(model.getId(), model.getTitle());
                    }
                });
                break;

                case LOADING:
                LoadingVH loadingVH = (LoadingVH) holder;
                    StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) loadingVH.itemView.getLayoutParams();
                    layoutParams.setFullSpan(true);


                    if (retryPageLoad) {
                        loadingVH.mErrorLayout.setVisibility(View.VISIBLE);
                        loadingVH.mProgressBar.setVisibility(View.GONE);

                        loadingVH.mErrorTxt.setText(
                                errorMsg != null ?
                                        errorMsg :
                                        context.getString(R.string.error_msg_unknown));

                    } else {
                        loadingVH.mErrorLayout.setVisibility(View.GONE);
                        loadingVH.mProgressBar.setVisibility(View.VISIBLE);
                    }
                    break;


        }
    }


    @Override
    public CustomRecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case ITEM:
                View viewItem = mInflater.inflate(
                        R.layout.view_category_item, viewGroup, false);
                viewHolder = new SubCategoryViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = mInflater.inflate(R.layout.view_loading_footer, viewGroup, false);
                viewHolder = new LoadingVH(viewLoading);
                break;
        }
        return viewHolder;
    }


    public class SubCategoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_desc)
        ImageView img_desc;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.lout_container)
        RelativeLayout lout_container;

        public SubCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.loadmore_progress)
        ProgressBar mProgressBar;
        @BindView(R.id.loadmore_retry)
        ImageButton mRetryBtn;
        @BindView(R.id.loadmore_errortxt)
        TextView mErrorTxt;
        @BindView(R.id.loadmore_errorlayout)
        LinearLayout mErrorLayout;

        public LoadingVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            if (mProgressBar != null) {
                mProgressBar.setIndeterminate(true);
                mProgressBar.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.white_blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                mProgressBar.setVisibility(View.VISIBLE);
            }

            mRetryBtn.setOnClickListener(this);
            mErrorLayout.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:

                    showRetry(false, null);
                    mCallback.retryPageLoad();

                    break;
            }
        }
    }

    public interface customButtonListener {
        public void onItemClickListner(String id, String title);
    }
    public void setCustomButtonListner(customButtonListener listener) {
        this.customListener = listener;
    }

    public void setPagingAdapterCallback (PaginationAdapterCallback pagingAdapterCallback)
    {
        this.mCallback = pagingAdapterCallback;
    }


    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(arrayList.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }

}
