package com.tyyar.tyyarordermanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.microsoft.windowsazure.notifications.NotificationsManager;
import com.tyyar.tyyarordermanager.DataServer;
import com.tyyar.tyyarordermanager.MyHandler;
import com.tyyar.tyyarordermanager.NotificationSettings;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.adapters.OrderAdapter;
import com.tyyar.tyyarordermanager.model.Order;
import com.tyyar.tyyarordermanager.notification.RegistrationIntentService;
import com.tyyar.tyyarordermanager.utils.DataUtils;
import com.tyyar.tyyarordermanager.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tyyar.tyyarordermanager.activities.LoginActivity.KEY_FROM_LOGIN;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY_ORDER = "order";

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.orders_recyclerView) RecyclerView mOrdersRecyclerView;

    public static MainActivity mainActivity;
    public static Boolean isVisible = false;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        UiUtils.showDrawer(this, mToolbar).setSelection(1, false);
        setupNotification();

        // TODO: 3/25/2017 replace it with check if there is a loged in user
        if (!getIntent().getBooleanExtra(KEY_FROM_LOGIN, false)) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        ArrayList<Order> orders = DataServer.getOrders();

        mOrdersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<OrderAdapter.OrderSection> sectionsList = DataUtils.getOrdersSectionedList(orders);
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

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported by Google Play Services.");
                ToastNotify("This device is not supported by Google Play Services.");
                finish();
            }
            return false;
        }
        return true;
    }

    public void registerWithNotificationHubs() {
        if (checkPlayServices()) {
            // Start IntentService to register this application with FCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }

    public void ToastNotify(final String notificationMessage) {
        runOnUiThread(() -> {
            Toast.makeText(MainActivity.this, notificationMessage, Toast.LENGTH_LONG).show();
//            TextView helloText = (TextView) findViewById(R.id.text_hello);
//            helloText.setText(notificationMessage);
            Toast.makeText(MainActivity.this, "notificationMessage: " + notificationMessage, Toast.LENGTH_LONG).show();
            Log.d(TAG, "ToastNotify " + "notificationMessage: " + notificationMessage);
        });
    }

    private void setupNotification() {
        mainActivity = this;
        NotificationsManager.handleNotifications(this, NotificationSettings.SenderId, MyHandler.class);
        registerWithNotificationHubs();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

//    @OnClick({R.id.new_order_container, R.id.in_progress_container})
//    public void onClick(View view) {
//        startActivity(new Intent(this, OrderDetailsActivity.class));
//    }
}
