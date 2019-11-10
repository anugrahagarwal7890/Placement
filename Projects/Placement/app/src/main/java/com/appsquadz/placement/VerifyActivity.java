package com.appsquadz.placement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyActivity extends AppCompatActivity {
    EditText edtType, edtRetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        Button submit1 = findViewById(R.id.btn_verify);
        edtType = findViewById(R.id.edt_type);
        edtRetype = findViewById(R.id.edt_retype);
        submit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validation(edtType.getText().toString(), edtRetype.getText().toString());
            }
        });
    }
    private void validation(String idT, String passR) {
         if (idT.equals(passR)) {
            startActivity(new Intent(VerifyActivity.this, Home_Page.class));
            finish();
        } else {
            Toast.makeText(this, "Password Mismatched", Toast.LENGTH_SHORT).show();
        }


    }
}

