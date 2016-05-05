#!/usr/bin/env python3

from DataStructure import Line, Matrix
from Algorithm import BroadFirstSearch, DepthFirstSearch


class Analyzer:
    def __init__(self):
        self.connections = []
        self.graph_size = 0
        self.size_multiplier = 6
        # matrix = Matrix.Matrix(6, [[0, 3], [1, 3], [2, 3]])
        # bfs = BroadFirstSearch.BroadFirstSearch(matrix)
        # matrix.show()
        # print(bfs.search(2))

    def create_graph(self):
        self.graph_size += 1
        self.create_connection_list()

    def create_connection_list(self):
        self.connections = [[0, 3], [1, 3], [2, 3]]

    def analyze(self):
        self.create_graph()
        matrix = Matrix.Matrix(self.graph_size * self.size_multiplier,
                               self.connections)
        bfs = BroadFirstSearch.BroadFirstSearch(matrix)
        matrix.show()
        print(bfs.search(2))

    def save_to_file(self):
        pass


if __name__ == '__main__':
    analyzer = Analyzer()
    for i in range(1):
        analyzer.analyze()
