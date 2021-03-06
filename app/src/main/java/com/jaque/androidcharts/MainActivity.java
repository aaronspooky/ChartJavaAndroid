package com.jaque.androidcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button lineChartButton;
    private Button lineChartGradientButton;
    private Button pieChartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lineChartButton = findViewById(R.id.line_chart_simple_btn_lineChartSimple);
        this.lineChartGradientButton = findViewById(R.id.line_chart_simple_btn_lineChartGradient);
        this.pieChartButton = findViewById(R.id.line_chart_simple_btn_pieChart);
        this.didTapLineSimpleChartButton();
        this.didTapLineChartGradientButton();
        this.didTapPieChartButton();
        this.didTapLineSimpleChartButton();
    }

    private void didTapLineSimpleChartButton() {
        this.lineChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(v.getContext(), LineChartSimple.class);
                startActivity(openActivity);
            }
        });
    }
    private void didTapLineChartGradientButton() {
        this.lineChartGradientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(v.getContext(), LineChartGradient.class);
                startActivity(openActivity);
            }
        });
    }

    private void didTapPieChartButton() {
        this.pieChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openActivity = new Intent(v.getContext(), PieChartActivity.class);
                startActivity(openActivity);
            }
        });
    }
}
