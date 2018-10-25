package org.javacream.tools.api;


public class Coordinate implements Comparable<Coordinate>
{
	private Integer x, y, z;

	@Override
	public String toString()
	{
		return "Coordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public Coordinate(Integer x, Integer y, Integer z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((z == null) ? 0 : z.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x == null)
		{
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null)
		{
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null)
		{
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	public Integer getX()
	{
		return x;
	}

	public Integer getY()
	{
		return y;
	}

	public Integer getZ()
	{
		return z;
	}
	
	public Integer distance()
	{
		Double distance = Math.sqrt(x * x + y * y + z * z);
		return distance.intValue();
	}

	@Override
	public int compareTo(Coordinate o)

	{

		if (1000 * this.distance() - 1000 * o.distance() > 0)
		{
			return 1;
		} else if (1000 * this.distance() - 1000 * o.distance() < 0)
		{
			return -1;
		} else
		{
			return 0;
		}
	}

}
