import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class TextWithButton implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JTextField field;
	JButton button;
	
	public TextWithButton()
	{
		this.frame = new JFrame("Button Demo");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Button Demo");
        this.frame.setResizable(false);
        this.frame.setSize(600,200);
        this.frame.setVisible(true);
        
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, 600, 200);
		this.panel.setLayout(null);
		
		this.label = new JLabel();
 
		this.button = new JButton();
		this.button.setText("Submit");
		this.button.setBounds(250,70,90,30);
		
		this.field = new JTextField();
		this.field.setBounds(3,5,600,40);
		
        this.button.addActionListener(this);
        
		this.panel.add(field);
        this.panel.add(button);
        this.panel.add(label);
        this.frame.add(panel);
        this.frame.setLayout(null);
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
        this.label.setText("You entered: " + this.field.getText());
        this.label.setBounds(0,0,600,50);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.field.setBounds(3,60,600,40);
        this.button.setBounds(250,115,90,30);
        this.button.setEnabled(false);
        this.field.setEnabled(false);
    }
    
}
