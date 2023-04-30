/**
*@author Miguel Cacais do Carmo
         *O principal objetivo desta classe é ser o ponto de partida do programa, para além disso, lê e escreve todos os dados do mesmo.  
*/

import java.util.Scanner;

import Classes_Interfaces.Community;
import Classes_Interfaces.CommunityClass;
import Classes_Interfaces.Gossip;
import Classes_Interfaces.Group;
import Classes_Interfaces.Landmark;
import Classes_Interfaces.Person;
import dataStructures.Iterator;


public class Main {
	
	/** 
	 * Comandos do utilizador.
	 */
	private static final String EXIT = "EXIT";
	private static final String HELP = "HELP";
	private static final String LANDMARK = "LANDMARK";
	private static final String LANDMARKS = "LANDMARKS";
	private static final String FORGETFUL = "FORGETFUL";
	private static final String GOSSIPER = "GOSSIPER";
	private static final String SEALED = "SEALED";
	private static final String PEOPLE = "PEOPLE";
	private static final String GO = "GO";
	private static final String JOIN = "JOIN";
	private static final String GROUPS = "GROUPS";
	private static final String ISOLATE = "ISOLATE";
	private static final String START = "START";
	private static final String GOSSIP = "GOSSIP";
	private static final String SECRETS = "SECRETS";
	private static final String INFOTAINMENT = "INFOTAINMENT";
	private static final String HOTTEST = "HOTTEST";
	
	/**
	 * Feedback dado pelo programa.
	 */
	
	private static final String BYE = "Bye!";
	private static final String LANDMARK_ADDED = "%s added.\n";
	private static final String LANDMARK_INVALID_CAPACITY = "Invalid landmark capacity %d!\n";
	private static final String LANDMARK_NOT_AVAILABLE = "Cannot create a landmark called home. You know, there is no place like home!";
	private static final String LANDMARK_ALREADY_EXISTS = "Landmark %s already exists!\n";
	private static final String NO_LANDMARKS = "This community does not have any landmarks yet!";
	private static final String NO_PEOPLE = "This community does not have any people yet!";
	private static final String LANDMARKS_INFO = "%s: %d %d.\n";
	private static final String FORGETFUL_ADDED = "%s can only remember up to %d gossips.\n";
	private static final String INVALID_GOSSIPS_CAPACITY = "Invalid gossips capacity %d!\n";
	private static final String PERSON_ALREADY_EXITS = "%s already exists!\n";
	private static final String DOESNT_EXITS = "%s does not exist!\n";
	private static final String GOSSIPER_ADDED = "%s is a gossiper.\n";
	private static final String SEALED_ADDED = "%s lips are sealed.\n";
	private static final String PERSON_INFO = "%s at %s knows %d gossips.\n";
	private static final String SHOW_PLACE = "%s is now at %s.\n";
	private static final String UNKNOWN_PLACE = "Unknown place %s!\n";
	private static final String ALREADY_THERE = "What do you mean go to %s? %s is already there!\n";
	private static final String TOO_CROWEDED = "%s is too crowded! %s went home.\n";
	private static final String GROUP_JOINED = "%s joined %s, at the %s.\n";
	private static final String NEEDS_COMPANY = "%s needs company from someone else!\n";
	private static final String AT_HOME = "%s is at home!\n";
	private static final String DIFERENT_LANDMARK = "%s is not in %s!\n";
	private static final String SAME_GROUP = "%s and %s are already in the same group!\n";
	private static final String HEADER_GROUPS = "%d groups at %s:\n";
	private static final String NO_GROUPS_AT_HOME = "You must understand we have no surveillance tech at home! Privacy is our top concern!";
	private static final String EMPTY_LANDMARK = "Nobody is at %s!\n";
	private static final String ALREADY_ALONE = "%s is already alone!\n";
	private static final String NOW_ALONE = "%s is now alone at %s.\n";
	private static final String GOSSIP_STARTED = "Have you heard about %s? %s\n";
	private static final String INVALID_GOSSIP_TARGETS = "Invalid number %d of gossip targets!\n";
	private static final String DUPLICATE_GOSSIP = "Duplicate gossip!";
	private static final String SHARED_WITH = "%s shared with %s, some hot news!\n%s";
	private static final String NOBODY_TO_GOSSIP = "%s has nobody to gossip with right now!\n";
	private static final String KNOWS_NOTHING = "%s knows nothing!\n";
	private static final String NOT_WISH_TO_GOSSIP = "%s does not wish to gossip right now!\n";
	private static final String HEARDER_SECRETS = "Here is what we know about %s:\n";
	private static final String BORING_LIFE = "%s lives a very boring life!\n";
	private static final String HOTTEST_GOSSIP = "The hottest gossips were shared %d times!\n";
	private static final String NO_GOSSIPS = "No gossips we are aware of!";
	private static final String NO_GOSSIPS_SHARED = "No gossips were shared, yet!";
	private static final String DEFEAULT = "Unknown command. Type help to see available commands.";
	private static final String HEADER_INFOTAINMENT = "%s knows things:\n";
	private static final String HELP_INFORMATION = "landmark - adds a new landmark to the community\n" + 
			"landmarks - displays the list of landmarks in the community\n" + 
			"forgetful - adds a forgetful person to the community\n" + 
			"gossiper - adds a gossiper person to the community\n" + 
			"sealed - adds a sealed lips person to the community\n" + 
			"people - lists all the persons in the community\n" + 
			"go - moves a person to a landmark, or home\n" + 
			"join - joins a person to a group\n" + 
			"groups - lists the groups composition in a landmark\n" + 
			"isolate - makes a person leave the current group, but not the landmark the person is currently on\n" + 
			"start - starts a new gossip\n" + 
			"gossip - share a gossip within the current group in the current landmark\n" + 
			"secrets - lists the gossip about a particular person\n" + 
			"infotainment - lists the gossips a particular person is aware of\n" + 
			"hottest - lists the most shared gossip\n" + 
			"help - shows the available commands\n" + 
			"exit - terminates the execution of the program";
	
