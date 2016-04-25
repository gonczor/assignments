import DataStructure.DataStructure as DataStructure


class Matrix(DataStructure.DataStructure):
    def __init__(self, number_of_elements, connections):
        super().__init__(number_of_elements, connections)
        self.__matrix__ = [[False for i in range(self.__number_of_elements__)]
                           for j in range(self.__number_of_elements__)]
        for connection in self.__connections__:
            self.__matrix__[connection[0]][connection[1]] = True
            self.__matrix__[connection[1]][connection[0]] = True

    def create(self):
        pass

    def show(self):
        for row in self.__matrix__:
            for cell in row:
                print("{0}".format(cell), end="\t")
            print()
