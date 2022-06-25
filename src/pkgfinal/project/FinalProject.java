/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;//Package with name final project is created

import java.time.YearMonth;//YearMonth method in java.util is imported to use it in this program
import java.time.format.DateTimeFormatter;//DateTimeFormatter method in java.util is imported to use it in this program
import java.time.format.ResolverStyle;//ResolverStyle method in java.util is imported to use it in this program
import java.util.ArrayList;//ArrayList method in java.util is imported to use it in this program
import java.util.Collections;//Collections method in java.util is imported to use it in this program
import java.util.HashSet;//HashSet method in java.util is imported to use it in this program
//import java.util.List;//List method in java.util is imported to use it in this program
import java.util.Scanner;//Scanner method in java.util is imported to use it in this program
import java.util.Set;//Set method in java.util is imported to use it in this program

/**
 *
 * @author me
 */
public class FinalProject {//Class with the name final project is created

    /**
     * @param args the command line arguments
     */
    /*
    This method is made to create ArrayLists and to call main menu
    Arguments of this method is a list of strings
    This is a void method so it doesn't return any value
     */
    public static void main(String[] args) {//Main method is made
        System.out.println("***** Welcome to Inventory Control System *****");//Welcome the user to inventory control system
        ArrayList<ArrayList<String>> item = new ArrayList<>();//Empty ArrayList of item is declared and created
        ArrayList<ArrayList<String>> customer = new ArrayList<>();//Empty ArrayList of customer is declared and created
        ArrayList<ArrayList<ArrayList<String>>> sale = new ArrayList<>();//Empty ArrayList of sale is declared and created
        ArrayList<ArrayList<ArrayList<String>>> reporting = new ArrayList<>();//Empty ArrayList of reporting is declared and created
        mainmenu(item, customer, sale, reporting);//Main menu is called
    }

    /*
    This method is made to display main menu to user so user can choose what he want to do in inventory control system
    Arguments of this method are ArrayList of item,customer,sale and reporting of type string
    This is a void method so it will not return anything
     */
    public static void mainmenu(ArrayList<ArrayList<String>> item, ArrayList<ArrayList<String>> customer, ArrayList<ArrayList<ArrayList<String>>> sale, ArrayList<ArrayList<ArrayList<String>>> reporting) {//Main menu is made

        String check = "1";//A variable with the name check is declared and initialized 
        while (check.equals("1")) {//Keep looping if check is equal to 1
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            System.out.print("Enter your choice\nEnter 1 to go to item menu\nEnter 2 to go to customer menu\nEnter 3 to go to sale menu\nEnter 4 to go to reporting menu: ");//ask the user to enter his choice
            String choice = obj.nextLine();//Store the value entered by user in the variable check
            if (choice.equals("1")) {//If 1 is stored in variable choice
                item = itemmenu(item);//Call item menu and store the return value in ArrayList item
            } else if (choice.equals("2")) {//If 2 is stored in variable choice
                customer = customermenu(customer);//Call customer menu and store the return value in ArrayList customer
            } else if (choice.equals("3")) {//If 3 is stored in variable choice
                sale = salemenu(item, customer, sale);//Call sale menu and store the return value in ArrayList sale
            } else if (choice.equals("4")) {//If 4 is stored in variable choice
                reporting = reportingmenu(sale, reporting);//Call reporting menu and store the return value in ArrayList reporting
            } else {//If choice is something else than 1,2,3,4
                System.out.println("***** Invalid input *****");//Display invalid input
            }
            System.out.print("enter 1 to continue to main menu: ");//Ask the user to enter 1 if he want to continue to main menu
            check = obj.nextLine();//Store the value entered in variable check
        }

        // TODO code application logic here
    }

    /*
    This method is made to display item menu to user so he can decide what he want to do with item
    Argument of this method is an 2d ArrayList of item of type string
    This method returns the2d  ArrayList of item
     */
    public static ArrayList<ArrayList<String>> itemmenu(ArrayList<ArrayList<String>> item) {//item menu method is made

        String check = "1";//A variable with name check is initialized and decalred 
        while (check.equals("1")) {//Keep looping if check is equal to 1
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            System.out.print("Enter your choice\nEnter 1 to add items\nEnter 2 to view item\nEnter 3 to delete items\nEnter 4 to update items\nEnter 5 to search items \nEnter 6 to sort items: ");//ask the user to tell her choice
            String choice = obj.nextLine();//Value entered by user is stored in variable choice
            if (choice.equals("1")) {//If 1 is stored in variable choice
                item = additem(item);//Call add item method and store the return value in ArrayList item
            } else if (choice.equals("2")) {//If 2 is stored in variable choice
                viewitem(item);//Call view item method
            } else if (choice.equals("3")) {//If 3 is stored in variable choice
                item = deleteitem(item);//Call delete item method and store the return value in ArrayList item
            } else if (choice.equals("4")) {//If 4 is stored in variable choice
                item = updateitem(item);//Call update item method and store the return value in ArrayList item
            } else if (choice.equals("5")) {//If 5 is stored in variable choice
                searchitem(item);//Call search item method
            } else if (choice.equals("6")) {//If 6 is stored in variable choice
                item = sortitem(item);//Call sort item method and store the return value in ArrayList item
            } else {////If choice is something else than 1,2,3,4
                System.out.println("***** Invalid input *****");//Display invalid input
            }
            System.out.print("enter 1 to continue to item menu: ");//Ask the user to enter 1 if he want to continue to item menu
            check = obj.nextLine();//Value entered is stored in variable check
        }
        return (item);//Return ArrayList item

    }

    /*
    This method is made to add item record
    Argument passed in this metho is 2d ArrayList item of type string
    This method returns the 2d ArrayList item of type string
     */
    public static ArrayList<ArrayList<String>> additem(ArrayList<ArrayList<String>> item) {//Add item method is made
        System.out.println("***** Adding item record *****");//Tell the user to add the record
        while (true) {//Keep looping so user can add as many items as he wants

            ArrayList<String> item1 = new ArrayList<>();//An ArrayList of name item1 is declared and created to add one item details

            Scanner obj = new Scanner(System.in);//An object of Scanner class is made to take input from user
            String item_code;//A varibale with name item_code is declared
            while (true) {//Keep looping while valid item code is not entered
                System.out.print("Enter the item code: ");//Ask the user to enter item code
                item_code = obj.nextLine();//Store the value of item code in variable item_code

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                for (char ch : item_code.toCharArray()) {//For every element of the character array containing each element of the item code 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_code which is not digit
                    }
                }

                if (digitFound == false) {//If item_code doesn't contain only digits
                    System.out.println("***** Enter only digits as item code *****");//Ask the user to enter only digits as item code
                    continue;//Continue the loop to take new item code as input from user
                }

                int repeat_item_code = 0;//Declare and initialize variable repeat_item_code to find is item code entered is unique or not

                for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to the size of the ArrayList item - 1
                    if (item.get(first_array_item_index).get(0).equals(item_code)) {//If item code is already present in ArrayList item
                        System.out.println("***** This item code already exist ..enter another item code *****");//Tell the user that this code already exist
                        repeat_item_code = 1;//Assign 1 to repeat_item_code as item_code is found
                        break;//Break the loop
                    }
                }
                if (repeat_item_code == 1) {//If item_code is not unique
                    continue;//Continue the loop to again take item_code and check its uniqueness
                } else {//If item_code is unique
                    break;//Break the loop
                }
            }
            item1.add(0, item_code);//Item_code is added at 0 index of ArrayList item1
            String item_name;//A varibale with name item_name is declared

            while (true) {//Keep looping while valid item name is not entered
                System.out.print("Enter the item name: ");//Tell the user to enter item name
                item_name = obj.nextLine();//Store the value entered by user in variable item_name
                boolean name_validation = false;//Initialize boolean varibale name_validation to false as we have not started validation for item name yet
                for (char ch : item_name.toCharArray()) {//For every element of the character array containing each element of the item name

                    if (Character.isLetter(ch) || ch == ' ') {//If element of character array is letter or a space
                        name_validation = true;//Assign true to name_validation
                    } else {//If name is not valid
                        name_validation = false;//Assign false to name_validation
                        break;//Break the loop 
                    }

                }
                if (item_name.isBlank()) {//If item_name is not written
                    System.out.println("***** Enter something *****");//Tell the user to enter something
                    continue;//Continue the loop to take item_name as input from user

                } else if (name_validation == false) {//If item_name is not valid
                    System.out.println("***** Enter only alphabets/spaces as item name *****");//Ask the user to enter valid item name
                    continue;//Continue the loop to take new item name as input from user
                } else {//If item_name is valid 
                    break;//Break the loop
                }

            }

            item1.add(1, item_name);//Item_name is added at index 1 of ArrayList item1
            String item_price;//A varibale with name item_price is declared
            while (true) {//Keep looping while valid item price is not entered
                System.out.print("Enter the item price in rupees : ");//Tell the user to enter item price
                item_price = obj.nextLine();//Store the value entered by user in variable item_price

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item price
                for (char ch : item_price.toCharArray()) {//For every element of the character array containing each element of the item price 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_price which is not digit
                    }
                }

