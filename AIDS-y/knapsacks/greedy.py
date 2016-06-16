class Items:
    def __init__(self, item):
        self.weight = item[0]
        self.price = item[1]
        self.density = self.price / self.weight


class Greedy:
    def __init__(self, items, knapsack_size=10):
        self.items = [Items(item) for item in items]
        self._knapsack_size = knapsack_size

    def fill_knapsack(self):
        self._sort_items()
        knapsack_price = 0
        knapsack_weight = 0
        for item in self.items:
            if knapsack_weight+item.weight <= self._knapsack_size:
                knapsack_price += item.price
                knapsack_weight += item.weight
        return knapsack_weight, knapsack_price

    def _sort_items(self):
        self.items.sort(key=lambda x: x.density, reverse=True)

