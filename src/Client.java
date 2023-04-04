import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            RandomOut href = RandomOutHelper.narrow(ncRef.resolve_str("Random_SERVER"));


            Scanner scan = new Scanner(System.in);
            String word1;
            String word2;

            System.out.println("\tВВОД ДАННЫХ");

            while (true) {

                System.out.println("Пожалуйста, введите первое слово: ");
                try {
                    word1 = scan.nextLine();
                    if (word1.matches("[а-яА-Я]+")) {
                        list.add(word1);
                        System.out.println("ok");
                        break;
                    } else {
                        System.out.println("ОШИБКА: ВВЕДИТЕ БУКВЫ!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            while (true) {

                System.out.println("Пожалуйста, введите второе слово: ");
                try {
                    word2 = scan.nextLine();
                    if (word2.matches("[а-яА-Я]+")) {
                        list.add(word2);
                        break;
                    } else {
                        System.out.println("ОШИБКА: ВВЕДИТЕ БУКВЫ!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("ok?");
            String goOutToMethod = list.toString();
            System.out.println(goOutToMethod);

            System.out.println(word1.charAt(0));
            System.out.print(word1.charAt(1));



            // word.charAt(0);


           // String word = "abc";
//            href.addWords(list);
//            System.out.println(href.getLetters());
//            print(href.addWords(word1));
//            print(href.addWords(word2));
//            print(href.getLetters(list));


        } catch (InvalidName | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | NotFound invalidName) {
            invalidName.printStackTrace();
        }
    }

    public static void print(String list){
        System.out.println(list);
    }
}
