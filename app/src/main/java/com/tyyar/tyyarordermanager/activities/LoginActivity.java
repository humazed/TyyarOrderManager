package com.tyyar.tyyarordermanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tyyar.tyyarordermanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    public static final String KEY_FROM_LOGIN = "from_login";

    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.email_editText) AutoCompleteTextView mEmailEditText;
    @BindView(R.id.password_editText) EditText mPasswordEditText;
    @BindView(R.id.login_form) LinearLayout mLoginForm;
    @BindView(R.id.login_button) TextView mLoginButton;
    @BindView(R.id.learn_more_textView) TextView mLearnMoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(v -> {
            mProgressBar.setVisibility(View.VISIBLE);

        });

        mLearnMoreTextView.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(KEY_FROM_LOGIN, true);
            startActivity(intent);
        });
    }
}
