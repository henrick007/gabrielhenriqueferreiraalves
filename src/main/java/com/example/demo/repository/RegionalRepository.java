/*
    ARQUIVO REGIONALREPOSITORY.JAVA: AQUI É ONDE IRA FAZER A PONTE DO JAVA/SPRING BOOT COM O MYSQLQ WORKBENCH.
*/

package com.example.demo.repository;

import com.example.demo.model.Regional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionalRepository extends JpaRepository<Regional, Integer> {

    Optional<Regional> findByIdAndAtivoTrue(Integer id);
}
