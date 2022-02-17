import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ToolBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolBar() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		add(toolBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setIconTextGap(2);
		lblNewLabel.setIcon(First.getSQIcon("/outline_person_black_24dp.png",45,45));
		toolBar.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(First.getSQIcon("/outline_dashboard_black_24dp.png",45,45));
		toolBar.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(First.getSQIcon("/outline_email_black_24dp.png",45,45));
		toolBar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(First.getSQIcon("/outline_calendar_today_black_24dp.png", 45,45));
		toolBar.add(lblNewLabel_3);

	}

}
