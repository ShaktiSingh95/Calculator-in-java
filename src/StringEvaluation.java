import java.util.Stack;

/**
 * Created by $SPS on 16-01-2016.
 */
public class StringEvaluation extends Stack {

    Stack<Character> operators = new Stack<Character>();
    Stack<Double> values = new Stack<Double>();

    public String evaluate(String expression) throws Exception {

        char[] charExp = expression.toCharArray();
        int i;
        for (i = 0; i < charExp.length; i++) {

            if (charExp[i] == '(') {

                this.operators.push(charExp[i]);

            } else if (charExp[i] == ')') {

                while (this.operators.peek() != '(') {
                    try {
                        this.calcNpush(this.operators.pop(), this.values.pop(), this.values.pop());

                    } catch (Exception e) {

                        throw new Exception();
                    }
                }
                this.operators.pop();

            }
            if (charExp[i] >= '0' && charExp[i] <= '9') {

                StringBuffer no = new StringBuffer();
                while (i < charExp.length && (charExp[i] >= '0' && charExp[i] <= '9')) {

                    no.append(charExp[i]);
                    i++;

                }
                i--;
                this.values.push(Double.parseDouble(no.toString()));

            } else if (charExp[i] == '+' || charExp[i] == '*' || charExp[i] == '/' || charExp[i] == '-') {

                if (this.operators.empty()) {
                    this.operators.push(charExp[i]);

                } else if (checkPreced(charExp[i], this.operators.peek())) {

                    this.operators.push(charExp[i]);


                } else {

                    while (!checkPreced(charExp[i], this.operators.peek())) {
                        try {
                            this.calcNpush(this.operators.pop(), this.values.pop(), this.values.pop());
                            System.out.println(this.values.toString());
                        } catch (Exception e) {

                            throw new Exception();
                        }
                    }
                    this.operators.push(charExp[i]);
                }

            }

        }

        while (!this.operators.empty()) {

            try {
                this.calcNpush(this.operators.pop(), this.values.pop(), this.values.pop());

            } catch (Exception e) {

                throw new Exception();
            }
        }
        return (this.values.pop().toString());
    }

    private void calcNpush(Character opr, Double b, Double a) throws ArithmeticException {

        double answer = 0;
        switch (opr) {

            case '+':
                answer = a + b;
                break;
            case '-':
                answer = a - b;
                break;
            case '*':
                answer = a * b;
                break;
            case '/':
                if (b == 0) {

                    throw new ArithmeticException();

                } else {
                    answer = a / b;
                }

        }
        this.values.push(answer);
    }

    private static boolean checkPreced(char c, char peek) {


        if ((c == '+' || c == '-') && (peek == '/' || peek == '*'))
            return false;
        else
            return true;

    }

}
