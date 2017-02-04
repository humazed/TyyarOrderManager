package com.tyyar.tyyarordermanager.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * User: YourPc
 * Date: 2/5/2017
 */

@AutoValue
public abstract class OrderItem implements Parcelable {
    public abstract int count();

    public abstract String category();

    public abstract String name();

    public abstract String specialInstructions();

    public abstract double price();

    public static OrderItem create(int count, String category, String name, String specialInstructions, double price) {
        return new AutoValue_OrderItem(count, category, name, specialInstructions, price);
    }


}
