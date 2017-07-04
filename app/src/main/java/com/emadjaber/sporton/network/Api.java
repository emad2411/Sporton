package com.emadjaber.sporton.network;


import com.emadjaber.sporton.model.SourceArticles;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


public interface Api {


    @GET("/articles/")
    void articles(@Query("source") String source,@Query("sortBy") String sortBy,
                  Callback<SourceArticles> callback);

}
