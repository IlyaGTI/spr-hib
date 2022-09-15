package com.example.app.repository;

import com.example.app.model.Position;

import java.util.List;

public interface PositionRepo {

    List<Position> allPositions();

    Position getById(Long id);

    void updatePosition(Position position);

    Position createPosition(Position position);

    void deletePosition(Position position);

}
