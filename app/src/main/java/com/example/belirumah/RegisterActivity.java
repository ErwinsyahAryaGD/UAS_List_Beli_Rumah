package com.example.belirumah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    TextView alredyHaveAccount;
    EditText inputEmail, inputPassword,inputConformPassword;
    Button btnRegister;
    String emailPattern  = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alredyHaveAccount=findViewById(R.id.ke_login);

        inputEmail=findViewById(R.id.reg_Email);
        inputPassword=findViewById(R.id.reg_Password);
        inputConformPassword=findViewById(R.id.reg_confirmPass);
        btnRegister=findViewById(R.id.daftar);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        alredyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preforAuth();
            }    
        });

    }

    private void preforAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String CorfrimPassword=inputConformPassword.getText().toString();

        if(!email.matches(emailPattern)) {
            inputEmail.setError("Enter Context Email");
        }else if(password.isEmpty() || password.length()<6)
        {
            inputPassword.setError("Enter Proper Password");
        }else if (!password.equals(CorfrimPassword))
        {
            inputConformPassword.setError("Password not Match");
        }else
        {
            progressDialog.setMessage("Please wait while Registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this,"Registaration Successful", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent (RegisterActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}