import java.util.Arrays;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args){

        Scanner SCANNER = new Scanner(System.in);

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to Start Banking";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSIT_MONEY = "Deposit";
        final String WITHDRAW_MONEY = "Withdrawal";
        final String TRANSFER_MONEY = "Transfer";
        final String CHECK_BALANCE  = "Check Balance";
        final String DELETE_STATE = "Delete Statement";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String screen = DASHBOARD;

        String[] userIds = new String[0];
        String[] userNames = new String[0];
        Double[] userBalance = new Double[0];

        mainLoop:

        do{

            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){

                case DASHBOARD: 

                    System.out.println("\t[1]. Create New Account");
                    System.out.println("\t[2]. Deposit");
                    System.out.println("\t[3]. Withdrawal");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Check Balance)");
                    System.out.println("\t[6]. Delete Statement");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = CREATE_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANSFER_MONEY; break;
                        case 5: screen = CHECK_BALANCE; break;
                        case 6: screen = DELETE_STATE; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;

                    case CREATE_ACCOUNT:

                       
                        String name;
                        boolean isValidName;

                        
                        System.out.printf("ID: SDB-%05d \n",(userIds.length +1));
                                                
                        String id = String.format("SDB-%05d", (userIds.length+1));
                        

                        // NAME Validation

                        do{

                            isValidName = true;
                            System.out.print("Enter User Name : ");
                            name = SCANNER.nextLine();

                            if(name.isBlank()){
                                System.out.printf(ERROR_MSG, "Username name can't be empty");
                                isValidName = false;
                                continue;

                            }
                            for (int i = 0; i < name.length(); i++) {
                                if (!(Character.isLetter(name.charAt(i)) || 
                                    Character.isSpaceChar(name.charAt(i))) ) {
                                    System.out.printf(ERROR_MSG, "Invalid name");
                                    isValidName = false;
                                    break;
                                }
                            }


                        }while(!isValidName);

                        //Initial Deposit Validation

                        boolean isValidDepo;
                        double intDepo = 0;

                        do{

                            isValidDepo = true;

                            System.out.print("Initial Deposit : ");
                            String strDepo = SCANNER.nextLine();
                            
                            if(strDepo.isBlank()){
                                System.out.printf(ERROR_MSG, "Please enter an Initial amount");
                                isValidDepo = false;
                                continue;
                            }
                            intDepo = Double.parseDouble(strDepo);

                            if(intDepo < 5000){
                                System.out.printf(ERROR_MSG, "Insufficient Initial Deposit");
                                isValidDepo = false;
                                continue;
                            }

                        }while(!isValidDepo);

                        String[] newUserIds = new String[userIds.length + 1];
                        String[] newUserNames = new String[userNames.length + 1];
                        Double[] newUserBalance = new Double[userIds.length + 1];
                        for (int i = 0; i < userIds.length; i++) {
                            newUserIds[i] = userIds[i];
                            newUserNames[i] = userNames[i];
                            newUserBalance[i] = userBalance[i];
                        }

                        newUserIds[newUserIds.length - 1] = id;
                        newUserNames[newUserNames.length - 1] = name;
                        newUserBalance[newUserBalance.length-1 ]= intDepo;
                        userIds = newUserIds;
                        userNames = newUserNames;
                        userBalance = newUserBalance;

                        System.out.println(Arrays.toString(userNames));
                        System.out.println(Arrays.toString(userIds));
                         System.out.println(Arrays.toString(userBalance));
                        

                        System.out.printf("\t%s%s%s%s%s%s%s",COLOR_GREEN_BOLD,"ID: ", id, " |Name : ", name, " account created succefully \n",RESET);
                        System.out.print("Do you want to continue (Y/N) ? ");
                        if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                        screen = DASHBOARD;
                        break;


                        








            }








        }while(true);



    }

}