package com.example.ch8.service;

import com.example.ch8.to.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public abstract void registerBoard(BoardDto boardDto)throws  Exception;
    public abstract List<BoardDto> findBoardList()throws Exception;
    public abstract BoardDto findBoardDetail(Long bno)throws Exception;
    public abstract void modifyBoard(Long boardIdx, BoardDto boardDto)throws Exception;
    public abstract void removeBoard(Long bno)throws Exception;

}
