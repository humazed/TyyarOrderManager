package com.tyyar.tyyarordermanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.activity_main) LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        UiUtils.showDrawer(this, mToolbar).setSelection(1, false);

    }

    @OnClick({R.id.new_order_container, R.id.in_progress_container})
    public void onClick(View view) {
        startActivity(new Intent(this, OrderDetailsActivity.class));
    }
}
