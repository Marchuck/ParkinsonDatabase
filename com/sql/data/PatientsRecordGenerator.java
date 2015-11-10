package com.sql.data;

import java.util.Random;

public class PatientRecordsGenerator {
	private static final Random seed = new Random();

	private PatientRecordsGenerator() {
	}

	public static void generateSinglePatient(int primaryKey) {
		String name = seed.nextBoolean() ? Randomizer.randomMaleName()
				: Randomizer.randomFemaleName();
		int randomNumber = seed.nextInt();
		String birthDate = Randomizer.randomDate();
		int educationId = Randomizer.randomEducationId();
		String patientInsert = "insert into mydb.Pacjent values(" + primaryKey
				+ ",\"" + name + "\",\"" + Randomizer.randomSurname()
				+ "\",date('" + birthDate + "')" + ","
				+ Randomizer.randomNumber() + ",\"ul "
				+ Randomizer.randomStreet() + " "
				+ Randomizer.randomHomeNumber(randomNumber) + "\"," + "\""
				+ Randomizer.randomProfession() + "\"" + "," + educationId
				+ "," + "\"" + Randomizer.randomConditions("ie", educationId)
				+ "\"" + "," + "\"" + Randomizer.randomSociality() + "\""
				+ ");";
		// insert new Patient
		System.out.println(patientInsert);
		// insert stimulants record for this patient
		System.out.println(Randomizer.randomStimulants(primaryKey, birthDate));
		// insert symptom of Parkinson's disease
		Randomizer.getParkinsonSymptoms(primaryKey);
		// insert other symptoms
		Randomizer.getOtherSymptoms(primaryKey);
		// insert current diseases for patient
		Randomizer.getDiseases(primaryKey, birthDate);
		// insert priamry investigation for patient
		Randomizer.getPatientExamination(primaryKey);
		// get list of recognized issues
		System.out.println( Randomizer.randomRozpoznanie(primaryKey));
		
		Randomizer.getListOfRecognitions(primaryKey);
		// if(seed.nextBoolean()){
		// list of diseases from family
		Randomizer.getFamilyDiseases(primaryKey);
		// }
		// current disease log
		Randomizer.getCurrentDiseaseLog(primaryKey);
	}
}
