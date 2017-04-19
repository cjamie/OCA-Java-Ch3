package ch3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
//import java.util.*; //alternative to the two imports above

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
 *      3.1* Arrays methods 
 *      3.2* Multidimensional Arrays
 * (4)ArrayList object
 *      4.1*ArrayList methods
 *      4.2*ArrayList and Wrapper Classes 
 *      4.3*Autoboxing 
 *      4.4*ArrayList<->Array conversion
 *      4.5*Sorting 
 * 
 * --its use with generics
 * (5)autoboxing
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
//       A();
//       B();
//       C();
//       D();  
//       E();
//       F();
//       G();
//       H();
//       I();
//       J();
       K();
       L();
       M();
       N();
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
       System.out.println(2+'b'+"c"); //number+char+string->number+string->string=100c
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
   explicitly using new keyword and have the same content value
   
   implication: "new" strings have different references from strings inside
   
   == equality operator compares reference equality
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
   required String methods in OCA exam
   
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
       
        System.out.println("lantern0.length:"+lantern0.length);
        
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
    -equals() has no overridden implementation so it tests reference equality
    
    -Arrays class requires an import from java.util.Arrays or java.util.*;
    ---sort(arrayName) will sort the arrayName alphabetically/in ascii value 
      CAUTION: characters and int sort differently
    ---binarySearch(arrayName, element)- in a sorted array, will return index of element
        -if sorted but entry does not exist, negate at intended index and subtract 1
        -NOTE: if array is NOT sorted, output is unpredictable
    -note: if you try to access an invalid array index, an ArrayIndexOutOfBoundsException will be thrown
    */   
   
    static void H(){
        int[] a= {1,2,100,4};
        String b[]= {"1","2", "100"};
        int[] c= {1,2,4,100};
        
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
        
        
        System.out.println("a.equals(c):"+a.equals(c));
        
//      System.out.println(b.);
        System.out.println();
    } 

    /*
    (3.2*
    Multidimensional Arrays
    -valid declarations
    -iterating through an array with an enhanced for loop
    */
    static void I(){
        //2d declarations
        int[][] a0;
        int a1[][];
        int[] []a2;
        int[] a3[];
        //2d and 3d on same line
        int[] a4[], a5[][];

        //2d declarations with with a specified size
        String[][] a6={{"January", "February"},{"March"},{"April", "May"}};
        String[][] a7=new String[2][]; //[][int] will not work
        String[][] a8=new String[3][2];
        
        //iterating through with enhanced for loop
        System.out.println("Method I:");
        for(String[] inner:a6){
            for(String content:inner)
                System.out.print(content+" ");
        }
    }
    /*
    (4)ArrayList is a mutable object
    -requires an import from java.util.ArrayList
    ---implements the List and Iterable interface
    -valid declaration (3 pre-java5 and 2 with generics)
    */
    static void J(){
        //pre-java5 ArrayList
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList(3);
        ArrayList c = new ArrayList(a);
        //ArrayList with generics
        ArrayList<String> d = new ArrayList<String>();//specifying string with constructor is redundant info
        ArrayList<String> e = new ArrayList<>();//<> refered to as diamond operator
        
        List<String> f = new ArrayList<>(); //you can use an instance of the ArrayList class as an instance of List
    }   
    /*
    4.1* ArrayList Methods required for OCA
    -add(), remove, set, isEmpty, size, clear, contains, 
    -ArrayList has a custom implementation which returns true on content equality 
    -DOES NOT support method chaining, like Strings, or StringBuilder objects
    */
    static void K(){
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        b.add("an entry");
        b.add(4);
        
        System.out.println("\nMethod K:");
        //.add() takes an (element) or (int index,element) parameter
        a.add("a string"); //returns boolean true
        a.add(0,Boolean.TRUE); //void return type NOTE: we are adding a Boolean wrapper object
        System.out.println(a);
        



        //.remove() takes an (element) or (int index) parameter)
        a.remove(1); //returns a boolean telling us it was removed (Boolean.TRUE) or not (Boolean.FALSE)
        a.remove(Boolean.TRUE);
        System.out.println(a);
        
        //.set() takes a (int index, element) parameter
        a.add("new String that doesn't matter");
        a.set(0,"new String that replaces previous"); //returns element
        System.out.println(a);
        
        //.clear() discards all of the elements of the ArrayList object 
        a.clear(); //void return type: 
        System.out.println("after a clear():"+ a);
        
        //.isEmpty() and .size() returns boolean and int respectively
        System.out.println("before add(): isEmpty() returns:"+a.isEmpty()+" and a.size() returns:"+a.size());
        a.add("an entry");
        System.out.println("after add(): isEmpty() is: "+a.isEmpty()+" and a.size() returns:"+a.size());
                
        //.contains() takes a (element) parameter and returns a boolean
        a.add(4);
        System.out.println("Does a.contain(4)? "+a.contains(4)); 
        
        //.equals returns true on CONTENT equality, not reference
        System.out.println("testing for content equality with equals: "+a.equals(b));
    }
    /*
    4.2* ArrayList and Wrapper Classes: 
        
    Wrapper classes are an object type with a corresponding primitive: 
    Arrays do not interpret literal inputs as its primitive type. Instead, it interprets it as its Wrapper class
    
    Boolean, Byte, Short, Integer, Long, Float, Double, Character are the wrapper classes of...
    boolean, byte, short, int, long, float, double, and char respectively, 
    
    Emphasis:
    String to primitive conversion can be done via wrapper classes using a method with parse<primitiveType> keyword 
    String to wrapper class assignment could be done via the wrapper classes' valueOf() method 
    
    4.3* Autoboxing 
    
    */
    static void L(){
        
        List<Double> b = new ArrayList<>();
        List<Integer> c= new ArrayList<>();      
        
        //String to primtive (via a 'helper' Wrapper Class )
        int a0 = Integer.parseInt("534"); 
        System.out.println("\nMethod L: \nint a0 = "+a0);
        
        //String to Wrapper Object
        Integer a1= Integer.valueOf("533");
        System.out.println("Value of Integer object a1:"+a1);
        
        //autoboxing: Java compiler will implicitly cast a primitive into its wrapper class as ArrayList entry 
        
        b.add(22.4);//the 22.4 double literal it autoboxed into a Double Wrapper Object 
        System.out.println("Confirming b[0]'s object type: "+b.get(0).getClass().getTypeName());
        
        b.add(new Double(60));
        b.add(Double.valueOf("43.22"));
        
        //CAUTION: be careful with integers
        System.out.println("ArrayList b:"+b);
        c.add(1);
        c.add(2);
        c.remove(1); //removes entry #1, NOT the Integer entry with a value of 1
        //c.remove(Integer.valueOf("1")); //if you really want to remove Integer entry by value
        
        System.out.println("ArrayList c:"+c);
    }
    /*
    4.4* ArrayList/List <-> Array Conversion 
    
    ArrayList has a toArray() method that returns an Array
        -both parties remain independent 
    CAUTION: Array to ArrayList is linked. What happens to one happens to the other

    */
    
    static void M(){
        System.out.println("\nMethod M: ");
        ArrayList<String> a = new ArrayList<>();    
        Integer[] b0={4,3,2,44};
        
        //ArrayList to Array: Java creates a new Array INDEPENDENT of the ArrayList object
        //default: returns list of Objects
 
        a.add("String1");
        a.add("String2");
        
        Object[] objectArr=a.toArray();
        System.out.println("objectArr[0]="+objectArr[0]);
        System.out.println("objectArr.length="+objectArr.length);
        
        
        //ArrayList to a non-object array (in this case, String)
        String[] stringArr=a.toArray(new String[0]);
        
                
        //Array to ArrayList/List:      
        //IMPORTANT: the original Array and List ARE LINKED
        List<Integer> b1= Arrays.asList(b0);
        System.out.println("ArrayList of Integers, b1:"+ b1);

        System.out.println("b0 is an object of type: "+b0.getClass().getTypeName());
        System.out.println("b1 is an object of type: "+b1.getClass().getTypeName());
        System.out.println("b1 entries are a wrapper class of type: "+b1.get(1).getClass().getTypeName());
        
        //we change ARRAY entry then confirm that both change because they are linked
        b0[1]=66;
        System.out.print("Array Modified (b0 and b1): ");
        for(int stuff:b0)
            System.out.print(stuff+" "); //array
        System.out.println(b1); //list
        
        //we change LIST entry then confirm that both change because they are linked
        b1.set(1,33);
        System.out.print("List modified (b0 and b1): ");
        for(int stuff:b0)
            System.out.print(stuff+" ");
        System.out.println(b1);        
        
        /*
        4.4* Sorting 
        ArrayLists can sorted via a helpter class called Collections
        requires import java.util.Collections; 
        */
        Collections.sort(b1); //takes in a 
        System.out.println("ArrayList b1 after sort(): "+b1);
        
    }
    
    /*5* Dates and Time classes */
    static void N(){
        System.out.println("\nMethod N:");   
    }
}