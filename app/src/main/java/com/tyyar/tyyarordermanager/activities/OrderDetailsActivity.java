package com.tyyar.tyyarordermanager.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.adapters.OrderDetailsAdapter;
import com.tyyar.tyyarordermanager.fragments.EditItemDialogFragment;
import com.tyyar.tyyarordermanager.fragments.SetPrepTimeDialogFragment;
import com.tyyar.tyyarordermanager.model.Order;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends AppCompatActivity {
    private static final String TAG = OrderDetailsActivity.class.getSimpleName();

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.accept_order_button) LinearLayout mAcceptOrderButton;
    @BindView(R.id.items_recyclerView) RecyclerView mItemsRecyclerView;
    @BindView(R.id.order_number_customer_name_textView) TextView mOrderNumberCustomerNameTextView;
    @BindView(R.id.items_count_pickup_time_textView) TextView mItemsCountPickupTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Order order = getIntent().getParcelableExtra(MainActivity.KEY_ORDER);

        mOrderNumberCustomerNameTextView.setText(getString(R.string.order_number_customer_name,
                order.orderNumber(), order.driverName()));
        mItemsCountPickupTimeTextView.setText(getString(R.string.items_count_pickup_time,
                order.items().size(), order.pickUpTime()));

        mItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mItemsRecyclerView.setAdapter(new OrderDetailsAdapter(order.items()));
        mItemsRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        mItemsRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showEditItemDialog();
            }
        });


        mAcceptOrderButton.setOnClickListener(v -> showPrepTimeDialog());

    }

    void showPrepTimeDialog() {

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        ft.commit();

        // Create and show the dialog.
        DialogFragment newFragment = SetPrepTimeDialogFragment.newInstance(1);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    void showEditItemDialog() {

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog2");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        ft.commit();

        // Create and show the dialog.
        DialogFragment newFragment = EditItemDialogFragment.newInstance("1");
        newFragment.show(getSupportFragmentManager(), "dialog2");
    }
}
