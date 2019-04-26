package SangSongV3;

import java.util.*;

public class State {
	//n: so nguoi phia thuyen
	//q: so quy phia thuyen
	//t: vi tri thuyen; 0:trai, 1:phai
	public int n,q,t;
	State fatherState;
	Operator fatherOp;
	public State(int n,int q,int t){
		this.n=n;
		this.q=q;
		this.t=t;
	}
	
	public String getString(){
		if (t==0) 
			return n+","+q+"t-----"+(3-n)+","+(3-q);
		else 
			return (3-n)+","+(3-q)+"-----t"+n+","+q;
	}
	
	boolean checkOK(){
		if ((n==1 || n==2) && n!=q) return false;
		return true;
	}
	
	public List<State> Children(){
		List<State> r=new ArrayList<State>();
		for (int i=1;i<=5;i++){
			Operator op=new Operator(i);
			State child=op.move(this);
			if (child!=null && child.checkOK()){
				r.add(child);
				child.fatherState=this;
				child.fatherOp=op;
			}
		}	
		return r;
	}
}
