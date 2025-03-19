public class A4Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main (String[] args)	{
		testCount = 0;
		testPassCount = 0;
		
		/* Part 1: Using the List ADT */		
		testCompetitorsCount();
		testCountScoresAboveX();
		testDistanceAway();
		testGetBestCompetitorName();
		testNumberTimesRecordBroken();
		testListOfRecordBreakers();
		
		/* Part 2: Implementing the Generic Stack ADT */
		testStackOperations();
		testStackIsGeneric();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	

	public static void testCompetitorsCount() {
		System.out.println("\nTesting competitorsCount...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.competitorsCount(list1);
		expected = 1;
		displayResults(result == expected, "competitorsCount(list1)");
		
		result = A4Exercises.competitorsCount(list2);
		expected = 4;
		displayResults(result == expected, "competitorsCount(list2)");
		
		result = A4Exercises.competitorsCount(list3);
		expected = 12;
		displayResults(result == expected, "competitorsCount(list3)");
		
		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs

	}
	
	
	public static void testCountScoresAboveX() {
		System.out.println("\nTesting countScoresAboveX...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		Competitor[] arr4 = {};

		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list4 = new ArrayList(arr4);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.countScoresAboveX(list1, 30);
		expected = 1;
		displayResults(result == expected, "countScoresAboveX(list1, 30)");
		result = A4Exercises.countScoresAboveX(list1, 40);
		expected = 0;
		displayResults(result == expected, "countScoresAboveX(list1, 40)");
		
		result = A4Exercises.countScoresAboveX(list2, 40);
		expected = 2;
		displayResults(result == expected, "countScoresAboveX(list2, 40)");
		result = A4Exercises.countScoresAboveX(list2, 50);
		expected = 1;
		displayResults(result == expected, "countScoresAboveX(list2, 50)");

		result = A4Exercises.countScoresAboveX(list2, 0);
		expected = 4;
		displayResults(result == expected, "countScoresAboveX(list2, 0)");
		
		result = A4Exercises.countScoresAboveX(list4, 40);
		expected = 0;
		displayResults(result == expected, "countScoresAboveX(list2, 0)");
		

		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs
		
	}


	public static void testDistanceAway() {
		System.out.println("\nTesting distanceAway...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		Competitor[] arr4 = {};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list4 = new ArrayList(arr4);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.distanceAway(list1, c1);
		expected = 0;
		displayResults(result==expected, "distanceAway(list1, c1)");
		
		result = A4Exercises.distanceAway(list2, c2);
		expected = 3;
		displayResults(result==expected, "distanceAway(list2, c2)");
		
		result = A4Exercises.distanceAway(list3, c3);
		expected = 2;
		displayResults(result==expected, "distanceAway(list3, c3)");

		result = A4Exercises.distanceAway(list2, c5);
		expected = -1;
		displayResults(result==expected, "distanceAway(list2, c5)");

		result = A4Exercises.distanceAway(list4, c5);
		expected = -1;
		displayResults(result==expected, "distanceAway(list4, c5)");

		result = A4Exercises.distanceAway(list3, c12);
		expected = 11;
		displayResults(result==expected, "distanceAway(list3, c3)");


		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs
		
	}
	

	public static void testGetBestCompetitorName() {
		System.out.println("\nTesting getBestCompetitorName...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		Competitor c13 = new Competitor("not luis", 88);
		Competitor c14 = new Competitor("still not luis", 88);
		Competitor c15 = new Competitor("definetly not luis", 88);




		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4};
		Competitor[] arr4 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		Competitor[] arr5 = {};
		Competitor[] arr6 = {c12,c13,c14,c15};
		Competitor[] arr7 = {c12,c12,c12,c12,c12,};



		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list4 = new ArrayList(arr4);
		List list5 = new ArrayList(arr5);
		List list6 = new ArrayList(arr6);
		List list7 = new ArrayList(arr7);


		
		String result = "";
		String expected = "";
		
		result = A4Exercises.getBestCompetitorName(list1);
		expected = "Ali";
		displayResults(result.equals(expected), "getBestCompetitorName(list1)");
		
		result = A4Exercises.getBestCompetitorName(list2);
		expected = "Jo";
		displayResults(result.equals(expected), "getBestCompetitorName(list2)");

		result = A4Exercises.getBestCompetitorName(list3);
		expected = "Jo";
		displayResults(result.equals(expected), "getBestCompetitorName(list3)");
		
		result = A4Exercises.getBestCompetitorName(list4);
		expected = "Ali";
		displayResults(result.equals(expected), "getBestCompetitorName(list3)");

		result = A4Exercises.getBestCompetitorName(list5);
		expected = "";
		displayResults(result.equals(expected), "getBestCompetitorName(list5)");

		result = A4Exercises.getBestCompetitorName(list6);
		expected = "Luis";
		displayResults(result.equals(expected), "getBestCompetitorName(list5)");

		result = A4Exercises.getBestCompetitorName(list7);
		expected = "Luis";
		displayResults(result.equals(expected), "getBestCompetitorName(list5)");
		
		// Write more of your own tests here
		
	}
	
	
	public static void testNumberTimesRecordBroken() {
		System.out.println("\nTesting numberTimesRecordBroken...");
		
		Competitor c1  = new Competitor("Ali",  37); // new record
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); // new record
		Competitor c4  = new Competitor("Jo",   53); // new record
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); // new record
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); // new record
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		Competitor c13 = new Competitor("not luis", 88);
		Competitor c14 = new Competitor("still not luis", 88);
		Competitor c15 = new Competitor("definetly not luis", 88);


		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		Competitor[] arr5 = {};
		Competitor[] arr6 = {c12,c13,c14,c15};
		Competitor[] arr7 = {c12,c12,c12,c12,c12,};
		Competitor[] arr8 = {c1,c2};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list5 = new ArrayList(arr5);
		List list6 = new ArrayList(arr6);
		List list7 = new ArrayList(arr7);
		List list8 = new ArrayList(arr8);

		
		int result = 0;
		int expected = 0;		
		
		result = A4Exercises.numberTimesRecordBroken(list1);
		expected = 1;
		displayResults(result==expected, "numberTimesRecordBroken(list1)");
		
		result = A4Exercises.numberTimesRecordBroken(list2);
		expected = 2;
		displayResults(result==expected, "numberTimesRecordBroken(list2)");
		System.out.println(result);

		result = A4Exercises.numberTimesRecordBroken(list3);
		expected = 5;
		displayResults(result==expected, "numberTimesRecordBroken(list3)");
		System.out.println(result);

		result = A4Exercises.numberTimesRecordBroken(list5);
		expected = 0;
		displayResults(result==expected, "numberTimesRecordBroken(list5)");

		result = A4Exercises.numberTimesRecordBroken(list6);
		expected = 1;
		displayResults(result==expected, "numberTimesRecordBroken(list6)");

		result = A4Exercises.numberTimesRecordBroken(list7);
		expected = 1;
		displayResults(result==expected, "numberTimesRecordBroken(list7)");

		result = A4Exercises.numberTimesRecordBroken(list8);
		expected = 1;
		displayResults(result==expected, "numberTimesRecordBroken(list8)");

		
		// Write more of your own tests here
		
	}

	private static boolean equal(String[] a1, String[] a2) {
		boolean equal = true;
		if ((a1 == null || a2 == null) && a1 != a2) { // one is null
			equal = false;
		} else if (a1.length != a2.length) { // different lengths
			equal = false;
		} else {
			int i = 0; 
			while (i < a1.length && equal == true) {
				if (!a1[i].equals(a2[i])) {
					equal = false;
				}
				i++;
			}
		}
		return equal;
	}

	public static void testListOfRecordBreakers() {
		System.out.println("\n Testing listOfRecordBreakers...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		Competitor c13 = new Competitor("not luis", 88);
		Competitor c14 = new Competitor("still not luis", 88);
		Competitor c15 = new Competitor("definetly not luis", 88);
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		Competitor[] arr5 = {};
		Competitor[] arr6 = {c12,c13,c14,c15};
		Competitor[] arr7 = {c12,c12,c12,c12,c12,};
		Competitor[] arr8 = {c1,c2};

		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list5 = new ArrayList(arr5);
		List list6 = new ArrayList(arr6);
		List list7 = new ArrayList(arr7);
		List list8 = new ArrayList(arr8);
		

		
		
		String[] result = null;
		String[] expected1 = {"Ali"};
		String[] expected2 = {"Ali", "Jo"};
		String[] expected3 = {"Ali", "Lee", "Jo", "Ola", "Ali"};
		String[] expected5 = {};
		String[] expected6 = {"Luis"};
		String[] expected7 = {"Luis"};
		String[] expected8 = {"Ali"};





		
		result = A4Exercises.listOfRecordBreakers(list1);
		displayResults(equal(result,expected1), "listOfRecordBreakers(list1)");
		
		result = A4Exercises.listOfRecordBreakers(list2);
		displayResults(equal(result,expected2), "listOfRecordBreakers(list2)");
		
		result = A4Exercises.listOfRecordBreakers(list3);
		displayResults(equal(result,expected3), "listOfRecordBreakers(list3)");

		result = A4Exercises.listOfRecordBreakers(list5);
		displayResults(equal(result,expected5), "listOfRecordBreakers(list5)");

		result = A4Exercises.listOfRecordBreakers(list6);
		displayResults(equal(result,expected6), "listOfRecordBreakers(list6)");

		result = A4Exercises.listOfRecordBreakers(list7);
		displayResults(equal(result,expected7), "listOfRecordBreakers(list7)");

		result = A4Exercises.listOfRecordBreakers(list8);
		displayResults(equal(result,expected8), "listOfRecordBreakers(list8)");
		
		// Write more of your own tests here
		
	}

	public static void testStackOperations() {
		System.out.println("\nTesting stack operations...");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		Integer result = 0;
		String expected_str = "{9, 6, 5, 2}";
		String expected_str2 = "{6, 5, 2}";
		String expected_str3 = "{5, 2}";
		String expected_str35 = "{2}";

		String expected_str4 = "{9, 2}";
		String expected_str5 = "{}";

		String result_str;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(2);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result.equals(2), "peek works after initial push");

		testStack.push(5);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(5), "peek works after push");

		testStack.push(6);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(6), "peek works after push");

		testStack.push(9);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(9), "peek works after push");

		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str), "stack right?");
		System.out.println(result_str);
		
		testStack.pop();
		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str2), "stack right?");
		System.out.println(result_str);

		testStack.pop();
		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str3), "stack right?");

		testStack.pop();
		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str35), "stack right?");

		testStack.pop();
		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str5), "stack right?");

		result = testStack.peek();
		displayResults(result==null, "peek works after push");

		result = testStack.pop();
		displayResults(result==null, "pop works after empty");

		testStack.push(2);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result.equals(2), "peek works after initial push");

		testStack.push(9);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(9), "peek works after push");

		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str4), "stack right?");

		testStack.popAll();
		result_str = testStack.toString();
		displayResults(testStack.isEmpty(), "empty");
		displayResults(result_str.equals(expected_str5), "stack right?");

		result_str = testStack.toString();
		displayResults(result_str.equals(expected_str5), "stack right?");

		testStack.push(2);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result.equals(2), "peek works after initial push");

		testStack.push(5);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(5), "peek works after push");

		testStack.push(6);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result.equals(6), "peek works after push");

		result = testStack.pop();
		displayResults(result==6, "pop works after empty");


		
		// Write more of your own tests here

	}
	
	public static void testStackIsGeneric() {
		System.out.println("\nTesting generics...");
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		String result2;
		String emptys = "{}";
		String expected2 = "{im eepy, world!, hello}";
		String expected22 = "{world!, hello}";


		Double result3;
		
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);
		
		result2 = s2.pop();
		result3 = s3.pop();
		
		//STRING
		displayResults(result2.equals("ENGR"), "String Stack");

		s2.popAll();
		result2 = s2.peek();
		displayResults(s2.isEmpty(), "stack not empty");
		displayResults(result2 == null, "peek works after push");
		result2 = s2.toString();
		displayResults(result2.equals(emptys), "peek works after push");
		System.out.println(result2);

		s2.push("hello");
		s2.push("world!");
		s2.push("im eepy");

		result2 = s2.toString();
		displayResults(result2.equals(expected2), "peek works after push");

		result2 = s2.pop();
		displayResults(result2.equals("im eepy"), "peek works after push");

		result2 = s2.toString();
		displayResults(result2.equals(expected22), "peek works after push");
		

		//DOUBLE

		displayResults(result3.equals(9.1), "Double Stack");		

		// Write more of your own tests here
			
	}
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed)	{
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}