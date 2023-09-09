package com.example.ch8.service;


import com.example.ch8.mapper.BoardMapper;
import com.example.ch8.to.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;


    @Override
    public void registerBoard(BoardDto boardDto) throws Exception {
                 boardMapper.insertBoard(boardDto);
    }

    @Override
    public List<BoardDto> findBoardList() throws Exception {
              List<BoardDto> list = boardMapper.selectBoardList();
        return list;
    }

    @Override
    public BoardDto findBoardDetail(Long bno) throws Exception {
        BoardDto board = boardMapper.selectBoardDetail(bno);
        return board;
    }

    @Override
    public void modifyBoard(Long boardIdx,BoardDto boardDto) throws Exception {
       BoardDto board = boardMapper.selectBoardDetail(boardIdx);
       board.setTitle(boardDto.getTitle());
       board.setContent(boardDto.getContent());
       boardMapper.updateBoard(board);
    }

    @Override
    public void removeBoard(Long bno) throws Exception {
        boardMapper.deleteBoard(bno);
    }
}
