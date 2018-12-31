/**
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
**/


public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int total = 0;
    total += (C - A) * (D - B);
    total += (G - E) * (H - F);
    int overX1 = Math.max(A, E);
    int overY1 = Math.max(B, F);
    int overX2 = Math.min(C, G);
    int overY2 = Math.min(D, H);
    int overArea = (overX2 > overX1 && overY2 > overY1) ? (overX2 - overX1) * (overY2 - overY1) : 0;
    return total - overArea;
    }
}
