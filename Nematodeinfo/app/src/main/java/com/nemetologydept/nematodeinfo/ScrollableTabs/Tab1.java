package com.nemetologydept.nematodeinfo.ScrollableTabs;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.nemetologydept.nematodeinfo.R;
import com.nemetologydept.nematodeinfo.settings;

/**
 * Created by Weirdo on 15-06-2016.
 */
public class Tab1 extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tab1, container, false);


        return v;

    }


}
