package res;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Wordament{

	private static ArrayList<String> res;
	private static Trie t;
	private static char[][] m;
	private final static int size = 4;
	private static boolean[][] visited;
	private static int[] arahX;
	private static int[] arahY;

    private static boolean valid(int x, int y){
		return x >= 0 && y >= 0 && x < size && y < size && !visited[x][y];
	}

	private static void recurse(int last,String s, Trie tNow){
		if(tNow.getExist()){
			res.add(s);
		}
		int x = last / size;
		int y = last % size;
		for(int i = 0;i < 8; ++i){
			int nowX = x + arahX[i];
			int nowY = y + arahY[i];
			if(valid(nowX, nowY)){
				visited[nowX][nowY] = true;
				int idx = (int)m[nowX][nowY] - 97;
				if(tNow.getNext(idx) != null){
					recurse(nowX * size + nowY, s + Character.toString(m[nowX][nowY]), tNow.getNext(idx));
				}
				visited[nowX][nowY] = false;
			}
		}
	}

	public static void Init(){
		visited = new boolean[size][size];
		arahX = new int[]{-1,-1,0,1,1,1,0,-1};
		arahY = new int[]{0,-1,-1,-1,0,1,1,1};
		t = new Trie();
		m = new char[size][size];
		// still in progress
	}

	public static void InitDictionary() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("../dictionary.txt"));
		String sNow;
		while((sNow = br.readLine()) != null){
			int len = sNow.length();
			Trie tNow = t;
			for(int i = 0;i < len; ++i){
				int ch = (int)sNow.charAt(i) - 97;
				if(tNow.getNext(ch) == null){
					tNow.setNext(ch);
				}
				tNow = tNow.getNext(ch);
			}	
			tNow.setExist();
		}
		br.close();
	}

	public static void Solve(char[][] _m){
		res = new ArrayList<>();
		for(int i = 0;i < size; ++i){
			for(int j = 0;j < size;++j){
				m[i][j] = _m[i][j];
			}
		}
		for(int i = 0;i < size; ++i){
			for(int j = 0;j < size; ++j){
				visited[i][j] = true;
				int idx = (int)m[i][j] - 97;

				if(t.getNext(idx) != null){
					recurse(i * size + j, Character.toString(m[i][j]), t.getNext(idx));
				}
				
				visited[i][j] = false;
			}
		}
		Set<String> hs = new HashSet<>();
		hs.addAll(res);
		res.clear();
		res.addAll(hs);
		Collections.sort(res);
	}

	public static ArrayList<String> getRes(){
	    return res;
    }
}