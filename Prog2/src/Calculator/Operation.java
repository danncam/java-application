package Calculator;
public class Operation
{
        public String answ;
        
        public Operation(int a, int b, char op)
        {
                switch(op)
                {
                        case '+':
                                answ = Integer.toString(a + b);
                                break;
                        case '-':
                                answ = Integer.toString(a - b);
                                break;
                        case '*':
                                answ = Integer.toString(a * b);
                                break;
                        case '/':
                                if(b != 0)
                                {
                                        answ = Double.toString(a / b);
                                        break;
                                }
                                else
                                        System.out.println("NaN"); 
                                        break;
                        case '%':
                                if(b != 0)
                                {
                                        answ = Integer.toString(a % b);
                                        break;
                                }
                                else
                                        System.out.println("NaN");
                                        break;
                        case '&':
                                answ = Integer.toString(a & b);
                                break;
                        case '|':
                                answ = Integer.toString(a | b);
                                break;
                        case '>':
                                answ = Integer.toString(a >> b);
                                break;
                        case '<':
                                answ = Integer.toString(a << b);
                                break;
                        default:
                                System.out.println("Cannot find operator");
                                break;
                                
                }
        }
        
        public Operation(int a, char op)
        {
                switch (op)
                {       
                        case '~':
                                answ = Integer.toString(-a);
                                break;
                        case '!':
                                answ = Integer.toString(factorial(a));
                                break;
                        case 'b':
                                answ = Byte.toString((byte) a);
                                break;
                        case 'l':
                                answ = Long.toString((long) a);
                                break;
                        case 'f':
                                answ = Float.toString((float) a);
                                break;
                        case 'd':
                                answ = Double.toString((double) a);
                                break;
                        default:
                                System.out.println("cannot find operator");
                                break;
 
                                
                }
        }
        
        public void printAnswer()
        {
                System.out.println(answ);
        }
        
        private static int power (int i, int n)
        {
                if(n == 1)
                        return i;
                else
                        return i * power(i, n--);
        }
        private static int factorial (int i)
        {
                if(i <= 1)
                {
                        return 1;
                }
                else
                        return i * factorial(i--);
        }
        

 
}