import Matrix as Matrix
import BroadFirstSearch


class Hamilton:
    def __init__(self, connections_matrix, number_of_connections):
        self._connections_matrix = connections_matrix
        self._number_of_connections = number_of_connections
        self._checked_vertexes = []

    def search_for_first_cycle(self):
        # if not self._is_complete():
        #     return False
        # Zaczynamy w dowolnym miejscu skoro ma byc cykl
        return self._search(0)

    def _is_complete(self):
        for i in range(1, self._number_of_connections):
            bfs = BroadFirstSearch.BroadFirstSearch(self._connections_matrix)
            if not bfs.search(0, i):
                return False

        return True

    def _search(self, vertex):
        to_return = False
        self._checked_vertexes.append(vertex)
        vertex_neighbours = self._connections_matrix.get_neighbours(vertex)

        if 0 in vertex_neighbours:
            to_return = True

        if to_return:
            return True
        
        for neighbour in vertex_neighbours:
            to_return = self._search(neighbour)
            self._connections_matrix.uncheck_neighbours(vertex)

        self._checked_vertexes.pop()
        return to_return
