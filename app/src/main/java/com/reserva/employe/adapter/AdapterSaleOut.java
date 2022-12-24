package com.reserva.employe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.reserva.R;
import com.reserva.employe.model.SaleOutModel;

import java.util.List;

public class AdapterSaleOut extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public AdapterSaleOut(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvproduk, tvjumlah,tvtgl;
        private ImageView tvimage;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvproduk = (TextView) itemView.findViewById(R.id.namain);
            tvjumlah = (TextView) itemView.findViewById(R.id.stokin);
            tvimage = itemView.findViewById(R.id.imagein);
            tvtgl = itemView.findViewById(R.id.tglin);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_sale, parent, false);

                return new AdapterSaleOut.ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                AdapterSaleOut.ItemViewHolder itemViewHolder = (AdapterSaleOut.ItemViewHolder) holder;
                SaleOutModel saleOutModel = (SaleOutModel) listRecyclerItem.get(position);

                itemViewHolder.tvproduk.setText(saleOutModel.getProduk());
                itemViewHolder.tvjumlah.setText(String.valueOf(saleOutModel.getJumlah()));
                itemViewHolder.tvtgl.setText(saleOutModel.getTglin());
                Glide.with(context)
                        .load(saleOutModel.getImage())
                        .into(itemViewHolder.tvimage);

        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
