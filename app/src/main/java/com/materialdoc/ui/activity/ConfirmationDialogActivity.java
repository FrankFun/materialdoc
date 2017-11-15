package com.materialdoc.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.materialdoc.R;

public class ConfirmationDialogActivity extends AppCompatActivity {

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, ConfirmationDialogActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_confirmation_dialog);

        Button btnSingle = findViewById(R.id.btnSingle);
        btnSingle.setOnClickListener(v -> showSingleChoiceDialog());

        Button btnMulti = findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(v -> showStyledMultiChoiceDialog());
    }

    public void showSingleChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmationDialogActivity.this);
        builder.setTitle(R.string.confirmation_dialog_title);

        //list of items
        String[] items = getResources().getStringArray(R.array.ringtone_list);
        builder.setSingleChoiceItems(items, 0,
                (dialog, which) -> {
                    // item selected logic
                });

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                (dialog, which) -> {
                    // positive button logic
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                (dialog, which) -> {
                    // negative button logic
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    public void showStyledMultiChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyConfirmationDialogTheme);
        builder.setTitle(R.string.confirmation_dialog_title);

        //list of items
        String[] items = getResources().getStringArray(R.array.ringtone_list);
        boolean[] selectedItemsArray = new boolean[items.length];

        builder.setMultiChoiceItems(items, selectedItemsArray, (dialog, which, isChecked) -> {
            //item checked logic
        });

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                (dialog, which) -> {
                    // positive button logic
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                (dialog, which) -> {
                    // negative button logic
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}
