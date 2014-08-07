public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result=new ArrayList<String>();
        if(words==null||words.length==0) return result;
        //if(words.length==1){result.add(words[0]); return result;}
        ArrayList<String> temp=new ArrayList<String>();
        int size=0;
        for(int i=0; i<words.length; i++){
            if(words[i].length()+size+temp.size()<=L){
                size+=words[i].length();
                temp.add(words[i]);
            }else{
                i--;
                result.add(helper(temp, L, size, false));
                temp=new ArrayList<String>(); 
                size=0;
            }
        }//for
        
        //the last row
        if(temp.size()>0){
            result.add(helper(temp, L, size, true));
        }
        return result;
    }
    
    public String helper(ArrayList<String> list, int L, int size, boolean is_last){
        int listSize=list.size();
        int numSpace=L-size;
        StringBuffer sb=new StringBuffer();
        StringBuffer space=new StringBuffer();
        if(listSize==1){
            sb.append(list.get(0));
            for(int j=0; j<numSpace;j++) sb.append(" ");
            return sb.toString();
        }

        int even=is_last?1:numSpace/(listSize-1);
        int more=is_last?0:numSpace%(listSize-1);
        
        for(int j=0; j<even;j++) space.append(" ");

        int i=0;
        for(; i<more; i++){
            sb.append(list.get(i));
            sb.append(space.toString()+" ");
        }
        
        for(; i<listSize; i++){
            sb.append(list.get(i));
            sb.append(space.toString());
        }
        
        
        String m=sb.toString();
        if(!is_last||m.length()>L)
            return m.substring(0, m.length()-even);
        else{
            int appendZero=L-size-listSize;
            for(int j=0; j<appendZero; j++) sb.append(" ");
            return sb.toString();
        }
    }
    
}
