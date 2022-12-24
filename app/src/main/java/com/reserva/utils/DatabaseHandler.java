package com.reserva.utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.reserva.employe.model.ReservasiModel;
import com.reserva.users.model.HistoryModel;
import com.reserva.users.model.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "reserva.sqlite";

    // table name
    private static final String KARYAWAN = "Karyawan";
    private static final String USERS = "Users";
    private static final String TRANSAKSI = "Transaksi";



    // column tables karyawan
    private static final String ID_COL = "id";
    private static final String EMAIL_COL = "email";
    private static final String PASS = "password";
   
    // column tables users
    private static final String ID_USERS_COL = "id";
    private static final String NAME_USERS_COL = "nama";
    private static final String EMAIL_USERS_COL = "email";
    private static final String PASSWORD_USERS_COL = "password";
    private static final String NO_TLP_USERS_COL = "notlp";

    //coloumn tables transaksi
    private static final String ID_TRANSAKSI_COL = "idTransaksi";
    private static final String EMAIL_TRANSAKSI_COL= "emailtrs";
    private static final String TREATMENT_USERS_COL = "treatment";
    private static final String SCHEDULE_USERS_COL = "schedule";
    private static final String TOTAL_USERS_COL = "total";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String karyawan = "CREATE TABLE " + KARYAWAN + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + PASS + " TEXT)";
        sqLiteDatabase.execSQL(karyawan);

        String users = "CREATE TABLE " + USERS + "("
                + ID_USERS_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_USERS_COL + " TEXT,"
                + EMAIL_USERS_COL + " TEXT,"
                + PASSWORD_USERS_COL + " TEXT,"
                + NO_TLP_USERS_COL + " TEXT,"
                + TREATMENT_USERS_COL + " TEXT,"
                + SCHEDULE_USERS_COL + " TEXT,"
                + TOTAL_USERS_COL + " TEXT)";
        sqLiteDatabase.execSQL(users);

       String transaksi = "CREATE TABLE " + TRANSAKSI + "("
                + ID_TRANSAKSI_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_TRANSAKSI_COL + " TEXT,"
                + TREATMENT_USERS_COL + " TEXT,"
                + SCHEDULE_USERS_COL + " TEXT,"
                + TOTAL_USERS_COL + " TEXT)";

        sqLiteDatabase.execSQL(transaksi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KARYAWAN);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USERS);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRANSAKSI);
        onCreate(sqLiteDatabase);


    }
    public void addUsers(UsersModel user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nama", user.getNama());
        cv.put("notlp", user.getNotlp());
        cv.put("email", user.getEmail());
        cv.put("password", user.getPassword());
        db.insert(USERS, null, cv);
        db.close();
    }
    public void addTransaksi(HistoryModel trs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("emailtrs", trs.getEmailusers());
        values.put("treatment", trs.getProduk());
        values.put("schedule", trs.getDateTime());
        values.put("total", trs.getTotal());
        db.insert(TRANSAKSI, null, values);
        db.close();
    }
    public List<ReservasiModel> getListReservasi() {
        List<ReservasiModel> List = new ArrayList<>();
        String MY_QUERY = "SELECT Users.nama, Transaksi.treatment, Transaksi.schedule, Transaksi.total FROM Transaksi INNER JOIN Users ON Transaksi.emailtrs = Users.email";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(MY_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                ReservasiModel trs = new ReservasiModel();
                trs.setEmailusers(cursor.getString(0));
                trs.setProduk(cursor.getString(1));
                trs.setDateTime(cursor.getString(2));
                trs.setTotal(cursor.getString(3));

                List.add(trs);
            } while (cursor.moveToNext());
        }

        return List;
    } public List<HistoryModel> getListHistory() {
        List<HistoryModel> List = new ArrayList<>();
        String MY_QUERY = "SELECT Users.nama, Transaksi.treatment, Transaksi.schedule, Transaksi.total FROM Transaksi INNER JOIN Users ON Transaksi.emailtrs = Users.email";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(MY_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                HistoryModel trs = new HistoryModel();
                trs.setEmailusers(cursor.getString(0));
                trs.setProduk(cursor.getString(1));
                trs.setDateTime(cursor.getString(2));
                trs.setTotal(cursor.getString(3));

                List.add(trs);
            } while (cursor.moveToNext());
        }

        return List;
    }



    public boolean checkUsers(String email, String password){
        SQLiteDatabase db = getReadableDatabase();
        String[] col = {ID_COL};
        String selection = EMAIL_USERS_COL + "=?" + " and " + PASSWORD_USERS_COL + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(USERS, col, selection,selectionArgs, null, null, null);
        int count = cursor.getCount();
        db.close();

        if (count>0)
            return true;
        else
            return false;

    }

}
