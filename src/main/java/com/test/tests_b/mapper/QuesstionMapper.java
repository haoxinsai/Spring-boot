package com.test.tests_b.mapper;


import com.test.tests_b.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuesstionMapper {
    @Insert("insert into quesstion (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void creat(Quesstion quesstion);
    @Select("select * from quesstion limit #{offset},#{size} ")
    List<Quesstion> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from  quesstion")
    Integer count();
    @Select("select * from quesstion where creator =  #{userid} limit #{offset},#{size} ")
    List<Quesstion> listByUserId(@Param(value = "userid")Integer userid, @Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from  quesstion where creator =  #{userid}")
    Integer countByUserId(@Param(value = "userid")Integer userid);
    @Select("select * from  quesstion where id =  #{id}")
    Quesstion getById(@Param(value = "id")Integer id);
}
