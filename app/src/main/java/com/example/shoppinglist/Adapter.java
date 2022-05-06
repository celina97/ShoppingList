package com.example.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    
    private List<ShoppingList> shoppingList;

    private RecyclerViewClickListener listener;

    public Adapter(List<ShoppingList> shoppingList, RecyclerViewClickListener listener){

        this.shoppingList = shoppingList;
        this.listener = listener;
    }
    
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = shoppingList.get(position).getImageview1();
        String name = shoppingList.get(position).getTextview();
        String detail = shoppingList.get(position).getTextview3();
        String line = shoppingList.get(position).getDivider();
        
        holder.setData(resource, name, detail, line);

    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView textView;
        private TextView textView3;
        private TextView divider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview1);
            textView = itemView.findViewById(R.id.textview);
            textView3 = itemView.findViewById(R.id.textview3);
            divider = itemView.findViewById(R.id.divider);

            imageView.setOnClickListener(this);

        }

        public void setData(int resource, String name, String detail, String line) {

            imageView.setImageResource(resource);
            textView.setText(name);
            textView3.setText(detail);
            divider.setText(line);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAbsoluteAdapterPosition());
        }
    }
}
