package com.example.__Transactional.entity;

import org.hibernate.internal.build.AllowNonPortable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllowNonPortable
@NoArgsConstructor

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String holderName;
	private String type;
	private double balance;
}
