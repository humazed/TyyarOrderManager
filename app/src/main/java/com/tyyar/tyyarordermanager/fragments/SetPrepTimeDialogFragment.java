package com.tyyar.tyyarordermanager.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tyyar.tyyarordermanager.R;
import com.tyyar.tyyarordermanager.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SetPrepTimeDialogFragment extends DialogFragment {
    private static final String TAG = SetPrepTimeDialogFragment.class.getSimpleName();

    @BindView(R.id.confirm_button) TextView mConfirmButton;
    @BindView(R.id.sub_time_button) ImageView mSubTimeButton;
    @BindView(R.id.min_count_textView) TextView mMinCountTextView;
    @BindView(R.id.add_time_button) ImageView mAddTimeButton;
    @BindView(R.id.time_estimation_textView) TextView mTimeEstimationTextView;
    @BindView(R.id.cancel_button) TextView mCancelButton;

    private Unbinder unbinder;
    int mNum;
    private int mMinCount = 5;

    public static SetPrepTimeDialogFragment newInstance(int num) {
        SetPrepTimeDialogFragment f = new SetPrepTimeDialogFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_set_prep_time, container, false);
        unbinder = ButterKnife.bind(this, view);

        mConfirmButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), MainActivity.class)));
        mCancelButton.setOnClickListener(v -> dismiss());

        mAddTimeButton.setOnClickListener(v -> changeTime(mMinCount += 5));
        mSubTimeButton.setOnClickListener(v -> changeTime(mMinCount -= 5));

        return view;
    }

    private void changeTime(int change) {
        long now = System.currentTimeMillis();
        now += change * 60_000;

        mMinCountTextView.setText(getString(R.string.min_count, change));
        mTimeEstimationTextView.setText(DateFormat.format("h:mm a", now));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}