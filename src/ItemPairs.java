/*
 * ItemPairs.java
 * 
 * Version: $Id: ItemPairs.java, v 1.1 2015/12/02 23:21:12
 * 
 * Revisions: 
 * 		
 * Initial Revision
 * 
 */

/**
 * To find the potential products to display on the store's endcaps 
 * from a given file of transaction data of a grocery store
 *
 * @author Sanika Kulkarni
 * @author Asavari Karandikar
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ItemPairs {

	// Arraylist to store the itempair that should be in endcaps
	static ArrayList<String> itemPair = new ArrayList<String>();
	static int x = 0;

	/**
	 * The main method
	 * 
	 * @param args
	 */
	public static void main(String args[]) throws IOException {
		// variable to store input filename
		String file = args[0];
		String line = null;
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// read the entire file
		while ((line = bufferedReader.readLine()) != null) {

			// get items from a transaction in the file
			String temp = line.split(",")[1];
			String temp1 = temp.split("]")[0];
			String temp2 = temp1.trim();
			String temp3[] = temp2.split(" ");

			// to go through each item in the transaction
			for (int i = 0; i < temp3.length; i++) {

				// to avoid duplicate pairs
				for (int j = i + 1; j < temp3.length; j++) {
					String concat = temp3[i] + "/" + temp3[j];
					String concat1 = temp3[j] + "/" + temp3[i];

					// to add an itempair in the same order
					if ((temp3[i].compareTo(temp3[j])) < 0) {

						// add the itempair in the arraylist
						itemPair.add(concat);
					} else {
						itemPair.add(concat1);
					}
				}
			}
		}

		bufferedReader.close();

		// to get the count of item pair
		Set<String> countItemPair = new HashSet<String>(itemPair);
		for (String count : countItemPair) {

			// display only those itempairs that have count greater than 650
			if (Collections.frequency(itemPair, count) > 650) {
				x++;
				System.out.println(count);
			}

		}
		System.out.println(x);

	}

}
