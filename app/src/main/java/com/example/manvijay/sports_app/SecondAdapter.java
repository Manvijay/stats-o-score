package com.example.manvijay.sports_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vishu.Saharan on 2/23/2018.
 */

class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    ArrayList<String> mylist;

    public SecondAdapter(ArrayList<String> temp){
        mylist = temp;
    }
    @Override
    public SecondAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SecondAdapter.ViewHolder holder, int position) {
        holder.text2.setText(mylist.get(position));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text2;
        public ViewHolder(View itemView) {
            super(itemView);
            text2 = itemView.findViewById(R.id.text2);

        }
    }
}
