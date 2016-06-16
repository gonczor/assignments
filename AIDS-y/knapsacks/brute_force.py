class Items:
    def __init__(self, item):
        self.weight = item[0]
        self.price = item[1]


class BruteForce:
    def __init__(self, items, knapsack_size=10):
        self.items = [Items(item) for item in items]
        self._knapsack_size = knapsack_size

    def fill_knapsack(self):
        mask = 0
        max_price = 0
        max_weight = 0

        while mask < pow(2, len(self.items)):
            current_weight, current_price = self.get_current_weight_and_price(mask)
            if self.fits_knapsack(current_weight):
                if current_price > max_price:
                    max_price, max_weight = current_price, current_weight
            mask += 1

        return max_weight, max_price

    def get_current_weight_and_price(self, mask):
        price = 0
        weight = 0
        for i in self.items:
            if mask % 2 == 1:
                price += i.price
                weight += i.weight
            mask //= 2

        return weight, price

    def fits_knapsack(self, current_size):
        return current_size <= self._knapsack_size
