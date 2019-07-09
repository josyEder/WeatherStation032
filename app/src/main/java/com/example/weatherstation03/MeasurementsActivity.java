package com.example.weatherstation03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MeasurementsActivity extends AppCompatActivity {
    private ListView measurementsLV = null;
    private ArrayList<String> myMeasurments = null;
    private static final String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
        SetMeasuremets();
    }

    private void SetMeasuremets() {
        //hier die Messwerte aus der DB holen
        measurementsLV = (ListView) findViewById(R.id.measurementsList);
        myMeasurments = new ArrayList<>();
        myMeasurments.add("Temperature");
        myMeasurments.add("WaterLevel");
        myMeasurments.add("Livecam Pictures");
        myMeasurments.add("Gas");
        myMeasurments.add("Livedata");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myMeasurments);

        measurementsLV.setAdapter(arrayAdapter);
        measurementsLV.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text Game, Help, Home
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                String sText = ((TextView) view).getText().toString();
                Intent i = null;
                if (sText.equals("Temperature")) {
                    i = new Intent(getBaseContext(),
                            TemperatureActivity.class);
                } else if (sText.equals("WaterLevel")) {
                    i = new Intent(getBaseContext(),
                            WaterLevelActivity.class);

                } else if (sText.equals("Livecam Pictures")) {
                    i = new Intent(getBaseContext(),
                            LiveCamPicturesAcitivity.class);
                } else if (sText.equals("Gas")) {
                    i = new Intent(getBaseContext(),
                            GasActivity.class);
                } else if (sText.equals("Livedata")) {
                    i = new Intent(getBaseContext(),
                            LiveDataActivity.class);
                }
                if (i != null)
                    startActivity(i);
            }
        });

    }

    public void btnHelpWasClicked(View view) {

    }

    public void btnDownload(View view) {
        Log.d(TAG, "button download as pdf was clicked");
        Intent i = new Intent(this, ChooseDownload.class);
        startActivity(i);
    }
}
