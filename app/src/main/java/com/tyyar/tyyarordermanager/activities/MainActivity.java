package com.tyyar.tyyarordermanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.adapters.DataServer;
import com.tyyar.tyyarordermanager.adapters.OrderAdapter;
import com.tyyar.tyyarordermanager.model.Order;
import com.tyyar.tyyarordermanager.utils.DataUtils;
import com.tyyar.tyyarordermanager.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY_ORDER = "order";

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.orders_recyclerView) RecyclerView mOrdersRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        UiUtils.showDrawer(this, mToolbar).setSelection(1, false);

        ArrayList<Order> orders = DataServer.getOrders();

        mOrdersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<OrderAdapter.OrderSection> sectionsList = DataUtils.getSectionsList(orders);
        OrderAdapter adapter = new OrderAdapter(sectionsList);
        mOrdersRecyclerView.setAdapter(adapter);

        mOrdersRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, OrderDetailsActivity.class);
                intent.putExtra(KEY_ORDER, orders.get(position));
                startActivity(intent);

            }
        });


    }

//    @OnClick({R.id.new_order_container, R.id.in_progress_container})
//    public void onClick(View view) {
//        startActivity(new Intent(this, OrderDetailsActivity.class));
//    }
}
