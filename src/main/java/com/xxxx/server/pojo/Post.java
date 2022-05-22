package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 话题表
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_post")
@ApiModel(value="Post对象", description="话题表")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "markdown内容")
    private String content;

    @ApiModelProperty(value = "作者ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "评论统计")
    private Integer comments;

    @ApiModelProperty(value = "收藏统计")
    private Integer collects;

    @ApiModelProperty(value = "浏览统计")
    private Integer view;

    @ApiModelProperty(value = "是否置顶，1-是，0-否")
    private Boolean top;

    @ApiModelProperty(value = "是否加精，1-是，0-否")
    private Boolean essence;

    @ApiModelProperty(value = "专栏ID")
    @TableField("section_id")
    private Integer sectionId;

    @ApiModelProperty(value = "发布时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private LocalDateTime modifyTime;


}
