package com.example.natureguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

=======
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,CustomAdapter.callback {
=======
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
    private DrawerLayout drawer;
    private ListView mainActivityListView;

    private FirebaseAuth mAuth;
    private DatabaseReference favLocationRef, userRef;

<<<<<<< HEAD

=======
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
    boolean doubleBackToExitPressedOnce = false;//click back twice to exit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main_page);
=======
        setContentView(R.layout.activity_main);
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
        Toolbar toolbar = findViewById(R.id.toolber);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
<<<<<<< HEAD
        View headerView = navigationView.getHeaderView(0);

        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainPage()).commit();
            navigationView.setCheckedItem(R.id.nav_main_page);
        }

=======
        navigationView.setNavigationItemSelectedListener(this);

>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAuth = FirebaseAuth.getInstance();
<<<<<<< HEAD

        final TextView headerUserName,headerUserEmail;

        headerUserName = ((TextView) headerView.findViewById(R.id.nav_header_userName));
        headerUserEmail = ((TextView) headerView.findViewById(R.id.nav_header_userEmail));

=======

        //connect to list view
        mainActivityListView = (ListView) findViewById(R.id.mainListView);
        //details to show
        final NatureLocation[] listToShow = new NatureLocation[]{
                new NatureLocation("נחל אלכסנדר", "נחל אלכסנדר", "נחל גדול באיזור חדרה עמק חפר", R.drawable.alexander, 32.386652, 34.892112),
                new NatureLocation("עכו", "עכו", "עַכּוֹ היא עיר במחוז הצפון בישראל, הגובלת מדרום בחופיו הצפוניים של מפרץ עכו וממערב בים התיכון. בשנת 2016 התגוררו בעיר כ-48,000 תושבים, כשני שלישים מהם יהודים. עכו היא אחת מערי הנמל העתיקות בעולם, ודברי ימיה המתועדים מתחילים בתקופת הברונזה הקדומה.", R.drawable.akko,32.922746, 35.068234),
                new NatureLocation("ג'ילבון", "ג'ילבון", "מסלול הג'ילבון יתאים תמיד, ובמיוחד רגע אחרי ששוקם אחרי שריפה: הוא גם יבש וגם רטוב, ויוכל לספק כל טיילן חובב צפון. ", R.drawable.jilbon, 33.046639, 35.667540),
                new NatureLocation("מכתש רמון", "מכתש רמון", "מכתש רמון הוא המכתש האירוזי הגדול בעולם. הוא מצוי בישראל ומהווה אחד מחמשת המכתשים שבנגב. ואחד מחמישים \"שמורות אור בינלאומית\" בעולם, נופו של מכתש רמון הוא ייחודי. על קצה המכתש מצויה העיירה מצפה רמון. אורכו של המכתש כ-40 ק\"מ, רוחבו המרבי כ-9 ק\"מ ועומקו המרבי כ-350 מטר. במזרח, מחולק המכתש על ידי הר ארדון לשתי בקעות: בקעת ארדון ובקעת מחמל.", R.drawable.alexander, 30.627331, 34.887882)
        };

        //CustomAdapter instance and connection to list view
        final CustomAdapter adapter = new CustomAdapter(MainActivity.this, listToShow);
        mainActivityListView.setAdapter(adapter);

>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
        //read from data base
        userRef = FirebaseDatabase.getInstance().getReference("Users").child(mAuth.getUid());
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstName = dataSnapshot.child("firstName").getValue(String.class);
                String lastName = dataSnapshot.child("lastName").getValue(String.class);
                String userEmail = dataSnapshot.child("email").getValue(String.class);
<<<<<<< HEAD
                headerUserName.setText(firstName + " " + lastName);
                headerUserEmail.setText(userEmail);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
=======
                ((TextView) findViewById(R.id.nav_header_userName)).setText(firstName + " " + lastName);
                ((TextView) findViewById(R.id.nav_header_userEmail)).setText(userEmail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_Favorites:
<<<<<<< HEAD
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Favorites()).commit();
=======
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                startActivity(new Intent(this, Favorites.class));
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
                break;
            case R.id.nav_logOut:
                mAuth.signOut();
                startActivity(new Intent(this, LoginPage.class));
                break;
<<<<<<< HEAD
            case R.id.nav_main_page:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainPage()).commit();
                break;
            case R.id.nav_add_location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddLocation()).commit();
                break;
            case R.id.nav_maps:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MapsActivity()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EditProfileActivity()).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //close app in two back button presses
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //in 2 sec it will turn back doubleBackToExitPressedOnce flag off
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void setLocation(String description, String name, double l, double l1) {
        MapsActivity mapsActivity = new MapsActivity();
        mapsActivity.leng1 = l;
        mapsActivity.leng2 = l1;
        mapsActivity.name = name;
        mapsActivity.Description = description;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mapsActivity).commit();
=======
            case R.id.nav_mainActivity:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_maps:
                startActivity(new Intent(this, MapsActivity.class));
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
    }

    //close app in two back button presses
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        }
        this.doubleBackToExitPressedOnce = true;
        //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //in 2 sec it will turn back doubleBackToExitPressedOnce flag off
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
