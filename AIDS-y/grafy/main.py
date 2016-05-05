#!/usr/bin/env python3

from DataStructure import Line, Matrix
from Algorithm import BroadFirstSearch, DepthFirstSearch


class Analyze:
    def __init__(self):
        matrix = Matrix.Matrix(6, [[0, 3], [1, 3], [2, 3]])
        bfs = BroadFirstSearch.BroadFirstSearch(matrix)
        matrix.show()
        print(bfs.search(2))

if __name__ == '__main__':
    analyze = Analyze()
