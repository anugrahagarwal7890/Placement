package com.appsquadz.placement;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsquadz.placement.response.Login_Respo.StuList.Data;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Items> {

    List<com.appsquadz.placement.response.Login_Respo.StuList.Data> data;
    Context context;
    LayoutInflater mInflater;

    public StudentAdapter(Activity activity, List<Data> data) {
        this.data = data;
        context = activity;
        mInflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public Items onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StudentAdapter.Items(mInflater.inflate(R.layout.card_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Items items, int i) {
        items.name.setText(data.get(i).getName());
        items.roll_no.setText(data.get(i).getRoll_no());
        items.graduation.setText(data.get(i).getGraduation());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Items extends RecyclerView.ViewHolder {
        TextView name,roll_no,graduation;
        public Items(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            roll_no = itemView.findViewById(R.id.txt_roll_no);
            graduation = itemView.findViewById(R.id.txt_branch);
        }
    }


}