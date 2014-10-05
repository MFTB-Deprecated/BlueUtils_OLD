package net.turrem.utils.math;

public interface Distribution
{
	public double probability(double x);
	
	public double cumulative(double x);
}
