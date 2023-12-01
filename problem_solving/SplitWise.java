import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

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

    static class Payable{
        int amount;
        String fromUsername;
        String toUsername;

        public Payable(int amount, String fromUsername, String toUsername){
            this.amount = amount;
            this.fromUsername = fromUsername;
            this.toUsername = toUsername;
        }

        @Override
        public String toString() {
            return fromUsername + " owes Rs." + amount + " to "  + toUsername;
        }
    }

    public static class Group{
        String name; 
        ArrayList<User> members;
        // ArrayList<Expense> expenses;
        HashMap<String, Integer> expenses = new HashMap<String, Integer>();
        // ArrayList<Payable> payables = new ArrayList<Payable>();
        private int[][] payables;
        boolean splitCalculated = false, expensesBuilt = false;


        public Group(String name){
            this.name = name;
            this.members = new ArrayList<User>();
        }

        public boolean addMember(String username, String name, int paid){
            if(findMember(username) != null){
                // throw new Exception("Member already added!");
                System.out.println("Member already exist!");
                return false;
            }

            User user = new User(username, name, paid);
            return members.add(user);
        }

        public boolean addExpense(int amount, String username){
            User u = findMember(username);
            if( u == null){
                System.out.println("User "+username+" is not in this group!");
                return false;
            }

            if(amount <= 0){
                System.out.println("Amounth should be greater than 0");
            }

            return (expenses.put(username, expenses.getOrDefault(username, 0) + amount) != null);
            // Expense expense = new Expense(amount, u);
            // return expenses.add(expense);
        }

        void buildExpenses(){
            // build expenses from group members
            if(!expensesBuilt){
                for(User member:members){
                    try{ expenses.put(member.username, member.paid);}
                    catch(Exception e){ System.out.println("Failed to add expense for: " + member.username + "of Rs" + member.paid);}
                }
            }
        }

        void calculatePayables(){
            Set<String> keys = expenses.keySet();
            // int totalExpense = 0;
            // for(int i=0; i<keys.size(); i++){
            //     totalExpense += expenses.get(keys.toArray()[i]);
            // }
            String[] users = getUsernames();
            int membersCount = members.size();
            int memberCount = keys.size();
            payables = new int[memberCount][membersCount];
            for(int i=0; i<memberCount; i++){
                for(int j=0; j<membersCount; j++){
                    if(i==j) payables[i][j] = 0;
                    else{
                        // payables[i][j] = payables[j][i] = (int)Math.ceil((double)expenses.get(users[i])/(double)totalExpense * (double)membersCount); // This wrong calculation was suggested by tab9 intelligence/github copilot
                        payables[i][j] = (int)Math.ceil((expenses.get(users[j]) - expenses.get(users[i]))/memberCount);
                    }
                }
            }
            splitCalculated = true;
        }

        String[] getUsernames(){
            // return members.stream().map(member -> member.username).collect(Collectors.collectingAndThen(Collectors.toList(),Array<String>));
            return members.stream().map(member -> member.username).toArray(String[] ::new);
        }

        public int[][] getPayables(){
            if(!splitCalculated) calculatePayables();
            return payables;
        }

        void printPayables(){
            getPayables();
            String[] usernames = getUsernames();
            for(int i=0; i<payables.length; i++){
                System.out.print(usernames[i] + "\t");
                // for(int j=0; j<payables.length; j++){
                //     System.out.print(payables[i][j]+ " ");
                // }
                System.out.println(payables[i]);
                System.out.println();
            }
        }

        public User findMember(String username){
            // int index = -1;
            // System.out.println("target: "+username);
            for(int i=0; i<members.size(); i++){
                // System.out.println(members.get(i));
                if(members.get(i).username.equals(username)) return members.get(i);
            }
            return null;
        }
        

        public boolean removeMember(String username){
            User u = findMember(username);
            return members.remove(u);
        }


    }

    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Enter group name:");
        // String groupName = scan.nextLine();

        Group grp = new Group("Test");

        // for(int i=0; i<5; i++){
        //     int amt = 0;
        //     if(i%2 == 0) amt = 100 + 100*i;
        //     System.out.println(grp.addMember("username"+i, "name"+i, amt));
        // }
        // System.out.println(grp.addMember("username0", "name7", 500));
        System.out.println(grp.addMember("DB", "Rahul", 550));
        System.out.println(grp.addMember("Ambakki", "Chetan", 1500));
        System.out.println(grp.addMember("Kitta", "Krishna", 1370));
        System.out.println(grp.addMember("putta", "Puttaraj", 0));

        grp.printPayables();
        // System.out.println(grp.findMember("username5"));

        // br.close();
        // scan.close();
    }
}