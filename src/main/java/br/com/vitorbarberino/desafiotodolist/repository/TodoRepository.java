package br.com.vitorbarberino.desafiotodolist.repository;

import br.com.vitorbarberino.desafiotodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
