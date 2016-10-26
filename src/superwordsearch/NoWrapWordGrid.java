package superwordsearch;

public class NoWrapWordGrid extends WordGrid {
	public NoWrapWordGrid(Character[][] charArr) {
		super(charArr);
	}

	@Override
	public Character getCharBySubscript(Subscript subscript) {
		if (subscript.getRow() >= 0 && subscript.getRow() < this.getRowNum() && subscript.getCol() >= 0
				&& subscript.getCol() < this.getColNum()) {
			return this.getCharArr()[subscript.getRow()][subscript.getCol()];
		} else {
			return null;
		}
	}
}
