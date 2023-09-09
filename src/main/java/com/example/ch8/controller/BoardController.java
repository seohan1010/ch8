package com.example.ch8.controller;

import com.example.ch8.service.BoardService;
import com.example.ch8.to.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;


    @RequestMapping(value="/board",method=RequestMethod.POST)
    public void registerBoard(BoardDto boardDto)throws Exception{
        boardService.registerBoard(boardDto);
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public List<BoardDto> findBoardList()throws Exception{
                List<BoardDto> boardList = boardService.findBoardList();
                return boardList;
    }

    @RequestMapping(value="/detail/{bno}",method=RequestMethod.GET)
    public BoardDto findBoardDetail(@PathVariable("bno") Long bno)throws Exception{
               BoardDto board = boardService.findBoardDetail(bno);
               return board;
    }


    @RequestMapping(value="/board/{bno}",method=RequestMethod.PUT)
    public void modifyBoard(@PathVariable("bno") Long boardIdx, BoardDto boardDto)throws Exception{
        boardService.modifyBoard(boardIdx ,boardDto);
    }

    @RequestMapping(value="/board/{bno}",method=RequestMethod.DELETE)
    public void removeBoard(@PathVariable("bno") Long bno)throws Exception{
        boardService.removeBoard(bno);
    }
}
