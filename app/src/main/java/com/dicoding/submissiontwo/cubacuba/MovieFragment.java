package com.dicoding.submissiontwo.cubacuba;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    String[] dataTitle;
    String[] dataGenre;
    String[] dataDesc;
    TypedArray dataImg;
    private ArrayList<MovieModel> listMovie = new ArrayList<>();
    private ListMovieAdapter adapter;

    private RecyclerView rvMovie;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);


        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        showRecyclerList();

        return view;
    }


    private void showRecyclerList(){

        dataTitle = getResources().getStringArray(R.array.item_data_title);
        dataGenre = getResources().getStringArray(R.array.item_data_genre);
        dataDesc = getResources().getStringArray(R.array.item_data_desc);
        dataImg = getResources().obtainTypedArray(R.array.item_data_photo);

        for(int i = 0; i < dataTitle.length; i++){
            MovieModel movieModel = new MovieModel();
            movieModel.setTitle(dataTitle[i]);
            movieModel.setGenre(dataGenre[i]);
            movieModel.setDescription(dataDesc[i]);
            movieModel.setPhoto(dataImg.getResourceId(i, -1));
            listMovie.add(movieModel);
        }

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMovieAdapter movieAdapter = new ListMovieAdapter(getActivity(), listMovie);
        rvMovie.setAdapter(movieAdapter);




    }




}
