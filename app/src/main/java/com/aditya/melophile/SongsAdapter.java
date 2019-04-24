package com.aditya.melophile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private List<ListItem> listItems;

    private Context context;

    public SongsAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override   
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);

        return new SongsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder songsViewHolder, int i) {
        ListItem listItem = listItems.get(i);
        songsViewHolder.sname.setText(listItem.getName());

    }

    @Override
    public int getItemCount() {
       return listItems.size();
       // return listItems == null ? 0 : listItems.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder {

        public TextView sname;

        public SongsViewHolder(@NonNull View itemView) {
            super(itemView);

            sname = (TextView) itemView.findViewById(R.id.sname);
        }
    }

}
