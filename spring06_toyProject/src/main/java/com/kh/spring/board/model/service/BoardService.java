package com.kh.spring.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.common.util.file.FileUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) //트랜잭션 관리
	public void insertBoard(List<MultipartFile> multiparts, Board board) {
		boardRepository.insertBoard(board);
		
		FileUtil util = new FileUtil();
		for (MultipartFile multipartFile : multiparts) {
			boardRepository.insertFileInfo(util.fileUpload(multipartFile)); //파일정보 집어넣기
		}
	}
	
}
