/**
*@author Miguel Cacais do Carmo
         *Esta classe implementa a interface Person
*/

package Classes_Interfaces;

public abstract class PersonAbstractClass implements Person{
	
	private static final String HOME="home"; 
	private String name;
	private String current_place;
	
	
	public PersonAbstractClass(String name) {
		this.name=name;
		current_place=HOME;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPlace() {
		return current_place;
	}
	
	@Override
	public void setPlace(String place) {
		current_place=place;
		
	}

	@Override
	public boolean equals(Person other) {
		return name.equals(other.getName());
	}

}
