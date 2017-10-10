package com.example.steven.spaghetti;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class LogIn extends AppCompatActivity implements View.OnClickListener {


    private static final int SIGN_IN_REQUEST_CODE = 1;
    private Button btnSignIn;

    private EditText editTextEmail;
    private EditText editTextPassword;

    RelativeLayout activity_log_in;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //Init Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnSignIn = (Button) findViewById(R.id.buttonSignIn);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        activity_log_in = (RelativeLayout) findViewById(R.id.activity_log_in);

        btnSignIn.setOnClickListener(this);


        //Check session, IF success -> dashboard
        //if (mAuth.getCurrentUser() != null) {
         //   startActivity(new Intent (LogIn.this, Dashboard.class));
        //}
    }

    //CHECK if user is signed in
    /*@Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        startActivity(new Intent(LogIn.this, Homepage.class));
    }*/

    //Sign in process
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonSignIn) {
                logInUser(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
    }

    private void logInUser(String email, final String password) {
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LogIn.this, "Welcome " +
                                    FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LogIn.this, Homepage.class));

                        } else {
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}

