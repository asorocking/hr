
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Homework6 {

    public static void main(String[] args) {
        System.out.println("Введите текст:");
        //12As        I          love         animals, so I’ve got a lot of them. Someone’s hobby is collecting stamps, doing exercises, drawing or learning foreign languages. Animals are my hobby. I like to look after them, feed and just watch them. I believe that animals bring us happiness and positive emotions. This, in its turn, has a positive effect on our moral and psychological state.
       
        StringBuilder testString = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        
        //ArrayList to keeps single words
        List<String> words = new ArrayList<String>();

        //Cast text to lower case and remove all not symbols and 
        //not white-spaces
        text = TextTools.prepareText(text);

        //Spliting text to single words by white-space
        words = TextTools.splitText(text);
        
        //delete repeated words from arrayList
        words = TextTools.deleteRepeats(words);
        
        //divide and sort words by alphabet
        TextTools.divideByAlphabet(words);
    }
}

class TextTools {
    
    private static final List<String> words = new ArrayList<String>();
    
    //delete repeated words from arrayList
    public static List<String> deleteRepeats (List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j)) && i != j) {
                    words.remove(j);
                }
            }
        }
        return words;
    }
    
    public static List<String> splitText(String text) {
        //Spliting text to single words by white-space
        String[] wordsArray = text.split("\\s");

        for (int i = 0; i < wordsArray.length; i++) {
            words.add(wordsArray[i]);
        }
        return words;
    }
    
    public static String prepareText(String text) {
        //Cast text to lower case and remove all not symbols and 
        //not white-spaces
        text = text.toLowerCase().replaceAll("[^ a-zA-Z]", "");
        //Remove all double white-spaces
        text = text.replaceAll("[\\s]{2,}", " ");
        return text;
    }
    
    public static void divideByAlphabet(List<String> words){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};
        
        //divide and sort words by alphabet
        for (char alph : alphabet) {
            List<String> tempArray = new ArrayList<String>();
            for (int i = 0; i < words.size(); i++) {
                //compare current alphabet's letter and first letter of current 
                //word from arrayList
                if (alph == words.get(i).charAt(0)) {
                    tempArray.add(words.get(i));
                }
            }
            //if exist words by current alphabet letter
            if (tempArray.size() > 0) {
                //sorting words by current alphabet letter
                Collections.sort(tempArray);
                System.out.print(Character.toUpperCase(alph) + ": ");

                //print sorting words by current alphabet letter
                Iterator<String> iter = tempArray.iterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next() + " ");
                }
                System.out.println();
            }

        }
    }
}