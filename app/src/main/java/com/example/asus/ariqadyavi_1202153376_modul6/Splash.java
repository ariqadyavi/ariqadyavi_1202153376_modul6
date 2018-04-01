package com.example.asus.ariqadyavi_1202153376_modul6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread three = new Thread(){
            public void run(){
                try{
                    sleep(4000); //4 detik
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(Splash.this, Login.class)); //jika berhasil langsung menuju kelas Login
                    finish();
                }
            }
        };
        three.start();
    }


}
