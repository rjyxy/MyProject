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
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -4535828020474116630L;

    private String id;
    private String name;
    private Address address;
}

