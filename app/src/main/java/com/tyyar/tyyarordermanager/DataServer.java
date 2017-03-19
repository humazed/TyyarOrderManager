package com.tyyar.tyyarordermanager;

import com.tyyar.tyyarordermanager.adapters.OrderAdapter;
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

    public static List<OrderAdapter.OrderSection> getSampleWithSection() {
        ArrayList<Order> list = getOrders();
        return DataUtils.getOrdersSectionedList(list);
    }

    public static ArrayList<Order> getOrders() {
        ArrayList<OrderItem> items = new ArrayList<OrderItem>() {{
            add(OrderItem.create(2, "main dishes", "Neapolitan Pizza", "pleas no tomato", 10.00));
//            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
//            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
        }};

        return new ArrayList<Order>() {{
            add(Order.create(1001, "Neapolitan Pizza", "12.30", "Mohammed H.", NEW, items));
            add(Order.create(1002, "Chicago Pizza", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1003, "Sicilian Pizza", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1004, "Pizza", "12.30", "mohammed", IN_PROGRESS, items));
            add(Order.create(1007, "Greek Pizza", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1008, "Sicilian Pizza", "12.30", "mohammed", COMPLECTED, items));
            add(Order.create(1009, "Pizza", "12.30", "mohammed", IN_PROGRESS, items));
            add(Order.create(1010, "Pizza", "12.30", "mohammed", IN_PROGRESS, items));
        }};
    }
}
