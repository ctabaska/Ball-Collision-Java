import java.awt.*;
import javax.swing.JPanel;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Screen extends JPanel implements KeyListener
{	

	public static int screenHeight = 600;
	public static int screenWidth = 800;
	ArrayList<Ball> balls = new ArrayList<Ball>();
	public Screen()
	{
		setLayout(null);
		
		balls.add( new Ball(0.0, 0.0, 20, 2.0, 2.0) );
		balls.add( new Ball(140.0, 140.0, 20.0) );

		addKeyListener(this);
        setFocusable(true);
	}
	
	public Dimension getPreferredSize()
	{
		//Sets the size of the panel
        return new Dimension(screenWidth,screenHeight);
	}
	
	public void paintComponent(Graphics gTemp)
	{
		Graphics2D g = (Graphics2D)gTemp;
		super.paintComponent(g);

		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).drawMe(g);
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 32)
		{
			balls.add( new Ball(0.0, 0.0, 20, 2, 2) );
		}
	}
	public void keyReleased(KeyEvent e){}

	public void animate()
	{

		while( true )
		{
			try {
			    Thread.sleep(16);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			for(int i = 0; i < balls.size(); i++)
			{
				balls.get(i).move();
			}
			for(int i = 0; i < balls.size() - 1; i++)
			{
				for(int ii = i + 1; ii < balls.size(); ii++)
				{
					balls.get(i).checkCollision(balls.get(ii));
				}
			}

			repaint();
		}
	}
}
