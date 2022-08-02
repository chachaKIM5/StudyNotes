package com.test.spring;

import java.util.List;

public interface BoardService {

	int add(BoardDTO dto);

	List<BoardDTO> list();

	BoardDTO view(String seq);

}
