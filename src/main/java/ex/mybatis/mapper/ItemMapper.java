package ex.mybatis.mapper;

import ex.mybatis.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("name") String name);

    Optional<Item> findById(Long id);
}
