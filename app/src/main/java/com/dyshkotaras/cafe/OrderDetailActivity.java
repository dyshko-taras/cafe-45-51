package com.dyshkotaras.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_DRINK= "drink";
    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_DRINK_TYPE = "drinkType";

    private TextView textViewUserName;
    private TextView textViewDrink;
    private TextView textViewDrinkType;
    private TextView textViewAdditives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initView();
        getInfo();

    }

    private void getInfo() {

        String userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        textViewUserName.setText(userName);

        String drink = getIntent().getStringExtra(EXTRA_DRINK);
        textViewDrink.setText(drink);

        ArrayList<String> additives = getIntent().getStringArrayListExtra(EXTRA_ADDITIVES);
        textViewAdditives.setText(additives.toString());

        String drinkType = getIntent().getStringExtra(EXTRA_DRINK_TYPE);
        textViewDrinkType.setText(drinkType);
    }

    public static Intent newIntent(
            Context context,
            String userName,
            String drink,
            ArrayList<String> additives,
            String drinkType) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME,userName);
        intent.putExtra(EXTRA_DRINK,drink);
        intent.putExtra(EXTRA_ADDITIVES,additives);
        intent.putExtra(EXTRA_DRINK_TYPE,drinkType);
        return intent;
    }

    public void initView() {
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditives);
    }
}