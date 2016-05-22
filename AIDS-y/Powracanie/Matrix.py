from colorama import init, Fore


class Node:
    def __init__(self):
        self.value = False
        self.checked = False


class Matrix:
    def __init__(self, number_of_elements, connections, oriented):
        self.__number_of_elements__ = number_of_elements
        self.__connections__ = connections
        self.matrix = [[Node() for i in range(self.__number_of_elements__)]
                       for j in range(self.__number_of_elements__)]
        if oriented:
            for connection in self.__connections__:
                self.matrix[connection[0]][connection[1]].value = True
        else:
            for connection in self.__connections__:
                self.matrix[connection[0]][connection[1]].value = True
                self.matrix[connection[1]][connection[0]].value = True

    def show(self):
        init(autoreset=True)
        for row in self.matrix:
            for cell in row:
                if cell.value:
                    print(Fore.GREEN + "{0}".format(cell.value), end="\t")
                else:
                    print(Fore.RED + "{0}".format(cell.value), end="\t")
            print()

    def get_neighbours(self, item_index):
        neighbours = list()
        for index in range(len(self.matrix[item_index])):
            if (index != item_index and
                    self.matrix[item_index][index].value and
                    not self.matrix[item_index][index].checked):
                neighbours.append(index)
                self.__mark_as_checked__(index, item_index)
        return neighbours

    def __mark_as_checked__(self, pos1, pos2):
        self.matrix[pos1][pos2].checked = True
        self.matrix[pos2][pos1].checked = True
