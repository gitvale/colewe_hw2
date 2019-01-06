package uni.colewe.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uni.colewe.shared.MyDictionaryEntry;

public class MyPrefixNode {
	private char prefix;
	private Set<MyDictionaryEntry> entries = new HashSet<>();
	private Map<Character, MyPrefixNode> children = new HashMap<>();

	public Set<MyDictionaryEntry> getEntries() {
		return entries;
	}

	public MyPrefixNode(char prefix){
		this.prefix = prefix;
	}
	
	public MyPrefixNode getChild(char c){
		return children.get(c);
	}
	
	public boolean addChild(char c){
		if(children.get(c) == null){
			children.put(c, new MyPrefixNode(c));
			return true;
		} else {
			return false;
		}
	}
	// TODO add duplicate check?
	public void addEntry(MyDictionaryEntry entry){
		entries.add(entry);
	}

	public void getBranchEntries(Set<MyDictionaryEntry> results) {
//		List<MyDictionaryEntry> results = new ArrayList<>();
		results.addAll(entries);
		for(Character c : children.keySet()){
			children.get(c).getBranchEntries(results);
		}
	}
}
