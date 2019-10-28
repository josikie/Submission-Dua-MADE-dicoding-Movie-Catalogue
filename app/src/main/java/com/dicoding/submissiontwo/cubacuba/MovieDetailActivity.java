package com.dicoding.submissiontwo.cubacuba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvGenre, tvDesc;
    ImageView imgPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        tvTitle = findViewById(R.id.tv_title_detail);
        tvGenre = findViewById(R.id.tv_genre_detail);
        tvDesc = findViewById(R.id.tv_desc_detail);
        imgPhoto = findViewById(R.id.imgPhotoDetail);

        MovieModel movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvGenre.setText(movie.getGenre());
        tvDesc.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());



    }


}
