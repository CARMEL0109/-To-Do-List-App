package com.johnson.toDoList;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;





@Entity
public class TodoTask {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String title;
    private String description;
    
    @CreationTimestamp 
	private Date createdBy;
    
    @Enumerated(value = EnumType.STRING)
	private Status status;
    
    public TodoTask() {
    	
    }

    	public TodoTask(String title, String description, Date createdBy, Status status) {
    		this.title = title;
    		this.description = description;
    		this.createdBy = createdBy;
    		this.status = status;
    	}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(Date createdBy) {
			this.createdBy = createdBy;
		}


		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "TodoTask [id=" + id + ", title=" + title + ", description=" + description + ", createdBy="
					+ createdBy + ", status=" + status + "]";
		}

    	
}