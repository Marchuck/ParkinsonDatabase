package com.sql.data;

import java.util.HashSet;
import java.util.Random;

import javax.swing.text.StyleContext.SmallAttributeSet;

final public class Randomizer {

	private static Random seed = new Random();

	public static void getParkinsonSymptoms(int primaryKey) {
		int symptomsSize = 11;
		for (Integer j : randomSet(0, 11, seed.nextInt(5))) {
			System.out.println("insert into mydb.Objaw_parkinsonowski value("
					+ primaryKey + "," // ID of Patient
					+ j // ID of symptom
					+ "," + seed.nextInt(6) + ","// ID of body part
					+ seed.nextInt(5) + ");"); // 0-4 (severity of the
												// disease)
		}
	}

	private final static String[] bradysinesiaValues = new String[] {
			"niedoczynność tarczycy", "ataksje Friedricha", "choroba Wilsona",
			"zatrucie alkoholowe", "stwardnienie rozsiane", "guzy czaszki",
			"zatrucie lekami", "uraz głowy", "choroby zapalne" };
	private final static String[] pyramidValues = new String[] {
			"osłabienie mięśni", "odruchy patologiczne Rossolimo",
			"wzmożenie napięcia mięśniowego", "klonusy",
			"zespół rzekomoopuszkowy", "brak fascykulacji",
			"osłabienie odruchów", "niedowład mięśni", "wiotkość mięśni",
			"choroby zapalne" };
	private final static String[] eyeValues = new String[] { "śródmózgowie",
			"uszkodzenie spoidła tylnego", "uszkodzenie pnia mózgu",
			"uszkodzenie kory mózgu", "uszkodzenie móżdżku",
			"porażenie międzyjądrowe", "stwardnienie rozsiane" };
	private final static String[] touchValues = new String[] { "kauzalgia",
			"neuralgia", "bóle fatomowe", "parestezje", "hiperpatia" };

	private static String randValues(String[] arr) {
		return arr[seed.nextInt(arr.length)];
	}

	public static String getRandomHour() {
		int hour = 1 + seed.nextInt(12);
		int min = seed.nextInt(60);
		String hString = hour < 10 ? "0" + hour : String.valueOf(hour);
		String hMin = min < 10 ? "0" + min : String.valueOf(min);
		return hString + ":" + hMin;
	}

	public static String randSmallInt() {
		return seed.nextBoolean() ? "1" : "0";
	}

	public static String randSmallInt(boolean b) {
		return b ? "1" : "0";
	}

	public static void getPatientRecognition(int primaryKey) {
		System.out.println(randomRozpoznanie(primaryKey));
	}

	public static void getPatientExamination(int primaryKey) {
		int lastPotion = (100 + seed.nextInt(400));
		System.out.println("insert into mydb.Badanie_przedmiotowe values("
				+ primaryKey + "," + "time('" + getRandomHour() + "'),"
				+ "time('" + getRandomHour() + "')," //+ lastPotion + ","
				+ (lastPotion + seed.nextInt(400)) + "," + seed.nextInt(3)
				+ "," + randSmallInt() + "," + randSmallInt() + ");");
	}

	public static HashSet<Integer> randomSet(int from, int to, int size) {
		HashSet<Integer> set = new HashSet<>();

		while (set.size() != size) {
			set.add(from + seed.nextInt(to - from));
		}
		return set;
	}

	private static String randomFamilyMember(boolean isMale) {
		if (isMale) {
			return seed.nextBoolean() ? "ojciec" : "brat";
		} else {
			return seed.nextBoolean() ? "matka" : "siostra";
		}
	}

	public static String getImmediateCircumstances() {
		return seed.nextBoolean() ? "okoliczność 1"
				: seed.nextBoolean() ? "okoliczność 2"
						: seed.nextBoolean() ? "okoliczność 3"
								: "okoliczność 4";
	}

	public static void getCurrentDiseaseLog(int primaryKey) {
		boolean immediate = seed.nextBoolean();
		boolean onLeft = seed.nextBoolean();
		boolean increased = seed.nextBoolean();

		System.out
				.println("insert into mydb.Dot_przeb_choroby values("
						+ primaryKey
						+ ","
						+ randSmallInt(immediate)
						+ ","
						+ (immediate ? "\"" + getImmediateCircumstances()
								+ "\"," : "null,")
						+ randSmallInt()
						+ ","
						+ (!onLeft ? randSmallInt(true) : randSmallInt())
						+ ","
						+ seed.nextInt(2)
						+ ","
						+ (increased ? "\"nasilenie\"," : "null,")
						+ (increased ? "date('" + timesBefore() + "')" : "null")
						+ ");");
	}

