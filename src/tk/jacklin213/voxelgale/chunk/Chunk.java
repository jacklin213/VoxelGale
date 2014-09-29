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
package tk.jacklin213.voxelgale.chunk;

import tk.jacklin213.voxelgale.block.Block;
import tk.jacklin213.voxelgale.block.BlockType;

public class Chunk {

	static final int CHUNK_SIZE = 16;
	private Block[][][] blocks;
	
	public Chunk() {
		blocks = new Block[CHUNK_SIZE][CHUNK_SIZE][CHUNK_SIZE];
		for (int x = 0; x < CHUNK_SIZE; x++) {
			for (int y = 0; y < CHUNK_SIZE; y++) {
				for (int z = 0; z < CHUNK_SIZE; z++) {
					blocks[x][y][z] = new Block(BlockType.DIRT);
				}
			}
		}
	}
	
	public void render() {
		
	}
	
	public void update() {
		
	}
}
