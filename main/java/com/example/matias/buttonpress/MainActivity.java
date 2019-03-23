package com.example.matias.buttonpress;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View changeV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout)findViewById(R.id.addScore);

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layout.getLayoutParams();
        lp.height = 0;
        layout.setLayoutParams(lp);

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tvo0 = new TextView(this);
        tvo0.setText("Väylä");
        tvo0.setTextSize(20);
        tvo0.setGravity(Gravity.CENTER);
        tvo0.setBackgroundColor(Color.WHITE);
        tvo0.setTextColor(Color.BLACK);
        tbrow0.addView(tvo0);

        TextView tv1 = new TextView(this);
        tv1.setText("Par");
        tv1.setTextSize(20);
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundColor(Color.WHITE);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Matias");
        tv2.setTextSize(20);
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);
        tv2.setBackgroundColor(Color.WHITE);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("Timo");
        tv3.setTextSize(20);
        tv3.setTextColor(Color.BLACK);
        tv3.setGravity(Gravity.CENTER);
        tv3.setBackgroundColor(Color.WHITE);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText("Matias Lappalainen");
        tv4.setTextSize(20);
        tv4.setTextColor(Color.BLACK);
        tv4.setGravity(Gravity.CENTER);
        tv4.setBackgroundColor(Color.WHITE);
        tbrow0.addView(tv4);

        stk.addView(tbrow0);
        for (int i = 1; i < 19; i++) {

            TableRow tbrow = new TableRow(this);

            Button t1v = new Button(this);
            t1v.setText(""+i);
            t1v.setId(i+100);
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setBackgroundColor(Color.WHITE);
            t1v.setOnClickListener(this);
            tbrow.addView(t1v);

            Button t2v = new Button(this);
            t2v.setText("3");
            t1v.setId(i+200);
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            t2v.setBackgroundColor(Color.WHITE);
            t2v.setOnClickListener(this);
            tbrow.addView(t2v);

            Button t3v = new Button(this);
            t3v.setText("?");
            t3v.setId(i+300);
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            t3v.setBackgroundColor(Color.WHITE);
            t3v.setOnClickListener(this);
            tbrow.addView(t3v);

            Button t4v = new Button(this);
            t4v.setText("?");
            t4v.setId(i+400);
            t4v.setTextColor(Color.BLACK);
            t4v.setGravity(Gravity.CENTER);
            t4v.setBackgroundColor(Color.WHITE);
            t4v.setOnClickListener(this);
            tbrow.addView(t4v);

            Button t5v = new Button(this);
            t5v.setText("?");
            t5v.setId(i+500);
            t5v.setTextColor(Color.BLACK);
            t5v.setGravity(Gravity.CENTER);
            t5v.setBackgroundColor(Color.WHITE);
            t5v.setOnClickListener(this);
            tbrow.addView(t5v);

            stk.addView(tbrow);
        }
        TableRow tbrowlast = new TableRow(this);
        Button lastbutton = new Button(this);
        lastbutton.setText("Lopeta peli");
        lastbutton.setTextColor(Color.BLACK);
        lastbutton.setGravity(Gravity.CENTER);
        lastbutton.setOnClickListener(this);
        tbrowlast.addView(lastbutton);
        stk.addView(tbrowlast);
    }

    @Override
    public void onClick(View v) {
        changeV = v;
        LinearLayout layout = (LinearLayout)findViewById(R.id.addScore);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layout.getLayoutParams();
        lp.height = 240;
        layout.setLayoutParams(lp);
    }

    public void onClick2(View v) {
        int color = ((ColorDrawable)v.getBackground()).getColor();
        Button changeB = (Button) changeV;
        changeB.setBackgroundColor(color);
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        changeB.setText(buttonText);

        LinearLayout layout = (LinearLayout)findViewById(R.id.addScore);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layout.getLayoutParams();
        lp.height = 0;
        layout.setLayoutParams(lp);
    }

}
