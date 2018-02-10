create or replace view v_t_resource as
select s."ID",s."TYPE",s."AVAILABLE",s."DESCRIPT",s."ORDER_NUM",s."NAME",s."URL",s."TITLE",s."PARENT_ID",s."APP_ID",s."CLASSNAME",
       (select sys_connect_by_path(title, '/')
          from t_resource t
         where id = s.id
         start with parent_id is null
        connect by t.parent_id = prior id) path,
        (select Substr( sys_connect_by_path(t.order_num, '-'),2)
          from t_resource t
         where id = s.id
         start with parent_id is null
        connect by t.parent_id = prior id) order_num_all
  from T_RESOURCE s;