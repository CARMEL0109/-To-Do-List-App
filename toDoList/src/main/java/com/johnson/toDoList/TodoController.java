package com.johnson.toDoList;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
	
	@Autowired
	private TodoTaskRepository todoTaskRepository; 
	
	
	
	@GetMapping(value="/")
	public String index(TodoTask todoTask, Model model) {
		model.addAttribute("tasks", todoTaskRepository.findAll());
		return "todolist/index";
	}
	
	@GetMapping(value = "/todolist/new")
	public String newTask(TodoTask todoTask) {
		return "todolist/new";
	}
	
	
	// post new task to database
		@PostMapping("todolist/new")
		public String submitTodoTask(TodoTask todoTask, Model model) {
			model.addAttribute("id", todoTask.getId());
			model.addAttribute("title", todoTask.getTitle());
			model.addAttribute("description", todoTask.getDescription());
			model.addAttribute("createdBy", todoTask.getCreatedBy());
			model.addAttribute("status", todoTask.getStatus());
			
			todoTaskRepository.save(todoTask);
			model.addAttribute("todoTasks", todoTaskRepository.findAll());
			return "todolist/result";
		}
	
//		to delete a task using id
		
		@GetMapping(value = "/todolist/result")
		public String deleteTask(TodoTask todoTask) {
			return "todolist/result";
		}
	@RequestMapping(value = "/todolist/result/{id}", method = RequestMethod.DELETE)
    public String deleteTaskWithId(@PathVariable Long id, TodoTask todoTask) {

        todoTaskRepository.deleteById(id);
        return "todolist/result";

    }
	
	
}