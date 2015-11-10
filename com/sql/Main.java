package com.sql;

import java.util.Random;
import com.sql.data.*;

;

/**
 * @author lukasz
 *
 */
public class Main {
	private static Random seed = new Random();

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("random number from 0 to 10: " +
		// seed.nextInt(10));
		// System.out.println("" + RandomPatient.printStats());
		// for (int j = 0; j < 101; j++) {
		// System.out.println(RandomPatient.randomPatientInsert(j));
		// System.out.println(RandomPatient.randomUzywki(j));
		// }

		// RecordGenerator.getNextDictionaryRecognition();
		// System.out.println(Randomizer.randomDateAfter("1984-06-13"));
		// RecordGenerator.getNextDictionaryRecognition();
		for (int j = 1; j < 3001; j++)
			PatientRecordsGenerator.generateSinglePatient(j);
	}
}
