package command;

public class Browse implements Action{
    
    private Command command;

    public Browse(Command command){
        this.command = command;
    }

    @Override
    public void performAction(){
        command.browse();
    }

}
