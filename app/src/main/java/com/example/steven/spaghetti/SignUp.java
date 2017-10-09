package com.example.steven.spaghetti;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private Button btnSignUp;
    private TextView gotAccount;

    private EditText inputTextEmail;
    private EditText inputTextPassword;

    private RelativeLayout activity_sign_up;

    private FirebaseAuth mAuth;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Init Firebase
        mAuth = FirebaseAuth.getInstance();

        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        inputTextEmail = (EditText) findViewById(R.id.editTextEmail);
        inputTextPassword = (EditText) findViewById(R.id.editTextPassword);
        gotAccount = (TextView) findViewById(R.id.gotAccount);
        activity_sign_up = (RelativeLayout) findViewById(R.id.activity_sign_up);

        btnSignUp.setOnClickListener(this);
        gotAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.gotAccount) {
            startActivity(new Intent(SignUp.this, LogIn.class));
            finish();
        } else if (view.getId() == R.id.buttonSignUp) {
            signUpUser(inputTextEmail.getText().toString(), inputTextPassword.getText().toString());
            startActivity(new Intent(SignUp.this, LogIn.class));
        }
    }

    private void signUpUser(String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(password.length() < 6) {
                            Toast.makeText(SignUp.this, "Password must have at least 6 letters",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else if (!task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Failed to sign up",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "Sign up success",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}