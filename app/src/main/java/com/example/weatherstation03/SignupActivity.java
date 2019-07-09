package com.example.weatherstation03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    Button _signupButton = null;
    EditText _userName = null;
    EditText _userEmail = null;
    EditText _password =null;
    TextView _pwdForgottenLink = null;
    TextView _loginLink = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

         _signupButton = (Button) findViewById(R.id.btn_signup);
         _userName = findViewById(R.id.input_name);
         _userEmail = findViewById(R.id.input_email);
         _password =(EditText)findViewById(R.id.input_password);
         _pwdForgottenLink = findViewById((R.id.link_forgetPWD));
         _loginLink = findViewById((R.id.link_forgetPWD));

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _userName.getText().toString();
        String email = _userEmail.getText().toString();
        String password = _password.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _userName.getText().toString();
        String email = _userEmail.getText().toString();
        String password = _password.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _userName.setError("at least 3 characters");
            valid = false;
        } else {
            _userName.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _userEmail.setError("enter a valid email address");
            valid = false;
        } else {
            _userEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _password.setError(null);
        }

        return valid;
    }

    public void alreadyRegisteredWasClicked(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
