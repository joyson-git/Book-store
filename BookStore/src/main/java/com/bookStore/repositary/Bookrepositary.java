package com.bookStore.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Book;
@Repository
public interface Bookrepositary  extends JpaRepository<Book, Long>{

}
