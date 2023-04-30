/**
*@author Miguel Cacais do Carmo
         *Esta interface é para ser implementada na PersonAbstractClass
*/

package Classes_Interfaces;

import dataStructures.Iterator;

public interface Person {
	
	/**
	 * 
	 * @return o nome da pessoa
	 */
	String getName();
	
	/**
	 * 
	 * @return o sitio onde se encontra
	 */
	String getPlace();
	
	/**
	 * 
	 * @return o número de gossips que sabe
	 */
	int getKnownGossips();
	
	/**
	 * muda o sitio onde se encontra para <place>
	 * @param place
	 */
	void setPlace(String place);
	
	/**
	 * 
	 * @param other
	 * @return se esta pessoa e a pessoa <other> são iguais ,ou seja, o nome delas são iguais
	 */
	boolean equals(Person other);
	
	/**
	 * 
	 * @param gossip
	 */
	void addGossip(Gossip gossip);
	
	/**
	 * 
	 * @return se a pessoa tem gossips para partilhar
	 */
	boolean somethingToShare();
	
	/**
	 * 
	 * @return se a pessoa tendo gossips para partilhar, se ela que ou não
	 */
	boolean wantsToshare();
	
	/**
	 * 
	 * @return um array dos gossips que ele irá partilhar
	 */
	Gossip[] getGossipsToShare();
	
	/**
	 * 
	 * @return um iterador de todos os Gossips que a pessoa sabe  
	 */
	Iterator<Gossip> listAllKnownGossips();
	
	/**
	 * 
	 * @param g
	 * @return se a pessoa sabe ou não do gossip <g>
	 */
	boolean hasGossip(Gossip g);
}
