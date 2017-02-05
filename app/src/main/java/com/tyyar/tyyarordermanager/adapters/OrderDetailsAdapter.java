package com.tyyar.tyyarordermanager.adapters;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.model.OrderItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsAdapter extends BaseQuickAdapter<OrderItem, BaseViewHolder> {
    private static final String TAG = OrderDetailsAdapter.class.getSimpleName();

    @BindView(R.id.order_name_container) LinearLayout mOrderNameContainer;
    @BindView(R.id.item_category_textView) TextView mItemCategoryTextView;
    @BindView(R.id.item_quantity_textView) TextView mItemQuantityTextView;
    @BindView(R.id.item_name_textView) TextView mItemNameTextView;

    @BindView(R.id.special_instructions_container) RelativeLayout mSpecialInstructionsContainer;
    @BindView(R.id.item_price_textView) TextView mItemPriceTextView;
    @BindView(R.id.special_instructions_title_textView) TextView mSpecialInstructionsTitleTextView;
    @BindView(R.id.special_instructions_textView) TextView mSpecialInstructionsTextView;

    @BindView(R.id.order_option_container) RelativeLayout mOrderOptionContainer;
    @BindView(R.id.options_title_textView) TextView mOptionsTitleTextView;
    @BindView(R.id.option_textView) TextView mOptionTextView;
    @BindView(R.id.option_price_textView) TextView mOptionPriceTextView;

    public OrderDetailsAdapter(List<OrderItem> items) {
        super(R.layout.row_order_details, items);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, OrderItem item) {
        ButterKnife.bind(this, viewHolder.getConvertView());
        mItemCategoryTextView.setText(item.category());
        mItemQuantityTextView.setText("1");
        mItemNameTextView.setText(item.name());
        mItemPriceTextView.setText(mContext.getString(R.string.price_in_pound, item.price()));
        mSpecialInstructionsTextView.setText(item.specialInstructions());


        viewHolder.setText(R.id.item_name_textView, item.category());
//                .addOnClickListener(R.id.sub_textView_1)
//                .addOnClickListener(R.id.sub_textView_2);
    }
}