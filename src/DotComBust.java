import java.util.*;

public class DotComBust {

    private static GameHelper helper = new GameHelper();
    private static ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private static int numOfGuesses = 0;

    public static void setUpGame() {

        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("yandex.ru");
        DotCom three = new DotCom();
        three.setName("google.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель потопить три сайта");
        System.out.println("Pets.com, yandex.ru, google.com");
        System.out.println("На поле 'ABCDEFG' '1234567'");
        System.out.println("Попытайтесь сделать это за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
         }
    }


    public static void startPlaying() {

        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход: ");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private static void checkUserGuess(String userGuess) {

        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил!")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);
    }

    public static void finishGame() {

        System.out.print("Количество попыток: " + numOfGuesses);
    }


    public static void main(String[] args) {

        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }
}
