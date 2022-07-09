package shop.dodobird.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.dodobird.blog.domain.Posting;
import shop.dodobird.blog.domain.PostingRepository;
import shop.dodobird.blog.domain.PostingRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostingService {

    private final PostingRepository postingRepository;

    @Transactional
    public Long update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(("아이디가 존재하지 않습니다."))
        );

        if(posting.getPassword().equals(requestDto.getPassword())) {
            posting.update(requestDto);
            return posting.getId();
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return id;
        }
    }

}
