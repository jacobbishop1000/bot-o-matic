import java.util.*;

public class main {
    //Some necessary data structures and variables for main method use
    public static LinkedList<Bot> bots = new LinkedList<>();
    public static String[] types = {"unipedal", "bipedal", "quadrupedal", "arachnid",
            "radial", "aeronautical"};
    static Scanner reader = new Scanner(System.in);  // Reading from System.in


    public static void main(String[] args) throws InterruptedException {
        //Welcome message
        System.out.println("Welcome to BOT-O-MAT!\n");
        bots.add(new Bot("testbot", "bipedal"));
        while (true){
            String choice;
            System.out.println("\nWhat would you like to do?\n" +
                    "(1) Create new bots\n" +
                    "(2) Watch bots complete tasks\n" +
                    "(3) Delete bots\n" +
                    "(q) Quit the program");
            choice = reader.next();

            //Now we take the user to the next menu screen

            //Choice 1: Create a new bot
            if(choice.equals("1")){
                String name;
                String type;
                System.out.println("Enter 'back' to go back\n");
                System.out.println("Please enter the bot name: ");
                name = reader.next();
                if(name.equals("back")){
                    continue;
                }else{
                    System.out.println("Enter 'back' to go back\n");
                    System.out.println("Please enter the bot type from the types below: ");
                    for (String typeOption: types) {
                        System.out.println(typeOption);
                    }
                    System.out.println();
                    type= reader.next();
                    if(type.equals("back")){
                        continue;
                    }else{
                        boolean optionMatches = false;
                        for (String typeOption: types) {
                            if(typeOption.equals(type)){
                                try{
                                    bots.add(new Bot(name, type));
                                    System.out.println("Bot created successfully");
                                    optionMatches=true;
                                }catch(Exception e){
                                    System.out.println("ERROR: Bot could not be created");
                                    optionMatches=true;
                                }
                            }
                        }
                        if(!optionMatches){
                            System.out.println("ERROR: Not a valid bot type");
                        }
                    }
                }


            }else if(choice.equals("2")){
                taskEvent();


            }else if(choice.equals("3")){
                System.out.println("Please enter the name of the bot you want to delete.\n" +
                        "List of bots:");
                for (Bot bot : bots) {
                    System.out.println(bot.getName());
                }
                choice=reader.next();
                for(Bot bot: bots){
                    if(choice.equals(bot.getName())){
                        bots.remove(bot);
                        System.out.println("Bot '"+bot.getName()+"' removed successfully");
                    }else{
                        System.out.println("ERROR: No bot was found with that name");
                    }
                }
            }else if(choice.equals("q")){
                reader.close();
                System.exit(0);
            }else{
                System.out.println("ERROR: Input invalid. Please enter a choice from the list:\n");
            }
        }


        }
    public static void taskEvent() throws InterruptedException {
        //Setup for tasks
        String[] taskDescriptions = {"Do the dishes", "Sweep the house", "Do the laundry",
                "Take out the recycling", "Make a sammich", "Mow the lawn", "Rake the leaves",
                "Give the dog a bath", "Bake some cookies", "Wash the car"};
        Integer[] taskTimes = {1000, 3000, 10000, 4000, 7000, 20000, 18000, 14500, 8000, 20000};

        String choice;
        System.out.println("Enter 'back' to go back\n");
        System.out.println("Please enter the name of the bot you want to do some tasks.\n" +
                "List of bots:");
        for (Bot bot : bots) {
            System.out.println(bot.getName());
        }
        choice = reader.next();

        if (choice.equals("back")) {
            //exit
        } else {
            for (Bot bot : bots) {
                if (choice.equals(bot.getName())) {
                    //Give the bot 5 random unique tasks
                    ArrayList<Integer> usedIndexes = new ArrayList<>(); //to keep track of what tasks are given so far
                    for (int i = 0; i < 5; i++) {
                        int index = (int) Math.floor(Math.random() * (10));

                        for (int dex : usedIndexes) {
                            if (index == dex) {
                                i--;
                            }
                        }
                        usedIndexes.add(index);
                        bot.giveTask(taskDescriptions[index], taskTimes[index]);
                    }
                    usedIndexes = new ArrayList<>(); //clear the arraylist now that we're finished with it
                    //Now the bot does the 5 random tasks
                    for (int i = 0; i < 5; i++) {
                        bot.completeTask();
                    }
                    System.out.println("\n");
                }
            }
            System.out.println("ERROR: no bot was found with that name");
        }
    }
}
