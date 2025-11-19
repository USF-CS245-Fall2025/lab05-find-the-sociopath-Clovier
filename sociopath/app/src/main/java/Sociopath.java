package app.src.main.java;
import java.util.List;

/**
 * @author Ty Van Heerden
 * @since Nov. 14, 2025
 * @version 1.0
 * 
 * [1,7] -> person 1 likes person 7
 * [2,7] -> person 2 likes person 7
 * [3,7] -> person 3 likes person 7
 * 
 * directed unweighted graph
 * 2d array
 */

public class Sociopath {

	/**
	 * returns the sociopath in the group
	 * Each pair in likeList [a, b] represents that a likes b
	 * A sociopath means that it likes no one, but is liked by everyone else
	 *
	 * If the input is invalid, or if no sociopath exists, the method will return -1
	 *
	 * @param groupSize the number of people in the group
	 * @param likeList the list of pairs meaning that [a,b] a likes be
	 * @return the sociopath's number, or -1 if the sociopath doesn't exist, or if the input is invalid
	 */
	public int findTheSociopath (int groupSize, List<int []> likeList) {
		if (groupSize <= 0){
			return -1;
		}

		int[][] edges = new int[groupSize + 1][2];

		for (int[] likePair : likeList){
			int outgoingEdge = likePair[0];
			int incomingEdge = likePair[1];

			if (outgoingEdge == 0 || outgoingEdge > groupSize || incomingEdge == 0 || incomingEdge > groupSize){
				return -1;
			}

			edges[outgoingEdge][1]++;
			edges[incomingEdge][0]++;
		}

		int target = -1;

		for (int i = 1; i <= groupSize; i++){
			int incoming = edges[i][0];
			int outgoing = edges[i][1];

			if (incoming == groupSize - 1 && outgoing == 0){
				if (target != -1){
					return -1;
				}
				target = i;
			}
		}
		return target;
	}
}
