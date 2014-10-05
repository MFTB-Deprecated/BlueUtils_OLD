package net.turrem.utils.math;

public class NormalDistribution implements Distribution
{	
	public double mean;
	public double deviation;
	
	public NormalDistribution(double mean, double deviation)
	{
		this.mean = mean;
		this.deviation = deviation;
	}

	@Override
	public double probability(double x)
	{
		return BlueMath.standardNormalProbability(this.getStandardX(x)) / x;
	}

	@Override
	public double cumulative(double x)
	{
		return BlueMath.standardNormalCumulative(this.getStandardX(x));
	}
	
	public double cumulative(double x, int n)
	{
		return BlueMath.standardNormalCumulative(this.getStandardX(x), n);
	}
	
	private double getStandardX(double x)
	{
		return (x - this.mean) / this.deviation;
	}
	
	public double cumulativeRange(double min, double max)
	{
		return BlueMath.standardNormalCumulativeRange(min, max);
	}
	
	public double cumulativeInRange(double min, double max, double x)
	{
		return BlueMath.standardNormalCumulativeInRange(min, max, x);
	}
	
	public double cumulativeRange(double min, double max, int n)
	{
		return BlueMath.standardNormalCumulativeRange(min, max, n);
	}
	
	public double cumulativeInRange(double min, double max, double x, int n)
	{
		return BlueMath.standardNormalCumulativeInRange(min, max, x, n);
	}
}
