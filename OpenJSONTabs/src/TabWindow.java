import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Font;

public class TabWindow {

	private JFrame frame;
	public static JSONObject objects;
 
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabWindow window = new TabWindow();
					window.frame.setMinimumSize(new Dimension(650, 600));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabWindow() throws IOException, ParseException {
		initialize();
	}

	private void initialize()throws IOException, org.json.simple.parser.ParseException {
		
		JSONParser jsonP = new JSONParser(); 
		//Read JSON
		FileReader reader = new FileReader("resource/tabs.json");
		Object obj = jsonP.parse(reader);
		//Create JSON object
		JSONObject tabsList = (JSONObject)obj; 
		System.out.println(tabsList);
		//Create JSON array
		JSONArray emplist = (JSONArray) tabsList.get("employees");
		System.out.println(emplist);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);;
		
		//add Tab panel
		for (int i = 0; i < emplist.size(); i++) {
			objects = (JSONObject) emplist.get(i); //Access JSON object inside the JSON array
			
			String tTitle = (String) objects.get("TabTitle");
	
			TabPanel tabPanel = new TabPanel(objects);
			JPanel pnl = new JPanel();	
			
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnl.setLayout(gbl_panel);
			pnl.add(tabPanel);
			tabbedPane.addTab(tTitle, null, pnl , null);
		
		}			
	}
}
