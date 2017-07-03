package com.emadjaber.sporton;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment {

    NewsRvAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_main, container, false);

        News news1=new News("BBC",
                "Marseille pessimistic over Giroud",
                "Olympique Marseille are losing hope of securing the services of Arsenal striker Olivier Giroud this summer.",
                "1 hour ago",
                "http://www.goal.com/en-ar/rumours?ICID=HP_TW1_VA",
                "http://images.performgroup.com/di/library/GOAL/53/8/javier-hernandez-mexico-confederations-cup_l2axp5bfq9ur174s91608vorr.jpg?t=-1142130468&w=620&h=430");

        News news2=new News("BBC",
                "Leicester want £18m Gent goalkeeper",
                "Leicester are considering an £18 million bid (€21m) for Gent goalkeeper Lovre Kalinic",
                "1 hour ago",
                "http://square.github.io/picasso/",
                "http://images.performgroup.com/di/library/Goal_Turkey/d0/eb/lovre-kalinic-croatia_1glztqngnqswv1h9kx8qex4to7.jpg?t=-199221839&w=100&h=80");

        News news3=new News("BBC",
                "Inter eye €49m Di Maria",
                "Inter are set to make an ambitious move for Paris Saint-Germain forward Angel Di Maria.",
                "1 hour ago",
                "http://square.github.io/picasso/",
                "Inter eye €49m Di Maria");

        News[]news={news1,news2,news3};

        ActiveNews activeNews=new ActiveNews("bbc-news",news);

        RecyclerView newsList=(RecyclerView)view.findViewById(R.id.news_list);
        mAdapter=new NewsRvAdapter(getContext(),activeNews);
        newsList.setAdapter(mAdapter);
        newsList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
