package com.reserva.users;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.reserva.R;
import com.reserva.utils.FunctionHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class BodyCareFragment extends Fragment {
    int tvharga1= 500000, tvharga2=350000, tvharga3=550000, tvharga4=600000;
    TextView tvHarga1,tvHarga2,tvHarga3,tvHarga4;
    EditText tvDateTime;
    int count1=0, count2=0,count3=0,count4=0;
    int total;
    AppCompatButton tvnext;
    CheckBox tvChecbox1, tvChecbox2, tvChecbox3, tvChecbox4;
    String cb1,cb2,cb3,cb4;
    String harga1,harga2,harga3,harga4;
    List<String> listProduk;
    List<String> listJumlah;

    String date_time = "";
    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_body_care, container, false);
        tvHarga1 = view.findViewById(R.id.hargabc1);
        tvHarga2 = view.findViewById(R.id.hargabc2);
        tvHarga3 = view.findViewById(R.id.hargabc3);
        tvHarga4 = view.findViewById(R.id.hargabc4);
        tvChecbox1 = view.findViewById(R.id.checkboxbc1);
        tvChecbox2 = view.findViewById(R.id.checkboxbc2);
        tvChecbox3 = view.findViewById(R.id.checkboxbc3);
        tvChecbox4 = view.findViewById(R.id.checkboxbc4);

        tvnext = view.findViewById(R.id.btNextbc);
        tvDateTime = view.findViewById(R.id.dateTimebc);
        tvDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });

        setHarga();
        clickNext();
        return view;




    }
    private void setHarga(){
        tvHarga1.setText(FunctionHelper.rupiahFormat(tvharga1));
        tvHarga2.setText(FunctionHelper.rupiahFormat(tvharga2));
        tvHarga3.setText(FunctionHelper.rupiahFormat(tvharga3));
        tvHarga4.setText(FunctionHelper.rupiahFormat(tvharga4));




    }
    private void datePicker(){

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        //*************Call Time Picker Here ********************
                        tiemPicker();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void tiemPicker(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        tvDateTime.setText(date_time+" "+hourOfDay + "." + minute + " WIB");
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
    public void clickNext(){
        tvnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getContext(), BON.class);
                listProduk = new ArrayList<>();
                listJumlah = new ArrayList<>();
                if (!tvChecbox1.isChecked() & !tvChecbox2.isChecked()& !tvChecbox3.isChecked()& !tvChecbox4.isChecked() ){
                    Toast.makeText(getContext(), "Pilih barang",Toast.LENGTH_SHORT).show();
                }else if (tvDateTime.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Pilih schedule",Toast.LENGTH_SHORT).show();
                }else {

                    if (tvChecbox1.isChecked()){
                        cb1 = tvChecbox1.getText().toString();
                        harga1 = tvHarga1.getText().toString();
                        count1 = tvharga1;

                        listProduk.add(cb1);
                        listJumlah.add(harga1);
                    }
                    if (tvChecbox2.isChecked()){
                        cb2 = tvChecbox2.getText().toString();
                        harga2 =tvHarga2.getText().toString();
                        count2 = tvharga2;
                        listProduk.add(cb2);
                        listJumlah.add(harga2);
                    }
                    if (tvChecbox3.isChecked()){
                        cb3 = tvChecbox3.getText().toString();
                        harga3 =tvHarga3.getText().toString();
                        count3 = tvharga3;
                        listProduk.add(cb3);
                        listJumlah.add(harga3);
                    }
                    if (tvChecbox4.isChecked()){
                        cb4 = tvChecbox4.getText().toString();
                        harga4 = tvHarga4.getText().toString();
                        count4 = tvharga4;
                        listProduk.add(cb4);
                        listJumlah.add(harga4);
                    }
                    total = count1 + count2 +count3+count4;
                    String totalstr = String.valueOf(total);
                    String datetime = tvDateTime.getText().toString();
                    next.putExtra("total", totalstr);
                    next.putExtra("date", datetime);
                    next.putStringArrayListExtra("Listproduk",  (ArrayList<String>) listProduk);
                    next.putStringArrayListExtra("Listjumlah", (ArrayList<String>) listJumlah);
                    startActivity(next);
                    getActivity().finish();
                }

            }
        });
    }


}