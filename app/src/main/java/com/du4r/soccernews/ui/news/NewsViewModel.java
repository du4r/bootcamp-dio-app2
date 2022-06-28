package com.du4r.soccernews.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.du4r.soccernews.ui.domains.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mNews;

    public NewsViewModel() {
        mNews = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("vitoria perde","mais uma vez o ecv perdeu uma partida..."));
        news.add(new News("vitoria perde de novo","mais uma vez o ecv perdeu uma partida..."));
        news.add(new News("vitoria perde na serie c","mais uma vez o ecv perdeu uma partida..."));

        this.mNews.setValue(news);
    }

    public MutableLiveData<List<News>> getNews() {
        return mNews;
    }
}