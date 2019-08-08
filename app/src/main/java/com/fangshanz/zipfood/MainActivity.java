package com.fangshanz.zipfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fangshanz.zipfood.adapter.ListRestaurantAdapter;
import com.fangshanz.zipfood.model.Restaurant;
import com.fangshanz.zipfood.model.RestaurantData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRestaurants;
    private ArrayList<Restaurant> list = new ArrayList<>();

    private void showSelectedRestaurant(Restaurant restaurant) {
//        Toast.makeText(this, "Kamu memilih " + restaurant.getRestaurantName(), Toast.LENGTH_SHORT).show();
        Intent moveIntent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
        moveIntent.putExtra(DetailRestaurantActivity.EXTRA_NAME, restaurant.getRestaurantName());
        moveIntent.putExtra(DetailRestaurantActivity.EXTRA_PHOTO, restaurant.getPhoto());
        moveIntent.putExtra(DetailRestaurantActivity.EXTRA_TYPEFOOD, restaurant.getFoodType());
        moveIntent.putExtra(DetailRestaurantActivity.EXTRA_ADDRESS, restaurant.getAddress());
        moveIntent.putExtra(DetailRestaurantActivity.EXTRA_PHONENUMBER, restaurant.getPhoneNumber());
        startActivity(moveIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRestaurants = findViewById(R.id.rv_restaurant);
        rvRestaurants.setHasFixedSize(true);

        getSupportActionBar().setTitle("Z1PF00D");

        list.addAll(RestaurantData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        ListRestaurantAdapter listRestaurantAdapter = new ListRestaurantAdapter(list);
        rvRestaurants.setAdapter(listRestaurantAdapter);

        listRestaurantAdapter.setOnItemClickCallback(new ListRestaurantAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Restaurant data) {
                showSelectedRestaurant(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_profile:
                Intent moveIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(moveIntent);
                break;
        }
    }



}
