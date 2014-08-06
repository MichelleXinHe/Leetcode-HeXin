//use a stack
public class PolishNotation {
    public int evalRPN(String[] t) {
        Stack<Integer> num=new Stack<Integer>();
        int a=0, b=0;
        for(int i=0;i<t.length;i++){
            switch(t[i]){
                case "+":
                    num.push(num.pop()+num.pop());
                    break;
                case "*":
                    num.push(num.pop()*num.pop());
                    break;
                case "-":
                    b=num.pop();
                    a=num.pop();
                    num.push(a-b);
                    break;
                case "/":
                    b=num.pop();
                    a=num.pop();
                    num.push(a/b);
                    break;
                default:
                    num.push(Integer.parseInt(t[i]));
            }
        }
        return num.pop();
    }
}
