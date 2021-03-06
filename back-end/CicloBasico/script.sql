use databasepi;
-- 
create table tb_aluno (
       id_aluno bigint not null auto_increment,
        email varchar(255) not null,
        nome varchar(255) not null,
        senha varchar(255) not null,
        primary key (id_aluno)
    );
    
    create table tb_aluno_curso (
       id_aluno bigint not null,
        id_curso bigint not null
    );
    
    create table tb_aula (
       id_aula bigint not null auto_increment,
        descricao varchar(255) not null,
        nome varchar(255) not null,
        url_video varchar(255) not null,
        primary key (id_aula)
    );
    
    create table tb_aula_comentario (
       id_aula bigint not null,
        id_comentario bigint not null
    );
    
    create table tb_comentario (
       id_comentario bigint not null auto_increment,
        conteudo varchar(255) not null,
        id_aluno bigint not null,
        primary key (id_comentario)
    );
    
    create table tb_curso (
       id_curso bigint not null auto_increment,
        data_adicionado date not null,
        descricao varchar(255) not null,
        nome varchar(255) not null,
        url_capa varchar(255) not null,
        primary key (id_curso)
    );
    
    create table tb_curso_aula (
       id_curso bigint not null,
        id_aula bigint not null
    ); 
    

    alter table tb_aluno 
       add constraint UK_83vpjsn4ih6eij9prsq3pqn3w unique (email);

    
    alter table tb_aluno_curso 
       add constraint FKacsy0tovwo1fp89fxedo2p8vx 
       foreign key (id_curso) 
       references tb_curso (id_curso);
    
    alter table tb_aluno_curso 
       add constraint FK4sx9dt4luejf5pjwhapsl9a4a 
       foreign key (id_aluno) 
       references tb_aluno (id_aluno);
    
    alter table tb_aula_comentario 
       add constraint FK410htuv1fd53ncda61n7s16og 
       foreign key (id_comentario) 
       references tb_comentario (id_comentario);

    alter table tb_aula_comentario 
       add constraint FKg69ircruob6amsykh3xn3ub6a 
       foreign key (id_aula) 
       references tb_aula (id_aula); 
    
    alter table tb_comentario 
       add constraint FKaas7fvu9ckeqyrbo6yiybkdk7 
       foreign key (id_aluno) 
       references tb_aluno (id_aluno);
    
    alter table tb_curso_aula 
       add constraint FKrddij4pcu1clgwfmkdjc5bx4h 
       foreign key (id_aula) 
       references tb_aula (id_aula);

    alter table tb_curso_aula 
       add constraint FKam2ofrphs58ua2vaeartk38os 
       foreign key (id_curso) 
       references tb_curso (id_curso);
