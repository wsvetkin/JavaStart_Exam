import java.util.*;

public class PhoneBook {
    public static Map<String, ArrayList<String>> pbMap = new HashMap<>();


//    add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
//    Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
//    Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

    private static void add(String name, Integer phoneNum) {
        if (!pbMap.containsKey(name)) {
            pbMap.put(name, new ArrayList<>());
        }
        pbMap.get(name).add(String.valueOf(phoneNum));
    }

//    find(String name): Поиск номеров телефона по имени в телефонной книге.
//    Если запись с именем name существует, возвращает список номеров телефона для этой записи.
//    Если запись с именем name не существует, возвращает пустой список.

    static void find(String name) {
        if(pbMap.containsKey(name)) System.out.println(pbMap.get(name));
        else System.out.println(new ArrayList<>());
    }

//    getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров
//    телефона.

    static void getPhoneBook() {
        System.out.println(pbMap);
    }

//    Реализуйте структуру телефонной книги с помощью HashMap.
//    Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с
//    разными телефонами,
//    их необходимо считать, как одного человека с разными телефонами.
//
//    Вывод должен быть отсортирован по убыванию числа телефонов.
    static void printPhoneBook() {
        SortedSet<Map.Entry<String, ArrayList<String>>> sortedset = new TreeSet<Map.Entry<String, ArrayList<String>>>(
                new Comparator<Map.Entry<String,ArrayList<String>>>() {

                    @Override
                    public int compare(Map.Entry<String, ArrayList<String>> arg0, Map.Entry<String, ArrayList<String>> arg1) {
                        if (arg0.getValue().size() >= arg1.getValue().size())
                          return -1;
                        return 1;
                    }
                }
        );
        sortedset.addAll(pbMap.entrySet());
        for (Map.Entry<String, ArrayList<String>> em : sortedset){
            System.out.println(em);
        }
    }



    public static void main(String[] args) {
        add("Виктор", 454545);
        add("Саша", 123478);
        add("Лена", 894534);

        add("Лена", 836534);
        add("Лена", 894188);

        add("Виктор", 454555);

        getPhoneBook();
        System.out.println("\n");
        printPhoneBook();
    }
}
