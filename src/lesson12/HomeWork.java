package lesson12;

import java.util.*;

public class HomeWork {

    // 2. Напишите простую реализацию HashMap на основе динамического массива.
    // Для этого вам потребуется реализовать класс Node<K, V>,
    // где будет храниться ключ и значений и метод,
    // который будет искать нужный индекс массива через hashcode ключа и размер массива.
    // Стоить учесть, что при увеличении размера массива нужно провесить рехэшинг
    // (перезаписать все существующие элементы массива на новые позиции, так как изменился размер).
    // Если этого не сделать, поиск по индексам будет работать некорректно.
    // В рамках данного задания вам не нужно волноваться о потенциальных коллизиях


    // 1. Сгруппируйте слова с одинаковым набором символов
    // Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором
    // символов.
    // вход: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
    // выход:
    // student, students,
    // cat, act,
    // dog, god,
    // flow, wolf
    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
        groupWords(words);
    }

    static void groupWords(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            int index = 1;
            int pos = 1;

            while (index != chars.length) {
                if (chars[index] != chars[index - 1]) {
                    chars[pos] = chars[index];
                    pos++;
                }
                index++;
            }

            String str = String.valueOf(chars);
            str = str.substring(0, pos);

            if (map.containsKey(str)) {
                map.get(str).add(s);
            } else {
                map.put(str, new ArrayList<>() {{ add(s); }});
            }
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    private static void groupWords1(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            Map<Character, String> sMap = new HashMap<>();
            for (char aChar : chars) {
                sMap.put(aChar, s);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, String> pair : sMap.entrySet()){
                sb.append(pair.getKey());
            }

            //TODO

            String str = sb.toString();
            List<String> list = new ArrayList<>();
            list.add(s);
            List<String> values = map.getOrDefault(str, list);

            if (!values.contains(s)){
                values.add(s);
            }
            System.out.println(values);
        }

    }

}
