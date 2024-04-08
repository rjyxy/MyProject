package top.yxy.boot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class SdCardValidator implements ConstraintValidator<SdCard,String> {
    private static final String REGEX_SDCARD = "\\d{17}[\\dxX]";


    @Override
    public void initialize(SdCard sdCard) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            //忽略空值，由@NoteBlank注解校验
            return true;
        }
        return Pattern.matches(REGEX_SDCARD,value);
    }
}
