package com.reserva.users.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.reserva.R;
import com.reserva.employe.ReservasiDetail;
import com.reserva.employe.adapter.AdapterReservasi;
import com.reserva.employe.model.ReservasiModel;
import com.reserva.users.model.HistoryModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<HistoryModel> listRecyclerItem;

    public HistoryAdapter(Context context, List<HistoryModel> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvnama, tvtanggal, tvservice;
        private AppCompatButton btkonfirmasi;



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnama = itemView.findViewById(R.id.namaHistory);
            tvtanggal = (TextView) itemView.findViewById(R.id.tanggalHistory);
            tvservice = itemView.findViewById(R.id.serviceHistory);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_history, parent, false);

                return new HistoryAdapter.ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:

                HistoryAdapter.ItemViewHolder itemViewHolder = (HistoryAdapter.ItemViewHolder) holder;
                HistoryModel reservasiModel = (HistoryModel) listRecyclerItem.get(position);

                itemViewHolder.tvnama.setText(reservasiModel.getEmailusers());
                itemViewHolder.tvtanggal.setText(reservasiModel.getDateTime());
                itemViewHolder.tvservice.setText(reservasiModel.getProduk());
                        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }


}
