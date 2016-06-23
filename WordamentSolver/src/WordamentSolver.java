


public class WordamentSolver {

    public static void main(final String[] args) {


	
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
D.addWord("ABA");
D.addWord("ACA");
D.addWord("ADA");
D.addWord("ADD");
D.addWord("ABC");
D.addWord("AB");

WordamentMatrix G = new WordamentMatrix();
G.setChar(new Point(1,0), 'B');
G.setChar(new Point(1,1), 'C');
G.setChar(new Point(0,1), 'D');

GameTree res = new GameTree(G,D);
Vector<GameStatus> temp = res.Process();

System.out.print(G);
System.out.print(temp);

///////////////////////////////////////////////////////////////////////////////

*/