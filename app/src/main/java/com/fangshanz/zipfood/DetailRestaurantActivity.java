package com.fangshanz.zipfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class DetailRestaurantActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_TYPEFOOD = "extra_typefood";
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_PHONENUMBER = "extra_phonenumber";
    public String PhoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_restaurant);

        getSupportActionBar().setTitle("RESTAURANT INFO");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvRestaurantNameDetail = findViewById(R.id.tv_restaurant_name_detail);
        TextView tvTypeFoodDetail = findViewById(R.id.tv_type_food_detail);
        TextView tvAddress = findViewById(R.id.tv_address_detail);
        TextView tvPhoneNumber = findViewById(R.id.tv_phone_number_detail);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String typeFood = getIntent().getStringExtra(EXTRA_TYPEFOOD);
        String address = getIntent().getStringExtra(EXTRA_ADDRESS);
        String phoneNumber = getIntent().getStringExtra(EXTRA_PHONENUMBER);
        PhoneNumber = phoneNumber;

        tvRestaurantNameDetail.setText(name);
        tvTypeFoodDetail.setText(typeFood);
        tvAddress.setText(address);
        tvPhoneNumber.setText(phoneNumber);

        ImageView restaurantImage = (ImageView) findViewById(R.id.restaurant_image);
        Glide.with(this)
                .load(photo)
                .apply(RequestOptions.circleCropTransform().transform(new RoundedCorners(20)))
                .into(restaurantImage);

        LinearLayout btnCall = findViewById(R.id.call_number);
        btnCall.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.call_number:
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ PhoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
