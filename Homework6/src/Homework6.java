
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Homework6 {

    public static void main(String[] args) {
        System.out.println("Введите текст:");
        //As         I          love         animals, so I’ve got a lot of them. Someone’s hobby is collecting stamps, doing exercises, drawing or learning foreign languages. Animals are my hobby. I like to look after them, feed and just watch them. I believe that animals bring us happiness and positive emotions. This, in its turn, has a positive effect on our moral and psychological state.

        //So let me tell you more about my pets. In my house you will find two dogs and one cat, aquarium with fish and two hamsters. Most of all I love dogs, but my mom loves cats. My brother is a very reserved person by character, so he keeps fish, but my sister loves hamsters. As for dad, his love is sufficient for all the animals. He, just like me, doesn’t mind playing with any pet in our house.

        //As I said earlier, I’m responsible mainly for the dogs in the house. Every day I take them for a walk twice. At the first opportunity I play with a ball with them or throw an artificial bone to them. My dogs are very smart and know a lot of tricks.

        //I believe that life without animals would be too boring. Animals are our friends that will never desert us.
        
        Scanner sc = new Scanner(System.in);
        
        StringBuilder testString = new StringBuilder();
        
        String text = sc.nextLine();
        
        List<String> words = new ArrayList<String>();
        text = text.toLowerCase().replaceAll("[^ a-zA-Z]", "");
        text = text.replaceAll("[\\s]{2,}", " ");

        String[] wordsArray = text.split("\\s");

        for (int i = 0; i < wordsArray.length; i++) {
            words.add(wordsArray[i]);
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))
                        && i != j) {
                    words.remove(j);
                }
            }
        }
        System.out.println();
        //System.out.println(words.size());
        System.out.println();

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (char alph : alphabet) {
            List<String> tempArray = new ArrayList<String>();
            for (int i = 0; i < words.size(); i++) {
                if (alph == words.get(i).charAt(0)) {
                    //System.out.println("Слово: " + words.get(i) + " -> Буква: " + alph);                    
                    tempArray.add(words.get(i));
                }
            }
            if (tempArray.size() > 0) {
                Collections.sort(tempArray);
                System.out.print(Character.toUpperCase(alph) + ": ");

                Iterator<String> iter = tempArray.iterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next() + " ");
                }
                System.out.println();
            }

        }

    }

}
