package com.example.dcube.swamptest;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        EditText patientName = (EditText) findViewById(R.id.patientName);
        EditText patientAge = (EditText) findViewById(R.id.patientAge);
        EditText patientReport = (EditText) findViewById(R.id.patientReport);

        final String pName = patientName.getText().toString();
        final String pAge = patientAge.getText().toString();
        final String pReport = patientReport.getText().toString();

        final SQLiteDatabase eventsDB = this.openOrCreateDatabase("MediTake", MODE_PRIVATE, null);

        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                eventsDB.execSQL("CREATE TABLE IF NOT EXISTS patients (name VARCHAR, age INT(2), report VARCHAR, medicine VARCHAR, dosage VARCHAR, medcode INT(1), notes VARCHAR)");

                eventsDB.execSQL("INSERT INTO patients (name, age, report) VALUES('"+pName+"', '"+pAge+"', '"+pReport+"');");

                //eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Wham split up', 1986)");

                Cursor c = eventsDB.rawQuery("SELECT * FROM patients", null);

                String nameIndex = String.valueOf(c.getColumnIndex("name"));
                String ageIndex = String.valueOf(c.getColumnIndex("age"));
                String reportIndex = String.valueOf(c.getColumnIndex("report"));

                c.moveToFirst();

                if (c != null) {


                    Log.i("Results - name", c.getString(0));
                    Log.i("Results - age", String.valueOf(ageIndex));
                    Log.i("Results - report", String.valueOf(reportIndex));

                }

                Toast.makeText(DataActivity.this, "Patient Details Saved", Toast.LENGTH_SHORT).show();
            }
        });


        }



    //public void register(View view) {


    //    Intent intent = new Intent(DataActivity.this, MainActivity.class);
  //      startActivity(intent);

  //  }
}
