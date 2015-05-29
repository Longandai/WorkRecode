-- Create table
create table UP_MENU_EXT
(
  ID        VARCHAR2(32),
  EXT_ATTR1 VARCHAR2(32),
  EXT_ATTR2 VARCHAR2(32)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column UP_MENU_EXT.ID
  is '菜单ID';
comment on column UP_MENU_EXT.EXT_ATTR1
  is '扩展属性1';
comment on column UP_MENU_EXT.EXT_ATTR2
  is '扩展属性2';