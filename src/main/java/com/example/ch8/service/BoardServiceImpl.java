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
//        return boardMapper.se
        return null;
    }

    @Override
    public List<BoardDto> findBoardDetail(String title) throws Exception {
        return null;
    }

    @Override
    public void updateBoard(BoardDto boardDto) throws Exception {

    }

    @Override
    public void deleteBoard(Long bno) throws Exception {

    }
}
