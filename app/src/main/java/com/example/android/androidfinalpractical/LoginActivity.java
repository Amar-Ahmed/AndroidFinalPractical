package com.example.android.androidfinalpractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "savedLogin";
    private SharedPreferences sharedPreferences;

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_button);


        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        //
        boolean isThere  = sharedPreferences.getString("username", null) != null && sharedPreferences.getString("password", null) != null;

        if (isThere) {
            Intent intent = new Intent(this, BreedsActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_field = username.getText().toString();
                String password_field = password.getText().toString();

                if (!TextUtils.isEmpty(username_field) &&
                        !TextUtils.isEmpty(password_field)&&
                        password_field.contains(username_field)) {
                    password.setError("Contains Username");
                }

                if (TextUtils.isEmpty(username_field)) {
                    username.setHint("Username empty");
                }

                if (TextUtils.isEmpty(password_field)) {
                    username.setHint("Password empty");
                }
                if (!password_field.contains(username_field) &&
                        !TextUtils.isEmpty(username_field) &&
                        !TextUtils.isEmpty(password_field)) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username_field);
                    editor.putString("password", password_field);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), BreedsActivity.class);
                    startActivity(intent);

                }
            }
        });

    }
}
