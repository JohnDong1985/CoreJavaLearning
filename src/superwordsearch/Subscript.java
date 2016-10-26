package superwordsearch;

public class Subscript {
	private int row;
	private int col;

	public Subscript(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	//add wrap if is wrap mode
	public void wrap(int rowNum, int colNum) {
		while (row < 0)
			row += rowNum;
		while (col < 0)
			col += colNum;
		row = row % rowNum;
		col = col % colNum;
	}

	//return the subscript by direction and target word's char index
	public Subscript getSubscript(Direction direction, int index) throws Exception {
		Subscript subscript = null;
		switch (direction) {
		case TB:
			subscript = new Subscript(row + index, col);
			break;
		case BT:
			subscript = new Subscript(row - index, col);
			break;
		case LR:
			subscript = new Subscript(row, col + index);
			break;
		case RL:
			subscript = new Subscript(row, col - index);
			break;
		case BLTR:
			subscript = new Subscript(row - index, col + index);
			break;
		case BRTL:
			subscript = new Subscript(row - index, col - index);
			break;
		case TLBR:
			subscript = new Subscript(row + index, col + index);
			break;
		case TRBL:
			subscript = new Subscript(row + index, col - index);
			break;
		default:
			throw new Exception("No such direction");
		}
		return subscript;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Subscript subscript = (Subscript) o;

		if (col != subscript.col)
			return false;
		if (row != subscript.row)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = row;
		result = 31 * result + col;
		return result;
	}

	@Override
	public String toString() {
		return "(" + this.row + ", " + this.col + ")";
	}
}
