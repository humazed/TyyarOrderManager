package com.tyyar.tyyarordermanager.adapters;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.tyyar.tyyarordermanager.model.Order;

public class OrderSection extends SectionEntity<Order> {
    private int mCount;
    private boolean isMore;
    private Order mOrder;

    public OrderSection(boolean isHeader, String header, int count) {
        super(isHeader, header);
        mCount = count;
    }

    public OrderSection(Order order) {
        super(order);
        mOrder = order;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public Order getOrder() {
        return mOrder;
    }

    public void setOrder(Order status) {
        mOrder = status;
    }
}