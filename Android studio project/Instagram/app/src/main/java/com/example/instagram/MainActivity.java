package com.example.instagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.instagram.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.instagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);



        Toolbar toolbar=findViewById(R.id.toolbar);
        set
//      setSupportActionBar(toolbar);

        ImageView cameraImage=toolbar.findViewById(R.id.camera);

        cameraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Camera button is clicked", Toast.LENGTH_SHORT).show();
            }
        });

  navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          if(item.getItemId()==R.id.home){
              HomeFragment homeFragment=new HomeFragment();
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.nav_host_fragment_activity_main,homeFragment);
              transaction.commit();

          } else if (item.getItemId()==R.id.search_bar) {
              Search searchFragment=new Search();
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.nav_host_fragment_activity_search,searchFragment);
              transaction.commit();

          }
          return true;
      }
  });





    }

}