package com.cxm.mytinyurl.dao.mapper;

import com.cxm.mytinyurl.dao.domain.DbTinyUrl;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TinyUrlMapper {
  @Insert("INSERT INTO tb_tiny_url (tiny_url_slug, full_url) VALUES (#{tiny_url_slug}, #{full_url})")
  int insert(@Param("tiny_url_slug") String tinyUrlSlug, @Param("full_url") String fullUrl);

  @Select("SELECT * FROM tb_tiny_url WHERE tiny_url_slug = #{tiny_url_slug}")
  List<DbTinyUrl> findByTinyUrl(@Param("tiny_url_slug") String tinyUrlSlug);

  @Select("SELECT * FROM tb_tiny_url WHERE full_url = #{full_url}")
  List<DbTinyUrl> findByFullUrl(@Param("full_url") String fullUrl);
}
