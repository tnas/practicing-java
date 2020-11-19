package edu.hofstra.cs.csc017.socialnetwork;
import java.util.Scanner;

public class SocialNetworkRunner {

	private static Person loggedInUser;
	private static final int EXIT_OPTION = 9;
	
    public static void main(String[] args) throws Exception {
    	
        SocialNetwork socialNetwork = new SocialNetwork();
        loggedInUser = socialNetwork.getLoggedInUser();
        
        int usersChoice = 0;

        printMenu();
        try (Scanner inputScanner = new Scanner(System.in)) {

            while (usersChoice != EXIT_OPTION) {
                usersChoice = Integer.parseInt(inputScanner.nextLine().trim());

                switch (usersChoice) {
                	case 0:
                		socialNetwork.loadDefaultData();
                    break;
                    case 1:
                        System.out.println("Enter file path which has people's data: ");
                        String peopleFilePath = inputScanner.nextLine();

                        socialNetwork.readPeopleFile(peopleFilePath.trim());
                       
                        break;
                    case 2:
                        System.out.println("Enter file path which has relationhip data: ");
                        String relationshipFilePath = inputScanner.nextLine();
                        socialNetwork.readRelationshipFile(relationshipFilePath.trim());
                        break;
                    case 3:
                        System.out.println("Enter file path which has content data: ");
                        String contentFilePath = inputScanner.nextLine();
                        socialNetwork.readContentFile(contentFilePath.trim());
                        break;
                    case 4:
                        System.out.println("~~~~People's List~~~~");
                        socialNetwork.listAllPeople();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                        break;
                    case 5:
                        System.out.println("~~~~Relationships List~~~~");
                        socialNetwork.listAllRelationships();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                        break;
                    case 6:
                        System.out.println("~~~~Content List~~~~");
                        socialNetwork.listAllContents();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                        break;
                    case 7:
                    	System.out.println("~~~~The main feed~~~~");
                        socialNetwork.printMainFeed(loggedInUser);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                    	break;
                    case 8:
                    	System.out.println("~~~~The recommended feed~~~~");
                        socialNetwork.printRecommendedFeed(loggedInUser);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                    	break;
                    case EXIT_OPTION:
                        break;
                    default:
                        System.out.print("Input error! Try again.");
                        break;
                }

                printMenu();
            }

            System.out.println("Have a good day.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println(String.format("Welcome to Social Network! (Logged in user: %s)", 
        		loggedInUser.getFullName()));
        System.out.println("Please choose one of the following options:");
        System.out.println("0. Load standard files from default directory");
        System.out.println("1. Enter filename for people\n2. Enter filename for relationships");
        System.out.println("3. Enter filename for content\n4. View a list of people");
        System.out.println("5. View a list of relationships\n6. View a list of content");
        System.out.println("7. Print the main feed.");
        System.out.println("8. Print the recommended feed.");
        System.out.println(String.format("%d. Exit", EXIT_OPTION));
        
    }

}
