package Nemo;

public class East extends Orientation {

    @Override
    public Orientation turnLeft() {
        return new North();
    }

    @Override
    public Orientation turnRight() {
        return new South();
    }

    @Override
    public Orientation moveForward(Coordinates coordinates) {
        coordinates.moveEast();
		return null;
    }

}
