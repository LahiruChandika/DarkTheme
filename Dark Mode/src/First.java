import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import eu.hansolo.custom.SteelCheckBox;
import eu.hansolo.custom.SteelCheckBoxUI;
import gui.util.EventSwitchSelected;
import gui.util.SwitchButton;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JSeparator;


public class First {


	private JFrame frame;
	private Second second;
	private ToolBar toolBar;	
	static int x;
	static JProgressBar b;
	private SwitchButton switchbutton;
	private JLabel lblNewLabel_1;
	
	
    public static void changeLaf(JFrame frame, String laf) {
        if (laf.equals("Dark")) {
        	try {
        	    UIManager.setLookAndFeel( new FlatDarkLaf() );
        	} catch( Exception e ) {
        	    System.err.println( "Failed to initialize LaF" );
        	}
        }
        if (laf.equals("Light")) {
        	try {
        	    UIManager.setLookAndFeel( new FlatLightLaf() );
        	} catch( Exception e ) {
        	    System.err.println( "Failed to initialize LaF" );
        	}
        }
        
        SwingUtilities.updateComponentTreeUI(frame);
    }
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException, JsonSyntaxException, JsonIOException, IOException {
		UIManager.setLookAndFeel( new FlatLightLaf() );
		
		First window = new First();
				try {
	        	    UIManager.setLookAndFeel( new FlatLightLaf() );
	        	} catch( Exception e ) {
	        	    System.err.println( "Failed to initialize LaF" );
	        	}
				
				try {
					
					window.frame.setMinimumSize(new Dimension(650,600));
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		window.loop();
	
	}
	
	public void clock(){
		
		Thread clock = new Thread() 
		{
			public void run() 
			{
				try {
					for(;;) {
					Calendar cal = new GregorianCalendar();
					int day= cal.get(Calendar.DAY_OF_MONTH);
					int month= cal.get(Calendar.MONTH);
					int year= cal.get(Calendar.YEAR);
					
					int second= cal.get(Calendar.SECOND);
					int minute= cal.get(Calendar.MINUTE);
					int hour= cal.get(Calendar.HOUR);
					
					lblNewLabel_1.setText("Time "+hour+":"+minute+":"+second+"  Date "+year+"/"+month+"/"+day+" " );
					
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws JsonIOException 
	 * @throws JsonSyntaxException 
	 */
	public First() throws JsonSyntaxException, JsonIOException, IOException {
		
		second = new Second();
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		second.add(separator, BorderLayout.NORTH);
		toolBar = new ToolBar();
		switchbutton =  new SwitchButton();
		
		initialize();	
		clock();
	}

	/*
	 * *Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_1 = new JLabel("Clock");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1);
		
		
		b = new JProgressBar(0,1000);
		b.setPreferredSize(new Dimension(120, 25));
		b.setValue(0);
		b.setForeground(new Color(111, 209, 196));
		b.setStringPainted(true);
		panel.add(b);
		
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frame , "clicked event", "Tittle" ,JOptionPane.CLOSED_OPTION);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Dark mode");
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(switchbutton, BorderLayout.NORTH);
		switchbutton.addEventSelected(new EventSwitchSelected() {
			
			@Override
			public void onSelected(boolean selected) {
				if (selected) {
					changeLaf(frame, "Dark");
				} else {
					changeLaf(frame, "Light");
				}
				
			}
		});
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(second);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(toolBar);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem);
		
		
	}

	
	public static ImageIcon getSQIcon(String icon, int w, int h) {
		Image image = new ImageIcon(First.class.getResource(icon))
		.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(image);
	}
	
	
	public void loop()
	  {
	    int i=0; 
	    while(i <= 1000)
	    {
	      // fills the bar
	      b.setValue(i);  
	      i = i + 20;  
	      try
	      {
	        // delay the thread 
	        Thread.sleep(120);
	      }
	      catch(Exception e){}
	    }
	  }
		
}
