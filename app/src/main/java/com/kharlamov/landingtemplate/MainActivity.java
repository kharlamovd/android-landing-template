package com.kharlamov.landingtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCustomMenuBar();

        ImageView helpView = findViewById(R.id.helpView);
        setHelpOnClickListener(helpView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setHelpOnClickListener(ImageView helpView) {
        helpView.setOnClickListener(view ->
                startActivity(new Intent(this, InfoActivity.class)));
    }

    private void showCustomMenuBar() {
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
    }
}