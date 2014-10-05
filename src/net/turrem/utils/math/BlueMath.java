package net.turrem.utils.math;

public class BlueMath
{	
	static final double sqrtTwoPi = Math.sqrt(2.0D * Math.PI);
	
	/**
	 * Calculates the probability density of standard normal distribution at x.
	 * @param x The top of the interval
	 * @return The standard normal distribution function of x
	 */
	public static double standardNormalProbability(double x)
	{
		return Math.exp(-0.5D * x * x) / sqrtTwoPi;
	}

	/**
	 * Calculates the cumulative distribution function (CDF) of the standard normal distribution using a Taylor series.
	 * <p>
	 * Accurate to <code>log(3*5*7...(2n+1))+x^2/2*log(e)+1/2*log(2*pi)-(2n+1)*log(x)</code> decimal places.
	 * @param x The top of the interval
	 * @param n How many iterations to make the calculation with
	 * @return The cumulative distribution function of x
	 */
	public static double standardNormalCumulative(double x, int n)
	{
		double xs = x * x;
		int div = 1;
		double sum = x;
		double part = x;
		for (int i = 1; i < n; i++)
		{
			div += 2;
			part *= xs;
			part /= div;
			sum += part;
		}
		sum /= sqrtTwoPi;
		sum *= Math.exp(-0.5D * xs);
		return sum + 0.5D;
	}
	
	/**
	 * Calculates the cumulative distribution function (CDF) of the standard normal distribution using a Taylor series.
	 * <p>
	 * Accurate to <code>5.53+x^2*0.22-13*log(x)</code> decimal places.
	 * @param x The top of the interval
	 * @return The cumulative distribution function of x
	 */
	public static double standardNormalCumulative(double x)
	{
		return standardNormalCumulative(x, 6);
	}
}
