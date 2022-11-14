package command;

import View.PTUI;
import data.CSV;
import data.IngredientStorage;
import database.Library;
import src.Date;
import src.Goal;
import src.History;
import src.Ingredient;
import src.Meal;
import src.Recipe;
import src.User;
import src.WorkOut;
import src.Ingredient.ingredient;
import search.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {

    private PTUI ptui;
    private IngredientStorage ingredients;
    private List<Recipe> recipes;
    private List<History> workoutHistory = new ArrayList<History>();;
    private Meal meal = new Meal("No meal");
    // private Goal goal = new Goal(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /**
     * @param ptui: the plain text user interface
     *              create the constrcutor
     */
    public Command(PTUI ptui) {
        this.ptui = ptui;
        this.recipes = new ArrayList<>();
        this.ingredients = new IngredientStorage();
        try {
            CSV inputData = new CSV();
            for (String[] data : inputData.ImportData("ingredients.csv")) {
                Ingredient ingr = new Ingredient(data);
                this.ingredients.add(ingr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create() throws IOException, ClassNotFoundException {
        boolean cont = false;
        Library lib = PTUI.library;
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        String password = "";
        String name = "";
        int height = 0;
        int weight = 0;
        int day = 0;
        int month = 0;
        int year = 0;
        while (!cont) {
            System.out.println("Enter username: ");
            userName = scanner.nextLine();
            if (userName.length() > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a name");
                System.out.println("Please enter a username");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            if (password.length() > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a password");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter name: ");
            name = scanner.nextLine();
            if (name.length() > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a name");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter height (in inches): ");
            height = scanner.nextInt();
            if (height > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a positive number");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter weight (in pounds): ");
            weight = scanner.nextInt();
            if (weight > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a positive number");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter birth month: ");
            month = scanner.nextInt();
            if (month > 0 && month <= 12) {
                cont = true;
            } else {
                System.out.println("Please enter a number between 1 and 12");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter birth day: ");
            day = scanner.nextInt();
            if (day > 0 && day <= 31) {
                cont = true;
            } else {
                System.out.println("Please enter a number between 1 and 31");
                cont = false;
            }
        }
        cont = false;
        while (!cont) {
            System.out.println("Enter birth year: ");
            year = scanner.nextInt();
            if (year > 1930 && year < 2022) {
                cont = true;
            } else {
                System.out.println("Please enter a valid year");
                cont = false;
            }
        }

        LocalDate birthDay = LocalDate.of(year, month, day);

        User user = new User(userName, password, name, height, weight, birthDay);
        //user.setPassword(password);
        lib.addUser(user);
        ptui.currentUser = user;

        // if(!ptui.user.containsKey(name)){
        // ptui.user.put(name, password);
        // }
        // else{
        // System.err.println("The account have already existed, try to use different
        // username.");
        // ptui.menu();
        // }

        // System.out.println("Enter password: ");
        // String password = scanner.nextLine();
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Logged in as: " + userName);
        ptui.menu();
        scanner.close();
    }

    /**
     * @throws IOException
     *                     the user log in and is recording in the txt file
     */
    public void logIn() throws IOException, ClassNotFoundException {
        String line = "";
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();


        BufferedReader br = new BufferedReader(new FileReader("model/users.csv"));


        if(br.read() != -1) {

            br = new BufferedReader(new FileReader("model/users.csv"));
            while ((line = br.readLine()) != null) {
                String[] user = line.split(",");
                
                boolean userBool = true;
                int passwordCount = 0;
                
                while (userBool) {
                    if(user[0].equals(username)) {
                        System.out.println("Enter password:");
                        String password = scanner.nextLine();
                        boolean passBool = true;

                        while (passBool) {
                            if (user[1].equals(password)) {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate date = LocalDate.parse(user[5], formatter);
                                User newUser = new User(user[0], user[1], user[2], Integer.parseInt(user[3]), Integer.parseInt(user[4]), date);


                                passwordCount = 0;
                                System.out.println("\n-----------------------------------------------------------");
                                System.out.println("Logged in as: " + username);
                                ptui.currentUser = newUser;
                                ptui.menu();
                                exit();
                                scanner.close();
                                passBool = false;
                                userBool = false;
                            } else {
                                System.out.println("Password incorrect, try again (" + (++passwordCount) + "/3 attempts)");
                                if (passwordCount == 3) {
                                    System.out.println("\nToo many attempts. Try again later\n");
                                    passwordCount = 0;
                                    passBool = false;
                                    userBool = false;
                                    ptui.run();
                                } else {
                                    password = scanner.nextLine();
                                }
                            }
                        }
                        userBool = false;
                    } else {
                        userBool = false;
                    }
                }

                    
            }  
            System.out.println("\nUser does not exist\n");
            ptui.run();
        }  
        else {
            System.out.println("\nThere are no users available\n");
            ptui.run();
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
     *                     the user workout
     */
    public void workout() throws IOException, ClassNotFoundException {

        boolean complete = false;
        boolean invalid = true;
        WorkOut.Intensity intensity = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nhow long? (minutes): ");
        int duration = scanner.nextInt();
        while (!complete) {
            while (invalid) {
                System.out.println("\n1 -- high intensity");
                System.out.println("2 -- medium intensity");
                System.out.println("3 -- low intensity");
                System.out.print("Which intensity? (#): ");
                int intense = scanner.nextInt();

                if (intense == 1) {
                    intensity = WorkOut.Intensity.high;
                    invalid = false;
                } else if (intense == 2) {
                    intensity = WorkOut.Intensity.medium;
                    invalid = false;
                } else if (intense == 3) {
                    intensity = WorkOut.Intensity.low;
                    invalid = false;
                } else {
                    System.out.println("That is not a valid intensity choice");
                }
            }

            WorkOut workout = new WorkOut(duration, intensity, java.time.LocalDate.now());
            double totalCalories = workout.getCalories();

            Scanner input = new Scanner(System.in);
            System.out.print("Did you complete your workout? (y/n): ");
            String str = input.nextLine();
            if (str.equals("y")) {
                System.out.println("\n" + workout.toString() + "\n");
                if (ptui.currentUser.getCurrentGoal() != null) {
                    if (totalCalories >= ptui.currentUser.getCurrentGoal().getCalorieGoal()) {
                        System.out.println("You reached your calorie goal!");
                    } else {
                        System.out.println("You did not reach your calorie goal");
                    }
                } else {
                    System.out.println("If you want a goal, set it up in the menu");
                }

                // History history = new History(goal.getWeightGoal(), goal.getCalorieGoal(),
                // meal, workout);
                // workoutHistory.add(history);
                ptui.menu();
                complete = true;
            }
        }
        scanner.close();
        exit();
    }

    /**
     * @throws IOException
     *                     the user history
     */
    public void history() throws IOException, ClassNotFoundException {
        if (workoutHistory.size() != 0) {
            System.out.println("\nHistory:");
            for (History history : workoutHistory) {
                for (WorkOut workout : history.getWorkOut()) {
                    System.out.println("Workout - " + workout);
                }
                for (Meal meal : history.getMeal()) {
                    System.out.println("Meal - " + meal);
                }
                System.out.println();
            }
            ptui.menu();
        } else {
            System.out.println("\nNo previous workouts.\n");
            ptui.menu();
        }

    }

    /**
     * @throws IOException
     *                     the user goal
     */
    // public void goal() throws IOException {
    // boolean cont = false;
    // boolean improve = false;
    // int weightGoal = 0;
    public void goal() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        boolean cont = false;
        boolean improve = false;
        int weightGoal = 0;
        while (!cont) {
            System.out.print("\nWhat is your weight goal?: ");
            weightGoal = input.nextInt();
            if (weightGoal > 0) {
                cont = true;
            } else {
                System.out.println("Please enter a postitive number");
            }
        }
        cont = false;
        while (!cont) {
            input = new Scanner(System.in);
            System.out.print("Would you like to improve your physical fitness (y/n)?: ");
            String inputString = input.nextLine();
            if (inputString.equals("y")) {
                improve = true;
                cont = true;
            } else if (inputString.equals("n")) {
                improve = false;
                cont = true;
            } else {
                System.out.println("Please enter y or n");
                cont = false;
            }
        }
        // System.out.print("How many calories a workout do you want to burn?: ");
        // int calorieGoal = input.nextInt();

        Goal goal = new Goal(weightGoal, improve);

        ptui.currentUser.setCurrentGoal(goal);

        ptui.currentUser.getCurrentGoal().updateGoal(ptui.currentUser.getWeight());

        ptui.menu();
    }

    /**
     * @throws IOException
     *                     the user goal
     */
    public void meal() throws IOException, ClassNotFoundException {
        if (this.recipes.size() < 1) {
            System.out.println("Unable to add meal: No recipes available\n");
            ptui.menu();
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter new meal name: ");
            String name = input.next();

            // Create new meal then store it in history
            Meal newMeal = new Meal(name);
            String decision;
            do {
                input = new Scanner(System.in);
                System.out.print("Add new recipe? (y/n): ");
                decision = input.next();
                if (decision.equalsIgnoreCase("Y")) {
                    // list all recipe names
                    for (int r = 0; r < recipes.size(); r++) {
                        // display recipe names
                        System.out.println(r + 1 + " " + recipes.get(r).getName());
                    }
                    int recipeChoice;
                    do {
                        // user selects number from meal displayed
                        // use as index but include -1
                        input = new Scanner(System.in);
                        System.out.print("Recipe number: ");
                        recipeChoice = input.nextInt();
                    } while (recipeChoice < 0 || recipeChoice > recipes.size());
                    newMeal.addRecipe(recipes.get(recipeChoice - 1));
                }
            } while (!decision.equalsIgnoreCase("n"));
            meal = newMeal;
        }
        ptui.menu();
    }

    /**
     * @throws IOException
     *                     the user log out
     */
    public void recipe() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Name of the recipe: ");
        String name = input.next();

        List<Ingredient> myIngredients = new ArrayList<>();
        List<Ingredient> _ing = ingredients.getAll();
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
            switch (choice) {
                case 1:
                    // ask for index choice
                    _input = new Scanner(System.in);
                    System.out.print("Ingredient number: ");
                    choice = _input.nextInt();
                    myIngredients.add(_ing.get(choice - 1));
                    break;
                case 2:
                    // Travers all possible ingredients
                    for (int i = 0; i < _ing.size(); i++) {
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
        } while (!canExit);

        // ask for instructions
        if (myIngredients.size() > 0) {
            System.out.print("Instructions for the new recipe: ");
            String instructions = input.next();

            // create new recipe
            Recipe newRecipe = new Recipe(name, instructions);
            for (Ingredient ingredient : myIngredients) {
                newRecipe.addIngredient(ingredient, 1);
            }
            recipes.add(newRecipe);
        }
        ptui.menu();
    }

    /**
     * @throws IOException
     *                     the user log out
     */
    public void logOut() throws IOException, ClassNotFoundException {
        System.out.println("\n\n");
        ptui.currentUser = null;
        ptui.run();
    }

    /**
     * exit the application
     */
    public void exit() {
        ptui.updateRunning();
    }

    public void userInfo() throws IOException, ClassNotFoundException {
        System.out.println("Current user stats -");
        System.out.println("Name - " + ptui.currentUser.getName());
        System.out.println("Height - " + ptui.currentUser.getHeight());
        System.out.println("Weight - " + ptui.currentUser.getWeight());
        System.out.println("Birthdate - " + ptui.currentUser.getBirthDate());
        System.out.println("Current Goal - " + ptui.currentUser.getCurrentGoal());
    }

    public void NewDay() throws ClassNotFoundException, IOException {
        boolean cont = false;
        int newWeight = 0;
        Scanner input = new Scanner(System.in);
        while (!cont) {
            System.out.println("Enter current weight: ");
            newWeight = input.nextInt();
            if (newWeight > 0) {
                ptui.currentUser.setWeight(newWeight);
                cont = true;
            } else {
                cont = false;
            }
        }
        if (ptui.currentUser.getCurrentGoal() != null) {
            ptui.currentUser.getCurrentGoal().updateGoal(newWeight);
        }
        ptui.menu();
    }

     /**
     * create a new password for the user
     */
    public void changePassword() throws IOException, ClassNotFoundException {
        Library lib = PTUI.library;
        String line = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new password:");
        String newPassword = input.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("model/users.csv"));
        while ((line = br.readLine()) != null)   //returns a Boolean value  
        {
            String[] user = line.split(",");    // use comma as separator  
            if(user[0].equals(ptui.currentUser.getUsername())) {
                User oldUserInfo = ptui.currentUser;
                lib.updateUser(oldUserInfo, newPassword);
                ptui.currentUser.setPassword(newPassword);
                System.out.println("\npassword changed successfully!\n");
                break;
            }  
        }
        ptui.menu();
    }

    /*
     * 
     */
    public void browse(){
        // need to implement the stock of ingredients.
        for(int i = 0; i < ingredients.getAll().size(); i++){
            System.out.println("Stock of Meals: " + ingredients.getAll().get(i) + ingredients.getAll().get(i).getStock());
        }
        System.out.println("Stock of Meals: 0, becasue guest can not create meals.");
        System.out.println("Stock of Recipes: 0, becasue guest can not create recipes.");
    }

    /*
     * 
     */
    public void previous(){
        if(ptui.menu.getPrev().equals("guest") || ptui.menu.getPrev().equals("user")){
            ptui.display_main();
        }
        else if(ptui.menu.getPrev().equals("log in") || ptui.menu.getPrev().equals("create")){
            ptui.display();
        }
    }

    /*
     * 
     */
    public void guestMode(){
        ptui.display_guest();
    }

    /*
     * 
     */
    public void userMode(){
        ptui.display();
    }

}
