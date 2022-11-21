import java.util.ArrayList;
import java.util.Scanner;
public class Lab11 {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean done = false;
        System.out.println("Welcome!");
        do{
            String response = menu(pipe, "What would you like to do? [Add-Delete-Print-Quit]", "[AaDdPpQq]",myArrList);
            switch (response) {
                case "A","a":
                    String add = SafeInput.getNonZeroLenString(pipe,"What would you like to add?");
                    myArrList.add(add);
                    break;
                case "D","d":
                    displayNumberedArray(myArrList);
                    int delete = SafeInput.getInt(pipe,"What entry would you like to delete?") - 1;
                    myArrList.remove(delete);
                    break;
                case "P","p":
                    displayNumberedArray(myArrList);
                    break;
                case "Q","q":
                    done = SafeInput.getYNConfirm(pipe,"Would you like to continue? [Y/N]");
                    break;
            }
        }while (!done);
    }
    private static String menu(Scanner pipe,String prompt,String regEx,ArrayList<String> myArrList){
        if(myArrList.size() != 0){
            for(String value: myArrList){
                System.out.printf("%s ",value);
            }
        }else{
            System.out.println("Your list will be displayed once something gets added to the array.");
        }
        String retVal = SafeInput.getRegExString(pipe,prompt,regEx);
        return retVal;
    }
    private static void displayNumberedArray(ArrayList<String> myArrList){
        int i = 1;
        System.out.println("");
        for(String value: myArrList){
            System.out.printf("%d(%s) ",i,value);
            i = i + 1;
        }
        System.out.println("");
    }
}