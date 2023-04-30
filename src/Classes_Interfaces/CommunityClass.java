/**
*@author Miguel Cacais do Carmo
         *Esta classe implementa a interface Community. 
*/

package Classes_Interfaces;


import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.ArrayIterator;
import dataStructures.Iterator;

public class CommunityClass implements Community{

	private static final String HOME="home";
	
	private Array<Landmark> landmarks;
	private Array<Person> persons;
	private Array<Gossip> gossips;
	
	public CommunityClass() {
		landmarks = new ArrayClass<>();
		persons = new ArrayClass<>();
		gossips = new ArrayClass<>();
	}
	
	
	@Override
	public boolean landmarkExists(String name) {
		int i=0;
		while (i<landmarks.size() && !landmarks.get(i).getName().equals(name)) {
			i++;
		}
		return i!=landmarks.size();
	}

	@Override
	public void addLandmark(int capacity, String name) {
		landmarks.insertLast(new LandmarkClass(capacity, name));
	}

	@Override
	public Iterator<Landmark> listAllLandmarks() {
		return landmarks.iterator();
	}

	@Override
	public boolean personExists(String name) {
		int i=0;
		while (i<persons.size() && !persons.get(i).getName().equals(name)) {
			i++;
		}
		return i!=persons.size();
	}

	@Override
	public void addForgetfulPerson(int nr_Gossips, String name) {
		persons.insertLast(new ForgetfulPersonClass(nr_Gossips, name));
	}

	@Override
	public void addGossiperPerson(String name) {
		persons.insertLast(new GossiperPersonClass(name));
	}

	@Override
	public void addSealedPerson(String name) {
		persons.insertLast(new SealedPersonClass(name));
	}

	@Override
	public Iterator<Person> listAllPersons() {
		return persons.iterator();
	}

	@Override
	public String getPlace(String name) {
		Person P = getPersonByName(name);
		return P.getPlace();
	}

	@Override
	public boolean isLandmarkFull(String place) {
		Landmark l = getLandmarkByName(place);
		return l.isFull();
	}

	@Override
	public void moveTo(String name, String place) {
		Person P = getPersonByName(name);
		if(!P.getPlace().equals(HOME)) {
			Landmark old = getLandmarkByName(P.getPlace());
			old.removePerson(P);
		}
		if(place.equals(HOME)) {
			P.setPlace(HOME);
		}else {
			Landmark current = getLandmarkByName(place);
			current.addPersonToLandmark(P);
		}
		P.setPlace(place);
		if(P instanceof ForgetfulPersonClass) {
			((ForgetfulPersonClass) P).setChangedGroup();
		}
	}

	@Override
	public boolean sameGroup(String name, String other) {
		Person p = getPersonByName(name);
		Landmark place = getLandmarkByName(p.getPlace());
		return place.sameGroup(p,getPersonByName(other));
	}

	@Override
	public boolean isLandmarkEmpty(String landmark) {
		Landmark l = getLandmarkByName(landmark);
		return l.isEmpty();
	}

	@Override
	public boolean isAlone(String name) {
		Person p = getPersonByName(name);
		Landmark place = getLandmarkByName(p.getPlace());
		return place.isAlone(p);
	}

	@Override
	public void setAlone(String name) {
		Person p = getPersonByName(name);
		Landmark place = getLandmarkByName(p.getPlace());
		if(p instanceof ForgetfulPersonClass) {
			((ForgetfulPersonClass) p).setChangedGroup();
		}
		place.removePerson(p);
		place.addPersonToLandmark(p);
	}

	@Override
	public boolean gossipExists(String creator, String[] Targets, String description) {
		Person p = getPersonByName(creator);
		Person[] targets = ArrayStringToPerson(Targets);
		int i=0;
		while (i<gossips.size() && !gossips.get(i).isEqual(p, targets, description)) {
			i++;
		}
		return i!=gossips.size();
	}

	@Override
	public void createGossip(String creator, String[] Targets, String description) {
		Person p =  getPersonByName(creator);
		Person[] targets = ArrayStringToPerson(Targets);
		gossips.insertLast(new GossipClass(p, targets, description));
		p.addGossip(gossips.get(gossips.size()-1));
		if(p instanceof ForgetfulPersonClass) {
			removeOrModifyGossip(((ForgetfulPersonClass) p).getForgottenGossip(), p);
		}
	}

	@Override
	public boolean somethingToShare(String name) {
		Person p = getPersonByName(name);
		return p.somethingToShare();
	}

	@Override
	public boolean wantsToShare(String name) {
		Person p = getPersonByName(name);
		return p.wantsToshare();
	}

	@Override
	public Gossip[] shareGossipWithGroup(String name) {
		Person p = getPersonByName(name);
		Landmark l = getLandmarkByName(p.getPlace());
		Iterator<Person> it = l.listAllPersonsGroup(p);
		Gossip[] gossi = p.getGossipsToShare();
		while (it.hasNext()) {
			Person p_it = it.next();
			if(!p_it.getName().equals(name)) {
				for(int i=0;i<gossi.length;i++) {
					if(!p_it.hasGossip(gossi[i])) {
						p_it.addGossip(gossi[i]);
						if(p_it instanceof ForgetfulPersonClass) {
							removeOrModifyGossip(((ForgetfulPersonClass) p_it).getForgottenGossip(), p_it);
						}
						if(!(gossi[i].getCreatorName().equals(p_it.getName()))) {
							gossi[i].sharedWith(p_it);
						}
					}
				}
			}
		}
		return gossi;
		
	}
	
