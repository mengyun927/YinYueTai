package com.github.yinyuetai.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.yinyuetai.R;
import com.github.yinyuetai.domain.FirstPageBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr.Yangxiufeng
 * DATE 2016/5/10
 * YinYueTai
 */
public class FirstRecycleViewAdapter extends RecyclerView.Adapter<FirstRecycleViewAdapter.FirstHolder> {


    private ArrayList<FirstPageBean> firstPageBeanList;
    private Activity activity;
    private LinearLayout.LayoutParams localLayoutParams;
    int mWidth, mHeight;

    public FirstRecycleViewAdapter(ArrayList<FirstPageBean> firstPageBeanList, Activity activity, int mWidth, int mHeight) {
        this.firstPageBeanList = firstPageBeanList;
        this.activity = activity;
        localLayoutParams = new LinearLayout.LayoutParams(mWidth, mHeight);
        this.mWidth = mWidth;
        this.mHeight = mHeight;
    }

    @Override
    public FirstHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_pager_item, parent, false);
        return new FirstHolder(view);
    }

    @Override
    public void onBindViewHolder(FirstHolder holder, int position) {
        FirstPageBean pageBean = firstPageBeanList.get(position);
        holder.itemRoot.setLayoutParams(new RelativeLayout.LayoutParams(mWidth, mHeight));
        holder.homeRecommendItemTitle.setText(pageBean.getTitle());
        holder.homeRecommendItemDescription.setText(pageBean.getDescription());
        if ("ACTIVITY".equalsIgnoreCase(pageBean.getType())) {//活动相关
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_activity);
        } else if ("VIDEO".equalsIgnoreCase(pageBean.getType())) {//首播，点击进去显示MV描述，相关MV
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_video);
        } else if ("WEEK_MAIN_STAR".equalsIgnoreCase(pageBean.getType())) {//(悦单)点击进去跟显示悦单详情一样
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_star);
        } else if ("PLAYLIST".equalsIgnoreCase(pageBean.getType())) {//(悦单)点击进去跟显示悦单详情一样
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_playlist);
        } else if ("AD".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_ad);
        } else if ("PROGRAM".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_program);
        } else if ("bulletin".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_bulletin);
        } else if ("fanart".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_fanart);
        } else if ("live".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_live);
        } else if ("live_new".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_live_new);
        } else if ("project".equalsIgnoreCase(pageBean.getType())) {
            holder.homeRecommendItemType.setImageResource(R.drawable.home_page_project);
        }
        holder.homeRecommendItemJpg.setLayoutParams(localLayoutParams);
        holder.homeRecommendItemJpg.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(activity).load(pageBean.getPosterPic()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.homeRecommendItemJpg);
    }

    @Override
    public int getItemCount() {
        return firstPageBeanList.size();
    }

    static class FirstHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.home_recommend_item_jpg)
        ImageView homeRecommendItemJpg;
        @Bind(R.id.home_recommend_item_type)
        ImageView homeRecommendItemType;
        @Bind(R.id.home_recommend_item_title)
        TextView homeRecommendItemTitle;
        @Bind(R.id.home_recommend_item_description)
        TextView homeRecommendItemDescription;
        @Bind(R.id.home_recommend_item_transbg)
        ImageView homeRecommendItemTransbg;
        @Bind(R.id.item_root)
        RelativeLayout itemRoot;
        public FirstHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
