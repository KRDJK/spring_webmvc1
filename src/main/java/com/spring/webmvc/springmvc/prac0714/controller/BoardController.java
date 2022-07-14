package com.spring.webmvc.springmvc.prac0714.controller;

import com.spring.webmvc.springmvc.prac0714.domain.Content;
import com.spring.webmvc.springmvc.prac0714.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;


    // 게시판 목록 화면 요청
    @GetMapping("/list")
    public ModelAndView list() {
        log.info("목록 화면 요청이 들어옴!");

        List<Content> contentList = service.listService();

        ModelAndView mv = new ModelAndView("/prac0714/board-list");
        mv.addObject(contentList);

        return mv;
    }


    // 게시판 목록 상세조회 요청
    @GetMapping("/content")
    public String detail(int boardNum, Model model) {
        log.info("{}번 게시글 상세조회 요청이 들어옴!", boardNum);

        Content content = service.detailService(boardNum);

        model.addAttribute("c", content);

        return "prac0714/board-detail";
    }


    // 게시판 글 등록 화면 요청
    @GetMapping("/write")
    public String form() {
        log.info("글 등록 화면 요청이 들어옴!");

        return "prac0714/board-write";
    }


    // 게시판 글 작성 후 등록 요청
    @PostMapping("/write")
    public String register(Content content) {
        log.info("작성된 게시글 등록 요청!!" + content);

        return service.writeService(content) ? "redirect:/board/list" : "redirect:/board/write";
    }
    
    
    // 게시판 글 삭제 요청
    @GetMapping("/delete")
    public String delete(int boardNum) {
        log.trace("{}번 게시글 삭제 요청이 들어옴!", boardNum);

        service.deleteService(boardNum);

        return "redirect:/board/list";
    }


    // 게시판 글 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(int boardNum, Model model) {
        log.trace("{}번 게시글 수정 화면 요청이 들어옴!", boardNum);

        Content content = service.detailService(boardNum);

        model.addAttribute("c", content);

        return "prac0714/board-modify";
    }


    // 게시판 글 수정 후 반영 요청
    @PostMapping("/modify")
    public String modify(Content content) {
        log.trace("게시글 수정 완료 후 반영 요청이 들어옴" + content);

        service.modifyService(content);

        return "redirect:/board/content?boardNum=" + content.getBoardNum();
    }


} // end controller
