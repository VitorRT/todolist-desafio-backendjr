package br.com.vitorbarberino.desafiotodolist.service;

import br.com.vitorbarberino.desafiotodolist.entity.Todo;
import br.com.vitorbarberino.desafiotodolist.repository.TodoRepository;
import br.com.vitorbarberino.desafiotodolist.request.TodoRequest;
import br.com.vitorbarberino.desafiotodolist.response.TodoResponse;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }
    public List<TodoResponse> create(TodoRequest todoRequest) {
        todoRepository.save(new Todo(todoRequest));
        return list();
        
    }

    public List<TodoResponse> list() {
       Sort sort =  Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
       );
       return todoRepository.findAll(sort).stream().map(this::toTodoResponse).toList();
    }

    public List<TodoResponse> update(TodoRequest todoRequest, UUID id) {
        Todo todo =  getTodo(id);
        todo.setId(id);
        todoRepository.save(todo);
        return list();
    }

    public List<TodoResponse> delete(UUID id) {
        Todo todo = getTodo(id);
        todoRepository.delete(todo);
        return list();
    }

    private TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(todo);
    }

    private Todo getTodo(UUID id) {
        return todoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Nenhum existe nenhuma tarefa com o id informado.")
        );
    }
}
