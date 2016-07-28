package com.company;

public class Trie{
	private char ch;
	private Trie[] next;
	private boolean exists;

	public Trie(){
		ch = '\0';
		exists = false;
		next = new Trie[26];
	}
	public Trie(int idx){
		ch = (char) ('a' + idx);
		exists = false;
		next = new Trie[26];
	}
	public char getChar(){
		return ch;
	}

	public Trie getNext(int idx){
		return next[idx];
	}

	public void setNext(int idx){
		next[idx] = new Trie(idx);
	}

	public void setExist(){
		exists = true;
	}

	public boolean getExist(){
		return exists;
	}
}