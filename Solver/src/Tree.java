
public class Tree{
        Tree[] node;
        int count;
        Tree(){
            count = 0;
        }
        /**
         * @param s a non-null string.
        **/
        Tree(String s) {
            if(s.length()==0){
                count = 1;
                return;
            } else {
                node = new Tree[26];
                node[s.charAt(0)-'a'] = new Tree(s.substring(1));
            }
        }
        /**
         * @param s a non-null string.
        **/        
        void addWord(String s) {
            if(s.length()==0){
                count++;
            }
            else if (node == null){
                node = new Tree[26];
                node[s.charAt(0)-'a'] = new Tree(s.substring(1));
            }else{
                if (node[s.charAt(0)-'a'] == null)
                {
                    node[s.charAt(0)-'a'] = new Tree(s.substring(1));  
                }
                else {
                    node[s.charAt(0)-'a'].addWord(s.substring(1));
                }
            }
        }

        Tree getNode(char c) {
            int i = c - 'a';
            return node[i];
        }

        Boolean isWord() {
           if (count == 1) {
                return true;
           }
           else{
                return false;
           }
        }
    }

