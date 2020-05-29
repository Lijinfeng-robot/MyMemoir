package com.example.mymemoir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymemoir.networkconnection.MD5;
import com.example.mymemoir.networkconnection.NetworkConnection;

/**
 * @author LiJinFeng
 */
public class LoginIn extends AppCompatActivity {
  NetworkConnection networkConnection = null;
  public static String title;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.loginin);
    networkConnection = new NetworkConnection();
    Button bt_sign_in = findViewById(R.id.buttonSignIn);
    Button bt_sign_up = findViewById(R.id.buttonSignUp);
    bt_sign_in.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            LoginInTask getAllLoginInTask = new LoginInTask();
            getAllLoginInTask.execute();
          }
        });
    bt_sign_up.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(LoginIn.this, SignUp.class);
              startActivityForResult(intent, 1);
          }
        });
  }

  @SuppressLint("StaticFieldLeak")
  private class LoginInTask extends AsyncTask<Void, Void, Boolean> {
    EditText usernameText = (EditText) findViewById(R.id.usernameText);
    String userText = usernameText.getText().toString();
    EditText passwordText = (EditText) findViewById(R.id.passwordText);
    String passText = passwordText.getText().toString();

    @Override
    protected Boolean doInBackground(Void... params) {
//      if (networkConnection.userLogin_user((userText)).equals("not exist")) {
//        return false;
//      }
//      title = networkConnection.findFirstNameByUsername(userText);
//      networkConnection.mainScreen(userText);
//      networkConnection.mainScreen2(networkConnection.mainTemp);
//      return networkConnection
//          .userLogin_user(userText)
//          .equals(MD5.md5Password(passText));
      //方便测试 将其注解
      return true;
    }

    @Override
    protected void onPostExecute(Boolean flag) {
      if (flag) {
        Intent intent = new Intent(LoginIn.this, MainScreen.class);
        startActivityForResult(intent, 1);
        sendToast("LOGIN IN SUCCESSFULLY");
      } else {
        sendToast("PLEASE INPUT RIGHT USERNAME AND PASSWORD!");
      }
    }
  }

  protected void sendToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }
}
