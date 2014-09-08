package net.turrem.utils.geo;

public class VoxelGeoUtils
{
	/**
	 * A list of vertex offsets to be used when converting faces to vertices
	 */
	public static final int[][] vertexOffset = new int[][] { new int[] { 1, 0, 1 }/* 0 */, new int[] { 0, 0, 1 }/* 1 */, new int[] { 0, 0, 0 }/* 2 */, new int[] { 1, 0, 0 }/* 3 */, new int[] { 1, 1, 1 }/* 4 */, new int[] { 0, 1, 1 }/* 5 */, new int[] { 0, 1, 0 }/* 6 */, new int[] { 1, 1, 0 } /* 7 */};
	
	public static final int[][] vertexOffsetSign;
	
	/**
	 * A list specifing which vericies in offs belong to which faces on a cube
	 */
	public static final int[][] vertexOffsetIndices = new int[][] { new int[] { 4, 0, 3, 7 }/* XUp */, new int[] { 5, 6, 2, 1 }/* XDown */, new int[] { 4, 7, 6, 5 }/* YUp */, new int[] { 0, 1, 2, 3 }/* YDown */, new int[] { 4, 5, 1, 0 }/* ZUp */, new int[] { 7, 3, 2, 6 } /* ZDown */};
	
	public static float vertexOcclude(boolean edge1, boolean edge2, boolean corner)
	{
		if (edge1 && edge2)
		{
			return 0.0F;
		}
		return ((edge1 ? 0.0F : 1.0F) + (edge2 ? 0.0F : 1.0F) + (corner ? 0.0F : 1.0F)) / 3.0F;
	}
	
	public static int[][] getOccludingVoxels(EnumDir face, int vertex)
	{
		int[][] occs = new int[3][3];
		int facedir = -1;
		int facesign = 0;
		if (face.xoff != 0)
		{
			facesign = face.xoff;
			facedir = 0;
		}
		else if (face.yoff != 0)
		{
			facesign = face.yoff;
			facedir = 1;
		}
		else if (face.zoff != 0)
		{
			facesign = face.zoff;
			facedir = 2;
		}
		occs[0][facedir] = facesign;
		occs[1][facedir] = facesign;
		occs[2][facedir] = facesign;
		facedir = (facedir + 1) % 3;
		occs[0][facedir] = vertexOffsetSign[vertexOffsetIndices[face.ind][vertex]][facedir];
		occs[2][facedir] = vertexOffsetSign[vertexOffsetIndices[face.ind][vertex]][facedir];
		facedir = (facedir + 1) % 3;
		occs[1][facedir] = vertexOffsetSign[vertexOffsetIndices[face.ind][vertex]][facedir];
		occs[2][facedir] = vertexOffsetSign[vertexOffsetIndices[face.ind][vertex]][facedir];
		return occs; 
	}
	
	static
	{
		int[][] sign = new int[vertexOffset.length][];
		for (int i = 0; i < sign.length; i++)
		{
			sign[i] = vertexOffset[i];
			for (int j = 0; j < sign[i].length; j++)
			{
				sign[i][j] = sign[i][j] * 2 - 1;
			}
		}
		vertexOffsetSign = sign;
	}
}
