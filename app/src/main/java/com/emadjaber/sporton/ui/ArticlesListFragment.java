package com.emadjaber.sporton.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emadjaber.sporton.R;
import com.emadjaber.sporton.adapter.NewsRvAdapter;
import com.emadjaber.sporton.model.SourceArticles;
import com.emadjaber.sporton.network.NewsApi;

public class ArticlesListFragment extends Fragment {

    private static final String DOWNLOADED_DATA = "downloaded data";
    private static final String ARTICLES_KEY = "articles key";
    NewsRvAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_articles_list, container, false);
        RecyclerView newsList=(RecyclerView)view.findViewById(R.id.news_list);
        mAdapter=new NewsRvAdapter(getContext());
        newsList.setAdapter(mAdapter);
        newsList.setLayoutManager(new LinearLayoutManager(getContext()));

        if(savedInstanceState==null){
            NewsApi.getSourceArticles(mAdapter);
            Log.i("KEY","calling");
        }else {
            if(savedInstanceState.containsKey(ARTICLES_KEY)){
                SourceArticles articles=savedInstanceState.getParcelable(ARTICLES_KEY);
                mAdapter.success(articles,null);
                Log.i("KEY","retrieving");

            }else {
                Log.i("KEY","calling");
                NewsApi.getSourceArticles(mAdapter);
            }

        }


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARTICLES_KEY,mAdapter.getSourceArticles());
    }
}
