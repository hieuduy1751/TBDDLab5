package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Bundle bundle = getIntent().getExtras();
        TextView tvName = (TextView) findViewById(R.id.detailName);
        TextView tvDetail = (TextView) findViewById(R.id.detailDesc);
        TextView tvPrice = (TextView) findViewById(R.id.detailPrice);
        ImageView img = (ImageView) findViewById(R.id.detailImg);

        tvName.setText(bundle.getString("detailName"));
        tvDetail.setText(bundle.getString("detailDesc"));
        tvPrice.setText(bundle.getString("detailPrice"));
        img.setImageResource(bundle.getInt("detailImg"));
    }
}