package com.spring.webmvc.springmvc.prac0714.repository;

import com.spring.webmvc.springmvc.prac0714.domain.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final JdbcTemplate template;


    @Override
    public boolean write(Content content) {
        String sql = "INSERT INTO board (board_no, writer, title, content)  VALUES (seq_board.nextval, ?, ?, ?)";

        return template.update(sql, content.getWriter(), content.getTitle(), content.getContent()) == 1;
    }


    @Override
    public boolean delete(int boardNum) {
        String sql = "DELETE FROM board WHERE board_no=?";

        return template.update(sql, boardNum) == 1;
    }


    @Override
    public boolean modify(Content content) {
        String sql = "UPDATE board SET writer = ?, title = ?, content = ? WHERE board_no = ?";

        return template.update(sql, content.getWriter(), content.getTitle(),
                                content.getContent(), content.getBoardNum()) == 1;
    }

    @Override
    public void upViewCount(int boardNum) {
        String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE board_no = ?";

        template.update(sql, boardNum);
    }


    @Override
    public List<Content> findAllContent() {
        String sql = "SELECT * FROM board ORDER BY board_no DESC";

        List<Content> contentList = template.query(sql, (rs, rowNum) -> new Content(rs));

        return contentList;
    }


    @Override
    public Content findOneContent(int boardNum) {
        String sql = "SELECT * FROM board WHERE board_no=?";

        Content content = template.queryForObject(sql, (rs, rowNum) -> new Content(rs), boardNum);

        return content;
    }

}
