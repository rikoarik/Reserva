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
import com.reserva.employe.model.StokBarangModel;

import java.util.List;

public class AdapterStokBarang extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public AdapterStokBarang(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvproduk, tvjumlah;
        private ImageView tvimage;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvproduk = (TextView) itemView.findViewById(R.id.namaBarang);
            tvjumlah = (TextView) itemView.findViewById(R.id.stokBarang);
            tvimage = itemView.findViewById(R.id.imagebarang);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.items_stokbarang, parent, false);

                return new ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                StokBarangModel stokBarangModel = (StokBarangModel) listRecyclerItem.get(position);

                itemViewHolder.tvproduk.setText(stokBarangModel.getProduk());
                itemViewHolder.tvjumlah.setText(String.valueOf(stokBarangModel.getJumlah()));
                Glide.with(context)
                        .load(stokBarangModel.getImage())
                        .into(itemViewHolder.tvimage);

        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
