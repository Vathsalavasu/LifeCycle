package Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Empdetails {

	@Id
	int empid;
	String name;
	long mobile;

}
