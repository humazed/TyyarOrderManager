package com.tyyar.tyyarordermanager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.adapters.DataServer;
import com.tyyar.tyyarordermanager.adapters.OrderAdapter;
import com.tyyar.tyyarordermanager.adapters.OrderSection;
import com.tyyar.tyyarordermanager.utils.DataUtils;
import com.tyyar.tyyarordermanager.utils.UiUtils;

import java.util.List;

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
        List<OrderSection> sectionsList = DataUtils.getSectionsList(DataServer.getOrders());
        OrderAdapter adapter = new OrderAdapter(sectionsList);
        mOrdersRecyclerView.setAdapter(adapter);

        mOrdersRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onSimpleItemClick " + sectionsList.get(position).getOrder());
            }
        });


    }

//    @OnClick({R.id.new_order_container, R.id.in_progress_container})
//    public void onClick(View view) {
//        startActivity(new Intent(this, OrderDetailsActivity.class));
//    }
}
