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
import com.reserva.employe.SaleIn;
import com.reserva.employe.model.SaleInModel;
import com.reserva.employe.model.StokBarangModel;

import java.util.List;

public class AdapterSaleIn extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public AdapterSaleIn(Context context, List<Object> listRecyclerItem) {
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

                return new AdapterSaleIn.ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                AdapterSaleIn.ItemViewHolder itemViewHolder = (AdapterSaleIn.ItemViewHolder) holder;
                SaleInModel saleInModel = (SaleInModel) listRecyclerItem.get(position);

                itemViewHolder.tvproduk.setText(saleInModel.getProduk());
                itemViewHolder.tvjumlah.setText(String.valueOf(saleInModel.getJumlah()));
                itemViewHolder.tvtgl.setText(saleInModel.getTglin());
                Glide.with(context)
                        .load(saleInModel.getImage())
                        .into(itemViewHolder.tvimage);

        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
