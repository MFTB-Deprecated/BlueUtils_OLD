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

	public double sliceMean(double left)
	{
		return this.sliceMean(left, 6);
	}
	
	public double sliceMean(double left, int n)
	{
		//Don't even try to figure this out
		//Solved using Wolfram Mathematica
		/**
		 * <code>SliceMean[dist_, edge_] := Integrate[PDF[dist, x]*x, {x, edge, \[Infinity]}]/(1 - CDF[dist, edge])</code><b>
		 * <code>NormalSliceMean[\[Mu]_, \[Sigma]_, edge_] := Evaluate[FullSimplify[SliceMean[NormalDistribution[\[Mu], \[Sigma]], edge]]]</code><b>
		 * <code>NormalSliceMean[\[Mu], \[Sigma], a]</code><b>
		 * out = <code>(E^(-((a - \[Mu])^2/(2 \[Sigma]^2))) Sqrt[2/\[Pi]] \[Sigma] + \[Mu] Sqrt[1/\[Sigma]^2] \[Sigma] - \[Mu] Erf[(a - \[Mu])/(Sqrt[2] \[Sigma])])/(1 + Erf[(-a + \[Mu])/(Sqrt[2] \[Sigma])])</code>
		 */
		double diff = this.mean - left;
		double ds = this.deviation * this.deviation;
		double error = BlueMath.errorFunction((diff) / (BlueMath.sqrtTwo * this.deviation), n);
		double out = Math.exp((diff * diff) / (-2.0D * ds));
		out *= BlueMath.sqrtTwoOverPi;
		out += this.mean * Math.sqrt(1.0D / ds);
		out *= this.deviation;
		out += this.mean * error;
		out /= 1.0D + error;
		return out;
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
