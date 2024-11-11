package day37.Anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示着我们的注解可以写在方法上面，其他地方不能写
@Target(ElementType.METHOD)
// 表示着我们的注解可以在任意时期都存在
// 如果写Source，那么只能在源码阶段存在，利用反射无法解析
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {

}
