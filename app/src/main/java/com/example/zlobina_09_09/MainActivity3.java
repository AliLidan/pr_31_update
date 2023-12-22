package com.example.zlobina_09_09;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    //Мы создаем константы для имен атрибутов

    ListView lvSimple;
    CheckBox ch1, ch2, ch3;
    LinearLayout ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // массивы данных
        String[] texts = {
                "sometext 1",
                "sometext 2",
                "sometext 3",
                "sometext 4",
                "sometext 5" };
        boolean[] checked = { true, false, false, true, false };

        //описываем массивы данных
       // int[] imga = {R.drawable.a1, R.drawable.a2, R.drawable.a3,R.drawable.a4,R.drawable.a5};
       // int img = R.drawable.a1;
        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                texts.length);


        Map<String, Object> m;
        for (int i = 0; i < texts.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
         //   m.put(ATTRIBUTE_NAME_IMAGE, imga[i]);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED}; //, ATTRIBUTE_NAME_IMAGE };
        //Массив from содержит имена Map-ключей

        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.tvText, R.id.cbChecked}; //, R.id.ivImg };

        //массив to содержит  ID View-компонентов

        /*в R.id.tvText  вставиться значение из элемента Map с ключом ATTRIBUTE_NAME_TEXT
        Адаптер перебрал View-компоненты (массив to) для каждого пункта списка
        и сопоставил им значения из Map (массив from)


        */
        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        // определяем список и присваиваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);


        ch1 =  findViewById( R.id.checkBox2 );
        ch2 =  findViewById( R.id.checkBox3 );
        ch3 =  findViewById( R.id.checkBox );
        ln = findViewById(R.id.new_linear);

      /*  repeatChkBx.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    // perform logic
                }

            }
        });*/
    }

    public void onClick(View v) {

        if ( ch1.isChecked() ) {
            // perform logic

            ln.setBackgroundColor(Color.parseColor("#B8DF8E"));
        }
        else if ( ch2.isChecked()){
            ln.setBackgroundColor(Color.BLUE);
        }
        else if (ch3.isChecked()) {
            ln.setBackgroundColor(Color.YELLOW);
        }
        else
        {
            ln.setBackgroundColor(Color.WHITE);
        }
    }
}