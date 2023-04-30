/**
*@author Miguel Cacais do Carmo
         *Esta classe implementa a interface Landmark.
*/

package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class LandmarkClass implements Landmark{
	
	private Array<Group> groups;
	
	private int fullCapacity,currentCapacity;
	private String name;
	
	public LandmarkClass(int capacity,String name) {
		groups = new ArrayClass<>(capacity);
		this.name=name;
		this.fullCapacity=capacity;
		currentCapacity=0;
	}
	


	@Override
	public String getName() {
		return name;
	}


	@Override
	public int getFullCapacity() {
		return fullCapacity;
	}


	@Override
	public int getCurrentCapacity() {
		return currentCapacity;
	}



	@Override
	public boolean isFull() {
		return fullCapacity==currentCapacity;
	}



	@Override
	public void removePerson(Person P) {
		Group g = getGroupByPerson(P);
		if(g.getGroupSize()==1) {
			int index = getIndexGroup(P);
			groups.removeAt(index);
		}else {
			g.removePerson(P);
		}
		currentCapacity--;
	}

	/**
	 * 
	 * @param P
	 * @return o Group em que a pessoa <P> está
	 */
	private Group getGroupByPerson(Person P) {
		int i=0;
		while(i<groups.size() && !groups.get(i).isInGroup(P)) {
			i++;
		}
		return groups.get(i);
	}

	@Override
	public void addPersonToLandmark(Person P) {
		groups.insertLast(new GroupClass(fullCapacity,P));
		currentCapacity++;
	}
	
	@Override
	public void addPersonToGroup(Person P,Person groupPerson) {
		Group g = getGroupByPerson(groupPerson);
		g.addPerson(P);
		currentCapacity++;
	}



	@Override
	public boolean sameGroup(Person p, Person other) {
		Group g = getGroupByPerson(p);
		return g.isInGroup(other);
	}



	@Override
	public Iterator<Person> listAllPersonsGroup(Person P) {
		Group g = getGroupByPerson(P);
		return g.listAll();
	}
	
	private int getIndexGroup(Person P) {
		int i=0;
		while(i<groups.size() && !groups.get(i).isInGroup(P)) {
			i++;
		}
		return i;
	}



	@Override
	public boolean isEmpty() {
		return currentCapacity==0;
	}



	@Override
	public Iterator<Group> listAllGroups() {
		return groups.iterator();
	}



	@Override
	public int getNrOfGroups() {
		return groups.size();
	}



	@Override
	public boolean isAlone(Person p) {
		Group g = getGroupByPerson(p);
		return g.getGroupSize()==1;
	}
}
