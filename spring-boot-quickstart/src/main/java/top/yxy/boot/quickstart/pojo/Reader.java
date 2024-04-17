package top.yxy.boot.quickstart.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator

 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements Serializable {
    private String name;
    private Integer age;
}
