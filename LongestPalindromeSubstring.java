public class Solution {
    //method1: 2n-1 centers
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2) return s;
        int max=1, n=s.length();
        String result=s.charAt(0)+"";
        
        //each char is the center
        for(int i=1; i<n-1; i++){
            int count=1;
            int start=i-1, end=i+1;
            while(start>=0&&end<=n-1){
                if(s.charAt(start)==s.charAt(end)){
                    count+=2;
                    start--;
                    end++;
                }else break;
            }
            
            if(count>max){
                max=count;
                result=s.substring(start+1, end);
            }
        }
        
        //each gap is the center
        for(int i=0; i<n-1; i++){
            int count=0; 
            int start=i; 
            int end=i+1;
            while(start>=0&&end<=n-1){
                if(s.charAt(start)==s.charAt(end)){
                    count+=2;
                    start--;
                    end++;
                }else break;
            }
            
            if(count>max){
                max=count;
                result=s.substring(start+1, end);
            }
        }
        
        return result;
    }
}
