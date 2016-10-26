package superwordsearch;

public class WrapWordGrid extends WordGrid {
	public WrapWordGrid(Character[][] charArr) {
		super(charArr);
	}

	@Override
	public Character getCharBySubscript(Subscript subscript) {
		subscript.wrap(this.getRowNum(), this.getColNum());
		return this.getCharArr()[subscript.getRow()][subscript.getCol()];
	}

}
