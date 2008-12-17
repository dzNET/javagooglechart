package com.a2a.googlechart;

/**
 * Represents a shape marker.
 */
public class ShapeMarker {
  String type;
  String color;
  int datasetIndex;
  float dataPoint;
  int size;

  public static final String Arrow = "Arrow";
  public static final String Cross = "Cross";
  public static final String Diamond = "Diamond";
  public static final String Circle = "Circle";
  public static final String Square = "Square";
  public static final String VerticalLineToDataPoint = "VerticalLineToDataPoint";
  public static final String VerticalLine = "VerticalLine";
  public static final String HorizontalLine = "HorizontalLine";
  public static final String XShape = "XShape";

  /**
   * Create a shape marker for points on line charts and scatter plots.
   * @param markerType
   * @param hexColor RRGGBB format hexadecimal number
   * @param datasetIndex the index of the line on which to draw the marker. 
   *        This is 0 for the first data set, 1 for the second and so on
   * @param dataPoint a floating point value that specifies on which data 
   *        point the marker will be drawn. This is 1 for the first data set, 
   *        2 for the second and so on. Specify a fraction to interpolate a 
   *        marker between two points.
   * @param size the size of the marker in pixels
   */
  public ShapeMarker(String markerType, String color, int datasetIndex, 
      float dataPoint, int size) {
    this.type = markerType;
    this.color = color;
    this.datasetIndex = datasetIndex;
    this.dataPoint = dataPoint;
    this.size = size;
  }

  /**
   * Returns the url part for the shape marker type.
   * @return String
   */
  protected String getTypeUrlChar() {
    String retour = null;

    if (this.type.equals(ShapeMarker.Arrow)) {
      retour =  "a";
    } else if (this.type.equals(ShapeMarker.Cross)) {
      retour =  "c";
    } else if (this.type.equals(ShapeMarker.Diamond)) {
      retour =  "d";
    } else if (this.type.equals(ShapeMarker.Circle)) {
      retour =  "o";
    } else if (this.type.equals(ShapeMarker.Square)) {
      retour =  "s";
    } else if (this.type.equals(ShapeMarker.VerticalLineToDataPoint)) {
      retour =  "v";
    } else if (this.type.equals(ShapeMarker.VerticalLine)) {
      retour =  "V";
    } else if (this.type.equals(ShapeMarker.HorizontalLine)) {
      retour =  "h";
    } else if(this.type.equals(ShapeMarker.XShape)) {
      retour =  "x";
    }
    return retour;
  }

  /**
   * Returns the url for the shape marker.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");
    s += getTypeUrlChar() + ",";
    s += color + ",";
    s += datasetIndex + ",";
    s += dataPoint + ",";
    s += String.valueOf(size);
    return s;
  }
}
