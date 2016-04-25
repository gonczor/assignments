#!/usr/bin/env python3

from DataStructure import Line, Matrix
from Algorithm import BroadFirstSearch, DepthFirstSearch


class Analyze:
    def __init__(self):
        matrix = Matrix.Matrix(5, [[0, 1], [3, 4]])
        matrix.show()

if __name__ == '__main__':
    analyze = Analyze()
