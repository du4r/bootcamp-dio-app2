package com.du4r.soccernews.ui.data.remote.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.du4r.soccernews.ui.domains.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news WHERE favorite = :favorite")
    List<News> loadFavoriteNews(boolean favorite);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news);


}
