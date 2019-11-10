package com.appsquadz.placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appsquadz.placement.response.Login_Respo.Data;

public class OtpActivity extends AppCompatActivity {
    private EditText otp;
    private Button verifyotp;
    private TextView resendotp;
    int otplast=0;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        getSupportActionBar().setTitle("OTP Verification");
        otplast = getIntent().getIntExtra("otp",0);

        otp = findViewById(R.id.otp);
        verifyotp = findViewById(R.id.verify);
        resendotp = findViewById(R.id.resend_otp);
        verifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respo1=(otp.getText().toString());
                String respo2=Integer.toString(otplast);

                if (!otp.getText().toString().trim().isEmpty() ) {
                    if(respo2.equals(respo1))
                        startActivity(new Intent(OtpActivity.this, VerifyActivity.class));
                    finish();
                }

            }
        });
    }
}
