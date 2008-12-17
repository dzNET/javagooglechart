package com.a2a.googlechart;

import java.util.ArrayList;

import com.a2a.googlechart.charts.Chart;

/**
 * Represents a linear stripes fill of the chart.
 */
public class LinearStripesFill {
  private String fillTarget;
  private int angle;
  private ArrayList<ColorWidthPair> colorWidthPairs = 
      new ArrayList<ColorWidthPair>();

  /**
   * Creates a linear stripes fill.
   * @param fillTarget The area that will be filled.
   * @param angle specifies the angle of the gradient between 0 (vertical)
   *        and 90 (horizontal) 
   */
  public LinearStripesFill(String fillTarget, int angle) {
    this.fillTarget = fillTarget;
    this.angle = angle;
  }

  /**
   * Adds a color/width pair that describes a linear stripe.
   * @param color RRGGBB format hexadecimal number
   * @param width must be between 0 and 1 where 1 is the full width of the chart 
   */
  public void AddColorWidthPair(String color, double width) {
    this.colorWidthPairs.add(new ColorWidthPair(color, width));
  }

  /**
   * Returns the url part for the fill type.
   * @return String
   */
  protected String getTypeUrlChar() {
    String retour = null;

    if (fillTarget.equals(SolidFill.ChartArea)) {
      retour = "c";
    } else if(fillTarget.equals(SolidFill.Background)) {
      retour = "bg";
    }

    return retour;
  }

  /**
   * Returns the url for the linear stripes fill.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");
    s += getTypeUrlChar() + ",";
    s += "ls,";
    s += String.valueOf(angle) + ",";

    for(int i = 0 ; i < colorWidthPairs.size(); i++) {
      ColorWidthPair colorWidthPair = (ColorWidthPair) colorWidthPairs.get(i);
      s += colorWidthPair.color + ",";
      s += colorWidthPair.width + ",";
    }

    return Chart.trimEnd(s,',');
  }

  /**
   * Represents a pair of color and its corresponding width.
   */
  private class ColorWidthPair {
    public String color;
    public double width;

    /**
     * Describes a linear stripe. Stripes are repeated until the chart is 
     * filled.
     * @param color RGGBB format hexadecimal number
     * @param width must be between 0 and 1 where 1 is the full width of the 
     *        chart 
     */
    public ColorWidthPair(String color, double width) {
      this.color = color;
      this.width = width;
    }
  }
}
