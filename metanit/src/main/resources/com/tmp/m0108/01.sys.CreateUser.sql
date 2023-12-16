// https://www.youtube.com/watch?v=lw_gny4zoEI

alter session set "_ORACLE_SCRIPT" = true; // Без этой команды не получится следующая (в версиях, начиная с 12c изменился концепт про пользователей).
CREATE USER test001 identified by 111;

// Может SYS и SYSMAN
grant create session to test001;
grant create table to test001;
