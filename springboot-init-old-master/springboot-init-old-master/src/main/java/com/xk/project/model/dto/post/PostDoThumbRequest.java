package com.xk.project.model.dto.post;

import lombok.Data;

import java.io.Serializable;

/**

 */
@Data
public class PostDoThumbRequest implements Serializable {

    /**
     * 帖子 id
     */
    private long postId;

    private static final long serialVersionUID = 1L;
}