/* Austin Lindstrom
 * Instructor: Paul Murray
 * Date Created: 11/27/2019
 * 
 * Program that reads in 33 lines of passenger data from a file and assigns them to an array
 * of objects, later prompting for 1-3 more passengers and stores them back into the array,
 * storing the full name, seat class, seat number, age, and the desired or non-desired mealoption.
 * Then later prints out every passenger's last name, seat class, and meal option from the array.
 */





import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Meal Option Enumerators
enum MealOption {
 Regular,
 Asian_Vegetarian,
 Hindu_vegetarian,
 Vegan_strict_vegetarian,
 Vegetarian_lacto_ovo,
 Child,
 Gluten_intolerant,
 Jain,
 Japanese,
 Kosher,
 Muslim,
 Extra_crunchy
}

enum Class { //Class Enumerators created
 First, Business, Economy
}

public class Flight_AustinLindstrom {

 static String[] seats = {"11D", "12D", "14D"}; // Create array of available seats (seats are strings)
 static int passengerAmount = 33; // creating a integer to store passenger amount in plane before user input
 
 // Method creates an array of 36 Passengers, and reads through the file "PassengerList.txt", creating one passenger for every line of data in the file. If a passenger does not have a meal option, the program recognizes that and only attempts to read in 3 pieces of data for that passenger rather than 4. Once all of the passengers in the text file are added to the array, the method prompts the user to enter another passenger. After the user inputs one passenger the user gets the option to continue or stop entering passengers. Once the user stops or the passenger count reaches 36, Paul Murray's meal option is changed to Extra crunchy, and Meg Merwin's meal was changed to Kosher. The method then prints out all of the passengers
 public static void main(String[] args) { //main method
  Passengers[] passengers = new Passengers[36]; // new array to store passengers
  File file = new File("PassengerList.txt"); 
  try {
   int lineNum = 0; // line number starts at zero
   int[] commas = countCommas(file);
   Scanner scan = new Scanner(file);
   scan.useDelimiter("[,\n]");
   while (scan.hasNext()) {
    String fullName = scan.next();
    String seatNumber = scan.next();
    int age = 0;
    if (scan.hasNextInt()) {
     age = scan.nextInt();
    } else {
     age = Integer.parseInt(scan.next().trim());
    }
    String mealOption = null;
    if (commas[lineNum] == 3) {
     mealOption = scan.next();
    }
    MealOption m = null;
    if (mealOption != null) {
     mealOption = mealOption.replace("(", "").replace(")", "").replace("-", "_").replace(" ", "_").trim();
     m = MealOption.valueOf(mealOption);
    } 
    passengers[lineNum] = new Passengers(fullName, null, seatNumber, age, m);
    lineNum++;
   }
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  enterPassenger(passengers);
  passengers[0].updateMeal(MealOption.valueOf("Extra_crunchy"));
  passengers[14].updateMeal(MealOption.valueOf("Kosher"));
  for (Passengers p : passengers) {
   if (p != null) {
    System.out.println(p.toString());    
   }
  }
 }
 
 //Method loops through every line in a file, and then on every line it loops through every character, counting the commas. The number of commas on a certain line are stored in an array that can hold up to 36 variables, the maximum amount of people allowed on the plane. The method returns that array 
 private static int[] countCommas(File f) throws FileNotFoundException {
  int lineNum = 0;
  int[] array = new int[36];
  Scanner scan = new Scanner(f);
  while (scan.hasNextLine()) {
   if (lineNum > 36) {
    break;
   }
   int count = 0;
   String line = scan.nextLine();
   for (char c : line.toCharArray()) {
    if (c == ',')
     count++;
   }
   array[lineNum] = count;
   lineNum++;
  }
  return array;
 }
 
 // Method which prompts the user to enter the full name of the passenger. The full name is returned by the method.
 public static String readPassengerName() {
  Scanner scan1 = new Scanner(System.in);
  System.out.print("Please enter the full name of the passenger: ");
  String fullName = scan1.nextLine();
  return fullName;
 }
 
 // Method loops through every seat within the "seats" array and adds that seat to the string "finalSeats", each seperated by a space, which is returned by the method.
 public static String getAvailableSeats() {
  String finalSeats = "";
  for (String s : seats) {
   finalSeats += s + " ";
  }
  return finalSeats;
 }
 
 // Method asks user to input seat for the passenger. The method then loops through the available seats to see if the seat number entered is in the array of available seats. If the seat entered does exist in the array, then it sets that seat inside of the array to null, making it unavailable. The method then creates a new array one size smaller than the previous array, and fills it with every value in the old array, except for the one that has been nullified. If a value was never nullified, it means the seat was not available or did not exist within the array of available seats, and so when the new array is filled an IndexOutOfBoundsException is caught because there are too many variables for the array to hold. This prompts the user that the seat they entered is unavailable and returns back to the method so the user can try again. If the seat is available, it will be taken out of the array of seats, and the name of that seat will be returned from the method
 public static String setPassengerSeat() {
  Scanner scan1 = new Scanner(System.in);
  String[] localSeats = new String[seats.length - 1];
  System.out.print("Please enter the seat of the passenger: ");
  String seat = scan1.next().trim();
  int i = 0;
  for (String s : seats) {
   if (s.equals(seat)) {
    seats[i] = null;
   } 
   i++;
  }
  int a = 0;
  try {
   for (String s1 : seats) {
    if (s1 != null) {
     localSeats[a] = s1;
     a++;
    }
   } 
  } catch (IndexOutOfBoundsException e) {
   System.out.println("This seat is unavailable.");
   return setPassengerSeat();
  }
  seats = localSeats;
  return seat;
 }
 
 // Method asks user to input passenger age, if the age is not a number then it will tell the user the age is invalid and return back to the start of the method so they can try again. If they do input a number then the method returns that number
 public static int readPassengerAge() {
  Scanner scan1 = new Scanner(System.in);
  System.out.print("Please enter the age of the passenger: ");
  int age;
  try {
   age = scan1.nextInt();   
  } catch (InputMismatchException e) {
   System.out.println("Invalid age.");
   return readPassengerAge();
  }
  return age;
 }
 
 // Method prompts user to input the meal option. If the meal option that they entered is not equal to the string values of any of the "MealOption" enumerators after the string is trimmed and modified to be recognized as an enumerator, an IllegalArgumentException is caught which tells the user they entered an invalid meal option and returns back to the method so they may try again. If the meal option that they entered does exist, the method returns that meal option
 public static MealOption readPassengerMealOption() {
  Scanner scan1 = new Scanner(System.in);
  System.out.print("Please enter the passenger's meal option: ");
  String mealOptionString = scan1.nextLine().replace("(", "").replace(")", "").replace("-", "_").replace(" ", "_").trim();
  MealOption m = null;
  try {
   m = MealOption.valueOf(mealOptionString);   
  } catch (IllegalArgumentException e) {
   System.out.println("Invalid meal option.");
   return readPassengerMealOption();
  }
  return m;
 }
 
 // Method used to start the process of entering new passengers to an existing array of passengers, with the max being 36 passengers. The method first reads the user's full name by calling the readPassengerName method. The method then prints out all of the available seats, and calls upon the setPassengerSeat method to assign a seat to the passenger. The method then reads in the passenger's age and meal option using their respective methods, and creates a new Passenger using those paramaters. The passenger count is increased by 1, and if it hits 36 the method returns because the plane cannot hold anymore passengers. If the count is not yet on 36 the method will ask the user if they want to input another passenger. If the user's response is "Y", the method calls back on itself to add an additional passenger. If not, the method returns and no more passengers are added.
 public static void enterPassenger(Passengers[] passengers) {
  String name = readPassengerName();
  System.out.print("Available seats: " + getAvailableSeats() + "\n");
  String seat = setPassengerSeat();
  int age = readPassengerAge();
  MealOption m = readPassengerMealOption();
  passengers[passengerAmount] = new Passengers(name, null, seat, age, m);
  passengerAmount++;
  if (passengerAmount == 36) {
   return;
  }
  Scanner scan = new Scanner(System.in);
  System.out.println("Would you like to enter another passenger? (Y/N): ");
  String input = scan.next();
  if (input.equalsIgnoreCase("Y")) {
   enterPassenger(passengers);
  }
  return;
 }
}
