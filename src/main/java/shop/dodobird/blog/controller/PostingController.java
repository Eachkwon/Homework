package shop.dodobird.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.dodobird.blog.domain.Posting;
import shop.dodobird.blog.domain.PostingRepository;
import shop.dodobird.blog.domain.PostingRequestDto;
import shop.dodobird.blog.service.PostingService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostingController {

    private final PostingRepository postingRepository;

    private final PostingService postingService;

    @PostMapping("/api/postings")
    public Posting createPosting(@RequestBody PostingRequestDto requestDto){
        Posting posting = new Posting(requestDto);
        return postingRepository.save(posting);
    }

    @GetMapping("/api/postings")
    public List<Posting> getPostings() { return postingRepository.findAllByOrderByCreatedAtDesc(); }

    @GetMapping("/api/postings/{id}")
    public Optional<Posting> getPosting(@PathVariable Long id) {
        return postingRepository.findById(id);
    }

        @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        Optional<Posting> posting = postingRepository.findById(id);
        if (posting.get().getPassword().equals(requestDto.getPassword())) {
            postingRepository.deleteById(id);
            return id;
        }
        System.out.println("비밀번호가 일치하지 않습니다.");
        return id;
    }

    @PutMapping("/api/postings/{id}")
    public Long updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        postingService.update(id, requestDto);
        return id;
    }

    



}
