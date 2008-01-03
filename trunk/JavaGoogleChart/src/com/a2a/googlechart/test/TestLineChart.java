package com.a2a.googlechart.test;

import com.a2a.googlechart.ChartAxis;
import com.a2a.googlechart.charts.LineChart;
import com.a2a.googlechart.data.VectorInt;

public class TestLineChart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] data = new int[] { 40, 32, 50, 10};
		int [] data2 = new int[] { 10, 30, 15, 25};
		VectorInt oVectData = new VectorInt();
		oVectData.add(data);
		oVectData.add(data2);
		
		String[] strColors = new String[] { "0000FF" };
		
		LineChart oChart = new LineChart(350,200,LineChart.MultiDataSet );
		oChart.setTitle("3D Test");
		oChart.setData(oVectData);		
		oChart.SetDatasetColors(strColors);
		
		oChart.addAxis(new ChartAxis(ChartAxis.Bottom));
		oChart.addAxis(new ChartAxis(ChartAxis.Left));
		
		System.out.print(oChart.getUrl());
		
	}

}
