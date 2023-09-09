package com.example.ch8.mapper;

import com.example.ch8.to.BoardDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;


    @Test
    @BeforeEach
    public void testData()throws Exception{

        String title = "test title";
        String writer = "test writer";
        String content = "test content";

        for(int i=0;i<100;i++){

            BoardDto b = new BoardDto();
            b.setTitle(title+i);
            b.setWriter(writer+i);
            b.setContent(content+i);
            boardMapper.insertBoard(b);
        }

    }


    
    //테스트 성공
    @Test
    @DisplayName("board test")
    public void test(){

        System.out.println("boardMapper = " + boardMapper);
        
    }


    //테스트 성공
    @Test
    @DisplayName("insert-Test")
    public void insertTest()throws Exception{

       String title ="test title";
       String content ="test content";
       String writer = "test writer";


        BoardDto b = new BoardDto();
        b.setTitle(title);
        b.setWriter(content);
        b.setContent(writer);
        boardMapper.insertBoard(b);

    }


    //테스트 성공
    @Test
    @DisplayName("select-Test")
    public void selectTest()throws Exception{

    List<BoardDto> list= boardMapper.selectBoardList();

        assertNotNull(list);
        list.forEach(System.out::println);

    }


    //테스트 성공
    @Test
    @DisplayName("selectDetail-Test")
    public void selectDetailTest()throws Exception{

        Long bno = 5L;

        BoardDto board = boardMapper.selectBoardDetail(bno);
        assertNotNull(bno);
        System.out.println("board = " + board);

    }


    //테스트 성공
    @Test
    @DisplayName("update-Test")
    public void updateTest()throws Exception{

        Long bno= 5L;
        String title = "modified title";
        String writer = "modified writer";
        String contents = "modified contents";


        BoardDto b = new BoardDto();
        b.setBno(bno);
        b.setTitle(title);
        b.setWriter(writer);
        b.setContent(contents);
        boardMapper.updateBoard(b);
        BoardDto board = boardMapper.selectBoardDetail(bno);

        System.out.println("board = " + board);

    }


    //테스트 성공
    @Test
    @DisplayName("delete")
    public void deleteTest()throws Exception{

        Long bno = 5L;

        boardMapper.deleteBoard(bno);
       BoardDto b = boardMapper.selectBoardDetail(bno);
       assertNull(b);

    }
    
    
    
}