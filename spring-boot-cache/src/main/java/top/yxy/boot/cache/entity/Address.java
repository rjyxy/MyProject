package top.yxy.boot.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable{

    @Serial
    private static final long serialVersionUID = 3781546185454865110L;
    private String province;
    private String city;
}
