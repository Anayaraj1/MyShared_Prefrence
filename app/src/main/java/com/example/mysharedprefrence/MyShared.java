package com.example.mysharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;

public class MyShared
{
   SharedPreferences.Editor editor;
   SharedPreferences sharedPreferences;
   public MyShared(Context context)
   {
       sharedPreferences = context.getSharedPreferences("mypref_file",Context.MODE_PRIVATE);
   }

   void storeData(String username,String email,String password)
   {
       editor = sharedPreferences.edit();
       editor.putString("username",username);
       editor.putString("email",email);
       editor.putString("password",password);

       editor.apply();
       editor.commit();
   }

   void login(boolean status)
   {
       editor = sharedPreferences.edit();
       editor.putBoolean("status",status);
       editor.apply();
       editor.commit();
   }

   boolean checkLogin()
   {
       boolean status = sharedPreferences.getBoolean("status",false);
       return status;
   }

   void clearData()
   {
       editor = sharedPreferences.edit();
       editor.clear();
       editor.apply();
       editor.commit();
   }
}
