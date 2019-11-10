package com.appsquadz.placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appsquadz.placement.response.Login_Respo.Data;
import com.appsquadz.placement.response.Login_Respo.Interface;
import com.appsquadz.placement.response.Login_Respo.LoginRespo;
import com.appsquadz.placement.response.Login_Respo.SharedManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity{

    EditText edtid,edtpass;
    Button button;
    TextView device,forget;
    Retrofit retrofit;
    private SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtid = findViewById(R.id.edt_id);
        edtpass = findViewById(R.id.edt_pass);
        device=findViewById(R.id.txt_device);
        button = findViewById(R.id.btn_button);
        forget=findViewById(R.id.txt_forgot);

       // sharedPrefManager = new SharedPrefManager()Manager(this);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        retrofit =new Retrofit
                .Builder()
                .baseUrl("http://192.168.0.104/placement/index.php/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApiData(edtid.getText().toString(), edtpass.getText().toString(),device.getText().toString());
                //startActivity(new Intent(SignInActivity.this,Home_Page.class));
            }
        });

    }

            private void getApiData(String username, String password,String device_token) {

                Interface api=retrofit.create(Interface.class);
                Call<LoginRespo> response=api.getLogin(username,password,"1212131213211");
                response.enqueue(new Callback<LoginRespo>() {
                    @Override
                    public void onResponse(Call<LoginRespo> call, Response<LoginRespo> response) {
                      //  Toast.makeText(SignInActivity.this,"Api Hitted....",Toast.LENGTH_SHORT).show();
//                        Toast.makeText(SignInActivity.this,response.body().toString(),Toast.LENGTH_SHORT).show();
                        if(response.body() != null) {
                            LoginRespo data = response.body();
                            if (data.getStatus()) {
                                Toast.makeText(SignInActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                if(data.getData().getUser_type().equals("3")){
                                    startActivity(new Intent(SignInActivity.this,Home_Page.class));
                                }
                                else if(data.getData().getUser_type().equals("2")){
                                    startActivity(new Intent(SignInActivity.this,OtpActivity.class));
                                }
                                else{
                                    Toast.makeText(SignInActivity.this,"Invalid Credentials..",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(SignInActivity.this,"Invalid Credentials..",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginRespo> call, Throwable t) {
                        Toast.makeText(SignInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }