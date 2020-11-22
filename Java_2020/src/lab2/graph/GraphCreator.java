package lab2.graph;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

/**
 * Class which will illustrate time-size dependence of actions from different containers.
 */
public class GraphCreator {
	/**
	 * create - static function to create window.
	 * @param type - type of data to illustrate.
	 */
	public static void create(TypeOfGraph type)
	{
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				MainFrame frame = new MainFrame(type);
				frame.setResizable(false);
				frame.setTitle("CraphCreator");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
	
	/**
	 * 
	 * @author gusarov2906
	 * Component for window with graph and all info.
	 */
	public static class Graph extends JComponent
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int W = 10;
		private int H = 10;
		
		public GraphData graphData = new GraphData();
		public TypeOfGraph type;
		
		/**
		 * Default constructor.
		 */
		
		Graph() 
		{
			super();
		}
		
		/**
		 * Constructor with data
		 * @param data - all data needed to illustrate.
		 */
		
		Graph(GraphData data)
		{
			super();
			this.graphData = data;
		}
		
		/**
		 * paintComponent - function to drawing all.
		 * @param g - object type Graphics.
		 */
		
		public void paintComponent(Graphics g) 
		{
		Graphics2D g2 = (Graphics2D) g;
        double leftX = 80;
        double topY = 50;
        double width = 450;
        double height = 450;
        int ovalRad = 10;
        int count = 5;
        
        boolean isDegree = false;
        if (this.type.equals(TypeOfGraph.AddTotalTime) || this.type.equals(TypeOfGraph.RemoveTotalTime))
        	isDegree = true;
	    Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
	    g2.setColor(Color.BLACK);
	    g2.draw(rect);
	    
	    double kScale = (height - topY) / getMaxDivision(graphData.getMaxY());
	    int tmp = 10;
	    for (int i = 0; i < count; i++)
	    {
	    	drawHorizontalDevision(g2, (int) leftX, (int) topY+76*(count-i), getMaxDivision(graphData.getMaxY())/5*(i+1),isDegree);
	    	drawVerticalDivision(g2, (int)(topY + height), (int) leftX+76*(i+1), tmp);
	    	tmp *= 10;
	    }
	    
	    
	    
	    
	    Font FTitle = new Font("Arial", Font.PLAIN, 14);
		g2.setFont(FTitle);
		g2.setColor(Color.BLACK);
	    g2.drawString(graphData.getMainTitle(), (int) (leftX+width/2), (int) (topY-10));       
	    g2.setColor(Color.BLACK);
	    Font EdX = new Font("Arial", Font.PLAIN, 10);
		g2.setFont(EdX);
		g2.setColor(Color.RED);
		Font FSmallTitle = new Font("Arial", Font.PLAIN, 14);
		g2.setFont(FSmallTitle);
		g2.drawString("ArrayList", (int) (leftX*1.5+width), (int) (topY*4));  
		g2.setColor(Color.BLUE);
		g2.drawString("LinkedList", (int) (leftX*1.5+width), (int) (topY*6));  
		
		g2.setColor(Color.RED);
		for (int i = 0; i < graphData.points.size() / 2; i++)
		{
			g2.fillOval(graphData.points.get(i).x - 5, ((int)((height + topY - 5) - graphData.points.get(i).y * kScale)), ovalRad, ovalRad);
			if (i > 0)
			{
				g2.setStroke(new BasicStroke(2));
				g2.drawLine(graphData.points.get(i-1).x, ((int)((height + topY) - graphData.points.get(i-1).y * kScale)),
						graphData.points.get(i).x, ((int)((height + topY) - graphData.points.get(i).y * kScale)));
			}
		}
		g2.setColor(Color.BLUE);
		for (int i = graphData.points.size() / 2; i < graphData.points.size() ; i++)
		{
			g2.fillOval(graphData.points.get(i).x - 5, ((int)((height + topY - 5) - graphData.points.get(i).y * kScale)), ovalRad, ovalRad);
			if(i > graphData.points.size() / 2)
			g2.drawLine(graphData.points.get(i-1).x, ((int)((height + topY ) - graphData.points.get(i-1).y * kScale)),
					graphData.points.get(i).x, ((int)((height + topY) - graphData.points.get(i).y * kScale)));
		}
		}
		
		/**
		 * getData - function to get specific data for current graphic.
		 * @param type - type of specific data for current graphic
		 */
		
		public void getData(TypeOfGraph type)
		{
	        graphData.getFromFile();
	        this.type = type;
	        switch(type.toString())
	        {
	        case "AddTotalTime":
		        graphData.fillPointsByAddTotalTime(graphData.arrayListTime);
		        graphData.fillPointsByAddTotalTime(graphData.linkedListTime);
		        graphData.setMainTitle("Add Total Time");
	        	break;
	        case "AddMedianTime":
		        graphData.fillPointsByAddMedianTime(graphData.arrayListTime);
		        graphData.fillPointsByAddMedianTime(graphData.linkedListTime);
		        graphData.setMainTitle("Add Median Time");
	        	break;
	        case "RemoveTotalTime":
	        	graphData.fillPointsByRemoveTotalTime(graphData.arrayListTime);
	        	graphData.fillPointsByRemoveTotalTime(graphData.linkedListTime);
	        	graphData.setMainTitle("Remove Total Time");
	        	break;
	        case "RemoveMedianTime":
	        	graphData.fillPointsByRemoveMedianTime(graphData.arrayListTime);
	        	graphData.fillPointsByRemoveMedianTime(graphData.linkedListTime);
	        	graphData.setMainTitle("Remove Median Time");
	        	break;
	        	
	        }
	        
		}
				
		public Dimension getPreferredSize() {
		return new Dimension(W, H);
		}
		
		/**
		 * drawHorizontalDevision - function to draw horizontal devisions on axis.
		 * @param g2 - object type Graphics2D.
		 * @param leftX - margin of left edge.
		 * @param y - y coordinate.
		 * @param value - value need to write near devision.
		 * @param isDegree - boolean variable to show *10^5 or not.
		 */
		
		public void drawHorizontalDevision(Graphics2D g2, int leftX, int y, int value, boolean isDegree)
		{
			g2.drawLine(leftX-5, y, leftX+5, y);
			if (isDegree)
			g2.drawString(String.valueOf(value)+"*10^5", leftX-75, y + 5);
			else
				g2.drawString(String.valueOf(value), leftX-75, y + 5);
				
		}
		
		/**
		 * drawVerticalDivision - function to draw vertical devisions on axis.
		 * @param g2 - object type Graphics2D.
		 * @param downY - margin of top edge.
		 * @param x - x coordinate.
		 * @param value - value need to write near devision.
		 */
		public void drawVerticalDivision(Graphics2D g2, int downY, int x, int value)
		{
			g2.drawLine(x, downY-5, x, downY+5);
			g2.drawString(String.valueOf(value), x, downY+30);
		}
		
		/**
		 * getMaxDivision - function to get max integer devision for current graph.
		 * @param maxY - max value of y.
		 * @return maxY - converted max Y.
		 */
		
		public int getMaxDivision(int maxY)
		{
			if (maxY % 50 == 0)
				return maxY;
			else
				return (maxY / 50 + 1)*50;
		}
		

	}
	
	/**
	 * Class with frame which contains Graph component.
	 * @author gusarov2906
	 *
	 */
	
	static class MainFrame extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int DEF_Width = 670;
		private int DEF_Height = 600;
		public MainFrame(TypeOfGraph type) 
		{

			Graph graph = new Graph();
			this.getContentPane().setBackground(Color.PINK);

			graph.getData(type);
			add(graph);
			
			//this.pack;
			setSize(this.DEF_Width, this.DEF_Height );
		}
	}
}
