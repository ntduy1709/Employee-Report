package com.ifi.employeereportbe.repository;

import com.ifi.employeereportbe.entity.Version;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends MongoRepository<Version,String> {
}
