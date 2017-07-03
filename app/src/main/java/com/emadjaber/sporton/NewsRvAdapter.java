package com.emadjaber.sporton;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsRvAdapter extends RecyclerView.Adapter<NewsRvAdapter.NewsViewHolder> {
    private Context mContext;
    private List<News> mNews;

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

    }

    @Override
    public int getItemCount() {
        if (mNews==null){
            return 0;
        }else {
            return mNews.size();
        }

    }


    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView mAgencyNameText;
        TextView mTime;
        TextView mTitle;
        TextView mDescription;
        ImageView mAgencyImage;
        ImageView mNewsImage;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mAgencyNameText= itemView.findViewById(R.id.agency_name);
            mTime=itemView.findViewById(R.id.news_time);
            mTitle=itemView.findViewById(R.id.news_title);
            mDescription=itemView.findViewById(R.id.news_description);
            mAgencyImage= itemView.findViewById(R.id.agency_image);
            mNewsImage= itemView.findViewById(R.id.news_image);
        }
    }


}
