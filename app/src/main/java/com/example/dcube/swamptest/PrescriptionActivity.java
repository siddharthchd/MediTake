package com.example.dcube.swamptest;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PrescriptionActivity extends AppCompatActivity {

    EditText MedicText;
    EditText NoteText;
    Spinner DoseSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        MedicText = (EditText) findViewById(R.id.MedicText);
        NoteText = (EditText) findViewById(R.id.NoteText);
        DoseSpinner = (Spinner) findViewById(R.id.DoseSpinner);


    }

    public void save(View view){
        Intent intent = new Intent(PrescriptionActivity.this, MainActivity.class);
        startActivity(intent);

    }
    public void clear(View view){
        Toast.makeText(this, "Medicines Saved", Toast.LENGTH_SHORT).show();


    }
}
