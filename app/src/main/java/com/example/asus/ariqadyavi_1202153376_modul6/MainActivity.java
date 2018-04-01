package com.example.asus.ariqadyavi_1202153376_modul6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //mendapatkan id dari item yang
        int id = item.getItemId();
        //apabila item yang dipilih adalah setting
        if (id==R.id.logout){
            //membuat intent ke menu Settings
            Intent intent = new Intent(MainActivity.this, Login.class);
            //memulai intent
            startActivity(intent);
            //menutup aktivitas setelah intent dijalankan
            finish();
        }
        return true;
    }

    public void caw(View view) {
        startActivity(new Intent(MainActivity.this, Post.class)); //jika berhasil langsung menuju kelas Login
        finish();
    }
}
