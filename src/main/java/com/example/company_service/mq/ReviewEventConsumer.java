package com.example.company_service.mq;

import com.example.company_service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewEventConsumer {
    private final CompanyService companyService;

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewEvent reviewEvent) {
        log.info("Received Review Event: {}", reviewEvent);
        companyService.updateCompanyRating(reviewEvent);
    }
}
