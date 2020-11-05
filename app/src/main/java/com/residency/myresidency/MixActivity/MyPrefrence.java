package com.residency.myresidency.MixActivity;

import android.app.Application;
import android.content.SharedPreferences;

public class MyPrefrence extends Application {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("mycon", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setLogin(boolean login){
        editor.putBoolean("login",login).commit();
    }
    public static boolean getLogin(){
        return sharedPreferences.getBoolean("login",false);

    }


    public static void setLanguage(String Language) {
        editor.putString("Language", Language).commit();
    }

    public static String getLanguage() {
        return sharedPreferences.getString("Language", "");
    }

     public static void setSelected_Language(String Selected_Language) {
        editor.putString("Selected_Language", Selected_Language).commit();
    }

    public static String getSelected_Language() {
        return sharedPreferences.getString("Selected_Language", "");
    }





    public static void setotpsendclick(String otpsendclick) {
        editor.putString("otpsendclick", otpsendclick).commit();
    }

    public static String getotpsendclick() {
        return sharedPreferences.getString("otpsendclick", "");
    }

}
