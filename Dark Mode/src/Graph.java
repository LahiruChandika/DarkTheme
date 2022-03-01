import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


public class Graph extends JPanel {
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws JsonIOException 
	 * @throws JsonSyntaxException 
	 */
	public Graph() throws JsonSyntaxException, JsonIOException, IOException {
			
		JPanel chartPanel = createChartPanel();
		chartPanel.setMinimumSize(new Dimension(200, 200));
        add(chartPanel, BorderLayout.CENTER);	

	}
	
	private JPanel createChartPanel() throws JsonSyntaxException, JsonIOException, IOException {
	    String chartTitle = "Employee Achivement level";
	    String categoryAxisLabel = "Time(Weeks)";
	    String valueAxisLabel = "Level (*1000) ";
	 
	    CategoryDataset dataset = createDataset();
	 
	    JFreeChart chart = ChartFactory.createLineChart(chartTitle,
	            categoryAxisLabel, valueAxisLabel, dataset);
	 
	    return new ChartPanel(chart);
	}
	
	private CategoryDataset createDataset() throws JsonSyntaxException, JsonIOException, IOException {
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    
	    for (int i = 0; i < 4; i++) {
	    	double tmpVal = Math.random()*1000;
			for (int j = 0; j < 22; j++) {
				double val = (i==0)? tmpVal:Math.random()*1000;
				
				dataset.addValue(val, i+" user", j+1+" day");	
			}
		}
	    
//	    System.out.println(getDatasetByJSON());
	      
	    return dataset;
	}
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static ArrayList getDatasetByJSON() throws JsonSyntaxException, JsonIOException, IOException {
//		ArrayList<HashMap<String, ArrayList<Point>>> sets = new ArrayList<>();
//		
//		sets = new Gson().fromJson(Files.newBufferedReader(Paths.get("lib/graph.json")),
//				new TypeToken<ArrayList<HashMap<String, ArrayList<Point>>>>() {}.getType());
//		Reader read = Files.newBufferedReader(Paths.get("lib/graph.json"));
//		
//		Object x = new Gson().fromJson(reader,).toString(),String.class);
//		System.out.println(read.toString());
//		read.close();
//		
//		ObjectMapper mapper = new ObjectMapper();
//		InputStream is = Test1.class.getResourceAsStream("/test.json");
//		Test1 testObj = mapper.readValue(is, Test1.class);
//		
//		System.out.println(testObj.toString());
//		
//		return sets;			
//	}
	
}

