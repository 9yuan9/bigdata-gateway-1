package com.weein.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * 类 名: Required<br/>
 * 描 述: 用于声明类属性不允许为空的注解类<br/>
 * 作 者: guoxin<br/>
 * 创 建： 2013-10-12<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Required {

}
