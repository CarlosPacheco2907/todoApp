package com.soto.todoapp.mappper;


import com.soto.todoapp.persitence.entity.Task;
import com.soto.todoapp.persitence.entity.TaskStatus;
import com.soto.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class TaskInDTOToTask implements  IMapper<TaskInDTO, Task>{



    @Override
    public Task map(TaskInDTO in) {
        Task task  = new Task();

        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());


        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
