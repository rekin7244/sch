package com.kh.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="user_seq_gen")
	@SequenceGenerator(
			name="user_seq_gen",
			sequenceName="user_seq",
			initialValue=1,
			allocationSize=1)
	@Column(name="id")
	@ApiModelProperty(hidden = true)
	private long id;
	@ApiModelProperty(value = "User Id", example = "user")
	@Column(name="userId")
	private String userId;
	@ApiModelProperty(value = "User Password", example = "password")
	@Column(name="password")
	private String password;

}
