package com.baitulmalfkam.baitulmalfkam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baitulmalfkam.baitulmalfkam.Detail.DetailMajalahActivity;
import com.baitulmalfkam.baitulmalfkam.POJO.Majalah;
import com.baitulmalfkam.baitulmalfkam.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MajalahAdapter extends RecyclerView.Adapter <MajalahAdapter.MajalahViewHolder> {
    ArrayList<Majalah> dataMajalah;
    Context context;

    public MajalahAdapter (ArrayList<Majalah>dataMajalah, Context context){
        this.dataMajalah = dataMajalah;
        this.context = context;
    }

    //membuat viewholder
    @Override
    public MajalahAdapter.MajalahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tampilkan = LayoutInflater.from(parent.getContext()).inflate(R.layout.majalah,parent,false);

        return new MajalahViewHolder(tampilkan);
    }


    //menangkap viewholder
    @Override
    public void onBindViewHolder(MajalahAdapter.MajalahViewHolder holder, int position) {
        final Majalah majalah = dataMajalah.get(position);

        holder.tv_title.setText(majalah.getTitle());
        holder.tv_date.setText(majalah.getEdisi());
        Picasso.with(context).load(majalah.getThumbnail()).into(holder.iv_Majalah);

        holder.iv_Majalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahBaru = new Intent(context,DetailMajalahActivity.class);
                pindahBaru.putExtra("MAJALAH",majalah);
                context.startActivity(pindahBaru);
            }
        });

        holder.tombolShare.setOnClickListener(new View.OnClickListener() {
            String sub = "Yuk Baca Majalah Online Baitulmal FKAM";
            String klik = "Yuk Baca Majalah Online Baitulmal FKAM! \n \n";
            String digital = "http://baitulmalfkam.com/media/majalah-digital/";
            String edisi = majalah.getEdisi().toString().trim();
            String judul = majalah.getTitle().toString().trim();
            String url = majalah.getUrl().toString().trim();

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,klik  + edisi +"\n" +"*"+ judul +"*"+"\n"+ url);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent,"Share Via:"));

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMajalah.size();
    }

    public class MajalahViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_date;
        ImageView iv_Majalah;
        FloatingActionButton tombolShare;

        public MajalahViewHolder(View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date = itemView.findViewById(R.id.tv_date);
            iv_Majalah = itemView.findViewById(R.id.iv_majalah);
            tombolShare = itemView.findViewById(R.id.btn_share);


        }
    }

}
