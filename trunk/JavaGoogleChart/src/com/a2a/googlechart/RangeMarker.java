package com.a2a.googlechart;

/**
 * Represents a range marker.
 */
public class RangeMarker {
  public static final String Horizontal = "Horizontal";
  public static final String Vertical = "Vertical";

  private String type;
  private String color;
  private double startPoint;
  private double endPoint;

  /**
   * Create a range marker for line charts and scatter plots.
   * @param rangeMarkerType
   * @param color an RRGGBB format hexadecimal number
   * @param startPoint Must be between 0.0 and 1.0. 0.0 is axis start, 1.0 is 
   *        axis end.
   * @param endPoint Must be between 0.0 and 1.0. 0.0 is axis start, 1.0 is 
   *        axis end.     
   */
  public RangeMarker(String rangeMarkerType, String color, double startPoint,
      double endPoint) {
    this.type = rangeMarkerType;
    this.color = color;
    this.startPoint = startPoint;
    this.endPoint = endPoint;
  }

  /**
   * Returns the url part for the range marker type.
   * @return String
   */
  public String getTypeUrlChar() {
    String retour = null;
    if (this.type.equals(RangeMarker.Horizontal)) {
      retour = "r";
    } else if (this.type.equals(RangeMarker.Vertical)) {
      retour = "R";
    }
    return retour;
  }

  /**
   * Returns the url for the range marker.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");
    s += getTypeUrlChar() + ",";
    s += color + ",";
    // this value is ignored - but has to be a number
    s += "0" + ",";
    s += String.valueOf(startPoint) + ",";
    s += String.valueOf(endPoint);
    return s;
  }

  /**
   * Returns range marker type.
   * @return String
   */
  public String getType() {
    return type;
  }

  /**
   * Sets range marker type.
   * @param type String
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Returns the color of the range marker.
   * @return color in RRGGBB format 
   */
  public String getColor() {
    return color;
  }

  /**
   * Sets the color of the range marker.
   * @param colo in RRGGBB format
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Returns the start point for the range marker.
   * @return double
   */
  public double getStartPoint() {
    return startPoint;
  }

  /**
   * Sets the start point for the range marker.
   * @param startPoint double
   */
  public void setStartPoint(double startPoint) {
    this.startPoint = startPoint;
  }

  /**
   * Returns the end point for the range marker.
   * @return double
   */
  public double getEndPoint() {
    return endPoint;
  }

  /**
   * Sets the end point for the range marker.
   * @param startPoint double
   */
  public void setEndPoint(double endPoint) {
    this.endPoint = endPoint;
  }
}

