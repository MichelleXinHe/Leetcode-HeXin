public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result =new ArrayList<String>();
        if(s==null) return result;
        String temp="";
        partition(s, 4, temp, result);
        return result;
    }
    
    public void partition(String s, int parts, String temp, ArrayList<String> result){
        //converge condition
        if(s.length()==0&&parts==0){
            result.add(temp.substring(0, temp.length()-1));
            return ;
        }
        //invalid input
        if(s.length()<parts||s.length()>3*parts) return;
        
        for(int i=1; i<=3&&i<=s.length(); i++){
            String left=s.substring(0, i);
            if(left.charAt(0)=='0'&&left.length()>1) break;
            if(Integer.parseInt(left)>255) break;
            String right=s.substring(i);
            temp=temp+left+".";
            partition(right, parts-1, temp, result);
            temp=temp.substring(0, temp.length()-left.length()-1);
        }
    }
}
