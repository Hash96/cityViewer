package com.example.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.viewHolder> {
    private ArrayList<CityItem> cityItems;
    private Context context;
    private FavDB favDB;

    public CityAdapter(ArrayList<CityItem> cityItems, FragmentActivity activity) {
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firsStart", true);
        if (firstStart){
            createTableFirstStart();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cityItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;
        Button b1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            b1 = itemView.findViewById(R.id.b1);
        }
    }
    private void createTableFirstStart(){
       favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();

    }



}
