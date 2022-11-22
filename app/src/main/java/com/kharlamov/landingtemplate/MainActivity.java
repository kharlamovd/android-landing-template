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
        //связывание макета графического интерфейса
        setContentView(R.layout.activity_main);

        //демонстрация полосы меню
        showCustomMenuBar();

        //задать слушатель для кнопки вызова информационной активности
        ImageView helpView = findViewById(R.id.helpView);
        setHelpOnClickListener(helpView);
    }

    //слушатель кнопки вызова информационной активности
    private void setHelpOnClickListener(ImageView helpView) {
        //переход на новый экран информационной активности
        helpView.setOnClickListener(view ->
                startActivity(new Intent(this, InfoActivity.class)));
    }

    //метод демонстрации пользовательской полосы меню
    private void showCustomMenuBar() {
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);
    }
}