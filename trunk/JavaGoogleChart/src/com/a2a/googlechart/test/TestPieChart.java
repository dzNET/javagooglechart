package com.a2a.googlechart.test;

import java.util.Vector;

import com.a2a.googlechart.ChartAxis;
import com.a2a.googlechart.charts.PieChart;

public class TestPieChart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] data = new int[] { 40, 30, 20, 10};
		Vector oVect = new Vector();
		oVect.add("A");
		oVect.add("B");
		oVect.add("C");
		oVect.add("D");
		
		String[] strColors = new String[] { "0000FF" };
		
		PieChart oChart = new PieChart(350,200,PieChart.ThreeD);
		oChart.setTitle("3D Test");
		oChart.setPieChartLabels(oVect);
		oChart.setData(data);		
		oChart.SetDatasetColors(strColors);
		
		oChart.addAxis(new ChartAxis(ChartAxis.Bottom));
		oChart.addAxis(new ChartAxis(ChartAxis.Left));
		
		System.out.print(oChart.getUrl());
		
	}

}
