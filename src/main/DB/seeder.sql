USE pet_lister;
DESCRIBE users;

INSERT INTO users(username,email, password) VALUES
        ('johnnyboy','johnnyB@gmail.com','letmein'),
        ('amandaf','amandarocks@yahoo.com','letmein'),
        ('sergiol','sergioboss@aol.com','letmein'),
        ('patrickc','mastapatrick@yahoo.com','letmein');

DESCRIBE ads;
INSERT INTO ads(title, description, user_id,date) VALUES
('Black labrador', 'He is the bestest boy ever', 2, now());

# INSERT INTO pet_type(dog, cat, reptile, bird, fish, ads_id) VALUES
# ('L')



