/**
*@author Miguel Cacais do Carmo
         *Esta interface é para ser implementada na CommunityClass.
*/

package Classes_Interfaces;

import dataStructures.Iterator;

public interface Community {
	
	/**
	 * 
	 * @param name
	 * @return se a landmark com o <name> existe na comunidade ou não
	 */
	boolean landmarkExists(String name);
	
	/**
	 * @pre: capacity > 0 && name!=<HOME> && landmarkExists(name) devolve true
	 * @param capacity
	 * @param name
	 */
	void addLandmark(int capacity,String name);
	
	/**
	 * 
	 * @return um iterador com todas as landmarks que existem na comunidade 
	 */
	Iterator<Landmark> listAllLandmarks();
	
	/**
	 * 
	 * @param name
	 * @return se a pessoa com o nome <name> existe ou não
	 */
	boolean personExists(String name);
	
	/**
	 * @pre: nr_Gossips > 0 && personExists(name) devolve false
	 * @param nr_Gossips
	 * @param name
	 */
	void addForgetfulPerson(int nr_Gossips,String name);
	
	/**
	 * @pre: personExists(name) devolve false
	 * @param name
	 */
	void addGossiperPerson(String name);
	
	/**
	 * @pre: personExists(name) devolve false
	 * @param name
	 */
	void addSealedPerson(String name);
	
	/**
	 * 
	 * @return um iterador com todas as pessoas que existem na comunidade
	 */
	Iterator<Person> listAllPersons();
	
	/**
	 * @pre: personExists(name) devolve true
	 * @param name
	 * @return o sitio onde a pessoa se encontra no momento
	 */
	String getPlace(String name);
	
	/**
	 * @pre: landmarkExists(place) devolve true
	 * @param place
	 * @return se as landmark está cheia ou não
	 */
	boolean isLandmarkFull(String place);
	
	/**
	 * personExists(name) devolve true && landmarkExits(place) devolve true
	 * @param name
	 * @param place
	 */
	void moveTo(String name,String place);
	
	/**
	 * persoExists(name) devolve true && personExists(other) devolve true
	 * @param name
	 * @param other
	 * @return se a pessoa com o nome <name> e a outra pessoa com o nome <other> são do mesmo grupo
	 */
	boolean sameGroup(String name,String other);
	
	/**
	 * @pre: landmarkExists(landmark) devolve true
	 * @param landmark
	 * @return se a landmark com o nome <landmark> está vazia ou não
	 */
	boolean isLandmarkEmpty(String landmark);
	
	/**
	 * @pre: personExits(name)
	 * @param name
	 * @return se a pessoa está num grupo ou não
	 */
	boolean isAlone(String name);
	
	/**
	 * @pre: personExits(name)
	 * @param name
	 */
	void setAlone(String name);
	
	/**
	 * 
	 * @param creator
	 * @param Targets
	 * @param description
	 * @return se o gossip com as caracteristicas passados nos parametros já existe ou não
	 */
	boolean gossipExists(String creator,String[] Targets,String description);
	
	/**
	 * @pre: personsExists(creator) devolve true &&   gossipExistes(creator,Targets,description) devolve false
	 * @param creator
	 * @param Targets
	 * @param description
	 */
	void createGossip(String creator,String[] Targets,String description);
	
	/**
	 * @pre: personExits(name)
	 * @param name
	 * @return se ou não de gossips
	 */
	boolean somethingToShare(String name);
	
	/**
	 * @pre: personExits(name)
	 * @param name
	 * @return se a pessoas que partilhar os gossips que tem 
	 */
	boolean wantsToShare(String name);
	
	/**
	 * @pre: personExits(name) devolve true && somethingToShare(name) devolve true && 
	 * && wantsToShare(name) devolve true
	 * @param name
	 * @return os gossips que a pessoa partilhou para o resto do grupo
	 */
	Gossip[] shareGossipWithGroup(String name);
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return se existe gossisps sobre a pessoa com o nome <name>
	 */
	boolean areThereGossipsAbout(String name);
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return se a pessoa com o nome <name> sabe de algum gossip ou não
	 */
	boolean hasGossips(String name);
	
	/**
	 * 
	 * @return se a communidade tem gossips ou não
	 */
	boolean communityHasGossips();
	
	/**
	 * 
	 * @return se a communidade tem gossips e agum destes foi partilhado ou não
	 */
	boolean communityHasSharedGossips();
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return iterador de Pessoas com as pessoas do grupo em que a pessoa com o nome <name> está
	 */
	Iterator<Person> listAllPersonsGroup(String name);
	
	/**
	 * @pre: personsExists(name) devolve true && personsExists(groupPerson) devolve true &&
	 * getPlace(name).equals(HOME) devolve false && 
	 * && (!(getPlace(other).equals(getPlace(name))) || getPlace(other).equals(HOME)) devolve false &&
	 * && sameGroup(name,other) devolve true
	 * @param name
	 * @param groupPerson
	 */
	void joinGroup(String name,String groupPerson);
	
	/**
	 * @pre: landmarkExists(place) devolve true
	 * @param place
	 * @return um iterador com os Grupos que existem na landmark com o nome <place>
	 */
	Iterator<Group> listAllGroups(String place);
	
	/**
	 * landmarkExists(place) devolve true
	 * @param place
	 * @return o número de grupos que há na landmark com o nome <place>
	 */
	int getNrOfGroups(String place);
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return um iterador com os Gossips existem sobre a pessoa com o nome <name>
	 */
	Iterator<Gossip> listAllGossipsAbout(String name);
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return um iterador com os Gossips que a pessoa com o nome <name> sabe
	 */
	Iterator<Gossip> listAllKnownGossips(String name);
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @return um iterador com os Gossips que foram mais partilhados na comunidade
	 */
	Iterator<Gossip> listMostSharedGossips();
	
}
