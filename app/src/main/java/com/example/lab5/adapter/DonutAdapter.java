package com.example.lab5.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.lab5.ItemDetail;
import com.example.lab5.R;
import com.example.lab5.models.Donut;

import java.util.ArrayList;
import java.util.List;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Donut> listDonut;
    private List<Donut> listFilterDonut;

    public DonutAdapter(Context context, int idLayout, List<Donut> listDonut) {
        this.context = context;
        this.idLayout = idLayout;
        this.listDonut = listDonut;
        this.listFilterDonut = this.listDonut;
    }

    @Override
    public int getCount() {
        if (listFilterDonut.size() != 0) {
            return listFilterDonut.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        TextView price = (TextView) view.findViewById(R.id.price);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        final ConstraintLayout itemLayout = (ConstraintLayout) view.findViewById(R.id.idItemLayout);
        final ConstraintLayout cardLayout = (ConstraintLayout) view.findViewById(R.id.cardConstraint);
        final ConstraintLayout imgLayout = (ConstraintLayout) view.findViewById(R.id.imgConstraint);
        final Donut donut = listDonut.get(i);

        if(!listFilterDonut.isEmpty()) {
            name.setText(donut.getName());
            desc.setText(donut.getDesc());
            price.setText(donut.getPrice());
            img.setImageResource(donut.getImg());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("detailName", donut.getName());
                bundle.putString("detailDesc", donut.getDesc());
                bundle.putString("detailPrice", donut.getPrice());
                bundle.putInt("detailImg", donut.getImg());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return view;
    }

    public void donutFilter(String keyword) {
        this.listFilterDonut = new ArrayList<Donut>();
        if(keyword.equals("")) {
            this.listFilterDonut = this.listDonut;
        } else {
            for (Donut d : this.listDonut) {
                if(d.getName().toLowerCase().contains(keyword)) {
                    this.listFilterDonut.add(d);
                }
            }
        }
        notifyDataSetChanged();
    }
}