                if (digitFound == false) {//If item_price doesn't contain only digits
                    System.out.println("***** Enter only digits as item price *****");//Ask the user to enter only digits as item price
                    continue;//Continue the loop to take new item price as input from user
                } else {//If item_price contain only digits
                    break;//Break the loop
                }
            }

            item1.add(2, item_price);//Item_price is added at index 2 of ArrayList item1
            String item_stock;//A varibale with name item_stock is declared
            while (true) {//Keep looping while valid item stock is not entered
                System.out.print("Enter the item stock: ");//Tell the user to enter item quantity
                item_stock = obj.nextLine();//Store the value entered by user in variable item_stock

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item stock
                for (char ch : item_stock.toCharArray()) {//For every element of the character array containing each element of the item stock 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_stock which is not digit
                    }
                }
                if (item_stock.equals("0")) {
                    System.out.println("Stock can't be zero");
                    continue;
                } else if (digitFound == false) {//If item_stock doesn't contain only digits
                    System.out.println("***** Enter only digits as item stock*****");//Ask the user to enter only digits as item stock
                    continue;//Continue the loop to take new item stock as input from user
                } else {//If item_stock contain only digits
                    break;//Break the loop
                }
            }

            item1.add(3, item_stock);//Item_stock is added at index 3 of ArrayList item1
            String item_market_price;//A varibale with name item_market_price is declared
            while (true) {//Keep looping while valid item market price is not entered
                System.out.print("Enter the item market price in rupees: ");//Tell the user to enter item market price
                item_market_price = obj.nextLine();//Store the value entered by user in variable item_market_price

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item market price
                for (char ch : item_market_price.toCharArray()) {//For every element of the character array containing each element of the item market price 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_market_price which is not digit
                    }
                }

                if (digitFound == false) {//If item_market_price doesn't contain only digits
                    System.out.println("***** Enter only digits as item market price *****");//Ask the user to enter only digits as item market price
                    continue;//Continue the loop to take new item market price as input from user
                } else {//If item_market_price contain only digits
                    break;//Break the loop
                }
            }

            item1.add(4, item_market_price);//Item_market_price is added at index 4 of ArrayList item1

            item.add(item1);//Add the ArrayList item1 containing one item record in ArrayList item
            System.out.print("Enter 1 to add more : ");//Ask the user to enter 1 if he want to add more item record
            String check = obj.nextLine();//Store the value entered in variable check

            if (check.equals("1")) {//If user want to add more item record

                continue;//Continue the loop to add more item record

            } else {//If user doesn't want to add more record
                System.out.println("***** Items are added successfully *****");//Tell the user that the records entered by him are added successfully
                break;//Break the loop
            }

        }
        return (item);//Return the ArrayList item so you can use it in other functions

    }

    /*
    This method is made to view the record of the item
    Argument of this method is 2d ArrayList item of type string
    This is a void method so it is not returning any value
     */
    public static void viewitem(ArrayList<ArrayList<String>> item) {//View item method is made
        if (item.size() != 0) {//If there is something present in ArrayList item
            System.out.println("***** Viewing item record *****");//Tell the user that the record is displaying
            System.out.println("item_code\titem_name\titem_price\titem_stock\titem_market_price");//Display the heading of the item record
            for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Outer looping from 0 to length of item - 1
                for (int second_array_item_index = 0; second_array_item_index < 5; second_array_item_index++) {//Inner looping from 0 to 3
                    System.out.print(item.get(first_array_item_index).get(second_array_item_index) + "\t\t");//Display each element of ArrayList item and giving two tab spaces after each 
                }

                System.out.println();//When one item record is displayed then go to next line
            }
        } else {//If there is nothing in arrayList item
            System.out.println("***** Item record not found *****");//Tell the user that no item record is present
        }
    }

    /*
    This method is made to delete the record of the item which user want
    Argument of this method is 2d ArrayList item of type string
    This method is returning 2d ArrayList item of type string
     */
    public static ArrayList<ArrayList<String>> deleteitem(ArrayList<ArrayList<String>> item) {//Delete item method is made
        System.out.println("***** Deleting item record *****");//Tell the user to delete the record
        if (item.size() != 0) {//If there is something present in ArrayList item
            String delete;//A variable with the name delete is declared
            while (true) {//Keep looping while valid item code is not entered
                Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
                System.out.print("Enter the item code you want to delete: ");//Tell the user to enter the item code whose record he want to delete
                delete = obj.nextLine();//Store the value entered by user in variable delete

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                for (char ch : delete.toCharArray()) {//For every element of the character array containing each element of the item code 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_code which is not digit
                    }
                }

                if (digitFound == false) {//If item_code doesn't contain only digits
                    System.out.println("***** Enter only digits as item code *****");//Ask the user to enter only digits as item code
                    continue;//Continue the loop to take new item code as input from user
                } else {//If item_code is valid
                    break;//Break the loop
                }
            }

            int index_delete = -1;//Initialize the index of variable delete in item as -1 as we have not found the index of delete in item yet
            boolean found = false;//Intialize the varibale found as false as wehave not found delete in item yet
            for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to length of item - 1
                if (item.get(first_array_item_index).get(0).equals(delete)) {//If delete is present in item 
                    index_delete = first_array_item_index;//Found the index where delete is present in item
                    found = true;//Found becomes true as delete is found in item
                    break;//Break the loop when delete is found
                }
            }
            if (found == true) {//If delete is present in item
                item.remove(index_delete);//Remove the record of the item required by user
                System.out.println("***** Item having code " + delete + " is deleted successfully *****");//Tell the user that record is deleted
            } else {//If delete is not present in item
                System.out.println("***** The Code you entered doesn't match any item *****");//Tell the user that this item is not present
            }
        } else {//If there is nothing in item
            System.out.println("***** Item record not found *****");//Tell the user that item record is not present
        }
        return (item);//Return the ArrayList item so you can use it in other functions
    }

    /*
    This function is made to update item record
    Argument of this method is 2d ArrayList item of type string
    This method is returning 2d ArrayList item of type string
     */
    public static ArrayList<ArrayList<String>> updateitem(ArrayList<ArrayList<String>> item) {//Update item method is made
        System.out.println("***** Updating item record *****");//Tell the user to update the item record
        if (item.size() != 0) {//If there is something present in item
            String update;//A variable with the name update is declared
            while (true) {//Keep looping while valid item code is not entered
                Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input from user
                System.out.print("Enter the item code for which you want to update the record: ");//Tell the user to enter the item code for which he want to update the record
                update = obj.nextLine();//Store the value entered by user in the variable update

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                for (char ch : update.toCharArray()) {//For every element of the character array containing each element of the item code 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_code which is not digit
                    }
                }

                if (digitFound == false) {//If item_code doesn't contain only digits
                    System.out.println("***** Enter only digits as item code *****");//Ask the user to enter only digits as item code
                    continue;//Continue the loop to take new item code as input from user
                } else {//If item_code is valid
                    break;//Break the loop
                }
            }

            int update_index = -1;//Initialize the index of variable update in item as -1 as we have not found the index of delete in item yet
            boolean found = false;//Intialize the varibale found as false as wehave not found update in item yet
            for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to length of item - 1
                if (item.get(first_array_item_index).get(0).equals(update)) {//If update is present in item 
                    update_index = first_array_item_index;//Found the index where update is present in item
                    found = true;//Found becomes true as update is found in item
                    break;//Break the loop when update is found
                }
            }
            if (found == true) {//If update is present in item

                Scanner obj = new Scanner(System.in);//Make object of scanner class to take input
                System.out.print("Enter 1 to update item name \nEnter 2 to update item price \nEnter 3 to update item stock\nEnter 4 to update item market price: ");//Ask the user to enter his choice about what he want to update
                String choice = obj.nextLine();//Store the value entered by user in the variable choice
                if (choice.equals("1")) {//If user want to update item name
                    String item_name;//A varibale with name item_name is declared

                    while (true) {
                        System.out.print("Enter the item name: ");//Ask the user to enter the new item name
                        item_name = obj.nextLine();//Store the value entered in variable item_name
                        boolean name_validation = false;//Initialize boolean varibale letterFound to false as we have not started validation for item name yet
                        for (char ch : item_name.toCharArray()) {//For every element of the character array containing each element of the item name

                            if (Character.isLetter(ch) || ch == ' ') {//If element of character array is letter or a space
                                name_validation = true;//Assign true to name_validation
                            } else {//If name is not valid
                                name_validation = false;//Assign false to name_validation
                                break;//Break the loop 
                            }

                        }
                        if (item_name.isBlank()) {//If item_name is not written
                            System.out.println("***** Enter something *****");//Tell the user to enter something
                            continue;//Continue the loop to take item_name as input from user

                        } else if (name_validation == false) {//If item_name is not valid
                            System.out.println("***** Enter only alphabets or spaces as item name *****");//Ask the user to enter valid item name
                            continue;//Continue the loop to take new item name as input from user
                        } else {//If item_name is valid 
                            break;//Break the loop
                        }

                    }

                    item.get(update_index).set(1, item_name);//Repalce the value at 1st index of arraylist present at update_index in item by item_name
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated 
                } else if (choice.equals("2")) {//If user want to update item price
                    String item_price;//A varibale with name item_price is declared
                    while (true) {//Keep looping while valid item price is not entered
                        System.out.print("Enter the item price in rupees: ");//Ask the user to enter the new item price
                        item_price = obj.nextLine();//Store the value entered in variable item_price

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item price
                        for (char ch : item_price.toCharArray()) {//For every element of the character array containing each element of the item price 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of item_price which is not digit
                            }
                        }

                        if (digitFound == false) {//If item_price doesn't contain only digits
                            System.out.println("***** Enter only digits as item price *****");//Ask the user to enter only digits as item price
                            continue;//Continue the loop to take new item price as input from user
                        } else {//If item_price contain only digits
                            break;//Break the loop
                        }
                    }

                    item.get(update_index).set(2, item_price);//Repalce the value at 2nd index of arraylist present at update_index in item by item_price
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated 
                } else if (choice.equals("3")) {//If user want to update item stock
                    String item_stock;//A varibale with name item_stock is declared
                    while (true) {//Keep looping while valid item stock is not entered
                        System.out.print("Enter the item stock: ");//Ask the user to enter the new item stock
                        item_stock = obj.nextLine();//Store the value entered in variable item_stock

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item stock
                        for (char ch : item_stock.toCharArray()) {//For every element of the character array containing each element of the item stock 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of item_stock which is not digit
                            }
                        }
                        if (item_stock.equals("0")) {//If stock is empty
                            System.out.println("Stock can't be zero");//Tell the user to enter some value 
                            continue;//Continue the loop to take correct item stock
                        } else if (digitFound == false) {//If item_stock doesn't contain only digits
                            System.out.println("***** Enter only digits as item stock *****");//Ask the user to enter only digits as item stock
                            continue;//Continue the loop to take new item stock as input from user
                        } else {//If item_stock contain only digits
                            break;//Break the loop
                        }
                    }

                    item.get(update_index).set(3, item_stock);//Repalce the value at 3rd index of arraylist present at update_index in item by item_stock
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                } else if (choice.equals("4")) {//If user want to update item market price
                    String item_market_price;//A varibale with name item_market_price is declared
                    while (true) {//Keep looping while valid item market price is not entered
                        System.out.print("Enter the item market price in rupees: ");//Ask the user to enter the new item market price
                        item_market_price = obj.nextLine();//Store the value entered in variable item_market_price

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item market price
                        for (char ch : item_market_price.toCharArray()) {//For every element of the character array containing each element of the item market price 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of item_market_price which is not digit
                            }
                        }

                        if (digitFound == false) {//If item_market_price doesn't contain only digits
                            System.out.println("***** Enter only digits as item market price *****");//Ask the user to enter only digits as item market price
                            continue;//Continue the loop to take new item market price as input from user
                        } else {//If item_market_price contain only digits
                            break;//Break the loop
                        }
                    }

                    item.get(update_index).set(4, item_market_price);//Repalce the value at 4th index of arraylist present at update_index in item by item_market_price
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                } else {//If user enter his choice other than 1, 2, 3, 4
                    System.out.println("***** Invalid input *****");//Tell the user that this is invalid
                }

            } else {//If update is not present in item 
                System.out.println("***** No such item code exists *****");//Tell the user that no such item record exist
            }

        } else {//If item record is empty
            System.out.println("***** No item record is there to update *****");//Tell the user that there is no item record present
        }

        return (item);//Return the ArrayList item so that you can use it in any other function
    }

    /*
    This method is made to search the item record
    Arguemnt of thsi method is ArrayList item of type string
    This is a void method so it doesn't return any value
     */
    public static void searchitem(ArrayList<ArrayList<String>> item) {//Search item method is made
        System.out.println("***** Searching item record *****");//Tell the user to search the item record
        if (item.size() != 0) {//If there is some record of item
            String search;//A variable with the name search is declared
            while (true) {//Keep looping while valid item code is not entered
                Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input
                System.out.print("Enter the item code for the item you want to search: ");//Ask the user to enter the item code for which he want to search the record
                search = obj.nextLine();//Store the value entered by user in variable search

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                for (char ch : search.toCharArray()) {//For every element of the character array containing each element of the item code 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of item_code which is not digit
                    }
                }

                if (digitFound == false) {//If item_code doesn't contain only digits
                    System.out.println("***** Enter only digits as item code *****");//Ask the user to enter only digits as item code
                    continue;//Continue the loop to take new item code as input from user
                } else {//If item_code is valid
                    break;//Break the loop
                }
            }

            boolean searched = false;//Initialize the variable searched to false as we have not serached item code yet
            int index_search = -1;//Initialize the variable index_search to -1 as we have not found the index of search in item yet
            for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to length of item - 1
                if (item.get(first_array_item_index).get(0).equals(search)) {//If item code is present in ArrayList item
                    searched = true;//Set searched to true as item code is found
                    index_search = first_array_item_index;//Get the index of search
                    break;//Break the loop when item code is found
                }

            }
            if (searched == true) {//If item code is present in item
                System.out.println("***** Item having code " + search + " is found *****");//Tell the user that the entered item code is found
                System.out.println("item_code\titem_name\titem_price\titem_stock\titem_market_price");//Display the heading of the item record
                System.out.println(item.get(index_search).get(0) + "\t\t" + item.get(index_search).get(1) + "\t\t" + item.get(index_search).get(2) + "\t\t" + item.get(index_search).get(3) + "\t\t" + item.get(index_search).get(4));//Display the searched item record
            } else {//If item code is not resent in item
                System.out.println("***** Item having code " + search + " is not found *****");//Tell the user that no such item record exit 
            }
        } else {//If nothing is present in ArrayList item 
            System.out.println("***** No item record is there to be searched for *****");//Tell the suer that there is no item record present
        }
    }

    /*
    This function is made to sort the 2d ArrayList item according to the item code
    Argument of this function is 2d ArrayList item of type string
    This function return 2d ArrayList item of type string
     */
    public static ArrayList<ArrayList<String>> sortitem(ArrayList<ArrayList<String>> item) {//Sort item method is made
        System.out.println("***** Sorting items *****");//Tell the user that sorting has started
        if (item.size() != 0) {//If some record of item is present
            for (int first_array_index = 0; first_array_index < (item.size()) - 1; first_array_index++) {//Outer looping from 0 to length of item - 2
                for (int next_array_index = first_array_index + 1; next_array_index < item.size(); next_array_index++) {//Middle looping from start of above loop + 1 to length of item - 1
                    if (Integer.parseInt(item.get(first_array_index).get(0)) > Integer.parseInt(item.get(next_array_index).get(0))) {//If first element in integer at an arraylist in item is greater than first element in integer of next arraylist in item
                        for (int second_array_item_index = 0; second_array_item_index <= 4; second_array_item_index++) {//Inner looping from 0 to 4
                            String first_array_element = item.get(first_array_index).get(second_array_item_index);//Store the element of the arraylist present in item in the variable first_array_element
                            item.get(first_array_index).set(second_array_item_index, item.get(next_array_index).get(second_array_item_index));//Set each element of arraylist taht comes first in item to each element of next aaraylist in item
                            item.get(next_array_index).set(second_array_item_index, first_array_element);//Set the element of the arraylist store above to the element of previous arraylist
                        }
                    }

                }

            }
            System.out.println("***** Items have been sorted successfully *****");//Tell the user that items have been sorted
        } else {//If no record of item exists
            System.out.println("***** No item record is there to sort *****");//Tell the user that no item record is present
        }
        return (item);//Return the ArrayList item so you can use it in another function

    }

    /*
    This method is made to display customer menu to user so he can decide what he want to do with customer
    Argument of this method is an 2d ArrayList of customer of type string
    This method returns the 2d ArrayList of customer
     */
    public static ArrayList<ArrayList<String>> customermenu(ArrayList<ArrayList<String>> customer) {//customer menu method is made

        String check = "1";//A variable with name check is initialized and decalred 
        while (check.equals("1")) {//Keep looping if check is equal to 1
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            System.out.print("Enter your choice\nEnter 1 to add customers\nEnter 2 to view customers\nEnter 3 to delete customers\nEnter 4 to update customers: ");//ask the user to tell her choice
            String choice = obj.nextLine();//Value entered by user is stored in variable choice
            if (choice.equals("1")) {//If 1 is stored in variable choice
                customer = addcustomer(customer);//Call add customer method and store the return value in ArrayList customer
            } else if (choice.equals("2")) {//If 2 is stored in variable choice
                viewcustomer(customer);//Call view customer method
            } else if (choice.equals("3")) {//If 3 is stored in variable choice
                customer = deletecustomer(customer);//Call delete customer method and store the return value in ArrayList customer
            } else if (choice.equals("4")) {//If 4 is stored in variable choice
                customer = updatecustomer(customer);//Call update customer method and store the return value in ArrayList customer
            } else {//If choice is something else than 1,2,3,4
                System.out.println("***** Invalid input *****");//Display invalid input
            }
            System.out.print("enter 1 to continue to customer menu: ");//Ask the user to enter 1 if he want to continue to customer menu
            check = obj.nextLine();//Value entered is stored in variable check
        }
        return (customer);//Return ArrayList customer

    }

    /*
    This method is made to add customer record
    Argument passed in this method is 2d ArrayList customer of type string
    This method returns the 2d ArrayList customer of type string
     */
    public static ArrayList<ArrayList<String>> addcustomer(ArrayList<ArrayList<String>> customer) {//Add customer method is made
        System.out.println("***** Adding customer record *****");//Tell the user to add the record
        while (true) {//Keep looping so user can add as many customers as he wants

            ArrayList<String> customer1 = new ArrayList<>();//An ArrayList of name customer1 is declared and created to add one customer details

            Scanner obj = new Scanner(System.in);//An object of Scanner class is made to take input from user

            String customer_id;//A varibale with name customer_id is declared
            while (true) {//Keep looping while valid customer id is not entered

                System.out.print("Enter the customer id: ");//Ask the user to enter customer id
                customer_id = obj.nextLine();//Store the value of customer in variable cutomer_id
                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in customer id
                for (char ch : customer_id.toCharArray()) {//For every element of the character array containing each element of the customer id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of customer_id which is not digit
                    }
                }

                if (digitFound == false) {//If customer id doesn't contain only digits
                    System.out.println("***** Enter only digits as customer id *****");//Ask the user to enter only digits as customer id
                    continue;//Continue the loop to take new customer id as input from user
                }
                int repeat = 0;//Declare and initialize variable repeat to find is customer id entered is unique or not
                for (int i = 0; i < customer.size(); i++) {//Looping from 0 to the size of the ArrayList customer - 1
                    if (customer.get(i).get(0).equals(customer_id)) {//If customer id is already present in ArrayList customer
                        System.out.println("***** This customer id already exist ..enter another customer id *****");//Tell the user that this id already exist
                        repeat = 1;//Assign 1 to repeat as customer id is found
                        break;//Break the loop
                    }
                }
                if (repeat == 1) {//If customer_id is not unique
                    continue;//Continue the loop to again take customer id and check its uniqueness
                } else {//If customer_id is unique
                    break;//Break the loop
                }
            }
            customer1.add(0, customer_id);//Customer_id is added at 0 index of ArrayList customer1

            String customer_name;//A varibale with name customer_name is declared
            while (true) {//Keep looping while valid customer name is not entered
                System.out.print("Enter the customer name: ");//Tell the user to enter customer name
                customer_name = obj.nextLine();//Store the value entered by user in variable customer_name

                boolean name_validation = false;//Initialize boolean varibale name_validation to false as we have not started validation for customer name yet
                for (char ch : customer_name.toCharArray()) {//For every element of the character array containing each element of the customer name

                    if (Character.isLetter(ch) || ch == ' ') {//If element of character array is letter or a space
                        name_validation = true;//Assign true to name_validation
                    } else {//If name is not valid
                        name_validation = false;//Assign false to name_validation
                        break;//Break the loop 
                    }

                }
                if (customer_name.isBlank()) {//If customer_name is not written
                    System.out.println("***** Enter something *****");//Tell the user to enter something
                    continue;//Continue the loop to take customer_name as input from user

                } else if (name_validation == false) {//If customer_name is not valid
                    System.out.println("***** Enter only alphabets/spaces as customer name *****");//Ask the user to enter valid customer name
                    continue;//Continue the loop to take new customer name as input from user
                } else {//If customer_name is valid 
                    break;//Break the loop
                }

            }

            customer1.add(1, customer_name);//Customer_name is added at index 1 of ArrayList customer1
            String customer_cnic;//A varibale with name customer_address is declared
            while (true) {//Keep looping while valid customer_cnic is not entered
                System.out.print("Enter the customer cnic in the format xxxxx-xxxxxxx-x: ");//Tell the user to enter customer cnic
                customer_cnic = obj.nextLine();//Store the value entered by user in variable customer_cnic

                String regex = ("\\d{5}-\\d{7}-\\d{1}");//Make regex for cnic format
                boolean same_cnic = false;//cnic is not same at start
                if (customer_cnic.matches(regex)) {//If customer cnic matches the required foramt
                    for (int i = 0; i < customer.size(); i++) {//Looping through customer array
                        if (customer_cnic.equals(customer.get(i).get(2))) {//If cnic entered is already of some other person
                            System.out.println("Two persons can't have same cnic");//Tell the user that cnic can't be same for two persons
                            same_cnic = true;//As cnic is same thus it become true
                            break;//Break the loop
                        }
                    }
                    if (same_cnic)//If cnic is same with another
                    {
                        continue;//Continue the loop
                    } else//If cnic is not same with another
                    {
                        break;//Break the loop
                    }
                } else {////If customer cnic doesn't matches the required foramt
                    System.out.println("Invalid");//Tell the user that cnic is invalid
                    continue;////Continue the loop to take new customer cnic as input from user
                }

            }

            customer1.add(2, customer_cnic);//Customer cnic is added at index 2 of ArrayList customer1
            String customer_phoneNo;//A varibale with name customer_phoneNo is declared
            while (true) {//Keep looping while valid customer phone number is not entered

                System.out.print("Enter the customer phone number in the format xxxx-xxxxxxx: ");//Tell the user to enter customer phone number
                customer_phoneNo = obj.nextLine();//Store the value entered by user in variable customer_phoneNo
                String regex = ("\\d{4}-\\d{7}");//Make regex for phone number format
                boolean same_phoneNo = false;//phone number is not same at start
                if (customer_phoneNo.matches(regex)) {//If customer phone number matches the required foramt
                    for (int i = 0; i < customer.size(); i++) {//Looping through customer array
                        if (customer_phoneNo.equals(customer.get(i).get(3))) {//If phone number entered is already of some other person
                            System.out.println("Two persons can't have same phone number");//Tell the user that phone number can't be same for two persons
                            same_phoneNo = true;//As phone number is same thus it become true
                            break;//Break the loop
                        }
                    }
                    if (same_phoneNo)//If phone number is same with another
                    {
                        continue;//Continue the loop
                    } else//If phone number is not same with another
                    {
                        break;//Break the loop
                    }
                } else {////If customer phone number doesn't matches the required foramt
                    System.out.println("Invalid");//Tell the user that phone number is invalid
                    continue;////Continue the loop to take new customer phone number as input from user
                }
            }

            customer1.add(3, customer_phoneNo);//Customer_phoneNO is added at index 3 of ArrayList customer1
            customer.add(customer1);//Add the ArrayList customer1 containing one customer record in ArrayList customer
            System.out.print("Enter 1 to add more : ");//Ask the user to enter 1 if he want to add more customer record
            String check = obj.nextLine();//Store the value entered in variable check

            if (check.equals("1")) {//If user want to add more customer record

                continue;//Continue the loop to add more customer record

            } else {//If user doesn't want to add more record
                System.out.println("***** Customers are added successfully *****");//Tell the user that the records entered by him are added successfully
                break;//Break the loop
            }

        }
        return (customer);//Return the ArrayList customer so you can use it in other functions

    }

    /*
    This method is made to view the record of customer
    Argument of this method is 2d ArrayList customer of type string
    This is a void method so it is not returning any value
     */
    public static void viewcustomer(ArrayList<ArrayList<String>> customer) {//View customer method is made
        if (customer.size() != 0) {//If there is something present in ArrayList customer
            System.out.println("***** Viewing customer record *****");//Tell the user that the record is displaying
            System.out.println("customer_id\tcustomer_name\tcustomer_cnic\tcustomer_phoneNo");//Display the heading of the customer record
            for (int i = 0; i < customer.size(); i++) {//Outer looping from 0 to length of customer - 1
                for (int j = 0; j < 4; j++) {//Inner looping from 0 to 3
                    System.out.print(customer.get(i).get(j) + "\t\t");//Display each element of ArrayList customer and giving two tab spaces after each 
                }

                System.out.println();//When one customer record is displayed then go to next line
            }
        } else {//If there is nothing in arrayList customer
            System.out.println("***** Customer record not found *****");//Tell the user that no customer record is present
        }
    }

    /*
    This method is made to delete the record of the customer which user want
    Argument of this method is 2d ArrayList customer of type string
    This method is returning 2d ArrayList customer of type string
     */
    public static ArrayList<ArrayList<String>> deletecustomer(ArrayList<ArrayList<String>> customer) {//Delete customer method is made
        System.out.println("***** Deleting customer record *****");//Tell the user to delete the record
        if (customer.size() != 0) {//If there is something present in ArrayList customer
            String delete;//A variable with the name delete is declared
            while (true) {//Keep looping while valid customer id is not entered
                Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user

                System.out.print("Enter the customer id you want to delete: ");//Tell the user to enter the customer id whose record he want to delete
                delete = obj.nextLine();//Store the value entered by user in variable delete

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in customer id
                for (char ch : delete.toCharArray()) {//For every element of the character array containing each element of the customer id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of customer_id which is not digit
                    }
                }

                if (digitFound == false) {//If customer_id doesn't contain only digits
                    System.out.println("***** Enter only digits as customer id *****");//Ask the user to enter only digits as customer id
                    continue;//Continue the loop to take new customer id as input from user
                } else {//If customer_id is valid
                    break;//Break the loop
                }
            }

            int index_delete = -1;//Initialize the index of variable delete as -1 as we have not found the index of delete in customer yet
            boolean found = false;//Intialize the varibale found as false as we have not found delete in customer yet
            for (int first_array_customer_index = 0; first_array_customer_index < customer.size(); first_array_customer_index++) {//Looping from 0 to length of customer - 1
                if (customer.get(first_array_customer_index).get(0).equals(delete)) {//If delete is present in customer
                    index_delete = first_array_customer_index;//Found the index where delete is present in customer
                    found = true;//Found becomes true as delete is found in customer
                    break;//Break the loop when delete is found
                }
            }
            if (found == true) {//If delete is present in customer
                customer.remove(index_delete);//Remove the record of the customer required by user
                System.out.println("***** Customer having id " + delete + " is deleted successfully *****");//Tell the user that record is deleted
            } else {//If delete is not present in customer
                System.out.println("***** The id you entered doesn't match any customer *****");//Tell the user that this customer is not present
            }
        } else {//If there is nothing in customer
            System.out.println("***** Customer record not found *****");//Tell the user that customer record is not present
        }
        return (customer);//Return the ArrayList customer so you can use it in other functions
    }

    /*
    This function is made to update customer record
    Argument of this method is 2d ArrayList customer of type string
    This method is returning 2d ArrayList customer of type string
     */
    public static ArrayList<ArrayList<String>> updatecustomer(ArrayList<ArrayList<String>> customer) {//Update customer method is made
        System.out.println("***** Updating customer record *****");//Tell the user to update the customer record

        if (customer.size() != 0) {//If there is something present in customer
            String update;//A variable with the name update is declared
            while (true) {//Keep looping while valid customer id is not entered
                Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input from user
                System.out.print("Enter the customer id for which you want to update the record: ");//Tell the user to enter the customer id for which he want to update the record
                update = obj.nextLine();//Store the value entered by user in the variable update
                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in customer id
                for (char ch : update.toCharArray()) {//For every element of the character array containing each element of the customer id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of customer_id which is not digit
                    }
                }

                if (digitFound == false) {//If customer id doesn't contain only digits
                    System.out.println("***** Enter only digits as customer id *****");//Ask the user to enter only digits as customer id
                    continue;//Continue the loop to take new customer id as input from user
                } else {//If customer_id is valid
                    break;//Break the loop
                }
            }
            int update_index = -1;//Initialize the index of variable update as -1 as we have not found the index of delete in customer yet
            boolean found = false;//Intialize the varibale found as false as we have not found update in customer yet
            for (int first_array_customer_index = 0; first_array_customer_index < customer.size(); first_array_customer_index++) {//Looping from 0 to length of customer - 1
                if (customer.get(first_array_customer_index).get(0).equals(update)) {//If update is present in customer
                    update_index = first_array_customer_index;//Found the index where update is present in customer
                    found = true;//Found becomes true as update is found in customer
                    break;//Break the loop when update is found
                }
            }
            if (found == true) {//If update is present in customer
                Scanner obj = new Scanner(System.in);//Make object of scanner class to take input
                System.out.print("Enter 1 to update customer name \nEnter 2 to update customer cnic \nEnter 3 to update customer phone number: ");//Ask the user to enter his choice about what he want to update
                String choice = obj.nextLine();//Store the value entered by user in the variable choice
                if (choice.equals("1")) {//If user want to update customer name

                    String customer_name;//A varibale with name customer_name is declared
                    while (true) {//Keep looping while valid customer name is not entered
                        System.out.print("Enter the customer name: ");//Tell the user to enter customer name
                        customer_name = obj.nextLine();//Store the value entered by user in variable customer_name

                        boolean name_validation = false;//Initialize boolean varibale name_validation to false as we have not started validation for customer name yet
                        for (char ch : customer_name.toCharArray()) {//For every element of the character array containing each element of the customer name

                            if (Character.isLetter(ch) || ch == ' ') {//If element of character array is letter or a space
                                name_validation = true;//Assign true to name_validation
                            } else {//If name is not valid
                                name_validation = false;//Assign false to name_validation
                                break;//Break the loop 
                            }

                        }
                        if (customer_name.isBlank()) {//If customer_name is not written
                            System.out.println("***** Enter something *****");//Tell the user to enter something
                            continue;//Continue the loop to take customer_name as input from user

                        } else if (name_validation == false) {//If customer_name is not valid
                            System.out.println("***** Enter only alphabets/spaces as customer name *****");//Ask the user to enter valid customer name
                            continue;//Continue the loop to take new customer name as input from user
                        } else {//If customer_name is valid 
                            break;//Break the loop
                        }

                    }
                    customer.get(update_index).set(1, customer_name);//Repalce the value at 1st index of arraylist present at update_index in customer by customer_name
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                } else if (choice.equals("2")) {//If user want to update customer address

                    String customer_cnic;//A varibale with name customer_address is declared
                    while (true) {//Keep looping while valid customer_cnic is not entered
                        System.out.print("Enter the customer cnic in the format xxxxx-xxxxxxx-x: ");//Tell the user to enter customer cnic
                        customer_cnic = obj.nextLine();//Store the value entered by user in variable customer_cnic

                        String regex = ("\\d{5}-\\d{7}-\\d{1}");//Make regex for cnic format

                        boolean same_cnic = false;//cnic is not same at start
                        if (customer_cnic.matches(regex)) {//If customer cnic matches the required foramt
                            for (int i = 0; i < customer.size(); i++) {//Looping through customer array
                                if (customer_cnic.equals(customer.get(i).get(2))) {//If cnic entered is already of some other person
                                    System.out.println("Two persons can't have same cnic");//Tell the user that cnic can't be same for two persons
                                    same_cnic = true;//As cnic is same thus it become true
                                    break;//Break the loop
                                }
                            }
                            if (same_cnic)//If cnic is same with another
                            {
                                continue;//Continue the loop
                            } else//If cnic is not same with another
                            {
                                break;//Break the loop
                            }
                        } else {////If customer cnic doesn't matches the required foramt
                            System.out.println("Invalid");//Tell the user that cnic is invalid
                            continue;////Continue the loop to take new customer cnic as input from user
                        }

                    }

                    customer.get(update_index).set(2, customer_cnic);//Repalce the value at 2nd index of arraylist present at update_index in customer by customer_cnic
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated 
                } else if (choice.equals("3")) {//If user want to update customer phone number

                    String customer_phoneNo;//A varibale with name customer_phoneNo is declared
                    while (true) {//Keep looping while valid customer phone number is not entered

                        System.out.print("Enter the customer phone number in the format xxxx-xxxxxxx: ");//Tell the user to enter customer phone number
                        customer_phoneNo = obj.nextLine();//Store the value entered by user in variable customer_phoneNo
                        String regex = ("\\d{4}-\\d{7}");//Make regex for phone number format

                        boolean same_phoneNo = false;//phone number is not same at start
                        if (customer_phoneNo.matches(regex)) {//If customer phone number matches the required foramt
                            for (int i = 0; i < customer.size(); i++) {//Looping through customer array
                                if (customer_phoneNo.equals(customer.get(i).get(3))) {//If phone number entered is already of some other person
                                    System.out.println("Two persons can't have same phone number");//Tell the user that phone number can't be same for two persons
                                    same_phoneNo = true;//As phone number is same thus it become true
                                    break;//Break the loop
                                }
                            }
                            if (same_phoneNo)//If phone number is same with another
                            {
                                continue;//Continue the loop
                            } else//If phone number is not same with another
                            {
                                break;//Break the loop
                            }
                        } else {////If customer phone number doesn't matches the required foramt
                            System.out.println("Invalid");//Tell the user that phone number is invalid
                            continue;////Continue the loop to take new customer phone number as input from user
                        }
                    }
                    customer.get(update_index).set(3, customer_phoneNo);//Repalce the value at 3rd index of arraylist present at update_index in customer by customer_phoneNo
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                } else {//If user enter his choice other than 1, 2, 3, 4
                    System.out.println("***** Invalid input *****");//Tell the user that this is invalid
                }

            } else {//If update is not present in customer
                System.out.println("***** No such customer code exists *****");//Tell the user that no such customer record exist
            }

        } else {//If customer record is empty
            System.out.println("***** No customer record is there to update *****");//Tell the user that there is no customer record present
        }

        return (customer);//Return the ArrayList customer so that you can use it in any other function
    }

    /*
    This method is made to display sale menu to user so he can decide what he want to do with sale
    Arguments of this method are 2d ArrayList item, 2d ArrayList customer and 3d ArrayList sale all of string type
    This method returns 3d ArrayList sale of string type
     */
    public static ArrayList<ArrayList<ArrayList<String>>> salemenu(ArrayList<ArrayList<String>> item, ArrayList<ArrayList<String>> customer, ArrayList<ArrayList<ArrayList<String>>> sale) {//sale menu is made

        String check = "1";//A variable with name check is initialized and decalred 
        while (check.equals("1")) {//Keep looping if check is equal to 1
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            System.out.print("Enter your choice\nEnter 1 to add sale\nEnter 2 to view sale\nEnter 3 to delete sale\nEnter 4 to update sale: ");//ask the user to tell her choice
            String choice = obj.nextLine();//Value entered by user is stored in variable choice
            if (choice.equals("1")) {//If 1 is stored in variable choice
                sale = addsale(item, customer, sale);//Call add sale method and store the return value in ArrayList sale
            } else if (choice.equals("2")) {//If 2 is stored in variable choice
                viewsale(sale);//Call view sale method
            } else if (choice.equals("3")) {//If 3 is stored in variable choice
                sale = deletesale(sale);//Call delete sale method and store the return value in ArrayList sale
            } else if (choice.equals("4")) {//If 4 is stored in variable choice
                sale = updatesale(item, customer, sale);//Call update sale method and store the return value in ArrayList sale
            } else {//If choice is something else than 1,2,3,4
                System.out.println("***** Invalid input *****");//Display invalid input
            }
            System.out.print("enter 1 to continue to sale menu: ");//Ask the user to enter 1 if he want to continue to sale menu
            check = obj.nextLine();//Value entered is stored in variable check
        }
        return (sale);//Return ArrayList sale

    }

    /*
    This method is made to add sale record
    Arguments passed in this method are 2d ArrayList item, 2d ArrayList customer, 3d ArrayList sale all of type string
    This method returns the 3d ArrayList sale of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> addsale(ArrayList<ArrayList<String>> item, ArrayList<ArrayList<String>> customer, ArrayList<ArrayList<ArrayList<String>>> sale) {//Add sale method is made

        ArrayList<String> allitems_quantity = new ArrayList<>();//Made an arraylist allitems_quantity to contain all the items quantity
        for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to size of item
            allitems_quantity.add(item.get(first_array_item_index).get(3));//Add the quantity of each item in arraylist allitems_quantity
        }
        int indexes_where_zero = 0;//Made a varible to count where item quantity is zero and initialize it to 0 
        for (int allitems_quantity_index = 0; allitems_quantity_index < allitems_quantity.size(); allitems_quantity_index++) {//Looping from 0 to size of all_items quantity - 1
            if (allitems_quantity.get(allitems_quantity_index).equals("0")) {//If quantity of item is zero
                indexes_where_zero++;//Make increment in the variable indexes_where_zero as we have found quantity as zero

            }

        }
        if (indexes_where_zero == allitems_quantity.size()) {//If quantity of all items become zero
            System.out.println("***** The stock of all items available have finished.. Add item stock to sold more items *****");//Tell the user that stock has finised
            return sale;//Return sale to stop adding sales as stock has finished
        }
        System.out.println("***** Adding sale record *****");//Tell the user that adding sale has started
        while (true) {//keeep looping while user want to add more record of sale
            if (item.size() != 0 && customer.size() != 0) {//If some record of item and customer is present
                int total_bill = 0;//Total bill is zero for the sale at the beginning
                int total_bill_market = 0;//Total bill according to market price is also zero at the beginning
                ArrayList<ArrayList<String>> sale1 = new ArrayList<>();//Made an array for adding one sale record
                ArrayList<String> array_sale_id = new ArrayList<>();//Make an array to add sale id
                Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input from user

                String sale_id;//Declare sale_id so to use it in add sale
                while (true) {//Keep looping while valid sale_id is not entered

                    System.out.print("Enter the sale id: ");//Tell the user to enter sale id
                    sale_id = obj.nextLine();//Store the value entered by user in the varible sale_id

                    boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale id
                    for (char ch : sale_id.toCharArray()) {//For every element of the character array containing each element of the sale id 

                        if (Character.isDigit(ch)) {//If element of character array is digit
                            digitFound = true;//Assign true to digitFound
                        } else {//If element is not a digit
                            digitFound = false;//Assign false to digitFound
                            break;//Break the loop as there is no element of sale_id which is not digit
                        }
                    }

                    if (digitFound == false) {//If sale_id doesn't contain only digits
                        System.out.println("***** Enter only digits as sale id *****");//Ask the user to enter only digits as sale id
                        continue;//Continue the loop to take new sale id as input from user
                    }

                    int repeat = 0;//Initialize varibale repeat as 0 as we have not checked sale id for uniqueness yet

                    for (int first_array_item_index = 0; first_array_item_index < sale.size(); first_array_item_index++) {//Looping from 0 to size of sale 
                        if (sale.get(first_array_item_index).get(0).equals(sale_id)) {//If sale id is already present in sale
                            System.out.println("***** This sale id already exist ..enter another sale id *****");//Tell the user that id is already present and ask her to enter unique sale id
                            repeat = 1;//Repeat become 1 as sale id is already present in sale
                            break;//Break the loop when sale id is not unique
                        }
                    }
                    if (repeat == 1) {//If sale id is not unique
                        continue;//Continue the loop to take another sale id 
                    } else {//If sale id is unique
                        break;//Break the loop
                    }
                }
                array_sale_id.add(sale_id);//Add sale id entered by user in the array of sale id
                sale1.add(0, array_sale_id);//Add array of sale id in sale record
                String sale_customer_id;//Declare a varibale sale_customer_id
                while (true) {//Keep looping while valid sale_customer_id is not entered
                    System.out.print("Enter the customer id of the customer you are selling product to: ");//Tell the user to enter the customer id of the custoemr to whom you want to sell 
                    sale_customer_id = obj.nextLine();//Store the value entered by user in the variable sale_customer_id

                    boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale_customer_id
                    for (char ch : sale_customer_id.toCharArray()) {//For every element of the character array containing each element of the sale_customer_id 

                        if (Character.isDigit(ch)) {//If element of character array is digit
                            digitFound = true;//Assign true to digitFound
                        } else {//If element is not a digit
                            digitFound = false;//Assign false to digitFound
                            break;//Break the loop as there is no element of sale_customer_id which is not digit
                        }
                    }

                    if (digitFound == false) {//If sale_cutomer_id doesn't contain only digits
                        System.out.println("***** Enter only digits as customer id *****");//Ask the user to enter only digits as sale_customer_id
                        continue;//Continue the loop to take new sale_customer_id as input from user
                    } else {//If sale_customer_id contain only digits
                        break;//Break the loop
                    }
                }

                boolean equal = false;//Initialize the equal variable as false as we have not checked sale_customer id in customer arraylist
                for (int first_array_customer_index = 0; first_array_customer_index < customer.size(); first_array_customer_index++) {//Looping from 0 to size of customer
                    if (customer.get(first_array_customer_index).get(0).equals(sale_customer_id)) {//If sale_customer_id is found in arraylist customer
                        equal = true;//Set the equal variable to true as sale_customer_id is found in arraylist customer 
                        break;//Break the loop when found
                    }
                }
                if (equal == false) {//If customer is not found in arraylist customer
                    System.out.println("***** Customer not found, Please Add this Customer First *****");//Tell the userthat the customer is not registered

                    return sale;//Return sale to stop adding sale as customer is not registered
                }
                ArrayList<String> array_customer_id = new ArrayList<>();//Made an arraylist for adding customer id
                array_customer_id.add(sale_customer_id);//Add customer id in above made arraylist
                sale1.add(1, array_customer_id);//Add array of customer id in sale record

                ArrayList<String> sale_total_price = new ArrayList<>();//Made an arraylist to add the price of the item sold to a customer
                ArrayList<String> sale_total_market_price = new ArrayList<>();//Made an arraylist to add the price according to market price of the item sold to a customer
                ArrayList<String> sale_items = new ArrayList<>();//Make an arraylist to add the items sold to a customer
                ArrayList<String> sale_items_quantity = new ArrayList<>();//Make an arraylist to add quantity of items sold to a customer
                while (true) {//keep looping while user wants to sell more items

                    String sale_item_code;//A varibale with name sale_item_code is declared
                    while (true) {//Keep looping while valid item code is not entered
                        obj = new Scanner(System.in);//An object of scanner class is made to take input from user
                        System.out.print("Enter the item code of item you want to sell: ");//Tell the user to enter the item code which he want to sell
                        sale_item_code = obj.nextLine();//Store the value enter by user in variable sale_item_code

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code yet
                        for (char ch : sale_item_code.toCharArray()) {//For every element of the character array containing each element of the item code 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of sale_item_code which is not digit
                            }
                        }

                        if (digitFound == false) {//If sale_item_code doesn't contain only digits
                            System.out.println("***** Enter only digits as item code *****");//Ask the user to enter only digits as item code
                            continue;//Continue the loop to take new item code as input from user
                        } else {//If sale_item_code contain only digits
                            break;//Break the loop
                        }
                    }

                    int index = -1;//Declare a variable index to check item code index in arraylist item and set it to -1 as we have not started searching it yet  
                    equal = false;//Set equal again to false for searching item code in arraylist item
                    for (int first_ArrayList_item_index = 0; first_ArrayList_item_index < item.size(); first_ArrayList_item_index++) {//Looping from 0 to size of item - 1
                        if (item.get(first_ArrayList_item_index).get(0).equals(sale_item_code)) {//Ifitem code is present in arraylist item
                            equal = true;//Set equal to true as we have found item code in arraylist item
                            index = first_ArrayList_item_index;//Store the index of item code in arraylist item in variable index
                            break;//Break the loop when item code is found in arraylist item
                        }
                    }
                    boolean repeat_item = false;//Make a variable to check item code uniqueness
                    int index_repeat_item = -1;//Make a variable to check index of item code which is not unique
                    if (equal == false) {//If item code doesn't matches any of the item code present in arraylist item
                        System.out.println("***** This item is not available, Add this item First *****");//Tell the user that this item is not available

                        return sale;//Return the arraylist sale to stop add sale 
                    } else if (item.get(index).get(3).equals("0")) {//If item stock has finished
                        System.out.println("***** The stock of this item has finished, please add another item *****");//Tell the user that this item is no more available and ask her to add another item code
                        continue;//Continue the loop to take another item code
                    } else if (sale_items.contains(sale_item_code)) {//If item code entered is already taken by customer
                        repeat_item = true;//Iem code is not unique 
                        index_repeat_item = sale_items.indexOf(sale_item_code);//Find the inex of the item code which is not unique
                        //System.out.println(index_repeat_item);
                    } else {
                        sale_items.add(sale_item_code);//Add item code in item array
                    }
                    while (true) {//Keep looping while sale_item_quantity is not enetered correctly
                        String sale_quantity;//declare a variable with the name sale_quantity
                        while (true) {//Keep looping while valid quantity of item is not entered

                            System.out.print("Enter the quantity of item you want to sell: ");//Ask the user to enter quantity ofthe item he want to sell
                            sale_quantity = obj.nextLine();//Store the value entered by user in variable sale_qunatity
                            boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item quantity
                            for (char ch : sale_quantity.toCharArray()) {//For every element of the character array containing each element of the item quantity 

                                if (Character.isDigit(ch)) {//If element of character array is digit
                                    digitFound = true;//Assign true to digitFound
                                } else {//If element is not a digit
                                    digitFound = false;//Assign false to digitFound
                                    break;//Break the loop as there is no element of item_quantity which is not digit
                                }
                            }

                            if (digitFound == false) {//If item_quantity doesn't contain only digits
                                System.out.println("***** Enter only digits as item quantity*****");//Ask the user to enter only digits as item quantity
                                continue;//Continue the loop to take new item quantity as input from user
                            } else {//If item_quantity contain only digits
                                break;//Break the loop
                            }
                        }

                        if (sale_quantity.equals("0")) {//If user enter 0 as quantity of item
                            System.out.println("***** Quantity can't be zero *****");//Tell the user that quantity can't be zero
                            continue;//Continue the loop to take correct item quantity from user
                        }

                        if (Integer.parseInt(sale_quantity) > Integer.parseInt((item.get(index).get(3)))) {//If quantity entered is greater than the amount of quantity available
                            System.out.println("***** This quantity of item is not avialable *****");//Tell the user that this qunatity is not available
                            continue;//Continue the loop to take correct item quantity
                        } else {//If quantity is correct
                            if (repeat_item == true) {//If item whose quantity is entered is already taken by user
                                sale_items_quantity.set(index_repeat_item, Integer.toString(Integer.parseInt(sale_quantity) + Integer.parseInt(sale_items_quantity.get(index_repeat_item))));//Add the quantity entered before with the quantity entered and place it at that index where item code is present in arraylist of sale item quantity 

                            } else {//If item is not taken by the customer before 
                                sale_items_quantity.add(sale_quantity);//Add the quantity in arraylist sale item quantity
                            }

                            int int_item_price = Integer.parseInt(item.get(index).get(2));//Convert item code to int
                            int int_item_quantity = Integer.parseInt(item.get(index).get(3));//Convert the quantity of item present to int
                            int int_sale_item_quantity = Integer.parseInt(sale_quantity);//Convert quantity of item taken to int
                            int_item_quantity -= int_sale_item_quantity;//Remove the amount of quantity taken from total amount present
                            String String_item_quantity = Integer.toString(int_item_quantity);//Convert new item quantity gained by subtracting amount of quantity taken from total amount present to string
                            item.get(index).set(3, String_item_quantity);//Add the new quantity in arraylist item
                            int total_price = int_item_price * int_sale_item_quantity;//Find the total price by multiplying item quantity with item price
                            int int_item_market_price = Integer.parseInt(item.get(index).get(4));//Convert item market price to int
                            int total_market_price = int_item_market_price * int_sale_item_quantity;//Find total price accoding to market by multiplying item quantity with item market price
                            total_bill_market += total_market_price;//Add total price according to market to the bill that will be generated if item are sold acording to market price
                            total_bill += total_price;//Add total price to the bill of the customer
                            //System.out.println(total_bill);
                            String string_total_market_price = Integer.toString(total_market_price);//Convert total price according to market to string
                            String string_total_price = Integer.toString(total_price);//Convert total price to string
                            if (repeat_item == true) {//If already taken item is again taken by customer
                                sale_total_price.set(index_repeat_item, Integer.toString(Integer.parseInt(string_total_price) + Integer.parseInt(sale_total_price.get(index_repeat_item))));//Add total price with the price before and then add it in arraylist of sale_total_price

                            } else {//If item taken by customer is not taken before
                                sale_total_price.add(string_total_price);//Add the price to the arraylist sale_total_price
                            }

                            sale_total_market_price.add(string_total_market_price);//Add total_market_price to arraylist sale_total_market_price
                            break;//Break the loop when one item is done
                        }

                    }

                    allitems_quantity = new ArrayList<>();//Make an arraylist to keep record of quantity of all items present
                    for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to size of item
                        allitems_quantity.add(item.get(first_array_item_index).get(3));//Add the quantity of each item in arraylist allitems_quantity
                    }
                    //Collections.sort(allitems);
                    //Collections.sort(sale_items);
                    //allitems.equals(sale_items);
                    indexes_where_zero = 0;//Made a varible to count where item quantity is zero and set it to 0 
                    for (int allitems_quantity_index = 0; allitems_quantity_index < allitems_quantity.size(); allitems_quantity_index++) {//Looping from 0 to size of all_items quantity - 1
                        if (allitems_quantity.get(allitems_quantity_index).equals("0")) {//If quantity of item is zero
                            indexes_where_zero++;//Make increment in the variable indexes_where_zero as we have found quantity as zero

                        }

                    }
                    if (indexes_where_zero == allitems_quantity.size()) {//If quantity of all items become zero
                        System.out.println("***** The stock of all items available have finished.. Add item stock to sold more items *****");//Tell the user that stock has finised
                        sale1.add(2, sale_items);//Add all items sold to sale record
                        sale1.add(3, sale_items_quantity);//Add quantity of all items to sale record
                        sale1.add(4, sale_total_price);//Add price of all items to sale record

                        String string_total_bill = Integer.toString(total_bill);//Convert the total bill generated to string
                        ArrayList<String> array_total_bill = new ArrayList<>();//Make an arraylist for adding total bill
                        array_total_bill.add(string_total_bill);//Add total bill in arraylist
                        sale1.add(5, array_total_bill);//Add total bill to sale record
                        String string_total_bill_market = Integer.toString(total_bill_market);//Convert total bill according to market to string
                        ArrayList<String> array_total_bill_market = new ArrayList<>();//Make an array to add total bill according to market
                        array_total_bill_market.add(string_total_bill_market);//Add total bill according to market to arraylist
                        sale1.add(6, array_total_bill_market);//Add total bill according to market to sale record
                        sale1.add(7, sale_total_market_price);//Add total price according to market to sale record
                        sale.add(sale1);//Add record of one sale to ArrayList sale
                        return sale;//Return the arraylist sale to stop add sale as stock of all items has finished
                    }
                    System.out.print("Press 1 to add another item...Press any other key to stop this customer sale: ");//Tell the user to enter 1 if he want to sale more items to customer
                    String more_item = obj.nextLine();//Store the value entered by user in variable more_items
                    if (more_item.equals("1")) {//If user want to sale more items to the customer
                        continue;//Continue the loop to add more items
                    } else {//If user want to stop the customer sale
                        /*StringBuffer sb1 = new StringBuffer();
      
                        for (String s : sale_items) {
                        sb1.append(s);
                        sb1.append(",");
                        }
                        String str1 = sb1.toString();
                        StringBuffer sb2 = new StringBuffer();
      
                        for (String s : sale_items_quantity) {
                        sb2.append(s);
                        sb2.append(",");
                        }
                        String str2 = sb2.toString();
                        StringBuffer sb3 = new StringBuffer();
      
                        for (String s : sale_total_price) {
                        sb3.append(s);
                        sb3.append(",");
                        }
                        String str3 = sb3.toString();*/
                        sale1.add(2, sale_items);//Add items sold to sale record
                        sale1.add(3, sale_items_quantity);//Add item's quantity sold to sale record
                        sale1.add(4, sale_total_price);//Add total price to sale record

                        String string_total_bill = Integer.toString(total_bill);//Convert total bill to string
                        ArrayList<String> array_total_bill = new ArrayList<>();//Make an arraylist to add total bill
                        array_total_bill.add(string_total_bill);//Add total bill to its arrylist
                        sale1.add(5, array_total_bill);//Add total bill arraylist to sale record
                        String string_total_bill_market = Integer.toString(total_bill_market);//Convert total bill according to market to string
                        ArrayList<String> array_total_bill_market = new ArrayList<>();//Make an arraylist to add total bill according to market
                        array_total_bill_market.add(string_total_bill_market);//Add total bill according to market to its arrylist
                        sale1.add(6, array_total_bill_market);//Add total bill according to market arraylist to sale record
                        sale1.add(7, sale_total_market_price);//Add total price according to market to sale record

                        sale.add(sale1);//Add one sale record to ArrayList sale
                        break;//Break the loop
                    }

                }
            } else {//If customer/item record is not present
                System.out.println("***** Add item/customer record first to sale the prouct *****");//Tell the suer to enter item/customerrcord to start sale
            }

            Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input
            System.out.print("Enter 1 to add more : ");//Ask the user to enter 1 if he want to do more sale
            String check = obj.nextLine();//Store the value in variable check

            if (check.equals("1")) {//If user want to do more sale

                continue;//Continue the loop to add more sales

            } else {//If user doesn't want to do more sale
                System.out.println("***** Sales are added successfully *****");//Tell the user that sale has been done
                break;//Break the loop to stop sale
            }

        }
        return (sale);//Return arraylist sale to use it in other functions
    }

    /*
    This method is made to view the record of the sale
    Argument of this method is 3d ArrayList sale of type string
    This is a void method so it is not returning any value
     */
    public static void viewsale(ArrayList<ArrayList<ArrayList<String>>> sale) {//View sale method is made
        if (sale.size() != 0) {//If there is something present in ArrayList sale
            System.out.println("***** Viewing sale record *****");//Tell the user that the record is displaying
            for (int first_array_item_index = 0; first_array_item_index < sale.size(); first_array_item_index++) {//Looping from 0 to size of sale - 1
                System.out.println("sale_id: " + sale.get(first_array_item_index).get(0).get(0) + "\nsale_customer_id: " + sale.get(first_array_item_index).get(1).get(0));//Display sale id and customer id to whom you are selling
                System.out.println("sale_item_code\tsale_item_quantity\tsale_total_price");//Display the heading for viewing item record present in sale

                for (int third_array_item_index = 0; third_array_item_index < sale.get(first_array_item_index).get(2).size(); third_array_item_index++) {//Looping from 0 to number of items sold to one customer

                    for (int second_array_item_index = 2; second_array_item_index < 5; second_array_item_index++) {//Looping from 2 to 4

                        System.out.print(sale.get(first_array_item_index).get(second_array_item_index).get(third_array_item_index) + "\t\t\t");//Dispalying item sold ,its quantity and total price each after two tab spaces
                    }
                    System.out.println();//Leave a line after displaying items sold

                }
                System.out.println("Total_bill: " + sale.get(first_array_item_index).get(5).get(0));//Display total bill

                System.out.println();//Leave a line after displaying record of one sale
            }
        } else {//If there is nothing in arrayList sale
            System.out.println("***** Sale record not found *****");//Tell the user that no sale record is present
        }
    }

    /*
    This method is made to delete the record of the sale which user want
    Argument of this method is 3d ArrayList sale of type string
    This method is returning 3d ArrayList sale of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> deletesale(ArrayList<ArrayList<ArrayList<String>>> sale) {//Delete sale method is made
        System.out.println("***** Deleting sale record *****");//Tell the user to delete the record
        if (sale.size() != 0) {//If there is something present in ArrayList sale
            String delete;//A varibale with name delete is declared
            while (true) {//Keep looping while valid sale id is not entered
                Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
                System.out.print("Enter the sale id you want to delete: ");//Tell the user to enter the sale id whose record he want to delete
                delete = obj.nextLine();//Store the value entered by user in variable delete

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale id
                for (char ch : delete.toCharArray()) {//For every element of the character array containing each element of the sale id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of sale id which is not digit
                    }
                }

                if (digitFound == false) {//If sale id doesn't contain only digits
                    System.out.println("***** Enter only digits as sale id *****");//Ask the user to enter only digits as sale id
                    continue;//Continue the loop to take new sale id as input from user
                } else {//If sale id contain only digits
                    break;//Break the loop
                }
            }

            int index = -1;//Initialize the index of variable delete as -1 as we have not found the index of delete in sale yet
            boolean found = false;//Intialize the varibale found as false as we have not found delete in sale yet
            for (int first_array_sale_index = 0; first_array_sale_index < sale.size(); first_array_sale_index++) {//Looping from 0 to length of sale - 1
                if (sale.get(first_array_sale_index).get(0).get(0).equals(delete)) {//If delete is present in sale
                    index = first_array_sale_index;//Found the index where delete is present in sale
                    found = true;//Found becomes true as delete is found in sale
                    break;//Break the loop when delete is found
                }
            }
            if (found == true) {//If delete is present in sale
                sale.remove(index);//Remove the record of the sale required by user
                System.out.println("***** Sale having id " + delete + " is deleted successfully *****");//Tell the user that record is deleted
            } else {//If delete is not present in sale
                System.out.println("***** The id you entered doesn't match any sale *****");//Tell the user that this sale is not present
            }
        } else {//If there is nothing in sale
            System.out.println("***** Sale record not found *****");//Tell the user that sale record is not present
        }
        return sale;//Return the ArrayList sale so you can use it in other functions
    }

    /*
    This method is made to update sale record
    Arguments of this method are 2d arraylist item, 2d arraylist customer and 3d arraylist sale all of type string
    This method is returning 3d arraylist sale of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> updatesale(ArrayList<ArrayList<String>> item, ArrayList<ArrayList<String>> customer, ArrayList<ArrayList<ArrayList<String>>> sale) {//Update sale mathod is made
        System.out.println("***** Updating sale record *****");//Tell the user to update the item record
        if (sale.size() != 0) {//If there is something present in sale
            Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input from user
            String update;//A varibale with name update is declared
            while (true) {//Keep looping while valid sale id is not entered

                System.out.print("Enter the sale id for which you want to update the record: ");//Tell the user to enter the sale id for which he want to update the record
                update = obj.nextLine();//Store the value entered by user in the variable update

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale id
                for (char ch : update.toCharArray()) {//For every element of the character array containing each element of the sale id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of sale id which is not digit
                    }
                }

                if (digitFound == false) {//If sale id doesn't contain only digits
                    System.out.println("***** Enter only digits as item price *****");//Ask the user to enter only digits as sale id
                    continue;//Continue the loop to take new sale id as input from user
                } else {//If sale id contain only digits
                    break;//Break the loop
                }
            }

            int index = -1;//Initialize the index of variable update in sale as -1 as we have not found the index of delete in sale yet
            boolean found = false;//Intialize the varibale found as false as we have not found update in sale yet
            for (int first_array_sale_index = 0; first_array_sale_index < sale.size(); first_array_sale_index++) {//Looping from 0 to length of sale - 1
                if (sale.get(first_array_sale_index).get(0).get(0).equals(update)) {//If update is present in sale 
                    index = first_array_sale_index;//Found the index where update is present in sale
                    found = true;//Found becomes true as update is found in sale
                    break;//Break the loop when update is found
                }
            }
            if (found == true) {//If update is present in sale
                obj = new Scanner(System.in);//Make object of scanner class to take input
                System.out.print("Enter 1 to update sale customer id \nEnter 2 to update sale item code and it's quantity\nEnter 3 to update only quantity of item: ");//Ask the user to enter his choice about what he want to update
                String choice = obj.nextLine();//Store the value entered by user in the variable choice
                if (choice.equals("1")) {//If user want to update customer id
                    String sale_customer_id;//A varibale with name customer id is declared
                    while (true) {//Keep looping while valid customer id is not entered
                        System.out.print("Enter the sale customer id for which you are sellig item to: ");//Ask the user to enter the new customer id
                        sale_customer_id = obj.nextLine();//Store the value entered in variable sale_customer_id

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in customer id
                        for (char ch : sale_customer_id.toCharArray()) {//For every element of the character array containing each element of the customer id 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of customer id which is not digit
                            }
                        }

                        if (digitFound == false) {//If customer id doesn't contain only digits
                            System.out.println("***** Enter only digits as customer id*****");//Ask the user to enter only digits as customer id
                            continue;//Continue the loop to take new customer id as input from user
                        } else {//If customer id contain only digits
                            break;//Break the loop
                        }
                    }

                    boolean equal = false;//Initialize the equal variable as false as we have not checked sale_customer id in customer arraylist
                    for (int first_array_customer_index = 0; first_array_customer_index < customer.size(); first_array_customer_index++) {//Looping from 0 to size of sale - 1
                        if (customer.get(first_array_customer_index).get(0).equals(sale_customer_id)) {//If sale_customer_id is found in arraylist customer
                            equal = true;//Set the equal variable to true as sale_customer_id is found in arraylist customer 
                            break;//Break the loop when found
                        }
                    }
                    if (equal == false) {//If customer is not found in arraylist customer
                        System.out.println("***** Customer not found, Please Add this Customer First *****");//Tell the userthat the customer is not registered
                    } else {//If customer is found in arraylist customer
                        sale.get(index).get(1).set(0, sale_customer_id);//Replace the customer id by new one in sale
                        System.out.println("***** Record has been updated successfully *****");//Tell the user that record has been updated

                    }
                } else if (choice.equals("2")) {//If user want to update item code and quantity sold
                    int total_bill = 0;//Initialze total bill to 0 at the beginnig
                    int total_bill_market = 0;//Initialze total bill according to market to 0 at the beginnig
                    int times_loop = 0;//Initialize no of times loop is run to zero
                    ArrayList<String> sale_items = new ArrayList<>();//Made an arraylist to add items sold
                    while (true) {//Keep looping while user want to add more items
                        times_loop++;//When loop start increment no of times loop is run
                        String sale_item_code;//A varibale with name item code is declared
                        while (true) {//Keep looping while valid item code is not entered
                            System.out.print("Enter the item code you want to sell: ");//Ask the user to enter new item code
                            sale_item_code = obj.nextLine();//Store the value in variable sale_item_code

                            boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                            for (char ch : sale_item_code.toCharArray()) {//For every element of the character array containing each element of the item code

                                if (Character.isDigit(ch)) {//If element of character array is digit
                                    digitFound = true;//Assign true to digitFound
                                } else {//If element is not a digit
                                    digitFound = false;//Assign false to digitFound
                                    break;//Break the loop as there is no element of item code which is not digit
                                }
                            }

                            if (digitFound == false) {//If item code doesn't contain only digits
                                System.out.println("***** Enter only digits as item stock*****");//Ask the user to enter only digits as item code
                                continue;//Continue the loop to take new item code as input from user
                            } else {//If item code contain only digits
                                break;//Break the loop
                            }
                        }

                        int index_item_code = -1;//Declare a variable index_item_code to check item code index in arraylist item and set it to -1 as we have not started searching it yet
                        boolean equal = false;//Set equal to false for searching item code in arraylist item
                        for (int first_ArrayList_item_index = 0; first_ArrayList_item_index < item.size(); first_ArrayList_item_index++) {//Looping from 0 to size of item - 1
                            if (item.get(first_ArrayList_item_index).get(0).equals(sale_item_code)) {//If item code is present in arraylist item
                                index_item_code = first_ArrayList_item_index;//Store the index of item code in arraylist item in variable index_item_code
                                equal = true;//Set equal to true as we have found item code in arraylist item
                                break;//Break the loop when item code is found in arraylist item
                            }
                        }
                        int index_item_code_remove = -1;//Find the index of item code in arraylist item to add its quantity in item that was sold earlier
                        if (equal == false) {//If item code is not found in arraylist item
                            System.out.println("***** This item is not available, Add this item First *****");//Tell the user that this item is not available
                            break;//Break the loop
                        } else {//If item code is found in arraylist item
                            if (times_loop == 1) {//If loop is run for first time
                                for (int third_ArrayList_sale_index = 0; third_ArrayList_sale_index < sale.get(index).get(3).size(); third_ArrayList_sale_index++) {//Looping from 0 to number of items available
                                    int item_qunatity_sale = Integer.parseInt(sale.get(index).get(3).get(third_ArrayList_sale_index));//Find the quantity of item that is present before 

                                    for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to size of item - 1
                                        if (item.get(first_array_item_index).get(0).equals(sale.get(index).get(2).get(third_ArrayList_sale_index))) {//If item code present in sale equals item code that is present before in sale 
                                            index_item_code_remove = first_array_item_index;//Find the index where item code of sale is present in item
                                            //index_item_code_inItem=i;
                                            break;//Break the loop
                                        }
                                    }
                                    int item_quantity_inItem = Integer.parseInt(item.get(index_item_code_remove).get(3));//Get the quantity of item present in item record
                                    int item_quantity_add = item_quantity_inItem + item_qunatity_sale;//Add quantity of item sold previosuly with item quantity present in item record as we are now updating previous record and save the value in the variable
                                    item.get(index_item_code_remove).set(3, Integer.toString(item_quantity_add));//Put above value in item record

                                }
                                sale.get(index).get(2).clear();//Clear all the item record present in sale to add new one
                                sale.get(index).get(2).clear();//Clear all the item quantity record present in sale to add new one

                            }

                            /*ArrayList<String> sale_id=new ArrayList(sale.get(index).get(0));
                            ArrayList<String> sale_customer_id=new ArrayList(sale.get(index).get(1));
                            sale.remove(index);
                            sale.get(index).add(sale_id);*/
                        }
                        boolean repeat_item = false;//Make a variable to check item code uniqueness
                        int index_repeat_item = -1;//Make a variable to check index of item code which is not unique

                        if (item.get(index_item_code).get(3).equals("0")) {//If item stock has finished
                            System.out.println("***** The stock of this item has finished, please add another item *****");//Tell the user that this item is no more available and ask her to add another item code
                            continue;//Continue the loop to take another item code
                        } else if (sale_items.contains(sale_item_code)) {//If item code entered is already taken by customer
                            repeat_item = true;//Iem code is not unique
                            index_repeat_item = sale_items.indexOf(sale_item_code);//Find the index of the item code which is not unique
                        } else {
                            sale_items.add(sale_item_code);//Add item code to item array
                            sale.get(index).get(2).add(times_loop - 1, sale_item_code);//Set the index where item code is present previously to arraylist of items
                        }
                        while (true) {//Keep looping while sale_item_quantity is not enetered correctly
                            String sale_quantity;//A varibale with name sale_item_quantity is declared
                            while (true) {//Keep looping while valid item quantity is not entered
                                System.out.print("Enter the quantity of item you want to sell: ");//Tell the user to enter new quantity of item
                                sale_quantity = obj.nextLine();//Store the value in varibale sale_quantity

                                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item quantity
                                for (char ch : sale_quantity.toCharArray()) {//For every element of the character array containing each element of the item quantity 

                                    if (Character.isDigit(ch)) {//If element of character array is digit
                                        digitFound = true;//Assign true to digitFound
                                    } else {//If element is not a digit
                                        digitFound = false;//Assign false to digitFound
                                        break;//Break the loop as there is no element of item quantity which is not digit
                                    }
                                }

                                if (digitFound == false) {//If item quantity doesn't contain only digits
                                    System.out.println("***** Enter only digits as item quantity*****");//Ask the user to enter only digits as item quantity
                                    continue;//Continue the loop to take new item quantity as input from user
                                } else {//If item quantity contain only digits
                                    break;//Break the loop
                                }
                            }

                            if (sale_quantity.equals("0")) {//If user enter 0 as quantity of item
                                System.out.println("***** Quantity can't be zero *****");//Tell the user that quantity can't be zero
                                continue;//Continue the loop to take correct item quantity from user
                            }
                            if (Integer.parseInt(sale_quantity) > Integer.parseInt(item.get(index_item_code).get(3))) {//If quantity entered is greater than the amount of quantity available
                                System.out.println("***** This quantity of item is not avialable *****");//Tell the user that this qunatity is not available
                                continue;//Continue the loop to take correct item quantity
                            } else {//If quantity is correct
                                if (repeat_item == true) {//If item whose quantity is entered is already taken by user
                                    sale.get(index).get(3).set(index_repeat_item, Integer.toString(Integer.parseInt(sale_quantity) + Integer.parseInt(sale.get(index).get(3).get(index_repeat_item))));//Add the quantity entered before with the quantity entered and place it at that index where item code is present in arraylist of sale item quantity
                                    //System.out.println(index_repeat_item);   
                                } else {//If item is not taken by the customer before

                                    sale.get(index).get(3).add(times_loop - 1, sale_quantity);//Add the quantity in arraylist sale item quantity
                                }

                                int int_item_price = Integer.parseInt(item.get(index_item_code).get(2));//Convert item price to int
                                int int_item_quantity = Integer.parseInt(item.get(index_item_code).get(3));//Convert the quantity of item present to int
                                int int_sale_item_quantity = Integer.parseInt(sale_quantity);//Convert quantity of item taken to int
                                int_item_quantity -= int_sale_item_quantity;//Remove the amount of quantity taken from total amount present
                                String String_item_quantity = Integer.toString(int_item_quantity);//Convert new item quantity gained by subtracting amount of quantity taken from total amount present to string
                                item.get(index_item_code).set(3, String_item_quantity);//Add the new quantity in arraylist item
                                int total_price = int_item_price * int_sale_item_quantity;//Find the total price by multiplying item quantity with item price
                                int int_item_market_price = Integer.parseInt(item.get(index_item_code).get(4));//Convert item market price to int
                                int total_market_price = int_sale_item_quantity * int_item_market_price;//Find total price accoding to market by multiplying item quantity with item market price
                                total_bill_market += total_market_price;//Add total price according to market to the bill that will be generated if item are sold acording to market price

                                total_bill += total_price;//Add total price to the bill of the customer

                                String string_total_market_price = Integer.toString(total_price);//Convert total price according to market to string
                                if (repeat_item == true) {//If already taken item is again taken by customer
                                    sale.get(index).get(4).set(index_repeat_item, Integer.toString(Integer.parseInt(string_total_market_price) + Integer.parseInt(sale.get(index).get(4).get(index_repeat_item))));//Add total price with the price before and then add it in arraylist of sale_total_price

                                } else {//If item taken by customer is not taken before

                                    sale.get(index).get(4).add(times_loop - 1, string_total_market_price);//Add the price according to market to sale record
                                }

                                String string_total_price = Integer.toString(total_market_price);//Convert total price to string
                                sale.get(index).get(7).add(times_loop - 1, string_total_price);//Add price to sale record
                                break;//Break the loop when one item is done
                            }

                        }

                        ArrayList<String> allitems_quantity = new ArrayList<>();//Make an arraylist to keep record of quantity of all items present
                        for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to size of item
                            allitems_quantity.add(item.get(first_array_item_index).get(3));//Add the quantity of each item in arraylist allitems_quantity
                        }

                        int indexes_where_zero = 0;//Made a varible to count where item quantity is zero and set it to 0 
                        for (int allitems_quantity_index = 0; allitems_quantity_index < allitems_quantity.size(); allitems_quantity_index++) {//Looping from 0 to size of all_items quantity - 1
                            if (allitems_quantity.get(allitems_quantity_index).equals("0")) {//If quantity of item is zero
                                indexes_where_zero++;//Make increment in the variable indexes_where_zero as we have found quantity as zero

                            }

                        }
                        if (indexes_where_zero == allitems_quantity.size()) {//If quantity of all items become zero
                            System.out.println("***** The stock of all items available have finished.. Add item stock to sold more items *****");//Tell the user that stock has finised

                            String string_total_bill = Integer.toString(total_bill);//Convert total bill to string

                            sale.get(index).get(5).set(0, string_total_bill);//Add total bill to sale record
                            String string_total_bill_market = Integer.toString(total_bill_market);//Convert total market bill to string

                            sale.get(index).get(6).set(0, string_total_bill_market);//Add total bill according to market to sale record
                            return sale;//Return sale to stop adding sale
                        }
                        System.out.print("Press 1 to add another item...Press any other key to stop this customer sale: ");//Ask the user to enter 1 if he want to sale another item
                        String more_item = obj.nextLine();//Store the value in the variable
                        if (more_item.equals("1")) {//If user want to sale another item
                            continue;//Continue the loop to take another item
                        } else {//If user doesn't want to add more items

                            String string_total_bill = Integer.toString(total_bill);//Convert total bill to string
                            sale.get(index).get(5).set(0, string_total_bill);//Add total bill to sale record
                            String string_total_bill_market = Integer.toString(total_bill_market);//Convert total bill according to market to string
                            sale.get(index).get(6).set(0, string_total_bill_market);//Add total bill according to market to sale record
                            System.out.println("***** Record has been updated successfully *****");//Tell the user that sale has updated
                            break;//Break the loop to stop updating
                        }
                    }
                } else if (choice.equals("3")) {//If user want to update qunatity of item
                    int total_bill = Integer.parseInt(sale.get(index).get(5).get(0));//Convert total bill present in sale to int
                    int total_bill_market = Integer.parseInt(sale.get(index).get(6).get(0));//Convert total bill according to market present in sale to int
                    while (true) {//keep looping while user want to udate the qunatity of item
                        obj = new Scanner(System.in);//Make an object of scanner class to take inut from user
                        String sale_item_code;//A varibale with name sale_item_code is declared
                        while (true) {//Keep looping while valid item code is not entered
                            System.out.print("Enter the item code whose quantity you want to update: ");//Ask the user to enter item code whose quanity he want to update
                            sale_item_code = obj.nextLine();//Store the value in the variable

                            boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item code
                            for (char ch : sale_item_code.toCharArray()) {//For every element of the character array containing each element of the item code 

                                if (Character.isDigit(ch)) {//If element of character array is digit
                                    digitFound = true;//Assign true to digitFound
                                } else {//If element is not a digit
                                    digitFound = false;//Assign false to digitFound
                                    break;//Break the loop as there is no element of item code which is not digit
                                }
                            }

                            if (digitFound == false) {//If item code doesn't contain only digits
                                System.out.println("***** Enter only digits as item code*****");//Ask the user to enter only digits as item code
                                continue;//Continue the loop to take new item code as input from user
                            } else {//If item code contain only digits
                                break;//Break the loop
                            }
                        }

                        int indexOfItemCode = -1;//Make a variable to find the index of item code in sale
                        int found_item_code = 0;//Intialize item code found to zero as we have not starting searching it yet
                        for (int third_array_sale_index = 0; third_array_sale_index < sale.get(index).get(2).size(); third_array_sale_index++) {//Looping from 0 to number of items present in sale record
                            if (sale_item_code.equals(sale.get(index).get(2).get(third_array_sale_index))) {//If item code is present in sale record
                                found_item_code = 1;//Set item found to 1 as item has found in sale
                                indexOfItemCode = third_array_sale_index;//Find the index of item code in sale
                                break;//Break the loop when item code is found in sale
                            } else {//If item code is not found in sale
                                found_item_code = 0;//Set item found to 0 as item code is not found in sale

                            }
                        }
                        if (found_item_code == 1) {//If item code is present in sale
                            int int_item_qunatity_inSale = Integer.parseInt(sale.get(index).get(3).get(indexOfItemCode));//Find the quantity of item sold previously
                            int indexOfItemCode_InItems = -1;//Find the index of item code in item record by making a variable an initialize it t -1 as we have not stared finding it yet
                            for (int first_array_item_index = 0; first_array_item_index < item.size(); first_array_item_index++) {//Looping from 0 to size of item - 1
                                if (item.get(first_array_item_index).get(0).equals(sale.get(index).get(2).get(indexOfItemCode))) {//If item code present in item become equal to item code prsent in sale
                                    indexOfItemCode_InItems = first_array_item_index;//Find the index of item code in item record
                                    //index_item_code_inItem=i;
                                    break;//Break the loop when item code is found in item record
                                }
                            }
                            int int_item_qunatity_inItems = Integer.parseInt(item.get(indexOfItemCode_InItems).get(3));//Find the quantity of item present in item record
                            int int_add_qunatity = int_item_qunatity_inItems + int_item_qunatity_inSale;//Add the quantity that is preent with the quantity that is sold previously
                            item.get(indexOfItemCode_InItems).set(3, Integer.toString(int_add_qunatity));//Put the quantity that is found above by adding in item record 

                            while (true) {//Keep looping while correct item quantity is not entered

                                String sale_item_quantity;//A varibale with name sale-item_quantity is declared
                                while (true) {//Keep looping while valid item qunatity is not entered
                                    System.out.print("Enter the quantity of item having code " + sale_item_code + " : ");//Tell the user to enter the new quantity of item
                                    sale_item_quantity = obj.nextLine();//Store the value entered by user in the varibale

                                    boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in item qunatity
                                    for (char ch : sale_item_quantity.toCharArray()) {//For every element of the character array containing each element of the item quantity 

                                        if (Character.isDigit(ch)) {//If element of character array is digit
                                            digitFound = true;//Assign true to digitFound
                                        } else {//If element is not a digit
                                            digitFound = false;//Assign false to digitFound
                                            break;//Break the loop as there is no element of item_qunatity which is not digit
                                        }
                                    }

                                    if (digitFound == false) {//If item quantity doesn't contain only digits
                                        System.out.println("***** Enter only digits as item stock*****");//Ask the user to enter only digits as item quantity
                                        continue;//Continue the loop to take new item qunatity as input from user
                                    } else {//If item quantity contain only digits
                                        break;//Break the loop
                                    }
                                }

                                if (sale_item_quantity.equals("0")) {//If quantity is entered zero
                                    System.out.println("***** Quantity can't be zero *****");//Tell the user that qunatity can't be zero
                                    continue;//Continue the loop to take correct item quantity from user
                                }
                                if (Integer.parseInt(sale_item_quantity) > Integer.parseInt(item.get(indexOfItemCode_InItems).get(3))) {//If quantity entered by user is not present
                                    System.out.println("***** This quantity of item is not avialable *****");//Tell the user that this quantity is not available 
                                    continue;
                                } else {//If qunatity is available

                                    sale.get(index).get(3).set(indexOfItemCode, sale_item_quantity);//Set the new qunatity in sale
                                    int int_item_price = Integer.parseInt(item.get(indexOfItemCode_InItems).get(2));//Convert item price present in item to int 
                                    int int_item_quantity = Integer.parseInt(item.get(indexOfItemCode_InItems).get(3));//Convert item quantity present in item to int
                                    int int_sale_item_quantity = Integer.parseInt(sale_item_quantity);//Convert item quantity sold to int
                                    int_item_quantity -= int_sale_item_quantity;//Remove the amount of quantity taken from total amount present
                                    String String_item_quantity = Integer.toString(int_item_quantity);//Convert new item quantity gained by subtracting amount of quantity taken from total amount present to string
                                    item.get(indexOfItemCode_InItems).set(3, String_item_quantity);//Add the new quantity in arraylist item
                                    int total_price = int_item_price * int_sale_item_quantity;//Find the total price by multiplying item quantity with item price
                                    int int_item_market_price = Integer.parseInt(item.get(indexOfItemCode_InItems).get(4));//Convert item market price to int
                                    int total_market_price = int_sale_item_quantity * int_item_market_price;//Find total price accoding to market by multiplying item quantity with item market price
                                    total_bill -= Integer.parseInt(sale.get(index).get(4).get(indexOfItemCode));//Remove the price that is present at sale whose record you are updating from bill now we are generating
                                    total_bill += total_price;//Add total price to the bill of the customer
                                    total_bill_market -= Integer.parseInt(sale.get(index).get(7).get(indexOfItemCode));//Remove the price according to market price that is present at sale whose record you are updating from bill according to market price now we are generating
                                    total_bill_market += total_market_price;//Add total price according to market to the bill that will be generated if item are sold acording to market price

                                    String string_total_price = Integer.toString(total_price);//Convert total price to string

                                    sale.get(index).get(4).set(indexOfItemCode, string_total_price);//Put total price in sale record

                                    break;
                                }
                            }
                            System.out.print("Enter 1 to update quantity of another item: ");//Tell the user to enter 1 if he want to update quantity of another item
                            int check = obj.nextInt();//Store the value in variable check
                            if (check == 1) {//If user want to update quantity of another item
                                continue;//Continue the loop to take quantity and item code whose quantity user want to update

                            } else {
                                String string_total_bill = Integer.toString(total_bill);//Convert total bill to string
                                sale.get(index).get(5).set(0, string_total_bill);//Put total bill in sale record
                                String string_total_bil_market = Integer.toString(total_bill_market);//Convert total bill according to market to string
                                sale.get(index).get(6).set(0, string_total_bil_market);//Put total bill according to market in sale record
                                System.out.println("***** Record has been updated successfully *****");//Tell the user that update has been done
                                break;//Break the loop when record is updated
                            }
                        } else {//If item code is not prsesent in sale id on which we are working
                            System.out.println("***** No such item code exit at sale id " + update + " *****");//Tell the user that this item code is not present at the specific sale id
                            break;
                        }

                    }

                } else {//If input is other than 1,2,3
                    System.out.println("***** Invalid input *****");//Tell the user that the input is invalid
                }

            } else {//If sale id not exist
                System.out.println("***** No such sale id exists *****");//Tell the user that so scuch sale id is present in sale
            }

        } else {//If sale record is not present
            System.out.println("***** No sale record is there to update *****");//Tell the user that sale record is not present
        }
        return (sale);//Reyurn sale to use this in other functions
    }

    /*
    This method is made to display reporting menu to user so he can decide what he want to do with report
    Arguments of this method are 3d ArrayLists sale and reporting of type string
    This method is returning 3d ArrayList reporting of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> reportingmenu(ArrayList<ArrayList<ArrayList<String>>> sale, ArrayList<ArrayList<ArrayList<String>>> reporting) {//Reporting menu method is made

        String check = "1";//A variable with name check is initialized and decalred 
        while (check.equals("1")) {//Keep looping if check is equal to 1
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            System.out.print("Enter your choice\nEnter 1 to add report\nEnter 2 to view report\nEnter 3 to delete report\nEnter 4 to update report: ");//Ask the user to tell her choice
            String choice = obj.nextLine();//Value entered by user is stored in variable choice
            if (choice.equals("1")) {//If 1 is stored in variable choice
                reporting = addreporting(sale, reporting);//Call add reporting method and store the return value in ArrayList reporting
            } else if (choice.equals("2")) {//If 2 is stored in variable choice
                viewreporting(reporting);//Call view reporting method
            } else if (choice.equals("3")) {//If 3 is stored in variable choice
                reporting = deletereporting(reporting);//Call delete reporting method and store the return value in ArrayList reporting
            } else if (choice.equals("4")) {//If 4 is stored in variable choice
                reporting = updatereporting(sale, reporting);//Call update reporting method and store the return value in ArrayList reporting
            } else {//If choice is something else than 1,2,3,4
                System.out.println("***** Invalid input *****");//Display invalid input
            }
            System.out.print("enter 1 to continue to reporting menu: ");//Ask the user to enter 1 if he want to continue to reporting menu
            check = obj.nextLine();//Value entered is stored in variable check
        }
        return (reporting);//Return ArrayList reporting

    }

    /*
    This function is made to add the record of reports
    Arguments of this method are 3d arraylist sale and reporting both of type string
    This method is returning 3d arraylist reporting of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> addreporting(ArrayList<ArrayList<ArrayList<String>>> sale, ArrayList<ArrayList<ArrayList<String>>> reporting) {//Add reporting method is made
        while (true) {//Keep looping while user want to add more reports
            if (sale.size() != 0) {//If there is some sale done
                System.out.println("***** Adding reporting record *****");//Tell the user to add the record of reports
                int total_bill = 0;//Initialize total bill of one report to zero
                ArrayList<ArrayList<String>> reporting1 = new ArrayList<>();//Create an array to add record of one report
                ArrayList<String> array_reporting_id = new ArrayList<>();//Create an array to add reporting id
                Scanner obj = new Scanner(System.in);//Create an object of scanner class to take input from user

                String reporting_id;//A variable with name reporting_id is declared
                while (true) {//While valid report id is not entered

                    System.out.print("Enter the report id: ");///Tell the user to enter report id
                    reporting_id = obj.nextLine();//Store the value entered in the variable made

                    boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in repot id
                    for (char ch : reporting_id.toCharArray()) {//For every element of the character array containing each element of the repot id 

                        if (Character.isDigit(ch)) {//If element of character array is digit
                            digitFound = true;//Assign true to digitFound
                        } else {//If element is not a digit
                            digitFound = false;//Assign false to digitFound
                            break;//Break the loop as there is no element of repot id which is not digit
                        }
                    }

                    if (digitFound == false) {//If repot id doesn't contain only digits
                        System.out.println("***** Enter only digits as repot id*****");//Ask the user to enter only digits as repot id
                        continue;//Continue the loop to take new repot id as input from user
                    } else {//If report id is valid

                        int repeat = 0;//Create a variable to find uniqueness of report id

                        for (int first_array_reporting_index = 0; first_array_reporting_index < reporting.size(); first_array_reporting_index++) {//Looping from 0 to size of reporting - 1
                            if (reporting.get(first_array_reporting_index).get(0).equals(reporting_id)) {//If report id is already present in report record
                                System.out.println("***** This report id already exist ..enter another report id *****");//Ask the user to enter another report id as this one already exist
                                repeat = 1;//Report id is not unique so repeat becomes 1
                                break;//Break the loop when report id is not unique
                            }
                        }
                        if (repeat == 1) {//If report id is not unique
                            continue;//Continue the loop to take another report id is input from user
                        } else {//If report id is unique
                            break;//Break the loop to take other details about report
                        }
                    }
                }
                array_reporting_id.add(reporting_id);//Add report id to array of report id
                reporting1.add(0, array_reporting_id);//Add array of report id to report record 
                ArrayList<String> array_reporting_period = new ArrayList<>();//Create an array to add report day/month/year
                String reporting_period;//Declare a varibale with the name reporting_period
                while (true) {//Keep looping while valid date/month/year is not entered
                    int repeat = 0;//Find that the report of that day/month/year is already present or not
                    System.out.print("Enter the day/month/year of which the report is generated: ");//Tell the user to enter day/month/year of which he want to made report
                    reporting_period = obj.nextLine();//Store the value entered in variable
                    int invalid = 0;//Report day/month/year is not invalid yet
                    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);//Make format pattern for day/month/year
                    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/uuuu");//Make format pattern for month/year

                    DateTimeFormatter format3 = DateTimeFormatter.ofPattern("uuuu");//Make format pattern for year

                    try {//Try the format day/month/year
                        format1.parse(reporting_period);//If format day/month/year is passed then it is true

                    } catch (Exception e) {//If format day/month/year is not true
                        invalid++;//Invalidity is present in value entered

                    }
                    try {//Try the format month/year
                        //if (month_int>=0 && month_int<=12){
                        YearMonth.parse(reporting_period, format2);//If format month/year is passed then it is true

                    } catch (Exception e) {//If format month/year is not true
                        invalid++;//Invalidity is present in value entered

                    }
                    try {//Try the format year
                        format3.parse(reporting_period);//If format year is passed then it is true
                    } catch (Exception e) {//If format year is not true

                        invalid++;//Invalidity is present in value entered

                    }
                    if (invalid == 3) {//If any one of above validity is not true
                        System.out.println("***** Invalid *****");//Tell the user that the value entered is invalid
                        continue;//continue the loop when value is not valid
                    }
                    for (int first_array_reporting_index = 0; first_array_reporting_index < reporting.size(); first_array_reporting_index++) {//Looping from 0 to size of reporting - 1

                        if (reporting.get(first_array_reporting_index).get(1).get(0).equals(reporting_period)) {//If report of day/month/year is already generated
                            System.out.println("***** Report of " + reporting_period + " is already generated..Enter another day/month/year *****");//Tell the user to enter another
                            repeat = 1;//Repeat becomes 1 as report day/month/year is repeat

                        }
                    }
                    if (repeat == 1) {//If day/month/year of report is repeated 
                        continue;//Continue the loop 
                    } else {//If day/month/year of report is unique one
                        array_reporting_period.add(reporting_period);//Add that in array of it
                        break;//Break the loop
                    }
                }

                reporting1.add(1, array_reporting_period);//Add the day/month/year of report to report 
                ArrayList<String> array_sale_id = new ArrayList<>();//Make an array to add sales done in the report period
                ArrayList<String> array_sale_bill = new ArrayList<>();//Make an array to add bill of the sales dones in the report period
                ArrayList<String> array_sale_id_item = new ArrayList<>();//Make an array to add items sold in the report period
                ArrayList<String> array_sale_id_quantity = new ArrayList<>();//Make an array to add quantity of items sold in the report period
                ArrayList<String> array_sale_item = new ArrayList<>();//Make an array to add items of one sale done in the report period
                ArrayList<String> array_sale_quantity = new ArrayList<>();//Make an array to add quantity of items of one sale done in the report period
                ArrayList<String> array_sale_bill_market = new ArrayList<>();//Make an array to add bill according to market of sales done in the report period
                int loop_times = 0;//Loop is not started yet so number of times loop is run is zero at start
                while (true) {//Keep looping while sale of report period is not finished
                    loop_times++;//When loop start number of times loop is run is increment
                    String reporting_sale_id;//A varibale with name reporting_sale_id is declared
                    while (true) {//Keep looping while valid sale id is not entered
                        System.out.print("Enter the sale id of the sale you have done on " + reporting_period + " : ");//Tell the user to enter sale that is dene in report period
                        reporting_sale_id = obj.nextLine();//Store the value in the variable

                        boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale id
                        for (char ch : reporting_sale_id.toCharArray()) {//For every element of the character array containing each element of the sale id 

                            if (Character.isDigit(ch)) {//If element of character array is digit
                                digitFound = true;//Assign true to digitFound
                            } else {//If element is not a digit
                                digitFound = false;//Assign false to digitFound
                                break;//Break the loop as there is no element of sale id which is not digit
                            }
                        }

                        if (digitFound == false) {//If sale id doesn't contain only digits
                            System.out.println("***** Enter only digits as sale id *****");//Ask the user to enter only digits as sale id
                            continue;//Continue the loop to take new sale id as input from user
                        } else {//If sale id contain only digits
                            break;//Break the loop
                        }
                    }

                    boolean equal = false;//Equal is false at start as we have not started founding sale id in sale record
                    int index_sale_id = -1;//Variable is made to find index of sale id in sale record
                    for (int first_array_sale_index = 0; first_array_sale_index < sale.size(); first_array_sale_index++) {//Looping from 0 to size of sale - 1
                        if (sale.get(first_array_sale_index).get(0).get(0).equals(reporting_sale_id)) {//If sale id is present in sale record
                            equal = true;//Equal become true as sale id is found in sale record 
                            index_sale_id = first_array_sale_index;//Find the index of sale id in sale
                            break;//Break the loop if sale id is found in sale record
                        }
                    }
                    if (equal == false) {//If sale id is not found in sale
                        System.out.println("***** Sale not found, Please Add this sale First *****");//Tell the user that record of this sale is not present

                        return reporting;//Return reporting to stop adding report record
                    }
                    equal = false;//Equal is again made false to find if sale id is already present in array of sale id's or not
                    for (int array_sale_id_index = 0; array_sale_id_index < array_sale_id.size(); array_sale_id_index++) {//Looping from 0 to size of array in which sale id is present - 1
                        if (reporting_sale_id.equals(array_sale_id.get(array_sale_id_index))) {//If sale id is already present in sale id array
                            equal = true;//Equal become true as sale id is already entered
                        }
                    }
                    if (equal == true) {//If sale id is already entered 
                        System.out.println("***** This sale id is already added..Enter another sale id *****");//Tell the user that sale id is already entered as it is present in array of sale id's 
                        continue;//Continue the loop to take unique sale id 
                    }

                    array_sale_id.add(reporting_sale_id);//Add sale id to its array
                    array_sale_bill.add(sale.get(index_sale_id).get(5).get(0));//Add the bill of the sale in its array
                    array_sale_bill_market.add(sale.get(index_sale_id).get(6).get(0));//Add the bill according to market price of the sale in its array
                    array_sale_id_item = sale.get(index_sale_id).get(2);//Add items of the sale to its array
                    array_sale_id_quantity = sale.get(index_sale_id).get(3);//Add quantity of items sale to its array

                    int index_sale_id_item = -1;//Make a variable to find the index of items sold at the sale we are adding in reporting in arraylist sale
                    int index_sale_item = -1;  //Make a variable to find the index of item sold in a specific reporting period in arraylist which will be later added to report record
                    boolean found = false;//make a variable to found if item of sale is already present in reporting or not
                    for (int array_sale_id_item_index = 0; array_sale_id_item_index < array_sale_id_item.size(); array_sale_id_item_index++) {//Looping from 0 to number of items of the sale
                        if (loop_times == 1) {//If loop is run at first time
                            array_sale_item.add(array_sale_id_item.get(array_sale_id_item_index));//Add the items of sale to reporting by adding them in the arraywhich will be added later to report
                            array_sale_quantity.add(array_sale_id_quantity.get(array_sale_id_item_index));//Add the quantity of items of sale to reporting by adding them in the arraywhich will be added later to report
                        } else {//If loop not run for first time (another sale is done )

                            for (int array_sale_item_index = 0; array_sale_item_index < array_sale_item.size(); array_sale_item_index++) {//Looping from 0 to number of items present in arraylist which will be late added to report record
                                if (array_sale_id_item.get(array_sale_id_item_index).equals(array_sale_item.get(array_sale_item_index))) {//If item of sale is already present in arraylist which will be later added to report record
                                    index_sale_id_item = array_sale_id_item_index;//Find that index of item code which is repeat in sale
                                    index_sale_item = array_sale_item_index;//Find the index where repetition occurs
                                    found = true;//Found become true as index is already present in arraylist of item code to be added to report record
                                    break;//Break the loop when found

                                }
                            }
                            if (found == true) {//If item code is already present in arraylist which will be alater added to report record
                                array_sale_quantity.set(index_sale_item, Integer.toString(Integer.parseInt(array_sale_quantity.get(index_sale_item)) + Integer.parseInt(array_sale_id_quantity.get(index_sale_id_item))));//Add the previous and now entered quantity to the arraylist of item quantity which will be late added to reporting record
                                //System.out.println(array_sale_quantity.get(index_sale_item));
                            } else {//If item code is not present in arraylist of item which will be later added to reporting record
                                array_sale_item.add(array_sale_id_item.get(array_sale_id_item_index));//Simply add that item to arraylist of item codes which will be alater added to report record
                                array_sale_quantity.add(array_sale_id_quantity.get(array_sale_id_item_index));//Simply add the quantity of the item to arraylist of items quantity which will be alater added to report record

                            }

                        }

                    }
                    System.out.print("Enter 1 if you have you done more sale on " + reporting_period + " : ");//Ask the user to enter 1 if more sale have been done in report period
                    String more_sale = obj.nextLine();//store th value in more_sale
                    if (more_sale.equals("1")) {//If user want to add more sale
                        if (array_sale_id.size() == sale.size()) {//if all sales are already added in report
                            System.out.println("***** All sale id's have been added in this report..Add more sale record if you want to add more sales in this report *****");//Tell the user that all sales are present no more left to add
                            break;//Break the loop
                        } else {//If all sales are not added in report 
                            continue;//Continue the loop to take another sale id done on report period
                        }

                    } else {//If user have not done any more sale on the given report period
                        break;//Break the loop
                    }
                }
                reporting1.add(2, array_sale_id);//Add sale id array to report record
                //array_sale_id.clear();
                reporting1.add(3, array_sale_bill);//Add array of the bills of sales in report record
                reporting1.add(4, array_sale_item);//Add array of items of sales in report record
                reporting1.add(5, array_sale_quantity);//Add quantity of items of sales in report record
                reporting1.add(6, array_sale_bill_market);//Add array of the bills according to market price of sales in report record
                reporting.add(reporting1);//Add record of one report to arraylist reporting
                System.out.print("Enter 1 if want to add more reports: ");//Tell the user to enter 1 if he want to add more reports
                String check = obj.nextLine();//Store the value in variable check
                if (check.equals("1")) {//If user want to make more reports
                    continue;//Continue the loop to take report data
                } else {//If user doesn't want to make more reports
                    System.out.println("***** Reort is added successfully *****");//Tell the user that reports data entered are added
                    break;//Break the loop after require reports are added
                }
            } else {//If sale is not done yet
                System.out.println("***** No sale record exist...Add sale record first to generate report *****");//Tell the user to do sale to make report
                break;//Break the loop
            }
        }
        return (reporting);//Return reporting to use it in other functions
    }

    /*
    This method is made to view the record of reporting
    Argument of this method is 3d ArrayList reporting of type string
    This is a void method so it is not returning any value
     */
    public static void viewreporting(ArrayList<ArrayList<ArrayList<String>>> reporting) {//View reporting method is made
        if (reporting.size() != 0) {//If there is something present in ArrayList reporting
            System.out.println("***** Viewing reporting record *****");//Tell the user that the record is displaying
            for (int first_array_item_index = 0; first_array_item_index < reporting.size(); first_array_item_index++) {//Looping from 0 to size of reporting - 1

                System.out.println("Report id: " + reporting.get(first_array_item_index).get(0).get(0));//Displaying report id
                System.out.println("This is the report of " + reporting.get(first_array_item_index).get(1).get(0));//Display of which date the report is
                System.out.println("Total number of sales done on " + reporting.get(first_array_item_index).get(1).get(0) + " : " + reporting.get(first_array_item_index).get(2).size());//Display the no of sales done in a report
                int total_amount = 0;//To store total amount gained variable is made
                for (int third_array_item_index = 0; third_array_item_index < reporting.get(first_array_item_index).get(3).size(); third_array_item_index++) {//Looping from 0 to no of bills present in reporting
                    total_amount += Integer.parseInt(reporting.get(first_array_item_index).get(3).get(third_array_item_index));//Add each bill to the amount gained

                }
                System.out.println("Total amount gained: " + total_amount);//Display the total amount gained
                int total_market_amount = 0;//To store total amount that will be gained if user sold according to market price variable is made
                for (int third_array_item_index = 0; third_array_item_index < reporting.get(first_array_item_index).get(6).size(); third_array_item_index++) {//Looping from 0 to no of bills according to market price present in reporting
                    total_market_amount += Integer.parseInt(reporting.get(first_array_item_index).get(6).get(third_array_item_index));//Add each bill to the amount gained if sold according to market price

                }
                System.out.println("Total amount that can be gained if items were sold according to market price: " + total_market_amount);//Display amount that will be gained if sale was one according to market price
                /*ArrayList<Integer> items_sold=new ArrayList<>();//Make an array to find all items sold
            for (int third_array_item_index=0;third_array_item_index<reporting.get(first_array_item_index).get(4).size();third_array_item_index++){//Looping from 0 to number of items sold
                items_sold.add(Integer.parseInt(reporting.get(first_array_item_index).get(4).get(third_array_item_index)));//Add the items sold to 
            }*/
                System.out.println("Total number of items sold: " + reporting.get(first_array_item_index).get(4).size());//Displat total number of items sold in a report
                ArrayList<Integer> items_quantity = new ArrayList<>();//Make an array to find quantity ofeach item sold
                for (int third_array_item_index = 0; third_array_item_index < reporting.get(first_array_item_index).get(5).size(); third_array_item_index++) {//Looping from 0 to number of items sold - 1
                    items_quantity.add(Integer.parseInt(reporting.get(first_array_item_index).get(5).get(third_array_item_index)));//Add item quantity to arraylist made for adding it
                }
                Set<Integer> set = new HashSet<>(items_quantity);//Pass the arraylist to setto remove any element if occured more than once
                int highest_quantity = Collections.max(items_quantity);//Find highest quantity of item sold by finding largest from arraylist of items quantity
                int index = items_quantity.indexOf(highest_quantity);//Find the index of item which is sold most
                if (set.size() == 1) {//If there is only one element in item quantity left after passing it to set
                    System.out.println("Same quantity of each item is sold");//Tell the suer that same quantity of each item is sold
                    //System.out.println("Id's of items are "+items_quantity);
                    System.out.println("Quantity of each item sold is " + highest_quantity);//Display the quantity of item that is sold
                } else {//If there are many elements in item quantity left after passing it to set
                    System.out.println("Item having id " + reporting.get(first_array_item_index).get(4).get(index) + " is sold most");//Display the item code which is sold most
                    System.out.println("Quantity of item sold is " + highest_quantity);//Tell the quantity of item which is sold most
                }

                int profit_loss = total_amount - total_market_amount;//Find profit/loss by using amount gained and amount gained if sold according to market price
                if (profit_loss > 0) {//If profit/loss is greater than 0
                    System.out.println("Profit is gained\nProfit% is " + (((float) profit_loss / total_market_amount) * 100));//Display profit occurs and the amount of profit occured
                } else if (profit_loss < 0)//If profit/loss is less than zero
                {
                    System.out.println("Loss occurs\nLoss% is " + (-(((float) profit_loss / total_market_amount) * 100)));//Display loss occurs and the amount of loss occured

                } else if (profit_loss == 0) {//If profit/loss is zero
                    System.out.println("None of profit/loss occur");//Tell the user that nothing profit/loss occurs
                }
            }
        } else {//If there is nothing in arrayList reporting
            System.out.println("***** No report record is there to view *****");//Tell the user that no reporting record is present
        }

    }

    /*
    This method is made to delete the record of the reporting which user want
    Argument of this method is 3d ArrayList reporting of type string
    This method is returning 3d ArrayList reporting of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> deletereporting(ArrayList<ArrayList<ArrayList<String>>> reporting) {//Delete reporting method is made
        System.out.println("***** Deleting report record *****");//Tell the user to delete the record
        if (reporting.size() != 0) {//If there is something present in ArrayList reporting
            Scanner obj = new Scanner(System.in);//An object of scanner class is made to take input from user
            String delete;//A varibale with name delete is declared
            while (true) {//Keep looping while valid reporting id is not entered
                System.out.print("Enter the report id you want to delete: ");//Tell the user to enter the reporting id whose record he want to delete
                delete = obj.nextLine();//Store the value entered by user in variable delete

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in reporting id
                for (char ch : delete.toCharArray()) {//For every element of the character array containing each element of the reporting id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of reporting id which is not digit
                    }
                }

                if (digitFound == false) {//If reporting id doesn't contain only digits
                    System.out.println("***** Enter only digits as reporting id *****");//Ask the user to enter only digits as reporting id
                    continue;//Continue the loop to take new reporting id as input from user
                } else {//If reporting id contain only digits
                    break;//Break the loop
                }
            }

            int index = -1;//Initialize the index of variable delete as -1 as we have not found the index of delete
            boolean found = false;//Intialize the varibale found as false as we have not found delete in reporting yet
            for (int first_array_reporting_index = 0; first_array_reporting_index < reporting.size(); first_array_reporting_index++) {//Looping from 0 to length of reporting - 1
                if (reporting.get(first_array_reporting_index).get(0).get(0).equals(delete)) {//If delete is present in reporting
                    index = first_array_reporting_index;//Found the index where delete is present in reporting
                    found = true;//Found becomes true as delete is found in reporting
                    break;//Break the loop when delete is found
                }
            }
            if (found == true) {//If delete is present in reporting
                reporting.remove(index);//Remove the record of the reporting required by user
                System.out.println("***** Report having id " + delete + " is deleted successfully *****");//Tell the user that record is deleted
            } else {//If delete is not present in reporting
                System.out.println("***** The id you entered doesn't match any report *****");//Tell the user that this report is not present
            }
        } else {//If there is nothing in reporting
            System.out.println("***** Report record not found *****");//Tell the user that reporting record is not present
        }

        return (reporting);//Return the ArrayList reporting so you can use it in other functions
    }

    /*
    This function is made to update report record
    Argument of this method is 3d ArrayList sale and reporting both of type string
    This method is returning 3d ArrayList reporting of type string
     */
    public static ArrayList<ArrayList<ArrayList<String>>> updatereporting(ArrayList<ArrayList<ArrayList<String>>> sale, ArrayList<ArrayList<ArrayList<String>>> reporting) {//Update reporting method is made
        System.out.println("***** Updating report record *****");//Tell the user to update the reporting record
        if (!reporting.isEmpty()) {//If there is something present in reporting
            Scanner obj = new Scanner(System.in);//Make an object of scanner class to take input from user
            String update;//A varibale with name update is declared
            while (true) {//Keep looping while valid report id is not entered
                System.out.print("Enter the report id for which you want to update the record: ");//Tell the user to enter the report id for which he want to update the record
                update = obj.nextLine();//Store the value entered by user in the variable update

                boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in report id
                for (char ch : update.toCharArray()) {//For every element of the character array containing each element of the report id 

                    if (Character.isDigit(ch)) {//If element of character array is digit
                        digitFound = true;//Assign true to digitFound
                    } else {//If element is not a digit
                        digitFound = false;//Assign false to digitFound
                        break;//Break the loop as there is no element of report id which is not digit
                    }
                }

                if (digitFound == false) {//If report id doesn't contain only digits
                    System.out.println("***** Enter only digits as report id *****");//Ask the user to enter only digits as report id
                    continue;//Continue the loop to take new report id as input from user
                } else {//If report id contain only digits
                    break;//Break the loop
                }
            }

            int index = -1;//Initialize the index of variable update as -1 as we have not found the index of update in report yet
            boolean found = false;//Intialize the varibale found as false as we have not found update in report yet
            for (int first_array_reporting_index = 0; first_array_reporting_index < reporting.size(); first_array_reporting_index++) {//Looping from 0 to length of reporting - 1
                if (reporting.get(first_array_reporting_index).get(0).get(0).equals(update)) {//If update is present in reporting
                    index = first_array_reporting_index;//Found the index where update is present in reporting
                    found = true;//Found becomes true as update is found in reporting
                    break;//Break the loop when update is found
                }
            }
            if (found == true) {//If update is present in reporting
                obj = new Scanner(System.in);//Make object of scanner class to take input
                System.out.print("Enter 1 to update day/month/year of report generated \nEnter 2 to update report sale id: ");//Ask the user to enter his choice about what he want to update
                String choice = obj.nextLine();//Store the value entered by user in the variable choice
                if (choice.equals("1")) {//If user want to update day/month/year of report
                    String reporting_period;//Declare a varibale with the name reporting_period
                    while (true) {//Keep looping while valid date/month/year is not entered
                        int repeat = 0;//Find that the report of that day/month/year is already present or not
                        System.out.print("Enter the day/month/year of which the report is generated: ");//Tell the user to enter new day/month/year of which he want to made report
                        reporting_period = obj.nextLine();//Store the value entered in variable
                        int invalid = 0;//Report day/month/year is not invalid yet
                        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);//Make format pattern for day/month/year
                        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/uuuu");//Make format pattern for month/year

                        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("uuuu");//Make format pattern for year

                        try {//Try the format day/month/year
                            format1.parse(reporting_period);//If format day/month/year is passed then it is true

                        } catch (Exception e) {//If format day/month/year is not true
                            invalid++;//Invalidity is present in value entered

                        }
                        try {//Try the format month/year
                            //if (month_int>=0 && month_int<=12){
                            YearMonth.parse(reporting_period, format2);//If format month/year is passed then it is true

                        } catch (Exception e) {//If format month/year is not true
                            invalid++;//Invalidity is present in value entered

                        }
                        try {//Try the format year
                            format3.parse(reporting_period);//If format year is passed then it is true
                        } catch (Exception e) {//If format year is not true

                            invalid++;//Invalidity is present in value entered

                        }
                        if (invalid == 3) {//If any one of above validity is not true
                            System.out.println("***** Invalid *****");//Tell the user that the value entered is invalid
                            continue;//continue the loop when value is not valid
                        }
                        //System.out.print("Enter the day/month/year of which the report is generated: ");
                        //reporting_period=obj.nextLine();
                        for (int first_array_reporting_index = 0; first_array_reporting_index < reporting.size(); first_array_reporting_index++) {//Looping from 0 to size of reporting - 1
                            if ((reporting.get(first_array_reporting_index).get(1).get(0).equals(reporting_period)) && !(reporting.get(index).get(1).get(0).equals(reporting_period))) {//If report of day/month/year is already generated
                                System.out.println("***** Report of " + reporting_period + " is already generated..Enter another day/month/year *****");//Tell the user to enter another
                                repeat = 1;//Repeat becomes 1 as report day/month/year is repeat

                            }
                        }
                        if (repeat == 1) {//If day/month/year of report is repeated 
                            continue;//Continue the loop 
                        } else {//If day/month/year of report is unique one
                            break;//Break the loop
                        }
                    }
                    reporting.get(index).get(1).set(0, reporting_period);//Replace the period of report with new one entered
                    System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                } else if (choice.equals("2")) {//If user want to update sales done in a given period of report
                    int loop_times = 0;//Loop is not started yet so number of times loop is run is zero at start
                    ArrayList<String> array_sale_id = new ArrayList<>();//Make an array to add sales done in the report period
                    ArrayList<String> array_sale_bill = new ArrayList<>();//Make an array to add bill of the sales dones in the report period
                    ArrayList<String> array_sale_id_item = new ArrayList<>();//Make an array to add items sold in the report period
                    ArrayList<String> array_sale_id_quantity = new ArrayList<>();//Make an array to add quantity of items sold in the report period
                    ArrayList<String> array_sale_item = new ArrayList<>();//Make an array to add items of one sale done in the report period
                    ArrayList<String> array_sale_quantity = new ArrayList<>();//Make an array to add quantity of items of one sale done in the report period
                    ArrayList<String> array_sale_bill_market = new ArrayList<>();//Make an array to add bill according to market of sales done in the report period
                    while (true) {//Keep looping while sale of report period is not finished
                        loop_times++;//When loop start number of times loop is run is increment
                        String reporting_sale_id;//A varibale with name reporting_sale_id is declared
                        while (true) {//Keep looping while valid sale id is not entered
                            System.out.print("Enter the sale id of the sale you have done on " + reporting.get(index).get(1).get(0) + " : ");//Tell the user to enter new sale that is dene in report period
                            reporting_sale_id = obj.nextLine();//Store the value in the variable

                            boolean digitFound = false;//Initialize boolean varibale digitFound to false as we have not searched for digits in sale id
                            for (char ch : reporting_sale_id.toCharArray()) {//For every element of the character array containing each element of the sale id

                                if (Character.isDigit(ch)) {//If element of character array is digit
                                    digitFound = true;//Assign true to digitFound
                                } else {//If element is not a digit
                                    digitFound = false;//Assign false to digitFound
                                    break;//Break the loop as there is no element of sale id which is not digit
                                }
                            }

                            if (digitFound == false) {//If sale id doesn't contain only digits
                                System.out.println("***** Enter only digits as sale id *****");//Ask the user to enter only digits as sale id
                                continue;//Continue the loop to take new sale id as input from user
                            } else {//If sale id contain only digits
                                break;//Break the loop
                            }
                        }

                        boolean equal = false;//Equal is false at start as we have not started founding sale id in sale record
                        int index_sale_id = -1;//Variable is made to find index of sale id in sale record
                        for (int first_array_sale_index = 0; first_array_sale_index < sale.size(); first_array_sale_index++) {//Looping from 0 to size of sale - 1
                            if (sale.get(first_array_sale_index).get(0).get(0).equals(reporting_sale_id)) {//If sale id is present in sale record
                                equal = true;//Equal become true as sale id is found in sale record 
                                index_sale_id = first_array_sale_index;//Find the index of sale id in sale
                                break;//Break the loop if sale id is found in sale record
                            }
                        }
                        if (equal == false) {//If sale id is not found in sale
                            System.out.println("***** Sale not found, Please Add this sale First *****");//Tell the user that record of this sale is not present

                            return reporting;//Return reporting to stop adding report record
                        }
                        equal = false;//Equal is again made false to find if sale id is already present in array of sale id's or not
                        for (int array_sale_id_index = 0; array_sale_id_index < array_sale_id.size(); array_sale_id_index++) {//Looping from 0 to size of array in which sale id is present - 1
                            if (reporting_sale_id.equals(array_sale_id.get(array_sale_id_index))) {//If sale id is already present in sale id array
                                equal = true;//Equal become true as sale id is already entered
                            }
                        }
                        if (equal == true) {//If sale id is already entered 
                            System.out.println("***** This sale id is already added..Enter another sale id *****");//Tell the user that sale id is already entered as it is present in array of sale id's
                            continue;//Continue the loop to take unique sale id 
                        }
                        array_sale_id.add(reporting_sale_id);//Add sale id to its array
                        array_sale_bill.add(sale.get(index_sale_id).get(5).get(0));//Add the bill of the sale in its array
                        array_sale_bill_market.add(sale.get(index_sale_id).get(6).get(0));//Add the bill according to market price of the sale in its array
                        array_sale_id_item = sale.get(index_sale_id).get(2);//Add items of the sale to its array
                        array_sale_id_quantity = sale.get(index_sale_id).get(3);//Add quantity of items sale to its array
                        int index_sale_id_item = -1;//Make a variable to find the index of items sold at the sale we are adding in reporting in arraylist sale
                        int index_sale_item = -1;  //Make a variable to find the index of item sold in a specific reporting period in arraylist which will be later added to report record
                        found = false;//make a variable to found if item of sale is already present in reporting or not
                        for (int array_sale_id_item_index = 0; array_sale_id_item_index < array_sale_id_item.size(); array_sale_id_item_index++) {//Looping from 0 to number of items of the sale
                            if (loop_times == 1) {//If loop is run at first time
                                array_sale_item.add(array_sale_id_item.get(array_sale_id_item_index));//Add the items of sale to reporting by adding them in the arraywhich will be added later to report
                                array_sale_quantity.add(array_sale_id_quantity.get(array_sale_id_item_index));//Add the quantity of items of sale to reporting by adding them in the arraywhich will be added later to report
                            } else {//If loop not run for first time (another sale is done )

                                for (int array_sale_item_index = 0; array_sale_item_index < array_sale_item.size(); array_sale_item_index++) {//Looping from 0 to number of items present in arraylist which will be late added to report record
                                    if (array_sale_id_item.get(array_sale_id_item_index).equals(array_sale_item.get(array_sale_item_index))) {//If item of sale is already present in arraylist which will be later added to report record
                                        index_sale_id_item = array_sale_id_item_index;//Find that index of item code which is repeat in sale
                                        index_sale_item = array_sale_item_index;//Find the index where repetition occurs
                                        found = true;//Found become true as index is already present in arraylist of item code to be added to report record
                                        break;//Break the loop when found

                                    }
                                }
                                if (found == true) {//If item code is already present in arraylist which will be alater added to report record
                                    array_sale_quantity.set(index_sale_item, Integer.toString(Integer.parseInt(array_sale_quantity.get(index_sale_item)) + Integer.parseInt(array_sale_id_quantity.get(index_sale_id_item))));//Add the previous and now entered quantity to the arraylist of item quantity which will be late added to reporting record
                                    //System.out.println(array_sale_quantity.get(index_sale_item));
                                } else {//If item code is not present in arraylist of item which will be later added to reporting record
                                    array_sale_item.add(array_sale_id_item.get(array_sale_id_item_index));//Simply add that item to arraylist of item codes which will be alater added to report record
                                    array_sale_quantity.add(array_sale_id_quantity.get(array_sale_id_item_index));//Simply add the quantity of the item to arraylist of items quantity which will be alater added to report record

                                }

                            }

                        }
                        System.out.print("Enter 1 if you have you done more sale on " + reporting.get(index).get(1).get(0) + " : ");//Ask the user to enter 1 if more sale have been done in report period
                        String more_sale = obj.nextLine();//store th value in more_sale
                        if (more_sale.equals("1")) {//If user want to add more sale
                            if (array_sale_id.size() == sale.size()) {//if all sales are already added in report
                                System.out.println("***** All sale id's have been added in this report..Add more sale record if you want to add more sales in this report *****");//Tell the user that all sales are present no more left to add
                                reporting.get(index).set(2, array_sale_id);//Replace sale id's with new one
                                reporting.get(index).set(3, array_sale_bill);//Replace sale bill's with new one
                                reporting.get(index).set(4, array_sale_item);//Replace sale item's with new one
                                reporting.get(index).set(5, array_sale_quantity);//Replace sale item's quantity with new one
                                reporting.get(index).set(6, array_sale_bill_market);//Replace sale bill according to market price with new one
                                System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                                break;//Break the loop when record is updated
                            } else {//If all sales are not added in report 
                                continue;//Continue the loop to take another sale id done on report period
                            }

                        } else {//If user have not done any more sale on the given report period
                            reporting.get(index).set(2, array_sale_id);//Replace sale id's with new one
                            reporting.get(index).set(3, array_sale_bill);//Replace sale bill's with new one
                            reporting.get(index).set(4, array_sale_item);//Replace sale item's with new one
                            reporting.get(index).set(5, array_sale_quantity);//Replace sale item's quantity with new one
                            reporting.get(index).set(6, array_sale_bill_market);//Replace sale bill according to market price with new one
                            System.out.println("***** Record has been updated successfully *****");//Tell the user that record is updated
                            break;//Break the loop when record is updated
                        }
                    }

                } else {//If user enter his choice other than 1, 2, 3, 4
                    System.out.println("***** Invalid input *****");//Tell the user that this is invalid
                }
            } else {//If update is not present in customer
                System.out.println("***** No such report id exists *****");//Tell the user that no such report record exist

            }
        } else {//If report record is empty
            System.out.println("***** No report record is there to update *****");//Tell the user that there is no report record present
        }

        return (reporting);//Return the ArrayList reporting so that you can use it in any other function
    }

}
