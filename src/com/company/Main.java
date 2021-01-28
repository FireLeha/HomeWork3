package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        //guessNumber(); //Задание №1
        //guessTheWord(); //Задание №2

    }



    private static void guessNumber() {

        int correctAnswer = (int) (Math.random() * 10);
        int maxTryCount = 3;

        System.out.println("Угадайте число от 0 до 9. У вас есть " + maxTryCount + " попыток.");

        for (int tryCount = 1; tryCount <= maxTryCount; tryCount++) {


            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswer) {
                System.out.println("Поздравляю, вы угадали!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int quitCondition = scanner.nextInt();
                if (quitCondition == 1) {
                   // guessNumber();
                    System.out.println("Угадайте число от 0 до 9. У вас есть " + maxTryCount + " попыток.");

                    correctAnswer = (int) (Math.random() * 10);
                    tryCount = 0;
                    continue;
                } else if (quitCondition == 0)
                    return;

            } else if (userAnswer > correctAnswer) {
                System.out.println("Вы ввели слишком большое число ");
            } else if (userAnswer < correctAnswer) {
                System.out.println("Вы ввели слишком маленькое число ");
            }
            if (tryCount >= maxTryCount) {
                System.out.println("Dы проиграли!");
                System.out.println("Правильный ответ: " + correctAnswer);
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int quitCondition = scanner.nextInt();
                if (quitCondition == 1) {
                    //guessNumber();
                    System.out.println("Угадайте число от 0 до 9. У вас есть " + maxTryCount + " попыток.");
                    correctAnswer = (int) (Math.random() * 10);
                    tryCount = 0;
                    continue;
                } else if (quitCondition == 0)
                    return;
            }
            if (userAnswer > correctAnswer || userAnswer < correctAnswer)
            System.out.println("Попробуйте ещё раз. Введите число от 0 до 9.\nУ Вас осталось " + (maxTryCount - tryCount) + " попыток.");
        }
    }

    private static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randomArrNum = (int) (Math.random() * words.length);
        String randomArrWord = (words[randomArrNum - 1]);
        String guessedWord;
        StringBuilder mask = new StringBuilder("###############");
        //System.out.println(randomWord); //вывести случайный элемент массива
        //System.out.println(Arrays.toString(words)); //вывести весь массив
        System.out.println("Вот список слов: " + Arrays.toString(words));
        System.out.println("Какое слово загадано?");
        String userAnswer = scanner.next();
        System.out.println("Вы ввели: " + userAnswer);
        do {

            if (!Objects.equals(userAnswer, randomArrWord)) {
                System.out.println("Вы не угадали.");

                char letterInGuessedWord;
                char letterInUserWord;
                for (int i = 0; i < randomArrWord.length(); i++) {
                    letterInGuessedWord = randomArrWord.charAt(i);
                    for (int j = 0; j < userAnswer.length(); j++) {
                        letterInUserWord = userAnswer.charAt(j);
                        if(letterInGuessedWord == letterInUserWord){
                            mask.setCharAt(i, letterInUserWord);
                            break;
                        }
                    }
                }
                System.out.println("Вы угадали следующие буквы в слове: " + mask);
                System.out.println("Попробуйте угадать слово");
                userAnswer = scanner.next();

            } else if(Objects.equals(userAnswer, randomArrWord)){
                System.out.println("Вы угадали!");
                scanner.close();
                break;
            }
        } while (userAnswer != randomArrWord);
    }
}
