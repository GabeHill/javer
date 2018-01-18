package logicc;

import java.util.Arrays;

import lib.ConsoleIO;
import object.Parcel;

public class PackageSorter {
	private static Parcel[] array;

	private static Parcel[] genParcels(int num) {
		final Parcel[] temp = new Parcel[num];
		final String[] d = { "height", "weight", "depth", "weight" };
		final double[] t = new double[d.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < d.length; j++) {
				t[j] = ConsoleIO.promptForDouble("Enter " + d[j] + " for parcel " + (i + 1) + ":", .1, 72);
			}
			temp[i] = new Parcel(t[0], t[1], t[2], t[3]);
		}
		return temp;
	}

	public static void run() {
		boolean cont = true;
		do {
			final int numOfP = ConsoleIO.promptForInt("How many parcels?", 0, Integer.MAX_VALUE);
			if (numOfP > 0) {
				array = genParcels(numOfP);
				sortParcels();

				for (final Parcel parcel : array) {
					System.out.println(parcel);
				}
			} else {
				System.out.println("There were no parcels.");
			}
			cont = ConsoleIO.promptForBool("Would you like to start again? y/n", "y", "n");
		} while (cont);
	}

	public static void sortParcels() {
		Arrays.sort(array);
	}
}
