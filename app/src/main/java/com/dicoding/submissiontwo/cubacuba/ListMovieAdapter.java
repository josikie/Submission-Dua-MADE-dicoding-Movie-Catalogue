package com.dicoding.submissiontwo.cubacuba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.dicoding.submissiontwo.cubacuba.MovieDetailActivity.EXTRA_MOVIE;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {
    private ArrayList<MovieModel> listMovie;
    Context contextmovie;



    ListMovieAdapter(Context context, ArrayList<MovieModel> list){
        this.contextmovie = context;
        this.listMovie = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_movie, viewGroup, false);
        return new ListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final MovieModel movieModel = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movieModel.getPhoto())
                .apply(new RequestOptions())
                .into(holder.imgPhoto);
        holder.tvTitle.setText(movieModel.getTitle());
        holder.tvGenre.setText(movieModel.getGenre());
        holder.tvDescription.setText(movieModel.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), listMovie.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(contextmovie, MovieDetailActivity.class);
                intent.putExtra(EXTRA_MOVIE, movieModel);
                contextmovie.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvGenre, tvDescription;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

}
