package com.jaque.androidcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        this.pieChart = findViewById(R.id.pieChart);
        this.setupPieChart();
    }

    private void setupPieChart() {
        pieChart.setUsePercentValues(true);
        ArrayList<PieEntry> entries = new ArrayList<>();

        for (int i=0; i<= 4; i++) {
            entries.add(new PieEntry((float) (Math.random() * 90), 5));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Ejemplo");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueLinePart1OffsetPercentage(80f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(14f);
        // Puts percentages outside
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieChart.setRotationAngle(0);
        pieChart.setExtraOffsets(20f, 0f, 20f, 0f);
        pieChart.setData(data);
    }
}
