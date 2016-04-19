package com.dev.bins.mvpexample;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bin on 4/19/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    List<String> data = new ArrayList<>();

    OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<String> data) {
        this.data = new ArrayList<>(data);
        notifyDataSetChanged();
    }

    public void append(String d){
        data.add(d);
        notifyItemInserted(this.data.size());
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.tv.setText(data.get(position));
        if (clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.click(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface OnItemClickListener {
        void click(int position);
    }

    class Holder extends RecyclerView.ViewHolder {


        TextView tv;

        public Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }


    }

}
