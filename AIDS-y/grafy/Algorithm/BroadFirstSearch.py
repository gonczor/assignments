import Algorithm.Algorithm as Algorithm
from DataStructure import Matrix, Line


class BroadFirstSearch(Algorithm.Algorithm):
    def __init__(self, data):
        super().__init__()
        self.__queue__ = list()
        self.__queue_index__ = 0
        self.__data__ = data

    def represent(self):
        pass

    def search_element(self, element):
        if isinstance(self.__data__, Matrix.Matrix):
            return self.__search_in_matrix__(element)
        elif isinstance(self.__data__, Line.Line):
            return self.__search_in_line__(element)
        else:
            raise TypeError

    def __search_in_matrix__(self, element):
        while True:
            self.__add_neighbours_in_matrix__()
            if self.__queue__[self.__queue_index__] == element:
                return True
            self.__queue_index__ += 1
            if self.__queue_index__ >= len(self.__queue__):
                return False

    def __add_neighbours_in_matrix__(self):
        self.__queue__ += self.__data__.get_neighbours_indexes_(self.__queue_index__)

    def __search_in_line__(self, element):
        pass

    def __add_to_queue__(self, element):
        self.__queue__.append(element)

    def __take_from_queue__(self):
        tmp = self.__queue__[self.__queue_index__]
        self.__queue_index__ += 1
        return tmp
