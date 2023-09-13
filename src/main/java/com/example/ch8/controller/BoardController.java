package com.example.ch8.controller;

import com.example.ch8.service.BoardService;
import com.example.ch8.to.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;


    // try catch로 잡아서 예외가 발생하지 않으면은 200번 코드를 반환
    // 예외가 발생하면은 적절한 에러코드를 반환

    @RequestMapping(value="/board",method=RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerBoard(@RequestBody BoardDto boardDto)throws Exception{

        try {
            boardService.registerBoard(boardDto);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value="/list",method= RequestMethod.GET)
    public ResponseEntity<List<BoardDto>> findBoardList()throws Exception{
                List<BoardDto> boardList = boardService.findBoardList();
                System.out.println("request has been arrived");
                try{
                    if(boardList.size()==0)
                        throw new Exception("no data exception");
                        return new ResponseEntity<List<BoardDto>>(boardList,HttpStatus.OK); // 200번 코드

                }catch(Exception e){
                    e.printStackTrace();
                }

                return new ResponseEntity<List<BoardDto>>(boardList,HttpStatus.OK); // 400번 코드

    }




    @RequestMapping(value="/board/{bno}",method=RequestMethod.GET)
    public ResponseEntity<BoardDto> findBoardDetail(@PathVariable("bno") Long bno)throws Exception{
               BoardDto board = boardService.findBoardDetail(bno);

               try{
                   if(board==null)
                        throw new Exception("no data exception");
                        return new ResponseEntity<BoardDto>(board,HttpStatus.OK); // 200번 코드
               }catch(Exception e){
                   e.printStackTrace();
               return new ResponseEntity<BoardDto>(board,HttpStatus.BAD_REQUEST); // 400번 에러코드
               }

    }


    @RequestMapping(value="/board/{bno}",method=RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyBoard(@PathVariable("bno") Long bno,@RequestBody BoardDto boardDto)throws Exception{

        boardService.modifyBoard(bno ,boardDto);
       BoardDto board = boardService.findBoardDetail(bno);
        if(board.getTitle().equals(boardDto.getTitle())&&board.getContent().equals(boardDto.getContent())){
                return new ResponseEntity<HttpStatus>(HttpStatus.CREATED); // 201번 코드
        }else{
                return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST); // 400번 코드
        }
    }


    @RequestMapping(value="/board/{bno}",method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeBoard(@PathVariable("bno") Long bno)throws Exception {

        boardService.removeBoard(bno);
        if (boardService.findBoardDetail(bno) == null) {
            return new ResponseEntity<HttpStatus>(HttpStatus.OK); // 200번 코드
        } else {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST); // 400번 코드
        }
    }
}
