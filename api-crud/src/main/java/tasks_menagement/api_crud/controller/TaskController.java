package tasks_menagement.api_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import tasks_menagement.api_crud.controller.dto.TaskDTO;
import tasks_menagement.api_crud.controller.dto.UpdateTaskDto;
import tasks_menagement.api_crud.entity.TaskEntity;
import tasks_menagement.api_crud.service.TaskService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getTask() {
        List<TaskEntity> task = taskService.getAllTasks();

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        var taskId = taskService.createTask(taskDTO);

        return ResponseEntity.created(URI.create(taskId.toString())).build();
    }

    @PutMapping(value = "/{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable("taskId") String taskId, @RequestBody UpdateTaskDto updateTaskDto) {
        taskService.updateTaskById(taskId, updateTaskDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") String taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
