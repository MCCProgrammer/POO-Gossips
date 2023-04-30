/**
*@author Miguel Cacais do Carmo
         *Esta classe extende a PersonAbstractClass
*/

package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class SealedPersonClass extends PersonAbstractClass{
	
	private static final int GOSSIP_SPREAD_RATE=1;
	
	
	
	private Array<Gossip> gossips;
	private int insertAt;
	
	public SealedPersonClass(String name) {
		super(name);
		gossips=new ArrayClass<>();
		insertAt=0;
	}
		
	@Override
	public int getKnownGossips() {
		return gossips.size();
	}


	@Override
	public void addGossip(Gossip gossip) {
		if(insertAt==0) {
			gossips.insertLast(gossip);
		}else {
			gossips.insertAt(gossip, gossips.size()-insertAt);
		}
	}

	@Override
	public boolean somethingToShare() {
		return gossips.size()>0;
	}

	@Override
	public boolean wantsToshare() {
		int i=0;
		while (i<gossips.size() && !gossips.get(i).isTarget(this.getName())) {
			i++;
		}
		return i!=gossips.size();
	}

	@Override
	public Gossip[] getGossipsToShare() {
		Gossip[] goss = new Gossip[GOSSIP_SPREAD_RATE];
		Gossip g = gossips.get(0);
		goss[0]=g;
		gossips.removeAt(0);
		gossips.insertLast(g);
		gossips.get(gossips.size()-1).incrementSharedTimes();
		insertAt++;
		if(insertAt==gossips.size()) {
			insertAt=0;
		}
		if(goss[0].isTarget(this.getName())){
			return goss;
		}else {
			return getGossipsToShare();
		}
	}
	
	@Override
	public Iterator<Gossip> listAllKnownGossips() {
		return gossips.iterator();
	}
	@Override
	public boolean hasGossip(Gossip g) {
		return gossips.searchForward(g);
	}
	
}
