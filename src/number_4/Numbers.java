package number_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Numbers { //построение цифр из звездочек
    static String[] zero = new String[7];
    static String[] one = new String[7];
    static String[] two = new String[7];
    static String[] three = new String[7];
    static String[] four = new String[7];
    static String[] five = new String[7];
    static String[] six = new String[7];
    static String[] seven = new String[7];
    static String[] eight = new String[7];
    static String[] nine = new String[7];
    static ArrayList<String> result = new ArrayList<>(7); //массив, выводимый в консоль

    public static String[] create_zero(){
        zero[0] = "   ***   ";
        zero[1] = " *     * ";
        zero[2] = "*       *";
        zero[3] = "*       *";
        zero[4] = "*       *";
        zero[5] = " *     * ";
        zero[6] = "   ***   ";
        return zero;
    }

    public static String[] create_one(){
        one[0] = "    *    ";
        one[1] = "  * *    ";
        one[2] = "*   *    ";
        one[3] = "    *    ";
        one[4] = "    *    ";
        one[5] = "    *    ";
        one[6] = "*********";
        return one;
    }

    public static String[] create_two(){
        two[0] = "  *****  ";
        two[1] = "*       *";
        two[2] = "       * ";
        two[3] = "     *   ";
        two[4] = "   *     ";
        two[5] = " *       ";
        two[6] = "*********";
        return two;
    }

    public static String[] create_three(){
        three[0] = "*******  ";
        three[1] = "       * ";
        three[2] = "     *   ";
        three[3] = "  *****  ";
        three[4] = "        *";
        three[5] = "        *";
        three[6] = "******   ";
        return three;
    }

    public static String[] create_four(){
        four[0] = "   *    *";
        four[1] = "  *     *";
        four[2] = " *      *";
        four[3] = "*********";
        four[4] = "        *";
        four[5] = "        *";
        four[6] = "        *";
        return four;
    }

    public static String[] create_five(){
        five[0] = "*********";
        five[1] = "*        ";
        five[2] = "*        ";
        five[3] = "  ****** ";
        five[4] = "        *";
        five[5] = "        *";
        five[6] = " ******  ";
        return five;
    }

    public static String[] create_six(){
        six[0] = "       * ";
        six[1] = "     *   ";
        six[2] = "   *     ";
        six[3] = "  *****  ";
        six[4] = "*       *";
        six[5] = "*       *";
        six[6] = "  *****  ";
        return six;
    }

    public static String[] create_seven(){
        seven[0] = "*********";
        seven[1] = "       * ";
        seven[2] = "      *  ";
        seven[3] = "   ***** ";
        seven[4] = "    *    ";
        seven[5] = "    *    ";
        seven[6] = "    *    ";
        return seven;
    }

    public static String[] create_eight(){
        eight[0] = "   ***   ";
        eight[1] = " *     * ";
        eight[2] = " *     * ";
        eight[3] = "   ***   ";
        eight[4] = "*       *";
        eight[5] = "*       *";
        eight[6] = "  *****  ";
        return eight;
    }

    public static String[] create_nine(){
        nine[0] = "*********";
        nine[1] = "*       *";
        nine[2] = "*       *";
        nine[3] = " ********";
        nine[4] = "       * ";
        nine[5] = "      *  ";
        nine[6] = "     *   ";
        return nine;
    }

    public static ArrayList<String> create_number(String[] insert){ //собираем число для вывода
        for (int i = 0; i < 7; i++)
            result.set(i, result.get(i) + " " + insert[i]);
        return result;
    }

    public static String[] create_max_digit(String[] digit, char max_digit){ //заменяем отображение макс цифры из звездочек на ее значение
        for (int i = 0; i < 7; i++)
            digit[i] = digit[i].replace('*', max_digit);
        return digit;
    }

    public static void main(String[] args) {
        System.out.println("Введите целое положительное число для отображения на экране: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String number_to_write = reverse(input); //переворачиваем число
        char max_digit = Character.forDigit(max_digit(input), 10); //находим макс цифру
        for (int i = 0; i < 7; i++) //заполняем массив-результат пустыми значениями
            result.add("");
        for (int i = 0; i < number_to_write.length(); i++){
            switch (number_to_write.charAt(i)){ //в зависимости от цифры числа создаем нужное отображение
                //и добавляем его в массив-результат
                case '0':
                    if (max_digit == '0') //если это - макс цифра числа
                        //предварительно заменим '*' на '0' и также добавим в массив-результат
                        create_number(create_max_digit(create_zero(), max_digit));
                    else //если это не макс цифра
                        create_number(create_zero()); //просто добавляем отображение из '*' в массив-результат
                    break;
                case '1':
                    if (max_digit == '1')
                        create_number(create_max_digit(create_one(), max_digit));
                    else
                        create_number(create_one());
                    break;
                case '2':
                    if (max_digit == '2')
                        create_number(create_max_digit(create_two(), max_digit));
                    else
                        create_number(create_two());
                    break;
                case '3':
                    if (max_digit == '3')
                        create_number(create_max_digit(create_three(), max_digit));
                    else
                        create_number(create_three());
                    break;
                case '4':
                    if (max_digit == '4')
                        create_number(create_max_digit(create_four(), max_digit));
                    else
                        create_number(create_four());
                    break;
                case '5':
                    if (max_digit == '5')
                        create_number(create_max_digit(create_five(), max_digit));
                    else
                        create_number(create_five());
                    break;
                case '6':
                    if (max_digit == '6')
                        create_number(create_max_digit(create_six(), max_digit));
                    else
                        create_number(create_six());
                    break;
                case '7':
                    if (max_digit == '7')
                        create_number(create_max_digit(create_seven(), max_digit));
                    else
                        create_number(create_seven());
                    break;
                case '8':
                    if (max_digit == '8')
                        create_number(create_max_digit(create_eight(), max_digit));
                    else
                        create_number(create_eight());
                    break;
                case '9':
                    if (max_digit == '9')
                        create_number(create_max_digit(create_nine(), max_digit));
                    else
                        create_number(create_nine());
                    break;
            }
        }
        write();
    }

    public static String reverse(int number){ //реверс числа
        String result = "";
        if (number == 0)
            result = "0";
        while (number > 0){
            result = Character.forDigit(number % 10, 10) + result; //собираем перевернутое число в строку
            number /= 10;
        }
        return result;
    }

    public static int max_digit(int number){ //поиск макс цифры
        int max = -1;
        if (number == 0)
            max = 0;
        while (number != 0){
            if (number % 10 > max)
                max = number % 10;
            number /= 10;
        }
        return max;
    }

    public static void write(){ //вывод массива в консоль
        for (int i = 0; i < 7; i++)
            System.out.println(result.get(i));
    }
}