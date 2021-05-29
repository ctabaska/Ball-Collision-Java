public class Object
{
	public double x;
	public double y;
	public double centerX;
	public double centerY;
	public double diameter;
	public double radius;
	public double xVelocity;
	public double yVelocity;
	public double velocity;
	public double mass;

	public Object(double x, double y, double diameter)
	{
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.radius = this.diameter/2.0;
		this.centerX = this.x + this.radius;
		this.centerY = this.y + this.radius;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.velocity = Math.sqrt(Math.pow(this.xVelocity, 2) + Math.pow(this.yVelocity, 2));
		this.mass = Math.PI * Math.pow(radius, 2);
	}

	public Object(double x, double y, double diameter, double xVelocity, double yVelocity)
	{
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.radius = this.diameter/2.0;
		this.centerX = this.x + this.radius;
		this.centerY = this.y + this.radius;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.velocity = Math.sqrt(Math.pow(this.xVelocity, 2) + Math.pow(this.yVelocity, 2));
		this.mass = Math.PI * Math.pow(radius, 2);	
	}

	public void move()
	{
		// x Movement
		if(this.x + xVelocity >= Screen.screenWidth - this.diameter)
		{
			this.x = Screen.screenWidth - this.diameter;
			this.xVelocity = -this.xVelocity;
		} else if(this.x + this.xVelocity <= 0)
		{
			this.x = 0;
			this.xVelocity = - this.xVelocity;
		} else
		{
			this.x += this.xVelocity;
		}
		
		// y Movement
		if(this.y + this.yVelocity >= Screen.screenHeight - this.diameter)
		{
			this.y = Screen.screenHeight - this.diameter;
			this.yVelocity = -this.yVelocity;
		} else if(this.y + this.yVelocity <= 0) 
		{
			this.y = 0;
			this.yVelocity = - this.yVelocity;
		} else
		{
			this.y += this.yVelocity;
		}
	}

	public void checkCollision(Object obj1)
	{
		//System.out.println(Math.sqrt(Math.pow(this.x - obj1.x, 2) + Math.pow(this.x - obj1.x, 2)));
		if(Math.sqrt(Math.pow(this.x - obj1.x, 2) + Math.pow(this.y - obj1.y, 2)) <= this.radius + obj1.radius)
		{
			//System.out.println("Velocity 1: " + this.velocity + " Velocity 2: " + obj1.velocity);
			double fVelocity2 = ((this.mass * this.velocity) + (obj1.mass * obj1.velocity) - (this.mass * (obj1.velocity - this.velocity)))/(this.mass + obj1.mass);
			double fVelocity1 = obj1.velocity - this.velocity + fVelocity2;
			this.velocity = fVelocity1;
			obj1.velocity = fVelocity2;

			double angle1 = Math.toDegrees(Math.atan((this.x - obj1.x )/(this.y - obj1.y)));
			double angle2 = Math.toDegrees(Math.atan((this.y - obj1.y )/(this.x - obj1.x)));
			System.out.println(angle1);
			System.out.println(angle2);

			this.xVelocity = Math.sin(angle1) * this.velocity;
			this.yVelocity = Math.cos(angle1) * this.velocity;

			obj1.xVelocity = Math.sin(angle2) * obj1.velocity;
			obj1.yVelocity = Math.cos(angle2) * obj1.velocity;

			//System.out.println("Velocity 1: " + this.velocity + " Velocity 2: " + obj1.velocity);

			//System.out.println("true");
			// this.xVelocity;
			// this.yVelocity;
			// obj1.xVelocity;
			// obj1.yVelocity;
		}
	}
}