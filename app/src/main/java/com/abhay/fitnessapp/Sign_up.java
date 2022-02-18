package com.abhay.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Sign_up extends AppCompatActivity {

    TextInputLayout username,password,confirm_password,email;
    Button register;
    private static final String TAG = "Sign_up";
    // [START declare_auth]
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        register=findViewById(R.id.register);
         username=findViewById(R.id.name_signup);

         password=findViewById(R.id.password_signup);
        confirm_password=findViewById(R.id.confirm_pass_signup);
    email=findViewById(R.id.email_signup);



        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
               // createAccount(username,password);
            }
        });



    }

    public void registration()
    {
       String name= username.getEditText().getText().toString().trim();
       String emails=email.getEditText().getText().toString().trim();
        String pass=password.getEditText().getText().toString().trim();
        String confirm=confirm_password.getEditText().getText().toString().trim();

        if(name.isEmpty()){
            username.setError("Full name is required");
            username.requestFocus();
            return ;
        }

        if(emails.isEmpty()){
            email.setError("Full name is required");
            email.requestFocus();
            return ;
        }

        if(pass.isEmpty()){
            password.setError("Full name is required");
            password.requestFocus();
            return ;
        }


        if(confirm.isEmpty()){
            confirm_password.setError("Full name is required");
            confirm_password.requestFocus();
            return ;
        }

        mAuth.createUserWithEmailAndPassword(emails, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Model2 model2=new Model2(emails,name);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                     .setValue(model2).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Sign_up.this, "User ha been Registered " +
                                                "sucessfully ", Toast.LENGTH_SHORT).show();

                                        Intent intent=new Intent(Sign_up.this,Login_page.class);
                                        startActivity(intent);


                                    }
                                    else{
                                        Toast.makeText(Sign_up.this, "Failed to registered ",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Sign_up.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });

    }







    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }


    private void updateUI(FirebaseUser user) {

    }
    private void reload() { }
}