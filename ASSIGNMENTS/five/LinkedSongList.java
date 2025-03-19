public class LinkedSongList {
	// DO NOT ADD ANY MORE FIELDS OR METHODS
	private SongNode head;
	
	public LinkedSongList() {
		head = null;
	}

	public void addFront (Song s) {
		SongNode n = new SongNode(s);
		n.next = head;
		head = n;
	}

	public void addBack (Song s){
		SongNode n = new SongNode(s);
		if (head == null) {
			head = n;
		} else {
			addBackRec(head, n);
		}
	}
	
	private void addBackRec(SongNode cur, SongNode n) {
		if (cur.next == null) {
			cur.next = n;
		} else {
			addBackRec(cur.next, n);
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Song get (int position) {
		return getRec(head, 0, position);
	}
	
	private Song getRec(SongNode cur, int i, int position) {
		if (i == position) {
			return cur.getData();
		} else {
			return getRec(cur.next, i+1, position);
		}
	}

	/* Purpose: create a string representation of list
	 * Parameters: nothing	 
	 * Returns: String - the string representation of the list
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			return "{" + toStringRec(head) + "}";
		}
	}
	
	private String toStringRec(SongNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		} else {
			return cur.getData().toString() + ", " + toStringRec(cur.next);
		}
	}

	/*
	 * Purpose: Insert all elements from array into this linked list
	 * Parameters: Song[] array - the elements to add to this list
	 * Returns void - nothing
	 */
	public void buildFromArray(Song[] array) {
		buildFromArrayRec(array, array.length-1);
	}
	
	private void buildFromArrayRec(Song[] array, int i) {
		if (i < 0) {
			return;
		} else {
			addFront(array[i]);
			buildFromArrayRec(array, i-1);
		}
	}
	

	/*
	 * Purpose: gets the total number of songs in this list
	 * Parameters: none
	 * Returns: int - the number of songs in this list
	 */
	public int countSongs() {
		return countSongsRec(0, head);
	}
	
	public int countSongsRec(int count, SongNode cur){
		if (isEmpty()){
			return count;
		}
		if (cur.next == null){
			return count+1;
		}
		else {
			return countSongsRec(count+1, cur.next);
		}

	}
		
	/*
	 * Purpose: gets the total duration of all songs in this list
	 * Parameters: none
	 * Returns: int - the total duration of all songs in this list
	 */
	public int totalDuration() {
		return totalDurationRec(0,head); 
	}
	
	public int totalDurationRec(int duration, SongNode cur){
		if (isEmpty()){
			return duration;
		}
		if (cur.next == null){
			return duration + cur.getData().getDuration();
		}
		else {
			return totalDurationRec(duration + cur.getData().getDuration(), cur.next);
		}
	}
	
	/*
	 * Purpose: counts the songs in this list by an artist with artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: int - number of songs by artistName
	 */
	public int countSongsByArtist(String artistName) {
		return countSongsByArtistRec(artistName,0,head);
	}

	public int countSongsByArtistRec(String name, int count, SongNode cur){
		if (isEmpty()){
			return count;
		}

		if (cur.next == null){
			if (name.equals(cur.getData().getArtist())){
				return count+1;
			}else{
				return count;
			}
		}else{
			if (name.equals(cur.getData().getArtist())){
				return countSongsByArtistRec(name, count+1, cur.next);
			}else{
				return countSongsByArtistRec(name,count,cur.next);
			}
		}

	}
	
	
	/*
	 * Purpose: determines whether this list contains a song by artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: boolean - true if a song by artistName is found
	 */
	public boolean containsArtist(String artistName) {
		return containsArtistRec(artistName, head);
	}

	public boolean containsArtistRec(String name, SongNode cur){
		if (isEmpty() || cur == null){
			return false;
		}
		if (cur.getData().getArtist().equals(name)){
			return true;
		}else{
			return containsArtistRec(name,cur.next);
		}
	}
	
	
	/*
	 * Purpose: gets the longest song in the list
	 * Parameters: none
	 * Returns Song - the longest song in the list
	 *                or null if the list is empty
	 */
	public Song longestSong() {
		if (isEmpty()){
			return null;
		}
		return longestSongRec(head,head.getData());
	}
	
	public Song longestSongRec(SongNode cur, Song longest){
		
		if (cur == null){
			return longest;
		}

		if (cur.getData().getDuration() > longest.getDuration()){
			longest = cur.getData();
			return longestSongRec(cur.next,longest);
		}else{
			return longestSongRec(cur.next,longest);
		}



	}
		
	/*
	 * Purpose: get the total duration of all songs in the list
	 *          before the first song by artistName
	 * Parameters: String artistName - the artist name to search for
	 * Returns int - the duration of all songs before the first
	 *               song by artistName, or -1 if no song by 
	 *               artistName is found.
	 */
	public int totalTimeUntilArtist(String artistName) {
		if (isEmpty() || !containsArtist(artistName)){
			return -1;
		}
		return totalTimeUntilArtistRec(artistName,0,head);
	}
	
	public int totalTimeUntilArtistRec(String name, int duration, SongNode cur){

		if (cur == null || cur.getData().getArtist().equals(name)){
			return duration;
		}else{
			return totalTimeUntilArtistRec(name, duration + cur.getData().getDuration(),cur.next);
		}
	}
}