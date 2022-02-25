import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.kitfox.svg.app.beans.SVGIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ToolBar extends JPanel {


	/**
	 * Create the panel.
	 */
	public ToolBar() {
		setLayout(new GridLayout(1, 0, 0, 0));
		

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		add(toolBar);
//		
//		Icon icon = IconFontSwing.buildIcon(FontAwesome.USER, 45, new Color(0, 0, 0));
//        JLabel label = new JLabel(icon);
//        
//        Icon icon1 = IconFontSwing.buildIcon(FontAwesome.CALENDAR, 45, new Color(0, 0, 0));
//        JLabel label1 = new JLabel(icon1);
//        
//        Icon icon2 = IconFontSwing.buildIcon(FontAwesome.FOLDER, 45, new Color(0, 0, 0));
//        JLabel label2 = new JLabel(icon2);
//        
//        Icon icon3 = IconFontSwing.buildIcon(FontAwesome.PAPER_PLANE, 45, new Color(0, 0, 0));
//        JLabel label3 = new JLabel(icon3);
//        
//        
//        toolBar.add(label);
//        toolBar.add(label1);
//        toolBar.add(label2);
//        toolBar.add(label3);
		
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
