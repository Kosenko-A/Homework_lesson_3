package ru.geekbrains.homeworks;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //task1
        guessTheNumber();

        //task2
        guessTheWord();
    }

    //task1
    public static void guessTheNumber() {
        checkTheAnswer();
        askUserAgain();
    }

    public static int createRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    public static void askUserAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите сыграть еще раз? Введите 1, если да, и 0, если нет");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                guessTheNumber();
                break;
            case 0:
                System.out.println("Спасибо, что сыграли в мою игру!");
                break;
            default:
                System.out.println("Вы ввели неправильное число");
        }
    }

    public static void checkTheAnswer() {
        int randomNumber = createRandomNumber();
        Scanner scanner = new Scanner(System.in);
        int maxTry = 3;
        System.out.printf("Угадайте целое число от 0 до 9. У вас есть %d попытки", maxTry);
        for (int i = maxTry; i > 0; i--) {
            int userAnswer = scanner.nextInt();
            if (userAnswer == randomNumber) {
                System.out.println("Поздравляем! Вы угадали загаданное число!");
                break;
            } else if (userAnswer > randomNumber) {
                System.out.printf("Загаданное число меньше. У вас осталось %d попытки", i - 1);
                System.out.println();
            } else if (userAnswer < randomNumber) {
                System.out.printf("Загаданное число больше. У вас осталось %d попытки", i - 1);
                System.out.println();
            } else {
                System.out.println("Вы ввели число вне загаданного диапазона");
            }
        }
    }

    //task2
    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int i = createRandomElement();
        System.out.println("Программа загадывает фрукт, овощ, ягоду или орех. Угадайте это слово.");
        checkTheWord(words, i);
    }

    public static int createRandomElement() {
        Random random = new Random();
        int randomNumber = random.nextInt(25);
        return randomNumber;
    }

    public static void print3(int n){
        for (int m = n; m <= 15; m++){
            System.out.print("#");
        }
    }
    public static void checkTheWord(String[]words, int i){
        outer: while (true) {
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();
            userAnswer = userAnswer.toLowerCase();
            boolean bool = userAnswer.equals(words[i]);
            if (bool == true) {
                System.out.println("Поздравляем! Вы угадали загаданное слово!");
                break;
            } else if (bool == false) {
                System.out.println("Слово не угадано.");
                for (int n = 0; n<words[i].length(); n++) {
                    if (words[i].charAt(n) == userAnswer.charAt(n)) {
                        print3(n);
                        System.out.print(words[i].charAt(n));
                        print3(n);
                        System.out.println();
                        continue outer;
                    }
                }
                if (words[i].charAt(0) != userAnswer.charAt(0)) {
                    System.out.println("Совпадений с загаданным словом нет");

                }
            }

        }
    }
}

