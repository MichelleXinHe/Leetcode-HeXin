public class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()%2==1) return false;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                else{
                    char p=stack.pop();
                    if(c==')'&&p!='(') return false;
                    if(c=='}'&&p!='{') return false;
                    if(c==']'&&p!='[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
