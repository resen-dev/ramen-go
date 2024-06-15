DROP TABLE IF EXISTS TBL_PROTEIN;

CREATE TABLE TBL_PROTEIN (
    id SERIAL PRIMARY KEY,
    image_inactive VARCHAR(255),
    image_active VARCHAR(255),
    image_ramen VARCHAR(255),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2)
);

INSERT INTO TBL_PROTEIN (image_inactive, image_active, image_ramen, name, description, price)
VALUES
    ('https://tech.redventures.com.br/icons/pork/inactive.svg', 'https://tech.redventures.com.br/icons/pork/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenChashu.png', 'Chashu', 'Slices of braised or roasted pork belly or pork loin. Chashu is a classic and popular topping in many ramen varieties.', 12.50),
    ('https://tech.redventures.com.br/icons/pork/inactive.svg', 'https://tech.redventures.com.br/icons/pork/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenKakuni.png', 'Kakuni', 'Cubes of braised pork belly, often simmered in soy sauce, mirin, and sugar until tender and flavorful.', 11.75),
    ('https://tech.redventures.com.br/icons/pork/inactive.svg', 'https://tech.redventures.com.br/icons/pork/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenNegiToro.png', 'Negi Toro', 'Minced or ground pork, typically seasoned and cooked with soy sauce and other seasonings.', 10.25),
    ('https://tech.redventures.com.br/icons/chicken/inactive.svg', 'https://tech.redventures.com.br/icons/chicken/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenChickenChashu.png', 'Chicken Chashu', 'Similar to pork chashu but made with chicken breast or thigh meat, often marinated and roasted.', 12.00),
    ('https://tech.redventures.com.br/icons/shrimp/inactive.svg', 'https://tech.redventures.com.br/icons/shrimp/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenShrimp.png', 'Shrimp', 'Grilled, poached, or fried shrimp, sometimes seasoned with garlic or other spices.', 13.50),
    ('https://tech.redventures.com.br/icons/beef/inactive.svg', 'https://tech.redventures.com.br/icons/beef/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenBeef.png', 'Beef', 'Slices of beef (often thinly sliced and quickly cooked in the hot broth), or occasionally braised beef slices.', 14.00),
    ('https://tech.redventures.com.br/icons/tofu/inactive.svg', 'https://tech.redventures.com.br/icons/tofu/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenTofu.png', 'Tofu', 'Cubes of tofu, either fried or soft, adding a vegetarian protein option to ramen.', 11.75),
    ('https://tech.redventures.com.br/icons/egg/inactive.svg', 'https://tech.redventures.com.br/icons/egg/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenEgg.png', 'Egg (Ajitsuke Tamago)', 'Soft-boiled or marinated eggs with a custard-like yolk. These are a common topping in ramen.', 10.50),
    ('https://tech.redventures.com.br/icons/seafood/inactive.svg', 'https://tech.redventures.com.br/icons/seafood/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenSeafood.png', 'Seafood', 'Various seafood options like clams, mussels, or fish cakes (narutomaki) are occasionally used in seafood-based ramen.', 13.25),
    ('https://tech.redventures.com.br/icons/vegetarian/inactive.svg', 'https://tech.redventures.com.br/icons/vegetarian/active.svg', 'https://tech.redventures.com.br/icons/ramen/ramenVegetarian.png', 'Vegetarian/Vegan Options', 'Beyond tofu, ramen can include various plant-based proteins such as seitan, tempeh, or plant-based meat alternatives.', 12.75);
