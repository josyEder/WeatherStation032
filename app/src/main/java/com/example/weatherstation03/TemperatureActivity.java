package com.example.weatherstation03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class TemperatureActivity extends AppCompatActivity {
    LineChartView lineChartView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        createLineChart();
    }

    private void createLineChart() {
        lineChartView = findViewById(R.id.temperatureChartID);

        //declare Data for X-Axis
        String[] axisData = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"};

        //declare Data for Y-Axis
        int[] yAxisData = {50,20,15,30,88,90,90,02,60,40,45};


        //Lists to hold the data for Axis and Y-Axis
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        //declate and initialize the line inside the Graph (l holds the values of Y-Axis)
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#0009ff"));


        //add the Axis and Y-Axis data
        for(int i = 0; i < axisData.length; i ++){
            axisValues.add(i,new  AxisValue(i).setLabel(axisData[i]));
        }

        for(int i = 0; i < yAxisData.length; i ++){
            yAxisValues.add(i,new PointValue(i, yAxisData[i]));
        }

        //list for all Lines
        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        //add the data to the linaChart to see it
        lineChartView.setLineChartData(data);


        //initialize the X-Axis values and set it to the bottom
        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(13);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        //initialize the Y-Axis values and set it to the left hand side
        Axis yAxis = new Axis();
        yAxis.setTextSize(16);
        yAxis.setName("Temperature in clecius");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisYLeft(yAxis);

        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

    }
}
