import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Graph() {
			
		JPanel chartPanel = createChartPanel();
		chartPanel.setMinimumSize(new Dimension(200, 200));
        add(chartPanel, BorderLayout.CENTER);	
	}
	
	private JPanel createChartPanel() {
	    String chartTitle = "Employee Achivement level";
	    String categoryAxisLabel = "Time(Weeks)";
	    String valueAxisLabel = "Level (*1000) ";
	 
	    CategoryDataset dataset = createDataset();
	 
	    JFreeChart chart = ChartFactory.createLineChart(chartTitle,
	            categoryAxisLabel, valueAxisLabel, dataset);
	 
	    return new ChartPanel(chart);
	}
	
	private CategoryDataset createDataset() {
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//	    String series1 = "Target";
//	    String series2 = "Completed level";
 
//	    dataset.addValue(10.000, series1, "1");
//	    dataset.addValue(10.000, series1, "2");
//	    dataset.addValue(10.000, series1, "3");
//	    dataset.addValue(10.000, series1, "4");
//	 
//	    dataset.addValue(8.000, series2, "1");
//	    dataset.addValue(7.000, series2, "2");
//	    dataset.addValue(8.500, series2, "3");
//	    dataset.addValue(8.000, series2, "4");
//	    
	    
	    for (int i = 0; i < 4; i++) {
	    	double tmpVal = Math.random()*1000;
			for (int j = 0; j < 22; j++) {
				double val = (i==0)? tmpVal:Math.random()*1000;
				
				dataset.addValue(val, i+" user", j+" day");	
			}
		}
	      
	    return dataset;
	}
}
