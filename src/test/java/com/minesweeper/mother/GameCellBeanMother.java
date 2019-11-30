package com.minesweeper.mother;

import static com.minesweeper.utils.TestConstants.COLUMNS;
import static com.minesweeper.utils.TestConstants.ROWS;

import com.minesweeper.bean.GameCellBean;
import com.minesweeper.enums.CellContent;
import com.minesweeper.enums.CellOperation;

public class GameCellBeanMother {
	public static GameCellBean.GameCellBeanBuilder mine() {
		return GameCellBean.builder()
				.row(ROWS)
				.column(COLUMNS)
				.cellContent(CellContent.MINE)
				.cellOperation(CellOperation.NONE);
	}
}
