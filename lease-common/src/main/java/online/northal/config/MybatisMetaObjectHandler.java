package online.northal.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createdAt = getFieldValByName("createTime", metaObject);
        Object updatedAt = getFieldValByName("updateTime", metaObject);

        if (createdAt == null) this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        if (updatedAt == null) this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
