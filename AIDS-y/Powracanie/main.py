#!/usr/bin/env python3

import Matrix
import Hamilton
import random

connections = []
number_of_elements_list = list(range(5, 16, 1))
saturation_list = [0.3, 0.5, 0.7]
number_of_repetitions = 3


def create_connections(oriented=False):
    global saturation_list
    global number_of_elements_list
    global connections
    temp_conn = []
    number_of_needed_connections = 0

    for number_of_elements in number_of_elements_list:
        for saturation in saturation_list:
            possible_connections = get_possible_connections(number_of_elements, oriented)
            if oriented:
                number_of_needed_connections = int(saturation * (number_of_elements * (number_of_elements-1)))
            else:
                number_of_needed_connections = int(saturation * (number_of_elements * (number_of_elements-1))/2)
            for i in range(number_of_needed_connections):
                conn_pos = random.randrange(0, len(possible_connections))
                temp_conn.append(possible_connections[conn_pos])
                possible_connections.remove(possible_connections[conn_pos])
            connections.append(temp_conn)
            temp_conn = []


def get_possible_connections(number_of_elements, oriented):
    connections = []
    if oriented:
        for i in range(number_of_elements):
            for j in range(number_of_elements):
                if i != j:
                    connections.append([i, j])
    else:
        for i in range(number_of_elements):
            for j in range(number_of_elements):
                if i != j and [j, i] not in connections:
                    connections.append([i, j])
    return connections


if __name__ == '__main__':
    create_connections(True)
    pass
    # matrix = Matrix.Matrix(number_of_elements, connections, oriented=True)
    # matrix.show()
    # print()
    # for v in range(number_of_elements):
    #     print(matrix.get_vertex_degree(v))
    # bfs = BroadFirstSearch.BroadFirstSearch(matrix)
    # print(bfs.search(2, 0))
    # hamilton = Hamilton.Hamilton(matrix, number_of_elements)
    # print(hamilton.search_for_first_cycle())
