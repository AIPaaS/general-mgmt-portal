/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/28 13:43:12                           */
/*==============================================================*/




alter table mgmt.sys_area
   add tenant_id varchar(64);

alter table mgmt.sys_log
   add tenant_id varchar(64);

alter table mgmt.sys_mdict
   add tenant_id varchar(64);

alter table mgmt.sys_menu
   add tenant_id varchar(64);

alter table mgmt.sys_office
   add tenant_id varchar(64);

   
alter table mgmt.sys_role
   add column effective_date datetime;

alter table mgmt.sys_role
   add column expiry_date datetime;   
   
alter table mgmt.sys_role
   add tenant_id varchar(64);

alter table mgmt.sys_user
   add tenant_id varchar(64);

alter table mgmt.sys_user
   add category char(1);

alter table mgmt.sys_user
   add address varchar(200);

alter table mgmt.sys_user
   modify column remarks varchar(1024);

alter table mgmt.sys_user
   add column effective_date datetime;

alter table mgmt.sys_user
   add column expiry_date datetime;