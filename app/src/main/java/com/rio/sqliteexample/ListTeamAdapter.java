package com.rio.sqliteexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Team> listTeam;

    public ListTeamAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(ArrayList<Team> listTeam) {
        this.listTeam = listTeam;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListTeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTeamAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvNameTeam.setText(getListTeam().get(i).getNameTeam());

    }

    @Override
    public int getItemCount() {
        return getListTeam().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameTeam = itemView.findViewById(R.id.tv_item_name);

        }
    }
}
