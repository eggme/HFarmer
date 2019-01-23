package com.honam.kyyeto.hfarmers.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.honam.kyyeto.hfarmers.R;

import java.util.ArrayList;

public class MdGoodsAdapter extends RecyclerView.Adapter<MdGoodsAdapter.MdGoodsViewHolder> {

    private Context context;
    private ArrayList<Md_Goods> mdList;

    public MdGoodsAdapter(Context context, ArrayList<Md_Goods> mdList) {
        super();
        this.context = context;
        this.mdList = mdList;
    }

    @Override
    public MdGoodsAdapter.MdGoodsViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.horizon_recycler_items, parent, false);
        return new MdGoodsAdapter.MdGoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MdGoodsAdapter.MdGoodsViewHolder holder, int position) {

        MdGoodsViewHolder myViewHolder = (MdGoodsViewHolder) holder;
        myViewHolder.imageView.setImageResource(mdList.get(position).getDrawableId());
        myViewHolder.textView.setText(mdList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mdList.size();
    }

    public static class MdGoodsViewHolder extends RecyclerView.ViewHolder{

        LinearLayout layout;
        ImageView imageView;
        TextView textView;

        public MdGoodsViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.horizon_layout);
            imageView = (ImageView)itemView.findViewById(R.id.horizon_image);
            textView = (TextView)itemView.findViewById(R.id.horizon_title);
        }

    }

}