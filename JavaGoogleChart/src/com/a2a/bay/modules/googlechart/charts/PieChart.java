package com.a2a.bay.modules.googlechart.charts;

import java.util.Vector;

import com.a2a.bay.modules.googlechart.exception.InvalidFeatureForChartTypeException;

public class PieChart extends Chart
{
    private String pieChartType;
    private Vector pieChartLabels;
    
    public static String ThreeD = "ThreeD"; 
    public static String TwoD = "TwoD";
    
    public PieChart(int width, int height)
    {
    	super(width, height);
    }

    public PieChart(int width, int height, String pieChartType)        
    {
    	super(width, height);
    	this.pieChartType = pieChartType;
    }

    protected String urlChartType()
    {
        String retour = "p";
        
        if (this.pieChartType.equals(PieChart.ThreeD))
        {
        	retour = "p3";
        }

        return retour;
    }

    protected void collectUrlElements()
    {
        super.collectUrlElements();
        if (pieChartLabels != null)
        {
            String s = "chl=";
            
            for(int i=0;i<pieChartLabels.size();i++)
            {
            	String label = (String) pieChartLabels.get(i);
                s += label;
                if(i<pieChartLabels.size())
                	s += "|";
            }
            
            this.urlElements.add(s);
        }
    }

    /// <summary>
    /// Legend is not supported on Pie Charts
    /// </summary>
    /// <param name="strs"></param>
    public void setLegend(String[] strs) throws InvalidFeatureForChartTypeException
    {
        throw new InvalidFeatureForChartTypeException();        
    }

    /// <summary>
    /// Set labels for the Pie Chart slices
    /// </summary>
    /// <param name="labels">Strings that will be used as label text</param>
    public void setPieChartLabels(Vector labels)
    {
        this.pieChartLabels = labels;
    }

    protected String getChartType()
    {
        return Chart.chartPieChart;
    }
}

