import java.awt.*;
import javax.swing.*;

class TestFrame extends JFrame {

    public TestFrame() {
        setTitle( "Test Application" );
        setSize( 200, 200 );
        setBackground( Color.gray );
        Panel topPanel = new Panel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create a label to look at
        Label labelHello = new Label( "Hello World!" );
        topPanel.add( labelHello, BorderLayout.NORTH );
    }


    public static void main( String args[] ) {
        TestFrame mainFrame = new TestFrame();
        mainFrame.setVisible( true );
    }
}