class BroadFirstSearch:
    def __init__(self, data):
        self.__queue__ = list()
        self.__queue_index__ = 0
        self.__data__ = data

    def represent(self):
        pass

    def search(self, begin, searched):
        self.__add_first_neighbours__(begin)
        while True:
            if self.__queue_checked__():
                return False
            if self.__element_in_queue__(searched):
                return True
            self.__queue_index__ += 1
            self.__add_neighbours_in_matrix__()

    def __add_first_neighbours__(self, begin):
        self.__queue__ += self.__data__.get_neighbours(begin)

    def __add_neighbours_in_matrix__(self):
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
