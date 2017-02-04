package com.tyyar.tyyarordermanager.adapters;

import com.tyyar.tyyarordermanager.model.Order;
import com.tyyar.tyyarordermanager.model.OrderItem;
import com.tyyar.tyyarordermanager.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import static com.tyyar.tyyarordermanager.model.OrderStatus.COMPLECTED;
import static com.tyyar.tyyarordermanager.model.OrderStatus.IN_PROGRESS;
import static com.tyyar.tyyarordermanager.model.OrderStatus.NEW;

/**
 * User: YourPc
 * Date: 2/4/2017
 */
public class DataServer {

    public static List<OrderSection> getSampleWithSection() {
        ArrayList<Order> list = getOrders();
        return DataUtils.getSectionsList(list);
    }

    public static ArrayList<Order> getOrders() {
        ArrayList<OrderItem> items = new ArrayList<OrderItem>() {{
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
        }};

        return new ArrayList<Order>() {{
            add(Order.create(1001, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1002, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1003, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1004, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1005, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1006, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1007, "lallala", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1008, "lallala", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1009, "lallala", "12.30", "mohammed", IN_PROGRESS, items));
            add(Order.create(1010, "lallala", "12.30", "mohammed", IN_PROGRESS, items));
            add(Order.create(1011, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1012, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1013, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1014, "lallala", "12.30", "mohammed", NEW, items));
            add(Order.create(1015, "lallala", "12.30", "mohammed", NEW, items));
        }};
    }
}
