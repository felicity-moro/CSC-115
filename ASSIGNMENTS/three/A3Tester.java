/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in A3LinkedList.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		testAddFront();
		 testAddBack();
		 testSizeAndIsEmpty();
		 testRemoveFront();
		 testRemoveBack();
		
		/* Part 2 */
		 testRemoveMiddle();
		testInterleave();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		System.out.println("\nTesting addFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		String result2;
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		System.out.println(result);

		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		System.out.println(result);

		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		displayResults(result.equals("{JAVA}"), "testAddFront");
		System.out.println(result);

		result = list1.backToFront();
		displayResults(result.equals("{AVAJ}"), "testAddFront");
		System.out.println(result);

		list2.addFront("E");
		list2.addFront("S");
		list2.addFront("U");
		list2.addFront("O");
		list2.addFront("M");
		list2.addFront(" ");
		list2.addFront("T");
		list2.addFront("A");
		list2.addFront("H");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{HAT MOUSE}"), "testAddFront");
		System.out.println(result2);

		result2 = list2.backToFront();
		displayResults(result2.equals("{ESUOM TAH}"), "testAddFront");
		System.out.println(result2);

	}
	
	public static void testAddBack() {
		System.out.println("\nTesting addBack...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");


		list2.addBack("snakes");
		list2.addBack(" ");
		list2.addBack("are");
		list2.addBack(" ");
		list2.addBack("rad");

		result = list2.frontToBack();
		displayResults(result.equals("{snakes are rad}"), "testAddBack");
		System.out.println(result);
		result = list2.backToFront();
		displayResults(result.equals("{rad are snakes}"), "testAddBack");
		System.out.println(result);




	}
	
	public static void testSizeAndIsEmpty() {
		System.out.println("\nTesting size and isEmpty...");
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		System.out.println("\nTesting removeFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		A3LinkedList list3 = new A3LinkedList();


		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");

		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		System.out.println(result);

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		System.out.println(result);

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");
		System.out.println(result);

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");
		System.out.println(result);

		list2.addFront("M");
		list2.addFront("m");
		list2.addFront("o");
		list2.addFront("O");
		list2.addFront("R");
		list2.addFront("V");

		result = list2.frontToBack();
		displayResults(result.equals("{VROomM}"), "testRemoveFront");
		System.out.println(result);

		list2.removeFront();
		result = list2.frontToBack();
		displayResults(result.equals("{ROomM}"), "testRemoveFront");
		System.out.println(result);

		list2.removeFront();
		result = list2.frontToBack();
		displayResults(result.equals("{OomM}"), "testRemoveFront");
		System.out.println(result);

		list2.removeFront();
		result = list2.frontToBack();
		displayResults(result.equals("{omM}"), "testRemoveFront");
		System.out.println(result);

		list3.removeFront();
		result = list3.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");
		System.out.println(result);

		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */
				
	}
	
	public static void testRemoveBack() {
		System.out.println("\nTesting removeBack...");
		
		System.out.println("\nTesting removeFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		A3LinkedList list3 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");

		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testremoveBack");
		System.out.println(result);

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testremoveBack");
		System.out.println(result);

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PI}"), "testremoveBack");
		System.out.println(result);

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{P}"), "testremoveBack");
		System.out.println(result);

		list2.addFront("M");
		list2.addFront("m");
		list2.addFront("o");
		list2.addFront("O");
		list2.addFront("R");
		list2.addFront("V");

		result = list2.frontToBack();
		displayResults(result.equals("{VROomM}"), "testRremoveBack");
		System.out.println(result);

		list2.removeBack();
		result = list2.frontToBack();
		displayResults(result.equals("{VROom}"), "testremoveBack");
		System.out.println(result);

		list2.removeBack();
		result = list2.frontToBack();
		displayResults(result.equals("{VROo}"), "testremoveBack");
		System.out.println(result);

		list2.removeBack();
		result = list2.frontToBack();
		displayResults(result.equals("{VRO}"), "testremoveBack");
		System.out.println(result);

		list3.removeBack();
		result = list3.frontToBack();
		displayResults(result.equals("{}"), "testremoveBack");
		System.out.println(result);

	}
	
	public static void testRemoveMiddle() {
		System.out.println("\nTesting removeMiddle...");
		
		A3LinkedList list1 = new A3LinkedList();
		String result1 = "";
		list1.addBack("T");
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("L");
		list1.addBack("E");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{TALE}"), "frontToBack after removeMiddle called on TABLE");
		System.out.println(result1);

		result1 = list1.backToFront();
		displayResults(result1.equals("{ELAT}"), "backToFront after removeMiddle called on TABLE");
		System.out.println(result1);
		
		list1 = new A3LinkedList();
		list1.addBack("B");
		list1.addBack("E");
		list1.addBack("T");
		list1.addBack("T");
		list1.addBack("E");
		list1.addBack("R");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{BEER}"), "frontToBack after removeMiddle called on BETTER");
		System.out.println(result1);

		result1 = list1.backToFront();
		displayResults(result1.equals("{REEB}"), "backToFront after removeMiddle called on BETTER");
		System.out.println(result1);

		list1 = new A3LinkedList();
		list1.addBack("A");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result1);
		result1 = list1.backToFront();
		
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 1");
		System.out.println(result1);
		// Write additional tests here to ensure all of your pointers
		// and other fields have been updated correctly.

		A3LinkedList list3 = new A3LinkedList();
		String result3 = "";
		list3.addBack("S");
		list3.addBack("O");
		list3.addBack("U");
		list3.addBack("P");
		list3.addBack("E");
		list3.addBack("R");
		
		result3 = list3.frontToBack();
		displayResults(result3.equals("{SOUPER}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result3);

		list3.removeMiddle();
		result3 = list3.frontToBack();
		displayResults(result3.equals("{SOER}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result3);

		list3.removeMiddle();
		result3 = list3.frontToBack();
		displayResults(result3.equals("{SR}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result3);

		A3LinkedList list35 = new A3LinkedList();
		String result35 = "";
		list35.addBack("S");
		list35.addBack("O");
		list35.addBack("U");
		list35.addBack("P");
		list35.addBack("E");
		list35.addBack("R");
		
		result35 = list35.backToFront();
		displayResults(result35.equals("{REPUOS}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result35);

		list35.removeMiddle();
		result35 = list35.backToFront();
		displayResults(result35.equals("{REOS}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result35);

		list35.removeMiddle();
		result35 = list35.backToFront();
		displayResults(result35.equals("{RS}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result35);

		A3LinkedList list4 = new A3LinkedList();
		String result4 = "";

		list4.removeMiddle();
		result4 = list4.frontToBack();
		displayResults(result4.equals("{}"), "frontToBack after removeMiddle called on length 1");
		System.out.println(result4);

				
	}
	
	
	public static void testInterleave() {
		System.out.println("\nTesting interleave...");
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		String result1 = "";
		String result2 = "";
		
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave, original first list is ABCDEFG");
		System.out.println(result1);
		

		list2.addBack("L");
		list2.addBack("M");
		list2.addBack("N");
		list2.addBack("O");
		list2.addBack("P");
		list2.addBack("Q");
		list2.addBack("R");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave, original second list is LMNOPQR");
		System.out.println(result2);
		
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "after interleave, first list now contains AMCOEQG");
		System.out.println(result1);

		displayResults(result2.equals("{LBNDPFR}"), "after interleave, second list now contains LBNDPFR");
		System.out.println(result2);


		result1 = list1.backToFront();
		result2 = list2.backToFront();

		displayResults(result1.equals("{GQEOCMA}"), "after interleave, first list now contains GQEOCMA");
		System.out.println(result1);

		displayResults(result2.equals("{RFPDNBL}"), "after interleave, second list now contains RFPDNBL");
		System.out.println(result2);

		A3LinkedList list3 = new A3LinkedList();
		A3LinkedList list4 = new A3LinkedList();
		String result3 = "";
		String result4 = "";

		list3.addBack("H");
		list3.addBack("H");
		list3.addBack("H");
		list3.addBack("H");
		list3.addBack("H");
		list3.addBack("H");

		list4.addBack("A");
		list4.addBack("A");
		list4.addBack("A");
		list4.addBack("A");
		list4.addBack("A");
		list4.addBack("A");

		list4.interleave(list3);

		result3 = list3.frontToBack();
		result4 = list4.frontToBack();
		displayResults(result4.equals("{AHAHAH}"), "after interleave, first list now contains AHAHAH");
		System.out.println(result4);

		displayResults(result3.equals("{HAHAHA}"), "after interleave, second list now contains HAHAHA");
		System.out.println(result3);

		A3LinkedList list5 = new A3LinkedList();
		A3LinkedList list6 = new A3LinkedList();
		String result5 = "";
		String result6 = "";

		list5.addBack("C");
		list5.addBack("C");

		list6.addBack("D");
		list6.addBack("D");
		
		list5.interleave(list6);

		result5 = list5.frontToBack();
		result6 = list6.frontToBack();
		displayResults(result5.equals("{CD}"), "after interleave, first list now contains CD");
		System.out.println(result5);

		displayResults(result6.equals("{DC}"), "after interleave, second list now contains DC");
		System.out.println(result6);

		A3LinkedList list7 = new A3LinkedList();
		A3LinkedList list8 = new A3LinkedList();
		String result7 = "";
		String result8 = "";

		list7.interleave(list8);

		result7 = list7.frontToBack();
		result8 = list8.frontToBack();
		displayResults(result7.equals("{}"), "after interleave, first list now contains NUIN");
		System.out.println(result7);

		displayResults(result8.equals("{}"), "after interleave, second list now contains NUIN");
		System.out.println(result8);






		



		// Write additional tests here to ensure all of your pointers
		// have been updated correctly.
		
	}
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
