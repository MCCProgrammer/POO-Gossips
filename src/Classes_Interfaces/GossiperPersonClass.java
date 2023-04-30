/**
*@author Miguel Cacais do Carmo
         *Esta classe extende a PersonAbstractClass
*/


package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class GossiperPersonClass extends PersonAbstractClass{
	
	private static final int GOSSIP_SPREAD_RATE=3;
	
	private int insertAt;
	
	private Array<Gossip> gossips;
	
	public GossiperPersonClass(String name) {
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
		return true;
	}

	@Override
	public Gossip[] getGossipsToShare() {
		int toShare;
		if(this.getKnownGossips()>3) {
			toShare=GOSSIP_SPREAD_RATE;
		}else {
			toShare=getKnownGossips();
		}
		Gossip[] goss = new Gossip[toShare];
		for(int i=0;i<goss.length;i++) {
			Gossip g = gossips.get(0);
			goss[i]=g;
			gossips.removeAt(0);
			gossips.insertLast(g);
			gossips.get(gossips.size()-1).incrementSharedTimes();
			insertAt++;
			if(insertAt==gossips.size()) {
				insertAt=0;
			}
		}
		return goss;
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
