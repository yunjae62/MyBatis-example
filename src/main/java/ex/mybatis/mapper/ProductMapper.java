package ex.mybatis.mapper;

import ex.mybatis.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM PRODUCTS WHERE id = #{id}")
    Product getProduct(@Param("id") Long id);

    @Insert("INSERT INTO PRODUCTS (name, price, stock_quantity) VALUES (#{name}, #{price}, #{stockQuantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Product product);
}