	/**
	 * este médodo vê se o gossip g é deferente de null,se não for vê se é para apagar o gossip esquecido da comunidade ou não
	 * @param g
	 * @param p
	 */
	private void removeOrModifyGossip(Gossip g,Person p) {
		if(g != null) {
			if(g.getCreatorName().equals(p.getName())) {
				if(!(g.getSharedWithSize()>0)) {
					gossips.removeAt(gossips.searchIndexOf(g));
				}
			}else {
				g.removeSharedWith(p);
			}
		}
	}

	@Override
	public boolean areThereGossipsAbout(String name) {
		int i=0;
		while (i<gossips.size() && !gossips.get(i).isTarget(name)) {
			i++;
		}
		return i!=gossips.size();
	}

	@Override
	public boolean hasGossips(String name) {
		Person p = getPersonByName(name);
		return p.getKnownGossips()>0;
	}

	@Override
	public boolean communityHasGossips() {
		return gossips.size()>0;
	}

	@Override
	public boolean communityHasSharedGossips() {
		int i=0;
		while (i<gossips.size() && !(gossips.get(i).getSharedTimes()>0)) {
			i++;
		}
		return i!=gossips.size();
	}
	
	/**
	 * @pre: personsExists(name) devolve true
	 * @param name
	 * @return a pessoa que tem o nome <name>
	 */
	private Person getPersonByName(String name) {
		int i=0;
		while (i<persons.size() && !persons.get(i).getName().equals(name)) {
			i++;
		}
		return persons.get(i);
	}
	
	/**
	 * @pre: landmarkExists(name) devolve true
	 * @param name
	 * @return a landmark que tem o nome <name>
	 */
	private Landmark getLandmarkByName(String name) {
		int i=0;
		while (i<landmarks.size() && !landmarks.get(i).getName().equals(name)) {
			i++;
		}
		return landmarks.get(i);
	}

	@Override
	public Iterator<Person> listAllPersonsGroup(String name) {
		Person P = getPersonByName(name);
		Landmark l = getLandmarkByName(P.getPlace());
		return l.listAllPersonsGroup(P);
	}

	@Override
	public void joinGroup(String name, String groupPerson) {
		Person P = getPersonByName(name);
		Person personGroup = getPersonByName(groupPerson);
		Landmark l = getLandmarkByName(P.getPlace());
		if(P instanceof ForgetfulPersonClass) {
			((ForgetfulPersonClass) P).setChangedGroup();;
		}
		l.removePerson(P);
		l.addPersonToGroup(P,personGroup);
	}

	@Override
	public Iterator<Group> listAllGroups(String place) {
		Landmark l = getLandmarkByName(place);
		return l.listAllGroups();
	}
	
	/**
	 * 
	 * @param Targets
	 * @return um array de pesosas com o mesmo tamanho do array <Targets>, a cada pessoa corresponde o nome no <Targets> 
	 */
	private Person[] ArrayStringToPerson(String[] Targets) {
		Person[] targets = new Person[Targets.length];
		for(int j=0;j<Targets.length;j++) {
			targets[j] = getPersonByName(Targets[j]);
		}
		return targets;
	}
	@Override
	public int getNrOfGroups(String place) {
		Landmark l = getLandmarkByName(place);
		return l.getNrOfGroups();
	}

	@Override
	public Iterator<Gossip> listAllGossipsAbout(String name) {
		Gossip[] go = new Gossip[gossips.size()];
		int size=0;
		for(int i=0;i<gossips.size();i++) {
			if(gossips.get(i).isTarget(name)) {
				go[size] = gossips.get(i);
				size++;
			}
		}
		return new ArrayIterator<>(go, size);
	}

	@Override
	public Iterator<Gossip> listAllKnownGossips(String name) {
		Person p = getPersonByName(name);
		return p.listAllKnownGossips();
	}

	@Override
	public Iterator<Gossip> listMostSharedGossips() {
		Gossip[] ranking = new Gossip[gossips.size()];
		int MaxShared=getMaxShared();
		MaxShared=gossips.get(0).getSharedTimes();
		int size=0;
		for(int i=0;i<gossips.size();i++) {
			if(MaxShared<=gossips.get(i).getSharedTimes()) {
				ranking[size]=gossips.get(i);
				size++;
			}
		}
		return new ArrayIterator<>(ranking, size);
	}
	
	/**
	 * 
	 * @return qual é o valor máximo de partilhas que um gossip tem
	 */
	private int getMaxShared() {
		int maxShared=gossips.get(0).getSharedTimes();
		for(int i=0;i<gossips.size();i++) {
			if(maxShared<=gossips.get(i).getSharedTimes()) {
				maxShared=gossips.get(i).getSharedTimes();
			}
		}
		return maxShared;
	}
}
