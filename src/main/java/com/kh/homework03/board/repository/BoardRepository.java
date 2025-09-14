package com.kh.homework03.board.repository;

import com.kh.homework03.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


    List<BoardEntity> findByTitleContaining(String title);

    List<BoardEntity> findByContentContaining(String content);


}
