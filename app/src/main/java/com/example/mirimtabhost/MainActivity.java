package com.example.mirimtabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecPuppy = tabHost.newTabSpec("Puppy").setIndicator("강아지");
        tabSpecPuppy.setContent(R.id.linear_puppy);
        tabHost.addTab(tabSpecPuppy);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("Cat").setIndicator("고양이");
        tabSpecCat.setContent(R.id.linear_cat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecHorse = tabHost.newTabSpec("Horse").setIndicator("말");
        tabSpecHorse.setContent(R.id.linear_horse);
        tabHost.addTab(tabSpecHorse);

        tabHost.setCurrentTab(0);
    }
}
