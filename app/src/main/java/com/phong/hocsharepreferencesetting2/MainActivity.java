package com.phong.hocsharepreferencesetting2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView txtBackGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        //Lắng nghe:
        Context context = getApplicationContext();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.registerOnSharedPreferenceChangeListener(this);//this ở đây là SharedPreferences.OnSharedPreferenceChangeListener
    }

    private void addControls() {
        txtBackGround = (TextView) findViewById(R.id.txtBackGround);
    }

    public void XuLyMoSetting(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivityForResult(intent, 101);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        //Lắng nghe thông tin trên giao diện mà User thay đổi
        boolean data = sharedPreferences.getBoolean(s, false);
        Toast.makeText(MainActivity.this, "Checked = " + data, Toast.LENGTH_SHORT).show();
        if (data == true)
        {
            txtBackGround.setBackgroundColor(Color.RED);
        }
        else
        {
            txtBackGround.setBackgroundColor(Color.BLUE);
        }
    }
}
