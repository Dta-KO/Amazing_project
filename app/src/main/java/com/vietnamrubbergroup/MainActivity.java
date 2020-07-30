package com.vietnamrubbergroup;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.vietnamrubbergroup.adapter.ExpandableListAdapter;
import com.vietnamrubbergroup.databinding.ActivityMainBinding;
import com.vietnamrubbergroup.model.MenuModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ExpandableListAdapter expandableListAdapter;
    private ExpandableListView expandableListView;
    private List<MenuModel> parentList = new ArrayList<>();
    private HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setToolBar();
        setFloatBtn();
        setNavigation();
        generateMenuData();
        setExpandableListView();

    }

    private void setToolBar() {
        Toolbar toolbar = binding.appBarMain.toolbar;
        setSupportActionBar(toolbar);
    }

    private void setFloatBtn() {
        FloatingActionButton fab = binding.appBarMain.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setNavigation() {
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder()
                .setOpenableLayout(drawer)
                .build();
        navigationView.setNavigationItemSelectedListener(this);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        setHeaderDrawer();
        setExpandableListView();
    }
    private void generateMenuData(){
        //add chart to menu
        MenuModel model = new MenuModel(R.string.menu_chart,R.id.nav_chart,false,true);
        parentList.add(model);
        if(!model.hasChildren){
            childList.put(model,null);
        }
        //add reporting to menu
        model = new MenuModel(R.string.menu_reporting,0,true,true);
        parentList.add(model);
        List<MenuModel> childModelList = new ArrayList<>();
        //add reporting 1
        MenuModel childModel = new MenuModel(R.string.menu_reporting_1,R.id.nav_reporting,false,false);
        childModelList.add(childModel);
        //add reporting 2
        childModel = new MenuModel(R.string.menu_reporting_2,R.id.nav_reporting,false,false);
        childModelList.add(childModel);
        //add reporting 3
        childModel = new MenuModel(R.string.menu_reporting_3,R.id.nav_reporting,false,false);
        childModelList.add(childModel);
        //add reporting 4
        childModel = new MenuModel(R.string.menu_reporting_4,R.id.nav_reporting,false,false);
        childModelList.add(childModel);
        //add reporting 5
        childModel = new MenuModel(R.string.menu_reporting_5,R.id.nav_reporting,false,false);
        childModelList.add(childModel);

        if(model.hasChildren){
            childList.put(model,childModelList);
        }
        childModelList = new ArrayList<>();
        model = new MenuModel(R.string.menu_send_report,0,true,true);
        parentList.add(model);
        //add form report 1
        childModel = new MenuModel(R.string.menu_send_report_1,R.id.nav_send_report,false,false);
        childModelList.add(childModel);
        //add form report 2
        childModel = new MenuModel(R.string.menu_send_report_2,R.id.nav_send_report,false,false);
        childModelList.add(childModel);
        //add form report 3
        childModel = new MenuModel(R.string.menu_send_report_3,R.id.nav_send_report,false,false);
        childModelList.add(childModel);

        if(model.hasChildren){
            childList.put(model,childModelList);
        }


    }

    private void setExpandableListView() {
        expandableListView = binding.expandableListView;
        expandableListAdapter = new ExpandableListAdapter(this,parentList,childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener((expandableListView1, view, parentPosition, id) -> {
            if (parentList.get(parentPosition).isGroup) {
                if (!parentList.get(parentPosition).hasChildren) {
                    //transition fragment
                    
                    onBackPressed();
                }
            }

            return false;
        });
        expandableListView.setOnChildClickListener((expandableListView1, view, parentPosition, childPosition, id) -> {
            if (childList.get(parentList.get(parentPosition)) != null) {
                MenuModel model = childList.get(parentList.get(parentPosition)).get(childPosition);
                if (model.idFragment > 0) {
                    //transition fragment

                    onBackPressed();
                }
            }

            return false;
        });


    }

    private void setHeaderDrawer(){
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;
    }
}