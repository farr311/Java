package lesson30;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class WordPrinter {

    private String word;
    private int index = 0;

    public WordPrinter(String word) { this.word = word; }

    public void printWord() {
        ExecutorService ex = Executors.newFixedThreadPool(word.length());
        for (int i = 0; i < word.length(); i++) {
            ex.execute(new Thread(this::printLetter));//.start();
        }
        //IntStream.range(0, word.length()).forEach(n -> (new Thread(this::printLetter)).start());
    }
    private synchronized void printLetter() { System.out.println(word.charAt(index++)); }
}

class Runner {
    public static void main(String[] args) {
        //(new WordPrinter((new Scanner(System.in)).next())).printWord();
        (new WordPrinter("Hello world")).printWord();
    }
}
