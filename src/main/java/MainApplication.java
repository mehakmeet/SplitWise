import Sections.Friends;
import Sections.Groups;
import UI.FriendUI;
import UI.GroupUI;
import UI.MenuUI;

import java.util.Scanner;

public class MainApplication {

    public static void main(String args[])
    {

        User user = new User();

        MenuUI menuUI = new MenuUI();

        Scanner scn = new Scanner(System.in);
        int choice = 0;
        do
        {
            System.out.println(menuUI.WelcomeScreen());

            String Prefix = (user.TotalBalance < 0) ? "You owe " : "You take ";
            System.out.println(Prefix + " INR " + Math.abs(user.TotalBalance));
            choice = scn.nextInt();

            switch(choice){

                //FRIEND SECTION
                case 1: {

                    System.out.println(new FriendUI().FriendFeature());

                    int choice2 = scn.nextInt();

                                    switch (choice2) {

                                        case 1: {

                                            System.out.println("Enter the name and Amount of the person");
                                            String nameOfFriend = scn.next();
                                            scn.nextLine();
                                            int amountPayable = scn.nextInt();

                                            Friends friends = new Friends(nameOfFriend, amountPayable);
                                            user.MyFriends.add(friends);
                                            System.out.println("Friend Successfully Created....");
                                            user.TotalBalance += amountPayable;

                                            break;
                                        }

                                        case 2: {

                                            System.out.println("Enter the name of Friend to remove");
                                            String nameOfFriend = scn.next();
                                            int flag = 0;
                                            for (int friendPos = 0; friendPos < user.MyFriends.size() ; friendPos++) {

                                                if (user.MyFriends.get(friendPos).name.equals(nameOfFriend)) {
                                                    flag = 1;
                                                    user.TotalBalance -= user.MyFriends.get(friendPos).amount;
                                                    user.MyFriends.remove(friendPos);
                                                    System.out.println("Successfully Removed....");
                                                    break;
                                                }

                                            }
                                            if(flag == 0) System.out.println("Friend does not exist");

                                            break;

                                        }

                                        case 3: {

                                            System.out.println("Enter the amount to add and name of Friend");
                                            int amountToAdd = scn.nextInt();
                                            String nameOfFriend = scn.next();

                                            System.out.println(nameOfFriend);
                                            int flag = 0;
                                            int frienPos=0;

                                            System.out.println(user.MyFriends.size());

                                           for(Friends frnds : user.MyFriends) {

                                                if (frnds.name!= null && frnds.name.equals(nameOfFriend)) {
                                                    flag = 1;
                                                    user.MyFriends.get(frienPos).amount += amountToAdd;
                                                    user.TotalBalance += amountToAdd;
                                                    System.out.println("Successfully Added.....");
                                                    break;
                                                }
                                                frienPos++;


                                            }

                                            if (flag == 0) System.out.println("Friend not Found");

                                            break;
                                        }

                                        default: {

                                        }

                                    }
                                    break;
                }


                //GROUP SECTION
                case 2: {

                            System.out.println(new GroupUI().GroupFeatures());

                            int choice3 = scn.nextInt();
                            switch (choice3) {

                                case 1: {
                                    System.out.println("Enter the group name");
                                    String nameOfGroup = scn.next();
                                    Groups groups = new Groups(nameOfGroup);

                                    System.out.println("Enter number of Group Members");
                                    int numberOfGroupMembers = scn.nextInt();
                                    for (int i = 0; i < numberOfGroupMembers; i++) {
                                        System.out.println("Enter Name of Friend");
                                        String friendName = scn.next();
                                        Friends friends = new Friends(friendName, 0);
                                        groups.GroupMembers.add(friends);
                                    }
                                    user.MyGroups.add(groups);

                                    break;

                                }

                                case 2: {
                                    System.out.println("Enter the Group name");
                                    String nameOfGroup = scn.next();
                                    int flag = 0;

                                    for (int groupPos = 0; groupPos < user.MyGroups.size(); groupPos++) {
                                        Groups GroupVal = user.MyGroups.get(groupPos);
                                        if (GroupVal.name.equals(nameOfGroup)) {
                                            flag = 1;
                                            System.out.println("Enter the amount of the Bill");

                                            int billAmount = scn.nextInt();

                                            user.TotalBalance += billAmount;

                                            System.out.println("Enter Amount to be paid by Each member:");
                                            for (int friendPos = 0; friendPos < GroupVal.GroupMembers.size(); friendPos++) {
                                                System.out.println("Enter Amount of " + GroupVal.GroupMembers.get(friendPos).name);

                                                int friendAmount = 0;
                                                do {

                                                    System.out.println("Enter Amount greater than 0 or less than equal to " + billAmount);
                                                    friendAmount = scn.nextInt();

                                                } while (friendAmount < 0 || friendAmount > billAmount);

                                                billAmount -= friendAmount;

                                                user.MyGroups.get(groupPos).GroupMembers.get(friendPos).amount += friendAmount;

                                            }
                                            break;
                                        }
                                    }

                                    if (flag == 0) System.out.println("No such group is created");


                                    break;

                                }

                                case 3: {

                                    System.out.println("Enter the Group Name");
                                    String nameOfGroup = scn.nextLine();
                                    int flag1 = 0;

                                    for (int groupPos = 0; groupPos < user.MyGroups.size(); groupPos++) {
                                        if (user.MyGroups.get(groupPos).equals(nameOfGroup)) {
                                            System.out.println("Enter the name of group Member to remove");
                                            String friendName = scn.nextLine();
                                            int flag2 = 0;

                                            for (int friendPos = 0; friendPos < user.MyGroups.get(groupPos).GroupMembers.size(); friendPos++) {
                                                if (user.MyGroups.get(groupPos).GroupMembers.get(friendPos).name.equals(friendName)) {

                                                    user.MyGroups.get(groupPos).GroupMembers.remove(friendPos);
                                                    System.out.println("Group Member Successfully Removed.....");
                                                    flag2 = 1;
                                                    break;
                                                }
                                            }
                                            if (flag2 == 1) break;
                                        }
                                    }

                                    if (flag1 == 0) System.out.println("Either Group Name or Friend Name does not exist... ");

                                    break;

                                }


                                case 4: {
                                    System.out.println("Enter the name of the Group ");
                                    String nameOfTheGroup = scn.nextLine();
                                    int flag = 0;
                                    for (Groups myGroups : user.MyGroups) {
                                        if (myGroups.name.equals(nameOfTheGroup)) {
                                            flag = 1;

                                            String Prefix2 = (myGroups.getGroupAmount() < 0) ? "You owe " : "You take ";

                                            System.out.println(Prefix2 + " Total Group Amount is: " + Math.abs(myGroups.getGroupAmount()));
                                            break;
                                        }
                                    }
                                    if (flag == 0) System.out.println("No Group exists with this name...");

                                    break;

                                }

                                default: {

                                }
                            }
                }

                case 3: {

                }
                default: {

                }

            }


        }while(choice>=1 && choice<=3);

    }
}
