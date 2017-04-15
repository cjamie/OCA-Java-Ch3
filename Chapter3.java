package ch3;

import java.util.Arrays;
/**
 *
 * @author huanj
 * CHAPTER 3: Core Java APIs 
 *
 * SUMMARY: 
 * 
 * (1)Strings are a fundamental class that does not need new keyword to instantiate
 *      1.1* Concatenation 
 *      1.2* Immutability
 *      1.3* String Pool
 *      1.4* String Methods
 * (2)StringBuilder is a mutable class that may be used over strings to save space
 *      2.1* StringBuilder equality
 * (3)Arrays
 *      3.1* Array methods 
 * (4)
 * (5)ArrayList object
 * --its use with generics
 * ()autoboxing
 * 
 * (6)LocalDate, LocalTime, and LocalDateTime objects
 * 
 * 
 * 
 * ()Date and Times object
 * 
 * 
 */

public class Chapter3 {
   public static void main(String[] args){
       A();
       B();
       C();
       D();  
       E();
       F();
       G();
       H();
   }
   /*
   1.1* concatenation rules:
   -number + number=number
   -String + anything=concatenation;
   -evaluated left to right 
   */ 
   static void A(){
       System.out.println("Method A:");
       System.out.println(1+2); //number+number
       System.out.println(2+'b'+"c"); //number+char->number+string=100c
       System.out.println("a"+2); // String+anything
   }
   /*
   1.2* Immutability: an object that can't be changed once it has been created
   */
   
   static void B(){
       System.out.println("\nMethod B:");
       String a="abc";
       a=a.concat("d");
       System.out.println("a does not change:");
   }
   /*
   1.3* String Pool
   Strings from same part of string pool are re-used if both created without 
   new keyword and have the same content value
   
   == equality operator compares physical address
   */
   static void C(){
       String a="bcd";
       String b= new String("bcd");
       String c="bcd";
       System.out.println("\nMethod C:");
       System.out.println(a==b); //false because a is in string pool, b is not
       System.out.println(b==c); //b not in string pool, c is
       System.out.println(c==a); //a and c are both in string pool with same value
      
   }
   
   /*
   1.4*
   Popular String methods
   
   length, charAt, indexOf, substring, toLowerCase, toUpperCase, equals,
   equalsIgnoreCase, startsWith, endsWith, contains, replace, trim 
   */
   static void D(){
       String a="qweRty";
       System.out.println("\nMethod D String:" + a);
       System.out.println("1"+ a.length()); //int return type
       System.out.println("2"+a.charAt(2)); //character return type, int parameter
       System.out.println("3"+a.indexOf('s')); //integer return type, char, char+int start index, or string parameters
       System.out.println("4"+a.substring(3)); //string return type, int paramter
       System.out.println("5"+a.toLowerCase()); //string return type
       System.out.println("6"+a.toUpperCase()); //string return type
       System.out.println("7"+a.equals(a.substring(6))); //boolean return type, string parameter
       System.out.println("8"+a.equalsIgnoreCase(a.substring(6))); //boolean return type, string parameter
       System.out.println("9"+a.startsWith("s")); //boolean return type, string parameter
       System.out.println("10"+a.endsWith("w")); //boolean return type, char or string parameter
       System.out.println("11"+a.contains("w")); //boolean return type, string parameter
       System.out.println("12"+a.replace('t','T')); //string return type, char or string parameter
       System.out.println("13"+a.trim()); //string return type
   }
   
