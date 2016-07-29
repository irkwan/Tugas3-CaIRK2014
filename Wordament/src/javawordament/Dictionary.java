/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawordament;

import java.io.File;
import java.util.TreeSet;
import java.util.Scanner;

/**
 *
 * @author Johan
 */
public class Dictionary {
    private final TreeSet<String> data;
    
    public Dictionary() {
	data = new TreeSet<>();
    }
    public Dictionary(TreeSet<String> _data) {
	data = _data;
    }
    
    public void addWord(String word) {
    	data.add(word);
    }
    
    public int getSize() {
    	return data.size();
    }
    
    public String getFirstWord() {
    	return data.first();
    }
    
    public boolean isEmpty() {
            return data.isEmpty();
    }
    
    public boolean isExist(String word) {
    	return data.contains(word);
    }
    
    public boolean scanWordFile(String path) {
        
        Scanner sc;
        try {
            sc = new Scanner(new File(path));
            
            while (sc.hasNextLine()) {

                String line = sc.nextLine().trim();
	        if(!isExist(line)) addWord(line.toUpperCase());
		
            }
            return true;
	    
        }   catch(Throwable e) {
                data.clear();
            return false;
        }
    }
    
    public Dictionary getSubPrefix(String pref) {
    	
    	byte[] temp = pref.getBytes();
    	temp[temp.length-1] = (byte) (temp[temp.length-1] + 1);
    	String ceil = new String(temp);
    	
    	TreeSet<String> _data = new TreeSet<>(data.subSet(pref, ceil));
    	Dictionary res = new Dictionary(_data);
    	return res;
    	
    }

    public String toString() {
	return data.toString();
    }    
}
