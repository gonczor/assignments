#!/usr/bin/env python3

from generator import generator
from greedy import Items, Greedy
import brute_force

generated_list_size = 20


def test_generator_within_range():
    assert len(generator(0)) == 0
    assert len(generator(generated_list_size)) == generated_list_size


def test_generator_price_within_limits():
    # default_limits
    gen = generator(generated_list_size)
    for g in gen:
        assert 1 <= g[1] <= 15
    # arbitrary limits
    high = 20
    gen = generator(generated_list_size, max_price=high)
    for g in gen:
        assert 1 <= g[1] <= 20


def test_generator_weight_within_limits():
    # default_limits
    gen = generator(generated_list_size)
    for g in gen:
        assert 1 <= g[0] <= 15
    # arbitrary limits
    high = 20
    gen = generator(generated_list_size, max_weight=high)
    for g in gen:
        assert 1 <= g[0] <= 20


def test_density():
    item = Items([2, 1])
    assert 0.499 <= item.density <= 0.501
    item = Items([1, 1])
    assert item.density == 1


def test_greedy_sorts_correctly():
    unsorted_items = generator(generated_list_size)
    greedy = Greedy(unsorted_items)
    greedy._sort_items()
    items_density_list = [greedy.items[i].density for i in range(len(greedy.items))]
    # assert that always next is greater o equal to the previous
    for i in range(1, len(items_density_list)):
        assert items_density_list[i-1] <= items_density_list[i]


def test_knapsack_filling():
    items_list = [[2, 1], [2, 1], [6, 1]]
    # test if size od items in the knapsack are not greater than knapsack size
    greedy = Greedy(items=items_list, knapsack_size=5)
    p, w = greedy.fill_knapsack()
    assert w <= 5
    # assert price is optimal
    assert p == 2
    items_list = [[2, 1], [2, 1], [6, 6]]
    # test if size od items in the knapsack are not greater than knapsack size
    greedy = Greedy(items=items_list, knapsack_size=6)
    p, w = greedy.fill_knapsack()
    assert w <= 6
    # assert price is optimal
    assert p == 3


def test_brute_force_filling():
    items_list = [[10, 10], [6, 8], [4, 5], [4, 5], [4, 4]]
    bf = brute_force.BruteForce(items_list, knapsack_size=12)
    print(bf.fill_knapsack())


if __name__ == '__main__':
    test_generator_price_within_limits()
    test_generator_weight_within_limits()
    test_generator_within_range()
    test_density()
    test_greedy_sorts_correctly()
    test_brute_force_filling()
