package top.yxy.boot.quickstart.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"content","title"})
public class Article {
    @JsonIgnore
    private Long id;

    @JsonProperty("author")
    private String author;

    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> readerList;
}
