package com.du4r.soccernews.ui.data;

import com.du4r.soccernews.ui.domains.News;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
