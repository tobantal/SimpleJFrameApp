import java.awt.*;
import javax.swing.*;

class TestFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel topPanel;

    public TestFrame() {
        setUp();
        createPages();
        addPages();
        addPages();
    }

    private void setUp() {
        setTitle( "Tabbed Pane Application" );
        setSize( 300, 200 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground( Color.gray );
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
    }

    private void createPages() {
        createPages();
        createPage1();
        createPage2();
        createPage3();
    }

    private void addPages() {
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab( "Page 1", panel1 );
        tabbedPane.addTab( "Page 2", panel2 );
        tabbedPane.addTab( "Page 3", panel3 );
        topPanel.add( tabbedPane, BorderLayout.CENTER );
    }

    public void createPage1() {
        panel1 = new JPanel();
        panel1.setLayout( null );
        JLabel label1 = new JLabel( "Username:" );
        label1.setBounds( 10, 15, 150, 20 );
        panel1.add( label1 );
        JTextField field = new JTextField();
        field.setBounds( 10, 35, 150, 20 );
        panel1.add( field );
        JLabel label2 = new JLabel( "Password:" );
        label2.setBounds( 10, 60, 150, 20 );
        panel1.add( label2 );
        JPasswordField fieldPass = new JPasswordField();
        fieldPass.setBounds( 10, 80, 150, 20 );
        panel1.add( fieldPass );
    }

    public void createPage2() {
        panel2 = new JPanel();
        panel2.setLayout( new BorderLayout() );
        panel2.add( new JButton( "North" ), BorderLayout.NORTH );
        panel2.add( new JButton( "South" ), BorderLayout.SOUTH );
        panel2.add( new JButton( "East" ), BorderLayout.EAST );
        panel2.add( new JButton( "West" ), BorderLayout.WEST );
        panel2.add( new JButton( "Center" ), BorderLayout.CENTER );
    }

    public void createPage3() {
        panel3 = new JPanel();
        panel3.setLayout( new GridLayout( 3, 2 ) );
        panel3.add( new JLabel( "Field 1:" ) );
        panel3.add( new TextArea() );
        panel3.add( new JLabel( "Field 2:" ) );
        panel3.add( new TextArea() );
        panel3.add( new JLabel( "Field 3:" ) );
        panel3.add( new TextArea() );
    }

    public static void main(String args[]) {
        TestFrame mainFrame = new TestFrame();
        mainFrame.setVisible( true );
    }
}
