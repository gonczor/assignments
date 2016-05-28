import Matrix as Matrix
import BroadFirstSearch


class Hamilton:
    def __init__(self, connections_matrix, number_of_vertexes):
        self._connections_matrix = connections_matrix
        self._number_of_vertexes = number_of_vertexes
        self._checked_vertexes = []

    def search_for_first_cycle(self):
        # if not self._is_complete():
        #     return False
        # Zaczynamy w dowolnym miejscu skoro ma byc cykl
        # self._connections_matrix.mark_zero_as_checked()
        return self._search(0)

    def _is_complete(self):
        for i in range(1, self._number_of_vertexes):
            bfs = BroadFirstSearch.BroadFirstSearch(self._connections_matrix)
            if not bfs.search(0, i):
                return False

        return True

    def _search(self, vertex):
        cycle_found = False
        self._checked_vertexes.append(vertex)
        vertex_neighbours = self._connections_matrix.get_neighbours(vertex)

        if self._cycle_found(vertex_neighbours):
            return True

        vertex_neighbours = self._remove_already_checked_neighbours(vertex_neighbours)

        for neighbour in vertex_neighbours:
            cycle_found = self._search(neighbour)
            if cycle_found:
                return True
            else:
                self._connections_matrix.uncheck_neighbours(vertex)

        # Analizowany wierzchołek nie prowadzi do znalezienia cyklu. Mozna go zdjac ze stosu.
        self._checked_vertexes.pop()
        return cycle_found

    def _cycle_found(self, vertex_neighbours):
        return 0 in vertex_neighbours and len(self._checked_vertexes) == self._number_of_vertexes

    def _remove_already_checked_neighbours(self, neigbours):
        updated_neighbours = []
        for neighbour in neigbours:
            if neighbour not in self._checked_vertexes:
                updated_neighbours.append(neighbour)
        return updated_neighbours
