package com.example.mymemoir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mymemoir.networkconnection.MD5;
import com.example.mymemoir.networkconnection.NetworkConnection;

/**
 * @author LiJinFeng
 */
public class SignUp extends AppCompatActivity {
    private RadioGroup genderRadio;
    private CalendarView DOB_calendarView;
    String dob;
    String gender;
    NetworkConnection networkConnection = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.signup);

    networkConnection = new NetworkConnection();
    Button bt_submit = findViewById(R.id.sign_up_SUBMIT);
    Button bt_return = findViewById(R.id.sign_up_RETURN);

    genderRadio = (RadioGroup) findViewById(R.id.sign_up_genderRadio);
      final RadioButton radio1 = (RadioButton) findViewById(R.id.sign_up_femaleGroupID);
      final RadioButton radio2 = (RadioButton) findViewById(R.id.sign_up_maleGroupID);

      DOB_calendarView = (CalendarView) findViewById(R.id.sign_up_DOB_CalendarView);

    genderRadio.setOnCheckedChangeListener(
        new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radio1.getId()) {
              gender = radio1.getText().toString();
            } else if (checkedId == radio2.getId()) {
              gender = radio2.getText().toString();
            }
          }
        });

    DOB_calendarView.setOnDateChangeListener(
        new CalendarView.OnDateChangeListener() {
          @Override
          public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            dob = year + "-" + month + "-" + dayOfMonth;
          }
        });

    bt_submit.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SignUpTask signUpTask = new SignUpTask();
              signUpTask.execute();
            }
          }
        );

    bt_return.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(SignUp.this, LoginIn.class);
            startActivityForResult(intent, 1);
          }
        });
  }

  @SuppressLint("StaticFieldLeak")
  private class SignUpTask extends AsyncTask<Void, Void, String> {

            EditText sign_up_firstnameText = (EditText) findViewById(R.id.sign_up_firstnameText);
          final String firstnameText = sign_up_firstnameText.getText().toString();

          EditText sign_up_surnameText = (EditText) findViewById(R.id.sign_up_surnameText);
          final String surnameText = sign_up_surnameText.getText().toString();

            EditText sign_up_addressText = (EditText) findViewById(R.id.sign_up_addressText);
          final String addressText = sign_up_addressText.getText().toString();

          EditText sign_up_postcodeText = (EditText) findViewById(R.id.sign_up_postcodeText);
          final String postcodeText = sign_up_postcodeText.getText().toString();

            EditText sign_up_emailText = (EditText) findViewById(R.id.sign_up_emailText);
          final String emailText = sign_up_emailText.getText().toString();

        EditText sign_up_passwordText = (EditText) findViewById(R.id.sign_up_passwordText);
          final String passwordText = sign_up_passwordText.getText().toString();

          final Spinner state_spinner = findViewById(R.id.sign_up_state_spinner);
          final String state_spinner_content = state_spinner.getSelectedItem().toString();

          String[] details = new String[] {
                  firstnameText,
                  surnameText,
                  gender,
                  dob,
                  addressText,
                  state_spinner_content,
                  postcodeText,
                  emailText,
                  passwordText
                          };

    @Override
    protected String doInBackground(Void... params) {

      return networkConnection.userSignUp(details);
            }

    @Override
    protected void onPostExecute(String result) {
      if ("SIGN UP SUCCESSFULLY".equals(result)) {
        Intent intent = new Intent(SignUp.this, LoginIn.class);
        startActivityForResult(intent, 1);
        sendToast("SIGN UP SUCCESSFULLY");
      } else {
        sendToast(result);
      }
    }
  }

  protected void sendToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }
}
