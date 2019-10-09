
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ranjith
 */
public class NthPrimeNumber 
{
    static final int PRIME_ARRAY_MAX_SIZE = 1299710; 
    static List<Integer> primes = new ArrayList<Integer>(); 

    
    static void generatePrime()  //Uses Sieve algorithm to generate prime numbers.
    {   
        boolean[] isPrime = new boolean[PRIME_ARRAY_MAX_SIZE];
          
        for(int index = 0; index < PRIME_ARRAY_MAX_SIZE; index++) 
            isPrime[index] = true; 
          
        for (int i = 2; i * i < PRIME_ARRAY_MAX_SIZE; i++)  
        {  
            if (isPrime[i] == true)  
            {  
                for (int j = i * i; j < PRIME_ARRAY_MAX_SIZE; j = j + i)  
                    isPrime[j] = false;  
            }  
        }  
      
        for (int index = 2; index < PRIME_ARRAY_MAX_SIZE; index++)  
        {
            if (isPrime[index] == true)  
            {
                primes.add(index); 
            }
        }
    }  
      
    public static void main (String[] args)  
    { 
          
        int N;
        
        System.out.println("Generating prime numbers till 1299710.......");
        long results = System.currentTimeMillis();
        generatePrime();  
        results = System.currentTimeMillis() - results;
        System.out.println("Time taken to generate prime numbers till 1299710 is:");
        System.out.println("Time in mili seconds = " + results);
        System.out.println("Time in seconds = " + TimeUnit.MILLISECONDS.toSeconds(results) + "\n");
      
        String flag = "y";
        do
        {
            System.out.print("Please enter the value of N:\t");
            Scanner myScanner = new Scanner(System.in); 

            try
            {
                N = myScanner.nextInt();
                results = System.currentTimeMillis();
                int primeResult = primes.get(N-1);
                results = System.currentTimeMillis() - results;
                System.out.println(N + ", prime number is " + primes.get(N-1) +
                        " (Time taken to extract this prime number is " + results + ")"); 
            
                
                System.out.print("\nDo you want to continue(y/n):\t");
                flag = myScanner.next();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Wrong Input. Please enter number.");
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Please enter N less than 100000");
            }
        }
        while(flag.equals("y") || flag.equals("Y"));
    } 
} 