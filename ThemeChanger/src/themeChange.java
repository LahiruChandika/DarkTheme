import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import gui.utill.EventSwitchSelected;
import gui.utill.SwitchButton;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class themeChange {

	private JFrame frame;
	private SwitchButton switchbutton;

	public static void changeLaf(final JFrame frame, final String laf) {
        if (laf.equals("Dark")) {
            try {
                UIManager.setLookAndFeel((LookAndFeel)new FlatDarkLaf());
            }
            catch (Exception e) {
                System.err.println("Failed to initialize LaF");
            }
        }
        if (laf.equals("Light")) {
            try {
                UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
            }
            catch (Exception e) {
                System.err.println("Failed to initialize LaF");
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themeChange window = new themeChange();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public themeChange() {
		switchbutton = new SwitchButton();
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//add switch button component to panel
		panel.add((Component)this.switchbutton, "North");
		
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
	}

}
