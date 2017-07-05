package com.emadjaber.sporton.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emadjaber.sporton.R;
import com.emadjaber.sporton.model.SourceArticles;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewsRvAdapter extends RecyclerView.Adapter<NewsRvAdapter.NewsViewHolder>
implements Callback<SourceArticles>{
    private Context mContext;
    private SourceArticles mSourceArticles;

    public NewsRvAdapter(Context context) {
        mContext=context;
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
        if (mSourceArticles ==null){
            return 0;
        }
        if(mSourceArticles.articles ==null){
            return 0;
        }
        return mSourceArticles.articles.length;
    }

    @Override
    public void success(SourceArticles sourceArticles, Response response) {
        mSourceArticles = sourceArticles;
        notifyDataSetChanged();
    }

    @Override
    public void failure(RetrofitError error) {
        Log.i("KEY","error "+error.toString());

    }

    public SourceArticles getSourceArticles(){
        return mSourceArticles;
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
             mPublisher=itemView.findViewById(R.id.publisher);
             mTitle=itemView.findViewById(R.id.news_title);
             mPublishDate =itemView.findViewById(R.id.publish_date);
             mTitle=itemView.findViewById(R.id.news_title);
             mDescription=itemView.findViewById(R.id.news_description);
             mAgencyImage= itemView.findViewById(R.id.agency_image);
             mNewsImage=  itemView.findViewById(R.id.news_image);
        }

        void bindViews(int position){
            mPublisher.setText(mSourceArticles.source);
            mTitle.setText(mSourceArticles.articles[position].getTitle());
            mPublishDate.setText(mSourceArticles.articles[position].getPublishedAt());
            mDescription.setText(mSourceArticles.articles[position].getDescription());
            Picasso.with(mContext)
                    .load(mSourceArticles.articles[position].getUrlToImage())
                    .into(mNewsImage);
            mAgencyImage.setImageResource(
                    mSourceArticles.getPublisherImageResId()
            );
        }

    }

}
