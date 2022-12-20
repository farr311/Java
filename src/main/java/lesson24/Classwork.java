package lesson24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Classwork {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Proin sagittis nisl rhoncus mattis. Pellentesque habitant morbi " +
            "tristique senectus et netus et malesuada fames. Id ornare arcu odio " +
            "ut sem nulla. Nulla facilisi nullam vehicula ipsum a arcu cursus vitae " +
            "congue. Vulputate ut pharetra sit amet aliquam id diam maecenas ultricies. " +
            "Volutpat est velit egestas dui id. Sit amet dictum sit amet. Sodales ut " +
            "etiam sit amet nisl purus in. Etiam tempor orci eu lobortis elementum. " +
            "Blandit cursus risus at ultrices mi. Tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.\n" +
            "\n" +
            "In ornare quam viverra orci sagittis eu. Dictum at tempor commodo ullamcorper a. " +
            "Nunc sed id semper risus in hendrerit gravida. Purus non enim praesent elementum. " +
            "Dignissim sodales ut eu sem integer vitae justo eget. Lectus nulla at volutpat " +
            "diam ut venenatis. Nibh sit amet commodo nulla facilisi nullam vehicula ipsum a." +
            " Arcu bibendum at varius vel. Feugiat sed lectus vestibulum mattis ullamcorper. " +
            "Mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan. Tempus quam " +
            "pellentesque nec nam aliquam sem et tortor. Habitasse platea dictumst quisque " +
            "sagittis purus sit amet. At erat pellentesque adipiscing commodo. Aliquet sagittis " +
            "id consectetur purus. Et pharetra pharetra massa massa ultricies. Purus in mollis " +
            "nunc sed id semper risus in. Senectus et netus et malesuada. Velit dignissim sodales ut eu" +
            " sem integer vitae.\n" +
            "\n" +
            "Adipiscing at in tellus integer feugiat scelerisque. Suspendisse interdum consectetur " +
            "libero id faucibus nisl tincidunt eget. Ipsum suspendisse ultrices gravida dictum fusce" +
            " ut. Habitasse platea dictumst quisque sagittis. Augue mauris augue neque gravida in " +
            "fermentum. Lorem sed risus ultricies tristique nulla aliquet enim tortor at. Gravida " +
            "in fermentum et sollicitudin. Auctor neque vitae tempus quam pellentesque nec nam " +
            "aliquam sem. Potenti nullam ac tortor vitae purus faucibus ornare suspendisse. " +
            "Aliquam ultrices sagittis orci a scelerisque purus semper. Scelerisque varius " +
            "morbi enim nunc faucibus a pellentesque sit. Interdum consectetur libero id faucibus " +
            "nisl tincidunt eget nullam non. Egestas quis ipsum suspendisse ultrices gravida. Cras " +
            "adipiscing enim eu turpis. Non pulvinar neque laoreet suspendisse interdum consectetur " +
            "libero id faucibus. Enim ut sem viverra aliquet eget sit amet. Nisi est sit amet facilisis" +
            "magna etiam tempor orci eu. Blandit turpis cursus in hac habitasse platea dictumst quisque. " +
            "Lectus quam id leo in vitae turpis massa sed elementum. Diam sit amet nisl suscipit adipiscing.\n" +
            "\n" +
            "Sed faucibus turpis in eu. Et netus et malesuada fames ac turpis egestas. " +
            "Malesuada proin libero nunc consequat interdum varius sit amet mattis. Ut" +
            " pharetra sit amet aliquam id diam maecenas. Elit pellentesque habitant " +
            "morbi tristique senectus. Risus nec feugiat in fermentum. At quis risus " +
            "sed vulputate. Condimentum vitae sapien pellentesque habitant morbi " +
            "tristique senectus. Risus feugiat in ante metus dictum at. Eleifend " +
            "quam adipiscing vitae proin sagittis nisl rhoncus.\n" +
            "\n" +
            "Fames ac turpis egestas integer eget. Dolor purus non enim praesent elementum" +
            " facilisis leo vel fringilla. Molestie at elementum eu facilisis sed odio" +
            " morbi quis commodo. Vitae justo eget magna fermentum iaculis eu non. " +
            "Vivamus at augue eget arcu dictum varius duis at. Vitae ultricies leo " +
            "integer malesuada nunc vel risus. Risus pretium quam vulputate dignissim " +
            "suspendisse in est ante in. Massa enim nec dui nunc. Aliquam ultrices " +
            "sagittis orci a scelerisque purus. Tincidunt vitae semper quis lectus" +
            " nulla at. Lorem ipsum dolor sit amet consectetur adipiscing elit ut" +
            " aliquam. Libero justo laoreet sit amet cursus sit amet dictum sit.";

    //TODO:
    // 1. Разбить текст на слова через регулярное выражение с поиском символов белого пространства
    // 2. Удалить все оставшиеся символы пунктуации
    // 3. Выбрать все слова, которые начинаются с заглавной буквы
    // 4. Выбрать все слова, в которых 4+ символов
    // 5. Сделать первую букву строчной
    // 6. Сделать последние 2 буквы большими
    // 7. Объединить слова с одну строку через "-"
    // 8. Вывести в консоль так, чтобы ни в начале, ни в конце не было лишних дефисов
    // Для решения данного задания нельзя использовать какие-либо циклы. Задание должно решаться через комбинацию стримов
    // и регулярок
    public static void main(String[] args) {
        /*List l = Arrays.stream(text.split("\\s+"))
                .map(s -> s.replaceAll("[,.]", ""))
                .filter(s -> s.matches("[A-Z]\\w*"))
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());

        System.out.println(l);*/

        String result = String.join("-",Arrays.stream(text.split("\\W+"))
                .map(s -> s.replaceAll("[,.]", ""))
                .filter(s -> s.matches("[A-Z]\\w*"))
                .filter(s -> s.length() > 3)
                .map(w -> w.substring(0,1).toLowerCase()
                        .concat(w.substring(1, w.length() - 2))
                        .concat(w.substring(w.length()-2).toUpperCase()))
                .toList());
        System.out.println(result);

    }
}
