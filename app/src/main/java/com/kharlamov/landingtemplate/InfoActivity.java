package com.kharlamov.landingtemplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    //при создании экрана
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //связывание макета графического интерфейса
        setContentView(R.layout.activity_info);

        //установка слушателей кнопкок дисклеймера и политики конфиденциальности
        AppCompatButton disclaimerButton = findViewById(R.id.disclaimerButton);
        disclaimerButton.setOnClickListener(view1 -> showDisclaimerDialog());
        AppCompatButton privPolButton = findViewById(R.id.privPolButton);
        privPolButton.setOnClickListener(
                view1 -> startActivity(new Intent(this, PrivacyPolicyActivity.class))
        );
        //парсинг описания приложения
        TextView appDescrView = findViewById(R.id.appDescrView);
        appDescrView.setMovementMethod(LinkMovementMethod.getInstance());
        //отобразить кнопку «назад» в левом верхнем углу
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //метод демонстрации диалога дисклеймера
    private void showDisclaimerDialog() {
        //инициализация строителя диалога
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //задание текстовых элементов диалога
        builder.setMessage("BSD License")
                .setTitle("Disclaimer")
                .setPositiveButton("OK", (dialog, id) -> {
                    dialog.cancel();
                });
        //непосредственное создание и демонстрация диалога
        Dialog dialog = builder.create();
        dialog.show();
        ((TextView) dialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}