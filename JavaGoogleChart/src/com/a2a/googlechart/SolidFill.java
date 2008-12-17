package com.a2a.googlechart;

/**
 * Represents a solid fill of the chart.
 */
public class SolidFill {
  public static final String Background = "Background";
  public static final String ChartArea = "ChartArea";

  private String fillTarget;
  private String color;

  /**
   * Creates a new SolidFill.
   * @param fillTarget The area that will be filled.
   * @param color RRGGBB format hexadecimal number
   */
  public SolidFill(String fillTarget, String color) {
    this.fillTarget = fillTarget;
    this.color = color;
  }

  /**
   * Returns the url part for the fill target.
   * @return String
   */
  private String getTypeUrlChar() {
    String retour = null;

    if(fillTarget.equals(SolidFill.ChartArea))
      retour = "c";
    else if(fillTarget.equals(SolidFill.Background))
      retour = "bg";

    return retour;
  }

  /**
   * Returns the url for the solid fill.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");
    s += getTypeUrlChar() + ",";
    s += "s,";
    s += this.color;
    return s;
  }

  public String getFillTarget() {
    return fillTarget;
  }

  public void setFillTarget(String fillTarget) {
    this.fillTarget = fillTarget;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
