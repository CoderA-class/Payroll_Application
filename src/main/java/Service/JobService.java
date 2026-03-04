package Service;


import Domain.JobTitle;
import Repo.JobRepo;

public class JobService {

    private final JobRepo jobRepository;

    public JobService(JobRepo jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobTitle createJob(JobTitle j) {
        if (j == null) throw new IllegalArgumentException("Job cannot be null");
        return jobRepository.save(j);
    }

    public JobTitle updateJob(JobTitle j) {
        if (j == null) throw new IllegalArgumentException("Job cannot be null");
        JobTitle existing = jobRepository.findByTitle(j.getTitle());
        if (existing == null) throw new RuntimeException("Job not found: " + j.getTitle());
        return jobRepository.save(j);
    }

    public JobTitle findJobByTitle(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Job title cannot be blank");
        return jobRepository.findByTitle(title);
    }
}