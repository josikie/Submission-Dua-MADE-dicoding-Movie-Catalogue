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

import static com.dicoding.submissiontwo.cubacuba.TvShowDetailActivity.EXTRA_TVSHOW;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ListViewHolder> {
    private ArrayList<TvShowModel> listTvShow;
    Context contexttvshow;

    public TvShowAdapter(Context context, ArrayList<TvShowModel> list){
        this.listTvShow = list;
        this.contexttvshow = context;
    }



    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_tvshow, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvShowAdapter.ListViewHolder holder, int position) {
        final TvShowModel tvShowModel = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShowModel.getImgTvShow())
                .apply(new RequestOptions())
                .into(holder.imgPhotoTvShow);
        holder.tvTitleTvShow.setText(tvShowModel.getTitleTvShow());
        holder.tvGenreTvShow.setText(tvShowModel.getGenreTvShow());
        holder.tvDescriptionTvShow.setText(tvShowModel.getDescTvShow());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), listTvShow.get(holder.getAdapterPosition()).getTitleTvShow(), Toast.LENGTH_SHORT).show();
                Intent intentt = new Intent(contexttvshow, TvShowDetailActivity.class);
                intentt.putExtra(EXTRA_TVSHOW, tvShowModel);
                contexttvshow.startActivity(intentt);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoTvShow;
        TextView tvTitleTvShow, tvGenreTvShow, tvDescriptionTvShow;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoTvShow = itemView.findViewById(R.id.item_photo_tvshow);
            tvTitleTvShow = itemView.findViewById(R.id.tv_item_title_tvshow);
            tvGenreTvShow = itemView.findViewById(R.id.tv_item_genre_tvshow);
            tvDescriptionTvShow = itemView.findViewById(R.id.tv_item_description_tvshow);
        }
    }


}
