package com.a2a.googlechart.test;

import com.a2a.googlechart.ChartAxis;
import com.a2a.googlechart.charts.BarChart;
import com.a2a.googlechart.data.VectorInt;

public class TestBarChart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] data = new int[] { 40, 30, 20, 10};
		int [] data2 = new int[] { 10, 30, 15, 25};
		VectorInt oVectData = new VectorInt();
		oVectData.add(data);
		oVectData.add(data2);
		
		
		String[] strColors = new String[] { "FF0000", "00AA00" };
		
		BarChart oChart = new BarChart(350,200,BarChart.Vertical,BarChart.Grouped);
		oChart.setTitle("3D Test");
		oChart.setData(oVectData);		
		oChart.SetDatasetColors(strColors);
		
		oChart.addAxis(new ChartAxis(ChartAxis.Bottom));
		oChart.addAxis(new ChartAxis(ChartAxis.Left));

		System.out.print(oChart.getUrl());
		
	}

}
