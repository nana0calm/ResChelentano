package com.example.navigationactivitymenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DishListAdapter extends RecyclerView.Adapter<DishListAdapter.ViewHolder>{
    private LayoutInflater inflater;

    private List<DishItem> pizzas;
    public DishListAdapter(Context context, List<DishItem> pizzas) {

        this.pizzas = pizzas;

        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DishListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.dish_block, parent, false);
        return new ViewHolder(view);}
    @Override
    public void onBindViewHolder(final DishListAdapter.ViewHolder holder, int position) {
        DishItem pizza = pizzas.get(position);

        Picasso.get().load(pizza.getResImage()).fit().centerCrop().into(holder.imageView);

        holder.nameView.setText(pizza.getFood_name());

        holder.priceView.setText(pizza.getFood_price());

        holder.weightView.setText(pizza.getWeight());


        holder.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.include_order_button.setVisibility(View.GONE);
                holder.include.setVisibility(View.VISIBLE);
            }
        });

        holder.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tvValCount=holder.countBtn.getText().toString();
                int valIntCount=Integer.parseInt(tvValCount);
                holder.orderBtn.setVisibility(View.VISIBLE);
                if(holder.countBtn.getText().equals("0")){
                    holder.include.setVisibility(View.GONE);
                    holder.include_order_button.setVisibility(View.VISIBLE);
                }
                else{
                    valIntCount--;
                    holder.include.setVisibility(View.VISIBLE);
                    holder.include_order_button.setVisibility(View.GONE);
                }
                holder.countBtn.setText(valIntCount+" ");

            }
        });

        holder.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tvValCount=holder.countBtn.getText().toString();
                int valIntCount=Integer.parseInt(tvValCount);
                holder.include_order_button.setVisibility(View.GONE);
                holder.include.setVisibility(View.VISIBLE);
                if(valIntCount!=0){
                    valIntCount++;
                }
                holder.countBtn.setText(valIntCount+" ");
            }
        });

    }
    @Override
    public int getItemCount() {
        return pizzas.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        final AppCompatImageView imageView;
        final AppCompatTextView nameView, priceView, weightView, countBtn;
        final AppCompatImageButton minusBtn, plusBtn;
        final AppCompatButton orderBtn;
        final View include;
        final View include_order_button;
        ViewHolder(View view){
            super(view);
            imageView = (AppCompatImageView) view.findViewById(R.id.imageViewDish);
            nameView = (AppCompatTextView) view.findViewById(R.id.dishname);
            priceView = (AppCompatTextView) view.findViewById(R.id.textViewPrice);
            weightView=(AppCompatTextView)view.findViewById(R.id.textViewGram);
            countBtn=(AppCompatTextView)view.findViewById(R.id.countTextView);
            minusBtn=(AppCompatImageButton) view.findViewById(R.id.minusBtn);
            plusBtn=(AppCompatImageButton) view.findViewById(R.id.plusBtn);
            orderBtn=(AppCompatButton) view.findViewById(R.id.orderBtn);
            include=view.findViewById(R.id.include);
            include_order_button=view.findViewById(R.id.include_order_button);

        }
    }
}
