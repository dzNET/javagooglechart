package com.a2a.googlechart.charts;

/**
 * Represents a bar chart.
 */
public class BarChart extends Chart {
  String orientation;
  String style;
  int barWidth;

  /**
   * Represents a stacked style of the bars.
   */
  public static String Stacked = "Stacked";
  /**
   * Represents a grouped style of the bars.
   */
  public static String Grouped = "Grouped";
  /**
   * Represents a vertical orientation of the bars.
   */
  public static String Vertical = "Vertical";
  /**
   * Represents a horizontal orientation of the bars.
   */
  public static String Horizontal = "Horizontal";

  /**
   * Creates a new bar chart.
   * @param width Width in pixels
   * @param height Height in pixels
   * @param orientation The orientation of the bars 
   *        (BarChart.Horizontal, BarChart.Vertical)
   * @param style Bar chart style when using multiple data sets
   */
  public BarChart(int width, int height, String orientation, String style) {
    super(width, height);

    this.orientation = orientation;
    this.style = style;
  }

  /**
   * Sets the width of the individual bars.
   * @param width Width in pixels
   */
  public void SetBarWidth(int width) {
    this.barWidth = width;
  }

  /**
   * Returns the chart identifier used in the chart url.
   * @return String
   */
  protected String urlChartType() {
    char orientationChar = this.orientation == BarChart.Horizontal ? 'h' : 'v';
    char styleChar = this.style == BarChart.Stacked ? 's' : 'g';

    return "b" + orientationChar + styleChar;
  }

  /**
   * Collect all the elements that will make up the chart url. 
   */
  protected void collectUrlElements() {
    super.collectUrlElements();
    if (this.barWidth != 0) {
      super.urlElements.add("chbh=" + this.barWidth);
    }
  }

  /**
   * Returns the chart type for this chart
   */
  protected String getChartType() {
    return Chart.chartBarChart;
  }
}
