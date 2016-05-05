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

    def search(self, element):
        if isinstance(self.__data__, Matrix.Matrix):
            return self.__search_in_matrix__(element)
        elif isinstance(self.__data__, Line.Line):
            return self.__search_in_line__(element)
        else:
            raise TypeError

    def __search_in_matrix__(self, element):
        while True:
            self.__add_neighbours_in_matrix__()
            if self.__queue_checked__():
                return False
            if self.__element_in_queue__(element):
                return True
            self.__queue_index__ += 1

    def __add_neighbours_in_matrix__(self):
        if not self.__queue__:
            self.__queue__ += self.__data__.get_neighbours(self.__queue_index__)
        else:
            self.__queue__ += self.__data__.get_neighbours(self.__queue__[self.__queue_index__-1])

    def __element_in_queue__(self, element):
        return self.__queue__[self.__queue_index__] == element

    def __queue_checked__(self):
        return self.__queue_index__ >= len(self.__queue__)

    def __search_in_line__(self, element):
        pass

    def __add_to_queue__(self, element):
        self.__queue__.append(element)

    def __take_from_queue__(self):
        tmp = self.__queue__[self.__queue_index__]
        self.__queue_index__ += 1
        return tmp
