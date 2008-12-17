package com.a2a.googlechart.charts;

import java.util.ArrayList;

/**
 * Represents a line chart.
 */
public class LineChart extends Chart {
  /**
   * Represents a line chart, where data points are spaced evenly along the 
   * x-axis.
   */
  public static final String SingleDataSet = "SingleDataSet";
  /**
   * Represents a line chart, where a pair of data sets (x,y) is required for 
   * each line.
   */
  public static final String MultiDataSet  = "MultiDataSet";

  private String lineChartType = LineChart.SingleDataSet;
  private ArrayList<LineStyle> lineStyles = new ArrayList<LineStyle>();

  /**
   * Creates a line chart with one line per dataset. Points are evenly spaced
   * along the x-axis.
   * @param width width in pixels
   * @param height height in pixels
   */
  public LineChart(int width, int height) {
    super(width, height);
    this.lineChartType = LineChart.SingleDataSet;
  }

  /**
   * Creates a line chart pf the specified type.
   * @param width width in pixels
   * @param height height in pixels
   * @param lineChartType specifies how the chart handles datasets
   */
  public LineChart(int width, int height, String lineChartType) {
    super(width, height);
    this.lineChartType = lineChartType;
  }

  /**
   * Returns the url part for the chart type.
   */
  protected String urlChartType() {
    if (this.lineChartType.equals(LineChart.MultiDataSet)) {
      return "lxy";
    }
    return "lc";
  }

  /**
   * Applies a style to a line. Line styles are applied to lines in order, the 
   * first line will use the first line style.
   * @param lineStyle LineStyle object
   */
  public void addLineStyle(LineStyle lineStyle) {
    lineStyles.add(lineStyle);
  }

  protected void collectUrlElements() {
    super.collectUrlElements();
    if (lineStyles.size() > 0) {
      String s = "chls=";
      for(int i = 0; i < lineStyles.size(); i++) {
        LineStyle lineStyle = (LineStyle) lineStyles.get(i);

        s += String.valueOf(lineStyle.getLineThickness()) + ",";
        s += String.valueOf(lineStyle.getLengthOfSegment()) + ",";
        s += String.valueOf(lineStyle.getLengthOfBlankSegment()) + "|";
      }

      urlElements.add( trimEnd(s,'|'));
    }
  }

  protected String getChartType() {
    return Chart.chartLineChart;
  }
}

/**
 * Represents a line style (thickness, dash).
 */
class LineStyle {
  private float lineThickness;
  private float lengthOfSegment;
  private float lengthOfBlankSegment;

  /**
   * Creates a line style. 
   * @param lineThickness line thickness in pixels
   * @param lengthOfSegment length of each solid line segment in pixels
   * @param lengthOfBlankSegment length of each blank line segment in pixels
   */
  public LineStyle(float lineThickness, float lengthOfSegment, 
      float lengthOfBlankSegment) {
    this.lineThickness = lineThickness;
    this.lengthOfSegment = lengthOfSegment;
    this.lengthOfBlankSegment = lengthOfBlankSegment;
  }

  /**
   * Returns line thickness.
   * @return thickness in pixels
   */
  public float getLineThickness() {
    return lineThickness;
  }

  /**
   * Sets line thickness.
   * @param lineThickness in pixels
   */
  public void setLineThickness(float lineThickness) {
    this.lineThickness = lineThickness;
  }

  public float getLengthOfSegment() {
    return lengthOfSegment;
  }

  public void setLengthOfSegment(float lengthOfSegment) {
    this.lengthOfSegment = lengthOfSegment;
  }

  public float getLengthOfBlankSegment() {
    return lengthOfBlankSegment;
  }

  public void setLengthOfBlankSegment(float lengthOfBlankSegment) {
    this.lengthOfBlankSegment = lengthOfBlankSegment;
  }
}
