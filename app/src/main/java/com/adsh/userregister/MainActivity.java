package com.adsh.userregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, password, rePassword;
    private RelativeLayout relativeLayout;
    private RadioGroup gender;
    private Spinner country;
    private CheckBox agree;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        rePassword = findViewById(R.id.txtReEnterPassword);
        gender = findViewById(R.id.radioGroup);
        country = findViewById(R.id.countrySpinner);
        agree = findViewById(R.id.agreeCheckBox);
        register = findViewById(R.id.registerBtn);
        relativeLayout = findViewById(R.id.parent);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() == 0 || email.getText().toString().length() == 0
                || password.getText().toString().length() == 0 || rePassword.getText().toString().length() ==0
                || !password.getText().toString().equals(rePassword.getText().toString()) ||
                gender.getCheckedRadioButtonId() == -1 || country.getSelectedItem() == null || !agree.isChecked()){
                    showSnackbar();
                }else {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void showSnackbar(){
        Snackbar.make(relativeLayout,"Need input",Snackbar.LENGTH_INDEFINITE)
                .setAction("retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setTextColor(Color.BLUE)
                .setActionTextColor(Color.RED)
                .show();
    }
    //TODO button
}