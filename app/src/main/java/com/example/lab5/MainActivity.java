package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab5.adapter.DonutAdapter;
import com.example.lab5.models.Donut;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Donut> listDonut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDonut = (Button) findViewById(R.id.donutBtn);
        Button btnPink = (Button) findViewById(R.id.pinkBtn);
        Button btnFloating = (Button) findViewById(R.id.floatingBtn);
        EditText txtSearch = (EditText) findViewById(R.id.searchTxt);
        listView = (ListView) findViewById(R.id.listView);

        listDonut = new ArrayList<Donut>();
        listDonut.add(new Donut("Tasty Donut", "Spicy tasty donut family", "$10.00", R.drawable.donut_yellow_1));
        listDonut.add(new Donut("Pink Donut", "Spicy tasty donut family", "$20.00", R.drawable.tasty_donut_1));
        listDonut.add(new Donut("Floating Donut", "Spicy tasty donut family", "$30.00", R.drawable.green_donut_1));
        listDonut.add(new Donut("Tasty Donut", "Spicy tasty donut family", "$30.00", R.drawable.donut_red_1));
        listDonut.add(new Donut("Tasty Donut", "Spicy tasty donut family", "$30.00", R.drawable.donut_red_1));

        DonutAdapter donutAdapter = new DonutAdapter(this, R.layout.donut_item, listDonut);
        listView.setAdapter(donutAdapter);

        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donutAdapter.donutFilter("");
            }
        });

        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donutAdapter.donutFilter("pink");
            }
        });

        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donutAdapter.donutFilter("floating");
            }
        });

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                donutAdapter.donutFilter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}