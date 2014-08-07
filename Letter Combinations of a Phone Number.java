public class Solution {
    HashMap<String, ArrayList<String>> map=init();
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("");
        if(digits==null||digits.length()==0) return list;
        for(int i=digits.length()-1; i>=0; i--){
            String key=digits.charAt(i)+"";
            ArrayList<String> dict=map.get(key);
            ArrayList<String> current=new ArrayList<String>();
            for(String s:dict){
                for(String ss:list)
                    current.add(s+ss);
            }
            list=current;
        }
        return list;
        
    }
    
    public HashMap<String, ArrayList<String>> init(){
        HashMap<String, ArrayList<String>> map=new  HashMap<String, ArrayList<String>>();
        ArrayList<String> l=new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        map.put("2", l);
        
        l=new ArrayList<String>();
        l.add("d");
        l.add("e");
        l.add("f");
        map.put("3", l);
        
        l=new ArrayList<String>();
        l.add("g");
        l.add("h");
        l.add("i");
        map.put("4", l);
        
        l=new ArrayList<String>();
        l.add("j");
        l.add("k");
        l.add("l");
        map.put("5", l);
        
        l=new ArrayList<String>();
        l.add("m");
        l.add("n");
        l.add("o");
        map.put("6", l);
        
        l=new ArrayList<String>();
        l.add("p");
        l.add("q");
        l.add("r");
        l.add("s");
        map.put("7", l);
        
        l=new ArrayList<String>();
        l.add("t");
        l.add("u");
        l.add("v");
        map.put("8", l);
        
        l=new ArrayList<String>();
        l.add("w");
        l.add("x");
        l.add("y");
        l.add("z");
        map.put("9", l);
        return map;
    }
    
    /**
    public HashMap<String, ArrayList<String>> init(){
        HashMap<String, ArrayList<String>> map=new  HashMap<String, ArrayList<String>>();
        char c='a';
        for(int i=2; i<=9; i++){
            ArrayList<String> list=new ArrayList<String>();
            char d=' ';
            for(int j=0; j<3;j++){
                d=(char) c+j;
                list.add(d+"");
            }
            c=d;
            map.put(i+"", list);
        }
        ArrayList<String> l=map.get("9");
        l.add("z");
        map.put("9", l);
        
        return map;
    }
    */
}
