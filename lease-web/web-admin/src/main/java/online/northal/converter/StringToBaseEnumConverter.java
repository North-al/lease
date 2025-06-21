package online.northal.converter;

import online.northal.enums.BaseEnum;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;


@Component
public class StringToBaseEnumConverter implements ConverterFactory<String, BaseEnum> {
    @NotNull
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(@NotNull Class<T> targetType) {
        return source -> {
            T[] enumConstants = targetType.getEnumConstants();
            if (source.isEmpty()) {
                return null;
            }

            for (T enumConstant : enumConstants) {
                if (enumConstant.getCode().equals(Integer.valueOf(source))) {
                    return enumConstant;
                }
            }

            throw new IllegalArgumentException(String.format("Enum type %s with code %s not found", targetType.getSimpleName(), source));
        };
    }
}
