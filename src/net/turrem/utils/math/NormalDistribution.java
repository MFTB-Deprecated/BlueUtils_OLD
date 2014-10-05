package net.turrem.utils.math;

public class NormalDistribution implements Distribution
{	
	public final double mean;
	public final double deviation;
	
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
}
