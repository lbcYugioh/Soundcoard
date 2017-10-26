import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Soundboard
{
	public Soundboard()
	{
		//Create a new frame
        JFrame a = new JFrame("Soundboard");
        
        
        //make sure the program exits when the frame closes
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the size of the frame
        a.setSize(900, 500);
		
		//create the Audrey Hepburn button			
		JButton j = makeSoundboardButton("audrey.JPG", "Hepburn.WAV");
        
		
		//create the Sylvia Mathews Burwell button
		JButton l = makeSoundboardButton("Obama.jpg", "barack.wav");
		
		//create a JPanel for the button
		JPanel b = new JPanel();
		
		//add the button to a JPanel
		b.add(j);
        b.add(l);
		
		//add the panel to the content pane of the frame
		a.getContentPane().add(b);
		
		//make sure the JFrame is visible
        a.setVisible(true);
	}
	
	/**
	 * Creates a JButton which displays the specified image and plays the specified sound when it is clicked.
	 * @param imageFile the name of the image to display on the button, including the file extension
	 * @param soundFile the name of the audio clip to play when the button is clicked
	 * @return the JButton
	 **/
	private JButton makeSoundboardButton(String imageFile, String soundFile)
	{
		JButton button;
		try{
			BufferedImage icon = ImageIO.read(new File(imageFile));
			button = new JButton(new ImageIcon(icon));
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			//add action listener
			button.addActionListener(new SoundboardActionListener(soundFile));
		}
		catch (IOException e) {
			System.out.println(e);
			button = new JButton();
		}
		return button;
	}
}