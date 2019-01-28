package com.honam.kyyeto.hfarmers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DetailGoodsActivity extends AppCompatActivity {

    private EditText etCount;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnKind;
    private TextView tvTitle;
    private int count = 1;
    private Choice choice = new Choice();
    private Button[][] btns = new Button[3][2];
    private TextView[] views = new TextView[3];

    public class Choice {
        boolean one = false;
        boolean two = false;
        boolean three = false;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_goods);
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                btns[i][j] = new Button(getApplicationContext());
            }
        }


        Button btnPurchase = (Button)findViewById(R.id.detail_btnPurchase);
        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailGoodsActivity.this, views[0].getText() + " : " + views[1].getText() + " : " + views[2].getText() , Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(DetailGoodsActivity.this, OrderActivity.class);
                //startActivity(intent);
            }
        });

        btnKind = findViewById(R.id.btnKind);

        final CharSequence[] oItems = {"2Kg", "1Kg", "500g"};
        final AlertDialog.Builder oDialog = new AlertDialog.Builder(this);

        oDialog.setTitle("종류를 선택하세요").setItems(oItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                LinearLayout con = (LinearLayout)findViewById(R.id.con);

                String text = "";
                switch (which){
                    case 0 : text = "2kg";
                        if(choice.one == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        choice.one = true;
                        addView(text,con,0);
                        break;
                    case 1 : text = "1kg";
                        if(choice.two == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        choice.two = true;
                        addView(text,con,1);
                        break;
                    case 2 : text = "500g";
                        if(choice.three == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        choice.three = true;
                        addView(text,con,2);
                        break;
                }
            }
        }).setCancelable(true);

        btnKind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oDialog.show();
            }
        });

    }

    public void addView(String text, LinearLayout con, int num){
        final TextView tv1 = new TextView(getApplicationContext());
        tv1.setText(text);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "gggggdfasdasdasd", Toast.LENGTH_SHORT).show();
            }
        });
        btns[num][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("가격이 올라감");
            }
        });
        btns[num][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("가격이 내려감");
            }
        });
        views[num] = tv1;
        con.addView(tv1);
        con.addView(btns[num][0]);
        con.addView(btns[num][1]);
    }
}
