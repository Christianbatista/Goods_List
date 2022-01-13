package edu.mtc.egr283.ShoppingList;

import java.util.Scanner;

/*************************************************************
 * Class for handling the <code>ShoppingList</code>.
 * This is the class to handle all the records and there input and removal and
 * displaying what is in the list
 * 
 * @author Christian Batista
 * @version 1.00 2019-14-03
 *          Copyright (C) 2019 by Christian Batista. All rights reserved.
 **/
public class ShoppingList {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		SLL<String> list = new SLL<String>();
		String item;
		char ch;

		do {
			System.out.println("*********** Shopping List ***********");
			System.out.println("Select any option (1 to 5)");
			System.out.println("1. Delete an item");
			System.out.println("2. Add an item at a specific location");
			System.out.println("3. Add an item at the end of the list");
			System.out.println("4. Display Shopping list");
			System.out.println("5. Exit");

			int choice = keyboard.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Enter the item which you want to delete from shopping list:");
					item = keyboard.next();

					if (list.find(item).equals(null)) {
						System.out.println("Invalid position\n");
					} else
						list.remove(item);
					System.out.println("item has been removed\n");
					break;

				case 2:
					System.out.println("Enter the item which you want to add in shopping list:");
					item = keyboard.next();
					System.out.println("Enter a specific location where you want to add an item:");
					int pos = keyboard.nextInt();
					if (pos < 0 || pos > list.size()) {
						System.out.println("Invalid position\n");
					} else
						list.add(item, list.size() - 1);// list size has increased by one after this call
					list.swap(list, pos, list.findDataPosition(list.getDataAtPosition(list.size() - 1)));

					break;

				case 3:
					System.out.println("Enter the item which you want to add in shopping list:");
					list.insertAtEnd(item = keyboard.next());
					System.out.println("Data has been added to list");
					break;
				case 4:
					System.out.println("Items in shopping list are:");
					System.out.println(list.toString());
					break;
				case 5:
					System.out.println("Thank you for using the Shopping list");
					System.exit(0);
					break;
				default:
					System.out.println("You have input a option that is not allowed \n ");
					break;
			}// Ending bracket of switch loop

			System.out.println("\nDo you want to continue (Type Y or N) \n");
			ch = keyboard.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');
		System.out.println("End of program");

		keyboard.close();
	}
}// Ending bracket of class ShoppingList