package Nemo;

public class CannotLiberateCapsule extends DepthState {
	int z = -2;
	
	public DepthState launchCapsule() {
		throw new RuntimeException("No se puede lanzar la cápsula por debajo del primer nivel de inmersión");
	}

	@Override
	public DepthState moveUp() {
		z += 1;
		return null;
	}

	@Override
	public DepthState moveDown() {
		z -=1;
		return this;
	}

    private final DepthState previousState;

    public CannotLiberateCapsule(DepthState previousDoes) {
        this.previousState = previousDoes;
    }

    public DepthState previousState() {
        return previousState;
    }

}
