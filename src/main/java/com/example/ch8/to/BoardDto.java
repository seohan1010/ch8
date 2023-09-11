package com.example.ch8.to;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BoardDto {
  private Long bno;
  private String title;
  private String writer;
  private String content;
  private LocalDate writeDate;
  private LocalDate updateDate;
  private Long boardLike;


    public BoardDto() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(bno, boardDto.bno) && Objects.equals(title, boardDto.title) && Objects.equals(writer, boardDto.writer) && Objects.equals(content, boardDto.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, writer, content);
    }


    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", writeDate=" + writeDate +
                ", updateDate=" + updateDate +
                ", boardLike=" + boardLike +
                '}';
    }

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getWriteDate() {
        return writeDate;

    }

    public void setWriteDate(LocalDate writeDate) {
        this.writeDate = writeDate;
    }


    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Long getBoardLike() {
        return boardLike;
    }

    public void setBoardLike(Long boardLike) {
        this.boardLike = boardLike;
    }
}