   /*
   (2)StringBuilder Class
   Since strings are immutable, StringBuilders were used to save memory space
   --StringBuilder is built into the java.lang package. 
   3 different ways to construct a StringBuilder 
   
   --methods in StringBuilder but NOT String: 
   ---append(string)-appends a string parameter to the StringBuilder object
   ---insert(int, string)-adds a string starting from a requiested index
   ---delete(int, int)-seleted characters from a start and end index
   ---deleteCharAt(int)- deletes 1 character at specified index
   ---reverse()- reverses all characters in sequence
   ---toString()- returns a string 
   ---capacity()-returns StringBuilder capacity; default is 16
   */
   static void E(){
       StringBuilder a = new StringBuilder(); //empty sequence of chars
       StringBuilder b = new StringBuilder("animal"); 
       StringBuilder c = new StringBuilder(10);
       System.out.println();
       System.out.println(b.insert(3,"ff")); //returns a StringBuilder
   }
   /*
   2.1
   == operator can be used to check numeric or object refence equality 
   CAUTION: no overridden implementation for equals() so checks for 
   OBJECT REFERENCE EQUALITY (same as ==)
   
   
   */
   static void F(){
       StringBuilder a=new StringBuilder();
       StringBuilder b=new StringBuilder();
       StringBuilder c=a.append("s");
       StringBuilder d=new StringBuilder("s");
       System.out.println("\nMethod F:");
       System.out.println(a==b); //different objects, same content
       System.out.println(a==c); //same object reference, so same altered content
   
       System.out.println(a.equals(d)); //checks for object reference equality, not content equality
   }
   
   /*
   (3) Arrays 
   -an area of memory on the heap with space for a designated number of elements
   -Strings are an array of characterss with extra methods ex. char[] stringName;
   -has a public length data member 
   
   -Displayed below are 3 ways of declaring an array 
   
   -unlike String and StringBuilder objects, an array have a size paramter
   
   -may be put into an enhanced for loop
   -examples of implicit and explicit casting 
   */
   static void G(){
        int[] lantern0={2,4,6};
        char []lantern1={'g','h','i'};
        String lantern2[]={"ss", "gd"};
        String[] lantern3= new String[5];

        System.out.println("\nMethod G:");
        System.out.println("0 \t" + lantern0.toString());  //prints hashcode
        System.out.println("1 \t" + lantern1.toString()); //
        System.out.println("2 \t" + lantern2.toString()); //
        System.out.println("3 \t" + lantern3.toString());
       
        for (String stuff:lantern2){
            System.out.print(stuff+" ");
        }
        
        //changing an array entry
        lantern2[1]="jhh";
        System.out.println();
        for (String stuff:lantern2){
            System.out.print(stuff+" ");
        }
        
        //implicit cast 
        Object[] objects = lantern2;
        //explicit cast
        String[] lantern2_2 = (String[])objects;
        System.out.println("\nlantern2_2[0]="+ lantern2_2[0]);
    }   
    
    /*
    3.1* Arrays class methods: 
    equals() has no overridden implementation so it tests reference equality
    
   -Arrays class requires an import from java.util.Arrays or java.util.*;
    ---sort(arrayName) will sort the arrayName alphabetically/in ascii value 
      CAUTION: characters and int sort differently
    ---binarySearch(arrayName, element)- in a sorted array, will return index of element
        -if sorted but entry does not exist, negate at intended index and subtract 1
   
   -note: if you try to access an invalid array index, an ArrayIndexOutOfBoundsException will be thrown
    */   
   
    static void H(){
        int[] a= {1,2,100,4};
        String b[]= {"1","2", "100"};
        
        System.out.println("\n\nMethod H:");        
        System.out.println("[]a, b before sort:");
        System.out.print("a:");
        for(int stuff:a){
            System.out.print(stuff +" ");
        }
        System.out.print("\nb:");
        for(String stuff:b){
            System.out.print(stuff +" ");
        }
        
        Arrays.sort(a); 
        Arrays.sort(b);
        System.out.println("\n[]a, b after sort:");
        System.out.print("a:");
        for(int stuff:a){
            System.out.print(stuff +" ");
        }
        System.out.print("\nb:");
        for(String stuff:b){
            System.out.print(stuff +" ");
        }
        
        System.out.println("\nbinarySearch(a,4):"+Arrays.binarySearch(a, 4));//returns 2 
        System.out.println("binarySearch(a,5):"+Arrays.binarySearch(a, 5));//entry should be on entry 3-> negate gives -3 then subtract 1 for -4
        
        System.out.println("\n"+a.equals(b));
        
//      System.out.println(b.);
        System.out.println();
    } 

    
    static void I(){
        
    }
}