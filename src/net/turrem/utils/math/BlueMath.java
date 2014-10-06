package net.turrem.utils.math;

public class BlueMath
{	
	static final double sqrtTwo = Math.sqrt(2.0D);
	static final double sqrtPi = Math.sqrt(Math.PI);
	static final double sqrtTwoOverPi = sqrtTwo / sqrtPi;
	static final double sqrtTwoPi = sqrtTwo * sqrtPi;
	
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
	
	public static double errorFunction(double x, int n)
	{
		double xs = x * x;
		int fact = 1;
		int div = 1;
		double sum = x;
		double part = x;
		for (int i = 1; i < n; i++)
		{
			fact *= i;
			div += 2;
			part *= xs;
			if (i % 2 == 0)
			{
				sum += part / (div * fact);
			}
			else
			{
				sum -= part / (div * fact);
			}
		}
		return sum * (2 / sqrtPi);
	}
	
	public static double errorFunction(double x)
	{
		return errorFunction(x, 6);
	}
	
	/**
	 * Calculates the cumulative distribution function (CDF) of the standard normal distribution using a Taylor series.
	 * @param x The top of the interval
	 * @return The cumulative distribution function of x
	 */
	public static double standardNormalCumulative(double x)
	{
		return standardNormalCumulative(x, 6);
	}
	
	public static double standardNormalCumulativeRange(double min, double max)
	{
		return standardNormalCumulative(max) - standardNormalCumulative(min);
	}
	
	public static double standardNormalCumulativeRange(double min, double max, int n)
	{
		return standardNormalCumulative(max, n) - standardNormalCumulative(min, n);
	}
	
	public static double standardNormalCumulativeInRange(double min, double max, double x)
	{
		double cmin = standardNormalCumulative(min);
		return (standardNormalCumulative(x) - cmin) / (standardNormalCumulative(max) - cmin);
	}
	
	public static double standardNormalCumulativeInRange(double min, double max, double x, int n)
	{
		double cmin = standardNormalCumulative(min, n);
		return (standardNormalCumulative(x, n) - cmin) / (standardNormalCumulative(max, n) - cmin);
	}
}
