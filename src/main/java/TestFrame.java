import java.awt.*;
import javax.swing.*;

class TestFrame extends JFrame {

    public TestFrame() {
        setTitle( "BoxLayout Application" );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create panels to display X- and Y-axis box layouts
        JPanel yAxisPanel = createYAxisPanel();
        topPanel.add( yAxisPanel, BorderLayout.CENTER );

        JPanel xAxisPanel = createXAxisPanel();
        topPanel.add( xAxisPanel, BorderLayout.SOUTH );
    }

    public JPanel createYAxisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        panel.setBackground( Color.blue );

        addComponentsToPanel(panel);
        return panel;
    }

    public JPanel createXAxisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new BoxLayout( panel, BoxLayout.X_AXIS ) );
        panel.setBackground( Color.green );

        addComponentsToPanel(panel);
        return panel;
    }

    private void addComponentsToPanel(JPanel panel) {
        panel.add( new JButton( "Button 1" ) );
        panel.add( new TextArea( "This is a text area" ) );
        panel.add( new JCheckBox( "Checkbox 1" ) );
    }

    public static void main( String args[] ) {
        TestFrame mainFrame = new TestFrame();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}