package Nemo;

public class South extends Orientation {

	@Override
    public Orientation turnLeft() {
        return new East();
    }

    @Override
    public Orientation turnRight() {
        return new West();
    }

    @Override
    public Orientation moveForward(Coordinates coordinates) {
        coordinates.moveSouth();
		return null;
    }

}
