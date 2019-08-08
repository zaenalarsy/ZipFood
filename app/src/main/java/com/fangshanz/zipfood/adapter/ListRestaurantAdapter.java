package com.fangshanz.zipfood.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fangshanz.zipfood.R;
import com.fangshanz.zipfood.model.Restaurant;

import java.util.ArrayList;

public class ListRestaurantAdapter extends RecyclerView.Adapter<ListRestaurantAdapter.ListViewHolder> {

    private ArrayList<Restaurant> listRestaurant;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListRestaurantAdapter(ArrayList<Restaurant> list) {
        this.listRestaurant = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_restaurant, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Restaurant restaurant = listRestaurant.get(position);

        Glide.with(holder.itemView.getContext())
                .load(restaurant.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvRestaurantName.setText(restaurant.getRestaurantName());
        holder.tvAddress.setText(restaurant.getAddress());
//        holder.tvPhoneNumber.setText(restaurant.getPhoneNumber());
//        holder.tvFoodType.setText(restaurant.getFoodType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listRestaurant.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRestaurant.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvRestaurantName, tvAddress, tvPhoneNumber, tvFoodType;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvRestaurantName = itemView.findViewById(R.id.tv_item_name);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Restaurant data);
    }
}
