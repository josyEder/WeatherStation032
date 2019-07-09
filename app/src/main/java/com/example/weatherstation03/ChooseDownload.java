package com.example.weatherstation03;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ChooseDownload extends AppCompatActivity {
    private static final String TAG = "TAG";
    Spinner timeCB = null;
    Spinner measurmentCB = null;
    Button btnCreate = null;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_download);
        fillTimeSpinner();
        fillMeasurmentsSpinner();
        createDocument("test");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createDocument(String someText) {
        btnCreate = findViewById(R.id.btnDownloadPDF);

        PdfDocument doc = new PdfDocument();

        //create a Page Description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();

        //start a Page
        PdfDocument.Page page = doc.startPage(pageInfo);
        Canvas can = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        can.drawCircle(50,50,30,paint);
        paint.setColor(Color.BLACK);
        can.drawText(someText,80,50,paint);

        //finish the page
        doc.finishPage(page);

        //write the document content
        String path = Environment.getExternalStorageDirectory().getPath() + "/myPDF/";
        File file = new File (path);
        if(!file.exists()){
            file.mkdirs();
        }
        String targetPDF = path + "/test2PDF";
        File filePath = new File(targetPDF);
        try{
            doc.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Log.e("main", "error "+ex.toString());
            Toast.makeText(this, "Something wrong: " + ex.toString(),  Toast.LENGTH_LONG).show();
        }

        //close the Document
        doc.close();

    }

    private void fillTimeSpinner() {
        timeCB = findViewById(R.id.spinnerTime);
        List<String> times = new ArrayList<String>();
        times.add("Woche");
        times.add("Monat");
        times.add("Jahr");
        times.add("Tag");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        timeCB.setAdapter(dataAdapter);
    }

    private void fillMeasurmentsSpinner() {
        measurmentCB = findViewById(R.id.spinnerMeasurment);
        List<String> measurments = new ArrayList<String>();
        measurments.add("Temperatur");
        measurments.add("Gas");
        measurments.add("Wasserstand");
        measurments.add("Durchfluss");
        measurments.add("Live Daten");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        measurmentCB.setAdapter(dataAdapter);
    }

    public void btnDownloadAsPDFWasClicked(View view) {
    }

    public void btnCancelWasClicked(View view) {
        Log.d(TAG, "button cancel  was clicked");
        Intent i = new Intent(this, MeasurementsActivity.class);
        startActivity(i);
    }
}
