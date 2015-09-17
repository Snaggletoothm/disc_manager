INSERT INTO user (name, password, email, state) VALUES ('maxim', '$2a$10$Qaf8Xzy5hqZs4MibTU0j8eRSMe9aFlo.oUSLrsi75JpTnwM/I0OvG', 'maxim@mail.ru', 'Active');
INSERT INTO user (name, password, email, state) VALUES ('aleksey', '$2a$10$Qaf8Xzy5hqZs4MibTU0j8eRSMe9aFlo.oUSLrsi75JpTnwM/I0OvG', 'aleksey@mail.ru', 'Active');
INSERT INTO user (name, password, email, state) VALUES ('viktor', '$2a$10$Qaf8Xzy5hqZs4MibTU0j8eRSMe9aFlo.oUSLrsi75JpTnwM/I0OvG', 'viktor@bk.com', 'Active');

INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'first blood', 1, 'drama', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'terminator', 1, 'fantasy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'avatar', 1, 'fantasy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'alien', 1, 'horror', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'solaris', 1, 'fantasy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (1, 'mars attacks', 1, 'comedy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'total recall', 1, 'thriller', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'robocop', 1, 'thriller', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'forest gamp', 1, 'melodrama', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'pandorum', 1, 'horror', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'one flew over the cuckoo s nest', 1, 'thriller', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'The Wolf', 1, 'drama', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (2, 'back to the future', 1, 'comedy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'mad max', 1, 'comedy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'save private Rian', 1, 'drama', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'Birds', 1, 'horror_test', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'Angels and Demons', 1, 'fantasy', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'Superman', 1, 'fantasy_test', 'something diecription about film', '');
INSERT INTO disc (user_id, title, owner, genre, description, tempOwnerName) VALUES (3, 'A beautiful mind', 1, 'drama', 'something diecription about film', '');

INSERT INTO user_profile(type) VALUES ('ADMIN');
INSERT INTO user_profile(type) VALUES ('USER');

INSERT INTO app_user_user_profile (user_id, user_profile_id) VALUES (1, 1);
INSERT INTO app_user_user_profile (user_id, user_profile_id) VALUES (1, 2);
INSERT INTO app_user_user_profile (user_id, user_profile_id) VALUES (2, 2);
INSERT INTO app_user_user_profile (user_id, user_profile_id) VALUES (3, 2);

INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (1, 'maxim', 'some comment for first blood from maxim', '2018-01-01');
INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (1, 'viktor', 'some comment for first blood: user from viktor', '2018-01-01');
INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (1, 'aleksey', 'some comment for first blood: user from aleksey', '2018-01-01');
INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (19, 'maxim', 'comment beautiful mind maxim', '2018-01-01');
INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (19, 'aleksey', 'comment beautiful mind aleksey', '2018-01-01');
INSERT INTO comment (disc_id, user_name, user_comment, local_date) VALUES (19, 'aleksey', ' second comment beautiful mind aleksey', '2018-01-01');