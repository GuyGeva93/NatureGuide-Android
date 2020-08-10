package com.example.natureguide;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
=======
import android.view.MenuItem;
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
<<<<<<< HEAD
import androidx.annotation.Nullable;
=======
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
<<<<<<< HEAD
import androidx.fragment.app.Fragment;
=======
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

<<<<<<< HEAD
public class Favorites extends Fragment {
=======
public class Favorites extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7

    private DrawerLayout drawer;
    private NatureLocation[] listToShow;
    private ListView favoritesListView;
    //data base ref
    FirebaseDatabase database;
    DatabaseReference favLocationRef, userRef;
    //firebase auth user
    private FirebaseAuth mAuth;
    //nl list
    ArrayList<NatureLocation> nlList;
    NatureLocation[] listOfPlaces;
    CustomAdapter adapter;

<<<<<<< HEAD
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_favorites, container, false);
        super.onCreate(savedInstanceState);
        //connect to view
        favoritesListView = (ListView) view.findViewById(R.id.favoritesListView);
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolber);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //connect to view
        favoritesListView = (ListView) findViewById(R.id.favoritesListView);
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
        //details to show
        nlList = new ArrayList<NatureLocation>();
        // Read from the database
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        favLocationRef = database.getReference("Users").child(mAuth.getUid()).child("favLocation");
        userRef = database.getReference("Users").child(mAuth.getUid());

<<<<<<< HEAD
        listOfPlaces = new NatureLocation[]{new NatureLocation("אין עדיין דברים במועדפים", "אין עדיין דברים במועדפים", "אין עדיין דברים במועדפים", "אין תמונה", 30.627331, 34.887882)};

        //CustomAdapter instance and connection to list view
        adapter = new CustomAdapter(getActivity(), listOfPlaces,true);
=======
        listOfPlaces = new NatureLocation[]{new NatureLocation("אין עדיין דברים במועדפים", "אין עדיין דברים במועדפים", "אין עדיין דברים במועדפים", R.drawable.border, 30.627331, 34.887882)};

        //CustomAdapter instance and connection to list view
        adapter = new CustomAdapter(Favorites.this, listOfPlaces);
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
        favoritesListView.setAdapter(adapter);


        //Read from the database
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    NatureLocation temp = ds.getValue(NatureLocation.class);
                    nlList.add(temp);
                }
<<<<<<< HEAD
                adapter = new CustomAdapter(getActivity(), nlList.toArray(new NatureLocation[nlList.size()]),true);
                favoritesListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
=======
                listOfPlaces = new NatureLocation[nlList.size()];
                for (int i = 0; i < listOfPlaces.length; i++) {
                    listOfPlaces[i] = new NatureLocation(nlList.get(i).getName(), nlList.get(i).getTitle(), nlList.get(i).getDescription(), nlList.get(i).getImage(), nlList.get(i).getLatLangv(), nlList.get(i).getLatLangv1());
                }
                adapter = new CustomAdapter(Favorites.this, listOfPlaces);
                favoritesListView.setAdapter(adapter);
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
<<<<<<< HEAD
                Toast.makeText(getActivity(), "Failed to read value", Toast.LENGTH_SHORT).show();
            }
        };
        favLocationRef.addListenerForSingleValueEvent(valueEventListener);
        return view;
=======
                Toast.makeText(Favorites.this, "Failed to read value", Toast.LENGTH_SHORT).show();
            }

        };
        favLocationRef.addListenerForSingleValueEvent(valueEventListener);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstName = dataSnapshot.child("firstName").getValue(String.class);
                String lastName = dataSnapshot.child("lastName").getValue(String.class);
                String userEmail = dataSnapshot.child("email").getValue(String.class);
                ((TextView) findViewById(R.id.nav_header_userName)).setText(firstName + " " + lastName);
                ((TextView) findViewById(R.id.nav_header_userEmail)).setText(userEmail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_Favorites:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                startActivity(new Intent(this, Favorites.class));
                break;
            case R.id.nav_logOut:
                mAuth.signOut();
                startActivity(new Intent(this, LoginPage.class));
                break;
            case R.id.nav_mainActivity:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
    }
}