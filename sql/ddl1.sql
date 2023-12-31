CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    nickname VARCHAR(128),
    gender TINYINT, -- 0: Female, 1: Male
    old INTEGER,    -- 1: old
    profile_img VARCHAR(128),
    id VARCHAR(128),
    password VARCHAR(128)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS marimos (
    marimo_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    user_id INTEGER,
    deco1 INTEGER,
    deco2 INTEGER,
    deco3 INTEGER,
    emotion INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS marimo_data (
    data_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimo_id INTEGER,
    stat1 INTEGER,
    stat2 INTEGER,
    stat3 INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimo_id) REFERENCES marimos(marimo_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS log1 (
    log_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimo_id INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimo_id) REFERENCES marimos(marimo_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS log2 (
    log_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimo_id INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimo_id) REFERENCES marimos(marimo_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS log3 (
    log_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marimo_id INTEGER,
    timestamp DATETIME,
    FOREIGN KEY (marimo_id) REFERENCES marimos(marimo_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS boards (
    board_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER,
    content VARCHAR(256),
    img VARCHAR(64),
    create_time DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS comments (
    comment_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER,
    board_id INTEGER,
    content VARCHAR(256),
    create_time DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (board_id) REFERENCES boards(board_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS partners (
    partner_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id1 INTEGER,
    user_id2 INTEGER,
    FOREIGN KEY (user_id1) REFERENCES users(user_id),
    FOREIGN KEY (user_id2) REFERENCES users(user_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS friends (
    friend_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id1 INTEGER,
    user_id2 INTEGER,
    FOREIGN KEY (user_id1) REFERENCES users(user_id),
    FOREIGN KEY (user_id2) REFERENCES users(user_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS diseases (
    disease_id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(64)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS disease_users (
    relation_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER,
    disease_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (disease_id) REFERENCES diseases(disease_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS records (
    record_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sender_id INTEGER,
    receiver_id INTEGER,
    url VARCHAR(255),
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
