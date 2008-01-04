package com.a2a.googlechart;

import com.a2a.googlechart.charts.ScatterPlot;
import com.a2a.googlechart.data.VectorInt;

public class ScatterPlotTests
{
    public static String scatterPlotTest()
    {
        int[] xData = { 10, 20, 30, 40, 50 };
        int[] yData = { 10, 20, 30, 40, 50 };

        VectorInt dataset = new VectorInt();
        dataset.add(xData);
        dataset.add(yData);

        ScatterPlot scatterPlot = new ScatterPlot(150, 150);
        scatterPlot.setTitle("Scatter Plot");
        scatterPlot.setData(dataset);

        scatterPlot.addAxis(new ChartAxis(ChartAxis.Left));
        scatterPlot.addAxis(new ChartAxis(ChartAxis.Bottom));

        return scatterPlot.getUrl();
    }
}
