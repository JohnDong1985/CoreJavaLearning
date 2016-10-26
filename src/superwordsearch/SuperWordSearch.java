package superwordsearch;

import java.util.ArrayList;
import java.util.List;

public class SuperWordSearch {
	public enum Mode {
		WRAP, NO_WRAP
	}

	private WordGrid grid;

	//init function
	public SuperWordSearch(int rowNum, int colNum, Mode mode, String... strings) throws Exception {
		final Character[][] charArr;
		charArr = new Character[rowNum][colNum];
		for (int i = 0; i < rowNum; i++) {
			charArr[i] = toBoxedCharArray(strings[i].toCharArray());
		}
		switch (mode) {
		case NO_WRAP:
			grid = new NoWrapWordGrid(charArr);
			break;
		case WRAP:
			grid = new WrapWordGrid(charArr);
			break;
		default:
			throw new Exception("No such mode");
		}
	}

	private static Character[] toBoxedCharArray(char[] chars) {
		Character[] charArr = new Character[chars.length];
		for (int i = 0; i < chars.length; i++) {
			charArr[i] = chars[i];
		}
		return charArr;
	}
	
	//main search function
	public List<Subscript> search(String targetWord) throws Exception {
		final Character[][] charArr = grid.getCharArr();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr[i].length; j++) {
				Subscript subscript = new Subscript(i, j);
				List<Subscript> list = singleSearch(subscript, targetWord);
				if (list != null)
					return list;
			}
		}
		return null;
	}

	private List<Subscript> singleSearch(final Subscript s, final String targetWord) throws Exception {
		char[] targetArr = targetWord.toCharArray();
		for (Direction direction : Direction.values()) {
			List<Subscript> result = new ArrayList<Subscript>();
			for (int i = 0; i < targetArr.length; i++) {
				Subscript subscript = s.getSubscript(direction, i);
				Character charArr = grid.getCharBySubscript(subscript);
				if (charArr == null)
					break;
				if (result.contains(subscript))
					break;
				if (charArr == targetArr[i])
					result.add(subscript);
			}
			if (result.size() == targetArr.length)
				return result;
		}
		return null;
	}
}
