package com.materialdoc.ui.activity.input;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.materialdoc.R;

public class InputErrorLabelActivity extends AppCompatActivity {

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, InputErrorLabelActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_input_error_label);

        final TextInputLayout inputLayoutFirstName = findViewById(R.id.inputLayoutFirstName);
        final TextInputLayout inputLayoutLastName = findViewById(R.id.inputLayoutLastName);

        Button btnShowError = findViewById(R.id.btnShowError);
        btnShowError.setOnClickListener(v -> {
            inputLayoutFirstName.setError(getString(R.string.First_name_is_required));
            inputLayoutLastName.setError(getString(R.string.Date_pattern));
        });

        Button btnHideError = findViewById(R.id.btnHideError);
        btnHideError.setOnClickListener(v -> {
            inputLayoutFirstName.setError("");
            inputLayoutLastName.setError("");
        });
    }
}
