package com.tyyar.tyyarordermanager.adapters;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.model.Order;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tyyar.tyyarordermanager.model.OrderStatus.COMPLECTED;
import static com.tyyar.tyyarordermanager.model.OrderStatus.IN_PROGRESS;

public class OrderAdapter extends BaseSectionQuickAdapter<OrderSection, BaseViewHolder> {
    private static final String TAG = OrderAdapter.class.getSimpleName();

    @BindView(R.id.new_order_button) TextView mNewOrderButton;
    @BindView(R.id.order_number_textView) TextView mOrderNumberTextView;
    @BindView(R.id.customer_name_textView) TextView mCustomerNameTextView;
    @BindView(R.id.order_items_count_textView) TextView mOrderItemsCountTextView;
    @BindView(R.id.pickup_time_textView) TextView mPickupTimeTextView;
    @BindView(R.id.row_container) RelativeLayout mRowContainer;

    public OrderAdapter() {
        super(R.layout.row_new_order, R.layout.header_delivery_list, DataServer.getSampleWithSection());
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderSection item) {
        ButterKnife.bind(this, helper.convertView);
        Order order = item.getOrder();
        mOrderNumberTextView.setText(mContext.getString(R.string.order_number, order.orderNumber()));
        mCustomerNameTextView.setText(order.customerName());
        mOrderItemsCountTextView.setText(mContext.getString(R.string.order_items_count, order.items().size()));
        mPickupTimeTextView.setText(mContext.getString(R.string.order_pickup_time, order.pickUpTime()));

        if (order.orderStatus() == IN_PROGRESS || order.orderStatus() == COMPLECTED) {
            mNewOrderButton.setVisibility(View.GONE);
            mRowContainer.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        } else {
            mNewOrderButton.setVisibility(View.VISIBLE);
            mRowContainer.setBackgroundColor(mContext.getResources().getColor(R.color.order_card_green));
        }

    }

    @Override
    protected void convertHead(BaseViewHolder helper, final OrderSection item) {
        helper.setText(R.id.header_textView, item.header)
                .setText(R.id.count_textView, item.getCount() + "");

//        helper.setOnClickListener(R.id.more,
//                (View.OnClickListener) v ->
//                        Toast.makeText(mContext, item.header + "more..", Toast.LENGTH_LONG).show());
    }
}