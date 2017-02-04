package com.tyyar.tyyarordermanager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.adapters.OrderAdapter;
import com.tyyar.tyyarordermanager.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.orders_recyclerView) RecyclerView mOrdersRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        UiUtils.showDrawer(this, mToolbar).setSelection(1, false);

        mOrdersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrderAdapter adapter = new OrderAdapter();

        mOrdersRecyclerView.setAdapter(adapter);

    }

//    @OnClick({R.id.new_order_container, R.id.in_progress_container})
//    public void onClick(View view) {
//        startActivity(new Intent(this, OrderDetailsActivity.class));
//    }
}
