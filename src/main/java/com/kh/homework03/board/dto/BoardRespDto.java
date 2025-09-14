package com.kh.homework03.board.dto;

import com.kh.homework03.board.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardRespDto {

    private Long no;
    private String title;
    private String content;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardRespDto from(BoardEntity entity){
        BoardRespDto respDto = new BoardRespDto();
        respDto.no = entity.getNo();
        respDto.title = entity.getTitle();
        respDto.content = entity.getContent();
        respDto.delYn = entity.getDelYn();
        respDto.createdAt = entity.getCreatedAt();
        respDto.updatedAt = entity.getUpdatedAt();

        return respDto;
    }

}
