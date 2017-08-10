package com.example.android.sowetoguideapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button attractionData;
    private Button restaurantData;
    private Button hotelData;
    private Button tourGuide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        attractionData = (Button) findViewById(R.id.view_attraction);
        restaurantData = (Button) findViewById(R.id.view_restaurant);
        hotelData = (Button) findViewById(R.id.view_hotel);
        tourGuide = (Button) findViewById(R.id.toolbar);

        attractionData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AttractionDataActivity.class);
                startActivity(intent);
            }
        });

        restaurantData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this,RestaurantDataActivity.class);
                startActivity(intent);
            }
        });
        hotelData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HotelDataActivity.class);
                startActivity(intent);
            }
        });


        tourGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TourGuideActivity.class);
                startActivity(intent);
            }
        });


    }
}