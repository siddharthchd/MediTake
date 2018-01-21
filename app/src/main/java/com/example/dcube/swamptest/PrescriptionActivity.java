package com.example.dcube.swamptest;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

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
        ImageView addButton = (ImageView) findViewById(R.id.addButton);
        ImageView saveButton = (ImageView) findViewById(R.id.saveButton);
        final HashMap<String, String> map = new HashMap<String, String>();
        ListView listView = (ListView) findViewById(R.id.listView);
        String[] medicines = new String[] {
        };

        // Create a List from String Array elements
        final List<String> medicines_list = new ArrayList<String>(Arrays.asList(medicines));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, medicines_list);

        listView.setAdapter(arrayAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List
                medicines_list.add(MedicText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                String doseNote = NoteText.getText().toString();
            }
        });

        //Intent intentBundle = new Intent(PrescriptionActivity.this, Main2Activity.class);
        //Bundle bundle  = new Bundle();
        //bundle.putString("Medicine", MedicText.getText().toString());
        //bundle.putString("Notes", NoteText.getText().toString());
        //intentBundle.putExtras(bundle);
        //startActivity(intentBundle);

    }

    public void save(View view){
        Intent intent = new Intent(PrescriptionActivity.this, MainActivity.class);
        startActivity(intent);

    }
    public void clear(View view){
        Toast.makeText(this, "Medicines Saved", Toast.LENGTH_SHORT).show();


    }
}
