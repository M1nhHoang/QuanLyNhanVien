create database QuanLiNhanVien
go
use QuanLiNhanVien

create table loaiNhanVien
(
	idNv int identity not null primary key,
	loaiNv nvarchar(50) not null,
)
go

create table nhanVien
(
	idNv int not null,
	maNv int identity(1,1) not null,
	tenNV nvarchar(200) not null,
	ngaySinh date not null,
	gioiTinh nvarchar(7) not null,
	ngayVaoCoQuan date not null,
	soCMND varchar(10) not null,
	heSoLuong float not null,
	primary key(idNv, maNv),
)
go

alter table nhanVien
	add constraint FK_idNv_nhanVien foreign key (idNv) references loaiNhanVien(idNv)
		on delete 
			cascade
		on update
			cascade
go

insert into loaiNhanVien
values
	(N'Nhân viên hợp đồng'),
	(N'Nhân viên biên chế')
go

insert into nhanVien
values
	(1, N'Nhân Viên 1', '1-11-2002', N'Nam', '01-01-1999', '999999999', 1.0),
	(2, N'Nhân Viên 2', '1-11-2002', N'Nữ', '01-01-1999', '999999999', 1.0)
go

update nhanVien 
set tenNV = '11123'
where maNv = 11
delete from nhanVien where maNv = 11
select * from nhanVien