package cblog.annotation;

import java.lang.annotation.*;

/**
 * Created by chenchicheng on 17-9-20.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@org.springframework.stereotype.Repository
public @interface Repository {

    /**
     * Repository在spring容器中的实例名称
     */
    String value() default "";

    /**
     * Repository处理的实体类
     */
    Class<?> entity();
}
