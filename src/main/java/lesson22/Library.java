package lesson22;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {

    //TODO:
    // 1. Реализовать класс таким образом, чтобы он мог хранить в себе объекты всех 4 типов
    //  Написать реализацию без дженериков и с дженериками
    //  реализовать методы get и add
    //  Все объекты должны храниться в списке/массиве
    //
    //TODO:
    // 2. Написать дополнительную реализацию для ситуации, когда все 4 класса
    //  будут наследниками интерфейса Media


    List<T> list = new ArrayList<>();

    public T get(int index) {
        return list.get(index);
    }

    public void add(T o) {
        list.add(o);
    }
}

interface Media {}

class Book {

}

class Manuscript {

}

class Newspaper {

}

class Magazine {

}
