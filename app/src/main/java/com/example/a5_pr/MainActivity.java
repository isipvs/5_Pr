package com.example.a5_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    String[] devices = {"Планшет","Ноутбук","Телефон","Компьютеры","Телевизоры"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, devices
        );

        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void  onItemClick(AdapterView<?> adapterView, View view, int x, long l){

                SparseBooleanArray items = lst.getCheckedItemPositions();
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < items.size(); i++) {
                    // если пользователь выбрал пункт списка,
                    // то выводим его в TextView.
                    if (items.valueAt(i)) {
                        sb.append(devices[items.keyAt(i)] + " ");
                    }
                }

                Toast.makeText(getApplicationContext(),
                        sb.toString(), Toast.LENGTH_LONG).show();
                /*
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                */
            }
        });

    }
}