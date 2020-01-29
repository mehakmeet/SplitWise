import Sections.Friends;
import Sections.Groups;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Friends> MyFriends;
    public List<Groups> MyGroups;
    public List<String> Transactions;
    public int TotalBalance;

    public User()
    {
        MyFriends = new ArrayList<Friends>();
        MyGroups = new ArrayList<Groups>();
        Transactions = new ArrayList<String>();
        TotalBalance = 0;
    }
}
