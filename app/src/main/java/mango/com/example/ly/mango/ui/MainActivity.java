package mango.com.example.ly.mango.ui;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import mango.com.example.ly.mango.R;
import mango.com.example.ly.mango.Util;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwitch = findViewById(R.id.switch_button);
        mSwitch.setOnCheckedChangeListener(this);
        //requestPermission();

    }
    public void requestPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch_button:
                Util.enable(this, isChecked);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Util.enable(this, false);
    }
}
