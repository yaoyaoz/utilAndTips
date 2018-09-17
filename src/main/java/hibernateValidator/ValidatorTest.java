package hibernateValidator;

import org.hibernate.validator.constraints.NotBlank;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yaoyao on 2018/7/31.
 */
public class ValidatorTest {

    /**
     * 校验不为空的实现方法：
     * org.hibernate.validator.internal.constraintvalidators.NotNullValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Test
    public void testValidator() {
        try {
            Student student = new Student();
//            student.setName("小红");
            student.validateParams();
            System.out.println("校验通过");
        } catch (Exception e) {
            System.out.println("异常信息:" + e);
        }
    }

}

class Student {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validateParams() {
        //调用JSR303验证工具，校验参数
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Student>> violations = validator.validate(this);
        Iterator<ConstraintViolation<Student>> iter = violations.iterator();
        if (iter.hasNext()) {
            String errMessage = iter.next().getMessage();
            throw new ValidationException(errMessage);
        }
    }
}