package com.a2a.googlechart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Program
{    
	public static void main(String[] args)
	{
		try{
			File oFile = new File("test.html");
			FileOutputStream oS = new FileOutputStream(oFile);
			PrintWriter tw = new PrintWriter(oS);
		    
		    
	        tw.println("<h3>Line Charts</h3>");
	        tw.println(getImageTag(LineChartTests.singleDatasetPerLine()));
	        tw.println(getImageTag(LineChartTests.multiDatasetPerLine()));
	        tw.println(getImageTag(LineChartTests.lineColorAndLegendTest()));
	        
	
	        //region Fills
	        tw.println("<h3>Fills</h3>");
	        tw.println(getImageTag(FillsTests.multiLineAreaFillsTest()));
	        tw.println(getImageTag(FillsTests.singleLineAreaFillTest()));
	        tw.println(getImageTag(FillsTests.linearGradientFillTest()));
	        tw.println("<br />");
	        tw.println(getImageTag(FillsTests.linearStripesTest()));
	        tw.println(getImageTag(FillsTests.solidFillTest()));
	        
	
	        //region Markers
	        tw.println("<h3>Markers</h3>");
	        tw.println(getImageTag(MarkersTests.rangeMarkersTest()));
	        tw.println(getImageTag(MarkersTests.shapeMarkersTest()));
	
	        
	
	        //region Grids
	        tw.println("<h3>Grids</h3>");
	        tw.println(getImageTag(GridTests.stepSizeTest()));
	        tw.println(getImageTag(GridTests.allParamsTest()));
	        tw.println(getImageTag(GridTests.solidGridTest()));
	        
	
	        //region Bar Charts
	        tw.println("<h3>Bar Charts</h3>");
	        tw.println(getImageTag(BarChartTests.horizontalStackedTest()));
	        tw.println(getImageTag(BarChartTests.verticalStackedTest()));
	        tw.println(getImageTag(BarChartTests.horizontalGroupedTest()));
	        tw.println(getImageTag(BarChartTests.verticalGroupedTest()));
	        
	
	        //region Pie Charts
	        tw.println("<h3>Pie Charts</h3>");
	        tw.println(getImageTag(PieChartTests.TwoDTest()));
	        tw.println(getImageTag(PieChartTests.ThreeDTest()));
	        
	
	        // region Venn Diagrams
	        tw.println("<h3>Venn Diagrams</h3>");
	        tw.println(getImageTag(VennDiagramTests.VennDiagramTest()));
	        
	
	        // region Scatter Plots
	        tw.println("<h3>Scatter Plots</h3>");
	        tw.println(getImageTag(ScatterPlotTests.scatterPlotTest()));
	        
	        tw.close();
	        
		}
		catch(Exception e){
			e.printStackTrace();
		}
	        
	    
	}
	
	public static String getImageTag(String url)
	{
	    return "<img src=\"" + url + "\" />";
	}
}
