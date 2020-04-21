package io.github.nisarg1184.spring.rest.properties;

import javax.validation.constraints.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("person")
@Validated
public class PersonProperties {
    /*
    * Person's first-name (person.firstname)
    * */
    @Pattern(regexp = "\\w+")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
