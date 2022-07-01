package com.du4r.soccernews.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.du4r.soccernews.R;
import com.du4r.soccernews.databinding.NewsItemBinding;
import com.du4r.soccernews.ui.domains.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;
    private final NewsListener favoriteListener;

    public NewsAdapter(List<News> news, NewsListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();

        News news = this.news.get(position);

        holder.binding.tvTitle.setText(news.Title);
        holder.binding.tvDescription.setText(news.Description);
        Picasso.get().load(news.Image).fit().into(holder.binding.ivThumbnail);

        //funcionalidade de abrir o link da noticia
        holder.binding.btnOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.Link));
            context.startActivity(i);
        });
        //funcionalidade de compartilhar link
        holder.binding.ivShare.setOnClickListener(view ->{
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,news.Link);
            context.startActivity(Intent.createChooser(i,"share"));

        });
        //funcionalidade favoritar
        holder.binding.ivFavorite.setOnClickListener(view -> {
            news.Favorite = !news.Favorite;
            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });

        int favoriteColor = news.Favorite ? R.color.favorite_color_icon : R.color.black;


        holder.binding.ivFavorite.setColorFilter(context.getResources().getColor(favoriteColor));

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding binding;

        public ViewHolder(@NonNull NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface NewsListener{
        void onFavorite(News news);
    }

}
