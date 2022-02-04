package number_1;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Введите строку для подсчета суммы цифр в ней:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine(); //считывание строки с консоли
        int sum = 0;
        for (int i = 0; i < input.length(); i++)
            if (Character.isDigit(input.charAt(i))) //является ли символ цифрой
                sum += Character.getNumericValue(input.charAt(i)); //суммирование цифр
        System.out.println("Сумма цифр в строке: " + sum);
    }
}
