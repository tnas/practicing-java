package edu.hofstra.cs.csc017.socialnetwork;
import java.util.Scanner;

public class SocialNetworkRunner {

	private static final int EXIT_OPTION = 9;
	
    public static void main(String[] args) throws Exception {
    	
    	SocialNetworkView socialNetView = new SocialNetworkViewCommand();
        SocialNetwork socialNet = SocialNetwork.getInstance();
        SocialNetworkDataSource socialNetDataSource = new SocialNetworkFileDataSource();
        
        int usersChoice = 0;

        try (Scanner inputScanner = new Scanner(System.in)) {

            while (usersChoice != EXIT_OPTION) {
            	
            	socialNetView.showMenuOptions();    	
                usersChoice = Integer.parseInt(inputScanner.nextLine().trim());

                switch (usersChoice) {
                	case 0:
                		socialNet.defaultInit();
                    break;
                    case 1:
                        socialNet.setPersons(socialNetDataSource.retrivePeople(
                        		socialNetView.getPeopleDataSource()));
                        break;
                    case 2:
                        socialNet.setRelationships(socialNetDataSource.retrieveRelationships(
                        		socialNetView.getRelationshipDataSource()));
                        break;
                    case 3:
                        socialNet.setContents(socialNetDataSource.retrieveContent(
                        		socialNetView.getContentDataSource()));
                        break;
                    case 4:
                        socialNetView.showPeople(socialNet.getAllPeople());
                        break;
                    case 5:
                        socialNetView.showRelationships(socialNet.getAllRelationships());
                        break;
                    case 6:
                        socialNetView.showFullContent(socialNet.getAllContents());
                        break;
                    case 7:
                    	socialNetView.showMainFeed(socialNet.getMainFeed());
                    	break;
                    case 8:
                    	socialNetView.showRecommendedFeed(socialNet.getRecommendedFeed());
                    	break;
                    case EXIT_OPTION:
                    	socialNetView.close();
                        break;
                    default:
                        System.out.print("Input error! Try again.");
                        break;
                }
            }

            socialNetView.goodBye();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
