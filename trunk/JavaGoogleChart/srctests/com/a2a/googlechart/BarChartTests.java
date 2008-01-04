package com.a2a.googlechart;

import com.a2a.googlechart.charts.BarChart;
import com.a2a.googlechart.data.VectorInt;

public class BarChartTests
{
    public static String horizontalStackedTest()
    {
        int[] data1 = new int[] { 10, 5, 20, 15 };
        int[] data2 = new int[] { 10, 10, 10, 10 };

        VectorInt dataset = new VectorInt();
        dataset.add(data1);
        dataset.add(data2);

        BarChart barChart = new BarChart(150, 150, BarChart.Horizontal, BarChart.Stacked);
        barChart.setTitle("Horizontal Stacked");
        barChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        barChart.addAxis(new ChartAxis(ChartAxis.Left));
        barChart.setData(dataset);

        barChart.setDatasetColors(new String[] { "FF0000", "00AA00" });
        
        return barChart.getUrl();
    }

    public static String verticalStackedTest()
    {
        int[] data1 = new int[] { 10, 5, 20, 15 };
        int[] data2 = new int[] { 10, 10, 10, 10 };

        VectorInt dataset = new VectorInt();
        dataset.add(data1);
        dataset.add(data2);

        BarChart barChart = new BarChart(150, 150, BarChart.Vertical, BarChart.Stacked);
        barChart.setTitle("Vertical Stacked");
        barChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        barChart.addAxis(new ChartAxis(ChartAxis.Left));
        barChart.setData(dataset);

        barChart.setDatasetColors(new String[] { "FF0000", "00AA00" });

        return barChart.getUrl();
    }

    public static String horizontalGroupedTest()
    {
        int[] data1 = new int[] { 10, 5, 20 };

        BarChart barChart = new BarChart(150, 150, BarChart.Horizontal, BarChart.Grouped);
        barChart.setTitle("Horizontal Grouped");
        barChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        barChart.addAxis(new ChartAxis(ChartAxis.Left));
        barChart.setData(data1);

        barChart.setDatasetColors(new String[] { "FF0000", "00AA00" });

        return barChart.getUrl();
    }

    public static String verticalGroupedTest()
    {
    	int[] data1 = new int[] { 10, 5, 20 };
        int[] data2 = new int[] { 30, 35, 15 };
        
        VectorInt dataset = new VectorInt();
        dataset.add(data1);
        dataset.add(data2);

        BarChart barChart = new BarChart(300, 150, BarChart.Vertical, BarChart.Grouped);
        barChart.setTitle("Vertical Grouped");
        barChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        barChart.addAxis(new ChartAxis(ChartAxis.Left));
        barChart.setData(dataset);

        barChart.setDatasetColors(new String[] { "FF0000", "00AA00" });

        return barChart.getUrl();
    }
}
