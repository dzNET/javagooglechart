package com.a2a.googlechart;

import com.a2a.googlechart.charts.LineChart;
import com.a2a.googlechart.data.VectorFloat;

public class FillsTests
{
    public static String solidFillTest()
    {
        int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
        LineChart lineChart = new LineChart(250, 150);
        lineChart.setTitle("Solid fill test");
        lineChart.setData(line1);

        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));

        SolidFill bgFill = new SolidFill(SolidFill.Background, "EFEFEF");
        SolidFill chartAreaFill = new SolidFill(SolidFill.ChartArea, "000000");

        lineChart.AddSolidFill(bgFill);
        lineChart.AddSolidFill(chartAreaFill);

        return lineChart.getUrl();
    }

    public static String linearGradientFillTest()
    {
        int[] line1 = new int[] { 5, 10, 50, 34, 10, 25 };
        LineChart lineChart = new LineChart(250, 150);
        lineChart.setTitle("Linear Gradient fill test");
        lineChart.setData(line1);

        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));

        LinearGradientFill fill = new LinearGradientFill(SolidFill.ChartArea, 45);
        fill.AddColorOffsetPair("FFFFFF", 0);
        fill.AddColorOffsetPair("76A4FB", 0.75);

        SolidFill bgFill = new SolidFill(SolidFill.Background, "EFEFEF");

        lineChart.AddLinearGradientFill(fill);
        lineChart.AddSolidFill(bgFill);

        return lineChart.getUrl();
    }

    public static String linearStripesTest()
    {
        float[] fdata = new float[] { 10, 30, 75, 40, 15 };
        LineChart chart = new LineChart(250, 150);
        chart.setTitle("Linear Stripes Test");
        chart.setData(fdata);

        chart.addAxis(new ChartAxis(ChartAxis.Left));
        chart.addAxis(new ChartAxis(ChartAxis.Bottom));

        LinearStripesFill linearStripesFill = new LinearStripesFill(SolidFill.ChartArea, 0);
        linearStripesFill.AddColorWidthPair("CCCCCC", 0.2);
        linearStripesFill.AddColorWidthPair("FFFFFF", 0.2);
        chart.AddLinearStripesFill(linearStripesFill);

        chart.AddSolidFill(new SolidFill(SolidFill.Background, "EFEFEF"));
        
        return chart.getUrl();
    }

    public static String singleLineAreaFillTest()
    {
        float[] fdata = new float[] { 10, 30, 75, 40, 15 };
        LineChart chart = new LineChart(250, 150);
        chart.setTitle("Area fill test");
        chart.setData(fdata);

        chart.addAxis(new ChartAxis(ChartAxis.Left));
        chart.addAxis(new ChartAxis(ChartAxis.Bottom));

        chart.addFillArea(new FillArea("224499", 0));
        
        return chart.getUrl();
    }

    public static String multiLineAreaFillsTest()
    {
        float[] line1 = new float[] { 15, 45, 5, 30, 10 };
        float[] line2 = new float[] { 35, 65, 25, 50, 30 };
        float[] line3 = new float[] { 55, 85, 45, 70, 50 };

        VectorFloat dataset = new VectorFloat();
        dataset.add(line1);
        dataset.add(line2);
        dataset.add(line3);

        LineChart lineChart = new LineChart(250, 150, LineChart.SingleDataSet);
        lineChart.setTitle("Area fills test");
        lineChart.setData(dataset);

        lineChart.addAxis(new ChartAxis(ChartAxis.Left));
        lineChart.addAxis(new ChartAxis(ChartAxis.Bottom));

        lineChart.addFillArea(new FillArea("FF0000", 0, 1));
        lineChart.addFillArea(new FillArea("224499", 1, 2));

        return lineChart.getUrl();
    }
}
