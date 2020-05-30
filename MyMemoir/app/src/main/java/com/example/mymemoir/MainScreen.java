package com.example.mymemoir;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.mymemoir.fragment.Maps;
import com.example.mymemoir.fragment.MovieMemoir;
import com.example.mymemoir.fragment.MovieSearch;
import com.example.mymemoir.fragment.HomeFragment;
import com.example.mymemoir.fragment.Reports;
import com.example.mymemoir.fragment.ViewFragment;
import com.example.mymemoir.fragment.Watchlist;
import com.example.mymemoir.viewmodel.WatchListViewModel;
import com.google.android.material.navigation.NavigationView;

/**
 * @author LiJinFeng
 */
public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    public static WatchListViewModel watchListViewModel;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.movieSearch:
                replaceFragment(new MovieSearch());
                break;
            case R.id.movieMemoir:
                replaceFragment(new MovieMemoir());
                break;
            case R.id.watchlist:
                replaceFragment(new Watchlist());
                break;
            case R.id.reports:
                replaceFragment(new Reports());
                break;
            case R.id.maps:
                replaceFragment(new Maps());
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void replaceFragment(Fragment nextFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, nextFragment);
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);


        watchListViewModel = new ViewModelProvider(this).get(WatchListViewModel.class);
        watchListViewModel.initalizeVars(getApplication());
        // adding the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nv);
        //
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // these two lines of code show the navicon drawer icon top left hand side
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}

