package com.dyshkotaras.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {
    TextView textViewGreetings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();


        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String result = String.format(textViewGreetings.getText().toString(),name);
        textViewGreetings.setText(result);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context,MakeOrderActivity.class);
        intent.putExtra("userName",userName);
        return intent;
    }

    public void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
    }
}