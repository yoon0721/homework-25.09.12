package com.kh.homework03.board.entity;

import com.kh.homework03.board.dto.BoardReqDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false,length = 20)
    private String title;
    @Column(nullable = false,length = 50)
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String delYn;

    public static BoardEntity from(BoardReqDto reqDto){
        BoardEntity entity = new BoardEntity();
        entity.title = reqDto.getTitle();
        entity.content = reqDto.getContent();
        return entity;
    }

    public BoardEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    public void update(BoardReqDto reqDto) {
        title = reqDto.getTitle();
        content = reqDto.getContent();
        updatedAt = LocalDateTime.now();
    }

    public void delete(BoardEntity entity) {
        delYn = "Y";
        updatedAt = LocalDateTime.now();
    }
}
