-- 22.07.17 실습-게시판에 기능 추가 ( 댓글 기능 )
DROP TABLE comments;
CREATE TABLE comments (
    board_no NUMBER(10)
    , writer VARCHAR2(20) NOT NULL
    , content VARCHAR2(2000) NOT NULL
    , reg_date DATE DEFAULT SYSDATE
    , like_cnt NUMBER(5) DEFAULT 0
    , CONSTRAINT pk_comments PRIMARY KEY (writer)
);

ALTER TABLE comments
ADD CONSTRAINT fk_board_no
FOREIGN KEY (board_no)
REFERENCES board (board_no) ON DELETE CASCADE;

commit;

SELECT * FROM comments;