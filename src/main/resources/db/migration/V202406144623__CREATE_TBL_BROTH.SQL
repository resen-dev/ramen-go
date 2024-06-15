DROP TABLE IF EXISTS TBL_BROTH;

CREATE TABLE TBL_BROTH (
    id SERIAL PRIMARY KEY,
    image_inactive VARCHAR(255),
    image_active VARCHAR(255),
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2)
);

INSERT INTO TBL_BROTH (image_inactive, image_active, name, description, price)
VALUES
    ('https://tech.redventures.com.br/icons/shoyu/inactive.svg', 'https://tech.redventures.com.br/icons/shoyu/active.svg', 'Shoyu', 'A clear broth seasoned with soy sauce, giving it a salty and savory flavor.', 12.50),
    ('https://tech.redventures.com.br/icons/shio/inactive.svg', 'https://tech.redventures.com.br/icons/shio/active.svg', 'Shio', 'A clear broth seasoned with salt, providing a lighter and cleaner taste compared to soy sauce-based broths.', 11.75),
    ('https://tech.redventures.com.br/icons/tonkotsu/inactive.svg', 'https://tech.redventures.com.br/icons/tonkotsu/active.svg', 'Tonkotsu', 'A creamy, rich broth made by boiling pork bones (usually trotters and marrow bones) for several hours.', 14.25),
    ('https://tech.redventures.com.br/icons/miso/inactive.svg', 'https://tech.redventures.com.br/icons/miso/active.svg', 'Miso', 'A hearty broth made with fermented soybean paste (miso), adding a robust and slightly tangy flavor.', 13.00),
    ('https://tech.redventures.com.br/icons/shoyu-tonkotsu/inactive.svg', 'https://tech.redventures.com.br/icons/shoyu-tonkotsu/active.svg', 'Shoyu-Tonkotsu', 'A combination of soy sauce and pork bone broth, blending the umami richness of both elements.', 15.50),
    ('https://tech.redventures.com.br/icons/shio-tonkotsu/inactive.svg', 'https://tech.redventures.com.br/icons/shio-tonkotsu/active.svg', 'Shio-Tonkotsu', 'A blend of salt and pork bone broth, offering a lighter yet flavorful alternative to the traditional tonkotsu.', 14.00),
    ('https://tech.redventures.com.br/icons/vegetable/inactive.svg', 'https://tech.redventures.com.br/icons/vegetable/active.svg', 'Vegetable Broth', 'A broth made primarily from vegetables such as kombu (kelp), shiitake mushrooms, carrots, and onions.', 12.75),
    ('https://tech.redventures.com.br/icons/chicken/inactive.svg', 'https://tech.redventures.com.br/icons/chicken/active.svg', 'Chicken (Tori)', 'A clear and light broth made by simmering chicken bones along with aromatics like ginger and garlic.', 11.50),
    ('https://tech.redventures.com.br/icons/spicy/inactive.svg', 'https://tech.redventures.com.br/icons/spicy/active.svg', 'Spicy Broth (Kara)', 'Any of the above broths made spicy by adding chili paste, chili oil, or other spicy ingredients.', 13.25);
