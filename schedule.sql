CREATE TABLE schedule(
    id BIGINT AUTO_INCREMENT
        PRIMARY KEY
        COMMENT '일정 고유식별자',
    authorId BIGINT
         COMMENT '작성자 고유식별자',
    taskTitle VARCHAR(50)
        NOT NULL
        COMMENT '일정 제목',
    taskContent VARCHAR(200)
         NOT NULL
         COMMENT '일정 내용',
    postDate TIMESTAMP
         DEFAULT CURRENT_TIMESTAMP
         COMMENT '작성일시',
    updateDate TIMESTAMP
         DEFAULT CURRENT_TIMESTAMP
         ON UPDATE CURRENT_TIMESTAMP
        COMMENT '최종 수정일시',
                         FOREIGN KEY(authorId) references author(id)
                             ON DELETE CASCADE
                             ON UPDATE CASCADE
);

CREATE TABLE author(
    id BIGINT AUTO_INCREMENT
         PRIMARY KEY
         COMMENT '작성자 고유식별자',
    authorName VARCHAR(20)
       NOT NULL
       COMMENT '이름',
    email TEXT
       NOT NULL
       COMMENT '이메일',
    password VARCHAR(30)
       NOT NULL
       COMMENT '비밀번호',
    postDate TIMESTAMP
       DEFAULT CURRENT_TIMESTAMP
       COMMENT '등록일',
    updateDate TIMESTAMP
       DEFAULT CURRENT_TIMESTAMP
       ON UPDATE CURRENT_TIMESTAMP
         COMMENT '수정일'
);