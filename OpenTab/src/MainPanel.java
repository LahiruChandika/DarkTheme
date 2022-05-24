import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.awt.Font;

public class MainPanel {

	private static final String String = null;
	private JFrame frame;
	public static JTabbedPane tabbedPane;
	public static JPanel panel;
	
	public static String tTitle;
	public static String name;
	public static String age;
	
	public static int x=3;

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
//					Tab t=new Tab();
					window.frame.setMinimumSize(new Dimension(650, 600));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPanel() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		
		JSONParser jsonP = new JSONParser();
		try(FileReader reader = new FileReader("lib/tab.json")){
			   //Read JSON File
			   Object obj = jsonP.parse(reader);
			   JSONArray tabList = (JSONArray) obj;
//			   System.out.println(tabList);
			   //Iterate over tab array
			   tabList.forEach(tab -> parseTabObj((JSONObject)tab));
			  }
			  catch (FileNotFoundException e) {
			            e.printStackTrace();
			        } catch (IOException e) {
			            e.printStackTrace();
			        } catch (ParseException e) {
			            e.printStackTrace();
			        }
		
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		

		JPanel panel[]= new JPanel[x];
		for (int i = 0; i < panel.length; i++) {
			
			panel[i] = new JPanel();
			tabbedPane.addTab(tTitle, null, panel[i], null);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel[i].setLayout(gbl_panel);
		
		
			JLabel lbl_tabTitle = new JLabel(tTitle);
			lbl_tabTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
			GridBagConstraints gbc_lbl_tabTitle = new GridBagConstraints();
			gbc_lbl_tabTitle.gridwidth = 3;
			gbc_lbl_tabTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lbl_tabTitle.gridx = 1;
			gbc_lbl_tabTitle.gridy = 1;
			panel[i].add(lbl_tabTitle, gbc_lbl_tabTitle);
			
			JLabel Name = new JLabel("Name :");
			Name.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_Name = new GridBagConstraints();
			gbc_Name.insets = new Insets(0, 0, 5, 5);
			gbc_Name.gridx = 3;
			gbc_Name.gridy = 4;
			panel[i].add(Name, gbc_Name);
		
			JLabel lblName = new JLabel(name);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 0);
			gbc_lblName.gridx = 5;
			gbc_lblName.gridy = 4;
			panel[i].add(lblName, gbc_lblName);
		
			JLabel Age = new JLabel("Age :");
			Age.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_Age = new GridBagConstraints();
			gbc_Age.fill = GridBagConstraints.HORIZONTAL;
			gbc_Age.insets = new Insets(0, 0, 0, 5);
			gbc_Age.gridx = 3;
			gbc_Age.gridy = 6;
			panel[i].add(Age, gbc_Age);
		
			JLabel lblAge = new JLabel(age);
			lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblAge = new GridBagConstraints();
			gbc_lblAge.gridx = 5;
			gbc_lblAge.gridy = 6;
			panel[i].add(lblAge, gbc_lblAge);
		
		}
		
		
	}
	
	 private static JSONObject parseTabObj(JSONObject tab) {
		  JSONObject tabObj = (JSONObject) tab.get("tabs");
		  //get tab TabTitle, Name, Age
		  tTitle = (String) tabObj.get("TabTitle");
		  name = (String) tabObj.get("Name");
		  age = (String) tabObj.get("Age");
		  System.out.println("Tab Title: " + tTitle);
		  System.out.println("Name: " + name);
		  System.out.println("Age: " + age);
		
		  return tabObj;
		  
	}

}
