package com.kienjd.post.mapper;

import com.kienjd.post.dto.response.PostResponse;
import com.kienjd.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toPostResponse(Post post);
}
