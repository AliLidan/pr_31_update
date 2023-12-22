package com.example.zlobina_09_09;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText nameBox, email;
    Button saveButton;
    db_helper sqlHelper;
    SQLiteDatabase db;
    long meoId = 0;


    Button btn;
    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        nameBox = findViewById(R.id.Login);
        email = findViewById(R.id.email);

       // saveButton = findViewById(R.id.saveButton);////0_0

        sqlHelper = new db_helper(this);

        db = sqlHelper.getWritableDatabase();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            meoId = extras.getLong("id");
        }

        if (meoId > 0) {
            // Fetch existing name from database for editing
            Cursor cursor = db.query(db_helper.TABLE, null, db_helper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(meoId)}, null, null, null);
            if (cursor.moveToFirst()) {
                nameBox.setText(cursor.getString(cursor.getColumnIndex(db_helper.COLUMN_NAME)));
            }
            cursor.close();
        }
    }

    public void onClicked1 (View view)
    {
        if (view.getId() == R.id.button)
        {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "something wrong with activity! Hey!", Toast.LENGTH_LONG).show();
        }

    }

    public void onClicked(View view) {
        ContentValues cv = new ContentValues();
        cv.put(db_helper.COLUMN_NAME, nameBox.getText().toString());

        if (meoId > 0) {
            // Update existing entry
            db.update(db_helper.TABLE, cv, db_helper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(meoId)});
        } else {
            // Insert new entry
            db.insert(db_helper.TABLE, null, cv);
        }

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}