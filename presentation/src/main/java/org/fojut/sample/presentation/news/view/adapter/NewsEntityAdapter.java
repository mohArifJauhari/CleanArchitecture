package org.fojut.sample.presentation.news.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.fojut.sample.presentation.R;
import org.fojut.sample.presentation.base.internal.di.scope.PerActivity;
import org.fojut.sample.presentation.news.model.NewsEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fojut on 2016/4/20.
 */
@PerActivity
public class NewsEntityAdapter extends RecyclerView.Adapter<NewsEntityAdapter.ViewHolder> {

    private List<NewsEntity> newsEntityList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;

    @Inject
    public NewsEntityAdapter(Context context) {
        this.mContext = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.newsEntityList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_summary, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        NewsEntity newsEntity = newsEntityList.get(position);
        Glide.with(mContext).load(newsEntity.getPicUrl()).asBitmap().animate(R.anim.image_load)
                .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_loading)
                .error(R.mipmap.ic_fail).into(viewHolder.photo);
        viewHolder.title.setText(newsEntity.getTitle());
        viewHolder.desc.setText(newsEntity.getDescription());
        viewHolder.time.setText(newsEntity.getTime());
    }

    @Override
    public int getItemCount() {
        return newsEntityList.size();
    }

    public void setNewsEntityList(List<NewsEntity> newsEntityList) {
        this.newsEntityList = newsEntityList;
    }

    public void updateDataList(List<NewsEntity> newsEntityList){
        setNewsEntityList(newsEntityList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_news_summary_photo)
        ImageView photo;
        @Bind(R.id.tv_news_summary_title)
        TextView title;
        @Bind(R.id.tv_news_summary_desc)
        TextView desc;
        @Bind(R.id.tv_news_summary_time)
        TextView time;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
