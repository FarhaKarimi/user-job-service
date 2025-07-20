package com.frhd.userjobservice.controller;

import com.frhd.userjobservice.Repository.JobRepository;
import com.frhd.userjobservice.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job savedJob = jobRepository.save(job);
        return ResponseEntity.ok(savedJob);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJob(@PathVariable String jobId) {
        return jobRepository.findByJobId(jobId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{jobId}/view/{userId}")
    public ResponseEntity<String> recordJobView(@PathVariable String jobId, @PathVariable String userId) {
        // تولید رویداد مشاهده
        String event = String.format("{\"userId\": \"%s\", \"jobId\": \"%s\", \"action\": \"view\"}", userId, jobId);
        // ارسال رویداد به Event-Tracker Service
        String eventTrackerUrl = "http://localhost:8082/api/events";
        restTemplate.postForEntity(eventTrackerUrl, event, String.class);
        return ResponseEntity.ok("View recorded");
    }
}