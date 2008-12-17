package com.a2a.googlechart.charts;

/**
 * Represents a pie chart.
 */
public class PieChart extends Chart {
  private String pieChartType;
  private String[] pieChartLabels;

  /**
   * Represents a 3D pie chart type.
   */
  public static String ThreeD = "ThreeD"; 
  /**
   * Represents a 2D pie chart type.
   */
  public static String TwoD = "TwoD";

  /**
   * Creates a new pie chart of given width and height.
   * @param width in pixels
   * @param height in pixels
   */
  public PieChart(int width, int height) {
    super(width, height);
    this.pieChartType = TwoD;
  }

  /**
   * Creates a new pie chart of given type and with given width and height.
   * @param width in pixels
   * @param height in pixels
   * @param pieChartType 2D or 3D
   */
  public PieChart(int width, int height, String pieChartType) {
    super(width, height);
    this.pieChartType = pieChartType;
  }

  /**
   * Returns the url part with chart type.
   * @return String
   */
  protected String urlChartType() {
    String retour = "p";

    if (this.pieChartType.equals(PieChart.ThreeD)) {
      retour = "p3";
    }

    return retour;
  }

  protected void collectUrlElements() {
    super.collectUrlElements();
    if (pieChartLabels != null) {
      String s = "chl=";

      for(int i = 0; i < pieChartLabels.length; i++) {
        String label = (String) pieChartLabels[i];
        s += label;
        if (i < pieChartLabels.length) {
          s += "|";
        }
      }

      this.urlElements.add(s);
    }
  }

  /**
   * Sets the labels for the Pie Chart slices.
   * @param labels Strings that will be used as label text
   */
  public void setPieChartLabels(String[] labels) {
    this.pieChartLabels = labels;
  }

  protected String getChartType() {
    return Chart.chartPieChart;
  }
}
