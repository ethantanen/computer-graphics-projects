import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener{
	
	Canvas canvas;
	JTextField x,y,z;
	JButton[] rotations;
	String[] rotation_names; 
		
	public GUI(Canvas c) {
		
		setPreferredSize(new Dimension(200,600));
		setBackground(Color.DARK_GRAY);

		canvas = c;
		
		//instantiate and add buttons to screen 
		rotation_names = new String[]{"Wire","Solid","XCC", "XC", "YCC", "YC", "ZCC","ZC","ARBCC","ARBC"};
		rotations = new JButton[rotation_names.length];
		
		x = new JTextField("X arb",5);
		y = new JTextField("Y arb",5);
		z = new JTextField("Z arb",5);
		
		
		for(int i=0; i<rotation_names.length; i++){
			rotations[i] = new JButton(rotation_names[i]);
			rotations[i].addActionListener(this);
			add(rotations[i]);
		}
		
		add(x);
		add(y);
		add(z);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = ((JButton)e.getSource()).getText();
		
		if(button.equals("Wire")){
			canvas.setWireFrame(true);
			canvas.repaint();
			return;
		}else if(button.equals("Solid")){
			canvas.setWireFrame(false);
			canvas.repaint();
			return;
		}
				
		if(button.equals("ARBC") || button.equals("ARBCC")){
			canvas.rotateCube(button, Double.parseDouble(x.getText()),Double.parseDouble(y.getText()),Double.parseDouble(z.getText()));
		}else{
			canvas.rotateCube(button, 0, 0, 0);
		}
	}
}
