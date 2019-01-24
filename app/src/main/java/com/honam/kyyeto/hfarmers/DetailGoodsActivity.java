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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_goods);

        Button btnPurchase = (Button)findViewById(R.id.detail_btnPurchase);
        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailGoodsActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        btnKind = findViewById(R.id.btnKind);

        final CharSequence[] oItems = {"2Kg", "1Kg", "500g"};
        final AlertDialog.Builder oDialog = new AlertDialog.Builder(this);

        oDialog.setTitle("종류를 선택하세요").setItems(oItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                KindOfGoodActivity n_layout = new KindOfGoodActivity(getApplicationContext());
                LinearLayout con = (LinearLayout)findViewById(R.id.con);
                // activity_kind_of_good.xml 불러오기


                con.addView(n_layout);

                etCount = findViewById(R.id.etCount);
                btnPlus = findViewById(R.id.btnPlus);
                btnMinus = findViewById(R.id.btnMinus);
                tvTitle = findViewById(R.id.tvTitle);
                tvTitle.setText(oItems[which]);


                btnPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count++;
                        etCount.setText(""+count);
                    }
                });

                btnMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count != 1){
                            count--;
                        }
                        etCount.setText(""+count);
                    }
                });

                Toast.makeText(getApplicationContext(),
                        oItems[which], Toast.LENGTH_LONG).show();
            }
        }).setCancelable(true);

        btnKind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oDialog.show();
            }
        });

    }

}
