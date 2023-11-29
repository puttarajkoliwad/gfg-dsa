// import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SplitWise{
    public static class Expense{
        int amount=0;
        User payer;
        String desc = "";

        public Expense(int amount, User payer){
            this.amount = amount;
            this.payer = payer;
        }

        public Expense(int amount, User payer, String desc){
            this(amount, payer);
            this.desc = desc;
        }
    }

    public static class User implements Comparable<User>{
        static int count;
        int id;
        String name;
        String username;
        int paid;

        public User(String username, String name, int paid){
            this.id = count++;
            this.username = username;
            this.name = name;
            this.paid = paid;
        }

        public int compareTo(User o){
            return this.username.compareTo(o.username);
        }

        public String toString(){
            return this.username + ", " + this.name + ", " + this.paid;
        }
    }

    public static class Group{
        String name; 
        ArrayList<User> members;
        ArrayList<Expense> expenses;

        public Group(String name){
            this.name = name;
            this.members = new ArrayList<User>();
        }

        public boolean addMember(String username, String name, int paid){
            if(members.contains(username)){
                // throw new Exception("Member already added!");
                System.out.println("Member already exist!");
                return false;
            }

            User user = new User(username, name, paid);
            return members.add(user);
        }

        public boolean addExpense(int amount, String username){
            User u = findMember(username);
            Expense expense = new Expense(amount, u);
            return expenses.add(expense);
        }

        public User findMember(String username){
            // int index = -1;
            System.out.println("target: "+username);
            for(int i=0; i<members.size(); i++){
                System.out.println(members.get(i));
                if(members.get(i).username.equals(username)) return members.get(i);
            }
            return null;
        }
        

        public boolean removeMember(String username){
            return members.remove(username);
        }
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Enter group name:");
        // String groupName = scan.nextLine();

        Group grp = new Group("Test");

        for(int i=0; i<5; i++){
            int amt = 0;
            if(i%2 == 0) amt = 100 + 100*i;
            System.out.println(grp.addMember("username"+i, "name"+i, amt));
        }
        
        System.out.println(grp.findMember("username4"));

        br.close();
        scan.close();
    }
}