/**
*@author Miguel Cacais do Carmo
         *Esta classe implementa a interface Gossip.
*/

package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class GossipClass implements Gossip{
	
	private Array<Person> targets;
	private Array<Person> sharedWith;
	
	private String description;
	private Person creator;
	private int sharedTimes;
	
	public GossipClass(Person creator,Person[] targets,String description) {
		sharedWith = new ArrayClass<>();
		this.targets = new ArrayClass<>(targets.length);
		fillInTargets(targets);
		
		this.creator=creator;
		this.description=description;
		sharedTimes=0;
	}
	
	/**
	 * este método adiciona todos os targets que veêmm no array e adicionaos ao arrayGenérico
	 * @param targets
	 */
	private void fillInTargets(Person[] targets) {
		for(int i=0;i<targets.length;i++) {
			this.targets.insertLast(targets[i]);
		}
	}

	@Override
	public boolean isEqual(Person creator,Person[] targets,String description) {
		boolean condition=true;
		condition =  this.creator.getName().equals(creator.getName()) && condition;
		if(this.targets.size()!=targets.length) {
			return false;
		}
		for(int i=0;i<targets.length;i++) {
			condition= this.targets.searchForward(targets[i]) && condition;
		}
		return condition && this.description.equals(description);
	}

	@Override
	public boolean isTarget(String name) {
		int i=0;
		while (i<targets.size() && !targets.get(i).getName().equals(name)) {
			i++;
		}
		return i!=targets.size();
	}

	@Override
	public void sharedWith(Person P) {
		sharedWith.insertLast(P);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void incrementSharedTimes() {
		sharedTimes++;
		
	}

	@Override
	public int getSharedTimes() {
		return sharedTimes;
	}

	@Override
	public String getCreatorName() {
		return creator.getName();
	}

	@Override
	public int getSharedWithSize() {
		return sharedWith.size();
	}

	@Override
	public void removeSharedWith(Person P) {
		sharedWith.removeAt(sharedWith.searchIndexOf(P));
	}
}
