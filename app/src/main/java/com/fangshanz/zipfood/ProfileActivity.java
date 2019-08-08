package com.fangshanz.zipfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("PROFILE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView profileImage = (ImageView) findViewById(R.id.profile_image);
        Glide.with(this)
                .load("https://pbs.twimg.com/profile_images/1149576608887349248/Bi59r7PH_400x400.png")
                .apply(RequestOptions.circleCropTransform())
                .into(profileImage);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
