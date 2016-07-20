
package solver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Albertus Kelvin
 */
public class MainSolver {
    
    private char[][] matrix = new char[4][4];
    private static Set<String> validWords = new HashSet<String>();
    private List<String> finalResult;
    private List<Integer> totalPoint;
    private final String dictLOC;
    
    public MainSolver(char[][] matrixVal, String dictLOC) {
        matrix = matrixVal;
        this.dictLOC = dictLOC;
        validWords.clear();
    }
    
    /**
     * GET the final result of found words
     * @return list of found words 
     */
    public List<String> getResult() {
        return finalResult;
    }
    
    /**
     * GET the total point for each found words,
     * where each character worths one point
     * @return list of total point 
     */
    public List<Integer> getTotalPoint() {
        
        totalPoint = new ArrayList<Integer>();
        
        for (String word : finalResult) {
            totalPoint.add(word.length());
        }
        
        return totalPoint;
    }
    
    /**
     * Solver master, where it will call the words tree creator and
     * determine the valid words
     * @throws IOException if program can not find or open the dictionary 
     */
    public void solve() throws IOException {
        
        Node root = new ModelCreator(dictLOC).init();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                traverse(matrix, new boolean[4][4], i, j, root, "");
            }
        }
        
        finalResult = new ArrayList<String>(validWords);
        
        Collections.sort(finalResult, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (String word : finalResult) {
            System.out.println("OK: " + word);
        }
        
    }
    
    /**
     * @param grid The grid of letters representing the game.
     * @param visited A grid of indicators telling us which letters have already been visited.
     * @param i Our current location in the grid. x-axis
     * @param j Our current location in the grid. y-axis
     * @param node The node we have just visited.
     * @param current The currently formulated word.
     */
    private static void traverse(char[][] grid, boolean[][] visited, int i, int j, Node node, String current) {
        char c = grid[i][j];
        String newStr = current + Character.toString(c);
        Node next = node.getNode(c);

        if (next != null) {
            visited[i][j] = true;
            if (next.isWord() && newStr.length() > 2) {
                validWords.add(newStr);
            }

            if (j < 3 && !visited[i][j + 1]) {
                traverse(grid, visited, i, j + 1, next, newStr);
            }
            if (i < 3 && !visited[i + 1][j]) {
                traverse(grid, visited, i + 1, j, next, newStr);
            }
            if (j > 0 && !visited[i][j - 1]) {
                traverse(grid, visited, i, j - 1, next, newStr);
            }
            if (i > 0 && !visited[i - 1][j]) {
                traverse(grid, visited, i - 1, j, next, newStr);
            }
            if (i < 3 && j < 3 && !visited[i + 1][j + 1]) {
                traverse(grid, visited, i + 1, j + 1, next, newStr);
            }
            if (i < 3 && j > 0 && !visited[i + 1][j - 1]) {
                traverse(grid, visited, i + 1, j - 1, next, newStr);
            }
            if (i > 0 && j > 0 && !visited[i - 1][j - 1]) {
                traverse(grid, visited, i - 1, j - 1, next, newStr);
            }
            if (i > 0 && j < 3 && !visited[i - 1][j + 1]) {
                traverse(grid, visited, i - 1, j + 1, next, newStr);
            }
            visited[i][j] = false;
        }

    }
}
