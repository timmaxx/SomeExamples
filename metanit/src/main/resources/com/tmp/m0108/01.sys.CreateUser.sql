// https://www.youtube.com/watch?v=lw_gny4zoEI

alter session set "_ORACLE_SCRIPT" = true; // ��� ���� ������� �� ��������� ��������� (� �������, ������� � 12c ��������� ������� ��� �������������).
CREATE USER test001 identified by 111;

// ����� SYS � SYSMAN
grant create session to test001;
grant create table to test001;
