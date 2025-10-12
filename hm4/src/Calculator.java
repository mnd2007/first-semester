public class Calculator<T extends Number> {
    public double sum(T a, T b) {
        if (a == null || b == null) {
            return Double.NaN;
        }
        return a.doubleValue() + b.doubleValue();
    }

    public double subtract(T a, T b) {
        if (a == null || b == null) {
            return Double.NaN;
        }
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b) {
        if (a == null || b == null) {
            return Double.NaN;
        }
        return a.doubleValue() * b.doubleValue();
    }

    public double divide(T a, T b) {
        if (a == null || b == null) {
            return Double.NaN;
        }
        if (b.doubleValue() == 0.0) {
            return Double.NaN;
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static void main(String[] args) {
        final Calculator<Integer> intCalc = new Calculator<>();
        final double result = intCalc.sum(5, 3);
        System.out.println("5 + 3 = " + result);
        final Calculator<Double> doubleCalc = new Calculator<>();
        final double div = doubleCalc.divide(10.0, 4.0);
        System.out.println("10.0 / 4.0 = " + div);
        System.out.println("5 * 3 = " + intCalc.multiply(5, 3));
        System.out.println("5 - 3 = " + intCalc.subtract(5, 3));
        System.out.println("10 / 0 = " + doubleCalc.divide(10.0, 0.0));
        System.out.println("null + 5 = " + intCalc.sum(null, 5));
    }
}