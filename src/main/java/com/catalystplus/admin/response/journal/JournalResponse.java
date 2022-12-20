package com.catalystplus.admin.response.journal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.subject.SubjectSimpleResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/10/2 14:27
 * @Version 1.1
 */
@ToString
@Data
@ApiModel("期刊信息通用响应")
public class JournalResponse implements Serializable {

    private static final long serialVersionUID = -1418217707640656576L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("表序列，除了查找文献以外，其他都用这个这个id")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("真实唯一journalId，查找文献用这个id")
    private Long journalId;

    /**
     * ISBN编号, 国际标准书号
     */
    private String isbn;

    /**
     * ISSN编号, 标准国际刊号，对外宣称的
     */
    private String issnL;

    /**
     * 带横杠版的issn，对外宣称的
     */
    private String issnPrimaryFormattedL;

    /**
     * ISSN(打印版编号)
     */
    private String issnPrint;

    /**
     * 带横杠版的ISSN(打印版编号)
     */
    private String issnPrintPrimaryFormatted;

    /**
     * ISSN(网络版编号)
     */
    private String issnOnline;

    /**
     * 带横杠版的ISSN(网络版编号)
     */
    private String issnOnlinePrimaryFormatted;

    /**
     * 期刊名字, en_name:英文名
     */
    private String enName;

    /**
     * 期刊名字, cn_name:中文名
     */
    private String chName;

    /**
     * 期刊描述
     */
    private String enDescription;

    /**
     * 期刊描述，中文描述
     */
    private String chDescription;

    /**
     * 封面图片地址链接
     */
    private String cover;

    /**
     * 封面图片base64数据
     */
    private String coverBase64;

    /**
     * 期刊关联subject主题表,
     */
    private Long subjectId;

    /**
     * 关联publisher出版商表
     */
    private Long publisherId;

    /**
     * 期刊的名字
     */
    private String publisherName;

    /**
     * 出版商的详细信息页链接
     */
    private String informationPageUrl;

    /**
     * 期刊影响因子
     */
    private Double impactFactor;

    /**
     * 是否为顶刊，0不是顶刊，1是顶刊
     */
    private Integer top;

    /**
     * 是否为开放性访问，0表示不行，1表示行
     */
    private Integer openAccess;

    /**
     * 是否为综述性期刊，0表示不是，1表示是
     */
    private Integer review;

    /**
     * Area Quartile in Category分区，1为一区，2为二区，3为三区，4为四区，以Area分区为标准
     */
    private Integer quartile;

    /**
     * Subject Quartile in Category分区，1为一区，2为二区，3为三区，4为四区
     */
    private Integer subQuartile;


    /**
     * 下面字段需要手动设置值
     */

    /**
     * 今日期刊订阅数
     */
    @ApiModelProperty("今日期刊订阅数")
    private Long todaySubscription;

    /**
     * 截至今日期刊订阅数
     */
    @ApiModelProperty("截至今日期刊订阅数")
    private Long subscriptionTotal;

    /**
     * 领域名字, cn_name:中文名
     */
    @ApiModelProperty("领域ID及中文名称")
    private AreaResponse areaResponse;

    /**
     * 期刊关联subject主题表
     */
    @ApiModelProperty("关联表主题subject名称及ID")
    private List<SubjectSimpleResponse> subjectSimpleResponses;


}
