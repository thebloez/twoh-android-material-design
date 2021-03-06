package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Hafizh Herdi on 7/23/2015.
 */
public class NavigationViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupToolbar();
        navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(NavigationViewActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_my_profile:
                        Toast.makeText(NavigationViewActivity.this, "My profile clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_settings:
                        Toast.makeText(NavigationViewActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                        return true;

                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // set toolbar ke dalam support action bar
        setSupportActionBar(toolbar);

        // enable home button untuk navigasi
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mengeset icon untuk home button Toolbar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        // mengeset title/nama aplikasi
        getSupportActionBar().setTitle("TWOH's Engineering");

        // mengeset subtitle
        getSupportActionBar().setSubtitle("Tutorial Material Design");

        // set logo toolbar
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
    }
}
