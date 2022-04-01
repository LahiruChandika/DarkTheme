package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class First {

	private JFrame frame;
	private test.SwitchButton switchButton;
	private final Action action = new SwingAction();


	public static void changeLaf(JFrame frame, String laf) {
        if (laf.equals("dark")) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }
        if (laf.equals("light")) {
            try {
                UIManager
                        .setLookAndFeel(new FlatLightLaf());
            } catch ( UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 try {
		                UIManager.setLookAndFeel(new FlatLightLaf());
		            } catch (Exception e) {
		                System.out.println(e);
		            }
				try {
					First window = new First();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public First() {
		initialize();
	}


	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		switchButton = new test.SwitchButton();
		panel.add(switchButton);
		switchButton.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if (selected) {
                	changeLaf(frame, "dark");
                } else {
                	changeLaf(frame, "light");
                }
            }
        });
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