	private static String timesBefore() {
		int aMonth = 1 + seed.nextInt(11);
		int aDay = 1 + seed.nextInt(29);
		String month = aMonth < 10 ? "0" + aMonth : String.valueOf(aMonth);
		String day = aDay < 10 ? "0" + aDay : String.valueOf(aDay);

		return "2015-" + month + "-" + day;
	}

	public static void getFamilyDiseases(int primaryKey) {
		boolean isMale = seed.nextBoolean();
		String familyMember = randomFamilyMember(isMale);

		System.out.println("insert into mydb.Wywiad_rodzinny values(" + "\""
				+ familyMember + "\"" + "," + (isMale ? "1," : "0,") + "\""
				+ randValues(RecordGenerator.NEUROLOGICAL_DISEASES) + "\""
				+ "," + primaryKey + ");");
	}

	public static void getListOfRecognitions(int primaryKey) {
		int to = RecordGenerator.RECOGNITION_EXCLUDED.length
				+ RecordGenerator.RECOGNITION_NOT_EXCLUDED.length;
		// for (Integer j : randomSet(0, to, 2 + seed.nextInt(6))) {
		int j = seed.nextInt(to);
		System.out.println("insert into mydb.Lista_rozpoznanie values("
				+ primaryKey + "," + j + "," + randSmallInt() + ");");
		// }
	}

	public static void getOtherSymptoms(int primaryKey) {
		System.out.println("insert into mydb.Objawy_reszta values("
				+ primaryKey
				+ ","// ID of Patient
				+ "\""
				+ randValues(bradysinesiaValues)
				+ "\"," // bradyskinesia level
				+ seed.nextBoolean()
				+ "," // dyskinezje
				+ seed.nextBoolean()
				+ "," // slinienie
				+ seed.nextBoolean()
				+ "," // lojotok
				+ seed.nextBoolean()
				+ "," // pocenie
				+ "\"" + randValues(bradysinesiaValues) + "\"," + "\""
				+ randValues(pyramidValues) + "\"" + "," + "\""
				+ randValues(eyeValues) + "\"" + "," + "\""
				+ randValues(touchValues) + "\"" + "," + seed.nextInt(31) + ","// MMSE
				+ seed.nextInt(40) // skala Hamiltona
				+ ");");
	}

	public static String printStats() {
		return "Database contains " + Data.SURNAMES.length + " surnames, "
				+ Data.FEMALE_NAMES.length + " female names,"
				+ Data.MALE_NAMES.length + " male names, "
				+ Data.STREET_NAMES.length + " street names,"
				+ Data.PROFESSIONS.length + " professions";
	}

	public static String randomMaleName() {
		return Data.MALE_NAMES[seed.nextInt(Data.MALE_NAMES.length)];
	}

	public static String randomFemaleName() {
		return Data.FEMALE_NAMES[seed.nextInt(Data.FEMALE_NAMES.length)];
	}

	public static String randomSurname() {
		return Data.SURNAMES[seed.nextInt(Data.SURNAMES.length)];
	}

	public static String create() {
		String name = seed.nextBoolean() ? randomMaleName()
				: randomFemaleName();
		return name + " " + randomSurname();
	}

	public static String createSqlInsert() {
		String name = seed.nextBoolean() ? randomMaleName()
				: randomFemaleName();
		return name + " " + randomSurname();
	}

	public static String randomDate() {
		int month = seed.nextInt(12);
		++month;
		String monthAsString = month < 10 ? "0" + month : String.valueOf(month);
		int day = 1 + seed.nextInt(29);
		String dayAsString = day < 10 ? "0" + day : String.valueOf(day);
		int year = 1940 + seed.nextInt(45);
		return year + "-" + monthAsString + "-" + dayAsString;
	}

	public static String randomDateAfter(String date) {

		int yearOfBirth = Integer.valueOf(date.substring(0, 4));
		int left = 2000 - yearOfBirth;
		int year = yearOfBirth + 15 + seed.nextInt(left);

		int month = seed.nextInt(12);
		++month;
		String monthAsString = month < 10 ? "0" + month : String.valueOf(month);
		int day = 1 + seed.nextInt(29);
		String dayAsString = day < 10 ? "0" + day : String.valueOf(day);
		return year + "-" + monthAsString + "-" + dayAsString;
	}

