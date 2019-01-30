package com.honam.kyyeto.hfarmers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.honam.kyyeto.hfarmers.Fragment.StoreFragment;

import java.util.List;

public class AllGoodsAdapter extends RecyclerView.Adapter< GoodsViewHolder > {

    private Context mContext;
    private List<All_Goods> mGoodsList;

    public AllGoodsAdapter(Context mContext, List<All_Goods> mGoodsList) {
        this.mContext = mContext;
        this.mGoodsList = mGoodsList;
    }

    @Override
    public GoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_goods_recyclerview_row, parent, false);
        return new GoodsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(GoodsViewHolder holder, int position) {
        holder.mImage.setImageResource(mGoodsList.get(position).getGoodsImage());
        holder.mTitle.setText(mGoodsList.get(position).getGoodsName());
    }

    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }
}

class GoodsViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;

    GoodsViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
    }
}
