/*
 * Copyright (c) 2022. Marc Kandel
 */

--
--

INSERT INTO users (username, email, displayname, active)
VALUES
    ('admin', 'admin@abc.com', 'Admin 1', 1),
    ('creator1', 'creator1@abc.com', 'Creator 1', 1),
    ('assigner1', 'assigner1@abc.com', 'Assigner 1', 1),
    ('user1', 'user1@abc.com', 'User 1', 1),
    ('user2', 'user2@abc.com', 'User 2', 1)
;

/*
4,ADMIN
3,ASSIGNER
2,CREATOR
1,USER
 */
INSERT INTO user_roles (user_id, role_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (2,2),
    (3,3),
    (4,1),
    (5,1),
    (5,2),
    (5,3)
;

/*
usergroup_role:
3,3
1,4
usergroup:
1,Group 1
2,Group 2
3,Group 3
4,Group 4
5,Group 5
 */
INSERT INTO user_usergroups (user, usergroup)
VALUES
    (1, 1)
;
