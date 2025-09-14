package com.kh.homework03.board.service;

import com.kh.homework03.board.dto.BoardReqDto;
import com.kh.homework03.board.dto.BoardRespDto;
import com.kh.homework03.board.entity.BoardEntity;
import com.kh.homework03.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    // 등록 : 요청용 Dto -> 엔티티로 변환해서 DB에 저장
    public void register(BoardReqDto reqDto) {
        BoardEntity entity = BoardEntity.from(reqDto);
        repository.save(entity);
    }
    // 단건 조회 : 마찬가지로 엔티티 변환후 JPA finById로 번호로 찾고 .get은 옵션널 방지
    public BoardRespDto retrieve(Long no) {
        BoardEntity entity = repository.findById(no).get();
        return BoardRespDto.from(entity);
    }
    // 목록 조회 : DB에서 가져온 엔티티 -> 응답용 DTO로 변환하고 리스트 뽑음
    public List<BoardRespDto> retrieveList() {
        List<BoardEntity> entityList = repository.findAll();
        return entityList.stream().map(BoardRespDto::from).toList();
    }
    // 수정 : 요청용 Dto -> 게시글 번호 -> DB 조회, get으로 옵션널 방지
    public BoardRespDto modify(BoardReqDto reqDto) {
        BoardEntity entity = repository.findById(reqDto.getNo()).get();
        entity.update(reqDto); // 요청용 Dto에 수정
        return BoardRespDto.from(entity); // 요청용 Dto -> 응답용 Dto
    }
    // 삭제 : 마찬가지로 요청용 Dto -> 번호 입력으로 -> DB 조회 후 삭제, get으로 옵션널 방지
    public BoardRespDto remove(Long no) {
        BoardEntity entity = repository.findById(no).get();
        repository.delete(entity); // 물리 삭제할거면 DB에서 그냥 바로 삭제
        return BoardRespDto.from(entity);
    }

    // 그만하고 싶다..
    public List<BoardRespDto> searchByTitle(String title) {
        List<BoardEntity> entityList = repository.findByTitleContaining(title);
        return entityList.stream().map(BoardRespDto::from).toList();
    }

    public List<BoardRespDto> searchByContent(String content) {
        List<BoardEntity> entityList = repository.findByContentContaining(content);
        return entityList.stream().map(BoardRespDto::from).toList();
    }

}
