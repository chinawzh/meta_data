package sunbeam.base.metadata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName BizData
 * @Author 王兆辉
 * @Date 2022/4/9 23:24
 * @Version 1.0
 * @Description
 */
@Data
@Table(name = "v_biz_data")
@EqualsAndHashCode(callSuper = false)
public class BizData {

    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "form_code")
    private String formCode;

    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "attr_code")
    private String attrCode;

    @Column(name = "data_value")
    private String dataValue;
}
