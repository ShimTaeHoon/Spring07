package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

// 스프링 컨테이너 환경을 불러오는 기능
@SpringBootTest
public class BoardRepositoryTest {

	// 컨테이너 안에 있는 리파지토리 빈 주입
	@Autowired
	BoardRepository repository;
	
	@Test // 단위테스트
	void 리파지토리빈_확인() {
		System.out.println("repository:" + repository);
	}
	
	@Test
	void 게시물등록() {
		
		Board board = Board.builder()
						   .title("3번글")
						   .content("내용입니다")
						   .writer("둘리")
						   .build();
		
		// tbl_board 테이블에 데이터 등록하기
		repository.save(board);
		
	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		for(Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	void 게시물단건조회() {
		Optional<Board> op = repository.findById(2);
		System.out.println(op);
		
	}
	
	@Test
	void 게시물수정() {
		
		Optional<Board> op = repository.findById(2);
		Board board = op.get();
		board.setTitle("제목을 변경합니다");
		repository.save(board);
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteById(2);
	}
	
}
