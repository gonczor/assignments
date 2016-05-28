#!/usr/bin/env python3

import Matrix, BroadFirstSearch, Hamilton

connections = [[1, 2], [0, 1], [2, 1], [2, 0]]
number_of_elements = 3

if __name__ == '__main__':
    matrix = Matrix.Matrix(number_of_elements, connections, oriented=True)
    # matrix.show()
    # print()
    # for v in range(number_of_elements):
    #     print(matrix.get_vertex_degree(v))
    # bfs = BroadFirstSearch.BroadFirstSearch(matrix)
    # print(bfs.search(2, 0))
    hamilton = Hamilton.Hamilton(matrix, number_of_elements)
    print(hamilton.search_for_first_cycle())
