package command;

import java.io.IOException;

public class Menu {

    private Action exit;
    private Action goal;
    private Action history;
    private Action logIn;
    private Action logOut;
    private Action meal;
    private Action recipe;
    private Action workout;
    private Action userInfo;
    private Action create;
    private Action guest;
    private Action user;
    private Action previous;
    private String prev;

    public Menu (Action previous, Action user, Action guest, Action create, Action exit, Action goal, Action history,
                Action logIn, Action logOut, Action meal,
                Action recipe, Action workout, Action userInfo) {
        this.exit = exit;
        this.goal = goal;
        this.history = history;
        this.logIn = logIn;
        this.logOut = logOut;
        this.meal = meal;
        this.recipe = recipe;
        this.workout = workout;
        this.create = create;
        this.userInfo = userInfo;
        this.create = create;
        this.guest = guest;
        this.user = user;
        this.previous = previous;
    }

    public boolean invoke(String command) throws IOException, ClassNotFoundException {
        boolean valid = true;
        command = command.toLowerCase();
        if (command.equals("log in")) {
            logIn.performAction();
        }
        else if (command.equals("exit")) {
            exit.performAction();
        }
        else if (command.equals("workout")){
            workout.performAction();
        }
        else if(command.equals("history")) {
            history.performAction();
        }
        else if(command.equals("goal")) {
            goal.performAction();
        }
        else if(command.equals("meal")) {
            meal.performAction();
        }
        else if(command.equals("recipe")) {
            recipe.performAction();
        }
        else if(command.equals("log out")) {
            logOut.performAction();
        }
        else if(command.equals("create")){
            create.performAction();
        }
        else if(command.equals("user info")){
            userInfo.performAction();
        }
        else if(command.equals("guest")){
            guest.performAction();
        }
        else if(command.equals("user")){
            user.performAction();
        }
        else if(command.equals("previous")){
            previous.performAction();
        }
        else {
            valid = false;
        }
        prev = command;
        return valid;
    }

    public String getPrev(){
        return this.prev;
    }

}
