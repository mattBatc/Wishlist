package com.mattb.wishlist;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.wajahatkarim3.easymoneywidgets.EasyMoneyEditText;

public class ViewDialog extends Dialog implements android.view.View.OnClickListener {

    public Activity c;
    Button add_but;
    EditText item_name,item_group;
    EasyMoneyEditText price_dia;
    AppDatabase db;


    public ViewDialog(Activity a){
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_dialog);
        add_but = findViewById(R.id.add_but);
        price_dia = findViewById(R.id.item_price);
        item_name = findViewById(R.id.item_name);
        item_group = findViewById(R.id.item_group);
        add_but.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String t = price_dia.getValueString();
        Item f = new Item();
        f.setPrice(Double.parseDouble(t));
        f.setName(item_name.toString());
        f.setGroup(item_group.toString());
        AppDatabase database = AppDatabase.getDatabase(c.getApplicationContext());
        DatabaseInterface.addItem(database,f);
    }
}
