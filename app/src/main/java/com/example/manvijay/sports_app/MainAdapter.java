package com.example.manvijay.sports_app;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawableResource;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by saksham on 21-Feb-18.
 */
// this class is for managing the recycler view on our current matches play. It manages the display for all the 3 recycler views

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
        ArrayList<String> list1;
        ArrayList<String> list2;
        ArrayList<String> list3; //receive the String array list to display
        ArrayList<String> leftimage;
        ArrayList<String> rightimage;
        private Context context;
  
    public MainAdapter(ArrayList<String> templist,ArrayList<String> templist2,ArrayList<String> templist3, ArrayList<String> limage, ArrayList<String> rimage){
        list1 = templist;
        list2 = templist2;
        list3 = templist3;
        leftimage = limage;
        rightimage = rimage;
    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview1,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = leftimage.get(position);
        String v = rightimage.get(position);
        holder.text1.setText(list1.get(position));
         holder.text2.setText(list2.get(position));
         holder.text3.setText(list3.get(position));
         if(list3.get(position).equals("● LIVE") )
            holder.text3.setTextColor(Color.parseColor("#ff0000"));
         else
             holder.text3.setTextColor(Color.parseColor("#000000"));

       Glide.with(context).load(s.substring(1,s.length()-1)).into(holder.image1);
        Glide.with(context).load(v.substring(1,v.length()-1)).into(holder.image2);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text1,text2,text3;
        public ImageView image1,image2;

        public ViewHolder(View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            image1 = itemView.findViewById(R.id.flag1);
            image2 = itemView.findViewById(R.id.flag2);

        }
       // text1=itemView.findViewById(R.id.text1);
    }
}
