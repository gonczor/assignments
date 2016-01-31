from PIL import Image


class Wells:
    def __init__(self, radius):
        self.__radius__ = radius
        self.__horizontal_position__ = 0
        self.__vertical_position__ = 0

    def set_position(self, horizontal, vertical):
        self.__horizontal_position__ = horizontal
        self.__vertical_position__ = vertical

    def get_position(self):
        return str("{0} {1}".format(self.__horizontal_position__, self.__vertical_position__))

    def get_radius(self):
        return self.__radius__


class WellsPositioning:
    def __init__(self, wells, water_quality):
        self.__wells__ = wells
        self.__water_quality__ = water_quality

    def position(self):
        for well in wells:
            self.__search_best_position__(well)

    def __search_best_position__(self, well):
        for row in range(well.get_radius(), len(self.__water_quality__) - well.get_radius()):
            for col in range(well.get_radius(), len(self.__water_quality__[row]) - well.get_radius()):
                if self.__water_quality_is_sufficient__(row, col, well):
                    well.set_position(col, row)
                    return

    def __water_quality_is_sufficient__(self, row, col, well):
        return self.__count_water_quality__(row, col, well) > 20

    def __count_water_quality__(self, row, col, well):
        # TODO To be implemented actually
        return self.__water_quality__[row][col]


def get_settings2():
    n = int(raw_input())
    temp = raw_input()
    r = []
    for i in temp.split():
        r.append(int(i))
    temp = raw_input().split()
    width, height = int(temp[0]), int(temp[1])
    water_quality = []
    for i in range(height):
        row = []
        for j in raw_input().split():
            row.append(int(j))
        water_quality.append(row)
    return r, water_quality


def get_settings():
    r = []
    n = input()
    for i in range(n):
        r.append(input())
    return r, get_water_quality()


def get_water_quality():
    """This function is used temporarily reading data from image and not standard input"""
    im = Image.open("111.png")
    (size, width) = im.size
    im = im.convert("RGB")
    water_quality = [[0 for i in range(width)] for j in range(size)]
    for row in range(size):
        for col in range(width):
            r, g, b = im.getpixel((row, col))
            water_quality[row][col] = g
    return water_quality


def create_wells(r):
    w = []
    for i in r:
        w.append(Wells(i))
    return w


def show_result(wells):
    for well in wells:
        print(well.get_position())
    pass


if __name__ == '__main__':
    radius, water_quality = get_settings()
    wells = create_wells(radius)
    positioning = WellsPositioning(wells, water_quality)
    positioning.position()
    show_result(wells)
