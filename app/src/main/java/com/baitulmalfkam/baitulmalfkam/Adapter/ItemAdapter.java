package com.baitulmalfkam.baitulmalfkam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baitulmalfkam.baitulmalfkam.Detail.DetailHomeActivity;
import com.baitulmalfkam.baitulmalfkam.POJO.ListItem;
import com.baitulmalfkam.baitulmalfkam.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter <ItemAdapter.ItemViewHolder> {
    ArrayList <ListItem> dataList;
    Context context;


    public ItemAdapter (ArrayList<ListItem> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tampilkan = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_model,parent,false);

        return new ItemViewHolder(tampilkan);
    }



    @Override
    public void onBindViewHolder(ItemAdapter.ItemViewHolder holder, int position) {
        final ListItem listItem = dataList.get(position);

        String title = listItem.getTitle();
        holder.post_title.setText(Html.fromHtml(title));
        holder.post_date.setText(listItem.getDate());

        String content = listItem.getContent();
        holder.overview.setText(Html.fromHtml(content));

        Picasso.with(context).load(listItem.getThumbnail()).into(holder.post_thumb);

        holder.card_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(context, DetailHomeActivity.class);
                homeIntent.putExtra("HOME", listItem);
                context.startActivity(homeIntent);

            }
        });

        String foundDate = dataList.get(position).getDate();
        SimpleDateFormat formatOfDate = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatOfDate.parse(foundDate);

            SimpleDateFormat newFormatDate =  new SimpleDateFormat("EEEE, dd MMM yyyy");
            String releaseDate = newFormatDate.format(date);
            holder.post_date.setText(releaseDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView post_thumb;
        TextView post_title,post_date,overview;
        FloatingActionButton fab_share;
        CardView card_news;


        public ItemViewHolder(View itemView) {
            super(itemView);

            post_thumb = itemView.findViewById(R.id.post_thumb);
            post_title = itemView.findViewById(R.id.post_title);
            post_date = itemView.findViewById(R.id.post_date);
            overview = itemView.findViewById(R.id.overview);
            card_news = itemView.findViewById(R.id.card_news);
        }
    }
}
