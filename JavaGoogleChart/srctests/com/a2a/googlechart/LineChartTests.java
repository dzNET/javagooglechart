package com.a2a.googlechart;

import com.a2a.googlechart.charts.LineChart;
import com.a2a.googlechart.data.VectorInt;

public class LineChartTests
{
  public static String singleDatasetPerLine() {
    int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
    int[] line2 = new int[] { 15, 20, 60, 44, 20, 35 };

    VectorInt dataset = new VectorInt();
    dataset.add(line1);
    dataset.add(line2);

    LineChart lineChart = new LineChart(250, 150);
    lineChart.setTitle("Single Dataset Per Line", "0000FF", 14);
    lineChart.setData(dataset);
    lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
    lineChart.addAxis(new ChartAxis(ChartAxis.Left));

    return lineChart.getUrl();
  }

  public static String multiDatasetPerLine()
  {
    int[] line1x = new int[] { 0, 15, 30, 45, 60 };
    int[] line1y = new int[] { 10, 50, 15, 60, 12};
    int[] line2x = new int[] { 0, 15, 30, 45, 60 };
    int[] line2y = new int[] { 45, 12, 60, 34, 60 };

    VectorInt dataset = new VectorInt();
    dataset.add(line1x);
    dataset.add(line1y);
    dataset.add(line2x);
    dataset.add(line2y);

    LineChart lineChart = new LineChart(250, 150, LineChart.MultiDataSet);
    lineChart.setTitle("Multi Dataset Per Line", "0000FF", 14);
    lineChart.setData(dataset);
    lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
    lineChart.addAxis(new ChartAxis(ChartAxis.Left));

    return lineChart.getUrl();
  }

  public static String lineColorAndLegendTest()
  {
    int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
    int[] line2 = new int[] { 15, 20, 60, 44, 20, 35 };

    VectorInt dataset = new VectorInt();
    dataset.add(line1);
    dataset.add(line2);

    LineChart lineChart = new LineChart(250, 150);
    lineChart.setTitle("Line Color And Legend Test", "0000FF", 14);
    lineChart.setData(dataset);
    lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
    lineChart.addAxis(new ChartAxis(ChartAxis.Left));

    lineChart.setDatasetColors(new String[] { "FF0000", "00FF00" });
    lineChart.setLegend(new String[] { "line1", "line2" });

    return lineChart.getUrl();
  }
  
  public static String tickMarksTest() {
    int[] line1 = new int[] {5, 10, 50};

    VectorInt dataset = new VectorInt();
    dataset.add(line1);

    LineChart lineChart = new LineChart(250, 150);
    lineChart.setTitle("Tick Marks Test", "0000FF", 14);
    lineChart.setData(dataset);
    ChartAxis axis = new ChartAxis(ChartAxis.Bottom);
    axis.setTickMarksSize(10);
    lineChart.addAxis(axis);
    
    return lineChart.getUrl();
  }
}

