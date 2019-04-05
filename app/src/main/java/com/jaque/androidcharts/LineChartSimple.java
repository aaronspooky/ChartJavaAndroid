package com.jaque.androidcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class LineChartSimple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart_simple);

        LineChart chart = findViewById(R.id.chart);
        List<Entry> entries = new ArrayList<Entry>();
        for (int i=0; i<=40; i++) {
            float val = (float) (Math.random() * 90) - 30;
            entries.add(new Entry(i, val));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Ejemplo");
        dataSet.setHighlightEnabled(true);
        dataSet.setHighLightColor(R.color.colorPrimary);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setDrawCircleHole(false);
        LineData lineData = new LineData(dataSet);
        dataSet.enableDashedLine(10, 10, 0);
        chart.animateX(1500);
        chart.setData(lineData);
    }
}
