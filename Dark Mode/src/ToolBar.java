import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;


class themeIcon {
	int r,g,bl;
	public void changeIcon(String theme) {
		if(theme.equals("Dark")){
			r = 150;
			g = 150;
			bl = 150;
		}if(theme.equals("Light")){
			r = 150;
			g = 150;
			bl = 150;
		}
	};	 
}

public class ToolBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 * @return 
	 */
	
	public ToolBar() {
		themeIcon obj = new themeIcon();
		
//		HashMap<String, Object> Colours = new HashMap<>();
//		Colours.put("Dark",Color.BLACK);
//		Colours.put("Light",Color.WHITE);
		
		setLayout(new GridLayout(1, 0, 0, 0));	

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		add(toolBar);
		IconFontSwing.register(FontAwesome.getIconFont());

		Icon icon = IconFontSwing.buildIcon(FontAwesome.USER, 55, new Color(obj.r,obj.g,obj.bl));
        JLabel label = new JLabel(icon);	
        
        Icon icon1 = IconFontSwing.buildIcon(FontAwesome.CALENDAR, 45, new Color(obj.r,obj.g,obj.bl));
        JLabel label1 = new JLabel(icon1);
        
        Icon icon2 = IconFontSwing.buildIcon(FontAwesome.FOLDER, 45, new Color(obj.r,obj.g,obj.bl));
        JLabel label2 = new JLabel(icon2);
        
        Icon icon3 = IconFontSwing.buildIcon(FontAwesome.PAPER_PLANE, 45, new Color(obj.r,obj.g,obj.bl));
        JLabel label3 = new JLabel(icon3);
        
        toolBar.add(label);        
        toolBar.add(label2);
        toolBar.add(label3);
        toolBar.add(label1);
				
	}	
}
