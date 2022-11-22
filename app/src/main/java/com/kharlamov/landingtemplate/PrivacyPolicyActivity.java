package com.kharlamov.landingtemplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;


public class PrivacyPolicyActivity extends AppCompatActivity {

    //при создании экрана
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //связывание макета графического интерфейса
        setContentView(R.layout.activity_privacy_policy);
        //парсинг текста с информацией
        TextView info = findViewById(R.id.infoText);
        info.setMovementMethod(LinkMovementMethod.getInstance());
        //определить выравнивание текста
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                info.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            }
        }
        //отобразить кнопку «назад» в левом верхнем углу
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //метод кнопки «назад»
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}