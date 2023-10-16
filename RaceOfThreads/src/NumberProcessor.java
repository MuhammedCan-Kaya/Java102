import java.util.ArrayList;

public class NumberProcessor implements Runnable {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> oddNumbers;
    private ArrayList<Integer> evenNumbers;

    public NumberProcessor(ArrayList<Integer> numbers, ArrayList<Integer> oddNumbers, ArrayList<Integer> evenNumbers) {
        this.numbers = numbers;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
    }
}
