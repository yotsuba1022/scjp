package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public class SimpleCalc {
    public int value;

    public void calculate() {
        value += 7;
    }
}


class MultiCalc extends SimpleCalc {
    public static void main(String[] args) {
        MultiCalc calculator = new MultiCalc();
        calculator.calculate(2);
        System.out.println("Value is: " + calculator.value);
    }

    public void calculate() {
        value -= 3;
    }

    public void calculate(int multiplier) {
        calculate();
        super.calculate();
        value *= multiplier;
    }
}
