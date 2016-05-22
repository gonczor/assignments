#!/usr/bin/env python3

import Matrix, BroadFirstSearch

connections = [[1, 2], [0, 1]]
number_of_elements = 4

if __name__ == '__main__':
    matrix = Matrix.Matrix(number_of_elements, connections, oriented=True)
    # matrix.show()
    bfs = BroadFirstSearch.BroadFirstSearch(matrix)
    print(bfs.search(2, 0))
