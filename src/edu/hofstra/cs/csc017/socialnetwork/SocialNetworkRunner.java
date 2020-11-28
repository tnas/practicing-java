package edu.hofstra.cs.csc017.socialnetwork;

public class SocialNetworkRunner {

	public static void main(String[] args) throws Exception {

		SocialNetworkView socialNetView = new SocialNetworkViewCommand();
		SocialNetwork socialNet = SocialNetwork.getInstance();
		SocialNetworkDataSource socialNetDataSource = new SocialNetworkFileDataSource();
		int userChoice;

		while (socialNetView.isActive()) {

			userChoice = socialNetView.getUserOption();

			switch (userChoice) {
			case 0:
				socialNet.defaultInit();
				break;
			case 1:
				socialNet.setPersons(socialNetDataSource.retrivePeople(socialNetView.getPeopleDataSource()));
				break;
			case 2:
				socialNet.setRelationships(
						socialNetDataSource.retrieveRelationships(socialNetView.getRelationshipDataSource()));
				break;
			case 3:
				socialNet.setContents(socialNetDataSource.retrieveContent(socialNetView.getContentDataSource()));
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
			default:
				break;
			}
		}

		socialNetView.close();
		socialNetView.goodBye();
	}
}
