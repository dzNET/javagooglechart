package com.a2a.bay.modules.googlechart.test;

import com.a2a.bay.modules.googlechart.charts.VennDiagram;

public class TestVennDiagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 100, 80, 60, 30, 30, 30, 10 };

		VennDiagram vennDiagram = new VennDiagram(150, 150);
		vennDiagram.setTitle("Venn Diagram");
		vennDiagram.setData(data);

		System.out.println(vennDiagram.getUrl());
		
	}

}
