package com.a2a.googlechart;

import java.util.ArrayList;

import com.a2a.googlechart.charts.Chart;

/**
 * Represents a chart's axis.
 */
public class ChartAxis {
  /**
   * Represents the left position of the axis or the left alignment of the axis 
   * labels.
   */
  public static final String Left = "Left";
  /**
   * Represents the central alignment of the axis labels.
   */
  public static final String Centered = "Centered";
  /**
   * Represents the right position of the axis or the right alignment of the 
   * axis labels.
   */
  public static final String Right = "Right";
  /**
   * Represents the unset alignment of the axis labels.
   */
  public static final String Unset = "Unset";
  /**
   * Represents the bottom position of the axis.
   */
  public static final String Bottom = "Bottom";
  /**
   * Represents the top position of the axis.
   */
  public static final String Top = "Top";

  String axisType;
  ArrayList<ChartAxisLabel> axisLabels = new ArrayList<ChartAxisLabel>();
  float tickMarkSize;
  private boolean ticksMarksSet = false;
  int upperBound;
  int lowerBound;
  boolean rangeSet;
  String color;
  int fontSize = -1;
  String alignment = ChartAxis.Unset;

  /**
   * Creates an axis, default is range 0 - 100 evenly spaced. You can create 
   * multiple axes of the same this.
   * @param axisType Axis type (top, bottom, left, right)
   */
  public ChartAxis(String axisType) {
    this.axisType = axisType;
  }

  /**
   * Create an axis, default is range 0 - 100 evenly spaced. You can create 
   * multiple axes of the same this.
   * @param axisType Axis type (top, bottom, left, right) 
   * @param labels These labels will be added to the axis without 
   *        position information 
   */
  public ChartAxis(String axisType, String[] labels) {
    this.axisType = axisType;

    if (labels != null) {
      for (int i=0; i<labels.length; i++) {
        String label = (String) labels[i];
        this.axisLabels.add(new ChartAxisLabel(label, -1));
      }
    }
  }

  /**
   * Sets the axis range.
   * @param lowerBound the lowest value on the axis
   * @param upperBound the highest value on the axis
   */
  public void SetRange(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.rangeSet = true;
  }

  /**
   * Sets the size for the axis tick marks.
   * @param tickMarksSize size in pixels
   */
  public void setTickMarksSize(float tickMarksSize) {
    this.tickMarkSize = tickMarksSize;
    this.ticksMarksSet = true;
  }
  
  /**
   * Adds a label to the axis.
   * @param axisLabel ChartAxisLabel object
   */
  public void addLabel(ChartAxisLabel axisLabel) {
    axisLabels.add(axisLabel);
  }

  /**
   * Returns the url part for the axis style.
   * @return String
   */
  public String urlAxisStyle() {
    if (color == null) {
      return null;
    }
    String result = color + ",";
    if (fontSize != -1) {
      result += String.valueOf(fontSize) + ",";
    }

    if (!alignment.equals(ChartAxis.Unset)) {
      if (alignment.equals(ChartAxis.Left)) {
        result += "-1,";
      } else if (alignment.equals(ChartAxis.Centered)) {
        result += "0,";
      } else if(alignment.equals(ChartAxis.Right)) {
        result += "1,";
      }       
    }

    return Chart.trimEnd(result,',');
  }
  
  /**
   * Returns the url part for the axis tick marks.
   * @return String
   */
  public String urlAxisTickMarks() {
    if (ticksMarksSet) {
      return String.valueOf(tickMarkSize);
    }
    return null;
  }

  /**
   * Returns the url part for the axis type.
   * @return String
   */
  public String urlAxisType() {
    String retour = null;

    if (axisType.equals(ChartAxis.Bottom)) {
      retour = "x";
    } else if(axisType.equals(ChartAxis.Top)) {
      retour = "t";
    } else if(axisType.equals(ChartAxis.Left)) {
      retour = "y";
    } else if(axisType.equals(ChartAxis.Right)) {
      retour = "r";
    }   

    return retour;
  }

  /**
   * Returns the url part for the axis labels.
   * @return String
   */
  public String urlLabels() {
    String result = "|";
    for (int i = 0; i < axisLabels.size(); i++) {
      ChartAxisLabel label = (ChartAxisLabel) axisLabels.get(i);
      result += label.text + "|";        	
    }

    return result;
  }

  /**
   * Returns the url part for the label positions.
   * @return String
   */
  public String urlLabelPositions() {
    String result = new String("");
    for(int i=0; i<axisLabels.size(); i++) {
      ChartAxisLabel axisLabel = (ChartAxisLabel) axisLabels.get(i);
      if (axisLabel.position == -1) {
        return null;
      }
      result += String.valueOf(axisLabel.position) + ",";
    }

    return Chart.trimEnd(result,',');
  }

  /**
   * Returns the url part for the axis range.
   * @return String
   */
  public String urlRange() {
    if (rangeSet) {
      return String.valueOf(lowerBound) + "," + String.valueOf(upperBound);
    }
    return null;
  }
}

/**
 * Describes an axis label.
 */
class ChartAxisLabel {
  public String text;
  public float position;

  /**
   * Creates an axis label without position information, labels will be evenly 
   * spaced on the axis.
   * @param text The label text
   */
  public ChartAxisLabel(String text) {
    this.text = text;
    this.position = -1;
  }

  /**
   * Creates an axis label without position information, labels will be evenly 
   * spaced on the axis.
   * @param text The label text
   */
  public ChartAxisLabel(float position) {
    this.text = null;
    this.position = position;
  }

  /**
   * Creates an axis label with label text and position.
   * @param text The label text
   * @param position The label position within the axis range
   */
  public ChartAxisLabel(String text, float position) {
    this.text = text;
    this.position = position;
  }
}
