import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class TestFrame extends JFrame implements ChangeListener {

    private JSplitPane splitPaneV;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;

    public TestFrame() {
        setTitle( "Advanced Scoller Application" );
        setSize( 300, 200 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create a text area for the top pane
        createTopPane();

        // Load a graphics for the bottom pane
        createBottomPane();

        // Create a split pane
        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        topPanel.add( splitPaneV, BorderLayout.CENTER );

        // Add the components to the splitter pane
        splitPaneV.setLeftComponent( scrollPane1 );
        splitPaneV.setRightComponent( scrollPane2 );
    }

    public void stateChanged( ChangeEvent event ) {
        // Event in the top pane??
        if( event.getSource() == scrollPane1.getViewport() ) {

            // Get the current viewport position for the top pane
            Point point = scrollPane1.getViewport().getViewPosition();

            // Determine the correct scaling for the views
            Dimension dim1 = scrollPane1.getViewport().getViewSize();
            Dimension dim2 = scrollPane2.getViewport().getViewSize();
            float fXScale = 1;
            float fYScale = 1;
            if( dim1.width > dim2.width ) {
                fXScale = (float)dim1.width / (float)dim2.width;
                fYScale = (float)dim1.height / (float)dim2.height;

                // Scale the movement
                point.x /= fXScale;
                point.y /= fYScale;
            } else {
                fXScale = (float)dim2.width / (float)dim1.width;
                fYScale = (float)dim2.height / (float)dim1.height;

                // Scale the movement
                point.x *= fXScale;
                point.y *= fYScale;
            }

            // Move the other viewport accordingly
            scrollPane2.getViewport().setViewPosition( point );
        }
    }

    private void createBottomPane() {

        // Load a graphic into the display
        Icon image2 = new ImageIcon( "/Users/anton_tobolkin/IdeaProjects/SimpleJFrameApp/src/main/java/image.gif" );
        JLabel label2 = new JLabel( image2 );

        // Create a tabbed pane
        scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );
        scrollPane2.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrollPane2.getViewport().add( label2 );
        scrollPane2.getViewport().addChangeListener( this );
    }

    private void createTopPane() {

        // Create a text are
        JTextArea area = new JTextArea();

        // Load a file into the text area, catching any exceptions
        try {
            FileReader fileStream = new FileReader( "TestFrame.java" );
            area.read( fileStream, "TestFrame.java" );
        } catch( FileNotFoundException e ) {
            System.out.println( "File not found" );
        } catch( IOException e ) {
            System.out.println( "IOException occurred" );
        }

        // Create the scrolling pane for the text area
        scrollPane1 = new JScrollPane();
        scrollPane1.getViewport().add( area );
        scrollPane1.getViewport().addChangeListener( this );
    }

    public static void main( String args[] ) {
        TestFrame mainFrame = new TestFrame();
        mainFrame.setVisible( true );
    }
}