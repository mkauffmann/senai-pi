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
		(1, 'Física I | Aulas USP', 
		'Canal USP gravou a disciplina ministrada por Marcelo Martinelli, livre-docente do Instituto de Física da USP no primeiro semestre de 2017.',
		'fisica.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values (1, 'Física I - Cinemática (Aula 1, parte 1)', 'Neste vídeo, o professor Marcelo Martinelli apresenta a primeira parte da aula "Cinemática".', 'trEe6t3-TL0');
insert into tb_aula (id_aula, nome, descricao, url_video) values (2, 'Cinemática (Aula 1, parte 2)', 'Neste vídeo, o professor Marcelo Martinelli apresenta a segunda parte da aula "Cinemática".', 'lKteBJOuwG0');
insert into tb_aula (id_aula, nome, descricao, url_video) values (3, 'Cinemática (Aula 1, parte 3)', 'Neste vídeo, o professor Marcelo Martinelli apresenta a terceira parte da aula "Cinemática".', '_xqUGSqSKvE');

insert into tb_curso_aula (id_curso, id_aula) values (1, 1);
insert into tb_curso_aula (id_curso, id_aula) values (1, 2);
insert into tb_curso_aula (id_curso, id_aula) values (1, 3);


-- 
insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(2, 'Química Geral e Inorgânica Básica | Aulas USP', 
		'Profª Dalva Lúcia A. de Faria faz a apresentação da Disciplina no Instituto de Química da USP, gravada durante o primeiro semestre de 2015, na USP, pela UnivespTV, da Fundação Padre Anchieta.',
		'quimica.jpg', '2015/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (4, 'Apresentação (Aula 01)', 
    'Neste vídeo, a Profª Dalva Lúcia A. de Faria faz a apresentação da Disciplina Química Geral e Inorgânica Básica, no Instituto de Química da USP.', 
    '_u8KnEOGpoU');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (5, 'Vidraria básica. Algarismos Significativos. Equações Químicas (Aula 2, parte 1)', 
    'A Profª Dalva Lúcia A. de Faria apresenta a primeira parte da aula "Vidraria básica. Algarismos Significativos. Equações Químicas", no Instituto de Química da USP.', 
    'luBpBItJZYs');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (6, 'Vidraria básica. Algarismos Significativos. Equações Químicas (Aula 2, parte 2)', 
    'A Profª Dalva Lúcia A. de Faria apresenta a segunda parte da aula "Vidraria básica. Algarismos Significativos. Equações Químicas", no Instituto de Química da USP.', 
    'BRnE9CWTmzQ');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (7, 'Vidraria básica. Algarismos Significativos. Equações Químicas (Aula 2, parte 3)', 
    'A Profª Dalva Lúcia A. de Faria apresenta a terceira parte da aula "Vidraria básica. Algarismos Significativos. Equações Químicas", no Instituto de Química da USP.', 
    'oXRtF5WAu9Q');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (8, 'Forças intermoleculares (Aula 23, parte 1)', 
    'aula "Forças intermoleculares: interações dipolo-dipolo, ligações dipolo-induzido, interações dipolo (forças de dispersão ou forças de London), íon-dipolo", no Instituto de Química da USP.', 
    'cifGCWpSXm8');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (9, 'Forças intermoleculares (Aula 23, parte 3)', 
    'aula "Forças intermoleculares: interações dipolo-dipolo, ligações dipolo-induzido, interações dipolo (forças de dispersão ou forças de London), íon-dipolo", no Instituto de Química da USP.', 
    'mOBtd7uhaUU');

insert into tb_curso_aula (id_curso, id_aula) values (2, 4);
insert into tb_curso_aula (id_curso, id_aula) values (2, 5);
insert into tb_curso_aula (id_curso, id_aula) values (2, 6);
insert into tb_curso_aula (id_curso, id_aula) values (2, 7);
insert into tb_curso_aula (id_curso, id_aula) values (2, 8);
insert into tb_curso_aula (id_curso, id_aula) values (2, 9);

--

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(3, 'Introdução à Ciência da Computação com Python', 
		'Aqui você irá aprender os principais conceitos introdutórios de Ciência da Computação e também aprenderá a desenvolver pequenos programas na linguagem Python. ',
		'programacao.jpg', '2019/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (10, 'O que é ciência da computação', 
    'Primeira aula do curso de introdução à ciência da computação com python.', 
    'rh65Lh5V7S0');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (11, 'Instalando o Python3 e o IDLE no Windows', 
    'Passo-a-passo de como instalar o Python3 e o IDLE no Windows.', 
    '1aUuW0aA7l0');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (12, 'Primeiras linhas em Python', 
    'Segunda aula do curso de introdução à ciência da computação com python.', 
    'LN8ejPwSzkU');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (13, 'Variáveis e scripts (programas) em Python', 
    'Terceira aula do curso de introdução à ciência da computação com python.', 
    'tqF0MjcOqcI');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (14, 'Valores e tipos em Python', 
    'Quarta aula do curso de introdução à ciência da computação com python.', 
    'UZ7_oudJ150');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (15, 'Entrada de dados', 
    'Quinta aula do curso de introdução à ciência da computação com python.', 
    'ECFj-bWzU8I');

insert into tb_curso_aula (id_curso, id_aula) values (3, 10);
insert into tb_curso_aula (id_curso, id_aula) values (3, 11);
insert into tb_curso_aula (id_curso, id_aula) values (3, 12);
insert into tb_curso_aula (id_curso, id_aula) values (3, 13);
insert into tb_curso_aula (id_curso, id_aula) values (3, 14);
insert into tb_curso_aula (id_curso, id_aula) values (3, 15);

-- 

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(4, 'História do Brasil Colonial I | Aulas USP', 
		'Profº João Paulo Garrido Pimenta, Faculdade de Filosofia, Letras e Ciências Humanas da USP. Gravado durante o primeiro semestre de 2014, na USP, pela UnivespTV, da Fundação Padre Anchieta.',
		'livro.jpg', '2014/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (16, 'América indígena (Aula 1, parte 1)', 
    'Neste vídeo, o Profº João Paulo Garrido Pimenta apresenta a primeira parte da aula "América Indígena", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    'kak6bsSB42s');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (17, 'América indígena (Aula 1, parte 2)', 
    'Neste vídeo, o Profº João Paulo Garrido Pimenta apresenta a segunda parte da aula "América Indígena", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    'pY6LEjfes50');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (18, 'América indígena (Aula 1, parte 3)', 
    'Neste vídeo, o Profº João Paulo Garrido Pimenta apresenta a terceira parte da aula "América Indígena", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    '14RoB4lgmS4');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (19, 'O imaginário da colonização (Aula 5, parte 1)', 
    'O Profº João Paulo Garrido Pimenta apresenta a primeira parte da aula "O imaginário da colonização", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    '4yTnkOlv75M');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (20, 'O imaginário da colonização (Aula 5, parte 2)', 
    'O Profº João Paulo Garrido Pimenta apresenta a segunda parte da aula "O imaginário da colonização", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    'fyyILYMH84g');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (21, 'O imaginário da colonização (Aula 5, parte 3)', 
    'O Profº João Paulo Garrido Pimenta apresenta a terceira parte da aula "O imaginário da colonização", na Faculdade de Filosofia, Letras e Ciências Humanas da USP.', 
    'DgV28DkMmr4');

insert into tb_curso_aula (id_curso, id_aula) values (4, 16);
insert into tb_curso_aula (id_curso, id_aula) values (4, 17);
insert into tb_curso_aula (id_curso, id_aula) values (4, 18);
insert into tb_curso_aula (id_curso, id_aula) values (4, 19);
insert into tb_curso_aula (id_curso, id_aula) values (4, 20);
insert into tb_curso_aula (id_curso, id_aula) values (4, 21);

-- 

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(5, 'Matemática Financeira e Introdução às Finanças', 
		'Prof. Dr. Adriano Azevedo Filho apresenta a primeira parte da aula "Introdução e Motivação", na Escola Superior de Agricultura Luiz de Queiroz da USP, gravadas durante o primeiro semestre de 2017.',
		'calculadora.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (22, 'Introdução e Motivação (Aula 01, parte 1)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a primeira parte da aula "Introdução e Motivação", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'l0rZRadylIQ');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (23, 'Introdução e Motivação (Aula 01, parte 2)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a segunda parte da aula "Introdução e Motivação", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'QgZKVkkTA9E');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (24, 'Introdução e Motivação (Aula 01, parte 3)', 
    'o Prof. Dr. Adriano Azevedo Filho apresenta a terceira parte da aula "Introdução e Motivação", na Escola Superior de Agricultura Luiz de Queiroz da USP.', 
    'xTYDPkCQ0Qo');

insert into tb_curso_aula (id_curso, id_aula) values (5, 22);
insert into tb_curso_aula (id_curso, id_aula) values (5, 23);
insert into tb_curso_aula (id_curso, id_aula) values (5, 24);

--

insert into tb_curso (id_curso, nome, descricao, url_capa, data_adicionado ) values 
		(6, 'Meio ambiente e sustentabilidade', 
		'Professor Responsável: Wellington Delitti
        Disciplina: Meio ambiente e sustentabilidade - (BES-001)
Curso de Licenciatura em Ciências e Matemática - Univesp - Universidade Virtual do Estado de São Paulo',
		'borboleta.jpg', '2017/02/03');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (25, 'Meio ambiente: Situação atual e perspectivas ', 
    'Meio ambiente e Sustentabilidade - Aula 01 - Meio ambiente: Situação atual e perspectivas - O papel do professor
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de São Paulo', 
    'q8dhQRjXJG4');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (26, 'Crise ambiental e sustentabilidade ', 
    'Meio ambiente e Sustentabilidade - Aula 02 - Meio ambiente: Situação atual e perspectivas - O papel do professor
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de São Paulo', 
    'qop11qf3tTs');

insert into tb_aula (id_aula, nome, descricao, url_video) values 
    (27, 'Educação ambiental: caminhos trilhados, mitos', 
    'Meio ambiente e Sustentabilidade - Aula 03 - Educação ambiental: caminhos trilhados, mitos e chavões
Curso de Licenciatura - Univesp - Universidade Virtual do Estado de São Paulo', 
    'sygBTa3SkDI');

insert into tb_curso_aula (id_curso, id_aula) values (6, 25);
insert into tb_curso_aula (id_curso, id_aula) values (6, 26);
insert into tb_curso_aula (id_curso, id_aula) values (6, 27);