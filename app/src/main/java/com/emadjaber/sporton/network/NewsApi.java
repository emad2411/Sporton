package com.emadjaber.sporton.network;


import com.emadjaber.sporton.model.SourceArticles;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class NewsApi {
    public static final String API_KEY="";

    private static RequestInterceptor getRequestInterceptor(){

        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addEncodedQueryParam("api_key",API_KEY);
            }
        };
    }

    private static Api getApi(){
        return new RestAdapter.Builder()
                .setEndpoint(" https://newsapi.org/v1")
                .setRequestInterceptor(getRequestInterceptor())
                .build()
                .create(Api.class);
    }

    public static void getSourceArticles(Callback<SourceArticles> sourceArticlesCallback){
        getApi().articles("the-next-web","latest",sourceArticlesCallback);
    }


}
