package com.reserva.employe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.reserva.R;
import com.reserva.employe.ReservasiDetail;
import com.reserva.employe.model.ReservasiModel;
import com.reserva.employe.model.StokBarangModel;

import java.util.List;

public class AdapterReservasi extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<ReservasiModel> listRecyclerItem;

    public AdapterReservasi(Context context, List<ReservasiModel> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvnama, tvtanggal, tvservice;
        private AppCompatButton btkonfirmasi;



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnama = itemView.findViewById(R.id.namaUser);
            tvtanggal = (TextView) itemView.findViewById(R.id.tanggal);
            tvservice = itemView.findViewById(R.id.service);
            btkonfirmasi = itemView.findViewById(R.id.confirmbutton);


        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.items_reservasi, parent, false);

                return new AdapterReservasi.ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                AdapterReservasi.ItemViewHolder itemViewHolder = (AdapterReservasi.ItemViewHolder) holder;
                ReservasiModel reservasiModel = (ReservasiModel) listRecyclerItem.get(position);

                itemViewHolder.tvnama.setText(reservasiModel.getEmailusers());
                itemViewHolder.tvtanggal.setText(reservasiModel.getDateTime());
                itemViewHolder.tvservice.setText(reservasiModel.getProduk());

                itemViewHolder.btkonfirmasi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent konfirm = new Intent(itemViewHolder.itemView.getContext(), ReservasiDetail.class);
                        konfirm.putExtra("nama", reservasiModel.getEmailusers());
                        konfirm.putExtra("tanggal", reservasiModel.getDateTime());
                        konfirm.putExtra("service", reservasiModel.getProduk());
                        itemViewHolder.itemView.getContext().startActivity(konfirm);



                    }
                });


        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