	private static final String HOME = "home";
	
	public static void main(String[] args) {
		Main.commands();

	}
	
	/**
	 * Interpretador de comandos.
	 */
	private static void commands() {
		Community comm = new CommunityClass();
		Scanner input = new Scanner(System.in);
		String command;
		do {
			command = input.next().toUpperCase();
			switch (command) {
			case LANDMARK: 
				addLandmark(input,comm); 
				break;
			case LANDMARKS : 
				ListALLLandmarks(comm); 
				break;
			case FORGETFUL : 
				addForgetfulPerson(input,comm);
			break;
			case GOSSIPER : 
				addGossiperPerson(input,comm);
				break;
			case SEALED : 
				addSealedPerson(input,comm);
				break;
			case PEOPLE : 
				listAllPersons(input,comm);
				break;
			case GO : 
				GoToLandmark(input,comm);
				break;
			case JOIN : 
				joinGroup(input,comm);
				break;
			case GROUPS : 
				groupsInLandmark(input,comm);
				break;
			case ISOLATE : 
				leaveGroup(input,comm);
				break;
			case START : 
				startGossip(input,comm);
				break;
			case GOSSIP : 
				shareGossipWithGroup(input,comm);
				break;
			case SECRETS : 
				secrets(input,comm);
				break;
			case INFOTAINMENT : 
				infotainment(input,comm);
				break;
			case HOTTEST : 
				hottest(input,comm);
				break;
			case HELP : 
				System.out.println(HELP_INFORMATION);
				break;
			case EXIT : 
				System.out.println(BYE);
				break;
			default : System.out.println(DEFEAULT);
			break;
			}
		} while (!command.equals(EXIT));
		input.close();
	}

