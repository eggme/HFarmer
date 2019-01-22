package com.honam.kyyeto.hfarmers;

/**
 * Created by kyyet on 2019-01-22.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavigationDrawerFragment extends Fragment {

    // private RecyclerView recyclerView;
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearenDrawer;
    private boolean mFromSavedInstanceState;

    private View containerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearenDrawer = Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER , "false"));
        if(savedInstanceState!=null){
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        //recyclerView = (RecyclerView)v.findViewById(R.id.drawerList);
        return v;
    }


    public void setUp (int fragmentId , DrawerLayout drawerLayout , Toolbar toolbar) {
        containerView=getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout , toolbar , R.string.drawer_open , R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                if(!mUserLearenDrawer){
                    mUserLearenDrawer = true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER , mUserLearenDrawer+"");
                }
                getActivity().invalidateOptionsMenu();
                syncState();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
                syncState();
            }


            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                mDrawerToggle.onConfigurationChanged(newConfig);
            }
        };
        if(!mUserLearenDrawer && !mFromSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void saveToPreferences(Context context, String preferenceName , String preferenceValue){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME , Context.MODE_PRIVATE);
        SharedPreferences.Editor editer = sharedPreferences.edit();
        editer.putString(preferenceName,preferenceValue);
        editer.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName , String defaultValue){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME , Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName,defaultValue);
    }



}