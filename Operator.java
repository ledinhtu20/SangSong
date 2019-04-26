package SangSongV3;

public class Operator {
	public int num;
	public Operator(int num){
		this.num=num;
	}
	
	public State move(State s){
		switch(num){
		//2 nguoi qua song
		case 1:if (s.n>=2) return new State(5-s.n, 3-s.q, 1-s.t);break;
		//2 quy qua song
		case 2:if (s.q>=2) return new State(3-s.n, 5-s.q, 1-s.t);break;
		//1n 1q qua song
		case 3:if (s.n>=1 && s.q>=1) return new State(4-s.n, 4-s.q, 1-s.t);break;
		//1 nguoi qua song
		case 4:if (s.n>=1) return new State(4-s.n, 3-s.q, 1-s.t);break;
		//2 quy qua song
		case 5:if (s.q>=1) return new State(3-s.n, 4-s.q, 1-s.t);break;
 		}
		return null;
	}
	public String getString(){
		switch(num){
		case 1: return "2 nguoi qua song";
		case 2: return "2 quy qua song";
		case 3: return "1n 1q qua song";
		case 4: return "1 nguoi qua song";
		case 5: return "1 quy qua song";
		}
		return "";
	}
}
