/**
*@author Miguel Cacais do Carmo
         *Esta interface é para ser implementa na classe GossipClass.
*/

package Classes_Interfaces;

public interface Gossip {
	/**
	 * 
	 * @param creator
	 * @param targets
	 * @param description
	 * @return se as caracteristicas do gossip passado no parâmetro é igual ao deste gossip
	 */
	boolean isEqual(Person creator,Person[] targets,String description);
	
	/**
	 * 
	 * @param name
	 * @return se a pessoa com o nome <name> é target deste gossip ou não
	 */
	boolean isTarget(String name);
	
	/**
	 * adiciona da pessoa <P> ao array das pessoas que o gossip foi partilhado
	 * @param P
	 */
	void sharedWith(Person P);
	
	/**
	 * 
	 * @return a variável <description>
	 */
	String getDescription();
	
	/**
	 * incrementa mais um, a variável <SharedTimes>
	 */
	void incrementSharedTimes();
	
	/**
	 * 
	 * @return <sharedTimes>
	 */
	int getSharedTimes();
	
	
	/**
	 * 
	 * @return o nome do criador do gossip
	 */
	String getCreatorName();
	
	/**
	 * 
	 * @return o número de pessoas que o gossip foi partilhado
	 */
	int getSharedWithSize();
	
	/**
	 * remove a pessoa <P> ao array das pessoas que o gossip foi partilhado
	 * @param P
	 */
	void removeSharedWith(Person P);
}
