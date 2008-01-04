package com.a2a.googlechart.charts;

import com.a2a.googlechart.exception.InvalidFeatureForChartTypeException;

public class ScatterPlot extends Chart
{
    /// <summary>
    /// Create a scatter plot
    /// </summary>
    /// <param name="width">width in pixels</param>
    /// <param name="height">height in pixels</param>
    public ScatterPlot(int width, int height){
        super(width, height);
    }

    public String urlChartType()
    {
        return "s";
    }

    public String getChartType()
    {
        return Chart.chartScatterPlot;
    }
    
    public void setGrid(float xAxisStepSize, float yAxisStepSize, float lengthLineSegment, float lengthBlankSegment) throws InvalidFeatureForChartTypeException
    {
        throw new InvalidFeatureForChartTypeException();
    }
}
