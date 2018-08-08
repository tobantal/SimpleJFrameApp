import java.awt.*;
import javax.swing.*;

class TestFrame extends JFrame {

    private JScrollPane scrollPane;
    private JPanel topPanel;
    private JLabel label;

    public TestFrame() {
        setup();
        addImage("/Users/anton_tobolkin/IdeaProjects/SimpleJFrameApp/src/main/java/image.gif");
        createScrollPane();
    }

    void setup() {
        setTitle( "Tabbed Pane Application" );
        setSize( 300, 200 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
    }

    void addImage(String file) {
        Icon image = new ImageIcon( file );
        label = new JLabel( image );
    }

    void createScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add( label );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }

    public static void main( String args[] ) {
        TestFrame mainFrame = new TestFrame();
        mainFrame.setVisible( true );
    }
}