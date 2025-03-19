public class A5Exercises {

	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	public static<T> void changeXToY(List<T> theList, T x, T y) {
		changeXToYRec(theList, x, y, 0);
	}
	public static<T> void changeXToYRec(List<T> list, T x, T y, int position){
		if (position == list.size()){
			return;
		}
		if (list.get(position).equals(x)){
			list.change(position,y);
			}
		changeXToYRec(list, x, y, position+1);
	}
	
	/*
	 * Purpose: count the total number of odd values in this list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the total number of odd values found
	 */
	public static int countOdd(List<Integer> theList) {
		if (theList.size() == 0){
			return 0;
		}
		return countOddRec(theList,0,0);
	}

	public static int countOddRec(List<Integer> list, int position, int count){
		if (position == list.size()){
			return count;
		}
		if (list.get(position)%2 != 0){
			return countOddRec(list,position+1,count+1);
		}else{
			return countOddRec(list,position+1,count);
		}
	}
	

	/*
	 * Purpose: get the largest sequence of odd values found in a row
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the largest sequence of odd values found in a row
	 */
	public static int countMostOddInARow(List<Integer> theList) {
		if (countOdd(theList) == 0 || theList.size() < 0){
			return 0;
		}
		return countMostOddInARowRec(theList,0,0,0);
	}

	public static int countMostOddInARowRec(List<Integer> list, int count,int position,int highest){
		if (count > highest){
			highest = count;
		}
		if (position == list.size()){
			return highest;
		}else{
			if (list.get(position)%2 != 0){
				return countMostOddInARowRec(list,count+1,position+1,highest);
			}else{
				return countMostOddInARowRec(list,0,position+1,highest);
			}
		}
	}
	
	
	/*
	 * Purpose: count the elements found in between the first two x's
	 * Parameters: List<Integer> theList - the list of Integers
	 *             int x - the values to search for
	 * Returns: int - the number of values in the list found 
	 *                between the first 2 occurrences if x,
	 *                or -1 if there are not 2 x's in the list.
	 */
	public static int countBetweenX(List<Integer> theList, int x){

		if (theList.size()==0){
			return -1;
		}

		boolean inx = false;
		if (theList.get(0) == x){
			inx = true;
		}
		
		return countBetweenXRec(theList, x,1,0,inx);
	}
	
	public static int countBetweenXRec(List<Integer> list, int x, int position,int count,boolean inx){

		if (position == list.size()){
			return -1;
		}else if ((list.get(position) == x) && inx){
			return count;
		}else if ((list.get(position) == x) && !inx){
			return countBetweenXRec(list,x,position+1,count,true);
		}else if (!inx){
			return countBetweenXRec(list,x,position+1,count,false);
		}else{
			return countBetweenXRec(list,x,position+1,count+1,true);
		}
	}
}