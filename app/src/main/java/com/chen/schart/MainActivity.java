package com.chen.schart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CombinedChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChart = (CombinedChart) findViewById(R.id.chart);
        initChart();

    }

    private void initChart(){
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawOrder(new DrawOrder[]{DrawOrder.CANDLE});

        CombinedData data = new CombinedData();
        data.setData(getCandleData());
        mChart.setData(data);
        mChart.invalidate();
    }

    private CandleData getCandleData(){
        CandleData data = new CandleData();
        ArrayList<CandleEntry> list = new ArrayList<>();
        list.add(new CandleEntry(1,90,60,80,75));
        CandleDataSet set = new CandleDataSet(list,"Candle DataSet");
        data.addDataSet(set);
        return data;
    }
}
