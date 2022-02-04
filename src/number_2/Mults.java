package number_2;

import java.util.Scanner;

public class Mults {
    public static void main(String[] args) {
        System.out.println("Введите положительное целое число для получения разложения на множители:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (!checkInput(input)) //проверка ввода числа
            System.out.println("Введено не целое число, ошибка выполнения");
        else {
            System.out.println("Множители введенного числа:");
            int ind_of_com = input.indexOf(','); //индекс разделителя-запятой (пр. 12,0)
            int ind_of_paint = input.indexOf('.'); //индекс разделителя-точки (пр. 12.0)
            int number; //число для деления на множители
            String part = "";
            if (ind_of_com > -1) { //если разделитель-запятая (пр. 12,0)
                part = input.substring(0, ind_of_com); //целая часть числа
                number = Integer.parseInt(part);
            }
            else if (ind_of_paint > -1) { //если разделитель-точка (пр. 12.0)
                part = input.substring(0, ind_of_paint); //целая часть числа
                number = Integer.parseInt(part);
            }
            else
                number = Integer.parseInt(input); //если число введено без разделителя (пр. 12)
            int number_copy = number; //копия числа для дальнейших действий
            int mult = 2; //первый возможный множитель
            while (number_copy > 1 && mult <= Math.sqrt(number)){
                //условие выхода: если число стало равно единице,
                //либо текущий множитель превысил значение квадратного корня
                //из исходного числа
                if (number_copy % mult == 0){ //если число является множителем
                    System.out.print(mult + " ");
                    number_copy /= mult;
                }
                else if (mult == 2) //если все четные множители выведены
                    mult++;
                else
                    mult += 2;}
            if (number_copy != 1) //если само число в остатке также является своим множителем
                System.out.print(number_copy);
        }
    }

    public static boolean checkInput(String input){
        int ind_of_com = input.indexOf(','); //индекс разделителя-запятой
        int ind_of_paint = input.indexOf('.'); //индекс разделителя-точки
        String part = ""; //часть числа после разделителя
        if (ind_of_com > -1){ //если разделитель-запятая (пр. 12,003)
            part = input.substring(ind_of_com + 1, input.length()); //часть числа после запятой (пр. 003)
            if (Integer.parseInt(part) != 0) //если там есть цифры, кроме 0
                return false; //число не целое
        }
        else if (ind_of_paint > -1){ //если разделитель-точка (пр. 12.003)
            part = input.substring(ind_of_paint + 1, input.length()); //часть числа после точки
            if (Integer.parseInt(part) != 0) //если там есть цифры, кроме 0
                return false; //число не целое
        }
        return true; //числа типа 12.0; 12,0; 12
    }
}
