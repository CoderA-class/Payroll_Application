package Repo;

import Domain.JobTitle;

import java.util.List;

public interface JobRepo {

    JobTitle save(JobTitle j);

    JobTitle findByTitle(String title);

    List<JobTitle> findAll();

    void deleteByTitle(String title);
}
