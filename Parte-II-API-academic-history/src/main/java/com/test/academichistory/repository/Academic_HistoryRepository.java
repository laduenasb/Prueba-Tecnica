package com.test.academichistory.repository;

import com.test.academichistory.model.Academic_History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Academic_HistoryRepository extends JpaRepository<Academic_History, Long> {
}
