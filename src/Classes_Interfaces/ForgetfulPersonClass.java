/**
*@author Miguel Cacais do Carmo
         *Esta classe extende a classe PersonAbstractClass
*/

package Classes_Interfaces;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.ArrayIterator;
import dataStructures.Iterator;

public class ForgetfulPersonClass extends PersonAbstractClass
{
	private static final int GOSSIP_SPREAD_RATE=1;
	
	private int nrGossips;
	private Array<Gossip> gossips;
	private boolean changedGroup;
	private Gossip GossipForgotten;
	private int nextToShare;
	
	
	public ForgetfulPersonClass(int nr_Gossips,String name) {
		super(name);
		gossips=new ArrayClass<>(nr_Gossips);
		this.nrGossips=nr_Gossips;
		changedGroup=true;
		nextToShare=-1;
	}
	
	@Override
	public int getKnownGossips() {
		return gossips.size();
	}
	
	@Override
	public void addGossip(Gossip gossip) {
		GossipForgotten=gossips.get(nrGossips-1);
		if (gossips.size()==0) {
			gossips.insertLast(gossip);
		}else if(gossips.size()==nrGossips){
			gossips.removeLast();
			gossips.insertAt(gossip,0);
		}else {
			gossips.insertAt(gossip,0);
		}

		if(nextToShare!=nrGossips-1) {
			nextToShare++;
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
		Gossip g;
		if(changedGroup) {
			nextToShare=gossips.size()-1;
			changedGroup=false;
			}
						
		g=gossips.get(nextToShare);
		nextToShare--;
		if(nextToShare==-1) {
			nextToShare=gossips.size()-1;
		}
		Gossip[] goss = new Gossip[GOSSIP_SPREAD_RATE];
		goss[0] = g;
		g.incrementSharedTimes();
		return goss;
	}
	
	@Override
	public Iterator<Gossip> listAllKnownGossips() {
		Gossip[] go = new Gossip[gossips.size()];
		for(int i=0;i<gossips.size();i++) {
			go[i]= gossips.get((nextToShare-i+gossips.size())%gossips.size());
		}
		return new ArrayIterator<>(go, gossips.size());
	}
	
	/**
	 * @pre: só pode ser utilizado se temos a certeza que a pessoa foi instanciada através do construtor da ForgetfullPersonClass 
	 * (p instanceof ForgetfullPersonClass devolve true)
	 * 
	 * este método é único desta classe, por isso é que não tem a tag override
	 * @return devolve o Gossip que foi esquecido pela pessoa
	 */
	public Gossip getForgottenGossip() {
		return GossipForgotten;
	}
	
	/**@pre: só pode ser utilizado se temos a certeza que a pessoa foi instanciada através do construtor da ForgetfullPersonClass 
	 * (p instanceof ForgetfullPersonClass devolve true)
	 * 
	 * este método é único desta classe, por isso é que não tem a tag override
	 */
	public void setChangedGroup() {
		changedGroup=true;
		
	}
	@Override
	public boolean hasGossip(Gossip g) {
		return gossips.searchForward(g);
	}
	
}
