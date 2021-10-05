select * from all_tables;

drop table post;
select * from mem;
select * from brd;
create table brd(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
create table mem(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);

insert into mem values('qwe','1212','오이','USER');
insert into mem values('admin','1212','관리자','ADMIN');

insert into brd (id,title,writer,content) values(1,'제목','오이','글 내용');
