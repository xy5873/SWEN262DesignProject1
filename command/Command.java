package command;

import View.PTUI;
import database.Library;
import src.Goal;
import src.History;
import src.Ingredient;
import src.Meal;
import src.Recipe;
import src.User;
import src.WorkOut;
import search.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
 
    private PTUI ptui;
    private searchIngredients ingredients;
    private List<Recipe> recipes;
    private List<History> workoutHistory = new ArrayList<History>();;
    private Meal meal = new Meal("No meal");
    private Goal goal = new Goal(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /**
     * @param ptui: the plain text user interface
     * create the constrcutor
     */
    public Command(PTUI ptui){
        this.ptui = ptui;
        this.recipes = new ArrayList<>();
        this.ingredients = new searchIngredients();
        try {
            this.ingredients.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     * the user log in and is recording in the txt file
     */
    public void logIn() throws IOException, ClassNotFoundException{
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        FileInputStream fis = new FileInputStream("model/users.txt");
        if(fis.read() != -1) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            User existingUser = (User)ois.readObject();

            if(username.equals(existingUser.getUsername())) {
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                boolean pass = false;

                while(pass) {
                    if(password.equals(existingUser.getPassword())) {
                        System.out.println("\n-----------------------------------------------------------");
                        System.out.println("Logged in as: " + username);
                        ptui.menu();
                        exit();
                        scanner.close();
                        pass = true;
                    }
                    else {
                        System.out.println("Password incorrect");
                    }
                }
            }
            else {
                createUser(username);
            }
            ois.close();
        }
        else {
            createUser(username);
        }
        
        


        // System.out.println("Enter password:");
        // String password = scanner.nextLine();
        // User user = new User(username, password, );



        // lib.add(user);
        // System.out.println("\n-----------------------------------------------------------");
        // System.out.println("Logged in as: " + username);
        // ptui.menu();
        // exit();
        // scanner.close();
    }

    /**
     * @throws IOException
     * creates a new user
     */
    public void createUser(String username) throws IOException, ClassNotFoundException {
            Library lib = PTUI.library;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Create new password:");
            String password = scanner.nextLine();
            System.out.println("Enter birth date(YYYY-MM-DD):");
            String birthDateString = scanner.nextLine();
            System.out.println("Enter current height(inches):");
            int height = scanner.nextInt();
            System.out.println("Enter current weight(lbs):");
            int weight = scanner.nextInt();

            
            
            //System.out.println(birthDateString);
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // LocalDate birthDate = LocalDate.parse(birthDateString, formatter);

            

            // User user = new User(username, password, name, height, weight, birthDate);
            // lib.add(user);
            scanner.close();
    }

    /**
     * @throws IOException
     * the user workout
     */
    public void workout() throws IOException, ClassNotFoundException {

        boolean complete = false;
        boolean invalid = true;
        double cpm = 0.0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nhow long? (minutes): ");
        int duration = scanner.nextInt();
        while(!complete) {
            while(invalid) {
                System.out.println("\n1 -- high intensity");
                System.out.println("2 -- medium intensity");
                System.out.println("3 -- low intensity");
                System.out.print("Which intensity? (#): ");
                int intensity = scanner.nextInt();
            
                if(intensity == 1) {
                    cpm = 10.0;
                    invalid = false;
                }
                else if(intensity == 2) {
                    cpm = 7.5;
                    invalid = false;
                }
                else if(intensity == 3) {
                    cpm = 5.0;
                    invalid = false;
                }
                else {
                    System.out.println("That is not a valid intensity choice");
                }
            }

            WorkOut workout = new WorkOut(duration, cpm, java.time.LocalDate.now());
            double totalCalories = workout.getCalories(cpm, duration);
        
            Scanner input = new Scanner(System.in);
            System.out.print("Did you complete your workout? (y/n): ");
            String str = input.nextLine();
            if(str.equals("y")) {
                System.out.println("\n" + workout.toString() + "\n");
                if(goal.getCalorieGoal() != Integer.MAX_VALUE) {
                    if(totalCalories >= goal.getCalorieGoal()) {
                        System.out.println("You reached your calorie goal!");
                    }
                    else {
                        System.out.println("You did not reach your calorie goal");
                    }
                }
                else {
                    System.out.println("If you want a goal, set it up in the menu");
                }

                History history = new History(goal.getWeightGoal(), goal.getCalorieGoal(), meal, workout);
                workoutHistory.add(history);
                ptui.menu();
                complete = true;
            }
        }
        scanner.close();
        exit();
    }

    /**
     * @throws IOException
     * the user history
     */
    public void history() throws IOException, ClassNotFoundException {
        if(workoutHistory.size() != 0) {
            System.out.println("\nHistory:");
            for(History history: workoutHistory) {
                System.out.println("Workout - " + history.getWorkOut().toString());
                System.out.println("Meal - " + history.getMeal().getName());
                System.out.println();
            }
            ptui.menu();
        }
        else {
            System.out.println("\nNo previous workouts.\n");
            ptui.menu();
        }
        
    }

    /**
     * @throws IOException
     * the user goal
     */
    public void goal() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nWhat is your weight goal?: ");
        int weightGoal = input.nextInt();
        System.out.print("How many calories a workout do you want to burn?: ");
        int calorieGoal = input.nextInt();

        goal = new Goal(weightGoal, calorieGoal);

        ptui.menu();
    }

    /**
     * @throws IOException
     * the user goal
     */
    public void meal() throws IOException, ClassNotFoundException {
        if(this.recipes.size() < 1){
            System.out.println("Unable to add meal: No recipes available\n");
            ptui.menu();
        }
        else {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter new meal name: ");
            String name = input.next();

            // Create new meal then store it in history
            Meal newMeal = new Meal(name);
            List<Recipe> myRecipes = new ArrayList<>();
            String decision;
            do {
                input = new Scanner(System.in);
                System.out.print("Add new recipe? (y/n): ");
                decision = input.next();
                if (decision.equalsIgnoreCase("Y")) {
                    //list all recipe names
                    for (int r = 0; r < recipes.size(); r++) {
                        // display recipe names
                        System.out.println(r + 1 + " " + recipes.get(r).getName());
                    }
                    int recipeChoice;
                    do {
                        //user selects number from meal displayed
                        // use as index but include -1
                        input = new Scanner(System.in);
                        System.out.print("Recipe number: ");
                        recipeChoice = input.nextInt();
                    }while(recipeChoice <0 || recipeChoice > recipes.size());
                    myRecipes.add(recipes.get(recipeChoice - 1));
                }
            } while (!decision.equalsIgnoreCase("n"));
            newMeal.setRecipes(myRecipes);
            meal = newMeal;
        }
        ptui.menu();
    }

    /**
     * @throws IOException
     * the user log out
     */
    public void recipe() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Name of the recipe: ");
        String name = input.next();

        List<Ingredient> myIngredients = new ArrayList<>();
        List<Ingredient> _ing = ingredients.getIngredients();
        // infinite loop asking for what ingredients
            // offer to view current ingredients
            // else show all possible ingredients
        boolean canExit = false;
        do {
            Scanner _input = new Scanner(System.in);
            System.out.println("1.) Add new ingredient ");
            System.out.println("2.) review ingredients ");
            System.out.println("3.) Exit ");
            System.out.print("choice: ");
            int choice = _input.nextInt();
            switch(choice){
                case 1:
                    // ask for index choice
                    _input = new Scanner(System.in);
                    System.out.print("Ingredient number: ");
                    choice = _input.nextInt();
                    myIngredients.add(_ing.get(choice-1));
                    break;
                case 2:
                    // Travers all possible ingredients
                    for(int i = 0; i < _ing.size(); i++){
                        String i_name = _ing.get(i).getName();
                        int index = i + 1;
                        System.out.println(index + " " + i_name);
                    }
                    break;
                case 3:
                    canExit = true;
                    break;
                default:
                    System.out.println("ERROR: unrecognized input");
            }
        }while(!canExit);

        // ask for instructions
        if(myIngredients.size() > 0) {
            System.out.print("Instructions for the new recipe: ");
            String instructions = input.next();

            // create new recipe
            Recipe newRecipe = new Recipe(name, instructions);
            newRecipe.setIngredients(myIngredients);
            recipes.add(newRecipe);
        }
        ptui.menu();
    }

    /**
     * @throws IOException
     * the user log out
     */
    public void logOut() throws IOException, ClassNotFoundException {
        System.out.println("\n\n");
        ptui.run();
    }

    /**
     * exit the application 
     */
    public void exit(){
        ptui.updateRunning();
    }

}
