package com.example.shop.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.R;
import com.example.shop.databinding.ItemOrderBinding;
import com.example.shop.models.ModelM;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {
    ItemOrderBinding binding;
    Context context;
    ArrayList<ModelM> nnList;

    public BasketAdapter( Context context, ArrayList<ModelM> nnList) {
        this.context = context;
        this.nnList = nnList;
    }

    @NonNull
    @Override
    public BasketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketAdapter.ViewHolder holder, int position) {
        holder.onBind(nnList.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderBinding binding;

        public ViewHolder(@NonNull ItemOrderBinding itemView) {
            super(itemView.getRoot());
            this.binding  = itemView;
        }

        public void onBind(ModelM modelM) {
            binding.productNameCard.setText(modelM.getTitle());
            binding.priceCard.setText(String.valueOf(modelM.getPrice()));

            Picasso.get()
                    .load(nnList.get(getAdapterPosition()).getImage())
                    .placeholder(R.drawable.ic_home_black_24dp)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageCard);

//            final int[] pp = {Integer.parseInt(binding.prodCounter.getText().toString())};
//
//            binding.btnIncrement.setOnClickListener(v1 -> {
//                binding.prodCounter.setText(String.valueOf(pp[0]++));
//                int[] cb = new int[]{modelM.getCounterProduct()};
//                cb = pp;
//            });
//
//            binding.btnDecrement.setOnClickListener(v2 -> {
//                if (pp[0] > 2) binding.prodCounter.setText(String.valueOf(pp[0]--));
//                else binding.prodCounter.setText("1");
//                int[] cb = new int[]{modelM.getCounterProduct()};
//                cb = pp;
//            });
        }
    }

    @Override
    public int getItemCount() {
        return nnList.size();
    }
}