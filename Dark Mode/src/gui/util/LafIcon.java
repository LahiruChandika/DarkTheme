package gui.util;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class LafIcon implements Icon {
    private Map<String, Icon> lafIcons;

    public LafIcon ()
    {
        super ();
        lafIcons = new HashMap<String, Icon> ();
    }

    public void addIcon ( String laf, Icon icon )
    {
        lafIcons.put ( laf, icon );
    }

    private String getLaf ()
    {
        return UIManager.getLookAndFeel ().getClass ().getCanonicalName ();
    }

    private Icon getCurrentIcon ()
    {
        return lafIcons.get ( getLaf () );
    }

    public void paintIcon ( Component c, Graphics g, int x, int y )
    {
        Icon icon = getCurrentIcon ();
        if ( icon != null )
        {
            icon.paintIcon ( c, g, x, y );
        }
    }
//
    public int getIconWidth ()
    {
        Icon icon = getCurrentIcon ();
        return icon != null ? icon.getIconWidth () : 0;
    }

    public int getIconHeight ()
    {
        Icon icon = getCurrentIcon ();
        return icon != null ? icon.getIconHeight () : 0;
    }

    public static void main ( String[] args ) throws IOException
    {
        installMetalLookAndFeel ();

        JFrame frame = new JFrame ();
        frame.setLayout ( new FlowLayout ( FlowLayout.CENTER, 5, 5 ) );

        frame.add ( new JButton ( "Test button", createIcon() ) );

        String[] laf = { "Metal Look and Feel", "Nimbus Look and Feel" };
        final JComboBox lafType = new JComboBox ( laf );
        lafType.addActionListener ( new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                if ( lafType.getSelectedIndex () == 0 )
                {
                    installMetalLookAndFeel ();
                }
                else
                {
                    installNimbusLookAndFeel ();
                }
            }
        } );
        frame.add ( lafType );

        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.pack ();
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }

//    private static LafIcon createIcon () throws IOException
//    {
//        LafIcon icon = new LafIcon ();    
//        try
//        {
//            icon.addIcon ( MetalLookAndFeel.class.getCanonicalName (),
//            		new ImageIcon(ImageIO.read(new File("Images/outline_person_black_24dp.png"))));
////            InputStream stream = getClass().getResourceAsStream("/resources/icons/xyz.png");
////            new ImageIcon(ImageIO.read(new File("Images/outline_person_black_24dp.png")));
//            icon.addIcon ( NimbusLookAndFeel.class.getCanonicalName (),
//            		new ImageIcon(ImageIO.read(new File("Images/outline_dashboard_black_24dp.png")) ) );
//        }
//        catch ( MalformedURLException e )
//        {
//            e.printStackTrace ();
//        }    
//        return icon;
//    }
    
    private static LafIcon createIcon () throws IOException
    {
        LafIcon icon = new LafIcon ();    
        try
        {
            icon.addIcon ( MetalLookAndFeel.class.getCanonicalName (),
            		new ImageIcon(ImageIO.read(new File("Images/outline_person_black_24dp.png"))));
            
            icon.addIcon ( NimbusLookAndFeel.class.getCanonicalName (),
            		new ImageIcon(ImageIO.read(new File("Images/outline_dashboard_black_24dp.png")) ) );
        }
        catch ( MalformedURLException e )
        {
            e.printStackTrace ();
        }    
        return icon;
    }

    private static void installMetalLookAndFeel ()
    {
        installLookAndFeel ( MetalLookAndFeel.class.getCanonicalName () );
    }

    private static void installNimbusLookAndFeel ()
    {
        installLookAndFeel ( NimbusLookAndFeel.class.getCanonicalName () );
    }

    private static void installLookAndFeel ( String name )
    {
        try
        {
            UIManager.setLookAndFeel ( name );

            Window[] windows = Window.getWindows ();
            if ( windows.length > 0 )
            {
                for ( Window window : windows )
                {
                    SwingUtilities.updateComponentTreeUI ( window );
                    window.pack ();
                }
            }
        }
        catch ( ClassNotFoundException e )
        {
            e.printStackTrace ();
        }
        catch ( InstantiationException e )
        {
            e.printStackTrace ();
        }
        catch ( IllegalAccessException e )
        {
            e.printStackTrace ();
        }
        catch ( UnsupportedLookAndFeelException e )
        {
            e.printStackTrace ();
        }
    }

	
}