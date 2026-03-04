package Repo;


import Domain.Position;

import java.util.List;

public interface PositionRepo {

    Position save(Position p);

    Position findByPositionCode(String code);

    List<Position> findAllByJobTitle(String title);

    void deleteByPositionCode(String code);
}