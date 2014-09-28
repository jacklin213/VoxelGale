package tk.jacklin213.voxelgale.block;

public class Block {
	
	private boolean isActive;
	private BlockType type;
	
	public Block(BlockType type) {
		this.type = type;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public BlockType getType() {
		return type;
	}
}
