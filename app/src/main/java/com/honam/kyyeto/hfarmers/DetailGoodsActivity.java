package com.honam.kyyeto.hfarmers;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.TEXT_ALIGNMENT_CENTER;


public class DetailGoodsActivity extends AppCompatActivity {

    private EditText etCount;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnKind;
    private TextView tvTitle;
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
                new AlertDialog.Builder(DetailGoodsActivity.this)
                        .setTitle("")
                        .setMessage("해당 상품은 최소 1개 이상" +
                                "주문하셔야 합니다.")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
                int count;
                for(int i = 0; i > 3; i++){
                    count =Integer.parseInt(String.valueOf(views[i].getText()));
                    if(count < 1){
                        Toast.makeText(DetailGoodsActivity.this, views[0].getText() , Toast.LENGTH_SHORT).show();
                    }
                }

                //Toast.makeText(DetailGoodsActivity.this, views[0].getText() + " : " + views[1].getText() + " : " + views[2].getText() , Toast.LENGTH_SHORT).show();
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
                LinearLayout con = (LinearLayout) findViewById(R.id.con);

                String text = "";
                switch (which){
                    case 0 : text = "2kg";
                        if(choice.one == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                            break;
                        }
                        choice.one = true;
                        addView(text,con,0);
                        break;
                    case 1 : text = "1kg";
                        if(choice.two == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                            break;
                        }
                        choice.two = true;
                        addView(text,con,1);
                        break;
                    case 2 : text = "500g";
                        if(choice.three == true) {
                            Toast.makeText(getApplicationContext(), "이미 추가되어 있습니다.", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
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
    public int cal(int a){
        float mScale = getResources().getDisplayMetrics().density;
        final int calHeight = (int)(a*mScale);
        return calHeight;
    }
    @SuppressLint("ResourceType")
    public void addView(String text, LinearLayout con, int num){
        //RelativeLayout rl = new RelativeLayout(getApplicationContext());
        final TextView tv1 = new TextView(getApplicationContext());
        tv1.setId(1);
        tv1.setText(text);
        RelativeLayout.LayoutParams topTvParams = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        tv1.setLayoutParams(topTvParams);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "gggggdfasdasdasd", Toast.LENGTH_SHORT).show();
            }
        });

        final EditText et1 = new EditText(getApplicationContext());
        et1.setId(2);
        et1.setText("1");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            et1.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        }
        RelativeLayout.LayoutParams middleEtParams = new RelativeLayout.LayoutParams
                (180,150);
        middleEtParams.addRule(RelativeLayout.BELOW, 1);
        et1.setLayoutParams(middleEtParams);

        btns[num][0].setId(3);
        btns[num][0].setText("+");
        RelativeLayout.LayoutParams plusBtnParams = new RelativeLayout.LayoutParams
                (150,150);
        plusBtnParams.addRule(RelativeLayout.ALIGN_TOP, 2);
        plusBtnParams.addRule(RelativeLayout.RIGHT_OF, 2);
        btns[num][0].setLayoutParams(plusBtnParams);

        btns[num][1].setId(4);
        btns[num][1].setText("-");
        RelativeLayout.LayoutParams minusBtnParams = new RelativeLayout.LayoutParams
                (150,150);
        minusBtnParams.addRule(RelativeLayout.ALIGN_TOP, 2);
        minusBtnParams.addRule(RelativeLayout.RIGHT_OF, 3);
        btns[num][1].setLayoutParams(minusBtnParams);

        btns[num][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = (int) Integer.parseInt(String.valueOf(et1.getText()));
                count++;
                et1.setText(""+count);
            }
        });
        btns[num][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = (int) Integer.parseInt(String.valueOf(et1.getText()));
                if(count > 1){
                    count--;
                }

                et1.setText(""+count);
            }
        });
        views[num] = et1;
        con.addView(tv1);
        con.addView(et1);
        con.addView(btns[num][0]);
        con.addView(btns[num][1]);
    }
}
