#!/usr/bin/env python3
import time
from generator import generator
import greedy
import brute_force
import KP

if __name__ == '__main__':
    size_multiplier = 5
    max_multiplier = 5
    f_kp = open('matrix', 'w')
    f_kp.close()
    f_bf = open('brute force', 'w')
    f_bf.close()
    f_gr = open('greedy', 'w')
    f_gr.close()
    for size_base in range(1, 16):
        print('Data size: {0}'.format(size_base*size_multiplier))
        g = generator(size_base*size_multiplier, size_base*max_multiplier, size_base*max_multiplier)
        for knapsack_size in [10, 20, 30]:
            for attempt in range(3):
                # KP
                kp = KP.Knapsack_problem(g, knapsack_size)
                start = time.clock()
                w, p = kp.kp_weight_value()
                stop = time.clock()
                f_kp = open('matrix', 'a')
                f_kp.write('Data size: {0}\tsize: {5}\tattempt: {1}\ttime: {2}\tweight: {3}\tvalue: {4}\n'.format(
                    size_base*size_multiplier, attempt, stop-start, w, p, knapsack_size
                ))
                f_kp.close()

                # BF
                if size_base*size_multiplier <= 20:
                    bf = brute_force.BruteForce(g, knapsack_size)
                    start = time.clock()
                    p, w = bf.fill_knapsack()
                    stop = time.clock()
                    f_bf = open('brute force', 'a')
                    f_bf.write('Data size: {0}\tsize: {5}\tattempt: {1}\ttime: {2}\tweight: {3}\tvalue: {4}\n'.format(
                        size_base*size_multiplier, attempt, stop-start, w, p, knapsack_size
                    ))
                    f_bf.close()

                # greedy
                gr = greedy.Greedy(g, knapsack_size)
                start = time.clock()
                p_gr, w_gr = gr.fill_knapsack()
                stop = time.clock()
                f_gr = open('greedy', 'a')
                f_gr.write('Data size: {0}\tsize: {6} attempt: {1}\ttime: {2}\tweight: {3}\tvalue: {4}\tgap: {5}\n'
                           .format(
                            size_base*size_multiplier, attempt, stop-start, w_gr, p_gr, 1-(p_gr/p), knapsack_size
                            ))
                f_gr.close()
