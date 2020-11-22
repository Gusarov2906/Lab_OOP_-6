package lab2.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import lab2.main.Logger;

/**
 * Class with fields with data which will illustrate time-size dependence of actions from different containers.
 * @author gusarov2906
 *
 */
public class GraphData {
	public ArrayList<SummaryTime> arrayListTime = new  ArrayList<SummaryTime>();
	public ArrayList<SummaryTime> linkedListTime = new  ArrayList<SummaryTime>();
	public ArrayList<Point> points = new ArrayList<Point>();
	private String mainTitle = "";
	private int leftX = 80;
	
	/**
	 * setMainTitle - setter for main title.
	 * @param str - main title.
	 */
	
	public void setMainTitle(String str)
	{
		mainTitle = str;
	}
	
	/**
	 * getMainTitle - getter for main title.
	 * @return main title.
	 */
	
	public String getMainTitle()
	{
		return mainTitle;
	}
	
	/**
	 * fillPointsByAddTotalTime - function to fill ArraList with add total time data.
	 * @param array - ArrayList with data.
	 */
	
	public void fillPointsByAddTotalTime(ArrayList<SummaryTime> array)
	{
		for (int j = 0; j < 5; j++)
		{
			points.add(new Point(leftX+76*(j+1),(int)(array.get(j).addTotalTime/100000)));
		}
	}
	
	/**
	 * fillPointsByAddMedianTime - function to fill ArraList with add median time data.
	 * @param array - ArrayList with data.
	 */
	
	public void fillPointsByAddMedianTime(ArrayList<SummaryTime> array)
	{
		for (int j = 0; j < 5;  j++)
		{
			points.add(new Point(leftX+76*(j+1),(int)array.get(j).addMedianTime));
		}
	}
	
	/**
	 * fillPointsByRemoveTotalTime - function to fill ArraList with remove total time data.
	 * @param array - ArrayList with data.
	 */
	
	public void fillPointsByRemoveTotalTime(ArrayList<SummaryTime> array)
	{
		for (int j = 0; j < 5;  j++)
		{
			points.add(new Point(leftX+76*(j+1),(int)(array.get(j).removeTotalTime/100000)));
		}
	}
	
	/**
	 * fillPointsByRemoveMedianTime - function to fill ArraList with remove median time data.
	 * @param array - ArrayList with data.
	 */
	
	public void fillPointsByRemoveMedianTime(ArrayList<SummaryTime> array)
	{
		for (int j = 0; j < 5;  j++)
		{
			points.add(new Point(leftX+76*(j+1),(int)array.get(j).removeMedianTime));
		}
	}
	
	/**
	 * getFromFile - function to get all data for illustration from file.
	 */
	
	public void getFromFile()
	{	
		 try (FileReader reader = new FileReader("lab5log.txt")) 
	        {
	            BufferedReader read = new BufferedReader(reader);
	            for(int i = 0; i < 5; i++)
	            {
	            read.readLine();
	            SummaryTime tmp1 = new SummaryTime();
	            tmp1.addTotalCount = Long.parseLong(read.readLine());
	            tmp1.addTotalTime = Long.parseLong(read.readLine());
	            tmp1.addMedianTime = Long.parseLong(read.readLine());
	            tmp1.removeTotalCount = Long.parseLong(read.readLine());
	            tmp1.removeTotalTime = Long.parseLong(read.readLine());
	            tmp1.removeMedianTime = Long.parseLong(read.readLine());
	            //tmp1.print();
	            
	            arrayListTime.add(tmp1);
	            read.readLine();
	            SummaryTime tmp2 = new SummaryTime();
	            tmp2.addTotalCount = Long.parseLong(read.readLine());
	            tmp2.addTotalTime = Long.parseLong(read.readLine());
	            tmp2.addMedianTime = Long.parseLong(read.readLine());
	            tmp2.removeTotalCount = Long.parseLong(read.readLine());
	            tmp2.removeTotalTime = Long.parseLong(read.readLine());
	            tmp2.removeMedianTime = Long.parseLong(read.readLine());
	            //tmp2.print();
	            linkedListTime.add(tmp2);
	            }
	            
	            read.close();
	        } 
	        catch (Exception e) 
	        {
				Logger.addError(e);
	            System.out.println("Exception: " + e.getMessage());
	        }
	}
	
	/**
	 * getMaxY - function to get max Y from points.
	 * @return max - max.
	 */
	
	public int getMaxY()
	{
		int max = points.get(0).y;
		for (int i = 1; i < points.size(); i++)
		{
			if (max < points.get(i).y)
				max = points.get(i).y;
		}
		return max;
	}
	
}
