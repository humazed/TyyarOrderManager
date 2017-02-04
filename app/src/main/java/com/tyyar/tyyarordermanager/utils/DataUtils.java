package com.tyyar.tyyarordermanager.utils;

import com.tyyar.tyyarordermanager.adapters.OrderSection;
import com.tyyar.tyyarordermanager.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * User: YourPc
 * Date: 2/5/2017
 */

public class DataUtils {

    public static List<OrderSection> getSectionsList(List<Order> orders) {
        ArrayList<Order> newO = new ArrayList<>();
        ArrayList<Order> inProg = new ArrayList<>();
        ArrayList<Order> comp = new ArrayList<>();

        for (Order order : orders) {
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
