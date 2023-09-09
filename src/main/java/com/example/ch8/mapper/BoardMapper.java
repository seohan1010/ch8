package com.example.ch8.mapper;

import com.example.ch8.to.BoardDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

public abstract void insertBoard(BoardDto boardDto)throws Exception;

public abstract List<BoardDto> selectBoardList()throws Exception;


public abstract BoardDto selectBoardDetail(Long bno)throws Exception;

public abstract void updateBoard(BoardDto boardDto)throws Exception;

public abstract void deleteBoard(Long bno)throws Exception;



}
