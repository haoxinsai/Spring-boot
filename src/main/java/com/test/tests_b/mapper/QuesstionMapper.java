package com.test.tests_b.mapper;


import com.test.tests_b.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuesstionMapper {
    @Insert("insert into quesstion (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void creat(Quesstion quesstion);
    @Select("select * from quesstion")
    List<Quesstion> list();
}
