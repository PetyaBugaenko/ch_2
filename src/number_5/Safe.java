package number_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Safe {
    static class Item { //класс хранит свойства одного предмета
        int volume; //объем
        int value; //ценность

        public Item(int volume, int value) {
            this.volume = volume;
            this.value = value;
        }

        public int getVolume() {
            return volume;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Объем = " + volume + "; Ценность = " + value;
        }
    }

    static ArrayList<Item> optimal_items = new ArrayList<>(); //оптимальный набор предметов
    static int max_volume = 0; //максимальный объем сейфа
    static int optimal_value = 0; //общая ценность предметов

    public static int count_volume(ArrayList<Item> items){ //суммарный объем набора предметов
        int current_volume = 0;
        for (int i = 0; i < items.size(); i++)
            current_volume += items.get(i).volume;
        return current_volume;
    }

    public static int count_value(ArrayList<Item> items){ //суммарная ценность набора предметов
        int current_value = 0;
        for (int i = 0; i < items.size(); i++)
            current_value += items.get(i).value;
        return current_value;
    }

    public static void check_set(ArrayList<Item> items){ //проверка, является ли данный набор лучшим решением
        if (optimal_items == null) { //если набор предметов пуст
            if (count_volume(items) <= max_volume) { //если проверяемый набор предметов имеет необходимый объем
                optimal_items = items; //записываем его как оптимальный
                optimal_value = count_value(items);
            }
        }
        else //если уже существует оптимальный набор предметов
            if (count_volume(items) <= max_volume && count_value(items) > optimal_value) { //является ли проверяемый набор предметов более оптимальным
                optimal_items = items; //меняем набор
                optimal_value = count_value(items);
            }
    }

    public static void search_set(ArrayList<Item> items){
        if (items.size() > 0) //если набор предметов не пуст
            check_set(items); //проверяем его оптимальность
        for (int i = 0; i < items.size(); i++){
            ArrayList<Item> new_set_of_items = new ArrayList<>(items); //новый набор предметов
            new_set_of_items.remove(i); //удаляем один предмет
            search_set(new_set_of_items); //рекурсивно проверяем полученный набор
        }
    }

    public static void write(){ //вывод в консоль
        for (int i = 0; i < optimal_items.size(); i++)
            System.out.println(optimal_items.get(i).toString());
    }

    public static void main(String[] args) {
        System.out.println("Укажите количество предметов в наборе: ");
        Scanner in = new Scanner(System.in);
        int count_of_items = in.nextInt(); //общее количество предметов
        int volume_of_item; //объем одного предмета
        int value_of_item; //ценность одного предмета
        for (int i = 0; i < count_of_items; i++) {
            System.out.println("Введите значение объема:");
            volume_of_item = in.nextInt();
            System.out.println("Введите значение ценности:");
            value_of_item = in.nextInt();
            optimal_items.add(new Item(volume_of_item, value_of_item)); //добавляем предмет в набор
        }
        System.out.println("Введите значение объема сейфа:");
        max_volume = in.nextInt(); //устанавливаем объем сейфа
        search_set(optimal_items); //ищем оптимальный набор
        System.out.println("Оптимальный набор предметов для заданного объема сейфа: ");
        write();
    }
}
