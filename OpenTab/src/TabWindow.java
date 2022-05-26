import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TabWindow {

	private JFrame frame;
	public static Vector<JSONObject> tabs = new Vector<JSONObject>();

	public static void main(String[] args) {
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
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//create array to JPanel
		JPanel panel [] = new JPanel[emplist.size()];
		for (int i = 0; i < emplist.size(); i++) {
			JSONObject objects = (JSONObject) emplist.get(i); //Access JSON object inside the JSON array
			
			String tTitle = (String) objects.get("TabTitle");
			String email = (String) objects.get("email");
			long age = (long) objects.get("age");
			int agei =(int)age;
			System.out.println(tTitle);
			System.out.println(email);
			System.out.println(agei);
			
			panel[i] = new JPanel();
			tabbedPane.addTab(tTitle, null, panel[i], null);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel[i].setLayout(gbl_panel);
			
			JLabel lblName = new JLabel("Name :");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			panel[i].add(lblName, gbc_lblName);
			
			JLabel JsonName = new JLabel(tTitle);
			GridBagConstraints gbc_JsonName = new GridBagConstraints();
			gbc_JsonName.insets = new Insets(0, 0, 5, 0);
			gbc_JsonName.gridx = 3;
			gbc_JsonName.gridy = 1;
			panel[i].add(JsonName, gbc_JsonName);
			
			JLabel lblEmail = new JLabel("Email :");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 3;
			panel[i].add(lblEmail, gbc_lblEmail);
			
			JLabel JsonEmail = new JLabel(email);
			GridBagConstraints gbc_JsonEmail = new GridBagConstraints();
			gbc_JsonEmail.insets = new Insets(0, 0, 5, 0);
			gbc_JsonEmail.gridx = 3;
			gbc_JsonEmail.gridy = 3;
			panel[i].add(JsonEmail, gbc_JsonEmail);
			
			JLabel lblAge = new JLabel("Age :");
			GridBagConstraints gbc_lblAge = new GridBagConstraints();
			gbc_lblAge.insets = new Insets(0, 0, 0, 5);
			gbc_lblAge.gridx = 1;
			gbc_lblAge.gridy = 5;
			panel[i].add(lblAge, gbc_lblAge);
			
			JLabel JsonAge = new JLabel();
			JsonAge.setText(String.valueOf(agei)); //Add integer variable to JLabel
			GridBagConstraints gbc_JsonAge = new GridBagConstraints();
			gbc_JsonAge.gridx = 3;
			gbc_JsonAge.gridy = 5;
			panel[i].add(JsonAge, gbc_JsonAge);
		}			
	}
}
