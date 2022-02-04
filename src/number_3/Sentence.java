package number_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Sentence {
    static String vowels = "аеёиоуыэюя"; //строка гласных русского алфавита
    static ArrayList<Word> sentence = new ArrayList<>(); //массив извлеченных слов

    public static boolean isVowel (char letter){ //является ли символ гласной
        if (vowels.indexOf(letter) > -1)
            return true;
        else
            return false;
    }

    public static int countOfVowel (String word){ //подсчет количества гласных в слове
        int count = 0; //кол-во гласных
        for (int i = 0; i < word.length(); i++)
            if (isVowel(word.charAt(i))) //если символ - гласная
                count++;
        return count;
    }

    public static String makeUpper (String word) { //делает первую гласную заглавной
        String result = ""; //строка-результат
        for (int i = 0; i < word.length(); i++)
            if (isVowel(word.charAt(i))){ //первая гласная
                    result = word.substring(0, i); //копируем строку до позиции гласной
                    result += word.substring(i, i + 1).toUpperCase(); //копируем и делаем гласную заглавной
                    result += word.substring(i + 1, word.length()); //копируем остаток строки
                    break;
                }
        return result;
    }

    public static void toSwap(int first, int second){ //меняем местами элементы
        Word temp = sentence.get(first);
        sentence.set(first, sentence.get(second));
        sentence.set(second, temp);

    }

    public static void Sort(){ //сортировка пузырьком относительно кол-ва гласных в слове
        for (int i = sentence.size() - 1; i >= 1; i--)
            for (int j = 0; j < i; j++)
                if (sentence.get(j).getCount_of_vowel() < sentence.get(j + 1).getCount_of_vowel())
                    toSwap(j, j + 1);
    }

    public static void main(String[] args) {
        System.out.println("Введите предложение для работы со словами:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine() + ' ';
        String current_word = ""; //текущее слово из предложения
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == ' ') { //вырезали слово из исходной строки
                sentence.add(new Word(makeUpper(current_word), countOfVowel(current_word))); //добавили в массив
                current_word = ""; //сбросили текущее слово
            }
            else
                current_word += input.charAt(i); //собираем текущее слово
        Sort(); //сортируем массив слов
        for (int i = 0; i < sentence.size(); i++) //выводим результат
            System.out.println(sentence.get(i).toString());
    }
}

class Word{ //каждое слово - объект
    String word = ""; //само слово
    int count_of_vowel = 0; //кол-во гласных

    public Word(String word, int count_of_vowel) {
        this.word = word;
        this.count_of_vowel = count_of_vowel;
    }

    public String getWord() {
        return word;
    }

    public int getCount_of_vowel() {
        return count_of_vowel;
    }

    @Override
    public String toString() { //вывод в консоль
        return "Слово: " + word + "; гласных: " + count_of_vowel;
    }
}