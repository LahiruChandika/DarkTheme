import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.dispatcher.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import gui.util.EventSwitchSelected;
import gui.util.SwitchButton;


public class First extends JFrame implements ActionListener, ItemListener,
NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Second second;
	private ToolBar toolBar;	
	static int x;
	static JProgressBar p;
	private SwitchButton switchbutton;
	private JLabel lblNewLabel_1;
	private int i = 100;
	int a = 100;
	
    private static final Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
	
	
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
		
		window.progrs();
	
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
					
					lblNewLabel_1.setText("Date "+year+"/"+month+"/"+day+" "+"  Time "+hour+":"+minute+":"+second);
					
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
	

	public First() throws JsonSyntaxException, JsonIOException, IOException {
		
		second = new Second();
		
        log.setUseParentHandlers(false);
        log.setLevel(Level.OFF);

        // Setup a generic ConsoleHandler
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        log.addHandler(handler);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		second.add(separator, BorderLayout.NORTH);
		toolBar = new ToolBar();
		switchbutton =  new SwitchButton();
		
		initialize();	
		clock();
	}


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
		
		
		p = new JProgressBar(0,100);
		p.setPreferredSize(new Dimension(120, 25));
		p.setValue(0);
		p.setForeground(new Color(0, 174, 255));
		p.setStringPainted(true);
		panel.add(p);
		
		
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
		

	GlobalScreen.setEventDispatcher(new SwingDispatchService());
         try {
				GlobalScreen.registerNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     GlobalScreen.addNativeKeyListener(this);
     GlobalScreen.addNativeMouseListener(this);
     GlobalScreen.addNativeMouseMotionListener(this);
     GlobalScreen.addNativeMouseWheelListener(this);
     setVisible(true);
		
	}

	
	public static ImageIcon getSQIcon(String icon, int w, int h) {
		Image image = new ImageIcon(First.class.getResource(icon))
		.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(image);
	}
	
	
	public void progrs() {
		
		while(i>=0) {
			p.setValue(i);
			i -=1;
			try {
				Thread.sleep(100);
			} catch (Exception e2) {
			}
		if (i == 0) {
			JOptionPane.showMessageDialog(frame , "Not active.", "Error" ,JOptionPane.YES_NO_OPTION );
			p.setValue(a);
			i=100;
			}
		}
	}
		
	public void itemStateChanged(ItemEvent e) {
 
	    }

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		 p.setValue(a);
	     i=100;
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void windowOpened(WindowEvent e) {
    
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException ex) {
            ex.printStackTrace();
        }

        System.runFinalization();
        System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseWheelMoved(NativeMouseWheelEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
        p.setValue(a);
        i=100;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}