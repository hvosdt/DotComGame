public class Main {

    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotComGame = new SimpleDotCom();
        int randomNum = (int) (Math.random() *5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};

        theDotComGame.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive){
            String guess = helper.getUserInput("Введите число");
            String result = theDotComGame.checkYourself(guess);
            numOfGuesses++;
            if (result == "Потопил"){
                isAlive = false;
                System.out.println("Количество попыток: " + numOfGuesses);
            }
        }
    }
}
