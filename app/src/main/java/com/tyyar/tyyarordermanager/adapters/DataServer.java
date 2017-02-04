package com.tyyar.tyyarordermanager.adapters;

import com.tyyar.tyyarordermanager.model.Order;
import com.tyyar.tyyarordermanager.model.OrderItem;

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

        ArrayList<OrderItem> items = new ArrayList<OrderItem>() {{
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
            add(OrderItem.create(2, "sides", "1/4 standawidsh", "pleas no tomato", 5.50));
        }};

        ArrayList<Order> list = new ArrayList<Order>() {{
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
        ArrayList<Order> newO = new ArrayList<>();
        ArrayList<Order> inProg = new ArrayList<>();
        ArrayList<Order> comp = new ArrayList<>();

        for (Order order : list) {
            switch (order.orderStatus()) {
                case NEW:
                    newO.add(order);
                    break;
                case IN_PROGRESS:
                    inProg.add(order);
                    break;
                case COMPLECTED:
                    comp.add(order);
                    break;
            }
        }

        return new ArrayList<OrderSection>() {{
            add(new OrderSection(true, "NEW", newO.size()));
            for (Order order : newO) add(new OrderSection(order));
            add(new OrderSection(true, "IN_PROGRESS", inProg.size()));
            for (Order order : inProg) add(new OrderSection(order));
            add(new OrderSection(true, "COMPLECTED", comp.size()));
            for (Order order : comp) add(new OrderSection(order));
        }};
    }
}
