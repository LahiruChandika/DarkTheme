import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.dispatcher.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class keyListners implements ActionListener, ItemListener, NativeKeyListener, 
NativeMouseInputListener, NativeMouseWheelListener, WindowListener{

	private JFrame frame;
	static JProgressBar p;
	private JLabel lblTime;
	static int x;
    private int i;
    int a;
    static Timer timer;
    static TimerTask task;
    static Thread one;
    int count;
    public static int sec = 0;
    public static int mins = 0;
    public static int hour = 0;
    static int oSec;
    static int oMins;
    static int oHour;
    static boolean on=true;

	public static void main(String[] args) {
		final keyListners window = new keyListners();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		window.progrs();	
	}

	public keyListners() {
		i = 100;
        a = 100;
        count = 0;
		initialize();
		time();
		idle();
	}
	
	public void idle() {
    	one= new Thread() {
    		public void run() {
    			while(on ==true){
    				oSec = (int)keyListners.sec;
    				oMins = (int)keyListners.mins;
    				oHour = (int)keyListners.hour;
//    				final Object[] parms = { oHour, oMins, oSec }; 
    				try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}   
    	};
    	one.start();
    } 

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		//Display time
		(lblTime = new JLabel("Clock")).setFont(new Font("Tahoma", 1, 14));
        panel.add(this.lblTime);
        
        //Disable info massages in JNativeHook
        // Clear previous logging configurations.
        LogManager.getLogManager().reset();
        // Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
		
        //progress bar
		(p = new JProgressBar(0, 100)).setPreferredSize(new Dimension(120, 25));
		p.setPreferredSize(new Dimension(160, 14));
        p.setValue(0);
        p.setForeground(new Color(0, 174, 255));
        p.setStringPainted(true);
        panel.add(p);
        JButton btnNewButton = new JButton("Click");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "clicked event", "Tittle", -1);

            }
        });
        
        //key listeners
        GlobalScreen.setEventDispatcher((ExecutorService)new SwingDispatchService());
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException e1) {
            e1.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener((NativeKeyListener)this);
        GlobalScreen.addNativeMouseListener((NativeMouseListener)this);
        GlobalScreen.addNativeMouseMotionListener((NativeMouseMotionListener)this);
        GlobalScreen.addNativeMouseWheelListener((NativeMouseWheelListener)this);
	}
	
	//progress bar function
	@SuppressWarnings("deprecation")
	public void progrs() {
        while (i >= 0) {
            p.setValue(i);
            --i;
            try {
                Thread.sleep(100L);
            }
            catch (Exception ex) {}
            if (i == 0) {
            	pause();
                JOptionPane.showMessageDialog(frame, "Not active.", "Error", 0);
                time();
                p.setValue(a);
                i = 100;
                one.stop();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    
    public void nativeMouseClicked(NativeMouseEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeMousePressed(NativeMouseEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeMouseReleased( NativeMouseEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeMouseDragged(NativeMouseEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeMouseMoved(NativeMouseEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void windowOpened(WindowEvent e) {
    }
    
    public void windowClosing( WindowEvent e) {
    }
    
    public void windowClosed( WindowEvent e) {
        try {
            GlobalScreen.unregisterNativeHook();
        }
        catch (NativeHookException ex) {
            ex.printStackTrace();
        }
        System.runFinalization();
        System.exit(0);
    }
    
    public void windowIconified(WindowEvent e) {
    }
    
    public void windowDeiconified(WindowEvent e) {
    }
    
    public void windowActivated(WindowEvent e) {
    }
    
    public void windowDeactivated(WindowEvent e) {
    }
    
    public void nativeMouseWheelMoved(NativeMouseWheelEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeKeyPressed( NativeKeyEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeKeyReleased( NativeKeyEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    public void nativeKeyTyped(NativeKeyEvent arg0) {
        p.setValue(a);
        i = 100;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    //time function
    public void time() {
    	timer = new Timer();
    	task = new TimerTask(){
            public void run(){
            	if (sec == 59){
            		sec = 0;
            		mins ++;
            		if(mins ==59) {
            			mins = 0;
            			hour++;
            		}
            	}
            	else {
            	sec ++;	
            	lblTime.setText("Hours : "+hour+" Mins : "+mins+" Sec : "+ sec); //set time to label
            	}
            }
        };
        timer.schedule(task, 0, 1000);	 	
    }
    
    public void pause() {
       timer.cancel();
    }
    
    public void resume() {
        timer.schedule( task, 0, 1000 );
    }

}
