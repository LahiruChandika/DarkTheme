import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Second extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	

	
	public Second() {
		
		setLayout(new BorderLayout(0, 0));
		
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(120, 0));
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMinimumSize(new Dimension(120, 29));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"java ", "c++", "python", "php"}));
		panel.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setMinimumSize(new Dimension(0, 0));
		spinner.setModel(new SpinnerDateModel(new Date(1644777000000L), null, null, Calendar.DAY_OF_YEAR));
		panel.add(spinner);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMinimumSize(new Dimension(175, 5));
		panel_1.add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("File", null, tabbedPane_1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("", null, scrollPane, null);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("colors");
						node_2 = new DefaultMutableTreeNode("blue");
							node_2.add(new DefaultMutableTreeNode("light blue"));
							node_2.add(new DefaultMutableTreeNode("dark blue"));
						node_1.add(node_2);
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode(" food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(tree);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Graph", null, tabbedPane_2, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_2.addTab("", null, scrollPane_1, null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ui\\1_vgddUDH0yDIbUELtbEXV4g.png"));
		scrollPane_1.setViewportView(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Application", null, panel_2, null);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save");
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("JSON", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2, BorderLayout.CENTER);

	}

}
