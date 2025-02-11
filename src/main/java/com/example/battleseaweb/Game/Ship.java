package com.example.battleseaweb.Game;


import java.io.Serializable;

public class Ship implements Serializable
{
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;

    private int size;

    private int ran;

    private int hits;

    public Ship(Coordinate start, Coordinate end, int size)
    {
        this.startCoordinate = start;
        this.endCoordinate = end;
        this.size = size;
        this.hits=0;

        ran = 0;
    }
    // Метод, который отмечает попадания по кораблю
    public void hit(Coordinate coord) {
        // Проверяем, попадает ли переданная координата в пределы корабля
        if (coord.getX() >= startCoordinate.getX() && coord.getX() <= endCoordinate.getX() &&
                coord.getY() >= startCoordinate.getY() && coord.getY() <= endCoordinate.getY()) {
            // Увеличиваем счетчик попаданий
            hits++;
        }
    }

    public boolean isDestroy()
    {
        ran++;
        if(ran == size)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.startCoordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return startCoordinate;
    }

    public void setEndCoordinate(Coordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }
}
