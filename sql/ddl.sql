CREATE TABLE IF NOT EXISTS users (
    userId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    nickname VARCHAR(128),
    gender TINYINT, -- 0: Female, 1: Male
    old INTEGER,    -- 1: old
    profileImg VARCHAR(128),
    Id VARCHAR(128),
    password VARCHAR(128)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS marimos (
    marimoId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INTEGER,
    deco1 INTEGER,
    deco2 INTEGER,
    deco3 INTEGER,
    emotion INTEGER,
    FOREIGN KEY (userId) REFERENCES users(userId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS marimodata (
    dataId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimoId INTEGER,
    stat1 INTEGER,
    stat2 INTEGER,
    stat3 INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimoId) REFERENCES marimos(marimoId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS log1 (
    logId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimoId INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimoId) REFERENCES marimos(marimoId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS log2 (
    logId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimoId INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimoId) REFERENCES marimos(marimoId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS log3 (
    logId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimoId INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimoId) REFERENCES marimos(marimoId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS boards (
    boardId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INTEGER,
    content VARCHAR(256),
    img VARCHAR(64),
    createTime DATETIME,
    FOREIGN KEY (userId) REFERENCES users(userId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS comments (
    commentId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INTEGER,
    boardId INTEGER,
    content VARCHAR(256),
    createTime DATETIME,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (boardId) REFERENCES boards(boardId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS partners (
    partnerId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId1 INTEGER,
    userId2 INTEGER,
    FOREIGN KEY (userId1) REFERENCES users(userId),
    FOREIGN KEY (userId2) REFERENCES users(userId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS friends (
    friendId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId1 INTEGER,
    userId2 INTEGER,
    FOREIGN KEY (userId1) REFERENCES users(userId),
    FOREIGN KEY (userId2) REFERENCES users(userId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS diseases (
    diseaseId INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(64)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS diseaseUsers (
    relationId INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INTEGER,
    diseaseId INTEGER,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (diseaseId) REFERENCES diseases(diseaseId)
)DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO diseases (diseaseId, name) VALUES
(1, '치매'),
(2, '파킨슨 병'),
(3, '결장, 직장암'),
(4, '간암'),
(5, '요추, 추간판 장애'),
(6, '당뇨병'),
(7, '무릎관절증'),
(8, '고혈압성 질환'),
(9, '대뇌혈관 질환'),
(10, '기관지, 폐암'),
(11, '위염'),
(12, '치아 및 지지구조 질환'),
(13, '급성 기관지염'),
(14, '기타');