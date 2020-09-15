package com.example.a13092020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etLastName, etUserName, etEmail, etPass, etConfirmPass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {
        etLastName = findViewById(R.id.etLastName);
        etUserName = findViewById(R.id.etUserName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etConfirmPass = findViewById(R.id.etPass_confirm);
        register = findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUserName.getText().toString().length() == 0){
                    etUserName.setError("Name is not entered");
                }
                else if (etLastName.getText().toString().length() == 0){
                    etLastName.setError("Last name isn't entered");
                }
                else if (etPass.getText().toString().length() < 8){
                    etPass.setError("Wrong password");
                }
                else if (!etPass.getText().toString().equals(etConfirmPass.getText().toString())){
                    etConfirmPass.setError("Password not matched");
                }

                String email = etEmail.getText().toString();
                if (email.length() != 0){
                    if (isValidEmail(email)) {

                    } else {
                        etEmail.setError("Email required");
                    }
                } else {
                    etEmail.setError("Email required");
                }
            }
        });
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
    }

    public static boolean isValidEmail(String email) {

       return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}