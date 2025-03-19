/*
* Lab6Tester.java
*/
public class Lab5Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main (String[] args) {
		
		try {
			testBasicStack();
			testStackUseFunctions();
			testQueue();
		} catch (Exception e) {
			System.out.println("Your code threw an Exception.");
			System.out.println("Perhaps a stack trace will help:");
			e.printStackTrace(System.out);
		}
		System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
	}

	/*
	 * Purpose: reverses given string following this algorithm
	 *  - pushes each character in str onto a new stack
	 *  - creates a new empty result String
	 *  - pops each character off the Stack adding it to the result String
	 *  - returns the result String
	 * Parameters: String str - the String to reverse
	 * Returns: String - the reversed result String
	 */
	public static String reverseString(String str) {
		Stack stk = new StackArrayBased();
		String result = "";

		if (str.length() == 0){
			return result;
		}

		for (int i = 0; i < str.length(); i++){
			stk.push(str.charAt(i));
		}

		System.out.println(stk);

		for (int i = 0; i < str.length(); i++){

			char letter = stk.pop();
			result = result + letter;

		}

		return result;
	}

	/*
	 * Purpose: determines whether every '(' has a matching ')'
	 *          found later in the string. Any ')' that does not
	 *          have a preceding '(' means the brackets do not match
	 * Parameters: String str - the String to check for a bracket match
	 * Returns: boolean - true if brackets are matched, false otherwise
	 */
	public static boolean doBracketsMatch(String str) {
		Stack stk = new StackArrayBased();
		

		if (str.length() == 0){
			return true;
		}

		for (int i = 0; i < str.length(); i++){
			stk.push(str.charAt(i));
		}

		char val;
		int open = 0;
		int falopen = 0;
		int close = 0;
		boolean ret = false;

		for (int i = 0; i < str.length(); i++){

			val = stk.pop();

			if (val == ')'){
				close++;
			}

			if ((val == '(') && (close > 0) ){
				open++;
			}

			if (val == '('){
				falopen++;
			}

			
			if (open == close){
				ret = true;
			}else{
				ret = false;
			}

			if (falopen != open){
				ret = false;
			}

			}
		
		return ret;
	}

	public static void testBasicStack() {
		System.out.println("testBasicStack: start");

		StackArrayBased s = new StackArrayBased();
		int subtestSize = 10;
		boolean subtestResult = false;
		char result;

		displayResults(s.isEmpty(), "isEmpty on empty stack");
		displayResults(s.size() == 0, "size on empty stack");
		s.push('a');
		s.push('b');
		displayResults(!s.isEmpty(), "isEmpty - stack with one element");
		displayResults(s.size() == 2, "size - stack with one element");

		result = s.top();
		displayResults(result=='b', "top of stack");
		result = s.pop();
		displayResults(result=='b', "popped from stack");
		result = s.top();
		displayResults(result=='a', "top of stack after pop");
		s.pop();
		displayResults(s.isEmpty(), "isEmpty on empty stack");
		displayResults(s.size() == 0, "size on empty stack");

		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "isEmpty - stack with multiple elements");
		displayResults(s.size() == subtestSize, "size - stack with multiple elements");

		subtestResult = true;
		for (int i = subtestSize - 1; i >= 0; i--) {
			char ii = s.pop();
			subtestResult = subtestResult && (ii == (char)(i+'0'));
		}
		displayResults(subtestResult, "pop - stack with multiple elements");
		displayResults(s.isEmpty(), "isEmpty - after pop");
		displayResults(s.size() == 0, "size - after pop");

		s.push('a');
		s.push('b');
		s.push('c');
		displayResults(!s.isEmpty(), "isEmpty - after 3 pushes");
		displayResults(s.size() == 3, "size - after 3 pushes");
		s.makeEmpty();
		displayResults(s.isEmpty(), "isEmpty - after makeEmpty");
		displayResults(s.size() == 0, "size - after makeEmpty");

		System.out.println("testBasicStack: end");
		System.out.println();
	}

	public static void testStackUseFunctions() {
		System.out.println("testStackUseFunctions: start");
		String resultString = "";
		String expected = "";

		resultString = reverseString("");
		expected = "";
		displayResults(resultString.equals(expected), "reverse empty String");
		System.out.println(resultString);

		resultString = reverseString("abc");
		expected = "cba";
		displayResults(resultString.equals(expected), "reverse odd-length string");
		System.out.println(resultString);

		resultString = reverseString("hotdog");
		expected = "godtoh";
		displayResults(resultString.equals(expected), "reverse even-length string");
		System.out.println(resultString);

		resultString = reverseString("1 2 3 4");
		expected = "4 3 2 1";
		displayResults(resultString.equals(expected), "reverse spaced number string");
		System.out.println(resultString);

		resultString = reverseString("defg");
		expected = "gfed";
		displayResults(resultString.equals(expected), "reverse even-length string");
		System.out.println(resultString);



		boolean matched;
		matched = doBracketsMatch("");
		displayResults(matched, "doBracketsMatch empty String");
		System.out.println(matched);

		matched = doBracketsMatch("abc");
		displayResults(matched, "doBracketsMatch no brackets");
		System.out.println(matched);

		matched = doBracketsMatch("(abc");
		displayResults(!matched, "doBracketsMatch one open no close");
		System.out.println(matched);

		matched = doBracketsMatch("abc)");
		displayResults(!matched, "doBracketsMatch close without preceding open");
		System.out.println(matched);

		matched = doBracketsMatch("(abc)");
		displayResults(matched, "doBracketsMatch one each");
		System.out.println(matched);

		matched = doBracketsMatch("(a(bc))");
		displayResults(matched, "doBracketsMatch two each");
		System.out.println(matched);
		
		matched = doBracketsMatch("(a)bc)(");
		displayResults(!matched, "doBracketsMatch two each, but not in correct order");
		System.out.println(matched);

		matched = doBracketsMatch("(lm(def)))");
		displayResults(!matched, "doBracketsMatch more close");
		System.out.println(matched);
		
		matched = doBracketsMatch("(qr(((stu(v)w)");
		displayResults(!matched, "doBracketsMatch more open");
		System.out.println(matched);

		matched = doBracketsMatch("()qr(((stu(v)w))()x)");
		displayResults(matched, "doBracketsMatch many open and close");
		System.out.println(matched);
		
		System.out.println("testStackUseFunctions: end");
		System.out.println();
	}

	public static void testQueue() {
		System.out.println("testBasicQueue: start");

		Queue q = new QueueRefBased();
		int subtestSize;
		boolean subtestResult;

		displayResults(q.isEmpty(), "isEmpty on empty queue");
		displayResults(q.size() == 0, "size on empty queue");

		q.enqueue(10);
		displayResults(!q.isEmpty(), "isEmpty - queue with one element");
		displayResults(q.size() == 1, "size - queue with one element");

		int first = q.peek();
		System.out.println(first);
		displayResults(first==10 , "peeking at item at front of queue");
		first = q.dequeue();
		displayResults(first==10, "dequeuing item from front of queue");
		displayResults(q.isEmpty(), "isEmpty after dequeue");
		displayResults(q.size() == 0, "size after dequeue");

		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		displayResults(!q.isEmpty(), "isEmpty - queue with multiple elements");
		displayResults(q.size() == subtestSize, "size - queue with multiple elements");

		subtestResult = true;
		for (int i = 0; i < subtestSize; i++) {
			int removed = q.dequeue();
			subtestResult = subtestResult && removed==i;
		}
		displayResults(subtestResult, "dequeue - queue with multiple elements");
		displayResults(q.isEmpty(), "isEmpty - after dequeue");
		displayResults(q.size() == 0, "size - after dequeue");

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		displayResults(q.size() == 3, "size - after three enqueues");
		q.makeEmpty();
		displayResults(q.size() == 0, "size - after makeEmpty");
		
		q.enqueue(5);
		displayResults(q.size() == 1, "size - after makeEmpty then enqueue");
		first = q.peek();
		displayResults(first==5, "peek after enqueue");
		first = q.dequeue();
		displayResults(first==5, "value returned from dequeue");
		displayResults(q.size() == 0, "size - after makeEmpty");

		System.out.println("testing Queue: end");
		System.out.println();
		
	}

	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}
