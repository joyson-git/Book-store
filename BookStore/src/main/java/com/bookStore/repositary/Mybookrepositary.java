package com.bookStore.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.MyBookList;

@Repository
public interface Mybookrepositary extends JpaRepository<MyBookList, Integer> {
    // Custom query methods can be added here if needed
}
