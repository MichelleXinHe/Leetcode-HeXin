//need to consider duplicate elements in the array
//so use arraylist rather than an integer to store the index of each number in this array-numbers
//time complexity=O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length==1) return null;
        int[] result= new int[2];
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<Integer, ArrayList<Integer>>();
        int[] diff= new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            diff[i]=target-numbers[i];
            ArrayList<Integer> list=null;
            if(map.containsKey(numbers[i])){
                list=map.get(numbers[i]);
            }else
                list= new ArrayList<Integer>();
            list.add(i);
            map.put(numbers[i], list);
        }
        
        for(Integer i:diff){
            if(map.containsKey(i)){
                ArrayList<Integer> index1=map.get(i);
                ArrayList<Integer> index2=map.get(target-i);
                int m=0;
                int n=0;
                while(m<index1.size()&&n<index2.size()){
                    int num1=index1.get(m);
                    int num2=index2.get(n);
                    if(num1!=num2){
                        result[0]=Math.min(num1, num2)+1;
                        result[1]=Math.max(num1, num2)+1;
                        break;
                    }else{
                        if(m+1<index1.size())
                            m++;
                        else
                            n++;
                    }
                }
            }
        }
        
        return result;
        
    }
}
