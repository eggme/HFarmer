package com.honam.kyyeto.hfarmers;

/**
 * Created by kyyet on 2019-01-22.
 */
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;


/**
 * Created by LSJ on 2015-08-19.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView month_goods;
    private RecyclerView md_goods;
    private PagerSnapHelper pagerSnapHelper;
    private LinearLayoutManager layoutManager;
    private RecyclerView.LayoutManager mLayoutManager;
    private Handler handler;
    private Runnable runnable;

    private ArrayList<Month_Goods> list = new ArrayList<>();
    private ArrayList<HorizontalData> mdList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.slide_recyclerview);
        month_goods = (RecyclerView)view.findViewById(R.id.month_goods);
        md_goods = (RecyclerView)view.findViewById(R.id.md_goods);

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

        list.add(new Month_Goods("맛있는 거봉 초대박 특가", R.drawable.grape));
        list.add(new Month_Goods("맛있는 오렌지 초대박 특가", R.drawable.orange));
        list.add(new Month_Goods("맛있는 딸기 초대박 특가", R.drawable.strawberry));
        list.add(new Month_Goods("맛있는 수박 초대박 특가", R.drawable.watermelon));
        list.add(new Month_Goods("맛있는 참외 초대박 특가", R.drawable.orientalmelon));

        GoodsAdapter adapter = new GoodsAdapter(getContext(), list);

        mLayoutManager = new LinearLayoutManager(getContext());
        month_goods.setLayoutManager(mLayoutManager);
        month_goods.setAdapter(adapter);
        month_goods.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), month_goods, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), position+"번 째 아이템 클릭", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        mdList.add(new HorizontalData("맛있는 거봉 초대박 특가", R.drawable.grape));
        mdList.add(new HorizontalData("맛있는 오렌지 초대박 특가", R.drawable.orange));
        mdList.add(new HorizontalData("맛있는 딸기 초대박 특가", R.drawable.strawberry));
        mdList.add(new HorizontalData("맛있는 수박 초대박 특가", R.drawable.watermelon));
        mdList.add(new HorizontalData("맛있는 참외 초대박 특가", R.drawable.orientalmelon));
        HorizontalAdapter mdAdapter = new HorizontalAdapter(getContext(), mdList);
        mLayoutManager = new LinearLayoutManager(getContext());
        md_goods.setLayoutManager(mLayoutManager);
        md_goods.setAdapter(mdAdapter);

        return view;

    }










}