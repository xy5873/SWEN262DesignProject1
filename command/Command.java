package command;

import View.PTUI;
import database.Library;
import src.Ingredient;
import src.Meal;
import src.Recipe;
import search.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
 
    private PTUI ptui;
    private searchIngredients ingredients;
    private List<Recipe> recipes;

    /**
     * @param ptui: the plain text user interface
     * create the constrcutor
     */
    public Command(PTUI ptui){

        this.ptui = ptui;
        try {
            this.ingredients = new searchIngredients();
        } catch (Exception e) {
            System.out.println("ERROR: ingredient fault");
        }
    }

    /**
     * @throws IOException
     * the user log in and is recording in the txt file
     */
    public void logIn() throws IOException{
        Library lib = PTUI.library;
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        lib.add(name);
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Logged in as: " + name);
        ptui.display_menu();
        ptui.menu();
        exit();
        scanner.close();
    }

    /**
     * @throws IOException
     * the user workout
     */
    public void workout() throws IOException {
        System.out.println("workout text");
        exit();
    }

    /**
     * @throws IOException
     * the user history
     */
    public void history() throws IOException {
        System.out.println("history text");
        exit();
    }

    /**
     * @throws IOException
     * the user goal
     */
    public void goal() throws IOException {
        System.out.println("goal text");
        exit();
    }

    /**
     * @throws IOException
     * the user goal
     */
    public void meal() throws IOException{
        if(this.recipes.size() < 1){
            System.out.println("Unable to add meal: No recipes available");
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
                    //user selects number from meal displayed
                    // use as index but include -1
                    input = new Scanner(System.in);
                    System.out.print("Recipe number: ");
                    int recipeChoice = input.nextInt();
                    myRecipes.add(recipes.get(recipeChoice - 1));
                }
            } while (!decision.equalsIgnoreCase("n"));
            newMeal.setRecipes(myRecipes);
        }
        exit();
    }

    /**
     * @throws IOException
     * the user log out
     */
    public void recipe() throws IOException {
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
        System.out.print("Instructions for the new recipe: ");
        String instructions = input.next();

        // create new recipe
        Recipe newRecipe = new Recipe(name, instructions);
        newRecipe.setIngredients(myIngredients);
        recipes.add(newRecipe);
        ptui.run();
    }

    /**
     * @throws IOException
     * the user log out
     */
    public void logOut() throws IOException {
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
