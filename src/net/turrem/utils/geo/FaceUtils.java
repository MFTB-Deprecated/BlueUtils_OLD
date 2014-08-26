package net.turrem.utils.geo;

public class FaceUtils
{
	/**
	 * A list of vertex offsets to be used when converting faces to vertices
	 */
	public static final int[][] vertexOffset = new int[][] { new int[] { 1, 0, 1 }/* 0 */, new int[] { 0, 0, 1 }/* 1 */, new int[] { 0, 0, 0 }/* 2 */, new int[] { 1, 0, 0 }/* 3 */, new int[] { 1, 1, 1 }/* 4 */, new int[] { 0, 1, 1 }/* 5 */, new int[] { 0, 1, 0 }/* 6 */, new int[] { 1, 1, 0 } /* 7 */};
	
	/**
	 * A list specifing which vericies in offs belong to which faces on a cube
	 */
	public static final int[][] vertexOffsetIndices = new int[][] { new int[] { 4, 0, 3, 7 }/* XUp */, new int[] { 5, 6, 2, 1 }/* XDown */, new int[] { 4, 7, 6, 5 }/* YUp */, new int[] { 0, 1, 2, 3 }/* YDown */, new int[] { 4, 5, 1, 0 }/* ZUp */, new int[] { 7, 3, 2, 6 } /* ZDown */};

}
