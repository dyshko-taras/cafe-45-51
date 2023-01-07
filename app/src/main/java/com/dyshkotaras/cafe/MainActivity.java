package com.dyshkotaras.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonSignIn.setOnClickListener((View View) -> launchMakeOrderActivity(getText(editTextName), getText(editTextPassword)));
    }

    private void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }

    public void launchMakeOrderActivity(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                    MainActivity.this,
                    R.string.error_fields_empty,
                    Toast.LENGTH_LONG).show();
        } else {
            startActivity(MakeOrderActivity.newIntent(MainActivity.this, userName));
        }
    }

    public String getText(EditText editText) {
        return editText.getText().toString().trim();
    }

}