package com.a2a.googlechart;

import com.a2a.googlechart.charts.LineChart;

public class GridTests
{
    public static String stepSizeTest()
    {
        int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
        LineChart lineChart = new LineChart(250, 150);
        lineChart.setTitle("Step Size Test");
        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        lineChart.setData(line1);

        try{
        	lineChart.setGrid(20, 50);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        return lineChart.getUrl();
    }

    public static String allParamsTest()
    {
        int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
        LineChart lineChart = new LineChart(250, 150);
        lineChart.setTitle("All Params Test");
        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        lineChart.setData(line1);

        try{
        	lineChart.setGrid(20, 50, 1, 5);
        }
        catch(Exception e){
        	e.printStackTrace();
        }

        return lineChart.getUrl();
    }

    public static String solidGridTest()
    {
        int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
        LineChart lineChart = new LineChart(250, 150);
        lineChart.setTitle("Solid Grid Test");
        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));
        lineChart.setData(line1);

        try{
	        lineChart.setGrid(20, 50, 1, 0);
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
        return lineChart.getUrl();
    }
}
