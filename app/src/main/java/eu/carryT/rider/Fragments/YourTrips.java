package eu.carryT.rider.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import eu.carryT.rider.R;

import eu.carryT.rider.Activities.MainActivity;


public class YourTrips extends Fragment {
    public static final String TAG = "YourTrips";
    TabWidget widget;
    ImageView backArrow;
    AppCompatActivity activity;
    Context context;
    View rootView;
    private FragmentTabHost tabHost;

    public YourTrips() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (AppCompatActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_your_trips, container, false);
        backArrow = (ImageView) rootView.findViewById(R.id.backArrow);
        tabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        widget = (TabWidget) rootView.findViewById(android.R.id.tabs);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, MainActivity.class));
            }
        });
        tabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("Tab1")) {
                    //destroy earth
                    tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                }
                if (tabId.equals("Tab2")) {
                    //destroy mars
                    tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

                }
            }
        });

        Bundle arg1 = new Bundle();
        arg1.putInt("Arg for Frag1", 1);
        tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator(getString(R.string.past)), PastTrips.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt("Arg for Frag2", 2);
        tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator(getString(R.string.upcoming)),
                OnGoingTrips.class, arg2);
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#ffffff"));
            // tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.BLACK);
        }
        return rootView;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
