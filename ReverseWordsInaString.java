public class Solution {
    //in all the test cases, if an input="a    b   "
    //the expected output is="b a"
    //all the space between a and b and appending at the end of the string should be ignored
    public String reverseWords(String s) {
        if(s==null||s.length()==0) return s;
        String reversed = reverse(s);
        String[] array = reversed.split(" ");
        if(array.length>=1){
            for(int i=0; i<array.length; i++){
                array[i]=reverse(array[i]);
            }
            StringBuffer sb= new StringBuffer();
            int index=0;
            while(index<array.length&&array[index].equals("")){
            	index++;
            }
        	sb.append(array[index]);

            for(int i=index+1; i<array.length;i++){
                if(!array[i].equals(""))
                sb.append(" "+array[i]);
            }
            return sb.toString();
        }else
            return "";
    }
    
    public String reverse(String s){
        if(s==null||s.length()==0||s.length()==1) return s;

        char[] content=s.toCharArray();
        int N=s.length();
        for(int i=0; i<N/2;i++){
            char temp=content[i];
            content[i]=content[N-i-1];
            content[N-i-1]=temp;
        }
        
        return new String(content);
    }
}
