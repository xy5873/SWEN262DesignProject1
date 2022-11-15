package command;


public class Form implements Action{

    private Command command;

    public Form(Command command){
        this.command = command;
    }
    

    @Override
    public void performAction() {
        command.form();
    }

}
