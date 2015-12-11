select * from board;
insert into board values( board_no_seq.nextval,'제목입니다','내용입니다.',1,0,SYSDATE);
select * from member;
delete member where no=3;
insert into member values( 3,'홍길동','abcd','1234','male');
commit;

select a.no,a.title,a.member_no,b.name as member_name,a.view_cnt,to_char(a.reg_date,'yyyy-mm-dd hh:mi:ss') from board a,member b where a.member_no = b.no order by a.reg_date desc;
