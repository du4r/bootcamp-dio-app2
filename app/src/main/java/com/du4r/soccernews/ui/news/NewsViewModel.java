package com.du4r.soccernews.ui.news;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.du4r.soccernews.ui.data.remote.SoccerNewsApi;
import com.du4r.soccernews.ui.data.remote.local.AppDatabase;
import com.du4r.soccernews.ui.domains.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mNews = new MutableLiveData<>();
    private final SoccerNewsApi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://du4r.github.io/mockings/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SoccerNewsApi.class);


        this.findNewsFromApi();
    }


    private void findNewsFromApi() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call,@NonNull Response<List<News>> response) {
                if(response.isSuccessful() ){
                    mNews.setValue(response.body());
                } else{
                    //TODO: PENSAR EM UMA ESTRATEGIA DE TRATAMENTO DE ERROS
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO: PENSAR EM UMA ESTRATEGIA DE TRATAMENTO DE ERROs
            }
        });
    }

    public MutableLiveData<List<News>> getNews() {
        return mNews;
    }

}