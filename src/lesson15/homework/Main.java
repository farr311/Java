package lesson15.homework;

public class Main {
    /*TODO
       Написать интерфейс Класс Button с методом void click(ButtonAction action)
       Написать функциональный интерфейс ButtonAction с методом performAction
       Создать Button и вызвать у него метод click 2 раза -- с лямбдой и с method
       reference (для этого нужно будет создать реализацию интерфейса ButtonAction)
     */

    public static void main(String[] args) {
        Main m = new Main();
        m.testButtons();
    }

    private void testButtons() {
        Button b = new Button();
        b.click(() -> System.out.println("Action"));
        b.click(MyButtonAction::performAction);
    }


    class MyButtonAction implements ButtonAction {

        @Override
        public void performAction() {
            System.out.println("Action 2");
        }
    }
}
