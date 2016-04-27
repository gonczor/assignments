import DataStructure.DataStructure as DataStructure
from colorama import init, Fore


class Node:
    def __init__(self):
        self.value = False
        self.checked = False


class Matrix(DataStructure.DataStructure):
    def __init__(self, number_of_elements, connections):
        super().__init__(number_of_elements, connections)
        self.matrix = [[Node() for i in range(self.__number_of_elements__)]
                       for j in range(self.__number_of_elements__)]
        for connection in self.__connections__:
            self.matrix[connection[0]][connection[1]].value = True
            self.matrix[connection[1]][connection[0]].value = True

    def create(self):
        pass

    def show(self):
        init(autoreset=True)
        for row in self.matrix:
            for cell in row:
                if cell.value:
                    print(Fore.GREEN + "{0}".format(cell.value), end="\t")
                else:
                    print(Fore.RED + "{0}".format(cell.value), end="\t")
            print()

    def get_neighbours_indexes_(self, item_index):
        neighbours = list()
        for index in range(len(self.matrix[item_index])):
            if (index != item_index and
                    self.matrix[item_index][index].value and
                    not self.matrix[item_index][index].checked):
                neighbours.append(index)
        return neighbours
