package tasks_menagement.api_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import tasks_menagement.api_crud.controller.dto.TaskDTO;
import tasks_menagement.api_crud.controller.dto.UpdateTaskDto;
import tasks_menagement.api_crud.entity.TaskEntity;
import tasks_menagement.api_crud.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> getAllTasks() {

        return taskRepository.findAll();

    }

    public UUID createTask(TaskDTO taskDTO) {
        var entity = new TaskEntity(
                UUID.randomUUID(),
                taskDTO.title(),
                taskDTO.description(),
                taskDTO.status());

        var taskSaved = taskRepository.save(entity);

        return taskSaved.getId();
    }

    public void updateTaskById(String taskId, UpdateTaskDto updateTaskDto) {
        var id = UUID.fromString(taskId);
        var taskEntity = taskRepository.findById(id);

        if (taskEntity.isPresent()) {
            var task = taskEntity.get();

            if(updateTaskDto.title() != null) {
                task.setTitle(updateTaskDto.title());
            }

            if(updateTaskDto.description() != null) {
                task.setDescription(updateTaskDto.description());
            }

            if(updateTaskDto.status() != null) {
                task.setStatus(updateTaskDto.status());
            }

                taskRepository.save(task);
        }

    }

    public void deleteTask(String taskId) {
        var id = UUID.fromString(taskId);

        var userExists = taskRepository.existsById(id);

        if (userExists) {
            taskRepository.deleteById(id);
        }
    }
}
