SELECT hospital_name, road_name_address FROM `sys`.nation_wide_hospital
where road_name_address like "경기도 수원시%"

SELECT * FROM `sys`.nation_wide_hospital
    where (hospital_name like '%피부%' and full_address like '%수원%') ;

SELECT business_type_name, hospital_name, road_name_address
    FROM `sys`.nation_wide_hospital
    where business_type_name in ('보건소', '보건지소')