package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정정보
//@Component 를 찾아서 자동으로 bean 등록 해줌
@ComponentScan (
        //@Configuration 이미 붙인건 제외하겠다는 뜻(이미 등록 되어있어서)
        //실무에서는 제외 안하고 그냥 사용
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
