package com.example.zlobina_09_09;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    TextView textView;
    db_helper databaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
