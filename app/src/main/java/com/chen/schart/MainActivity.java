package com.chen.schart;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CombinedChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChart = findViewById(R.id.chart);
        initChart();

    }

    private void initChart() {
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawOrder(new DrawOrder[]{DrawOrder.LINE, DrawOrder.CANDLE});

        Legend l = mChart.getLegend();

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(30f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value % 30);
            }
        });

        CombinedData data = new CombinedData();
        data.setData(getLineData());
        data.setData(getCandleData());
        mChart.setData(data);
        mChart.invalidate();
    }

    private LineData getLineData() {
        LineData data = new LineData();
        ArrayList<Entry> list = new ArrayList<>();
        list.add(new Entry(1, 70));
        list.add(new Entry(6, 75));
        list.add(new Entry(11, 80));
        list.add(new Entry(16, 75));
        LineDataSet set = new LineDataSet(list, "Line DataSet");
        set.setColor(Color.RED);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawCircles(false);
        set.setDrawValues(false);
        data.addDataSet(set);
        return data;
    }

    private CandleData getCandleData() {
        CandleData data = new CandleData();
        ArrayList<CandleEntry> list = new ArrayList<>();
        list.add(new CandleEntry(1, 90, 70, 80, 75));
        list.add(new CandleEntry(6, 88, 75, 80, 75));
        list.add(new CandleEntry(11, 80, 70, 80, 75));
        list.add(new CandleEntry(16, 90, 70, 70, 85));
        CandleDataSet set = new CandleDataSet(list, "Candle DataSet");
        set.setIncreasingColor(Color.RED);
        set.setIncreasingPaintStyle(Paint.Style.FILL);
        set.setDecreasingColor(Color.GREEN);
        set.setDecreasingPaintStyle(Paint.Style.FILL);
        set.setShadowColorSameAsCandle(true);
        set.setBarSpace(0.3f);
        set.setDrawValues(false);
        data.addDataSet(set);
        return data;
    }
}
