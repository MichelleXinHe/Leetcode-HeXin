//http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
//
public class Solution {
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()<t.length()) return "";
        int p1=0, p2=0;
        int start=-1, min=s.length();//start is the starting index of the min window, min is the global min size of the window
        //count: store the total characters in t that's met so far(not counting characters when found[x] excedds needFind[x])
        int count=0, n=t.length();
        //stores the total count of a character in t
        HashMap<Character, Integer> needFind=new HashMap<Character, Integer>();
        //stores the total count of a character met so far
        HashMap<Character, Integer> found=new HashMap<Character, Integer>();
        for(int i=0; i<n; i++){
            char c=t.charAt(i);
            if(needFind.containsKey(c)) needFind.put(c, needFind.get(c)+1);
            else needFind.put(c, 1);
        }
        
        //pointer2 starts from the begining of string s
        while(p2<s.length()){
            char c=s.charAt(p2);
            if(!needFind.containsKey(c)){// if c doesnot exist in string t, continue
                p2++;
                continue;
            }
            
            //as long as c exists in string t, store it in found table
            if(found.containsKey(c)) found.put(c, found.get(c)+1);
            else found.put(c, 1);
            
            //only if in this condition, increasing count
            if(found.get(c)<=needFind.get(c)) count++;
            //if count==n, we know a window is found, the right end is p2
            if(count==n){
                //so narrow the size of the found window by moving p1 towards p2
                while(p1<p2){
                    char c1=s.charAt(p1);
                    if(!needFind.containsKey(c1)) p1++;
                    else if(found.get(c1)>needFind.get(c1)){
                        p1++;
                        found.put(c1, found.get(c1)-1);
                    }else//until the sum of found==needFind, maintain the condition of count==n is always true
                    	break;
                }
                
                //now this is the min window ended at p2, compare the size with the global min window size
                if(p2-p1+1<=min){
                    min=p2-p1+1;
                    start=p1;
                }
            }
            //dont forget to increase the pointer p2
            p2++;
        }//while
        
        //only if a window is found, return it, otherwise return ""
        if(count==n) return s.substring(start, min+start);
        else return"";
    }
}
