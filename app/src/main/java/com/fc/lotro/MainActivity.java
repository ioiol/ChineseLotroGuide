package com.fc.lotro;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fc.lotro.activity.BaseActivity;
import com.fc.lotro.fragment.GuideFragment;
import com.fc.lotro.fragment.ClassFragment;
import com.fc.lotro.fragment.OtherFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GuideFragment guideFragment = new GuideFragment();
    private ClassFragment classFragment = new ClassFragment();
    private OtherFragment otherFragment = new OtherFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.id_content, classFragment);
        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_guides) {
            //攻略
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.id_content, guideFragment);
            transaction.commit();
        } else if (id == R.id.nav_classes) {
            //职业
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.id_content, classFragment);
            transaction.commit();
        } else if (id == R.id.nav_others) {
            //其他
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.id_content, otherFragment);
            transaction.commit();
        } else if (id == R.id.nav_about) {
            //关于

        } else if (id == R.id.nav_share) {
            //分享

        } else if (id == R.id.nav_send) {
            //发送

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
