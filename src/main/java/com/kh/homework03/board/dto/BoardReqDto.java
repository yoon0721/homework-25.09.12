package com.kh.homework03.board.dto;

import com.kh.homework03.board.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardReqDto {

    private Long no;
    private String title;
    private String content;

    public static BoardReqDto from(BoardEntity entity){
        BoardReqDto reqDto = new BoardReqDto();
        reqDto.title = entity.getTitle();
        reqDto.content = entity.getContent();
        return reqDto;
    }

}
