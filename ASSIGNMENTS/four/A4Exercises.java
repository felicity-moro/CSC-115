public class A4Exercises {

	/*
	 * Purpose: gets the number of competitors in the given list
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number of competitors in the given list
	 */
	public static int competitorsCount(List cList) {
		return cList.size();
	}
	
	/*
	 * Purpose: gets the number of competitors with a score above x
	 * Parameters: List cList - the list of competitors
	 *             int x - the threshold competitors must score more than
	 * Returns: int - the number competitors with a score above x
	 */
	public static int countScoresAboveX(List cList, int x) {
		int count = 0;
		for(int i = 0; i < competitorsCount(cList);i++){
			if (cList.get(i).getScore() > x){
				count++;
			}
		}
		return count; 
	}
	
	/*
	 * Purpose: get the number of competitors into the list c is
	 * Parameters: List cList - the list of competitors
	 *             Competitor c - the competitor to find
	 * Returns: int - the distance the first occurrence of 
	 *                c is from the start of the list, or 
	 *                -1 if c is not found in cList
	 */
	public static int distanceAway(List cList, Competitor c) {
		int count = 0;
		for(int i = 0; i < competitorsCount(cList);i++){
			if (cList.get(i) == c){
				return count;
			}else{
				count++;
			}
		}
		return -1; 
	}
	
	/*
	 * Purpose: get the name of the competitor with the highest score
	 * Parameters: List cList - the list of competitors
	 * Returns: String - the name of the competitor with the highest
	 *                   score, or "" if the list is empty
	 *
	 * Note: if two or more competitors are tied with the highest 
	 *       score, the name of the competitor who comes first in the
	 *       list among those who are tied is returned
	 */
	public static String getBestCompetitorName(List cList) {

		if (competitorsCount(cList) == 0){
			return "";
		}

		Competitor winner = cList.get(0);

		for (int i = 0; i < competitorsCount(cList); i++){
			if (cList.get(i).getScore() > winner.getScore()){
				winner = cList.get(i);
			}
		}
		return winner.getName();
	}

	/*
	 * Purpose: get the number of times a new highest score
	 *          in the list of competitors is found
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number times a new highest score is
	 *                found when traversing from left to right
	 *                through the list of competitors
	 * 
	 * Note: Read through the assignment PDF for more information
	 */
	public static int numberTimesRecordBroken(List cList) {

		if (competitorsCount(cList) == 0){
			return 0;
		}

		int counter = 1; 
		int highest = cList.get(0).getScore();

		for (int i = 1; i < competitorsCount(cList); i++){
			if (cList.get(i).getScore() > highest){
				counter++;
		    	highest = cList.get(i).getScore();
			}
		}
		return counter;
	}
		
	/*
	 * Purpose: get names of all the competitors who had
	 *          the highest score seen so far at some point
	 * Parameters: List cList - the list of competitors
	 * Returns: String[] - the names of competitors who had 
	 *                     the highest score seen so far
	 *                     at some point while traversing 
	 *                     the list from left to right
	 */
	public static String[] listOfRecordBreakers(List cList) {

		String[] winners = new String[numberTimesRecordBroken(cList)];

		if (competitorsCount(cList) == 0){
			return winners;
		}

		Competitor highest = cList.get(0);
		winners[0] = cList.get(0).getName();
		int j = 1;

		for (int i = 1; i < competitorsCount(cList); i++){
			if (cList.get(i).getScore() > highest.getScore()){

		    	highest = cList.get(i);
				winners[j] = cList.get(i).getName();
				j++;
				
			}
		}
		return winners;
	}

}