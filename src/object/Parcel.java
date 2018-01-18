package object;

public class Parcel implements Comparable<Parcel> {
	private static int counter = 1;
	public final double[] dimensions = new double[3];
	private final double sortCriterion;
	public final int packageID;
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
		if (o == null) {
			throw new NullPointerException("That is null.");
		} else if (o.getClass() != Parcel.class) {
			throw new ClassCastException("That is not a parcel.");
		} else {
			if (o.getMass() > sortCriterion) {
				return 1;
			} else if (o.getMass() < sortCriterion) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public double getMass() {
		return sortCriterion;
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
