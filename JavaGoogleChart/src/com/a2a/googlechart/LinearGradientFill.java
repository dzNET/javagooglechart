package com.a2a.googlechart;

import java.util.ArrayList;

import com.a2a.googlechart.charts.Chart;

/**
 * Represents a linear gradient fill.
 */
public class LinearGradientFill {
  private String fillTarget;
  private int angle;
  private ArrayList<ColorOffsetPair> colorOffsetPairs = 
      new ArrayList<ColorOffsetPair>();

  /**
   * Creates a linear gradient.
   * @param fillTarget area to be filled
   * @param angle specifies the angle of the gradient between 0 (horizontal) 
   *        and 90 (vertical)
   */
  public LinearGradientFill(String fillTarget, int angle) {
    this.fillTarget = fillTarget;
    this.angle = angle;
  }

  /**
   * Adds a color/offset pair to the linear gradient.
   * @param color RRGGBB format hexadecimal number
   * @param offset specifies at what point the color is pure where: 0 specifies the right-most chart position and 1 the left-most</param> 
   */
  public void AddColorOffsetPair(String color, double offset) {
    this.colorOffsetPairs.add(new ColorOffsetPair(color, offset));
  }

  /**
   * Returns the url part for the gradient type.
   * @return String
   */
  public String getTypeUrlChar() {
    String retour = null;

    if(fillTarget.equals(SolidFill.ChartArea)) {
      retour = "c";
    } else if(fillTarget.equals(SolidFill.Background)) {
      retour = "bg";
    }

    return retour;
  }

  /**
   * Returns the url for the gradient.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");
    s += getTypeUrlChar() + ",";
    s += "lg,";
    s += String.valueOf(angle) + ",";

    for(int i = 0; i < colorOffsetPairs.size(); i++) {
      ColorOffsetPair colorOffsetPair = (ColorOffsetPair) colorOffsetPairs.get(i);
      s += colorOffsetPair.color + ",";
      s += colorOffsetPair.offset + ",";
    }

    return Chart.trimEnd(s,',');
  }

  /**
   * Represents a pair of color and its corresponding offset. 
   */
  private class ColorOffsetPair {
    /**
     * RRGGBB format hexadecimal number
     */
    public String color;

    /**
     * Specifies at what point the color is pure where: 0 specifies the 
     * right-most chart position and 1 the left-most.
     */
    public double offset;

    /**
     * Creates a new ColorOffsetPair.
     * @param color RRGGBB format hexadecimal number
     * @param offset specify at what point the color is pure where: 0 specifies 
     *        the right-most chart position and 1 the left-most
     */
    public ColorOffsetPair(String color, double offset) {
      this.color = color;
      this.offset = offset;
    }
  }
}
