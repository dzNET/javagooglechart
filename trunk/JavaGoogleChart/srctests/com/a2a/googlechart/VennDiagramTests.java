package com.a2a.googlechart;

import com.a2a.googlechart.charts.VennDiagram;

public class VennDiagramTests
{
    public static String VennDiagramTest()
    {
        int[] data = new int[] { 100, 80, 60, 30, 30, 30, 10 };

        VennDiagram vennDiagram = new VennDiagram(150, 150);
        vennDiagram.setTitle("Venn Diagram");
        vennDiagram.setData(data);

        return vennDiagram.getUrl();
    }
}
