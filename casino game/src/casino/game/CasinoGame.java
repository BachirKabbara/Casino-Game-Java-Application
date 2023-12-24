package casino.game;

import java.util.Scanner;

public class CasinoGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int balance = 0, nb, k = 3;
        char choice, choice2;
        String username, password, enteredpass;
        System.out.println("Welcome to the GAME CENTER !!! ");//WELCOME MESSAGE
        System.out.println();
        System.out.print("Enter Username: ");
        username = scan.next();
        while (true) {
            System.out.print("Set Password: ");
            password = scan.next();
            if (checkpassword(password)) {
                break;
            } else {
                System.out.println("\npassword should contain:\nAt least 8 characters\nA mixture of both uppercase and lowercase letters.\n" + "A mixture of letters and numbers.\n" + "Inclusion of at least one special character, e.g., ! @ # ? ]\n");
            }
        }
        System.out.println();
        while (true) {
            System.out.println(username + "'s " + "Balance is " + balance + "$");//MAIN MENU
            System.out.println();
            System.out.println("B-Balance");
            System.out.println("P-Play");
            System.out.println("I-Info");
            System.out.println("E-Exit");
            System.out.println("----------");
            choice = scan.next().charAt(0);
            OUTER:
            switch (choice) {
                case 'b':
                case 'B':
                    System.out.print("Enter Password: ");
                    enteredpass = scan.next();
                    while (!enteredpass.equals(password)) {
                        System.out.print("Enter Password: ");
                        enteredpass = scan.next();
                        if (k > 0) {
                            System.out.println("wrong pass, attempts left (" + k-- + ") !");
                        } else {
                            break OUTER;
                        }
                    }

                    while (true) {
                        System.out.println(username + "'s " + "Balance is " + balance + "$");//BALANCE MENU
                        System.out.println();
                        System.out.println("D-Deposit");
                        System.out.println("W-Withdraw");
                        System.out.println("*-Go Back");
                        System.out.println("------------");
                        choice2 = scan.next().charAt(0);
                        switch (choice2) {
                            case 'w':
                            case 'W':
                                System.out.print("Enter the amount you want to withdraw: ");
                                nb = scan.nextInt();
                                if (nb > balance) {
                                    System.out.println("you cannot withdraw more then what it avalable\n");
                                }
                                if (nb < 0) {
                                    System.out.println("you cant withdraw negative numbers\n");
                                } else {
                                    balance -= nb;
                                }
                                break;
                            case 'D':
                            case 'd':
                                System.out.print("enter the amout you want to deposit: ");
                                nb = scan.nextInt();
                                if (nb >= 0) {
                                    balance += nb;
                                } else {
                                    System.out.println("you cannot add negative balance\n");
                                }
                                break;
                            case '*':
                                break OUTER;
                            default:
                                System.out.println("wrong choice format please try again\n");
                                break;
                        }
                    }
                case 'p':
                case 'P':
                    while (true) {
                        System.out.println(username + "'s " + "Balance is " + balance + "$");
                        System.out.println();
                        System.out.println("R-Rock,paper,scissors (200$)");
                        System.out.println("L-Lottery (500$)");
                        System.out.println("*-Go Back");
                        System.out.println("-------------------------");
                        choice2 = scan.next().charAt(0);
                        switch (choice2) {
                            case 'R':
                            case 'r':
                                if (balance >= 200) {
                                    char rps;
                                    int botchoice, converted, scoreplayer = 0, scorebot = 0;
                                    System.out.println("Rock Paper scissors !!!(best out of 3)");
                                    for (int i = 1; i <= 3; i++) {
                                        System.out.println("R-Rock");
                                        System.out.println("P-Paper");
                                        System.out.println("S-scissors");
                                        while (true) {
                                            rps = scan.next().charAt(0);

                                            switch (rps) {
                                                case 'R':
                                                case 'r':
                                                    converted = 1;
                                                    botchoice = (int) (Math.random() * 3 + 1);
                                                    if (botchoice == 1) {
                                                        System.out.println("the bot picked rock\n");
                                                    } else if (botchoice == 2) {
                                                        System.out.println("the bot picked paper\n");
                                                    } else {
                                                        System.out.println("the bot picked scissors\n");
                                                    }
                                                    break;
                                                case 'P':
                                                case 'p':
                                                    converted = 2;
                                                    botchoice = (int) (Math.random() * 3 + 1);
                                                    switch (botchoice) {
                                                        case 1:
                                                            System.out.println("the bot picked rock\n");
                                                            break;
                                                        case 2:
                                                            System.out.println("the bot picked paper\n");
                                                            break;
                                                        default:
                                                            System.out.println("the bot picked scissors\n");
                                                            break;
                                                    }
                                                    break;

                                                case 'S':
                                                case 's':
                                                    converted = 3;
                                                    botchoice = (int) (Math.random() * 3 + 1);
                                                    switch (botchoice) {
                                                        case 1:
                                                            System.out.println("the bot picked rock\n");
                                                            break;
                                                        case 2:
                                                            System.out.println("the bot picked paper\n");
                                                            break;
                                                        default:
                                                            System.out.println("the bot picked scissors\n");
                                                            break;
                                                    }
                                                    break;

                                                default:
                                                    System.out.println("wrong format....\n");
                                                    converted = 0;
                                                    botchoice = 0;
                                                    break;
                                            }

                                            if (converted == botchoice) {
                                                System.out.println("lets repeat the round\n");
                                            } else if ((converted == 1 && botchoice == 3) || (converted == 2 && botchoice == 1) || (converted == 3 && botchoice == 2)) {
                                                scoreplayer += 1;
                                                break;
                                            } else if ((converted == 1 && botchoice == 2) || (converted == 2 && botchoice == 3) || (converted == 3 && botchoice == 1)) {
                                                scorebot += 1;
                                                break;
                                            }

                                        }
                                    }
                                    System.out.println("The bot won " + scorebot + " rounds");
                                    System.out.println("The you won " + scoreplayer + " rounds\n");
                                    if (scorebot > scoreplayer) {
                                        System.out.println("you lost (-200$)\n");
                                        balance -= 200;
                                    } else {
                                        System.out.println("You won!!! (+100$)\n");
                                        balance += 100;
                                    }
                                } else {
                                    System.out.println("insufficient balance :(\n");
                                }
                                break;
                            case 'L':
                            case 'l':
                                if (balance >= 500) {
                                    int lotnb1, lotnb2, lotnb3, playernb1, playernb2, playernb3;
                                    String playernb;
                                    while (true) {
                                        while (true) {
                                            lotnb1 = (int) ((Math.random() * 100));
                                            if (lotnb1 >= 48 && lotnb1 <= 57) {
                                                break;
                                            }
                                        }
                                        while (true) {
                                            lotnb2 = (int) ((Math.random() * 100));
                                            if (lotnb2 >= 48 && lotnb2 <= 57) {
                                                break;
                                            }
                                        }
                                        while (true) {
                                            lotnb3 = (int) ((Math.random() * 100));
                                            if ((lotnb3 >= 48 && lotnb3 <= 57)) {
                                                break;
                                            }
                                        }
                                        if ((lotnb1 != lotnb2) && (lotnb1 != lotnb3) && (lotnb2 != lotnb3)) {
                                            break;
                                        }
                                    }
                                    while (true) {
                                        System.out.print("Enter a 3 digit number: ");
                                        playernb = scan.next();

                                        if (playernb.length() == 3) {
                                            playernb1 = playernb.charAt(0);
                                            playernb2 = playernb.charAt(1);
                                            playernb3 = playernb.charAt(2);
                                            if ((playernb1 >= 48 && playernb1 <= 57) && (playernb2 >= 48 && playernb2 <= 57) && (playernb3 >= 48 && playernb3 <= 57)) {
                                                break;
                                            } else {
                                                System.out.println("plz enter a valid number");
                                            }
                                        } else {
                                            System.out.println("plz enter a valid number");
                                        }
                                    }
                                    System.out.println("The lottery number: " + (char) lotnb1 + "" + (char) lotnb2 + "" + (char) lotnb3);
                                    if ((lotnb1 == playernb1) && (lotnb2 == playernb2) && (lotnb3 == playernb3)) {
                                        System.out.println("JACKPOTTT!!! YOU WON (+10000$)\n");
                                        balance += 10000;
                                    } else if (((lotnb1 == playernb1) && (lotnb2 == playernb2)) || ((lotnb1 == playernb1) && (lotnb3 == playernb3)) || ((lotnb2 == playernb2) && (lotnb3 == playernb3))) {
                                        System.out.println("YOU GUESSED 2 NUMBERS (+4000$)\n");
                                        balance += 4000;
                                    } else if ((lotnb1 == playernb1) || (lotnb2 == playernb2) || (lotnb3 == playernb3)) {
                                        System.out.println("YOU GUESSED 1 NUMBER (+1000$)\n");
                                        balance += 1000;
                                    } else {
                                        System.out.println("Sorry better luck next time :( \n");
                                        balance -= 500;
                                    }
                                } else {
                                    System.out.println("Insufficient ballance :( \n");
                                }
                                break;
                            case '*':
                                break OUTER;
                            default:
                                System.out.println("wrong choice format please try again \n");
                                break;
                        }
                    }

                case 'I':
                case 'i':
                    while (true) {
                        System.out.println("Learn more information about: ");
                        System.out.println();
                        System.out.println("B-Balance");
                        System.out.println("P-Play");
                        System.out.println("*-Go Back");
                        System.out.println("------------");
                        choice2 = scan.next().charAt(0);
                        switch (choice2) {
                            case 'B':
                            case 'b':
                                System.out.println("When you choose on the Balance in the menu you will have 2 choices to pick from: ");
                                System.out.println();
                                System.out.println("Deposit: You add money to your balance ");
                                System.out.println();
                                System.out.println("Withdraw: You take your money out of the program");
                                System.out.println();
                                break;
                            case 'P':
                            case 'p':
                                System.out.println("When you choose on the Play in the menu you will have 2 choices to pick from: ");
                                System.out.println();
                                System.out.println("Rock,Paper,scissors: This is a game where you choose rock, paper or scissors and play against a bot");
                                System.out.println("The rules as follows (Rock>Scissors)/(Scissors>Paper)/(Paper>Rock)");
                                System.out.println("If you win 100$ will be added to your balance and If you lose 200$ will be deducted from you balance");
                                System.out.println();
                                System.out.println("Lottery: This is a game where you guess a 3 digit number and try to get the the same number generated");
                                System.out.println("If you guess one digit of the same placement 1000$ will be added to your balance");
                                System.out.println("If you guess two digits of the same placement 4000$ will be added to your balance");
                                System.out.println("If you guess all the digits of the same placement 10000$ will be added to your balance");
                                System.out.println();
                                break;
                            case '*':
                                break OUTER;
                            default:
                                System.out.println("wrong choice format please try again\n");
                                break;
                        }
                    }
                case 'e':
                case 'E':
                    if (balance == 0) {
                        System.exit(0);
                    } else {
                        System.out.println("Go and withdraw the remaining balance before exiting :)\n");
                        break;
                    }
                default:
                    System.out.println("wrong choice format please try again \n");
            }
        }
    }

    public static boolean checkpassword(String password) {
        boolean checknb = false, checkspacial = false, checkcapital = false, checklower = false;
        if (password.length() > 7) {
            for (int i = 0; i < password.length(); i++) {
                for (int j = 48; j <= 57; j++) {
                    if (password.charAt(i) == j) {
                        checknb = true;
                    }
                }
                for (int j = 33; j <= 47; j++) {
                    if (password.charAt(i) == j) {
                        checkspacial = true;
                    }
                }
                for (int j = 63; j <= 64; j++) {
                    if (password.charAt(i) == j) {
                        checkspacial = true;
                    }
                }
                for (int j = 65; j <= 90; j++) {
                    if (password.charAt(i) == j) {
                        checkcapital = true;
                    }
                }
                for (int j = 97; j <= 122; j++) {
                    if (password.charAt(i) == j) {
                        checklower = true;
                    }
                }
            }
        }

        if (checknb && checkspacial && checkcapital && checklower) {
            return true;
        }
        return false;
    }
}
