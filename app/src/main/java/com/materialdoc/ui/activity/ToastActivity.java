package com.materialdoc.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.materialdoc.R;

public class ToastActivity extends AppCompatActivity {

    private Toast mToast;

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, ToastActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_toast);

        findViewById(R.id.btnShow).setOnClickListener(v -> showToast());

        findViewById(R.id.btnShowStyled).setOnClickListener(v -> showStyledToast());

        findViewById(R.id.btnHide).setOnClickListener(v -> hideToast());
    }

    private void showToast() {
        hideToast();
        mToast = Toast.makeText(this, "No network connection.", Toast.LENGTH_SHORT);
        mToast.show();
    }

    private void showStyledToast() {
        hideToast();
        mToast = Toast.makeText(this, "No network connection.", Toast.LENGTH_SHORT);

        TextView textView = (TextView) mToast.getView().findViewById(android.R.id.message);
        textView.setTextColor(Color.YELLOW);

        mToast.getView().setBackgroundColor(getResources().getColor(R.color.indigo));
        mToast.show();
    }

    private void hideToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
