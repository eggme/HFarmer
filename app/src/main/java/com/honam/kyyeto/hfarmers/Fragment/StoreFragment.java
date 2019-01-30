package com.honam.kyyeto.hfarmers.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.honam.kyyeto.hfarmers.AllGoodsAdapter;
import com.honam.kyyeto.hfarmers.All_Goods;
import com.honam.kyyeto.hfarmers.DetailGoodsActivity;
import com.honam.kyyeto.hfarmers.Home.MdGoodsAdapter;
import com.honam.kyyeto.hfarmers.Home.Md_Goods;
import com.honam.kyyeto.hfarmers.Home.Month_Goods;
import com.honam.kyyeto.hfarmers.Home.RecyclerViewAdapter;
import com.honam.kyyeto.hfarmers.MainActivity;
import com.honam.kyyeto.hfarmers.R;
import com.honam.kyyeto.hfarmers.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyyet on 2019-01-22.
 */

public class StoreFragment extends Fragment{

    private RecyclerView md_goods;
    private RecyclerView.LayoutManager mdLayoutManager;
    private RecyclerView.Adapter mdAdapter;

    private ArrayList<Md_Goods> mdlist = new ArrayList<>();

    RecyclerView mRecyclerView;
    List<All_Goods> mGoodsList;
    All_Goods mGoodsData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        md_goods = (RecyclerView) view.findViewById(R.id.md_goods);

        mdlist.add(new Md_Goods("맛있는 거봉 초대박 특가", R.drawable.grape));
        mdlist.add(new Md_Goods("맛있는 오렌지 초대박 특가", R.drawable.orange));
        mdlist.add(new Md_Goods("맛있는 딸기 초대박 특가", R.drawable.strawberry));
        mdlist.add(new Md_Goods("맛있는 수박 초대박 특가", R.drawable.watermelon));
        mdlist.add(new Md_Goods("맛있는 거봉 초대박 특가", R.drawable.grape));
        mdlist.add(new Md_Goods("맛있는 오렌지 초대박 특가", R.drawable.orange));
        mdlist.add(new Md_Goods("맛있는 딸기 초대박 특가", R.drawable.strawberry));
        mdlist.add(new Md_Goods("맛있는 수박 초대박 특가", R.drawable.watermelon));

        md_goods = (RecyclerView)view.findViewById(R.id.md_goods);
        md_goods.setHasFixedSize(true);
        mdLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        md_goods.setLayoutManager(mdLayoutManager);

        mdAdapter = new MdGoodsAdapter(getContext(), mdlist);
        md_goods.setAdapter(mdAdapter);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.all_goods);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mGoodsList = new ArrayList<>();
        mGoodsData = new All_Goods("Rose", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Carnation", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Tulip", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Daisy", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Sunflower", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Daffodil",null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Gerbera", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Orchid", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Iris", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);
        mGoodsData = new All_Goods("Lilac", null, R.drawable.grape);
        mGoodsList.add(mGoodsData);

        AllGoodsAdapter allGoodsAdapter = new AllGoodsAdapter(getActivity(), mGoodsList);
        mRecyclerView.setAdapter(allGoodsAdapter);
        md_goods.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), md_goods, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), position+"번 째 아이템 클릭", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), DetailGoodsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        return view;

    }
}