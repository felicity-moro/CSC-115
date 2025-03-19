
/*
 * A3Grader
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Grader {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		// Uncomment each method one at a time, 
		// and implement the method in A3LinkedList.java 
		// until all tests pass. It is strongly
		// recommended that you add additional tests 
		// to ensure the correctness of your implementation.
		
		testAddFront();
		testAddBack();
		testAddBoth();
		//testRemoveFront();
		testRemoveBack();
		testSizeAndIsEmpty();
		
		testRemoveMiddle();
		testInterleave();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		System.out.println("\nTesting addFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addFront("S");
		list1.addFront("C");
		list1.addFront("I");
		list1.addFront("E");
		list1.addFront("N");
		list1.addFront("C");
		list1.addFront("E");
		
		result = list1.frontToBack();
		displayResults(result.equals("{ECNEICS}"), "testAddFront1");
		result = list1.backToFront();
		displayResults(result.equals("{SCIENCE}"), "testAddFront2");
		
	}
	
	public static void testAddBack() {
		System.out.println("\nTesting addBack...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("L");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		list1.addBack("E");
		list1.addBack("D");
		
		result = list1.frontToBack();
		displayResults(result.equals("{LINKED}"), "testAddBack1");
		result = list1.backToFront();
		displayResults(result.equals("{DEKNIL}"), "testAddBack2");
	
	}
	
	public static void testAddBoth() {
		System.out.println("\nTesting addBoth...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("K");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("G");
		list1.addFront("R");
		list1.addFront("O");
		list1.addFront("W");
		
		result = list1.frontToBack();
		displayResults(result.equals("{WORKING}"), "testAddBoth1");
		result = list1.backToFront();
		displayResults(result.equals("{GNIKROW}"), "testAddBoth2");
		
		
		A3LinkedList list2 = new A3LinkedList();
		
		list2.addFront("S");
		list2.addFront("E");
		list2.addFront("T");
		list2.addBack("T");
		list2.addBack("I");
		list2.addBack("N");
		list2.addBack("G");
		
		result = list2.frontToBack();
		displayResults(result.equals("{TESTING}"), "testAddBoth3");
		result = list2.backToFront();
		displayResults(result.equals("{GNITSET}"), "testAddBoth4");
	}
		
	public static void testRemoveFront() {
		System.out.println("\nTesting removeFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addFront("A");
		list1.addFront("B");
		list1.addFront("C");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{BA}"), "testRemoveFront1");
		result = list1.backToFront();
		displayResults(result.equals("{AB}"), "testRemoveFront2");
		
		list1.removeFront();
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront3");
		result = list1.backToFront();
		displayResults(result.equals("{}"), "testRemoveFront4");
		
		
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{EF}"), "testRemoveFront5");
		result = list1.backToFront();
		displayResults(result.equals("{FE}"), "testRemoveFront6");
		
		list1.removeFront();
		list1.removeFront();
		list1.addFront("G");
		list1.addBack("H");
		list1.addFront("I");
		list1.addBack("J");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{GHJ}"), "testRemoveFront7");
		result = list1.backToFront();
		displayResults(result.equals("{JHG}"), "testRemoveFront8");
	}
		
	public static void testRemoveBack() {
		System.out.println("\nTesting removeBack...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addFront("A");
		list1.addFront("B");
		list1.addFront("C");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{CB}"), "testRemoveBack1");
		result = list1.backToFront();
		displayResults(result.equals("{BC}"), "testRemoveBack2");
		
		list1.removeBack();
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack3");
		result = list1.backToFront();
		displayResults(result.equals("{}"), "testRemoveBack4");
		

		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{DE}"), "testRemoveBack5");
		result = list1.backToFront();
		displayResults(result.equals("{ED}"), "testRemoveBack6");
		
		list1.removeBack();
		list1.removeBack();
		list1.addFront("G");
		list1.addBack("H");
		list1.addFront("I");
		list1.addBack("J");
		list1.removeBack();
		
		result = list1.frontToBack();
		displayResults(result.equals("{IGH}"), "testRemoveBack7");
		result = list1.backToFront();
		displayResults(result.equals("{HGI}"), "testRemoveBack8");
	}
	
	public static void testSizeAndIsEmpty() {
		System.out.println("\nTesting size and isEmpty...");
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty1");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty2");
		
		list1.addFront("C");
		result = list1.size();
		displayResults(result==1, "testSizeAndIsEmpty3");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty4");
		
		list1.removeFront();
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty5");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty6");
		
		list1 = new A3LinkedList();
		list1.addFront("S");
		result = list1.size();
		displayResults(result==1, "testSizeAndIsEmpty7");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty8");
		
		list1.removeBack();
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty9");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty10");
		
		list1 = new A3LinkedList();
		list1.addBack("U");
		result = list1.size();
		displayResults(result==1, "testSizeAndIsEmpty11");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty12");
		
		list1.removeFront();
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty13");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty14");
		
		list1 = new A3LinkedList();
		list1.addBack("S");
		result = list1.size();
		displayResults(result==1, "testSizeAndIsEmpty15");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty16");
		
		list1.removeBack();
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty17");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty18");
		
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addFront("B");
		list1.addFront("C");
		list1.addFront("D");
		list1.addBack("E");
		
		result = list1.size();
		displayResults(result==5, "testSizeAndIsEmpty19");
		list1.removeBack();
		list1.removeBack();
		list1.removeBack();
		list1.removeFront();
		result = list1.size();
		displayResults(result==1, "testSizeAndIsEmpty20");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty21");
		
		list1.removeBack();
		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty22");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty23");
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
		result1 = list1.backToFront();
		displayResults(result1.equals("{ELAT}"), "backToFront after removeMiddle called on TABLE");
		
		
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
		result1 = list1.backToFront();
		displayResults(result1.equals("{REEB}"), "backToFront after removeMiddle called on BETTER");
		
		list1 = new A3LinkedList();
		list1.addBack("A");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 1");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 1");
		
		// Write additional tests here to ensure all of your pointers
		// and other fields have been updated correctly.
		
		list1 = new A3LinkedList();

		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on empty list");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on empty list");
		
		
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("Z");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 2");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 2");
		displayResults(list1.size()==0, "size after removeMiddle called on length 2");
		
		
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("Z");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 2");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 2");
		displayResults(list1.size()==0, "size after removeMiddle called on length 2");
		
		
		list1 = new A3LinkedList();
		list1.addBack("M");
		list1.addBack("A");
		list1.addBack("P");
		list1.addBack("L");
		list1.addBack("E");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{MALE}"), "frontToBack after removeMiddle called on MAPLE");
		result1 = list1.backToFront();
		displayResults(result1.equals("{ELAM}"), "backToFront after removeMiddle called on MAPLE");
		displayResults(list1.size()==4, "size after removeMiddle called on length 5");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{ME}"), "frontToBack after removeMiddle called on MALE");
		result1 = list1.backToFront();
		displayResults(result1.equals("{EM}"), "backToFront after removeMiddle called on MALE");
		displayResults(list1.size()==2, "size after removeMiddle called on length 4");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on empty");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on empty");
		displayResults(list1.size()==0, "size after removeMiddle called on length 2");
		
		
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
		
		list2.addBack("L");
		list2.addBack("M");
		list2.addBack("N");
		list2.addBack("O");
		list2.addBack("P");
		list2.addBack("Q");
		list2.addBack("R");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave, original second list is LMNOPQR");
		
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "after interleave, first list now contains AMCOEQG");
		displayResults(result2.equals("{LBNDPFR}"), "after interleave, second list now contains LBNDPFR");

		// Write additional tests here to ensure all of your pointers
		// have been updated correctly.
		
		list1 = new A3LinkedList();
		list2 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");
		list2.addBack("W");
		list2.addBack("X");
		
		try{
			list1.interleave(list2);
			result1 = list1.frontToBack();
			result2 = list1.backToFront();
			displayResults(result1.equals("{AX}"), "testInterleave first list frontToBack size 2");
		}catch(Exception e){
			displayResults(false, "testInterleave first list frontToBack size 2");
		}
		try{
			displayResults(result2.equals("{XA}"), "testInterleave first list backToFront size 2");
		}catch(Exception e){
			displayResults(false, "testInterleave first list backToFront size 2");
		}
		
		try{
			result1 = list2.frontToBack();
			result2 = list2.backToFront();
			displayResults(result1.equals("{WB}"), "testInterleave second list frontToBack size 2");
		}catch(Exception e){
			displayResults(false, "testInterleave second list frontToBack size 2");
		}
		try{
			displayResults(result2.equals("{BW}"), "testInterleave second list backToFront size 2");
		}catch(Exception e){
			displayResults(false, "testInterleave second list backToFront size 2");
		}

		A3LinkedList list3 = new A3LinkedList();
		A3LinkedList list4 = new A3LinkedList();
		list3.addBack("A");
		list3.addBack("B");
		list3.addBack("C");
		list3.addBack("D");
		list4.addBack("W");
		list4.addBack("X");
		list4.addBack("Y");
		list4.addBack("Z");

		try{
			list4.interleave(list3);
			result1 = list3.frontToBack();
			result2 = list3.backToFront();
			displayResults(result1.equals("{AXCZ}"), "testInterleave first list frontToBack size 4");
		}catch(Exception e){
			displayResults(false, "testInterleave first list frontToBack size 4");
		}
		try{
			displayResults(result2.equals("{ZCXA}"), "testInterleave first list backToFront size 4");
		}catch(Exception e){
			displayResults(false, "testInterleave first list backToFront size 4");
		}
		
		try{
			result1 = list4.frontToBack();
			result2 = list4.backToFront();
			displayResults(result1.equals("{WBYD}"), "testInterleave second list frontToBack size 4");
		}catch(Exception e){
			displayResults(false, "testInterleave second list frontToBack size 4");
		}
		try{
			displayResults(result2.equals("{DYBW}"), "testInterleave second list backToFront size 4");
		}catch(Exception e){
			displayResults(false, "testInterleave second list backToFront size 4");
		}
		
		
		A3LinkedList list5 = new A3LinkedList();
		A3LinkedList list6 = new A3LinkedList();
		list5.addBack("A");
		list5.addBack("B");
		list5.addBack("C");
			
		list6.addBack("V");
		list6.addBack("W");
		list6.addBack("X");

		try{
			list5.interleave(list6);
			result1 = list5.frontToBack();
			result2 = list5.backToFront();
			displayResults(result1.equals("{AWC}"), "testInterleave first list frontToBack size 3");
		}catch(Exception e){
			displayResults(false, "testInterleave9");
		}try{
			displayResults(result2.equals("{CWA}"), "testInterleave first list backToFront size 3");
		}catch(Exception e){
			displayResults(false, "testInterleave10");
		}
		try{
			result1 = list6.frontToBack();
			result2 = list6.backToFront();
			displayResults(result1.equals("{VBX}"), "testInterleave second list frontToBack size 3");
		}catch(Exception e){
			displayResults(false, "testInterleave second list frontToBack size 3");
		}
		try{
			displayResults(result2.equals("{XBV}"), "testInterleave second list backToFront size 3");
		}catch(Exception e){
			displayResults(false, "testInterleave second list backToFront size 3");
		}

		A3LinkedList list7 = new A3LinkedList();
		A3LinkedList list8 = new A3LinkedList();
		list7.addBack("A");
		list7.addBack("B");
		list7.addBack("C");
		list7.addBack("D");
		list7.addBack("E");
		
		list8.addBack("V");
		list8.addBack("W");
		list8.addBack("X");
		list8.addBack("Y");
		list8.addBack("Z");
		
		try{
			list8.interleave(list7);
			result1 = list7.frontToBack();
			result2 = list7.backToFront();
			displayResults(result1.equals("{AWCYE}"), "testInterleave first list frontToBack size 5");
		}catch(Exception e){
			displayResults(false, "testInterleave first list frontToBack size 5");
		}
		try{
			displayResults(result2.equals("{EYCWA}"), "testInterleave first list backToFront size 5");
		}catch(Exception e){
			displayResults(false, "testInterleave first list backToFront size 5");
		}
		
		try{
			result1 = list8.frontToBack();
			result2 = list8.backToFront();
			displayResults(result1.equals("{VBXDZ}"), "testInterleave second list frontToBack size 5");
		}catch(Exception e){
			displayResults(false, "testInterleave second list frontToBack size 5");
		}try{
			displayResults(result2.equals("{ZDXBV}"), "testInterleave second list backToFront size 5");
		}catch(Exception e){
			displayResults(false, "testInterleave second list backToFront size 5");
		}

	}
	
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}
