package com.example.natureguide;

<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
=======
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
<<<<<<< HEAD
=======

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    //fields
    EditText userEmail, userPass;
<<<<<<< HEAD
    Button btnMoveToRegister;
=======
    Button  btnMoveToRegister;
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Checking if user signed in
            startActivity(new Intent(LoginPage.this, MainActivity.class));
<<<<<<< HEAD
        } 
=======
        } else {
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
            // If not signed in doing nothing..
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();

        //connect object to views
        //user info
        userEmail = findViewById(R.id.LoginUserEmail);
        userPass = findViewById(R.id.LoginUserPassword);
<<<<<<< HEAD
        //buttons
        (findViewById(R.id.LoginBtnLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userEmail.getText().toString().equals("") || userPass.getText().toString().equals("")) {
                    Toast.makeText(LoginPage.this, "שדות חסרים", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString())
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    updateUI(null);
                                }
                            }
                        });
            }
        });
        btnMoveToRegister = findViewById(R.id.LoginBtnMoveToRegister);
        btnMoveToRegister.setOnClickListener(new View.OnClickListener() {
=======
            //buttons
        (findViewById(R.id.LoginBtnLogin)).setOnClickListener(new View.OnClickListener() {
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
            @Override
            public void onClick(View v) {
                /* Checking if first password field matches the second
                if (userPass1.getText().toString() != userPass2.getText().toString())
                 */
                mAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString())
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    updateUI(null);
                                }

                                // ...
                            }
                        });
            }
        });
<<<<<<< HEAD
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            startActivity(new Intent(LoginPage.this, MainActivity.class));
        } else {
            Toast.makeText(LoginPage.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
=======
                btnMoveToRegister = findViewById(R.id.LoginBtnMoveToRegister);
                btnMoveToRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(LoginPage.this, RegisterPage.class));
                    }
                });

            }

            private void updateUI(FirebaseUser user) {
                if (user != null) {
                    startActivity(new Intent(LoginPage.this, MainActivity.class));

                } else {
                    Toast.makeText(LoginPage.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
>>>>>>> f4e0fbc30fa26f66e68ee052a075049b1c7e5ef7
