package com.honam.kyyeto.hfarmers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalViewHolder> {
    private Context context;
    private ArrayList<HorizontalData> mdList;

    public HorizontalAdapter(Context context, ArrayList<Month_Goods> mdList) {
        super();
        this.context = context;
        this.mdList = mdList;
    }

    public void setData(ArrayList<HorizontalData> mdList){
        mdList = mdList;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 사용할 아이템의 뷰를 생성해준다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizon_recycler_items, parent, false);

        HorizontalViewHolder holder = new HorizontalViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        HorizontalData data = mdList.get(position);

        holder.description.setText(data.getText());
        holder.icon.setImageResource(data.getImg());

    }

    @Override
    public int getItemCount() {
        return mdList.size();
    }
}