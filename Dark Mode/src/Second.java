import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
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
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.tree.DefaultTreeModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

//import DefaultMutableTreeNodeDeserializer.POJO;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.GridLayout;

public class Second extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField_1;
	
	static JProgressBar b;
	
	private Graph graph;

	String json;
	DefaultMutableTreeNode x;
	private Gson gson = new GsonBuilder()
    		.registerTypeAdapter(DefaultMutableTreeNode.class, new DefaultMutableTreeNodeSerializer())
            .registerTypeAdapter(DefaultMutableTreeNode.class, new DefaultMutableTreeNodeDeserializer())
            .setPrettyPrinting()
            .create();

	public Second() throws JsonSyntaxException, JsonIOException, IOException {
		
		graph = new Graph();

		try {

		    Reader reader = Files.newBufferedReader(Paths.get("lib/sample2.json"));

		    x = this.gson.fromJson(reader, DefaultMutableTreeNode.class);   
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(120, 0));
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(graph);
		graph.setLayout(new GridLayout(1, 0, 0, 0));
		
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
		

		JTree tree = new JTree();  // create a sample tree
		Object topNode = tree.getModel().getRoot();  // a DefaultMutableTreeNode
		
		tree.setModel(new DefaultTreeModel(x));
		
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
		tabbedPane.addTab("New", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2, BorderLayout.CENTER);

	}

}

class DefaultMutableTreeNodeSerializer implements JsonSerializer<DefaultMutableTreeNode> {

    @Override
    public JsonElement serialize(DefaultMutableTreeNode src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("allowsChildren", src.getAllowsChildren());
        jsonObject.add("userObject", context.serialize(src.getUserObject()));
        if (src.getChildCount() > 0) {
            jsonObject.add("children", context.serialize(Collections.list(src.children())));
        }
        return jsonObject;
    }

}


