package SangSongV3;

import java.util.*;

public class Search {
	List<State> Open;
	List<State> Closed;
	State start;
	State goal;
	Random rand=new Random();
	
	public static void main(String [] args){
		new Search();
	}
	
	public Search(){
		Open=new ArrayList<State>();
		Closed=new ArrayList<State>();
		start=new State(3,3,0);
		goal=new State(3,3,1);
		//Buoc 1: Cho Start vao Open
		Open.add(start);
		//Buoc 2:
		boolean searchOK=false;
		while(Open.size()>0){
			//Buoc 3: Lay dinh dau O
			State O=Open.remove(0);
			Closed.add(O);
			//Buoc 4
			if (Compare(O,goal)){
				searchOK=true;
				goal=O;
				break;
			}
			//Buoc 5
			List<State> children=O.Children();
			for (int i=0;i<children.size();i++){
				State child=children.get(i);
				if (!In(child,Open) && !In(child,Closed))
					Open.add(rand.nextInt(Open.size()+1),child);
			}
			//Buoc 6:
		}
		
		if (searchOK){
			Print(goal);
			System.out.println(goal.getString());
		}
			
		
	}
	private void Print(State g) {
		if (g.fatherState!=null){
			Print(g.fatherState);
			System.out.println(g.fatherState.getString());
			System.out.println(g.fatherOp.getString());
			
		}
		
	}
	private boolean In(State child, List<State> list) {
		for (int i=0;i<list.size();i++){
			if (Compare(child, list.get(i))) return true;
		}
		return false;
	}
	private boolean Compare(State o, State g) {
		if (o.n==g.n && o.q==g.q && o.t==g.t) return true;
		return false;
	}

}
