package com.reserva.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManagerEmployee {
    public static final String SP_EMPLOYEE_APP = "spEmployee";

    public static final String SP_EMAIL_EMPLOYEE = "spEmailEmployee";
    public static final String SP_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManagerEmployee(Context context){
        sp = context.getSharedPreferences(SP_EMPLOYEE_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL_EMPLOYEE, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_LOGIN, false);
    }
}
