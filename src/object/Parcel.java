package object;

import java.math.BigInteger;

public class Parcel implements Comparable<Parcel> {
	private static int counter = 1;
	public final double[] dimensions = new double[3];
	public final int packageID;
	public final double sortCriterion;
	private final double weight;

	public Parcel(double height, double width, double depth, double weight) {
		dimensions[0] = height;
		dimensions[1] = width;
		dimensions[2] = depth;
		this.weight = weight;
		packageID = counter++;
		sortCriterion = weight / (height * width * depth);
	}

	@Override
	public int compareTo(Parcel o) {
		final BigInteger oo = BigInteger.valueOf((long) (o.sortCriterion * 10000));
		final BigInteger r = BigInteger.valueOf((long) (sortCriterion * 10000));

		return r.compareTo(oo);

	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Parcel " + packageID + ": height: " + dimensions[0] + ", width: " + dimensions[1] + ", depth: "
				+ dimensions[2] + ", weight: " + weight + ", mass: " + sortCriterion + ".";
	}

}
