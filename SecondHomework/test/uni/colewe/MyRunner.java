package uni.colewe;

import java.util.HashSet;
import java.util.Set;

import uni.colewe.server.MyDictionary;

public class MyRunner {
	public static void main(String[] args) {
		MyDictionary dict = new MyDictionary("C://_projects//GWT//SecondHomework//war//WEB-INF//dictdata.txt");
		
		Set<String> queries = new HashSet<>();
		for (int i = 97; i < 124; i++) {
			String c = String.valueOf(Character.toChars(i));
			if (i == 123) {
				c = "";
			}
			for (int j = 97; j < 124; j++) {
				String d = String.valueOf(Character.toChars(j));
				if (j == 123) {
					d = "";
				}
				for (int k = 97; k < 124; k++) {
					String e = String.valueOf(Character.toChars(k));
					if (k == 123) {
						e = "";
					}
					queries.add(c + d + e);
				}
			}
		}
		System.out.println("Processing " + queries.size() + " queries");

		long start = System.currentTimeMillis();
		for (String query : queries) {
			dict.treeLookUp(query, true, true);
		}
		long end = System.currentTimeMillis();
		System.out.println("Tree lookup: " + Long.toString(end - start) + "ms");

		start = System.currentTimeMillis();
		for (String query : queries) {
			dict.mapLookUp(query, true, true);
		}
		end = System.currentTimeMillis();
		System.out.println("Map  lookup: " + Long.toString(end - start) + "ms");
		// +++
		start = System.currentTimeMillis();
		for (String query : queries) {
			dict.treeLookUp(query, true, false);
		}
		end = System.currentTimeMillis();
		System.out.println("Tree lookup: " + Long.toString(end - start) + "ms");

		start = System.currentTimeMillis();
		for (String query : queries) {
			dict.mapLookUp(query, true, false);
		}
		end = System.currentTimeMillis();
		System.out.println("Map  lookup: " + Long.toString(end - start) + "ms");

		// System.out.println("Found " + Integer.toString(results.size()) + "
		// matches");
		// for (MyDictionaryEntry entry : results) {
		// System.out.println(entry);
		// }
	}
}
