package com.jaque.androidcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class LineChartGradient extends AppCompatActivity {

    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart_gradient);

        this.chart = findViewById(R.id.chartGradient);
        this.setupLineChart();
    }

    private void setupLineChart() {
        List<Entry> entries = new ArrayList<Entry>();
        for (int i=0; i<=40; i++) {
            float val = (float) (Math.random() * 90);
            entries.add(new Entry(i, val));
        }

        XAxis xAxis;
        xAxis = chart.getXAxis();
        xAxis.enableAxisLineDashedLine(10f, 10f, 0f);
        xAxis.setDrawLimitLinesBehindData(true);

        YAxis yAxis;
        yAxis = chart.getAxisLeft();

        LimitLine ll = new LimitLine(90f, "Critical Line");
        ll.setLineColor(R.color.colorAccent);
        ll.setLineWidth(2f);
        yAxis.addLimitLine(ll);

        LimitLine lowerLine = new LimitLine(0f, "Lower Line");
        lowerLine.setLineColor(R.color.colorAccent);
        lowerLine.setLineWidth(2f);
        yAxis.addLimitLine(lowerLine);

        LineDataSet dataSet = new LineDataSet(entries, "Ejemplo");
        dataSet.setHighlightEnabled(true);
        dataSet.setHighLightColor(R.color.colorPrimary);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setDrawCircleHole(false);

        // Needed to fill color
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(ColorTemplate.JOYFUL_COLORS[1]);
        LineData lineData = new LineData(dataSet);
        dataSet.enableDashedLine(10, 10, 0);
        chart.animateX(1500);
        chart.setData(lineData);
    }
}
