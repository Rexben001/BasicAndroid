package com.android.rexben.associateexam1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class TabbingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbing);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To create Tabbed Activity within your App
        //1. Create a new theme for your tha tabbed activity
//            <style name="AppThemes" parent="Theme.AppCompat.Light.DarkActionBar">
//        <!-- Customize your theme here. -->
//        <item name="colorPrimary">@color/colorPrimary</item>
//        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
//        <item name="colorAccent">@color/colorAccent</item>
//
//        <item name="windowActionBar">false</item>
//        <item name="windowNoTitle">true</item>
//    </style>

        //2. In your .xml file, add theme and the name of the theme should be the name of the newly created theme
        //3. In your manifest.xml, add android:theme="@style/AppTheme.NoActionBar" inside the tabbed activity


                TabLayout tabLayout = findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter pagerAdapter = new PAgerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
