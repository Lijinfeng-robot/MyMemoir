package com.example.mymemoir.networkconnection;

import com.example.mymemoir.datastructure.Credentials;
import com.example.mymemoir.datastructure.Usertable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author LiJinFeng
 */
public class NetworkConnection {
  private OkHttpClient client = null;
  private String results_passWord;
  private String results_firstName;
  public String curtime;
  public String mainTemp;
  public static String[] MainResults = new String[20];
  String mainResult;
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  public NetworkConnection() {
    client = new OkHttpClient();
  }

  private static final String BASE_URL = "http://10.0.2.2:8080/FIT5046/webresources/username.credentials/";

  public String userLogin_user(String username) {
    // this method is intended to verify
    Request.Builder builder = new Request.Builder();
    builder.url(BASE_URL + "findPasswordByUsername/" + username);
    Request request = builder.build();
    try {
      Response response = client.newCall(request).execute();
      results_passWord = response.body().string();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return results_passWord;
  }

  public String findFirstNameByUsername(String username) {
    // this method is intended to verify
    Request.Builder builder = new Request.Builder();
    builder.url(BASE_URL + "findFirstNameByUsername/" + username);
    Request request = builder.build();
    try {
      Response response = client.newCall(request).execute();
      results_firstName = response.body().string();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return results_firstName;
  }

  public String userSignUp(String[] details){
    String tempres = "";
    String strResponse="";

    Request.Builder builder = new Request.Builder();
    builder.url(BASE_URL + "count");
    Request request = builder.build();
    try {
      Response response= client.newCall(request).execute();
      tempres = response.body().string();
    } catch (Exception e)
    {
      e.printStackTrace();
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if(details[3] == null){
      return "PLEASE CHOOSE CORRECT DOB";
    }else if(details[6].isEmpty()){
      return "PLEASE INPUT CORRECT POSTCODE!";
    }else if(details[8].isEmpty()){
      return "PLEASE INPUT CORRECT PASSWORD!";
    }
    Date date = new Date();
    try {
      date = simpleDateFormat.parse(details[3]);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Date date2 = new Date(System.currentTimeMillis());
    curtime = simpleDateFormat.format(date2);

    Usertable user = new Usertable(Integer.parseInt(tempres)+1,details[1],details[0],details[2],date,details[4],details[5],Integer.valueOf(details[6]));
    Credentials cre = new Credentials(Integer.parseInt(tempres)+1,details[7],MD5.md5Password(details[8]),date2);
    cre.setUserId2(user);
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'").create();
    String studentJson = gson.toJson(cre);
    final String methodPath = "SignUp/";
    RequestBody body = RequestBody.create(studentJson, JSON);
    Request request2 = new Request.Builder() .url(BASE_URL + methodPath) .post(body) .build();
    try {
      Response response= client.newCall(request2).execute();
      strResponse= response.body().string();
    }
    catch (Exception e) { e.printStackTrace(); }

    return strResponse;
  }

  public void mainScreen(String username){
    Request.Builder builder = new Request.Builder();
    builder.url(BASE_URL + "findIdyUsername/" + username);
    Request request = builder.build();
    try {
      Response response = client.newCall(request).execute();
      mainTemp = response.body().string();

    } catch (Exception e) {
      e.printStackTrace();
    }
}
  public void mainScreen2(String id){
    Request.Builder builder = new Request.Builder();
    builder.url("http://10.0.2.2:8080/FIT5046/webresources/username.memoir/Advanced4/" + id);
    Request request = builder.build();

    try {
      Response response2 = client.newCall(request).execute();
      mainResult = response2.body().string();

    } catch (Exception e) {
      e.printStackTrace();
    }
    MainResults = mainResult.split("-");

  }

      }