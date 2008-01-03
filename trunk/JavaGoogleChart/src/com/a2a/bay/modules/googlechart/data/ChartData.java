package com.a2a.bay.modules.googlechart.data;

import com.a2a.bay.modules.googlechart.charts.Chart;


public class ChartData
{
    public static String Encode(int[] data)
    {
        int maxValue = findMaxValue(data);
        if (maxValue <= 61)
        {
            return SimpleEncoding(data);
        }
        else if (maxValue <= 4095)
        {
            return ExtendedEncoding(data);
        }

        return null;
    }

    public static String Encode(VectorInt data)
    {
        int maxValue = findMaxValue(data);
        if (maxValue <= 61)
        {
            return SimpleEncoding(data);
        }
        else if (maxValue <= 4095)
        {
            return ExtendedEncoding(data);
        }

        return null;
    }

    public static String Encode(float[] data)
    {
        return TextEncoding(data);
    }

    public static String Encode(VectorFloat data)
    {
        return TextEncoding(data);
    }

    public static String SimpleEncoding(int[] data)
    {
        return "chd=s:" + simpleEncode(data);
    }

    public static String SimpleEncoding(VectorInt data)
    {
        String chartData = "chd=s:";

        for(int i=0;i<data.size();i++)
        {
        	int[] objectArray = (int[]) data.get(i);
            chartData += simpleEncode(objectArray) + ",";
        }

        return chartData;
    }

    private static String simpleEncode(int[] data)
    {
        String simpleEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String chartData = new String("");

        for(int i=0;i<data.length;i++)
        {
        	int value = data[i];
        	
            if (value == -1)
            {
                chartData += "_";
            }
            else
            {
                char c = simpleEncoding.charAt(value);
                chartData += String.valueOf(c);
            }
        }

        return chartData;
    }

    public static String TextEncoding(float[] data)
    {
        return "chd=t:" + textEncode(data);
    }

    public static String TextEncoding(VectorFloat data)
    {
        String chartData = "chd=t:";

        for(int i=0;i<data.size();i++)
        {
        	float[] objectArray = (float[])data.get(i);
            chartData += textEncode(objectArray) + "|";
        }

        return Chart.trimEnd(chartData,'|');
    }

    private static String textEncode(float[] data)
    {
        String chartData = new String("");

        for(int i=0;i<data.length;i++)
        {
        	float value = data[i];
        	
            if (value == -1)
            {
                chartData += "-1,";
            }
            else
            {
                chartData += String.valueOf(value) + ",";
            }
        }

        return Chart.trimEnd(chartData,',');
    }

    public static String ExtendedEncoding(int[] data)
    {
        return "chd=e:" + extendedEncode(data);
    }

    public static String ExtendedEncoding(VectorInt data)
    {
        String chartData = "chd=e:";
        
        for(int i=0;i<data.size();i++)
        {
        	int[] objectArray = (int[])data.get(i);
        	chartData += extendedEncode(objectArray) + ",";
        }

        return Chart.trimEnd(chartData,',');
    }

    private static String extendedEncode(int[] data)
    {
        String extendedEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-.";
        String chartData = new String("");

        for(int i=0;i<data.length;i++)
        {
        	int value = data[i];
        	
            if (value == -1)
            {
                chartData += "__";
            }
            else
            {
                int firstCharPos = (int)(Math.floor((double)(value / extendedEncoding.length())));
                int secondCharPos = (int)(Math.floor((double)(value % extendedEncoding.length())));

                chartData += extendedEncoding.charAt(firstCharPos);
                chartData += extendedEncoding.charAt(secondCharPos);
            }
        }

        return chartData;
    }

    private static int findMaxValue(int[] data)
    {
        int maxValue = -1;
        
        for(int i=0;i<data.length;i++)
        {
        	int value = data[i];
        	
            if (value > maxValue)
            {
                maxValue = value;
            }
        }

        return maxValue;
    }

    private static int findMaxValue(VectorInt data)
    {
    	int[] maxValuesList = new int[20];

    	for(int i=0;i<data.size();i++)
    	{
    		int[] objectArray = (int[]) data.get(i);
    		maxValuesList[i] = findMaxValue(objectArray);
    	}
    	
    	int maxValue = findMaxValue(maxValuesList);
    	return maxValue;

        //int[] maxValues = maxValuesList.toArray();
        //Array.Sort(maxValues);
        //return maxValues[maxValues.length - 1];
    }
}
