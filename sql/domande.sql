create table domande
(
    id              bigint auto_increment
        primary key,
    book_title      text   null,
    testo           text   null,
    answer_type     text   null,
    risposta_esatta text   null,
    spiegazione     text   null,
    chapter         int    null,
    question        int    null,
    book_id         bigint null
);