	/**
	 * É o metodo que é executado quando a variável command.equals(LANDMARK). Este método faz 3 
	 * verificações antes de ser adicionado uma nova landmark à comunidade
	 * @param in 
	 * @param comm  
	 */
	private static void addLandmark(Scanner in,Community comm) {
		int capacity=in.nextInt();
		String name = inputString(in);
		if(capacity<=0) {
			System.out.printf(LANDMARK_INVALID_CAPACITY,capacity);
		}else if(name.equals(HOME)) {
			System.out.println(LANDMARK_NOT_AVAILABLE);
		}else if (comm.landmarkExists(name)) {
			System.out.printf(LANDMARK_ALREADY_EXISTS,name);
		}else {
			comm.addLandmark(capacity,name);
			System.out.printf(LANDMARK_ADDED,name);
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(LANDMARKS). Este método lista todas as 
	 * landmarks adicionadas, se não houver nenhuma, da print da constante NO_LANDMARKS
	 * @param in 
	 * @param comm  
	 */
	private static void ListALLLandmarks(Community comm) {
		Iterator<Landmark> it =  comm.listAllLandmarks();
		if(!it.hasNext()) {
			System.out.println(NO_LANDMARKS);
		}else {
		while (it.hasNext()) {
			Landmark land = it.next();
			System.out.printf(LANDMARKS_INFO,land.getName(),land.getFullCapacity(),land.getCurrentCapacity());
		}
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(FORGETFUL). Este método faz 2 
	 * verificações antes de adicionar uma pessoa do tipo Forgetful à comunidade
	 * @param in
	 * @param comm
	 */
	private static void addForgetfulPerson(Scanner in,Community comm) {
		int nr_Gossips=in.nextInt();
		String name = inputString(in);
		if(nr_Gossips<=0) {
			System.out.printf(INVALID_GOSSIPS_CAPACITY,nr_Gossips);
		}else if(comm.personExists(name)) {
			System.out.printf(PERSON_ALREADY_EXITS,name);
		}else {
			comm.addForgetfulPerson(nr_Gossips,name);
			System.out.printf(FORGETFUL_ADDED,name,nr_Gossips);
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(GOSSIPER). Este método faz 1 
	 * verificações antes de adicionar uma pessoa do tipo Gossiper à comunidade
	 * @param in
	 * @param comm
	 */
	private static void addGossiperPerson(Scanner in,Community comm) {
		String name = inputString(in);
		if(comm.personExists(name)) {
			System.out.printf(PERSON_ALREADY_EXITS,name);
		}else {
			comm.addGossiperPerson(name);
			System.out.printf(GOSSIPER_ADDED,name);
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(SEALED). Este método faz 1 
	 * verificações antes de adicionar uma pessoa do tipo Sealed à comunidade
	 * @param in
	 * @param comm
	 */
	private static void addSealedPerson(Scanner in,Community comm) {
		String name = inputString(in);
		if(comm.personExists(name)) {
			System.out.printf(PERSON_ALREADY_EXITS,name);
		}else {
			comm.addSealedPerson(name);
			System.out.printf(SEALED_ADDED,name);
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(PEOPLE). Este método lista
	 * todas as pessoas nas comunidade,senão houver nenhuma da print da constante NO_PEOPLE 
	 * @param in
	 * @param comm
	 */
	private static void listAllPersons(Scanner in,Community comm) {
		Iterator<Person> it =  comm.listAllPersons();
		if(!it.hasNext()) {
			System.out.println(NO_PEOPLE);
		}else {
		while (it.hasNext()) {
			Person p = it.next();
			System.out.printf(PERSON_INFO,p.getName(),p.getPlace(),p.getKnownGossips());
		}
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(GO). Este método faz 4
	 * verificações antes mover uma pessoa para uma landmark
	 * @param in
	 * @param comm
	 */
	private static void GoToLandmark(Scanner in,Community comm) {
		String name=inputString(in);
		String place = in.nextLine();
		if(!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (!comm.landmarkExists(place)) {
			System.out.printf(UNKNOWN_PLACE,place);
		}else if(comm.getPlace(name).equals(place)){
			System.out.printf(ALREADY_THERE,place,name);
		}else if (comm.isLandmarkFull(place)) {
			System.out.printf(TOO_CROWEDED,place,name);
			comm.moveTo(name,HOME);
		}else {
			comm.moveTo(name,place);
			System.out.printf(SHOW_PLACE,name,place);
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(JOIN). Este método faz 6
	 * verificações antes de colocar uma pessoa no grupo de outra
	 * @param in
	 * @param comm
	 */
	private static void joinGroup(Scanner in,Community comm) {
		String name=inputString(in);
		String other = in.nextLine();
		if(name.equals(other)) {
			System.out.printf(NEEDS_COMPANY,name);
		}else if (!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (!comm.personExists(other)) {
			System.out.printf(DOESNT_EXITS,other);
		}else if (comm.getPlace(name).equals(HOME)) {
			System.out.printf(AT_HOME,name);
		}else if(!(comm.getPlace(other).equals(comm.getPlace(name))) || comm.getPlace(other).equals(HOME)){
			System.out.printf(DIFERENT_LANDMARK,other,comm.getPlace(name));
		}else if (comm.sameGroup(name,other)) {
			System.out.printf(SAME_GROUP,name,other);
		}else {
			Iterator<Person> it =  comm.listAllPersonsGroup(other);
			comm.joinGroup(name,other);
			String membres = "";
			int index=0;
			while (it.hasNext()) {
				Person p = it.next();
				if(index!=0) {
					membres+=", ";
				}
				membres+= p.getName();
				index++;
			}
			System.out.printf(GROUP_JOINED,name,membres,comm.getPlace(name));
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(GROUPS). Este método faz 3
	 * verificações antes de listar todos os grupos numa determinada landmark.
	 * @param in
	 * @param comm
	 */
	private static void groupsInLandmark(Scanner in,Community comm) {
		String landmark = inputString(in);
		if(landmark.equals(HOME)) {
			System.out.println(NO_GROUPS_AT_HOME);
		}else if(!comm.landmarkExists(landmark)) {
			System.out.printf(DOESNT_EXITS,landmark);
		}else if (comm.isLandmarkEmpty(landmark)) {
			System.out.printf(EMPTY_LANDMARK,landmark);
		}else {
			Iterator<Group> it = comm.listAllGroups(landmark);
			String membres;
			int index,nrGroups=comm.getNrOfGroups(landmark);
			System.out.printf(HEADER_GROUPS,nrGroups,landmark);
			while (it.hasNext()) {
				index=0;
				membres="";
				Group g = it.next();
				Iterator<Person> P_it = g.listAll();
				while (P_it.hasNext()) {
					if(index!=0) {
						membres += ", ";
					}
					Person p = P_it.next();
					membres += p.getName();
					index++;
				}
				System.out.println(membres);
			}
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(ISOLATE). Este método faz 3
	 * verificações antes de isolar uma pessoa. (ou seja,mover a pessoa do grupo em que se encontra mas não da landmark)
	 * @param in
	 * @param comm
	 */
	private static void leaveGroup(Scanner in,Community comm) {
		String name= inputString(in);
		if(!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (comm.getPlace(name).equals(HOME)) {
			System.out.printf(AT_HOME,name);
		}else if (comm.isAlone(name)) {
			System.out.printf(ALREADY_ALONE,name);
		}else {
			comm.setAlone(name);
			System.out.printf(NOW_ALONE,name,comm.getPlace(name));
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(START). Este método faz 4
	 * verificações antes de começar um gossip.
	 * @param in
	 * @param comm
	 */
	private static void startGossip(Scanner in,Community comm) {
		String creator = inputString(in);
		int nrOfTargets = in.nextInt();
		in.nextLine();
		String[] targets=null;
		if(nrOfTargets>0) {
			targets=new String[nrOfTargets];
		}
		for(int i=0;i<nrOfTargets;i++) {
			targets[i]=in.nextLine();
		}
		String description = in.nextLine();
		String person=null; 
		if(nrOfTargets>0) {
		person = Main.personThatDontExists(targets, comm);
		}
		if(!comm.personExists(creator)) {
			System.out.printf(DOESNT_EXITS,creator);
		}else if (nrOfTargets<=0) {
			System.out.printf(INVALID_GOSSIP_TARGETS,nrOfTargets);
		}else if (person!=null) {
			System.out.printf(DOESNT_EXITS,person);
		}else if (comm.gossipExists(creator,targets,description)) {
			System.out.println(DUPLICATE_GOSSIP);
		}else {
			comm.createGossip(creator,targets,description);
			String outputTargets = "";
			for(int i=0;i<targets.length;i++) {
				if(i!=0)
					outputTargets+=", ";
				outputTargets+=targets[i];
			}
			System.out.printf(GOSSIP_STARTED,outputTargets,description);
		}
	}
	
	/**
	 * Método auxiliar ao metodo private static void startGossip(Scanner in,Community comm)
	 * @param targets
	 * @param comm
	 * @return o nome da pessoa que não exister, se todos existirem devolve null
	 */
	private static String personThatDontExists(String[] targets,Community comm) {
		int i=0;
		while (i<targets.length && comm.personExists(targets[i])) {
			i++;
		}
		if(i==targets.length) {
			return null;
		}else {
			return targets[i];
		}
		
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(GOSSIP). Este método faz 4
	 * verificações antes de a pessoa com o nome name partilhar, partilhar os seus gossips com o seu grupo
	 * @param in
	 * @param comm
	 */
	private static void shareGossipWithGroup(Scanner in,Community comm) {
		String name=inputString(in);
		if(!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (comm.getPlace(name).equals(HOME) || comm.isAlone(name)) {
			System.out.printf(NOBODY_TO_GOSSIP,name);
		}else if (!comm.somethingToShare(name)) {
			System.out.printf(KNOWS_NOTHING,name);
		}else if (!comm.wantsToShare(name)) {
			System.out.printf(NOT_WISH_TO_GOSSIP,name);
		}else {
			Gossip[] goss = comm.shareGossipWithGroup(name);
			Iterator<Person> it = comm.listAllPersonsGroup(name);
			String outputGroupmembers = "";
			int counter=0;
			while (it.hasNext()) {
				Person p = it.next();
				if(!p.getName().equals(name)) {
					if(counter!=0)
						outputGroupmembers+=", ";
					outputGroupmembers+=p.getName();
					counter++;
				}
			}
			String outputGossips = "";
			for(int i=0;i<goss.length;i++) {
				outputGossips += goss[i].getDescription()+"\n";
			}
			System.out.printf(SHARED_WITH,name,outputGroupmembers,outputGossips);
		}
		
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(SECRETS). Este método faz 2
	 * verificações antes de listar todos os gossips sobre a pessoas com o nome name
	 * @param in
	 * @param comm
	 */
	private static void secrets(Scanner in,Community comm) {
		String name=inputString(in);
		if(!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (!comm.areThereGossipsAbout(name)) {
			System.out.printf(BORING_LIFE,name);
		}else {
			Iterator<Gossip> it = comm.listAllGossipsAbout(name);
			System.out.printf(HEARDER_SECRETS,name);
			while (it.hasNext()) {
				Gossip g = it.next();
				System.out.println((g.getSharedWithSize()+1)+" "+g.getDescription());
			}
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(INFOTAINMENT). Este método faz 2
	 * verificações antes de listar todos os gossips que a pessoa com o nome name sabe
	 * @param in
	 * @param comm
	 */
	private static void infotainment(Scanner in,Community comm) {
		String name=inputString(in);
		if(!comm.personExists(name)) {
			System.out.printf(DOESNT_EXITS,name);
		}else if (!comm.hasGossips(name)) {
			System.out.printf(KNOWS_NOTHING,name);
		}else {
			Iterator<Gossip> it = comm.listAllKnownGossips(name);
			System.out.printf(HEADER_INFOTAINMENT,name);
			while(it.hasNext()) {
				Gossip g = it.next();
				System.out.println(g.getDescription());
			}
		}
	}
	
	/**
	 * É o metodo que é executado quando a variável command.equals(HOTTEST). Este método faz 2
	 * verificações antes de listar os gossips com maior número de partilhas  
	 * @param in
	 * @param comm
	 */
	private static void hottest(Scanner in,Community comm) {
		if(!comm.communityHasGossips()) {
			System.out.println(NO_GOSSIPS);
		}else if (!comm.communityHasSharedGossips()) {
			System.out.println(NO_GOSSIPS_SHARED);
		}else {
			Iterator<Gossip> it = comm.listMostSharedGossips();
			boolean control=true;
			while (it.hasNext()) {
				Gossip g = it.next();
				if(control) {
					System.out.printf(HOTTEST_GOSSIP,g.getSharedTimes());
					control=false;
				}
				System.out.println(g.getDescription());
			}
		}
	}
	
	/**
	 * Método auxiliar de alguns outros métodos para dar input de uma string
	 * @param in
	 * @return
	 */
	private static String inputString(Scanner in) {
		in.skip(" ");
		String s = in.nextLine();
		return s;
	}
	
	
}
