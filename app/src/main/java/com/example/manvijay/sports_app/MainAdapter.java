package com.example.manvijay.sports_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saksham on 21-Feb-18.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<String> list1;


    public MainAdapter(ArrayList<String> templist){
        list1 = templist;

    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview1,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
         holder.text1.setText(list1.get(position));
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text1;

        public ViewHolder(View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text1);
        }
       // text1=itemView.findViewById(R.id.text1);
    }
}
