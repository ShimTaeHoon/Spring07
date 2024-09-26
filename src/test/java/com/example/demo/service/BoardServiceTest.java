package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;

@SpringBootTest // 스프링 컨테이너 환경을 임시로 생성
public class BoardServiceTest {

	@Autowired // 컨테이너에서 빈 주입받기
	BoardService service;
	
	@Test
	public void 빈이주입되었는지확인() {
		System.out.println("service:" + service);
	}
	
	@Test
	public void 게시물등록() {
		
		BoardDTO dto = BoardDTO.builder()
								.title("1번글")
								.content("내용입니다")
								.writer("둘리")
								.build();
	
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
		
	}
	
	@Test
	public void 게시물수정() {
		
		BoardDTO dto = service.read(1);
		
		dto.setContent("수정");
		
		service.modify(dto);
		
	}
	
}
