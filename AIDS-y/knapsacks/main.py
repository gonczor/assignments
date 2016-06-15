#!/usr/bin/env python3
import time
from generator import generator
import greedy
import brute_force
import KP

if __name__ == '__main__':
    size_multiplier = 10
    max_multiplier = 10
    for size_base in range(1, 11):
        print('Data size: {0}'.format(size_base*size_multiplier))
        g = generator(size_base*size_multiplier, size_base*max_multiplier, size_base*max_multiplier)
        for attempt in range(3):
            # Max knapsack size is always 2 times bigger than biggest allowed element

            # KP
            kp = KP.Knapsack_problem(g, size_base*max_multiplier*2)
            start = time.clock()
            w, p = kp.kp_weight_value()
            stop = time.clock()
            f_kp = open('matrix', 'a')
            f_kp.write('Data size: {0}\tattempt: {1}\ttime:{2}\tweight:{3}\tvalue:{4}\n'.format(
                size_base*size_multiplier, attempt, stop-start, w, p
            ))
            f_kp.close()

            # BF
            bf = brute_force.BruteForce(g, size_base*max_multiplier*2)
            start = time.clock()
            p, w = bf.fill_knapsack()
            stop = time.clock()
            f_bf = open('brute force', 'a')
            f_bf.write('Data size: {0}\tattempt: {1}\ttime:{2}\tweight:{3}\tvalue:{4}\n'.format(
                size_base*size_multiplier, attempt, stop-start, w, p
            ))
            f_bf.close()

            # greedy
            gr = greedy.Greedy(g, size_base*max_multiplier*2)
            start = time.clock()
            p_gr, w_gr = gr.fill_knapsack()
            stop = time.clock()
            f_gr = open('greedy', 'a')
            f_gr.write('Data size: {0}\tattempt: {1}\ttime:{2}\tweight:{3}\tvalue:{4}\tgap:{5}\n'.format(
                size_base*size_multiplier, attempt, stop-start, w, p, 1-(p_gr/p)
            ))
            f_gr.close()
