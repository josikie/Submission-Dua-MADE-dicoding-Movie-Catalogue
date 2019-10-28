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
public class TvShowFragment extends Fragment {
    private String[] dataTitleTvShow;
    private String[] dataGenreTvShow;
    private String[] dataDescTvShow;
    private TypedArray dataImgTvShow;
    private ArrayList<TvShowModel> listTv = new ArrayList<>();
    private RecyclerView rvTvShow;
    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);

        showRecyclerList();

        return view;
    }

    private void showRecyclerList(){
        dataTitleTvShow = getResources().getStringArray(R.array.item_data_title_tvshow);
        dataGenreTvShow = getResources().getStringArray(R.array.item_data_genre_tvshow);
        dataDescTvShow = getResources().getStringArray(R.array.item_data_desc_tshow);
        dataImgTvShow = getResources().obtainTypedArray(R.array.item_data_photo_tvshow);

        for(int i = 0; i <dataTitleTvShow.length; i++){
            TvShowModel  tvShowModel = new TvShowModel();
            tvShowModel.setTitleTvShow(dataTitleTvShow[i]);
            tvShowModel.setGenreTvShow(dataGenreTvShow[i]);
            tvShowModel.setDescTvShow(dataDescTvShow[i]);
            tvShowModel.setImgTvShow(dataImgTvShow.getResourceId(i, -1));
            listTv.add(tvShowModel);
        }

        rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter listTvShowAdapter= new TvShowAdapter(getActivity(),listTv);
        rvTvShow.setAdapter(listTvShowAdapter);

    }

}
