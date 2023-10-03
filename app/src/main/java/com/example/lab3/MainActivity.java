package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean[] selectedItems = {false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastmsg(View view) {
        Toast toasttest = Toast.makeText(getApplicationContext(), "все файлы удалены", Toast.LENGTH_LONG);
        // Toast.LENGTH_SHORT - 2 сек, лонг 3.5 сек, вызов:
        // setGravity(Gravity. ---, xOffcet: 0, yOffset: 0) - положение тоста, 0 0
        toasttest.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toasttest.show();
    }

    public void alertmsg(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("закрыть приложение?")
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("точно?")
                .setPositiveButton("ДА!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toasttest = Toast.makeText(getApplicationContext(), "все файлы удалены", Toast.LENGTH_LONG);
                        toasttest.show();
                        dialogInterface.cancel();

                    }
                });


        AlertDialog alert = builder.create();
        alert.show();
    }

    public void choice(View view) {
        String[] items = {"А", "И", "Б"};
//        boolean[] selectedItems = {false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("а и б сидели на трубе. а упала, б пропала, кто остался на трубе?")
                .setCancelable(false)
                .setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedItems[i] = b;
                    }
                })
                .setPositiveButton("ответить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String selected = "";
//                        for (int j = 0; j < items.length; j++) {
//                            if (selectedItems[j]) {
//                                selected += items[j] + ";";
//                            }
//                        }

                        String selected = "";
                        for (int j = 0; j < items.length; j++) {
                            if (selectedItems [1]==true && selectedItems[0,2]==false) {
                                Toast toast = Toast.makeText(getApplicationContext(), "ок. правильно", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        } else Toast toast = Toast.makeText(getApplicationContext(), "АХАХАХА, нет", Toast.LENGTH_LONG);
                        toast.show();

//                        Toast toast = Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_LONG);
//                        toast.show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}