import java.awt.Graphics2D;
import java.awt.Color;
public class Ball extends Object
{
	public Ball(double x, double y, double diameter)
	{
		super(x,y,diameter);
	}

	public Ball(double x, double y, double diameter, double xVelocity, double yVelocity)
	{
		super(x,y,diameter,xVelocity,yVelocity);
	}

	public void drawMe(Graphics2D g)
	{
		g.setColor(Color.black);
		g.fillOval((int)x, (int)y, (int)diameter, (int)diameter);
	}
}