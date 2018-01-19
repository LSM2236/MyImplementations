import java.util.HashMap;

public class ParallelLetterFrequency {
    private String input;

    public ParallelLetterFrequency(String input) {
        this.input = input.toLowerCase().trim().replaceAll("[^a-züäöß]","");
    }

    public HashMap<Integer, Integer> letterCounts(){

        HashMap<Integer, Integer> sumowanie = new HashMap<>();

        Thread thread1 = new Thread(() -> System.out.println("Useless thread1"));
        thread1.start();

        Thread thread2 = new Thread(() -> System.out.println("Useless thread2"));
        thread2.start();

        Thread thread3 = new Thread(() -> System.out.println("Useless thread3"));
        thread3.start();

        Thread thread4 = new Thread(() -> {
            for (Character c : input.toCharArray()) {

                sumowanie.merge((int)c,1, Integer::sum);
            }
        });
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sumowanie;
    }
}
