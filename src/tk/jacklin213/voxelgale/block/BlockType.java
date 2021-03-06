/* This file is part of VoxelGale
 * 
 * Copyright (c) 2014 jacklin213
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
