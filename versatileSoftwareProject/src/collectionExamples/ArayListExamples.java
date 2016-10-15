package collectionExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ArayListExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Array List
		// Resizable arrays
		// List<String> names=new ArrayList<String>();
		// names.add("Raaj");
		// names.add("Kal");
		// names.add("Adtrian");
		// names.add("Ranjith");
		//
		// System.out.println(names);
		// System.out.println(names.get(3));
		// System.out.println(names.contains("Subra"));
		//

		// // Set collections
		// Set<String> players=new HashSet<String>();
		// Set<String> playersFootbal=new HashSet<String>();
		// playersFootbal.add("D");
		// playersFootbal.add("D");
		// playersFootbal.add("A");
		// playersFootbal.add("A");
		// playersFootbal.add("A");
		// playersFootbal.add("A");
		//
		// System.out.println(playersFootbal);
		// String[] allPlayers={"Dhoni","Kholi", "Rahul","Dhoni"};
		// for (String p : allPlayers) {
		// players.add(p);
		// }
		// for (int i = 0; i < allPlayers.length; i++) {
		// players.add(allPlayers[i]);
		// }
		// System.out.println(players);
		//
		// // Maps, unique keys to Value mapping
		// Map<String, Integer> nameAges=new HashMap<String, Integer>();
		// nameAges.put("Raaj", 25);
		// nameAges.put("Kal", 35);
		// nameAges.put("Adrian", 26);
		//
		// System.out.println(nameAges.keySet());
		// System.out.println(nameAges.values());
		// System.out.println(nameAges.get("Raaj"));

		// Queues

		Queue queueA = new LinkedList();

		queueA.add("element 0");
		queueA.add("element 1");
		queueA.add("element 2");

		// access via Iterator
		Iterator iterator = queueA.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			System.out.println(element);
		}

		// access via new for-loop
		for (Object object : queueA) {
			String element = (String) object;
			System.out.println(element);
		}

	}

}
