package lab2.graph;

/**
 * Class to collect all types of time.
 * @author gusarov2906
 *
 */

public class SummaryTime {
	public long addTotalTime = 0;
	public long addTotalCount = 0;
	public long addMedianTime = 0;
	public long removeTotalCount = 0;
	public long removeTotalTime = 0;
	public long removeMedianTime = 0;
	
	/*
	 * print - debug function to show all fields.
	 */
	public void print()
	{
		System.out.println("!SummaryTime");
		System.out.println(addTotalTime);
		System.out.println(addTotalCount);
		System.out.println(addMedianTime);
		System.out.println(removeTotalCount);
		System.out.println(removeTotalTime);
		System.out.println(removeMedianTime);
	}
}