-- 

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(1, 'F??sica I | Aulas USP', 
		'Canal USP gravou a disciplina ministrada por Marcelo Martinelli, livre-docente do Instituto de F??sica da USP no primeiro semestre de 2017.',
		'fisica.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values (1, 'F??sica I - Cinem??tica (Aula 1, parte 1)', 'Neste v??deo, o professor Marcelo Martinelli apresenta a primeira parte da aula "Cinem??tica".', 'trEe6t3-TL0');
insert into tb_aula (id_aula, nome, descricao, url_video) values (2, 'Cinem??tica (Aula 1, parte 2)', 'Neste v??deo, o professor Marcelo Martinelli apresenta a segunda parte da aula "Cinem??tica".', 'lKteBJOuwG0');
insert into tb_aula (id_aula, nome, descricao, url_video) values (3, 'Cinem??tica (Aula 1, parte 3)', 'Neste v??deo, o professor Marcelo Martinelli apresenta a terceira parte da aula "Cinem??tica".', '_xqUGSqSKvE');

insert into tb_curso_aula (id_curso, id_aula) values (1, 1);
insert into tb_curso_aula (id_curso, id_aula) values (1, 2);
insert into tb_curso_aula (id_curso, id_aula) values (1, 3);


-- 
insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(2, 'Qu??mica Geral e Inorg??nica B??sica | Aulas USP', 
		'Prof?? Dalva L??cia A. de Faria faz a apresenta????o da Disciplina no Instituto de Qu??mica da USP, gravada durante o primeiro semestre de 2015, na USP, pela UnivespTV, da Funda????o Padre Anchieta.',
		'quimica.jpg', '2015/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (4, 'Apresenta????o (Aula 01)', 
    'Neste v??deo, a Prof?? Dalva L??cia A. de Faria faz a apresenta????o da Disciplina Qu??mica Geral e Inorg??nica B??sica, no Instituto de Qu??mica da USP.', 
    '_u8KnEOGpoU');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (5, 'Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas (Aula 2, parte 1)', 
    'A Prof?? Dalva L??cia A. de Faria apresenta a primeira parte da aula "Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas", no Instituto de Qu??mica da USP.', 
    'luBpBItJZYs');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (6, 'Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas (Aula 2, parte 2)', 
    'A Prof?? Dalva L??cia A. de Faria apresenta a segunda parte da aula "Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas", no Instituto de Qu??mica da USP.', 
    'BRnE9CWTmzQ');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (7, 'Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas (Aula 2, parte 3)', 
    'A Prof?? Dalva L??cia A. de Faria apresenta a terceira parte da aula "Vidraria b??sica. Algarismos Significativos. Equa????es Qu??micas", no Instituto de Qu??mica da USP.', 
    'oXRtF5WAu9Q');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (8, 'For??as intermoleculares (Aula 23, parte 1)', 
    'aula "For??as intermoleculares: intera????es dipolo-dipolo, liga????es dipolo-induzido, intera????es dipolo (for??as de dispers??o ou for??as de London), ??on-dipolo", no Instituto de Qu??mica da USP.', 
    'cifGCWpSXm8');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (9, 'For??as intermoleculares (Aula 23, parte 3)', 
    'aula "For??as intermoleculares: intera????es dipolo-dipolo, liga????es dipolo-induzido, intera????es dipolo (for??as de dispers??o ou for??as de London), ??on-dipolo", no Instituto de Qu??mica da USP.', 
    'mOBtd7uhaUU');

insert into tb_curso_aula (id_curso, id_aula) values (2, 4);
insert into tb_curso_aula (id_curso, id_aula) values (2, 5);
insert into tb_curso_aula (id_curso, id_aula) values (2, 6);
insert into tb_curso_aula (id_curso, id_aula) values (2, 7);
insert into tb_curso_aula (id_curso, id_aula) values (2, 8);
insert into tb_curso_aula (id_curso, id_aula) values (2, 9);

--

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(3, 'Introdu????o ?? Ci??ncia da Computa????o com Python', 
		'Aqui voc?? ir?? aprender os principais conceitos introdut??rios de Ci??ncia da Computa????o e tamb??m aprender?? a desenvolver pequenos programas na linguagem Python. ',
		'programacao.jpg', '2019/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (10, 'O que ?? ci??ncia da computa????o', 
    'Primeira aula do curso de introdu????o ?? ci??ncia da computa????o com python.', 
    'rh65Lh5V7S0');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (11, 'Instalando o Python3 e o IDLE no Windows', 
    'Passo-a-passo de como instalar o Python3 e o IDLE no Windows.', 
    '1aUuW0aA7l0');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (12, 'Primeiras linhas em Python', 
    'Segunda aula do curso de introdu????o ?? ci??ncia da computa????o com python.', 
    'LN8ejPwSzkU');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (13, 'Vari??veis e scripts (programas) em Python', 
    'Terceira aula do curso de introdu????o ?? ci??ncia da computa????o com python.', 
    'tqF0MjcOqcI');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (14, 'Valores e tipos em Python', 
    'Quarta aula do curso de introdu????o ?? ci??ncia da computa????o com python.', 
    'UZ7_oudJ150');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (15, 'Entrada de dados', 
    'Quinta aula do curso de introdu????o ?? ci??ncia da computa????o com python.', 
    'ECFj-bWzU8I');

insert into tb_curso_aula (id_curso, id_aula) values (3, 10);
insert into tb_curso_aula (id_curso, id_aula) values (3, 11);
insert into tb_curso_aula (id_curso, id_aula) values (3, 12);
insert into tb_curso_aula (id_curso, id_aula) values (3, 13);
insert into tb_curso_aula (id_curso, id_aula) values (3, 14);
insert into tb_curso_aula (id_curso, id_aula) values (3, 15);

-- 

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(4, 'Hist??ria do Brasil Colonial I | Aulas USP', 
		'Prof?? Jo??o Paulo Garrido Pimenta, Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP. Gravado durante o primeiro semestre de 2014, na USP, pela UnivespTV, da Funda????o Padre Anchieta.',
		'livro.jpg', '2014/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (16, 'Am??rica ind??gena (Aula 1, parte 1)', 
    'Neste v??deo, o Prof?? Jo??o Paulo Garrido Pimenta apresenta a primeira parte da aula "Am??rica Ind??gena", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    'kak6bsSB42s');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (17, 'Am??rica ind??gena (Aula 1, parte 2)', 
    'Neste v??deo, o Prof?? Jo??o Paulo Garrido Pimenta apresenta a segunda parte da aula "Am??rica Ind??gena", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    'pY6LEjfes50');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (18, 'Am??rica ind??gena (Aula 1, parte 3)', 
    'Neste v??deo, o Prof?? Jo??o Paulo Garrido Pimenta apresenta a terceira parte da aula "Am??rica Ind??gena", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    '14RoB4lgmS4');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (19, 'O imagin??rio da coloniza????o (Aula 5, parte 1)', 
    'O Prof?? Jo??o Paulo Garrido Pimenta apresenta a primeira parte da aula "O imagin??rio da coloniza????o", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    '4yTnkOlv75M');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (20, 'O imagin??rio da coloniza????o (Aula 5, parte 2)', 
    'O Prof?? Jo??o Paulo Garrido Pimenta apresenta a segunda parte da aula "O imagin??rio da coloniza????o", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    'fyyILYMH84g');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (21, 'O imagin??rio da coloniza????o (Aula 5, parte 3)', 
    'O Prof?? Jo??o Paulo Garrido Pimenta apresenta a terceira parte da aula "O imagin??rio da coloniza????o", na Faculdade de Filosofia, Letras e Ci??ncias Humanas da USP.', 
    'DgV28DkMmr4');

insert into tb_curso_aula (id_curso, id_aula) values (4, 16);
insert into tb_curso_aula (id_curso, id_aula) values (4, 17);
insert into tb_curso_aula (id_curso, id_aula) values (4, 18);
insert into tb_curso_aula (id_curso, id_aula) values (4, 19);
insert into tb_curso_aula (id_curso, id_aula) values (4, 20);
insert into tb_curso_aula (id_curso, id_aula) values (4, 21);

-- 

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(5, 'Matem??tica Financeira e Introdu????o ??s Finan??as', 
		'Prof. Dr. Adriano Azevedo Filho apresenta a primeira parte da aula "Introdu????o e Motiva????o", na Escola Superior de Agricultura Luiz de Queiroz da USP, gravadas durante o primeiro semestre de 2017.',
		'calculadora.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (22, 'Introdu????o e Motiva????o (Aula 01, parte 1)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a primeira parte da aula "Introdu????o e Motiva????o", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'l0rZRadylIQ');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (23, 'Introdu????o e Motiva????o (Aula 01, parte 2)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a segunda parte da aula "Introdu????o e Motiva????o", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'QgZKVkkTA9E');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (24, 'Introdu????o e Motiva????o (Aula 01, parte 3)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a terceira parte da aula "Introdu????o e Motiva????o", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'xTYDPkCQ0Qo');

insert into tb_curso_aula (id_curso, id_aula) values (5, 22);
insert into tb_curso_aula (id_curso, id_aula) values (5, 23);
insert into tb_curso_aula (id_curso, id_aula) values (5, 24);

--

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(6, 'Meio ambiente e sustentabilidade', 
		'Professor Respons??vel: Wellington Delitti
        Disciplina: Meio ambiente e sustentabilidade - (BES-001)
Curso de Licenciatura em Ci??ncias e Matem??tica - Univesp - Universidade Virtual do Estado de S??o Paulo',
		'borboleta.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (25, 'Meio ambiente: Situa????o atual e perspectivas ', 
    'Meio ambiente e Sustentabilidade - Aula 01 - Meio ambiente: Situa????o atual e perspectivas - O papel do professor
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de S??o Paulo', 
    'q8dhQRjXJG4');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (26, 'Crise ambiental e sustentabilidade ', 
    'Meio ambiente e Sustentabilidade - Aula 02 - Meio ambiente: Situa????o atual e perspectivas - O papel do professor
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de S??o Paulo', 
    'qop11qf3tTs');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (27, 'Educa????o ambiental: caminhos trilhados, mitos', 
    'Meio ambiente e Sustentabilidade - Aula 03 - Educa????o ambiental: caminhos trilhados, mitos e chav??es
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de S??o Paulo', 
    'sygBTa3SkDI');

insert into tb_curso_aula (id_curso, id_aula) values (6, 25);
insert into tb_curso_aula (id_curso, id_aula) values (6, 26);
insert into tb_curso_aula (id_curso, id_aula) values (6, 27);