package br.com.poketeams.model.service;

import br.com.poketeams.model.entity.Move;

import java.util.List;

public interface MoveService {

    Move create(Move move);

    List<Move> findAll();
}
