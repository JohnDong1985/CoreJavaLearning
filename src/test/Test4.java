package test;

public class Test4 {
	public enum Direction {
		NORTH,
		NORTHEAST,
		EAST,
		SOUTHEAST,
		SOUTH,
		SOUTHWEST,
		WEST,
		NORTHWEST
	}
	
	public static void main(String[] args) {
		for(Direction direction : Direction.values()){
			if(direction.equals(Direction.SOUTH)){
				System.out.println("I'm SOUTH");
			}else{
				System.out.println("direction");
			}
		}
	}
}

//Direction.values()
//direction.equals(Direction.SOUTH)
