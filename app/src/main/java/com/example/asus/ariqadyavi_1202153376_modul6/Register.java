package com.example.asus.ariqadyavi_1202153376_modul6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ASUS on 01/04/2018.
 */

public class Register extends AppCompatActivity {

    private EditText email; //deklarasi edittext
    private EditText username; //deklarasi edittext
    private EditText password; //deklarasi edittext
    private Button submit; //deklarasi button
    private FirebaseAuth firebaseAuth; //deklarasi firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        email = (EditText) findViewById(R.id.email); //pemanggilan edittext
        username = (EditText) findViewById(R.id.username); //pemanggilan edittext
        password = (EditText) findViewById(R.id.password); //pemanggilan edittext
        firebaseAuth = FirebaseAuth.getInstance(); //pemanggilan firebase

    }

    public void Submit(View view) {

        final ProgressDialog progressDialog = ProgressDialog.show(Register.this, "Please wait...", "Processing...", true); //pembuatan progress dialog saat register
        (firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) { //penyimpanan data dari input text email dan password
                progressDialog.dismiss();

                if (task.isSuccessful()) { // bila berhasil akan menuju ke activity selanjutnya
                    Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Register.this, Login.class);
                    startActivity(i);
                }
                else
                { // bila ada kurang akan dapat pesan error
                    Log.e("ERROR", task.getException().toString());
                    Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }


            }

        });
    }
}

