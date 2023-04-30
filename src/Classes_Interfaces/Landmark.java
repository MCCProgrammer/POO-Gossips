/**
*@author Miguel Cacais do Carmo
         *Esta classe é para ser implementada na LandmarkClass
*/

package Classes_Interfaces;

import dataStructures.Iterator;

public interface Landmark {
	
	/**
	 * 
	 * @return o nome da landmark
	 */
	String getName();
	
	/**
	 * 
	 * @return a capacidade maxima da landmark
	 */
	int getFullCapacity();
	
	/**
	 * 
	 * @return a capacidade atual da landmark
	 */
	int getCurrentCapacity();
	
	/**
	 * 
	 * @return se a landmark está cheia ou não 
	 */
	boolean isFull();
	
	/**
	 * 
	 * @return se a landmark está vazia ou não
	 */
	boolean isEmpty();
	
	/**
	 * @pre: <P>  tem de pertencer a esta landmark
	 * remove a pessoa <P> da landmark
	 * @param P
	 */
	void removePerson(Person P);
	
	/**
	 * @pre: <P>  tem de pertencer a esta landmark
	 * adiciona a pessoa <P> da landmark
	 * @param P
	 */
	void addPersonToLandmark(Person P);
	
	/**
	 * @pre: <P> e <groupPerson> tem de pertencer a esta landmark
	 * adiciona a pessoa <P> ao grupo da pessoa <groupPerson>
	 * @param P
	 * @param groupPerson
	 */
	void addPersonToGroup(Person P,Person groupPerson);
	
	/**
	 * @pre: <P> e <other> tem de pertencer a esta landmark
	 * @param p
	 * @param other
	 * @return se a pessoa <p> e a pessoa <other> são do mesmo grupo ou não
	 */
	boolean sameGroup(Person p,Person other);
	
	/**
	 * @pre: <P> tem de pertencer a esta landmark
	 * @param P
	 * @return um iterador de Pessoas com todas as pessoas do grupo da pessoa <P>
	 */
	Iterator<Person> listAllPersonsGroup(Person P);
	
	/**
	 * 
	 * @return um iterador dos Grupos que está landmark tem 
	 */
	Iterator<Group> listAllGroups();
	
	/**
	 * 
	 * @return o número de grupos que a landmark tem
	 */
	int getNrOfGroups();
	
	/**@pre: <P> tem de pertencer a esta landmark
	 * 
	 * @param p
	 * @return se a pessoa <P> ta sozinha num grupo ou não
	 */
	boolean isAlone(Person p);
}
