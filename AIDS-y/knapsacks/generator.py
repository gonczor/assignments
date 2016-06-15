from random import randrange


def generator(size, max_weight=10, max_price=10):
    return [[randrange(1, max_weight), randrange(1, max_price)] for i in range(size)]