	public static String randomNumber() {
		return String.valueOf(900000000 - seed.nextInt(80000000));
	}

	public static String randomStreet() {
		return Data.STREET_NAMES[seed.nextInt(Data.STREET_NAMES.length)];
	}

	public static String randomHomeNumber(int j) {
		int val = j % 200;
		return String.valueOf(val < 0 ? -val : val);
	}

	public static String randomProfession() {
		return Data.PROFESSIONS[seed.nextInt(Data.PROFESSIONS.length)];
	}

	public static int randomEducationId() {
		return seed.nextInt(10);
	}

	public static String randomConditions(String suffix, int iD) {
		if (iD >= 5) {
			return seed.nextBoolean() ? "wysok" + suffix : "powyżej średniej";
		} else
			return seed.nextBoolean() ? seed.nextBoolean() ? seed.nextBoolean() ? seed
					.nextBoolean() ? "w normie" : "poniżej średniej"
					: "powyżej średniej"
					: "nisk" + suffix
					: "wysok" + suffix;

	}

	public static String randomConditions(int iD) {
		return randomConditions("ie", iD);
	}

	public static String randomSociality() {
		return randomConditions("a", -1);
	}

	public static String randomPatientInsert(int j) {
		String name = seed.nextBoolean() ? randomMaleName()
				: randomFemaleName();
		int randomNumber = seed.nextInt();
		String birthDate = randomDate();
		int edu = randomEducationId();
		String patientInsert = "insert into mydb.Pacjent values(" + j + ",\""
				+ name + "\",\"" + randomSurname() + "\",date('" + birthDate
				+ "')" + "," + randomNumber() + ",\"ul " + randomStreet() + " "
				+ randomHomeNumber(randomNumber) + "\"," + "\""
				+ randomProfession() + "\"" + "," + edu + "," + "\""
				+ randomConditions(edu) + "\"" + "," + "\"" + randomSociality()
				+ "\"" + ");";
		return patientInsert + ";" + randomStimulants(j, birthDate);
	}

	public static String randomHoehnScale() {
		String out;
		int scale = 1 + seed.nextInt(5);
		if (scale == 2 || scale == 1) {
			boolean b = seed.nextBoolean();
			out = b ? scale + ".5" : String.valueOf(scale);
		} else {
			out = String.valueOf(scale);
		}
		return out;
	}

	private static String randomYears() {
		return seed.nextInt(6) + " lat";
	}

	public static String randomRozpoznanie(int j) {

		return "insert into mydb.rozpoznanie values" + "(" + j // idPatient
				+ ",\"" + randomYears() + "\"," // disease duration
				+ randomHoehnScale() + "," // Hoehn scale
				+ (10 * seed.nextInt(11)) // Schwab scale
				+ ");";
	}

	public static String randomYes(boolean b) {
		return b ? "\"tak\"" : "\"nie\"";
	}

	public static String randomStimulants(int j, String dateOfBirth) {

		boolean niko = seed.nextBoolean();
		boolean alko = seed.nextBoolean();
		boolean leki = seed.nextBoolean();
		String nikOd = niko ? "'" + randomDateAfter(dateOfBirth) + "'" : "null";
		String alkOd = alko ? "'" + randomDateAfter(dateOfBirth) + "'" : "null";
		String lekOd = leki ? "'" + randomDateAfter(dateOfBirth) + "'" : "null";
		return "insert into mydb.Uzywki values" + "(" + j + ","
				+ randomYes(niko) + "," + nikOd + "," + randomYes(alko) + ","
				+ alkOd + "," + randomYes(leki) + "," + lekOd + ");";
	}

	public static String getDyskinesiaType() {
		return seed.nextBoolean() ? "wczesne" : "późne";
	}

	public static void getDiseases(int primaryKey, String date) {
		for (Integer j : randomSet(0, 26, seed.nextInt(6))) {
			int J = j.intValue();
			System.out.println("insert into mydb.Choroba values("
					+ primaryKey
					+ ","
					+ J
					+ ","
					+ "date('"
					+ randomDateAfter(date)
					+ "'),"
					+ ((7 == J || 8 == J) ? "\"" + getDyskinesiaType() + "\""
							: "null") + ");");
		}

	}
}
