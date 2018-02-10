--------------------------------
--  Changed table t_resource  --
--------------------------------
-- Add/modify columns 
alter table T_RESOURCE add classname VARCHAR2(32);
-- Add comments to the columns 
comment on column T_RESOURCE.classname
  is 'css名称';
---------------------------------
--  New table t_user_resource  --
---------------------------------
-- Create table
create table T_USER_RESOURCE
(
  user_id     VARCHAR2(32) not null,
  resource_id VARCHAR2(32) not null,
  order_num   NUMBER not null
);
-- Add comments to the table 
comment on table T_USER_RESOURCE
  is '用户资源对照表';
-- Add comments to the columns 
comment on column T_USER_RESOURCE.user_id
  is '用户ID';
-- Create/Recreate indexes 
create index IND_USERID on T_USER_RESOURCE (USER_ID);
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USER_RESOURCE
  add constraint PK_USER__RESOURCE primary key (USER_ID, RESOURCE_ID, ORDER_NUM)
  using index ;
