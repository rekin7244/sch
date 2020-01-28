package com.kh.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="todo")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDo {
	
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="todo_seq_gen")
	@SequenceGenerator(
			name="todo_seq_gen",
			sequenceName="todo_seq",
			initialValue=1,
			allocationSize=1)
	@Column(name="id")
	private long id;
	@Column(name="title")
	private String title;
	@Column(name="done")
	private String done;
//	@Column(name="author")
//	private String author;
	
}
