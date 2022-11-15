package Mediator;

import java.util.ArrayList;
import java.util.List;

import src.User;

public class Team implements TeamMediator{
    
    private String name;
    private List<User> members;

    public Team(String name){
        this.name = name;
        members = new ArrayList<>();
    }

    @Override
    public void addUser(User user){
        members.add(user);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the members
     */
    public List<User> getMembers() {
        return members;
    }

}
