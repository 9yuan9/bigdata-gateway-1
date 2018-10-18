package com.weein.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * 类 名: TablePrefix<br/>
 * 描 述: 动态表查询,表名前缀注解<br/>
 * 作 者: 郭昕<br/>
 * 创 建： 2014-9-3<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TablePrefix {
	String value() default "";
}
