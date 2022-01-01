import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;

/********************************************************************
 *  GUI Example - Converting Fahrenheit temp to Celsius temp
 *  @author Ana Posada
 *  @version - March 2019
 *********************************************************************/
public class FahrenheitFrame extends JFrame implements ActionListener {   
    /** To enter fahrenheit temperature */  
    private JTextField fahrenheit;

    /** To show the celsius temperature*/   
    private JTextField celsius;

    /** Button to do the conversion */  
    private JButton convertButton;

    /************************************************
     * Constructor
     ************************************************/
    public FahrenheitFrame() {      
        // setting a background color
        getContentPane().setBackground(Color.CYAN);
        
        // Use a GridBagLayout and the GridBadConstraints
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // instantiate the components (JTextFields and JButton)
        fahrenheit = new JTextField (5);
        celsius = new JTextField (5);
        
        // users cannot enter/modify the celsius field 
        celsius.setEditable (false);
        
        convertButton = new JButton ("Convert");  
        // associates the button with the action listener
        convertButton.addActionListener(this);

        // Specify component's grid location
        loc.gridx = 0;
        loc.gridy = 0;

        // 10 pixels of padding around component
        loc.insets = new Insets(10, 10, 10, 10);

        // aligns the components to the rigth
        loc.anchor = GridBagConstraints.LINE_END;
        
        add (new JLabel ("Fahrenheit:"), loc);

        loc.gridx = 1;
        add (fahrenheit, loc);

        loc.gridx = 0;
        loc.gridy = 1;
        add (new JLabel ("Celsius: "), loc);

        loc.gridx = 1;
        add (celsius, loc);

        // instantiating the object loc again to start 
        // with the default setting
        loc = new GridBagConstraints();
        loc.insets = new Insets(10, 10, 10, 10);
        
        // The width of the column is set to 2
        // convert button is centered in the first two columns
        loc.gridwidth = 2;
        loc.gridx = 0;
        loc.gridy = 2;
        add (convertButton, loc);
    }

    /******************************************************************
     *  action listener for the temperature input field.
     *  @param - event that invokes the action listener 
     ******************************************************************/
    public void actionPerformed (ActionEvent event) {
        double fahrenheitTemp = 0;
        double celsiusTemp;
        DecimalFormat fmt = new DecimalFormat("0.#");
        
        // gets the text entered in the JTextField
        String text = fahrenheit.getText();
        try  {
            // converts the text to a double to be able to use it in formula
            fahrenheitTemp = Double.parseDouble (text);
            celsiusTemp = (fahrenheitTemp - 32) * 5 / 9;
            
            // converts the double to a text using the decimal format
            celsius.setText (fmt.format(celsiusTemp));
        }
        catch( NumberFormatException e ) {
            JOptionPane.showMessageDialog(null, "Enter a valid number"  );
            celsius.setText ("");
        } 
    }

    /***********************************************
     * main method
     *************************************************/
    public static void main(String[] args) {
        FahrenheitFrame myFrame = new FahrenheitFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}

