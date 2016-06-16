class Knapsack_problem():
    def __init__(self,list,max_weight):
        self.list=list
        self.max_weight=max_weight
        self.matrix=[]
        self.size=len(self.list)
        self.items=[]

    def create_matrix(self):
        for i in range(0,self.max_weight+1):
            self.matrix.append([0])
        for i in range(0,self.size):
            for k in range(0,self.max_weight+1):
                self.matrix[k].append(0)
    def take_value(self,i):
        weight = self.list[i-1][0]
        value = self.list[i-1][1]
        return [weight,value]

# matrix [waga][kolejna paczka]
    def insert(self):                                               # tworzy macierz do KP
        param=[0,0]
        for i in range(1,self.size+1):
            param = self.take_value(i)
            value = param[1]
            weight = param[0]
            for k in range(1,self.max_weight+1):
                if weight > k:
                    try:
                        self.matrix[k][i] = self.matrix[k][i-1]
                    except:
                        self.matrix[k][i]=0
                else:
                    if (value + self.matrix[k - weight][i-1])>self.matrix[k][i-1]:
                        self.matrix[k][i] = value + self.matrix[k - weight][i-1]
                    else:
                        self.matrix[k][i]=self.matrix[k][i-1]
    def get_items(self):
        self.remove(self.max_weight,self.size)                  # zwraca liste elementow ktore weszly do plecaka [waga,cena]
        return self.items

    def remove(self,k,i):
        if self.matrix[k][i]==0:
            return
        if self.matrix[k][i] != self.matrix[k][i-1]:
            self.items.append(self.list[i-1])
            k = k - self.list[i-1][0]
        i = i -1
        self.remove(k,i)

    def kp_weight_value(self):
        result_value = 0
        result_weight = 0
        self.create_matrix()
        self.insert()
        self.get_items()
        for i in range(0,len(self.items)):
            result_weight += self.items[i][0]
            result_value += self.items[i][1]
        return int(result_weight), int(result_value)


items_list = [[10, 10], [6, 8], [4, 5], [4, 5], [4, 4]]
matrix = Knapsack_problem(items_list, 12)
print(matrix.kp_weight_value())
# print(matrix.kp_value_weight())
# print(matrix.matrix)
# print(matrix.items)