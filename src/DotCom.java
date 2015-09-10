import java.util.*;

/**
 * Created by hvosdt on 05.09.15.
 */
public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setName(String n) {
        name = n;
    }

    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";

        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "Потопил!";
                System.out.println("Вы потопили: " + name);
            } else {
                result = "Попал";
            }
        }
        return result;
        }
}
