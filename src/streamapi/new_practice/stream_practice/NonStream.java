package streamapi.new_practice.stream_practice;

public class NonStream {
    public void frequencyOfEachCharacter(String input) {
        input.chars().distinct().forEach(
                element -> {
                    long count = input.chars().filter(ch -> ch == element).count();
                    System.out.println((char) element + " = " + count);
                }
        );
    }
}
