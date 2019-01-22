package com.honam.kyyeto.hfarmers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private Context context;
    private ArrayList<Month_Goods> list;

    public GoodsAdapter(Context context, ArrayList<Month_Goods> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public GoodsAdapter.GoodsViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_items, parent, false);
        return new GoodsAdapter.GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoodsAdapter.GoodsViewHolder holder, int position) {

        GoodsViewHolder myViewHolder = (GoodsViewHolder) holder;
        myViewHolder.imageView.setImageResource(list.get(position).getDrawableId());
        myViewHolder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class GoodsViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout layout;
        ImageView imageView;
        TextView textView;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            layout = (RelativeLayout)itemView.findViewById(R.id.layout);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView)itemView.findViewById(R.id.title);
        }

    }

}
