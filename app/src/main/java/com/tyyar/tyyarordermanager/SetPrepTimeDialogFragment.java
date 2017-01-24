package com.tyyar.tyyarordermanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tyyar.tyyarordermanager.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetPrepTimeDialogFragment extends DialogFragment {
    int mNum;
    @BindView(R.id.confirm_button) TextView mConfirmButton;

    /**
     * Create a new instance of SetPrepTimeDialogFragment, providing "num"
     * as an argument.
     */
    public static SetPrepTimeDialogFragment newInstance(int num) {
        SetPrepTimeDialogFragment f = new SetPrepTimeDialogFragment();

        // Supply num input as an argument. 
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_set_prep_time, container, false);
        ButterKnife.bind(this, v);

        mConfirmButton.setOnClickListener(v1 -> startActivity(new Intent(getActivity(), MainActivity.class)));
        return v;
    }
} 