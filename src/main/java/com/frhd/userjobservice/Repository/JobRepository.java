package com.frhd.userjobservice.Repository;

import com.frhd.userjobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Custom queries can be added here if needed
    Optional<Job> findByJobId(String jobId);
}
