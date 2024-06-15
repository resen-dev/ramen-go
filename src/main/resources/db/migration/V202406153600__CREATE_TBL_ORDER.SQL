DROP TABLE IF EXISTS TBL_ORDER;

CREATE TABLE TBL_ORDER (
    id SERIAL PRIMARY KEY,
    id_protein BIGINT,
    id_broth BIGINT,
    CONSTRAINT fk_protein FOREIGN KEY (id_protein) REFERENCES tbl_protein(id),
    CONSTRAINT fk_broth FOREIGN KEY (id_broth) REFERENCES tbl_broth(id)
);
