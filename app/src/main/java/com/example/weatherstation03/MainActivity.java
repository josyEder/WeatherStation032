package com.example.weatherstation03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private static final int REQUEST_SIGNUP = 0;
    private static final int REQUEST_RESET = 0;


    Button _loginButton = null;
    EditText _userEmail = null;
    EditText _password = null;
    TextView _pwdForgottenLink = null;
    TextView _signUpLink = null;
    String URL = "i weiss ned was i für a url da reinschreibn muss";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _loginButton = findViewById(R.id.btnLogin);
        _userEmail = findViewById(R.id.input_email);
        _password = (EditText) findViewById(R.id.input_password);
        _pwdForgottenLink = findViewById((R.id.link_forgetPWD));
        _signUpLink = findViewById((R.id.link_forgetPWD));
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        Toast.makeText(getBaseContext(), "Login succesfull", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    private boolean validUser() {
        /**
         * To Do --> databse user einbaun!
         */
        boolean valid = true;

        String email = _userEmail.getText().toString();
        String password = _password.getText().toString();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _userEmail.setError("enter a valid username");
            valid = false;
        } else {
            _userEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _password.setError("Password not valid");
            valid = false;
        } else {
            _password.setError(null);
        }


        return valid;
    }

    public void signUpLinkWasClicked(View view) {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }

    public void forgtePWDLinkWasClicked(View view) {
        // Start the Password Reset  activity
        Log.d(TAG, "link forget pwd clicked");
        Intent i = new Intent(this, ResetPasswordActivity.class);
        startActivity(i);
    }

    public void Login(View view) {
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (s.equals("true")) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, MeasurementsActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, "Some error occurred -> " + volleyError, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("email", _userEmail.getText().toString());
                parameters.put("password", _password.getText().toString());
                return parameters;
            }
        };

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
    }


}
