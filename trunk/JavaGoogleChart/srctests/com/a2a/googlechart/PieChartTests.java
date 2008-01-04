package com.a2a.googlechart;

import com.a2a.googlechart.charts.PieChart;

public class PieChartTests
{
    public static String TwoDTest()
    {
        int[] data = new int[] { 10, 20, 30, 40 };
        PieChart pieChart = new PieChart(250, 150);
        pieChart.setTitle("2D Test");
        pieChart.setData(data);
        pieChart.setPieChartLabels(new String[] { "A", "B", "C", "D" });

        return pieChart.getUrl();
    }

    public static String ThreeDTest()
    {
        int[] data = new int[] { 10, 20, 30, 40 };
        PieChart pieChart = new PieChart(300, 150, PieChart.ThreeD);
        pieChart.setTitle("3D Test");
        pieChart.setData(data);
        pieChart.setPieChartLabels(new String[] { "A", "B", "C", "D" });
        pieChart.setDatasetColors(new String[] { "0000FF" });

        return pieChart.getUrl();
    }
}
