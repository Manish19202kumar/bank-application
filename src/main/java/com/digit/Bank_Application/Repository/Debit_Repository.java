package com.digit.Bank_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Debit_Card;

public interface Debit_Repository extends JpaRepository<Debit_Card, Long>{

	Debit_Card findByCardno(Long cardno);
}
