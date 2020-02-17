package com.example.thankugodhamburger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    EditText login,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(this);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        String templog = login.getText().toString();
        String temppass = password.getText().toString();
        if ((templog.equals(getString(R.string.checkLogin))) && (temppass.equals(getString(R.string.checkPassword)))) {
            loadFragment (new Authorisation());
            Log.e("RRRR","123");
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Wrong ASS", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    private void loadFragment(Fragment f) {

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main,f);


        ft.commit();
    }
}
