import stack_and_queue.BasicCalculator;

public class Main {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        System.out.println(calculator.calculate("(1+(-4+5+2)-3)+(6+8)"));
    }
}
