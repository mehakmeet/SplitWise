package Sections;

import java.util.ArrayList;
import java.util.List;

public class Groups {

    public String name;
    public List<Friends> GroupMembers;

    public Groups(String name){
        this.name=name;
        GroupMembers = new ArrayList<Friends>();

    }

    public int getGroupAmount(){
        int total = 0;
        for(Friends groupMembers : GroupMembers)
        {
            total += groupMembers.amount;
        }

        return total;
    }
}
