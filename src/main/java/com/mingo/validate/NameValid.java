package com.mingo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Author:mingo
 * Date:2018/5/25 11:09
 * Description:自定义注解实现id校验
 */
@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameValid {
    String message() default "{param_invalid}"; //防止忘记传值
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}