/*
 * Created on 4 janv. 08
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.a2a.googlechart.interfaces;


public interface IGridChart {
	
	public void setGrid(float xAxisStepSize, float yAxisStepSize);
	public void setGrid(float xAxisStepSize, float yAxisStepSize, float lengthLineSegment, float lengthBlankSegment);
}
