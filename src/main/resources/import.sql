# Users
INSERT INTO users (username, password, enabled) VALUES ('admin', 'admin', true);
INSERT INTO users (username, password, enabled) VALUES ('user1', '12345', true);
INSERT INTO users (username, password, enabled) VALUES ('user2', '12345', true);
INSERT INTO users (username, password, enabled) VALUES ('user3', '12345', true);
INSERT INTO users (username, password, enabled) VALUES ('user4', '12345', true);

# Roles
INSERT INTO user_roles (username, role) VALUES ('admin','ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('user1','ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('user2','ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('user3','ROLE_NONE');
INSERT INTO user_roles (username, role) VALUES ('user4','ROLE_USER');