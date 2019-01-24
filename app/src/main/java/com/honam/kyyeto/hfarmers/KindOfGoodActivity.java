package com.honam.kyyeto.hfarmers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class KindOfGoodActivity extends RelativeLayout {

    public KindOfGoodActivity(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public KindOfGoodActivity(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_kind_of_good,this,true);
    }
}
