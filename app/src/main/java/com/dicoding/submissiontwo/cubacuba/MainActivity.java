package com.dicoding.submissiontwo.cubacuba;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Fragment mainlayoutframe;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movie:
                    getSupportActionBar().setTitle(R.string.title_bar_movie);
                    mainlayoutframe = new MovieFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_construct, mainlayoutframe, mainlayoutframe.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_tv_show:
                    getSupportActionBar().setTitle(R.string.title_bar_tvshow    );
                    mainlayoutframe = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_construct, mainlayoutframe, mainlayoutframe.getClass().getSimpleName())
                            .commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if( savedInstanceState == null){
            navView.setSelectedItemId(R.id.navigation_movie);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_change_settings){
            Intent menuIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(menuIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
