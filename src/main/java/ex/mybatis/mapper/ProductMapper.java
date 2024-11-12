package ex.mybatis.mapper;

import ex.mybatis.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM PRODUCTS WHERE id = #{id}")
    Product getProduct(@Param("id") Long id);
}
