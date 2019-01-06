package uni.colewe.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uni.colewe.shared.MyDictionaryEntry;

public class MyPrefixTree {
	private MyPrefixNode root = new MyPrefixNode(Character.MIN_VALUE);

	public MyPrefixNode getRoot() {
		return root;
	}

	public void addEntry(String toAdd, MyDictionaryEntry entry) {
		MyPrefixNode node = getNode(toAdd);
		if(node != null){
			node.addEntry(entry);
		} else {
			node = root;
			boolean create = false;
			for(int i = 0; i < toAdd.length(); i++){
				char c = toAdd.charAt(i);
				if(create || node.getChild(c) == null){
					create = true;
					node.addChild(c);
				}
				node = node.getChild(c);
				if(i == toAdd.length()-1){
					node.addEntry(entry);
				}
			}
		}
	}

	public MyPrefixNode getNode(String query) {
		if (query.length() > 0) {
			return getNode(query, root);
		}
		return null;
	}

	private MyPrefixNode getNode(String query, MyPrefixNode node) {
		MyPrefixNode current = node.getChild(query.charAt(0));
		if (query.length() > 1) {
			if (current != null) {
				return getNode(query.substring(1), current);
			}
		} else {
			return current;
		}
		return null;
	}

	public Set<MyDictionaryEntry> getEntries(String query, boolean startsWith) {
		MyPrefixNode node = getNode(query);
		Set<MyDictionaryEntry> results = new HashSet<MyDictionaryEntry>();
		if (node != null) {
			if (startsWith) {
				node.getBranchEntries(results);
				return results;
			} else {
				return node.getEntries();
			}
		}
		return results;
	}
}
