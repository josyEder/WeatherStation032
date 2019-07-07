package com.example.weatherstation03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MeasurementsActivity extends AppCompatActivity {
    private ListView measurements;
    private ArrayList<Double>measurments = new ArrayList<>();
    private ArrayAdapter<Double> adapter;
    private final static int REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
        SetMeasuremets();
    }

    private void SetMeasuremets() {
        //hier die Messwerte aus der DB holen
        String[] textString = {"Temperature", "Waterlevel", "Gas","Durchfluss","LivecamPictures", "All in one"};
        //int[] drawableIds = {R.drawable.temperature, R.drawable.waterlevel, R.drawable.gas};



    }
}
