
package controller;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

import model.Dictionary;
import model.Point;
import model.WordamentMatrix;

public class GameTree {
    
    private static class GameStatusComparator implements Comparator<GameStatus> {
	@Override
	public int compare(GameStatus x, GameStatus y) {
	    if (x.getCost() < y.getCost())
	    {
		return -1;
	    }
	    if (x.getCost() > y.getCost())
	    {
		return 1;
	    }
	    return 0;
	}
    }
    
    private final GameStatusComparator MyComp = new GameStatusComparator();
    private final PriorityQueue<GameStatus> Repository = new PriorityQueue<>(1,MyComp);

    private final Vector<GameStatus> ClaimedDetail;
    
    public GameTree(WordamentMatrix M, Dictionary W) {
	
	Dictionary Claimed = new Dictionary();
	ClaimedDetail = new Vector<>();
	
	for(int i=0; i<4; i++) {
	    for(int j=0; j<4; j++) {
		
		Point pos = new Point(i,j);
		
		Vector<Point> Way = new Vector<>();
		Way.add(pos);
		Dictionary SubDict = W.getSubDictPrefix(Character.toString(M.getChar(pos)));

		if(!SubDict.isEmpty()) Repository.add(new GameStatus(M, Claimed, ClaimedDetail, Way, SubDict));
		
	    }
	}
	
    }
    
    public void Begin() {
	while(!Repository.isEmpty()) {
	    Repository.addAll(Repository.remove().generateChild());
	}
    }
    
    public Vector<GameStatus> getResult() {
	return ClaimedDetail;
    }
}


/*
///////////////////////////////////////////////////////////////////////////////

Dictionary data = new Dictionary();
data.addWord("A");
data.addWord("AB");
data.addWord("AC");
data.addWord("BCD");
data.addWord("BCDEF");

data.addWord("ABDFS");
data.addWord("VBSD");
data.addWord("VDFS");
data.addWord("VESS");
data.addWord("BSDS");

System.out.println(data);
System.out.println(data.getSubDictPrefix("A"));

///////////////////////////////////////////////////////////////////////////////

Point p = new Point(3,3);
Vector<Point> a = new Vector<>();
a.add(new Point(3,2));
a.add(new Point(2,2));

Vector<Point> temp = p.getValidAdjacentPoint(a);
System.out.println(a);
System.out.println(temp);

///////////////////////////////////////////////////////////////////////////////

Vector<Point> P = new Vector<>();
P.add(new Point(0,0));

Dictionary D = new Dictionary();
D.addWord("ABA");
D.addWord("ACA");
D.addWord("ADA");
D.addWord("ADD");
D.addWord("ABC");
D.addWord("AB");

GameStatus G = new GameStatus(D,P);
G.setBoard(new Point(1,0), 'B');
G.setBoard(new Point(1,1), 'C');
G.setBoard(new Point(0,1), 'D');

System.out.print(G);

Vector<GameStatus> ListG = G.generateChild();
for(GameStatus TempG : ListG) {
    System.out.println();
    System.out.println();
    System.out.print(TempG);
    System.out.println();
    System.out.print(TempG.generateChild());
}

///////////////////////////////////////////////////////////////////////////////

Dictionary D = new Dictionary();
boolean B = D.scanWordFile("D:\\Tugas3-CaIRK2016\\dictionary.txt");

WordamentMatrix G = new WordamentMatrix();
G.setChar(new Point(0,0), 'A');
G.setChar(new Point(0,1), 'B');
G.setChar(new Point(0,2), 'C');
G.setChar(new Point(0,3), 'D');

G.setChar(new Point(1,0), 'E');
G.setChar(new Point(1,1), 'F');
G.setChar(new Point(1,2), 'G');
G.setChar(new Point(1,3), 'H');

G.setChar(new Point(2,0), 'A');
G.setChar(new Point(2,1), 'I');
G.setChar(new Point(2,2), 'U');
G.setChar(new Point(2,3), 'E');

G.setChar(new Point(3,0), 'M');
G.setChar(new Point(3,1), 'N');
G.setChar(new Point(3,2), 'O');
G.setChar(new Point(3,3), 'P');

GameTree res = new GameTree(G,D);
res.Begin();
Vector<GameStatus> temp = res.getResult();

System.out.print(G);
System.out.print(temp);

///////////////////////////////////////////////////////////////////////////////
*/