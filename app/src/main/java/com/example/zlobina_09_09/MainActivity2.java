package com.example.zlobina_09_09;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView textView;
    db_helper databaseHelper;
    SQLiteDatabase db;

    Button phone, check;
    ImageButton btnback, btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        phone = findViewById(R.id.button3);
        check = findViewById(R.id.button);
        btnback = findViewById(R.id.imageButton);
        btn = findViewById(R.id.imageButton3);


        textView = findViewById(R.id.textView77);
        databaseHelper = new db_helper(this);
        db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(db_helper.TABLE, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(db_helper.COLUMN_NAME));
            textView.setText(String.format("  " + name));
            textView.setTextColor(Color.RED);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        }

        cursor.close();
        db.close();
    }

    public void onClick (View v)
    {
        switch (v.getId()){
            case R.id.button3:
                Intent intent = new Intent("android.intent.action.DIAL");
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(this, MainActivity3.class );
                startActivity(intent2);
                break;
            case R.id.imageButton:
                Intent intent3 = new Intent(this, MainActivity.class );
                startActivity(intent3);
                break;

        }
    }
}

/* вход в другие приложения
*     public void onClick(View view) {
        switch (view.getId()) {
            case R.id.telephone:
                Intent intent = new Intent("android.intent.action.DIAL");
                startActivity(intent);
                break;

            case R.id.camera:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent2);
                break;

            case R.id.maps:

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/maps/65/novosibirsk/?ll=82.920430%2C55.030199&mode=poi&poi%5Bpoint%5D=82.928453%2C55.025143&poi%5Buri%5D=ymapsbm1%3A%2F%2Forg%3Foid%3D1010733977&z=12"));
                startActivity(browserIntent);
                break;

            case R.id.galary:
                Intent galaryIntent = new Intent(Intent.ACTION_VIEW);
                galaryIntent.setType("image/*");
                startActivity(galaryIntent);
                break;

            case R.id.google:
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent1);
                break;

            case R.id.calendar:
                long startMillis = System.currentTimeMillis();
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent5 = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent5);
                break;

            default:
                Toast.makeText(getApplication(), "hey!", Toast.LENGTH_LONG).show();
        }
    }
*
*
* */