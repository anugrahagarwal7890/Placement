package com.appsquadz.placement.response.Login_Respo;

import com.appsquadz.placement.response.Login_Respo.Company_List.CompanyList;
import com.appsquadz.placement.response.Login_Respo.StuList.StudentList;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Interface {
 String Base="http://192.168.0.104/placement/index.php/api/";

    @FormUrlEncoded
    @POST("login")
    Call<LoginRespo> getLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("device_token") String device_token
    );
    @FormUrlEncoded
    @POST("change_password")
    Call<JsonObject> getdata(
            @Field("user_id") String user_id,
            @Field("password") String pwd
    );
//   @FormUrlEncoded
//   @POST("Forget_password")
//   Call<ForgetResponse> getOtp(
//           @Field("username") String userName
//   );


   @FormUrlEncoded
   @POST("get_company_list")
   Call<CompanyList> getCompany(@FieldMap HashMap<String,String> username);

   @FormUrlEncoded
   @POST("get_student_list")
   Call<StudentList> getStudent(@FieldMap HashMap<String,String> username);
}
