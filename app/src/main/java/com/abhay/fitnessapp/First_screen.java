package com.abhay.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First_screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    TextView textView;
  FirebaseUser user;
  FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        Toolbar toolbar=findViewById(R.id.tollbar);
        setSupportActionBar(toolbar);
        textView=findViewById(R.id.emailtext);

        mAuth=FirebaseAuth.getInstance();

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        user=mAuth.getCurrentUser();

        textView=findViewById(R.id.emailtext);

        drawerLayout=findViewById(R.id.drawer_layout);



//        String name=user.getDisplayName();
        //textView.setText(name);

//        textView.setText(email);
        ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.home);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new About_us()).commit();
                break;
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "this is working", Toast.LENGTH_SHORT).show();

                 FirebaseAuth.getInstance().signOut();

                Intent intent=new Intent(getApplicationContext(),Login_page.class);
                startActivity(intent);

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}