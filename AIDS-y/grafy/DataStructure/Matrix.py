import DataStructure.DataStructure as DataStructure
from colorama import init, Fore


class Node:
    def __init__(self):
        self.value = False
        self.checked = False


class Matrix(DataStructure.DataStructure):
    def __init__(self, number_of_elements, connections):
        super().__init__(number_of_elements, connections)
        self.__matrix__ = [[Node() for i in range(self.__number_of_elements__)]
                           for j in range(self.__number_of_elements__)]
        for connection in self.__connections__:
            self.__matrix__[connection[0]][connection[1]].value = True
            self.__matrix__[connection[1]][connection[0]].value = True

    def create(self):
        pass

    def show(self):
        init(autoreset=True)
        for row in self.__matrix__:
            for cell in row:
                if cell.value:
                    print(Fore.GREEN + "{0}".format(cell.value), end="\t")
                else:
                    print(Fore.RED + "{0}".format(cell.value), end="\t")
            print()
