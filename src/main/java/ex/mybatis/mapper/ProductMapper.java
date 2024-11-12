package ex.mybatis.mapper;

import ex.mybatis.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM PRODUCTS WHERE id = #{id}")
    Product getProduct(@Param("id") Long id);

    @Insert("INSERT INTO PRODUCTS (name, price, stock_quantity) VALUES (#{name}, #{price}, #{stockQuantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Product product);

    @Update("UPDATE PRODUCTS SET name = #{name}, price = #{price}, stock_quantity = #{stockQuantity} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM PRODUCTS WHERE id = #{id}")
    void delete(@Param("id") Long id);
}
