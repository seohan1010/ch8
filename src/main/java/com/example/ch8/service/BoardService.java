package com.example.ch8.service;

import com.example.ch8.to.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public abstract void registerBoard(BoardDto boardDto)throws  Exception;
    public abstract List<BoardDto> findBoardList()throws Exception;
    public abstract List<BoardDto> findBoardDetail(String title)throws Exception;
    public abstract void updateBoard(BoardDto boardDto)throws Exception;
    public abstract void deleteBoard(Long bno)throws Exception;

}
