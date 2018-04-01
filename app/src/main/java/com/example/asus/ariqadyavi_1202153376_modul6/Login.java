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

public class Login extends AppCompatActivity {

    private EditText emaiLogin; //deklarasi edittext
    private EditText passLogin; //deklarasi edittext
    private Button btnLogin; //deklarasi button
    private Button goRegister; //deklarasi button
    private FirebaseAuth firebaseAuth; //deklarasi firebash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emaiLogin = (EditText) findViewById(R.id.emaiLogin);
        passLogin = (EditText) findViewById(R.id.passLogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void go(View view) {
        startActivity(new Intent(Login.this, Register.class)); //jika berhasil langsung menuju kelas Login
        finish();
    }

    public void Login(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(Login.this, "Please wait...", "Processing...", true); //pembuatan progress dialog untuk proses login
        (firebaseAuth.signInWithEmailAndPassword(emaiLogin.getText().toString(), passLogin.getText().toString())) //menyesuaikan isi dari input text email dan password dengan yang sudah terdaftar di firebase
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) { //bila berhasil bisa menuju ke kelas selanjutnya
                            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Login.this, MainActivity.class);
                            i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        } else { //bila gagal muncul text penolakan
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}

