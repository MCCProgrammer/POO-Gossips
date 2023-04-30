/**
*@author Miguel Cacais do Carmo
         *Esta classe implementa a interface Group
*/

package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class GroupClass implements Group{
	
	private Array<Person> persons;
	
	public GroupClass(int maxCapacity,Person P) {
		persons = new ArrayClass<>(maxCapacity);
		addPerson(P);
	}
	
	@Override
	public boolean isInGroup(Person P) {
		int i=0;
		while (i<persons.size() && !persons.get(i).getName().equals(P.getName())) {
			i++;
		}
		return i!=persons.size();
	}

	@Override
	public void removePerson(Person P) {
		int index = getIndexPerson(P);
		persons.removeAt(index);
	}
	
	private int getIndexPerson(Person P) {
		int i=0;
		while(i<persons.size() && !persons.get(i).equals(P)) {
			i++;
		}
		return i;
	}
	
	@Override
	public void addPerson(Person P) {
		persons.insertLast(P);
	}

	@Override
	public Iterator<Person> listAll() {
		return persons.iterator();
	}

	@Override
	public int getGroupSize() {
		return persons.size();
	}
}
