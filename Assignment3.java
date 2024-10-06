import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the 3rd assignment for the CEN 4802C course. In this project, a code from another
 * course (Software Development II CEN 4025C, which was used for a different assignment)
 * will be used to demonstrate the unit testing importance. The code is for a
 * simple application that allows the user to add or delete items from a to-do list, and
 * view the items on that same list.
 */
public class Assignment3
{
    /**
     * This is the main method that contains the 3 different functions mentioned in the last comment:
     * add, delete, and list. Additionally, it has a 4th option that allows the user to terminate
     * the program. The functions are separated using a switch/case statement to which the user can
     * easily access by just typing a specific number.
     * @param args Used for the command line arguments passed to the program.
     */
    public static void main(String[] args)
    {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println("Welcome to your To-Do List. Choose one of the following options: " +
                    "\n[1] Add Item " +
                    "\n[2] Delete Item " +
                    "\n[3] List Items " +
                    "\n[4] Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter the to-do item:");
                    String item = scanner.nextLine();
                    toDoList.addItem(item);
                    System.out.println("Item added successfully.\n");
                    break;

                case 2:
                    if (toDoList.getItems().isEmpty())
                    {System.out.println("The to-do list is empty.\n");}
                    else
                    {
                        System.out.println("Enter item index to delete:");
                        int index = scanner.nextInt();
                        boolean success = toDoList.deleteItem(index);
                        if (success)
                        {System.out.println("Item deleted successfully.\n");}
                    }
                    break;

                case 3:
                    List<String> items = toDoList.getItems();
                    if (items.isEmpty())
                    {System.out.println("The to-do list is empty.\n");}
                    else
                    {
                        System.out.println("To-Do Items:");
                        for (int i = 0; i < items.size(); i++)
                        {System.out.println(i + ": " + items.get(i));}
                        System.out.println("\n");
                    }
                    break;

                case 4:
                    System.out.println("The program will exit now.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

/**
 * This class contains the different methods used in the main class. It includes the
 * constructor for the ArrayList that contains the items that will be added by the user,
 * the addItem method for adding the items to the list, the deleteItem method to
 * remove the items from the list, and the getItems to display the items on the list.
 */
class ToDoList
{
    private final List<String> items;

    /**
     * Method used to initialize the 'items' ArrayList.
     */
    public ToDoList()
    {items = new ArrayList<>();}

    /**
     * Method used to add items to the ArrayList.
     */
    public void addItem(String item)
    {items.add(item);}

    /**
     * Method used to remove items from the ArrayList by using an index.
     * @param index It's the number of the item inside the ArrayList.
     */
    public boolean deleteItem(int index)
    {
        if (items.isEmpty())
        {
            System.out.println("The to-do list is empty.");
            return false;
        }
        else
        {
            if (index >= 0 && index < items.size())
            {
                items.remove(index);
                return true;
            }
            else
            {
                System.out.println("Invalid index.");
                return false;
            }
        }
    }


    /**
     * Method used to display the items on the ArrayList.
     * @return Returns the ArrayList content.
     */
    public List<String> getItems()
    {return items;}
}