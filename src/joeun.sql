select * from test;
select * from tabs;
select * from TEST;

drop table te;
drop table customer;
drop table mem cascade constraint;
drop table seller;

select * from tabs;
drop table dep;
drop table test;

create table game(
	id varchar2(20) primary key,
	passwd varchar2(20) not null
);

create table game2(
	id varchar2(20) primary key,
	score int 
);

insert into game2 values('1','10');


select * from game;
select * from game2;





drop table game2;

select * from game;

select * from dbtest;
insert into dbtest values('aaa', '111', 'ȫ�浿' , '1111-2222','�����');
insert into dbtest values('bbb', '111', '������' , '1111-3333','�����');
insert into dbtest values('ccc', '111', '�̼���' , '1111-4444','������');
insert into dbtest values('ddd', '111', '������' , '1111-5555','��õ��');
insert into dbtest values('eee', '111', '������' , '1111-2666','�Ȼ��');
commit

create table game{
	id varchar2(20) primary key,
	passwd varchar2(20) not null,
	score number(4)
};