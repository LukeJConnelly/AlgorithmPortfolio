import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello and welcome to my Algorithms Lab repo.\n" +
                "This class will demonstrate my java work over the 9 practicals.\n\n" +
                "Practical 1: Russian Peasants Algorithm\n" +
                "Practical 2: Three Sum\n" +
                "Practical 3: Towers of Hanoi\n" +
                "Practical 4: Insertion vs Selection Sorts\n"+
                "Practical 5: Insertion vs Merge Sorts\n"+
                "Practical 6: Merge vs Quick Sorts\n"+
                "Practical 7: Substring Searches\n"+
                "Practical 8: Tries\n"+
                "Practical 9: Run Length Encoding\n\n"+
                "To get started, please enter the number of the practical (eg. '1' for Russian Peasants Algorithm) you would like to view:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String i="";
        while(!(s.matches("[1-9]")||s.matches("quit")||s.matches("QUIT")))
        {
            System.out.println("Input not recognized, please re-enter");
            s = scanner.nextLine();
        }
        while(!(s.matches("quit")||s.matches("QUIT")))
        {
            if(s.matches("[1]"))
            {
                System.out.println("RUSSIAN PEASANTS ALGORITHM:\n" +
                        "You can now either enter two numbers you wish to multiply, seperated by a single space, or else enter " +
                        "NONE to see the default arguments (25 63)");
                i = scanner.nextLine();
                while(!(i.matches("[0-9]{1,}[ ][0-9]{1,}")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    RusPesAlg.main(args);
                }
                else{
                    String[] userArgs = i.split(" ");
                    RusPesAlg.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[2]"))
            {
                System.out.println("THREE SUM:\n" +
                        "You can now either enter the file you would like threesum to use, or else enter " +
                        "NONE to see the default file (1Kints.txt)");
                System.out.println("The available files are:\n" +
                        "1Kints.txt\n2Kints.txt\n4Kints.txt\n8Kints.txt\n" +
                        "16Kints.txt\n32Kints.txt\n8ints.txt");
                i = scanner.nextLine();
                while(!(i.matches("[1248]Kints.txt")||i.matches("16Kints.txt")||i.matches("32Kints.txt")||i.matches("8ints.txt")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                System.out.println("Thank you");
                if(i.toUpperCase().matches("NONE"))
                {
                    ThreeSumA.main(args);
                    ThreeSumB.main(args);
                }
                else{
                    String[] userArgs = new String[1];
                    userArgs[0] = i;
                    ThreeSumA.main(userArgs);
                    ThreeSumB.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[3]"))
            {
                System.out.println("TOWERS OF HANOI:\n" +
                        "Help the monks! Enter the number of discs they must move or else enter " +
                        "NONE to see the default (3)");
                i = scanner.nextLine();
                while(!(i.matches("[0-9]{2,}")||i.matches("[1-9]")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    towersOfHanoi.main(args);
                }
                else{
                    String[] userArgs = new String[1];
                    userArgs[0] = i;
                    towersOfHanoi.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[4]"))
            {
                System.out.println("Insertion Sort VS Selection Sort VS My Idiotic Sort:\n" +
                        "Enter the starting size of the array, followed by the maximum size of the array you would like to sort. (Size increments by default by 1000)\n" +
                        "Then enter yes or no to include my idiotic sort (not recommended for large sizes). Seperate each argument with a space.\n" +
                        "Alternatively enter NONE to see the default (Starting Size = 1000, Max Size = 2000, no Idiotic sort)");
                i = scanner.nextLine();
                while(!(i.matches("[0-9]{1,}[ ][0-9]{1,}[ ]yes")||i.matches("[0-9]{1,}[ ][0-9]{1,}[ ]no")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    InsertionVSSelection.main(args);
                }
                else{
                    String[] userArgs = i.split(" ");
                    InsertionVSSelection.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[5]"))
            {
                System.out.println("Insertion Sort VS Merge Sort VS Enhanced Merge Sort:\n" +
                        "Enter the starting size of the array, followed by the maximum size of the array you would like to sort. (Size increments by default by 1000)\n" +
                        "Seperate the numbers with a single space.\n" +
                        "Alternatively enter NONE to see the default (Starting Size = 1000, Max Size = 2000)");
                i = scanner.nextLine();
                while(!(i.matches("[0-9]{1,}[ ][0-9]{1,}")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    InsertionVSMerge.main(args);
                }
                else{
                    String[] userArgs = i.split(" ");
                    InsertionVSMerge.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[6]"))
            {
                System.out.println("Merge Sort VS Quick Sort VS Enhanced Quick Sort:\n" +
                        "Enter the starting size of the array, followed by the maximum size of the array you would like to sort. (Size increments by default by 1000)\n" +
                        "Seperate the numbers with a single space.\n" +
                        "Alternatively enter NONE to see the default (Starting Size = 1000, Max Size = 2000)");
                i = scanner.nextLine();
                while(!(i.matches("[0-9]{1,}[ ][0-9]{1,}")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    MergeVSQuickSort.main(args);
                }
                else{
                    String[] userArgs = i.split(" ");
                    MergeVSQuickSort.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[7]"))
            {
                System.out.println("SUBSTRING SEARCH:\n" +
                        "Enter the text, followed by the pattern you would like to find\n" +
                        "Seperate the texts with only |\n" +
                        "Alternatively enter NONE to see the default");
                i = scanner.nextLine();
                while(!(i.matches(".+[|].+")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    SubstringSearch.main(args);
                }
                else{
                    String[] userArgs = i.split("[|]");
                    SubstringSearch.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[8]"))
            {
                System.out.println("TRIES:\n" +
                        "Enter the tries (two or more) you would like to generate, each lowercase and containing only the letters a-z. Seperate each with a space.\n" +
                        "The code will search for 'one', 'seventy' and 'banana'\n" +
                        "Alternatively enter NONE to see the default (the numbers from 'one' to 'ten')");
                i = scanner.nextLine();
                while(!(i.matches("([a-z]{1,}[ ]){1,}[a-z]{1,}")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    Trie.main(args);
                }
                else{
                    String[] userArgs = i.split("[ ]");
                    Trie.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else if(s.matches("[9]"))
            {
                System.out.println("RUN LENGTH ENCODING:\n" +
                        "Enter any number of strings below which you would like to compress\n" +
                        "Seperate the string with only |\n" +
                        "Alternatively enter NONE to see the defaults compressed");
                i = scanner.nextLine();
                while(!(i.matches("(.+[|]){1,}.+")||i.toUpperCase().matches("NONE")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    i = scanner.nextLine();
                }
                if(i.toUpperCase().matches("NONE"))
                {
                    RunLengthEncoding.main(args);
                }
                else{
                    String[] userArgs = i.split("[|]");
                    RunLengthEncoding.main(userArgs);
                }
                s="";
                System.out.println("Please enter the number of the next practical you would like to view or QUIT below");
            }
            else{
                s=scanner.nextLine();
                while(!(s.matches("[1-9]")||s.matches("quit")||s.matches("QUIT")))
                {
                    System.out.println("Input not recognized, please re-enter");
                    s = scanner.nextLine();
                }
            }
        }
        System.out.println("Sure thing! Thanks for reading, bye!");
    }
}