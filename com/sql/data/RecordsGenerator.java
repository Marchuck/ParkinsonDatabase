package com.sql.data;

public class RecordGenerator {
	private RecordGenerator() {
	}

	final static String[] RECOGNITION_EXCLUDED = new String[] {
			"nawracające incydenty niedokrwienia mózgu",
			"skokowe pogorszenie zespołu parkinsonowskiego",
			"powtarzające się   urazy czaszkowo-mózgowe",
			"przebyte zapalenie mózgu",
			"Objawy móżdżkowe",
			"Leczenie neuroleptykami w okresie pojawienia się objawów",
			"Więcej niż jeden krewny dotknięty chorobą",
			"Długotrwałe remisje",
			"Objawy piramidowe",
			"Wyłącznie jednostronne objawy po 3 latach od początku choroby",
			"Postępujące porażenie nadjądrowe",
			"Wczesne , ciężkie zaburzenia wegetatywne",
			"Wczesne, ciężkie otępienie z zaburzeniami pamięci , mowy i praksji",
			"Rozpoznanie guza mózgu lub wodogłowia komunikującego",
			"Zła odpowiedź na duże dawki L-Dopy ( wykluczyć zespół złego wchłaniania)",
			"Narażenie na MPTP" };

	final static String[] RECOGNITION_NOT_EXCLUDED = new String[] {
			"Spowolnienie ruchowe", "Drżenie spoczynkowe 4-6 Hz",
			"Sztywność mięśniowa", "Zaburzenia postawy",
			"Początek z objawami jednostronnymi", "Obecne drżenie spoczynkowe",
			"Przetrwała asymetria objawów", "Bardzo dobra odpowiedź na L-Dopę",
			"Ciężka pląsawica wywołana przez L-Dopę",
			"Dobra reakcja na L-Dopę po więcej niż 5 latach",
			"Przebieg choroby dłużej niż 10 lat"

	};
	public static final String[] NEUROLOGICAL_DISEASES = new String[] {
			"padaczka", "otępienie", "drżenie samoistne/piramidowe",
			"stwardnienie zanikowe boczne", "Parkinson", "Alzheimer",
			"Huntington", "Creutzfeldta-Jakoba", "zespół Guillaina-Barrego",
			"migrena", "udar mózgu", "klasterowy ból głowy",
			"zapalenie opon mózgowych", "stwardnienie rozsiane",
			"encefalopatia wątrobowa", };
	public static final String DISEASES[] = new String[] {

	};

	public static void getNextDictionaryRecognition() {
		String x = "";
		int currentId = 0;
		for (String s : RECOGNITION_EXCLUDED) {
			System.out.println("insert into mydb.Slownik_rozpoznanie value("
					+ currentId + ", \"" + s + "\", 1);");
			currentId++;
		}
		for (String s : RECOGNITION_NOT_EXCLUDED) {
			System.out.println("insert into mydb.Slownik_rozpoznanie value("
					+ currentId + ", \"" + s + "\", 0);");
			currentId++;
		}
	}

//	public static void getDiseasesDictionary() {
//		int size = DISEASES.length;
//		for (int j = 0; j < size; j++) {
//			System.out.println("insert into mydb.Choroba_slownik values(" + j
//					+ "," + ");");
//		}
//	}
}
