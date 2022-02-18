import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;


public class First {


	private JFrame frame;
	private Second second;
	private ToolBar toolBar;	
	
	static JProgressBar b;
	
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
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	        	    UIManager.setLookAndFeel( new FlatLightLaf() );
	        	} catch( Exception e ) {
	        	    System.err.println( "Failed to initialize LaF" );
	        	}
				
				try {
					First window = new First();
					window.frame.setMinimumSize(new Dimension(650,600));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First() {
		
		second = new Second();
		toolBar = new ToolBar();
		
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu bar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		JProgressBar progressBar = new JProgressBar();
		b = new JProgressBar();
		b.setValue(0);
		b.setForeground(Color.BLUE);
		b.setStringPainted(true);
		panel.add(b);
		
		fill();
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Change theme");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnNewToggleButton.isSelected()){
					changeLaf(frame, "Dark");
				}else {
					changeLaf(frame, "Light");
				}
			}
		});
		panel.add(tglbtnNewToggleButton);

		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frame , "clicked event", "Tittle" ,JOptionPane.CLOSED_OPTION);
			}
		});
		panel.add(btnNewButton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Main", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	
	public static void fill()
	{
		int i = 0;
        try {
            while (i <= 100) {
                
                if (i > 30 && i < 70)
                    b.setString("wait for sometime");
                else if (i > 70)
                    b.setString("almost finished loading");
                else
                    b.setString("loading started");
 
                b.setValue(i + 10);
 
                Thread.sleep(500);
                i += 20;
            }
        }
        catch (Exception e) {
        }
	}
		
}
