package co.edu.konradlorenz.joyzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ListView mListView = (ListView) findViewById(R.id.List_Event);
        ArrayList<Event> eventlist = new ArrayList<>();

        Event a = new Event("Rock Al Parque");
        eventlist.add(a);
        Event b = new Event("Jazz Al Parque");
        eventlist.add(b);
        Event c = new Event("HipHop Al Parque");
        eventlist.add(c);

        EventListAdapter adapter = new EventListAdapter(this, R.layout.adapter_event_view_layout, eventlist);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long i){
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Item one clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Item two clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Item three clicked...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mListView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id_item = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            Intent go_to_map = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(go_to_map);
        } else if (id == R.id.nav_profile) {
            Intent go_to_profile = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(go_to_profile);
        } else if (id == R.id.nav_login) {
            Intent go_to_login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(go_to_login);
        } else if (id == R.id.nav_create_event) {
            Intent go_to_create_event = new Intent(MainActivity.this, Create_EventActivity.class);
            startActivity(go_to_create_event);
        } else if (id == R.id.nav_detail_event) {
            Intent go_to_detail_event = new Intent(MainActivity.this, Detail_EventActivity.class);
            startActivity(go_to_detail_event);
        } else if (id == R.id.nav_ranking) {
            Intent go_to_ranking = new Intent(MainActivity.this, RankingActivity.class);
            startActivity(go_to_ranking);
        } else if (id == R.id.nav_settings) {
            Intent go_to_settings = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(go_to_settings);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
