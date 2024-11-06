public class Passengers { //supporting class
  
 // Declaring variables for person's name, seat class, seat number, age, and meal option
 String fullName;
 Class seatClass;
 String seatNumber;
 int age;
 MealOption mealOption;
 
 // Constructor method that takes 5 values, 2 of which can be null. If the seatClass is null, one will be assigned based on seat number. If mealOption is null, one will be assigned based on age
 public Passengers(String fullName, Class seatClass, String seatNumber, int age, MealOption mealOption) {
  this.fullName = fullName;
  this.seatNumber = seatNumber;
  this.age = age;
  if (mealOption == null) {
   if (this.age >= 18) {
    this.mealOption = MealOption.Regular;
   } else {
    this.mealOption = MealOption.Child;
   }
  } else {
   this.mealOption = mealOption;
  }
  if (this.seatClass == null) {
   assignSeatClass();
  } else {
   this.seatClass = seatClass;
  }
 }
 //Method used to assign seat class based on seat number. If the number is between 1 and 4, seat class is First class. If it is between 5 and 8, it is business class. Any other seat is automatically assumed to be economy
 private void assignSeatClass() {
  if (seatNumber.startsWith("1") || seatNumber.startsWith("2") || seatNumber.startsWith("3") || seatNumber.startsWith("4")) {
   this.seatClass = Class.First;
  } else if (seatNumber.startsWith("5") || seatNumber.startsWith("6") || seatNumber.startsWith("7") || seatNumber.startsWith("8")) {
   this.seatClass = Class.Business;
  } else {
   this.seatClass = Class.Economy;
  }
 }
 
 // Method that returns a string containing the passenger's last name, their seat class, their seat number, and their meal option, if they have one. The method also converts the meal option enumerators back to their original full strings to be displayed
 public String toString() {
   try {
       if (mealOption == null) {
         return (getLastName() + " " + seatClass.toString() + " " + seatNumber);
       } else {
         String finalMealOption = mealOption.toString();
         if (mealOption == MealOption.Asian_Vegetarian)
           finalMealOption = "Asian Vegetarian";
         if (mealOption == MealOption.Hindu_vegetarian)
           finalMealOption = "Hindu vegetarian";
         if (mealOption == MealOption.Vegan_strict_vegetarian)
           finalMealOption = "Vegan (strict) vegetarian";
         if (mealOption == MealOption.Vegetarian_lacto_ovo)
           finalMealOption = "Vegetarian lacto-ovo";
         if (mealOption == MealOption.Gluten_intolerant)
           finalMealOption = "Gluten-intolerant";
         if (mealOption == MealOption.Extra_crunchy)
           finalMealOption = "Extra crunchy";
         return (getLastName() + " " + seatClass.toString() + " " + seatNumber + " " + finalMealOption);
       } 
       // If there is no space in in full name of the person, then a StringIndexOutOfBoundsException is thrown and caught, returning the full name in place of the last name, where the "full name" is just one word
   } catch (StringIndexOutOfBoundsException e) {
         return (fullName + " " + seatClass.toString() + " " + seatNumber + " " + mealOption.toString());
   }
 }
 
 // Method loops through the full name, finds the final space and sets the "index" integer equal to the index of that final space. The method then returns a substring of the full name, split at the index
 public String getLastName() throws StringIndexOutOfBoundsException {
    // index must start at negative one instead of zero so that it does not assign the index to the location of the first character of the string if no space exists, but rather will attempt to return a substring at negative one, throwing a StringIndexOutOfBoundsException, which will later be caught
    int index = -1; 
    char[] s = fullName.toCharArray();
    for (int i = 0; i < s.length; i++)  {
      if (s[i] == ' ') {
        index = i; 
      }
    }
    return fullName.substring(index).trim();
 }

 // Method sets the mealOption variable equal to another specified meal option
 public void updateMeal(MealOption m) {
  this.mealOption = m;
 }
}
