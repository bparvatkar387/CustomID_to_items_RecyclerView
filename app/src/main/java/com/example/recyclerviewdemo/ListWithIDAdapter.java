package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ListWithIDAdapter extends RecyclerView.Adapter<ListWithIDAdapter.ViewHolder>{

    private ArrayList<String> hsptNames = new ArrayList<>();
    private ArrayList<Integer> hsptID = new ArrayList<>();
    private Context context;

    public ListWithIDAdapter(Context context, ArrayList<Integer> hsptID, ArrayList<String> hsptNames) {
        this.hsptNames = hsptNames;
        this.hsptID = hsptID;
        this.context = context;
    }

    //below method same of almost any recyclerViews, just change the layout depending on use
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //to bind hospital name to the textview
        holder.hsptName.setText(hsptNames.get(position));
        //get hospital id when clicked on it
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, String.valueOf(hsptID.get(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //if this is not correct then the List wont appear
        //can use any Array to get the size
        return hsptNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hsptName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hsptName = itemView.findViewById(R.id.hsptName);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
