import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import java.awt.event.ActionListener;
import java.awt.image.ColorConvertOp;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.kitfox.svg.app.beans.SVGIcon;
import com.orsoncharts.Colors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ToolBar extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Action label = null;

	/**
	 * Create the panel.
	 * @return 
	 */
	
	
	public ToolBar() {
		
		HashMap<String, Object> Colours = new HashMap<>();
		Colours.put("Dark",Color.BLACK);
		Colours.put("Light",Color.WHITE);
		
		setLayout(new GridLayout(1, 0, 0, 0));	

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		add(toolBar);
		IconFontSwing.register(FontAwesome.getIconFont());
		
		Icon icon = IconFontSwing.buildIcon(FontAwesome.USER, 55, new Color(150,150,150));
        JLabel label = new JLabel(icon);
        
        Icon icon1 = IconFontSwing.buildIcon(FontAwesome.CALENDAR, 45, new Color(150, 150, 150));
        JLabel label1 = new JLabel(icon1);
        
        Icon icon2 = IconFontSwing.buildIcon(FontAwesome.FOLDER, 45, new Color(150, 150, 150));
        JLabel label2 = new JLabel(icon2);
        
        Icon icon3 = IconFontSwing.buildIcon(FontAwesome.PAPER_PLANE, 45, new Color(150, 150, 150));
        JLabel label3 = new JLabel(icon3);
        
        toolBar.add(label);        
        toolBar.add(label2);
        toolBar.add(label3);
        toolBar.add(label1);
				
	}
	
}
