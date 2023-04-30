/**
*@author Miguel Cacais do Carmo
         *Esta interface é para ser implementada na GroupClass
*/

package Classes_Interfaces;

import dataStructures.Iterator;

public interface Group {
	
	/**
	 * 
	 * @param P
	 * @return se a pessoa <P> está neste grupo ou não
	 */
	boolean isInGroup(Person P);
	
	/**
	 * remove a pessoa <P> do grupo
	 * @param P
	 */
	void removePerson(Person P);
	
	/**
	 * adiciona a pessoa <P> neste grupo
	 * @param P
	 */
	void addPerson(Person P);
	
	/**
	 * 
	 * @return um iterador com todas as pessoas pertencentes a este grupo
	 */
	Iterator<Person> listAll();
	
	/**
	 * 
	 * @return quantas pessoas tem o grupo
	 */
	int getGroupSize();
}
