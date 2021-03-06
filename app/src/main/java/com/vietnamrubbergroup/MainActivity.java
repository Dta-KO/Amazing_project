package com.vietnamrubbergroup;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.vietnamrubbergroup.adapter.ExpandableListAdapter;
import com.vietnamrubbergroup.databinding.ActivityMainBinding;
import com.vietnamrubbergroup.model.MenuModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private List<MenuModel> parentList = new ArrayList<>();
    private HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setToolBar();
        setNavigation();
        generateMenuData();
        setHeaderDrawer();
        setExpandableListView();

    }

    private void setToolBar() {
        Toolbar toolbar = binding.appBarMain.toolbar;
        setSupportActionBar(toolbar);
    }

    private void setNavigation() {
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_chart, R.id.nav_reporting, R.id.nav_send_report)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //generate data for menu drawer navigation
    private void generateMenuData() {
        //add chart to menu
        MenuModel model = new MenuModel(R.string.menu_chart, R.id.nav_chart, false, true, R.drawable.ic_chart);
        parentList.add(model);
        if (!model.hasChildren) {
            childList.put(model, null);
        }
        //add reporting to menu
        model = new MenuModel(R.string.menu_reporting, 0, true, true, R.drawable.reporting);
        parentList.add(model);
        List<MenuModel> childModelList = new ArrayList<>();
        //add reporting 1
        MenuModel childModel = new MenuModel(R.string.menu_reporting_1, R.id.nav_reporting, false, false, 0);
        childModelList.add(childModel);
        //add reporting 2
        childModel = new MenuModel(R.string.menu_reporting_2, R.id.nav_reporting, false, false, 0);
        childModelList.add(childModel);
        //add reporting 3
        childModel = new MenuModel(R.string.menu_reporting_3, R.id.nav_reporting, false, false, 0);
        childModelList.add(childModel);
        //add reporting 4
        childModel = new MenuModel(R.string.menu_reporting_4, R.id.nav_reporting, false, false, 0);
        childModelList.add(childModel);
        //add reporting 5
        childModel = new MenuModel(R.string.menu_reporting_5, R.id.nav_reporting, false, false, 0);
        childModelList.add(childModel);

        if (model.hasChildren) {
            childList.put(model, childModelList);
        }
        childModelList = new ArrayList<>();
        model = new MenuModel(R.string.menu_send_report, 0, true, true, R.drawable.send_report);
        parentList.add(model);
        //add form report 1
        childModel = new MenuModel(R.string.menu_send_report_1, R.id.nav_send_report, false, false, 0);
        childModelList.add(childModel);
        //add form report 2
        childModel = new MenuModel(R.string.menu_send_report_2, R.id.nav_send_report, false, false, 0);
        childModelList.add(childModel);
        //add form report 3
        childModel = new MenuModel(R.string.menu_send_report_3, R.id.nav_send_report, false, false, 0);
        childModelList.add(childModel);

        if (model.hasChildren) {
            childList.put(model, childModelList);
        }


    }

    //set menu for drawer navigation
    private void setExpandableListView() {
        ExpandableListView expandableListView = binding.expandableListView;
        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(this, parentList, childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener((expandableListView1, view, parentPosition, id) -> {
            if (parentList.get(parentPosition).isGroup) {
                if (!parentList.get(parentPosition).hasChildren) {
                    //transition fragment
                    navController.navigate(parentList.get(parentPosition).idFragment);
                    mAppBarConfiguration.getOpenableLayout().close();
                }
            }

            return false;
        });
        expandableListView.setOnChildClickListener((expandableListView1, view, parentPosition, childPosition, id) -> {
            if (childList.get(parentList.get(parentPosition)) != null) {
                MenuModel model = childList.get(parentList.get(parentPosition)).get(childPosition);
                if (model.idFragment > 0) {
                    //transition fragment
                    navController.navigate(model.idFragment);
                    mAppBarConfiguration.getOpenableLayout().close();
                }
            }

            return false;
        });


    }

    private void changeToFragment(int idFragment) {

    }

    //set header drawer navigation
    private void setHeaderDrawer() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}