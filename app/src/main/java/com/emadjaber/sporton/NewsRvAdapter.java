package com.emadjaber.sporton;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsRvAdapter extends RecyclerView.Adapter<NewsRvAdapter.NewsViewHolder> {
    private Context mContext;
    private ActiveNews mActiveNews;

    public NewsRvAdapter(Context context, ActiveNews activeNews) {
        mContext=context;
        mActiveNews=activeNews;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(mContext)
               .inflate(R.layout.news_list_item,parent,false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bindViews(position);

    }

    @Override
    public int getItemCount() {
        if (mActiveNews==null){
            return 0;
        }else {
            if(mActiveNews.news.length==0){
                return 0;
            }else {
                return mActiveNews.news.length;
            }
        }
    }




    class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView mPublisher;
        TextView mPublishDate;
        TextView mTitle;
        TextView mDescription;
        ImageView mAgencyImage;
        ImageView mNewsImage;

         NewsViewHolder(View itemView) {
            super(itemView);
             mPublisher=(TextView)itemView.findViewById(R.id.publisher);
             mTitle=(TextView)itemView.findViewById(R.id.news_title);
             mPublishDate =(TextView)itemView.findViewById(R.id.publish_date);
             mTitle=(TextView)itemView.findViewById(R.id.news_title);
             mDescription=(TextView)itemView.findViewById(R.id.news_description);
             mAgencyImage= (ImageView) itemView.findViewById(R.id.agency_image);
             mNewsImage= (ImageView) itemView.findViewById(R.id.news_image);
        }

        void bindViews(int position){
            mPublisher.setText(mActiveNews.source);
            mTitle.setText(mActiveNews.news[position].getTitle());
            mPublishDate.setText(mActiveNews.news[position].getPublishDate());
            mDescription.setText(mActiveNews.news[position].getNewsDescription());
            Picasso.with(mContext)
                    .load(mActiveNews.news[position].getImageURL())
                    .into(mNewsImage);
            mAgencyImage.setImageResource(
                    mActiveNews.getPublisherImageResId()
            );
        }

    }

}
