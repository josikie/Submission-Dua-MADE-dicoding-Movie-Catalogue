package com.dicoding.submissiontwo.cubacuba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TvShowDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    TextView tvTitleTV, tvGenreTV, tvDescTV;
    ImageView imgPhotoTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        tvTitleTV = findViewById(R.id.tv_title_detailTV);
        tvGenreTV = findViewById(R.id.tv_genre_detailTV);
        tvDescTV = findViewById(R.id.tv_desc_detailTV);
        imgPhotoTV = findViewById(R.id.imgPhotoDetailTV);

        TvShowModel tvShowModel =  getIntent().getParcelableExtra(EXTRA_TVSHOW);

        tvTitleTV.setText(tvShowModel.getTitleTvShow());
        tvGenreTV.setText(tvShowModel.getGenreTvShow());
        tvDescTV.setText(tvShowModel.getDescTvShow());
        imgPhotoTV.setImageResource(tvShowModel.getImgTvShow());

    }
}
