package com.example.mirimtabhost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ActionBarAndFragment extends AppCompatActivity {
    ActionBar.Tab tabPuppy, tabCat, tabHorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabPuppy = bar.newTab();
        tabPuppy.setText("강아지");
        tabPuppy.setTabListener(tabListener);
        bar.addTab(tabPuppy);

        tabCat = bar.newTab();
        tabCat.setText("고양이");
        tabCat.setTabListener(tabListener);
        bar.addTab(tabCat);

        tabHorse = bar.newTab();
        tabHorse.setText("말");
        tabHorse.setTabListener(tabListener);
        bar.addTab(tabHorse);
    }

    MyFragment myFrags[] = new MyFragment[3];

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            MyFragment myFrag = null;

            if(myFrags[tab.getPosition()] == null) {
                myFrag = new MyFragment();

                Bundle data = new Bundle();
                data.putString("tabName", tab.getText().toString());
                myFrag.setArguments(data);
                myFrags[tab.getPosition()] = myFrag;
            }else {
                myFrag = myFrags[tab.getPosition()];
            }

            ft.replace(android.R.id.content, myFrag);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    };

    public static class MyFragment extends Fragment {
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout linear = new LinearLayout(super.getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            linear.setLayoutParams(params);
            linear.setOrientation(LinearLayout.VERTICAL);
            if (tabName.equals("강아지"))
                linear.setBackgroundColor(Color.RED);

            if (tabName.equals("고양이"))
                linear.setBackgroundColor(Color.YELLOW);

            if (tabName.equals("말"))
                linear.setBackgroundColor(Color.BLUE);

            return linear;
        }
    }
}