
package solver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albertus Kelvin
 */
public class PathCreator {
    
    public static List<PathCreator> chosenfPC;
    public static ArrayList<Integer[]> possibleID;
    public static char[][] model;
    
    public String word;
    public int id;
    public int idx;
    public int idy;
    
    public PathCreator(int id, String word, int idx, int idy) {
        this.word = word;
        this.id = id;
        this.idx = idx;
        this.idy = idy;
    }
    
    public static Integer[] getPath() {
        
        int xx, yy;
        boolean valid;
        Integer[] matchID = new Integer[chosenfPC.size()];
        
        for (Integer[] elmt : possibleID) {
            valid = true;
            for (int i = 0; i < chosenfPC.size(); i++) {
                xx = chosenfPC.get(elmt[i]).idx;
                yy = chosenfPC.get(elmt[i]).idy;
                if (chosenfPC.get(elmt[i]).word.charAt(i) != model[xx][yy]) {
                    valid = false;
                    break;
                }
                
            }
            
            if (valid) {
                /*
                System.out.print("GOTCHA: ");
                for (int i = 0; i < chosenfPC.size(); i++) {
                    System.out.print(elmt[i] + " ");
                }
                System.out.println();
                */
                matchID = elmt;
                break;
            }
        }
        
        return matchID;
    }
    
    public static void Permute(int[] fPCID, int initID) {
        int size = fPCID.length;

        if (size == initID + 1) {
            
            // convert int[] into Integer[]
            Integer[] newArray = new Integer[size];
            int i = 0;
            for (int value : fPCID) {
                newArray[i++] = Integer.valueOf(value);
            }
           
            possibleID.add(newArray);
            
            /*
            for (Integer[] elmt : possibleID) {
                for (int j = 0; j < chosenfPC.size(); j++) {
                    System.out.print(Integer.toString(elmt[j]) + " ");
                }
                System.out.println();
            }
            System.out.println("+++++++++++");
            */
            
        } else {
            for (int i = initID; i < size; i++) {

                int temp = fPCID[i];
                fPCID[i] = fPCID[initID];
                fPCID[initID] = temp;
                
                Permute(fPCID, initID + 1);
                
                temp = fPCID[i];
                fPCID[i] = fPCID[initID];
                fPCID[initID] = temp;
            }
        }
    }

}
