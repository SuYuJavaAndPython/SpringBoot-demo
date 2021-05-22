package com.xingyu.test;

import com.xingyu.bean.Guest;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DataValidationTest {

    /**
     * validator实例工具有两种校验模式：
     *  普通模式：遍历校验所有bean
     *  快速失败模式：遍历到第一个不满足要求的bean即结束
     * @NotNull 不能为null，但可以为empty
     *
     * @NotEmpty 不能为null，而且长度必须大于0
     *
     * @NotBlank 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
     * @param args
     */
    public static void main(String[] args) {
        //通过Validation创建一个validator实例工具用于校验数据   （普通模式）
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Guest guest = new Guest("", "");
        Set<ConstraintViolation<Guest>> violationSet = validator.validate(guest);
        for(ConstraintViolation<Guest> violation : violationSet){
            System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
        }

        System.out.println("========================");

        //快速失败模式
        Validator validator1 = Validation.byDefaultProvider().configure()
                .addProperty("hibernate.validator.fail_fast","true").buildValidatorFactory().getValidator();
        Set<ConstraintViolation<Guest>> violationSet1 = validator1.validate(guest);
        for(ConstraintViolation<Guest> violation : violationSet1){
            System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
        }
    }
}
