package com.nofi.submissionandroidpemula.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.fragment.WisataFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment pageContent = new WisataFragment();
    private String title = "Home";
    private String KEY_TITLE;
    private String KEY_FRAGMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.main_toolbar);
        final DrawerLayout drawerLayout = findViewById(R.id.main_drawer);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_navigation);
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()) {
                case R.id.menu_home:
                    pageContent = new WisataFragment();
                    title = "Home";
                    break;
                case R.id.menu_profil:
                    Toast.makeText(this, "Tunggu Sebentar .. Anda masuk ke menu profil saya", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, ProfilNofiActivity.class));
                    title = "My Profil";
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pageContent).commit();
            toolbar.setTitle(title);
            drawerLayout.closeDrawers();
            return true;
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pageContent).commit();
            toolbar.setTitle(title);
        } else {
            pageContent = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);
            title = savedInstanceState.getString(KEY_TITLE);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pageContent).commit();
            toolbar.setTitle(title);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_TITLE, title);
        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, pageContent);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_myprofil) {
            Toast.makeText(this, "Tunggu Sebentar .. Anda masuk ke menu profil saya", Toast.LENGTH_LONG).show();
            Intent mIntent = new Intent(MainActivity.this, ProfilNofiActivity.class);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }


}