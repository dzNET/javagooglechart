package com.a2a.googlechart;

/**
 * Represents a fill area between lines for use on a line chart.
 */
public class FillArea {
  public static final String SingleLine = "SingleLine";
  public static final String MultiLine = "MultiLine";

  private String type;
  private String color;
  private int startLineIndex;
  private int endLineIndex;

  /**
   * Creates a fill area between lines for use on a line chart.
   * @param color an RRGGBB format hexadecimal number
   * @param startLineIndex line indices are determined by the order in 
   *        which datasets are added. The first set is index 0, then index 1 etc
   * @param endLineIndex line indices are determined by the order in which 
   *        datasets are added. The first set is index 0, then index 1 etc 
   */
  public FillArea(String color, int startLineIndex, int endLineIndex) {
    this.type = FillArea.MultiLine;
    this.color = color;
    this.startLineIndex = startLineIndex;
    this.endLineIndex = endLineIndex;
  }

  /**
   * Creates a fill for all the area under a line.
   * @param color an RRGGBB format hexadecimal number
   * @param lineIndex line indexes are determined by the order in which datasets
   *        are added. The first set is index 0, then index 1 etc 
   */
  public FillArea(String color, int lineIndex) {
    this.type = FillArea.SingleLine;
    this.color = color;
    this.startLineIndex = lineIndex;
  }

  /**
   * Returns the string containing the url for the chart.
   * @return String
   */
  public String getUrlString() {
    String s = new String("");

    if (type.equals(FillArea.MultiLine)) {
      s += "b" + ",";
      s += this.color + ",";
      s += String.valueOf(this.startLineIndex) + ",";
      s += String.valueOf(this.endLineIndex) + ",";
      s += "0"; // ignored
    } else if (type.equals(FillArea.SingleLine)) {
      s += "B" + ",";
      s += this.color + ",";
      s += String.valueOf(this.startLineIndex) + ",";
      s += "0" + ","; // ignored
      s += "0"; // ignored
    }

    return s;
  }
}
