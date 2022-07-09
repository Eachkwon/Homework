package shop.dodobird.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dodobird.blog.domain.Timestamped;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@RequiredArgsConstructor
@RestController
public class VisitingController {

    private static long visitCount = 0;
//    Instant visit = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toInstant();
//    Instant today = ZonedDateTime.now().toInstant();

    @GetMapping("/api/visits")
    public void visit(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
    }

//    오늘 조회수 만들다가 말았음
//    @GetMapping("/api/todayvisits")
//    public String todayVisit(Model model) {
//        if (model.getAttribute(visit).equals(today)) {
//            model.getAttribute("visit",visitCount)
//        };
//    }


}
