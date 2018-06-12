package com.mingo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:mingo
 * Date:2018/5/25 11:13
 * Description:姓名校验器
 */
public class NameValidator implements ConstraintValidator<NameValid, String> {

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[\\u4E00-\\u9FA5a-zA-Z]+$"
    );


    @Override
    public void initialize(NameValid nameValid) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null||s.equals("")){
            return false;
        }
        Matcher m = NAME_PATTERN.matcher(s);
        return m.matches();
    }
}
