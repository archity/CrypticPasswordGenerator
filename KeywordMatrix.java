
package cypher;



import java.util.Scanner;
import java.lang.*;

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
    
    int []arr = new int[26];
    public KeywordMatrix(String str)
    {
        
        initializeTheArray();
            
        for(int i = 0; i<str.length(); i++)// loop will run till the word length
        {
            mouldTheArray(str.charAt(i));   
        }
        
    }
    
    
    
    static int fetchCharacterPosition(char c)
    {
        int no = c;
        
           
        if(no >= 97) 
        {
            no = no-97;
        }
        else if(no >=65 && no <= 90)//to take care of the capital letters.
        {
            no = no-65;
        }
        
        return no;
    }   
    
    
    
    int mouldTheArray(char ch)
    {
       int []tempArray = new int[26];
       
       
       int posToStop = fetchCharacterPosition(ch);
       //Reversing position is dependent on both character value and character position in the string;
       
        
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
    
    void initializeTheArray()//To be called once.
    {
        for(int i = 0; i<26; i++)
        {
            arr[i] = i;
            /* this should be i, not i+1, else NullPointerException may be thrown
           for letter z caused by ArrayIndexOutOfBoundsException...
             */
        }
    }

    
    
}
