package keywordmatrix;

import java.util.Scanner;

/**
 *
 * @author Archit
 */
/*----------------------------------------------------------*/
/*----------------------------------------------------------*/
/*
This class works upon a specific keyword which is entered
by the user. It could be anything, a keyword or your 
favourite word.Something which is not too well known to the world.
*/
/*----------------------------------------------------------*/
/*----------------------------------------------------------*/
public class KeywordMatrix 
{
    static int []arr = new int[26];
    
    static int fetchCharacterPosition(char c)
    {
        int no = c;
        return (no-96);
    }
    
    static int mouldTheArray(char ch)
    {
       int []tempArray = new int[26];
       
       int posToStop = fetchCharacterPosition(ch);
        //System.out.println("----");
        //System.out.println(posToStop);
        //System.out.println("----");
       for(int i = 0; i<26; i++)
       {
           
           tempArray[i] = arr[i];
           if((i+1)==posToStop)
           {
               for(int downCounter = posToStop, iterator = 0; downCounter>0; downCounter--, iterator++)
               {
                   arr[iterator] = tempArray[downCounter-1];
               }
               break;
           }
           
       }
       return 0; 
    }
    
    static void initializeTheArray()//To be called once.
    {
        for(int i = 0; i<26; i++)
        {
            arr[i] = i+1;
        }
    }

    public static void main(String[] args) 
    {
        initializeTheArray();
        String string = new String();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your keyword: ");
            //No blank spaces in the keyword...for now.
        string = scanner.next();
            //System.out.println(fetchCharacterPosition('e'));
        for(int i = 0; i<string.length(); i++)// loop will run till the word length
        {
            //System.out.println(string.charAt(i));
            mouldTheArray(string.charAt(i));
            
        }
        for(int i=0; i<26; i++)
        {
            System.out.println(arr[i]);
        }
    }
    
}
