from colorama import init, Fore


class Node:
    def __init__(self):
        self.value = False
        self.checked = False


class Matrix:
    def __init__(self, number_of_elements, connections, oriented):
        self.__number_of_elements__ = number_of_elements
        self.__connections__ = connections
        self.__oriented__ = oriented
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
            # zakładam brak pętli własnej, wiec pomijam sprawdzanie
            # index != item_index
            if self.matrix[item_index][index].value and not self.matrix[item_index][index].checked:
                neighbours.append(index)
                self.__mark_as_checked__(index, item_index)
        return neighbours

    def uncheck_neighbours(self, index):
        for i in range(len(self.matrix[index])):
            if self.matrix[index][i].value:
                if self.__oriented__:
                    self.matrix[index][i].checked = False
                else:
                    self.matrix[index][i].checked = False
                    self.matrix[i][index].checked = False

    def get_vertex_degree(self, vertex_index):
        degree = 0
        for index in range(len(self.matrix[vertex_index])):
            if self.matrix[vertex_index][index].value:  # zakładam brak pętli własnej, wiec pomijam sprawdzanie
                                                        # vertex != vertex_index
                degree += 1
        return degree

    def __mark_as_checked__(self, pos1, pos2):
        if self.__oriented__:
            self.matrix[pos1][pos2].checked = True
        else:
            self.matrix[pos1][pos2].checked = True
            self.matrix[pos2][pos1].checked = True
