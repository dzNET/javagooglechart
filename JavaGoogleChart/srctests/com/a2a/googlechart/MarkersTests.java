package com.a2a.googlechart;

import com.a2a.googlechart.charts.LineChart;

public class MarkersTests
{
    public static String rangeMarkersTest()
    {
        float[] fdata = new float[] { 10, 30, 75, 40, 15 };
        LineChart chart = new LineChart(250, 150);
        chart.setTitle("Range markers test");
        chart.setData(fdata);

        chart.addAxis(new ChartAxis(ChartAxis.Left));
        chart.addAxis(new ChartAxis(ChartAxis.Bottom));

        chart.addRangeMarker(new RangeMarker(RangeMarker.Horizontal, "EFEFEF", 0.2, 0.7));
        chart.addRangeMarker(new RangeMarker(RangeMarker.Vertical, "CCCCCC", 0.4, 0.6));

        return chart.getUrl();
    }

    public static String shapeMarkersTest()
    {
        float[] fdata = new float[] { 10, 30, 75, 40, 15 };
        LineChart chart = new LineChart(300, 150);
        chart.setTitle("Shape markers test");
        chart.setData(fdata);

        chart.addAxis(new ChartAxis(ChartAxis.Left));
        chart.addAxis(new ChartAxis(ChartAxis.Bottom));

        chart.addShapeMarker(new ShapeMarker(ShapeMarker.Arrow, "FF0000", 0, 0, 5));
        chart.addShapeMarker(new ShapeMarker(ShapeMarker.Circle, "00FF00", 0, 1, 15));
        chart.addShapeMarker(new ShapeMarker(ShapeMarker.Cross, "0000FF", 0, 2, 15));
        chart.addShapeMarker(new ShapeMarker(ShapeMarker.VerticalLine, "FF0000", 0, 3, 2));

        return chart.getUrl();
    }
}

