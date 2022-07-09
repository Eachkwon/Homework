package shop.dodobird.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostingRequestDto {

    private final String title;
    private final String content;
    private final String username;
    private final String password;
}
