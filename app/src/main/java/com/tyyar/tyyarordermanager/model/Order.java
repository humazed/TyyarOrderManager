package com.tyyar.tyyarordermanager.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * User: YourPc
 * Date: 2/4/2017
 */

@AutoValue
public abstract class Order implements Parcelable {
    public abstract int orderNumber();

    public abstract String customerName();

    public abstract String pickUpTime();

    public abstract String driverName();

    public abstract OrderStatus orderStatus();

    public abstract List<OrderItem> items();

    public static Order create(int orderNumber, String customerName, String pickUpTime, String driverName, OrderStatus orderStatus, List<OrderItem> items) {
        return new AutoValue_Order(orderNumber, customerName, pickUpTime, driverName, orderStatus, items);
    }


}
