package com.kh.homework03.board.api;

import com.kh.homework03.board.dto.BoardReqDto;
import com.kh.homework03.board.dto.BoardRespDto;
import com.kh.homework03.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    // 등록 ~~
    @PostMapping
    public ResponseEntity<String> register(@RequestBody BoardReqDto reqDto){
        service.register(reqDto);
        return ResponseEntity.ok("등록되었습니다.");
    }
    // 단건 조회 ~~
    @GetMapping("{no}")
    public ResponseEntity<BoardRespDto> retrieve(@PathVariable Long no){
        BoardRespDto respDto = service.retrieve(no);
        return ResponseEntity.ok(respDto);
    }
    // 목록 조회 ~~
    @GetMapping
    public ResponseEntity<List<BoardRespDto>> retrieveList(){
        List<BoardRespDto> respDto = service.retrieveList();
        return ResponseEntity.ok(respDto);
    }
    // 수정 ~~
    @PutMapping
    public ResponseEntity<BoardRespDto> modify(@RequestBody BoardReqDto reqDto){
        BoardRespDto respDto = service.modify(reqDto);
        return ResponseEntity.ok(respDto);
    }
    // 삭제 ~~
    @DeleteMapping("{no}")
    public ResponseEntity<BoardRespDto> remove(@PathVariable Long no){
        service.remove(no);
        return ResponseEntity.ok().build();
    }

    // 제목으로 검색
    @GetMapping("search/title")
    public ResponseEntity<List<BoardRespDto>> searchByTitle (@RequestParam String title){
        List<BoardRespDto> titleList = service.searchByTitle(title);
        return ResponseEntity.ok(titleList);
    }
    // 내용으로 검색
    @GetMapping("search/content")
    public ResponseEntity<List<BoardRespDto>> searchByContent (@RequestParam String content){
        List<BoardRespDto> contentList = service.searchByContent(content);
        return ResponseEntity.ok(contentList);
    }



}
