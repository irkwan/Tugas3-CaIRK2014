package model;

import java.util.TreeSet;

public class Dictionary {
    
    private final TreeSet<String> data;
    
    public Dictionary() {
	data = new TreeSet<>();
    }
    public Dictionary(TreeSet<String> _data) {
	data = _data;
    }
    
    /**
     * Add the input string to Dictionary (will be arranged lexicographically)
     * @param word input string
     */
    public void addWord(String word) {
	data.add(word);
    }
    
    /**
     * @return The first word in dictionary
     */
    public String getFirstWord() {
	return data.first();
    }
    
    /**
     * @param pref A string
     * @return Subset of dictionary which contains word with the prefix pref
     */
    public Dictionary getSubDictPrefix(String pref) {
	
	byte[] temp = pref.getBytes();
	temp[temp.length-1] = (byte) (temp[temp.length-1] + 1);
	String ceil = new String(temp);
	
	TreeSet<String> _data = new TreeSet<>(data.subSet(pref, ceil));
	Dictionary res = new Dictionary(_data);
	return res;
	
    }
    
    public boolean isEmpty() {
	return data.isEmpty();
    }
    
    @Override
    public String toString() {
	return data.toString();
    }
    
}
