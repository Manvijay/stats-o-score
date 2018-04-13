package com.example.manvijay.sports_app;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saksham on 21-Feb-18.
 */
// this class is for managing the recycler view on our current matches play. It manages the display for all the 3 recycler views

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
        ArrayList<String> list1;
        ArrayList<String> list2;
        ArrayList<String> list3;   //receive the String array list to display
  
    public MainAdapter(ArrayList<String> templist,ArrayList<String> templist2,ArrayList<String> templist3){
        list1 = templist;
        list2 = templist2;
        list3 = templist3;

    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview1,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
         holder.text1.setText(list1.get(position));
         holder.text2.setText(list2.get(position));
         holder.text3.setText(list3.get(position));
         if(list3.get(position).equals("● LIVE") )
            holder.text3.setTextColor(Color.parseColor("#ff0000"));
         else
             holder.text3.setTextColor(Color.parseColor("#000000"));
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text1,text2,text3;

        public ViewHolder(View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);

        }
       // text1=itemView.findViewById(R.id.text1);
    }
}
