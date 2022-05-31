import javax.swing.JPanel;

import org.json.simple.JSONObject;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TabPanel extends JPanel {

	public TabPanel(JSONObject objTab) {

		String tTitle = (String) objTab.get("TabTitle");
		String email = (String) objTab.get("email");
		int age = Integer.parseInt(objTab.get("age").toString());
		
		System.out.println(tTitle);
		System.out.println(email);
		System.out.println(age);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		JLabel JsonName = new JLabel(tTitle);
		JsonName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_JsonName = new GridBagConstraints();
		gbc_JsonName.insets = new Insets(0, 0, 5, 0);
		gbc_JsonName.gridx = 3;
		gbc_JsonName.gridy = 1;
		add(JsonName, gbc_JsonName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);
		
		JLabel JsonEmail = new JLabel(email);
		JsonEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_JsonEmail = new GridBagConstraints();
		gbc_JsonEmail.insets = new Insets(0, 0, 5, 0);
		gbc_JsonEmail.gridx = 3;
		gbc_JsonEmail.gridy = 3;
		add(JsonEmail, gbc_JsonEmail);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 0, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 5;
		add(lblAge, gbc_lblAge);
		
		JLabel JsonAge = new JLabel();
		JsonAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JsonAge.setText(String.valueOf(age)); //Add integer variable to JLabel
		GridBagConstraints gbc_JsonAge = new GridBagConstraints();
		gbc_JsonAge.gridx = 3;
		gbc_JsonAge.gridy = 5;
		add(JsonAge, gbc_JsonAge);


	}

}
