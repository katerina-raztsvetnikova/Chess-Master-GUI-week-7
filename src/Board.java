
public class Board {
	public String color;
	public boolean clicked;
	
	public Board(){
		color = null;
		clicked = false;
	}
	
	public Board(String c) {
		color = c;
		if(c != null)
			clicked= true;
		else
			clicked = false;
	}
	

}
