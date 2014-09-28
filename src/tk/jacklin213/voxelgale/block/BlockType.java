package tk.jacklin213.voxelgale.block;

public enum BlockType {
	AIR(0),
	STONE(1),
	GRASS(2),
	DIRT(3),
	WATER(4),
	WOOD(5),
	SAND(6)
	;
	
	private int id;
	
	private BlockType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
