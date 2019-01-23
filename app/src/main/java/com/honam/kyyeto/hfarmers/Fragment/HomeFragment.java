package com.honam.kyyeto.hfarmers.Fragment;

/**
 * Created by kyyet on 2019-01-22.
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.honam.kyyeto.hfarmers.Home.MdGoodsAdapter;
import com.honam.kyyeto.hfarmers.Home.Md_Goods;
import com.honam.kyyeto.hfarmers.Home.Month_Goods;
import com.honam.kyyeto.hfarmers.R;
import com.honam.kyyeto.hfarmers.RecyclerItemClickListener;
import com.honam.kyyeto.hfarmers.Home.RecyclerViewAdapter;
import com.honam.kyyeto.hfarmers.DetailGoodsActivity;

import java.util.ArrayList;


/**
 * Created by LSJ on 2015-08-19.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView md_goods;
    private PagerSnapHelper pagerSnapHelper;
    private LinearLayoutManager layoutManager;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mdLayoutManager;
    private RecyclerView.Adapter mdAdapter;
    private Handler handler;
    private Runnable runnable;

    private ArrayList<Month_Goods> list = new ArrayList<>();
    private ArrayList<Md_Goods> mdlist = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.slide_recyclerview);
        md_goods = (RecyclerView) view.findViewById(R.id.md_goods);


        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pagerSnapHelper = new PagerSnapHelper();

        if(handler == null) {
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (layoutManager.findFirstVisibleItemPosition() != 2) {
                        recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
                    } else {
                        recyclerView.smoothScrollToPosition(0);
                    }
                    handler.postDelayed(this, 3000);
                }
            };
        }
        handler.postDelayed(runnable, 3000);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext()));
        pagerSnapHelper.attachToRecyclerView(recyclerView);



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